package com.baidu.tieba;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.bq;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.bg;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GuideActivity extends j {

    /* renamed from: a  reason: collision with root package name */
    public static String f998a = "from_logo_page";
    public static String b = "from_about_page";
    private static String m = "from_page";
    private ArrayList<View> f;
    private z g;
    private BaseViewPager h;
    private List<Bitmap> i;
    private int[] e = {R.drawable.image_bootpage01, R.drawable.image_bootpage02, R.drawable.image_bootpage03};
    private y j = null;
    private LinearLayout k = null;
    private String l = null;
    private com.baidu.tieba.view.a n = new u(this);
    public View.OnClickListener c = new v(this);
    public View.OnClickListener d = new w(this);
    private final bq o = new x(this);

    public static void a(Activity activity, int i, String str) {
        Intent intent = new Intent(activity, GuideActivity.class);
        intent.putExtra(m, str);
        activity.startActivityForResult(intent, i);
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.guide_activity);
        this.g = new z(this, null);
        this.h = (BaseViewPager) findViewById(R.id.guide_pager);
        this.h.setAdapter(this.g);
        this.h.setOnScrollOutListener(this.n);
        this.h.setOnPageChangeListener(this.o);
        this.i = new ArrayList();
        this.f = new ArrayList<>();
        this.k = (LinearLayout) findViewById(R.id.tagsGroup);
        for (int i = 0; i < this.e.length; i++) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.e[i]);
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setBackgroundColor(-1);
            imageView.setOnClickListener(this.d);
            imageView.setImageBitmap(decodeResource);
            this.i.add(decodeResource);
            this.f.add(i, imageView);
        }
        if (TiebaApplication.g().s()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.h.a());
            } catch (Exception e) {
                bg.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
        if (bundle != null) {
            this.l = bundle.getString(m);
        } else {
            this.l = getIntent().getStringExtra(m);
        }
        if (this.l.equals(f998a)) {
            this.j = new y(this, null);
            this.j.setSelfExecute(true);
            this.j.execute(new String[0]);
            return;
        }
        this.j = null;
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.length) {
                break;
            }
            View view = this.f.get(i2);
            if (view != null) {
                view.setBackgroundDrawable(null);
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageBitmap(null);
                }
            }
            Bitmap bitmap = this.i.get(i2);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            i = i2 + 1;
        }
        if (this.j != null) {
            this.j.cancel(true);
            this.j = null;
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.g().s()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                bg.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        if (TiebaApplication.g().s()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                bg.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                a();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setComponent(new ComponentName(getPackageName(), getPackageName() + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getString(R.string.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
        sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        String str;
        try {
            ContentResolver contentResolver = getContentResolver();
            if (Build.VERSION.SDK_INT < 8) {
                str = "content://com.android.launcher.settings/favorites?notify=true";
            } else {
                str = "content://com.android.launcher2.settings/favorites?notify=true";
            }
            Cursor query = contentResolver.query(Uri.parse(str), new String[]{"title", "iconResource"}, "title=?", new String[]{getString(R.string.app_name)}, null);
            if (query != null) {
                if (query.getCount() > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            bg.a(getClass().getName(), "checkShortCut", e.toString());
        }
        return false;
    }
}
