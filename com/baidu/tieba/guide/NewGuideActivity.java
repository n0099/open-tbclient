package com.baidu.tieba.guide;

import android.app.Activity;
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
import com.baidu.tieba.data.g;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.guide.a.f;
import com.baidu.tieba.j;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class NewGuideActivity extends j implements View.OnClickListener {

    /* renamed from: a */
    private d f1169a;
    private GuideView b;
    private c c;

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.new_guide_activity);
        this.b = (GuideView) findViewById(R.id.guide);
        this.f1169a = new d(this.b.getForegroundView(), null);
        this.b.setOnEnterClickListener(this);
        this.b.setIndicator((IndicatorView) findViewById(R.id.indicator));
        a(new f(this, 10));
        a(new com.baidu.tieba.guide.a.c(this));
        com.baidu.tieba.guide.a.b bVar = new com.baidu.tieba.guide.a.b(getApplicationContext());
        a(bVar);
        a(new com.baidu.tieba.guide.a.e(this, bVar.d()));
        if (TiebaApplication.g().s()) {
            try {
                StatService.setAppChannel(g.a());
            } catch (Exception e) {
                av.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
        this.c = new c(this, null);
        this.c.setSelfExecute(true);
        this.c.execute(new String[0]);
    }

    public static void a(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, NewGuideActivity.class), i);
    }

    private void a(e eVar) {
        this.b.getForegroundView().a(eVar);
        this.f1169a.a(eVar);
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f1169a.b();
        if (TiebaApplication.g().s()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                av.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f1169a.a();
        if (TiebaApplication.g().s()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                av.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f1169a != null) {
            this.f1169a.c();
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
        Intent intent = new Intent(getApplicationContext(), LogoActivity.class);
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
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
            av.a(getClass().getName(), "checkShortCut", e.toString());
        }
        return false;
    }
}
