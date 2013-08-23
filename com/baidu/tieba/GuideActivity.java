package com.baidu.tieba;

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
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.view.BaseViewPager;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class GuideActivity extends g {
    private ArrayList d;
    private s e;
    private BaseViewPager f;
    private List g;
    private int[] c = {R.drawable.image_bootpage01, R.drawable.image_bootpage02, R.drawable.image_bootpage03};
    private r j = null;
    private LinearLayout k = null;
    private com.baidu.tieba.view.a l = new n(this);

    /* renamed from: a */
    public View.OnClickListener f841a = new o(this);
    public View.OnClickListener b = new p(this);
    private final bq m = new q(this);

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.guide_activity);
        this.e = new s(this, null);
        this.f = (BaseViewPager) findViewById(R.id.guide_pager);
        this.f.setAdapter(this.e);
        this.f.setOnScrollOutListener(this.l);
        this.f.setOnPageChangeListener(this.m);
        this.g = new ArrayList();
        this.d = new ArrayList();
        this.k = (LinearLayout) findViewById(R.id.tagsGroup);
        for (int i = 0; i < this.c.length; i++) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.c[i]);
            ImageView imageView = new ImageView(this);
            imageView.setOnClickListener(this.b);
            imageView.setBackgroundDrawable(new BitmapDrawable(decodeResource));
            this.g.add(decodeResource);
            this.d.add(i, imageView);
        }
        if (TiebaApplication.g().u()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.g.a());
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
        this.j = new r(this, null);
        this.j.setSelfExecute(true);
        this.j.execute(new String[0]);
    }

    @Override // com.baidu.tieba.g, android.app.Activity
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
            Bitmap bitmap = (Bitmap) this.g.get(i2);
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

    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.g().u()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        if (TiebaApplication.g().u()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.tieba.util.aq.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                b();
                return true;
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    public void b() {
        setResult(-1);
        finish();
    }

    public void c() {
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
            com.baidu.tieba.util.aq.a(getClass().getName(), "checkShortCut", e.toString());
        }
        return false;
    }
}
