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
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
public class LogoActivity extends j {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f1011a = true;
    private boolean b = false;
    private boolean c = false;
    private ImageView d = null;
    private Bitmap e = null;
    private AlphaAnimation f = null;
    private boolean g = false;
    private boolean h = false;
    private Handler i = new ai(this);
    private Runnable j = new al(this);
    private Runnable k = new am(this);

    public static void a(boolean z) {
        f1011a = z;
    }

    public static void a(Context context, Intent intent) {
        f1011a = true;
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
            com.baidu.adp.lib.h.e.c("intent:" + intent);
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
        f1011a = true;
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.h().ax();
        a(getIntent());
        com.baidu.tieba.util.bd.a(getClass().getName(), "onCreate", null);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.logo_activity);
        this.d = (ImageView) findViewById(R.id.logo);
        if (bundle != null) {
            f1011a = bundle.getBoolean("is_first", true);
        } else {
            f1011a = true;
        }
        this.f = new AlphaAnimation(1.0f, 1.0f);
        this.f.setDuration(500L);
        this.f.setAnimationListener(new aj(this));
        this.i.post(this.j);
        new ak(this).start();
        b();
        if (TiebaApplication.h().x()) {
            UtilHelper.e(getBaseContext());
        } else {
            UtilHelper.f(getBaseContext());
        }
        try {
            if (TiebaApplication.h().w()) {
                MoPlusConstants.startService(getApplicationContext());
            } else {
                com.baidu.tieba.util.bd.b(getClass().getName(), "onCreate", "moplus close！！！");
            }
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b(getClass().getName(), "onCreate_init_moplus", e.toString());
        }
        if (com.baidu.tieba.data.h.s()) {
            a();
        }
    }

    private void a() {
        startService(new Intent(this, SwitchDebugService.class));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_first", f1011a);
    }

    private void b() {
        try {
            startService(new Intent(this, FatalErrorService.class));
        } catch (Throwable th) {
            com.baidu.adp.lib.h.e.a("failed to start FatalErrorService:" + th.getMessage());
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && f1011a) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        if (!this.h) {
            TiebaApplication.h().ay();
        }
        this.i.removeCallbacks(this.k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!f1011a) {
            f1011a = true;
            finish();
            return;
        }
        this.i.removeCallbacks(this.k);
        this.i.postDelayed(this.k, 5000L);
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
                                com.baidu.tieba.util.bd.b(getClass().getName(), "deleteAllfile", "list[i].delete error");
                            }
                        }
                    }
                } else if (!file.delete()) {
                    com.baidu.tieba.util.bd.b(getClass().getName(), "deleteAllfile", "file.delete error");
                }
            } catch (Exception e) {
                com.baidu.tieba.util.bd.b(getClass().getName(), "deleteAllfile", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c();
        f1011a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        c();
        this.i.removeCallbacks(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        this.i.removeCallbacks(this.k);
        com.baidu.tieba.account.a.a().a(context);
        if (TiebaApplication.h().u()) {
            TiebaApplication.h().aO();
        }
        this.g = TiebaApplication.h().aH();
        if (this.g) {
            TiebaApplication.h().w(true);
            TiebaApplication.h().d(0);
            TiebaApplication.h().aI();
            TiebaApplication.h().ay();
            com.baidu.tieba.sharedPref.b.a().b("frs_first_in", true);
            GuideActivity.a(this, 16001, GuideActivity.f1010a);
            return;
        }
        a(1);
    }

    private void a(int i) {
        f1011a = false;
        String B = TiebaApplication.B();
        this.g = TiebaApplication.h().aH();
        this.h = true;
        if (B != null && B.length() > 0 && !this.g) {
            MainTabActivity.a(this, i);
            return;
        }
        MainTabActivity.c(i);
        MainTabActivity.a(this, 2);
        if (this.g) {
            TiebaApplication.h().aI();
        }
        if ((B == null || B.length() <= 0) && TiebaApplication.o() && f.a((Activity) this) && i != 10) {
            TiebaApplication.h().ay();
            f.a(this, 0, i, false);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
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
        this.d.setImageBitmap(null);
        if (this.e != null && !this.e.isRecycled()) {
            this.e.recycle();
            this.e = null;
        }
    }
}
