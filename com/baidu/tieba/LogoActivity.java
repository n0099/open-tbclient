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
import com.baidu.tieba.guide.NewGuideActivity;
import com.baidu.tieba.service.FatalErrorService;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import java.io.File;
/* loaded from: classes.dex */
public class LogoActivity extends j {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f855a = true;
    private boolean b = false;
    private boolean c = false;
    private ImageView d = null;
    private Bitmap e = null;
    private AlphaAnimation f = null;
    private boolean g = false;
    private boolean j = false;
    private Handler k = new w(this);
    private Runnable l = new x(this);
    private Runnable m = new y(this);

    public static void a(boolean z) {
        f855a = z;
    }

    public static void a(Context context, Intent intent) {
        f855a = true;
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
        f855a = true;
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.g().ax();
        a(getIntent());
        com.baidu.tieba.util.av.a(getClass().getName(), "onCreate", null);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.logo_activity);
        this.d = (ImageView) findViewById(R.id.logo);
        if (bundle != null) {
            f855a = bundle.getBoolean("is_first", true);
        } else {
            f855a = true;
        }
        this.f = new AlphaAnimation(1.0f, 1.0f);
        this.f.setDuration(500L);
        this.f.setAnimationListener(new z(this));
        this.k.post(this.l);
        new aa(this).start();
        c();
        if (TiebaApplication.g().w()) {
            UtilHelper.g(getBaseContext());
        } else {
            UtilHelper.h(getBaseContext());
        }
        try {
            if (TiebaApplication.g().v()) {
                MoPlusConstants.startService(getApplicationContext());
            } else {
                com.baidu.tieba.util.av.b(getClass().getName(), "onCreate", "moplus close！！！");
            }
        } catch (Exception e) {
            com.baidu.tieba.util.av.b(getClass().getName(), "onCreate_init_moplus", e.toString());
        }
        if (com.baidu.tieba.data.g.s()) {
            b();
        }
    }

    private void b() {
        startService(new Intent(this, SwitchDebugService.class));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_first", f855a);
    }

    private void c() {
        try {
            startService(new Intent(this, FatalErrorService.class));
        } catch (Throwable th) {
            com.baidu.adp.lib.f.d.a("failed to start FatalErrorService:" + th.getMessage());
        }
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && f855a) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        if (!this.j) {
            TiebaApplication.g().ay();
        }
        this.k.removeCallbacks(this.m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!f855a) {
            f855a = true;
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
                                com.baidu.tieba.util.av.b(getClass().getName(), "deleteAllfile", "list[i].delete error");
                            }
                        }
                    }
                } else if (!file.delete()) {
                    com.baidu.tieba.util.av.b(getClass().getName(), "deleteAllfile", "file.delete error");
                }
            } catch (Exception e) {
                com.baidu.tieba.util.av.b(getClass().getName(), "deleteAllfile", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d();
        f855a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onStop() {
        super.onStop();
        d();
        this.k.removeCallbacks(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        this.k.removeCallbacks(this.m);
        com.baidu.tieba.account.a.a().a(context);
        if (TiebaApplication.g().t()) {
            TiebaApplication.g().aI();
        }
        this.g = TiebaApplication.g().aC();
        if (this.g) {
            TiebaApplication.g().h(0);
            TiebaApplication.g().aD();
            TiebaApplication.g().ay();
            com.baidu.tieba.sharedPref.b.a().b("frs_first_in", true);
            NewGuideActivity.a(this, 16001);
            return;
        }
        b(1);
    }

    private void b(int i) {
        f855a = false;
        String C = TiebaApplication.C();
        this.g = TiebaApplication.g().aC();
        this.j = true;
        if (C != null && C.length() > 0 && !this.g) {
            MainTabActivity.a(this, i);
            return;
        }
        MainTabActivity.a(i);
        MainTabActivity.a(this, 2);
        if (this.g) {
            TiebaApplication.g().aD();
        }
        if ((C == null || C.length() <= 0) && TiebaApplication.n() && f.a((Activity) this)) {
            TiebaApplication.g().ay();
            f.a(this, 0, i, false);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16001:
                    b(1);
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
