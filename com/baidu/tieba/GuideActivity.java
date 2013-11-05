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
import com.baidu.tieba.util.be;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GuideActivity extends j {
    private ArrayList<View> d;
    private x e;
    private BaseViewPager f;
    private List<Bitmap> g;
    private int[] c = {R.drawable.image_bootpage01, R.drawable.image_bootpage02, R.drawable.image_bootpage03};
    private w j = null;
    private LinearLayout k = null;
    private com.baidu.tieba.view.a l = new s(this);

    /* renamed from: a  reason: collision with root package name */
    public View.OnClickListener f983a = new t(this);
    public View.OnClickListener b = new u(this);
    private final bq m = new v(this);

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, GuideActivity.class), i);
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.guide_activity);
        this.e = new x(this, null);
        this.f = (BaseViewPager) findViewById(R.id.guide_pager);
        this.f.setAdapter(this.e);
        this.f.setOnScrollOutListener(this.l);
        this.f.setOnPageChangeListener(this.m);
        this.g = new ArrayList();
        this.d = new ArrayList<>();
        this.k = (LinearLayout) findViewById(R.id.tagsGroup);
        for (int i = 0; i < this.c.length; i++) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.c[i]);
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageView.setBackgroundColor(-1);
            imageView.setOnClickListener(this.b);
            imageView.setImageBitmap(decodeResource);
            this.g.add(decodeResource);
            this.d.add(i, imageView);
        }
        if (TiebaApplication.g().s()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.h.a());
            } catch (Exception e) {
                be.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
        this.j = new w(this, null);
        this.j.setSelfExecute(true);
        this.j.execute(new String[0]);
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.length) {
                break;
            }
            View view = this.d.get(i2);
            if (view != null) {
                view.setBackgroundDrawable(null);
                if (view instanceof ImageView) {
                    ((ImageView) view).setImageBitmap(null);
                }
            }
            Bitmap bitmap = this.g.get(i2);
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
                be.b(getClass().getName(), "onResume", e.getMessage());
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
                be.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                b();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getPackageName(), LogoActivity.class.getName()));
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setFlags(270532608);
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getString(R.string.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
        sendBroadcast(intent2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
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
            be.a(getClass().getName(), "checkShortCut", e.toString());
        }
        return false;
    }
}
