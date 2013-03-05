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
import com.baidu.tieba.c.ag;
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
    private Handler i = new l(this);
    private Runnable j = new m(this);
    private Runnable k = new n(this);

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
        a(getIntent());
        ag.a(getClass().getName(), "onCreate", null);
        getWindow().setFlags(NotificationProxy.MAX_URL_LENGTH, NotificationProxy.MAX_URL_LENGTH);
        setContentView(R.layout.logo_activity);
        this.f = (ImageView) findViewById(R.id.logo);
        if (bundle != null) {
            c = bundle.getBoolean("is_first", true);
        } else {
            c = true;
        }
        this.h = new AlphaAnimation(1.0f, 1.0f);
        this.h.setDuration(1000L);
        this.h.setAnimationListener(new o(this));
        this.i.post(this.j);
        new p(this).start();
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

    @Override // android.app.Activity, android.view.KeyEvent.Callback
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
        this.i.removeCallbacks(this.k);
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
                                ag.b(getClass().getName(), "deleteAllfile", "list[i].delete error");
                            }
                        }
                    }
                } else if (!file.delete()) {
                    ag.b(getClass().getName(), "deleteAllfile", "file.delete error");
                }
            } catch (Exception e) {
                ag.b(getClass().getName(), "deleteAllfile", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l();
        c = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onStop() {
        super.onStop();
        l();
        this.i.removeCallbacks(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.i.removeCallbacks(this.k);
        com.baidu.tieba.account.a.a().d();
        if (TiebaApplication.b().l()) {
            TiebaApplication.b().av();
        }
        if (TiebaApplication.b().ar()) {
            TiebaApplication.b().as();
            GuideActivity.a(this, 1600001);
            return;
        }
        k();
    }

    private void k() {
        c = false;
        String x = TiebaApplication.x();
        if ((x != null && x.length() > 0) || TiebaApplication.b().ah() >= 3) {
            MainTabActivity.a(this, "goto_home");
            return;
        }
        MainTabActivity.a(this, "goto_recommend");
        if ((x == null || x.length() <= 0) && TiebaApplication.g() && a.a((Activity) this)) {
            a.a(this, 0, "goto_home", false);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1600001:
                    k();
                    return;
                default:
                    return;
            }
        }
    }

    private void l() {
        this.f.setImageBitmap(null);
        if (this.g != null && !this.g.isRecycled()) {
            this.g.recycle();
            this.g = null;
        }
    }
}
