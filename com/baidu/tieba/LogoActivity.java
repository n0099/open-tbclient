package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.debug.service.SwitchDebugService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.File;
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity {
    private Animation.AnimationListener acM;
    private long acQ;
    private long acR;
    private boolean acI = false;
    private boolean acJ = false;
    private ImageView acK = null;
    private Bitmap mBitmap = null;
    private AlphaAnimation acL = null;
    private boolean acN = false;
    private boolean acO = false;
    private a acP = new a();
    private final Handler mHandler = new g(this);
    private final Runnable acS = new h(this);
    private final Runnable acT = new i(this);
    private final d acA = new j(this);

    static {
        TbadkApplication.m251getInst().RegisterIntent(LogoActivityConfig.class, LogoActivity.class);
    }

    private void c(Intent intent) {
        if (intent != null) {
            BdLog.i("intent:" + intent);
            if (intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) {
                LogoActivityConfig.mFromSpacial = true;
                Intent intent2 = new Intent();
                intent2.putExtra("class", 2);
                intent2.putExtra(ImageViewerConfig.FORUM_NAME, intent.getStringExtra(ImageViewerConfig.FORUM_NAME));
                intent2.putExtra(FrsActivityConfig.FROM_SHORT_CUT, true);
                intent2.putExtra("back_special", true);
                intent2.putExtra("from", "short_cut");
                intent.putExtra(LogoActivityConfig.EXTRAINTENT, intent2);
            }
            TbadkApplication.setIntent((Intent) intent.getParcelableExtra(LogoActivityConfig.EXTRAINTENT));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        c(intent);
        L(getBaseContext());
        LogoActivityConfig.isFirst = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.acQ = System.currentTimeMillis();
        this.acP.a(this.acA);
        TbadkApplication.m251getInst().markLauchTime();
        if (!TbadkApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        }
        c(getIntent());
        getWindow().setFlags(1024, 1024);
        if (!com.baidu.adp.lib.g.b.ek().a(this, w.logo_activity)) {
            finish();
            return;
        }
        this.acK = (ImageView) findViewById(v.logo);
        if (bundle != null) {
            LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
        } else {
            LogoActivityConfig.isFirst = true;
        }
        this.acL = new AlphaAnimation(1.0f, 1.0f);
        this.acL.setDuration(500L);
        this.acM = new k(this);
        this.acL.setAnimationListener(this.acM);
        this.acN = TbadkApplication.m251getInst().getIsFirstUse();
        this.mHandler.post(this.acS);
        new l(this).start();
        MessageManager.getInstance().sendMessage(new CustomMessage(2006002, com.baidu.tbadk.core.frameworkData.a.START));
        if (TbConfig.getDebugSwitch()) {
            cz();
        }
        if (!com.baidu.tbadk.core.util.s.bm()) {
            TiebaStatic.file("no SD", "LogoActivity.onCreate");
        }
        this.acR = System.currentTimeMillis();
    }

    private void cz() {
        startService(new Intent(this, SwitchDebugService.class));
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_first", LogoActivityConfig.isFirst);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && LogoActivityConfig.isFirst) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (!this.acO) {
            TbadkApplication.m251getInst().delLauchTime();
        }
        this.mHandler.removeCallbacks(this.acT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        this.mHandler.removeCallbacks(this.acT);
        this.mHandler.postDelayed(this.acT, TbConfig.NOTIFY_SOUND_INTERVAL);
        com.baidu.tbadk.performanceLog.w.a(this.acQ - TbadkApplication.m251getInst().processCreateTime, this.acR - this.acQ, System.currentTimeMillis() - this.acR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(File file) {
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (int i = 0; i < listFiles.length; i++) {
                            if (listFiles[i].isDirectory()) {
                                q(listFiles[i]);
                            } else {
                                listFiles[i].delete();
                            }
                        }
                        return;
                    }
                    return;
                }
                file.delete();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.acS);
        wd();
        LogoActivityConfig.isFirst = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        wd();
        this.mHandler.removeCallbacks(this.acT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(Context context) {
        this.mHandler.removeCallbacks(this.acT);
        wb();
        if (LogoActivityConfig.mFromSpacial) {
            dw(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkApplication.isLogin()) {
            if (this.acN) {
                sendMessage(new CustomMessage(2015000, new GuildActivityConfig(this).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
                com.baidu.adp.lib.g.k.el().b(new m(this));
                finish();
                return;
            }
            dw(1);
        } else {
            this.acP.a(this, null);
        }
    }

    private void wb() {
        if (this.acN) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkApplication.m251getInst().setIsAbstractOn(0);
            TbadkApplication.m251getInst().delLauchTime();
            com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("frs_first_in", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wc() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.s.lw());
        if (file.isDirectory() && (listFiles = file.listFiles(new n(this))) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void dw(int i) {
        this.acP.a(this, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx(int i) {
        LogoActivityConfig.isFirst = false;
        this.acO = true;
        sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(this).createNormalCfg(i)));
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16001:
                    if (intent == null) {
                        dw(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        dw(intExtra);
                        return;
                    } else {
                        dw(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void wd() {
        if (this.acK != null) {
            this.acK.setImageDrawable(null);
        }
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
    }
}
