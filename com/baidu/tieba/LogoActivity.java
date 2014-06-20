package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.debug.service.SwitchDebugService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.File;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity {
    private boolean a = false;
    private boolean b = false;
    private ImageView c = null;
    private Bitmap d = null;
    private AlphaAnimation e = null;
    private boolean f = false;
    private boolean g = false;
    private a h = new a();
    private final Handler i = new h(this);
    private final Runnable j = new i(this);
    private final Runnable k = new j(this);
    private final d l = new k(this);

    static {
        TbadkApplication.m252getInst().RegisterIntent(com.baidu.tbadk.core.atomData.aj.class, LogoActivity.class);
    }

    private void a(Intent intent) {
        if (intent != null) {
            BdLog.i("intent:" + intent);
            if (intent.getBooleanExtra("from_short_cut", false)) {
                com.baidu.tbadk.core.atomData.aj.b = true;
                Intent intent2 = new Intent();
                intent2.putExtra("class", 2);
                intent2.putExtra("fname", intent.getStringExtra("fname"));
                intent2.putExtra("from_short_cut", true);
                intent2.putExtra("back_special", true);
                intent2.putExtra("from", "short_cut");
                intent.putExtra("extra_intent", intent2);
            }
            TbadkApplication.setIntent((Intent) intent.getParcelableExtra("extra_intent"));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
        a(getBaseContext());
        com.baidu.tbadk.core.atomData.aj.a = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h.a(this.l);
        TbadkApplication.m252getInst().markLauchTime();
        if (!TbadkApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2007015, null));
        }
        a(getIntent());
        BdLog.i(getClass().getName(), "onCreate", null);
        getWindow().setFlags(1024, 1024);
        setContentView(w.logo_activity);
        this.c = (ImageView) findViewById(v.logo);
        if (bundle != null) {
            com.baidu.tbadk.core.atomData.aj.a = bundle.getBoolean("is_first", true);
        } else {
            com.baidu.tbadk.core.atomData.aj.a = true;
        }
        this.e = new AlphaAnimation(1.0f, 1.0f);
        this.e.setDuration(500L);
        this.e.setAnimationListener(new l(this));
        this.f = TbadkApplication.m252getInst().getIsFirstUse();
        this.i.post(this.j);
        new m(this).start();
        MessageManager.getInstance().sendMessage(new CustomMessage(2008003, com.baidu.tbadk.core.frameworkData.a.START));
        if (TbConfig.getDebugSwitch()) {
            a();
        }
        if (!com.baidu.tbadk.core.util.x.a()) {
            TiebaStatic.file("no SD", "LogoActivity.onCreate");
        }
    }

    private void a() {
        startService(new Intent(this, SwitchDebugService.class));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_first", com.baidu.tbadk.core.atomData.aj.a);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && com.baidu.tbadk.core.atomData.aj.a) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (!this.g) {
            TbadkApplication.m252getInst().delLauchTime();
        }
        this.i.removeCallbacks(this.k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!com.baidu.tbadk.core.atomData.aj.a) {
            com.baidu.tbadk.core.atomData.aj.a = true;
            finish();
            return;
        }
        this.i.removeCallbacks(this.k);
        this.i.postDelayed(this.k, TbConfig.NOTIFY_SOUND_INTERVAL);
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
                                BdLog.e(getClass().getName(), "deleteAllfile", "list[i].delete error");
                            }
                        }
                    }
                } else if (!file.delete()) {
                    BdLog.e(getClass().getName(), "deleteAllfile", "file.delete error");
                }
            } catch (Exception e) {
                BdLog.e(getClass().getName(), "deleteAllfile", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c();
        com.baidu.tbadk.core.atomData.aj.a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        c();
        this.i.removeCallbacks(this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        this.i.removeCallbacks(this.k);
        b();
        if (com.baidu.tbadk.core.atomData.aj.b) {
            a(1);
            com.baidu.tbadk.core.atomData.aj.b = false;
        } else if (TbadkApplication.isLogin()) {
            if (this.f) {
                sendMessage(new CustomMessage(2017000, new com.baidu.tbadk.core.atomData.r(this).a("from_logo_page")));
                finish();
                return;
            }
            a(1);
        } else {
            this.h.a(this, null);
        }
    }

    private void b() {
        if (this.f) {
            com.baidu.tbadk.f.a().b("first_sync_image_quality", true);
            TbadkApplication.m252getInst().setIsAbstractOn(0);
            TbadkApplication.m252getInst().delLauchTime();
            com.baidu.tbadk.core.sharedPref.b.a().b("frs_first_in", true);
        }
    }

    private void a(int i) {
        this.h.a(this, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        com.baidu.tbadk.core.atomData.aj.a = false;
        this.g = true;
        sendMessage(new CustomMessage(2017001, new com.baidu.tbadk.core.atomData.ak(this).a(i)));
        finish();
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
        if (this.c != null) {
            this.c.setImageBitmap(null);
        }
        if (this.d != null && !this.d.isRecycled()) {
            this.d.recycle();
            this.d = null;
        }
    }
}
