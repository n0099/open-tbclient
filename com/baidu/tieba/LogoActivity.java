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
        a = false;
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

    private static void a(Intent intent) {
        if (intent != null) {
            com.baidu.adp.lib.util.e.d("intent:" + intent);
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
        getBaseContext();
        a();
        a = true;
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.g().an();
        a(getIntent());
        com.baidu.adp.lib.util.e.a(getClass().getName(), "onCreate", (String) null);
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
        this.g = TiebaApplication.g().ax();
        this.j.post(this.k);
        new ae(this).start();
        TiebaApplication.g();
        TiebaApplication.bc();
        if (TiebaApplication.g().r()) {
            UtilHelper.f(getBaseContext());
        } else {
            UtilHelper.g(getBaseContext());
        }
        try {
            if (TiebaApplication.g().q()) {
                MoPlusConstants.startService(getApplicationContext());
            } else {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "onCreate", "moplus close！！！");
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b(getClass().getName(), "onCreate_init_moplus", e.toString());
        }
        if (com.baidu.tieba.data.i.F()) {
            startService(new Intent(this, SwitchDebugService.class));
        }
        if (!com.baidu.tieba.util.af.a()) {
            cb.a("no SD", "LogoActivity.onCreate");
        }
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
            TiebaApplication.g().ao();
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
                                com.baidu.adp.lib.util.e.b(getClass().getName(), "deleteAllfile", "list[i].delete error");
                            }
                        }
                    }
                } else if (!file.delete()) {
                    com.baidu.adp.lib.util.e.b(getClass().getName(), "deleteAllfile", "file.delete error");
                }
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "deleteAllfile", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b();
        a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onStop() {
        super.onStop();
        b();
        this.j.removeCallbacks(this.l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.j.removeCallbacks(this.l);
        if (this.g) {
            TiebaApplication.g().v(true);
            TiebaApplication.g().d(0);
            TiebaApplication.g().ao();
            com.baidu.tieba.sharedPref.b.a().b("frs_first_in", true);
        }
        if (i) {
            a(1);
            i = false;
        } else if (TiebaApplication.w()) {
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

    private void a(int i2) {
        a = false;
        this.h = true;
        MainTabActivity.a(this, i2);
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        int intExtra;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            switch (i2) {
                case 16001:
                    if (intent != null && (intExtra = intent.getIntExtra("go_to", -1)) >= 0) {
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

    private void b() {
        if (this.d != null) {
            this.d.setImageBitmap(null);
        }
        if (this.e != null && !this.e.isRecycled()) {
            this.e.recycle();
            this.e = null;
        }
    }
}
