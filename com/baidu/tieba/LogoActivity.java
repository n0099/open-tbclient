package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.baidu.adp.lib.debug.service.SwitchDebugService;
import com.baidu.android.moplus.MoPlusConstants;
import com.baidu.tieba.service.FatalErrorService;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
public class LogoActivity extends g {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f821a = true;
    private boolean b = false;
    private boolean c = false;
    private ImageView d = null;
    private Bitmap e = null;
    private AlphaAnimation f = null;
    private boolean g = false;
    private boolean j = false;
    private Handler k = new ae(this);
    private Runnable l = new af(this);
    private Runnable m = new ag(this);

    public static void a(boolean z) {
        f821a = z;
    }

    public static void a(Context context, Intent intent) {
        f821a = true;
        Intent intent2 = new Intent(context, LogoActivity.class);
        if (!(context instanceof Activity)) {
            intent2.setFlags(268435456);
        }
        if (intent != null) {
            intent2.putExtra("extra_intent", intent);
        }
        intent2.addCategory("android.intent.category.LAUNCHER");
        intent2.setAction("android.intent.action.MAIN");
        context.startActivity(intent2);
    }

    private void a(Intent intent) {
        if (intent != null) {
            if (intent.getBooleanExtra("from_short_cut", false)) {
                Intent intent2 = new Intent();
                intent2.putExtra("class", 2);
                intent2.putExtra("fname", intent.getStringExtra("fname"));
                intent2.putExtra("from_short_cut", true);
                intent2.putExtra("back_special", true);
                intent2.putExtra("from", "short_cut");
                intent.putExtra("extra_intent", intent2);
            }
            TiebaApplication.a((Intent) intent.getParcelableExtra("extra_intent"));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
        a(getBaseContext());
        f821a = true;
    }

    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.f().aG();
        a(getIntent());
        com.baidu.tieba.util.aj.a(getClass().getName(), "onCreate", null);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.logo_activity);
        this.d = (ImageView) findViewById(R.id.logo);
        if (bundle != null) {
            f821a = bundle.getBoolean("is_first", true);
        } else {
            f821a = true;
        }
        this.f = new AlphaAnimation(1.0f, 1.0f);
        this.f.setDuration(500L);
        this.f.setAnimationListener(new ah(this));
        this.k.post(this.l);
        new ai(this).start();
        c();
        if (TiebaApplication.f().y()) {
            com.baidu.tieba.util.am.g(getBaseContext());
        } else {
            com.baidu.tieba.util.am.h(getBaseContext());
        }
        if (com.baidu.tieba.data.g.r()) {
            b();
        }
        try {
            if (TiebaApplication.f().x()) {
                MoPlusConstants.startService(getApplicationContext());
            } else {
                com.baidu.tieba.util.aj.b(getClass().getName(), "onCreate", "moplus close！！！");
            }
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "onCreate_init_moplus", e.toString());
        }
    }

    private void b() {
        startService(new Intent(this, SwitchDebugService.class));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_first", f821a);
    }

    private void c() {
        try {
            startService(new Intent(this, FatalErrorService.class));
        } catch (Throwable th) {
            com.baidu.adp.lib.e.d.a("failed to start FatalErrorService:" + th.getMessage());
        }
    }

    @Override // com.baidu.tieba.g, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && f821a) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onPause() {
        super.onPause();
        if (!this.j) {
            TiebaApplication.f().aH();
        }
        this.k.removeCallbacks(this.m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!f821a) {
            f821a = true;
            finish();
            return;
        }
        this.k.removeCallbacks(this.m);
        this.k.postDelayed(this.m, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (int i = 0; i < listFiles.length; i++) {
                            if (listFiles[i].isDirectory()) {
                                a(listFiles[i]);
                            } else if (!listFiles[i].delete()) {
                                com.baidu.tieba.util.aj.b(getClass().getName(), "deleteAllfile", "list[i].delete error");
                            }
                        }
                    }
                } else if (!file.delete()) {
                    com.baidu.tieba.util.aj.b(getClass().getName(), "deleteAllfile", "file.delete error");
                }
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "deleteAllfile", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d();
        f821a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onStop() {
        super.onStop();
        d();
        this.k.removeCallbacks(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        this.k.removeCallbacks(this.m);
        com.baidu.tieba.account.a.a().a(context);
        if (TiebaApplication.f().u()) {
            TiebaApplication.f().aR();
        }
        this.g = TiebaApplication.f().aL();
        if (this.g) {
            TiebaApplication.f().aH();
            GuideActivity.a(this, 16001);
            return;
        }
        c("goto_home");
    }

    private void c(String str) {
        f821a = false;
        String E = TiebaApplication.E();
        this.g = TiebaApplication.f().aL();
        this.j = true;
        if (E != null && E.length() > 0 && !this.g) {
            MainTabActivity.a(this, str);
            return;
        }
        MainTabActivity.a(str);
        MainTabActivity.a(this, "goto_recommend");
        if ((E == null || E.length() <= 0) && TiebaApplication.n() && c.a((Activity) this)) {
            TiebaApplication.f().aH();
            c.a(this, 0, str, false);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16001:
                    TiebaApplication.f().aM();
                    c("goto_home");
                    return;
                default:
                    return;
            }
        }
    }

    private void d() {
        this.d.setImageBitmap(null);
        if (this.e != null && !this.e.isRecycled()) {
            this.e.recycle();
            this.e = null;
        }
    }
}
