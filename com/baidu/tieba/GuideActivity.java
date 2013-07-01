package com.baidu.tieba;

import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.bq;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GuideActivity extends Activity {
    private ArrayList d;
    private q e;
    private BaseViewPager f;
    private Button g;
    private List h;
    private int[] c = {R.drawable.image_bootpage01, R.drawable.image_bootpage02};
    private p i = null;
    private LinearLayout j = null;
    private com.baidu.tieba.view.a k = new l(this);

    /* renamed from: a */
    public View.OnClickListener f613a = new m(this);
    public View.OnClickListener b = new n(this);
    private final bq l = new o(this);

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, GuideActivity.class), i);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        View imageView;
        super.onCreate(bundle);
        setContentView(R.layout.guide_activity);
        this.e = new q(this, null);
        this.f = (BaseViewPager) findViewById(R.id.guide_pager);
        this.f.setAdapter(this.e);
        this.f.setOnScrollOutListener(this.k);
        this.f.setOnPageChangeListener(this.l);
        this.h = new ArrayList();
        LayoutInflater layoutInflater = getLayoutInflater();
        this.d = new ArrayList();
        this.j = (LinearLayout) findViewById(R.id.tagsGroup);
        for (int i = 0; i < this.c.length; i++) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.c[i]);
            if (i == this.c.length - 1) {
                imageView = layoutInflater.inflate(R.layout.guide_view, (ViewGroup) null);
            } else {
                imageView = new ImageView(this);
            }
            imageView.setOnClickListener(this.b);
            imageView.setBackgroundDrawable(new BitmapDrawable(decodeResource));
            this.h.add(decodeResource);
            this.d.add(i, imageView);
        }
        if (TiebaApplication.f().t()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.g.a());
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
        this.i = new p(this, null);
        this.i.setSelfExecute(true);
        this.i.execute(new String[0]);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.length) {
                break;
            }
            View view = (View) this.d.get(i2);
            if (view != null) {
                view.setBackgroundDrawable(null);
            }
            Bitmap bitmap = (Bitmap) this.h.get(i2);
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            i = i2 + 1;
        }
        if (this.i != null) {
            this.i.cancel(true);
            this.i = null;
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.f().t()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (TiebaApplication.f().t()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                a();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void a() {
        setResult(-1);
        finish();
    }

    public void b() {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        intent.setComponent(new ComponentName(getPackageName(), String.valueOf(getPackageName()) + ".LogoActivity"));
        Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        intent2.putExtra("duplicate", false);
        intent2.putExtra("android.intent.extra.shortcut.NAME", getString(R.string.app_name));
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, R.drawable.icon));
        sendBroadcast(intent2);
    }

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
            com.baidu.tieba.util.z.a(getClass().getName(), "checkShortCut", e.toString());
        }
        return false;
    }
}
