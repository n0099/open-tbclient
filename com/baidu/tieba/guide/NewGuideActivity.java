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
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NewGuideActivity extends j implements View.OnClickListener {

    /* renamed from: a */
    private e f1304a;
    private GuideView b;
    private d c;

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_guide_activity);
        this.b = (GuideView) findViewById(R.id.guide);
        this.f1304a = new e(this.b.getForegroundView());
        this.b.setOnEnterClickListener(this);
        this.b.setIndicator((IndicatorView) findViewById(R.id.indicator));
        a(new com.baidu.tieba.guide.a.f(this, 10));
        a(new com.baidu.tieba.guide.a.c(this));
        com.baidu.tieba.guide.a.b bVar = new com.baidu.tieba.guide.a.b(getApplicationContext());
        a(bVar);
        a(new com.baidu.tieba.guide.a.e(this, bVar.d()));
        if (TiebaApplication.g().s()) {
            try {
                StatService.setAppChannel(h.a());
            } catch (Exception e) {
                be.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
        this.c = new d(this);
        this.c.setSelfExecute(true);
        this.c.execute(new String[0]);
    }

    private void a(f fVar) {
        this.b.getForegroundView().a(fVar);
        this.f1304a.a(fVar);
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f1304a.b();
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
        this.f1304a.a();
        if (TiebaApplication.g().s()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                be.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f1304a != null) {
            this.f1304a.c();
            this.b.getForegroundView().a();
            this.b.getBackgroundView().a();
        }
        if (this.c != null) {
            this.c.cancel(true);
            this.c = null;
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

    @Override // com.baidu.adp.a.a, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.enter) {
            if (TiebaApplication.g().s()) {
                StatService.onEvent(this, "guide_start_voice", "voice_click", 1);
            }
            c();
            return;
        }
        b();
    }

    private void b() {
        setResult(-1);
        finish();
    }

    private void c() {
        setResult(-1);
        FrsActivity.a(this, "贴吧好声优", "from_guide");
        finish();
    }

    public void d() {
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

    public boolean e() {
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
