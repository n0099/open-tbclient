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
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.service.FatalErrorService;
import com.baidu.zeus.NotificationProxy;
import java.io.File;
/* loaded from: classes.dex */
public class LogoActivity extends e {
    private static boolean c = true;
    private boolean d = false;
    private boolean e = false;
    private ImageView f = null;
    private Bitmap g = null;
    private AlphaAnimation h = null;
    private boolean i = false;
    private boolean j = false;
    private Handler k = new y(this);
    private Runnable l = new z(this);
    private Runnable m = new aa(this);

    public static void a(boolean z) {
        c = z;
    }

    public static void a(Context context, Intent intent) {
        c = true;
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
        j();
        c = true;
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.b().ar();
        a(getIntent());
        com.baidu.tieba.c.ag.a(getClass().getName(), "onCreate", null);
        getWindow().setFlags(NotificationProxy.MAX_URL_LENGTH, NotificationProxy.MAX_URL_LENGTH);
        setContentView(R.layout.logo_activity);
        this.f = (ImageView) findViewById(R.id.logo);
        if (bundle != null) {
            c = bundle.getBoolean("is_first", true);
        } else {
            c = true;
        }
        this.h = new AlphaAnimation(1.0f, 1.0f);
        this.h.setDuration(500L);
        this.h.setAnimationListener(new ab(this));
        this.k.post(this.l);
        new ac(this).start();
        i();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_first", c);
    }

    private void i() {
        startService(new Intent(this, FatalErrorService.class));
    }

    @Override // com.baidu.tieba.e, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && c) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        if (!this.j) {
            TiebaApplication.b().as();
        }
        this.k.removeCallbacks(this.m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!c) {
            c = true;
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
                                com.baidu.tieba.c.ag.b(getClass().getName(), "deleteAllfile", "list[i].delete error");
                            }
                        }
                    }
                } else if (!file.delete()) {
                    com.baidu.tieba.c.ag.b(getClass().getName(), "deleteAllfile", "file.delete error");
                }
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "deleteAllfile", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        k();
        c = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onStop() {
        super.onStop();
        k();
        this.k.removeCallbacks(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.k.removeCallbacks(this.m);
        com.baidu.tieba.account.a.a().d();
        if (TiebaApplication.b().m()) {
            TiebaApplication.b().aA();
        }
        this.i = TiebaApplication.b().aw();
        if (this.i) {
            TiebaApplication.b().as();
            PushConstants.restartPushService(getApplicationContext());
            GuideActivity.a(this, 1600001);
            return;
        }
        PushConstants.startPushService(getApplicationContext());
        c("goto_home");
    }

    private void c(String str) {
        c = false;
        String y = TiebaApplication.y();
        this.i = TiebaApplication.b().aw();
        this.j = true;
        if ((y != null && y.length() > 0 && !this.i) || TiebaApplication.b().ai() >= 3) {
            MainTabActivity.a(this, str);
            return;
        }
        MainTabActivity.a(str);
        MainTabActivity.a(this, "goto_recommend");
        if ((y == null || y.length() <= 0) && TiebaApplication.g() && a.a((Activity) this)) {
            TiebaApplication.b().as();
            a.a(this, 0, str, false);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1600001:
                    LabelActivity.a(this, 1600002, "guide");
                    return;
                case 1600002:
                    TiebaApplication.b().ax();
                    c("goto_recommend");
                    return;
                default:
                    return;
            }
        }
    }

    private void k() {
        this.f.setImageBitmap(null);
        if (this.g != null && !this.g.isRecycled()) {
            this.g.recycle();
            this.g = null;
        }
    }
}
