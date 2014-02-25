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
import com.baidu.tieba.account.NotLoginGuideActivity;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
public class LogoActivity extends f {
    private static boolean a = true;
    private static boolean i = false;
    private boolean b = false;
    private boolean c = false;
    private ImageView d = null;
    private Bitmap e = null;
    private AlphaAnimation f = null;
    private boolean g = false;
    private boolean h = false;
    private Handler j = new aa(this);
    private Runnable k = new ab(this);
    private Runnable l = new ac(this);

    public static void a(boolean z) {
        a = z;
    }

    public static void a(Context context, Intent intent) {
        a = true;
        i = true;
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
            com.baidu.adp.lib.util.f.d("intent:" + intent);
            if (intent.getBooleanExtra("from_short_cut", false)) {
                i = true;
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
        a = true;
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.g().au();
        a(getIntent());
        com.baidu.adp.lib.util.f.a(getClass().getName(), "onCreate", (String) null);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.logo_activity);
        this.d = (ImageView) findViewById(R.id.logo);
        if (bundle != null) {
            a = bundle.getBoolean("is_first", true);
        } else {
            a = true;
        }
        this.f = new AlphaAnimation(1.0f, 1.0f);
        this.f.setDuration(500L);
        this.f.setAnimationListener(new ad(this));
        this.g = TiebaApplication.g().aE();
        this.j.post(this.k);
        new ae(this).start();
        TiebaApplication.g().bk();
        if (TiebaApplication.g().w()) {
            UtilHelper.f(getBaseContext());
        } else {
            UtilHelper.g(getBaseContext());
        }
        try {
            if (TiebaApplication.g().v()) {
                MoPlusConstants.startService(getApplicationContext());
            } else {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "onCreate", "moplus close！！！");
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "onCreate_init_moplus", e.toString());
        }
        if (com.baidu.tieba.data.i.F()) {
            a();
        }
        if (!com.baidu.tieba.util.af.a()) {
            cb.a("no SD", "LogoActivity.onCreate");
        }
    }

    private void a() {
        startService(new Intent(this, SwitchDebugService.class));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_first", a);
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && a) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        if (!this.h) {
            TiebaApplication.g().av();
        }
        this.j.removeCallbacks(this.l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!a) {
            a = true;
            finish();
            return;
        }
        this.j.removeCallbacks(this.l);
        this.j.postDelayed(this.l, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file) {
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (int i2 = 0; i2 < listFiles.length; i2++) {
                            if (listFiles[i2].isDirectory()) {
                                a(listFiles[i2]);
                            } else if (!listFiles[i2].delete()) {
                                com.baidu.adp.lib.util.f.b(getClass().getName(), "deleteAllfile", "list[i].delete error");
                            }
                        }
                    }
                } else if (!file.delete()) {
                    com.baidu.adp.lib.util.f.b(getClass().getName(), "deleteAllfile", "file.delete error");
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.f.b(getClass().getName(), "deleteAllfile", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c();
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        c();
        this.j.removeCallbacks(this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        this.j.removeCallbacks(this.l);
        b();
        if (i) {
            a(1);
            i = false;
        } else if (TiebaApplication.B()) {
            if (this.g) {
                GuideActivity.a(this, "from_logo_page");
                finish();
                return;
            }
            a(1);
        } else {
            NotLoginGuideActivity.a(this, NotLoginGuideActivity.b);
            finish();
        }
    }

    private void b() {
        if (this.g) {
            TiebaApplication.g().w(true);
            TiebaApplication.g().d(0);
            TiebaApplication.g().av();
            com.baidu.tieba.sharedPref.b.a().b("frs_first_in", true);
        }
    }

    private void a(int i2) {
        a = false;
        this.h = true;
        MainTabActivity.a(this, i2);
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            switch (i2) {
                case 16001:
                    if (intent == null) {
                        a(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        a(intExtra);
                        return;
                    } else {
                        a(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void c() {
        if (this.d != null) {
            this.d.setImageBitmap(null);
        }
        if (this.e != null && !this.e.isRecycled()) {
            this.e.recycle();
            this.e = null;
        }
    }
}
