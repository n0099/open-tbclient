package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.baidu.adp.lib.debug.service.SwitchDebugService;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.File;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends com.baidu.tbadk.a {
    private boolean a = false;
    private boolean b = false;
    private ImageView c = null;
    private Bitmap d = null;
    private AlphaAnimation e = null;
    private boolean f = false;
    private boolean g = false;
    private final Handler h = new e(this);
    private final Runnable i = new f(this);
    private final Runnable j = new g(this);

    static {
        TbadkApplication.j().a(com.baidu.tbadk.core.b.z.class, LogoActivity.class);
    }

    private static void a(Intent intent) {
        if (intent != null) {
            com.baidu.adp.lib.util.f.d("intent:" + intent);
            if (intent.getBooleanExtra("from_short_cut", false)) {
                com.baidu.tbadk.core.b.z.b = true;
                Intent intent2 = new Intent();
                intent2.putExtra("class", 2);
                intent2.putExtra("fname", intent.getStringExtra("fname"));
                intent2.putExtra("from_short_cut", true);
                intent2.putExtra("back_special", true);
                intent2.putExtra("from", "short_cut");
                intent.putExtra("extra_intent", intent2);
            }
            TbadkApplication.a((Intent) intent.getParcelableExtra("extra_intent"));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
        getBaseContext();
        a();
        com.baidu.tbadk.core.b.z.a = true;
    }

    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TbadkApplication.j().f();
        a(getIntent());
        com.baidu.adp.lib.util.f.a(getClass().getName(), "onCreate", (String) null);
        getWindow().setFlags(1024, 1024);
        setContentView(com.baidu.b.a.g.logo_activity);
        this.c = (ImageView) findViewById(com.baidu.b.a.f.logo);
        if (bundle != null) {
            com.baidu.tbadk.core.b.z.a = bundle.getBoolean("is_first", true);
        } else {
            com.baidu.tbadk.core.b.z.a = true;
        }
        this.e = new AlphaAnimation(1.0f, 1.0f);
        this.e.setDuration(500L);
        this.e.setAnimationListener(new h(this));
        this.f = TbadkApplication.j().T();
        this.h.post(this.i);
        new i(this).start();
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006003, "start"));
        if (com.baidu.tbadk.core.data.n.a()) {
            startService(new Intent(this, SwitchDebugService.class));
        }
        if (!com.baidu.tbadk.core.util.w.a()) {
            TiebaStatic.a("no SD", "LogoActivity.onCreate");
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_first", com.baidu.tbadk.core.b.z.a);
    }

    @Override // com.baidu.tbadk.a, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && com.baidu.tbadk.core.b.z.a) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onPause() {
        super.onPause();
        if (!this.g) {
            TbadkApplication.j().g();
        }
        this.h.removeCallbacks(this.j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!com.baidu.tbadk.core.b.z.a) {
            com.baidu.tbadk.core.b.z.a = true;
            finish();
            return;
        }
        this.h.removeCallbacks(this.j);
        this.h.postDelayed(this.j, 5000L);
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
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b();
        com.baidu.tbadk.core.b.z.a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, android.app.Activity
    public void onStop() {
        super.onStop();
        b();
        this.h.removeCallbacks(this.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.h.removeCallbacks(this.j);
        if (this.f) {
            com.baidu.tbadk.s.a();
            com.baidu.tbadk.s.b("first_sync_image_quality", true);
            TbadkApplication.j().a(0);
            TbadkApplication.j().g();
            com.baidu.tbadk.core.sharedPref.b.a().b("frs_first_in", true);
        }
        if (com.baidu.tbadk.core.b.z.b) {
            a(1);
            com.baidu.tbadk.core.b.z.b = false;
        } else if (TbadkApplication.F()) {
            if (this.f) {
                sendMessage(new com.baidu.adp.framework.message.a(2015000, new com.baidu.tbadk.core.b.p(this).a("from_logo_page")));
                finish();
                return;
            }
            a(1);
        } else {
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.ad(this, com.baidu.tbadk.core.b.ad.c)));
            finish();
        }
    }

    private void a(int i) {
        com.baidu.tbadk.core.b.z.a = false;
        this.g = true;
        sendMessage(new com.baidu.adp.framework.message.a(2015001, new com.baidu.tbadk.core.b.aa(this).a(i, false)));
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int intExtra;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
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
        if (this.c != null) {
            this.c.setImageBitmap(null);
        }
        if (this.d != null && !this.d.isRecycled()) {
            this.d.recycle();
            this.d = null;
        }
    }
}
