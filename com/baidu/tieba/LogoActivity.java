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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.performanceLog.ad;
import java.io.File;
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private Animation.AnimationListener akx;
    private boolean akt = false;
    private boolean aku = false;
    private ImageView akv = null;
    private Bitmap mBitmap = null;
    private AlphaAnimation akw = null;
    private boolean aky = false;
    private a akz = new a();
    private final Handler mHandler = new g(this);
    private final Runnable akA = new h(this);
    private final Runnable akB = new i(this);
    private final d akm = new j(this);

    static {
        TbadkCoreApplication.m255getInst().RegisterIntent(LogoActivityConfig.class, LogoActivity.class);
    }

    private void H(Intent intent) {
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
            TbadkCoreApplication.setIntent((Intent) intent.getParcelableExtra(LogoActivityConfig.EXTRAINTENT));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        H(intent);
        ai(getBaseContext());
        LogoActivityConfig.isFirst = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        System.currentTimeMillis();
        this.akz.a(this.akm);
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        }
        H(getIntent());
        getWindow().setFlags(1024, 1024);
        if (!com.baidu.adp.lib.g.b.ek().a(getPageContext().getPageActivity(), x.logo_activity)) {
            finish();
            return;
        }
        this.akv = (ImageView) findViewById(w.logo);
        if (bundle != null) {
            LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
        } else {
            LogoActivityConfig.isFirst = true;
        }
        this.akw = new AlphaAnimation(1.0f, 1.0f);
        this.akw.setDuration(500L);
        this.akx = new k(this);
        this.akw.setAnimationListener(this.akx);
        this.aky = TbadkCoreApplication.m255getInst().getIsFirstUse();
        ad.zl().aX(this.aky);
        this.mHandler.post(this.akA);
        new l(this).start();
        MessageManager.getInstance().sendMessage(new CustomMessage(2006002, com.baidu.tbadk.core.frameworkData.a.START));
        if (TbConfig.getDebugSwitch()) {
            Ah();
        }
        if (!com.baidu.tbadk.core.util.s.bN()) {
            TiebaStatic.file("no SD", "LogoActivity.onCreate");
        }
    }

    private void Ah() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000996, new com.baidu.adp.a.a.c(getPageContext().getPageActivity())));
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
        this.mHandler.removeCallbacks(this.akB);
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
        this.mHandler.removeCallbacks(this.akB);
        this.mHandler.postDelayed(this.akB, TbConfig.NOTIFY_SOUND_INTERVAL);
        ad.zl().y(System.currentTimeMillis());
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
        this.mHandler.removeCallbacks(this.akA);
        Ak();
        LogoActivityConfig.isFirst = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Ak();
        this.mHandler.removeCallbacks(this.akB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(Context context) {
        this.mHandler.removeCallbacks(this.akB);
        Ai();
        if (LogoActivityConfig.mFromSpacial) {
            dZ(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.aky) {
                if (MessageManager.getInstance().findTask(2015000) != null) {
                    sendMessage(new CustomMessage(2015000, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
                } else {
                    sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                }
                com.baidu.adp.lib.g.l.em().c(new m(this));
                finish();
                return;
            }
            dZ(1);
        } else {
            this.akz.a(getPageContext().getPageActivity(), null);
        }
    }

    private void Ai() {
        if (this.aky) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.m255getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.og().putBoolean("frs_first_in", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aj() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.s.or());
        if (file.isDirectory() && (listFiles = file.listFiles(new n(this))) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void dZ(int i) {
        this.akz.a(getPageContext().getPageActivity(), Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16001:
                    if (intent == null) {
                        dZ(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        dZ(intExtra);
                        return;
                    } else {
                        dZ(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void Ak() {
        if (this.akv != null) {
            this.akv.setImageDrawable(null);
        }
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
    }
}
