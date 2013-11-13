package com.baidu.tieba.guide;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.adp.widget.IndicatorView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.LogoActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.h;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.j;
import com.baidu.tieba.util.bg;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class c extends j implements View.OnClickListener {

    /* renamed from: a */
    public static String f1382a = "from_logo_page";
    public static String b = "from_about_page";
    private static String g = "from_page";
    private f c;
    private GuideView d;
    private e e;
    private String f;

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_guide_activity);
        this.d = (GuideView) findViewById(R.id.guide);
        this.c = new f(this.d.getForegroundView());
        this.d.setOnEnterClickListener(this);
        this.d.setIndicator((IndicatorView) findViewById(R.id.indicator));
        a(new com.baidu.tieba.guide.a.f(this, 10));
        a(new com.baidu.tieba.guide.a.c(this));
        com.baidu.tieba.guide.a.b bVar = new com.baidu.tieba.guide.a.b(getApplicationContext());
        a(bVar);
        a(new com.baidu.tieba.guide.a.e(this, bVar.d()));
        if (TiebaApplication.g().s()) {
            try {
                StatService.setAppChannel(h.a());
            } catch (Exception e) {
                bg.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
        if (bundle != null) {
            this.f = bundle.getString(g);
        } else {
            this.f = getIntent().getStringExtra(g);
        }
        if (this.f.equals(f1382a)) {
            this.e = new e(this);
            this.e.setSelfExecute(true);
            this.e.execute(new String[0]);
            return;
        }
        this.e = null;
    }

    private void a(g gVar) {
        this.d.getForegroundView().a(gVar);
        this.c.a(gVar);
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.c.b();
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
        this.c.a();
        if (TiebaApplication.g().s()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                bg.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.c();
            this.d.getForegroundView().a();
            this.d.getBackgroundView().a();
        }
        if (this.e != null) {
            this.e.cancel(true);
            this.e = null;
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

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.enter) {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "guide_start_voice", "voice_click", 1);
            }
            b();
            return;
        }
        a();
    }

    private void a() {
        setResult(-1);
        finish();
    }

    private void b() {
        setResult(-1);
        FrsActivity.a(this, "贴吧好声优", "from_guide");
        finish();
    }

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
            if (query != null && query.moveToFirst()) {
                query.close();
                return true;
            }
        } catch (Exception e) {
            bg.a(getClass().getName(), "checkShortCut", e.toString());
        }
        return false;
    }
}
