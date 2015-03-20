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
import com.baidu.sapi2.SapiAccountManager;
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
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private Animation.AnimationListener atx;
    private boolean att = false;
    private boolean atu = false;
    private ImageView atv = null;
    private Bitmap mBitmap = null;
    private AlphaAnimation atw = null;
    private boolean aty = false;
    private a atz = new a();
    private final Handler mHandler = new f(this);
    private final Runnable atA = new g(this);
    private final Runnable atB = new h(this);
    private final d atn = new i(this);

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
        al(getBaseContext());
        LogoActivityConfig.isFirst = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().onLowMemory();
        System.currentTimeMillis();
        this.atz.a(this.atn);
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        }
        H(getIntent());
        getWindow().setFlags(1024, 1024);
        if (!com.baidu.adp.lib.g.b.hH().a(getPageContext().getPageActivity(), w.logo_activity)) {
            finish();
            return;
        }
        this.atv = (ImageView) findViewById(v.logo);
        if (bundle != null) {
            LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
        } else {
            LogoActivityConfig.isFirst = true;
        }
        this.atw = new AlphaAnimation(1.0f, 1.0f);
        this.atw.setDuration(500L);
        this.atx = new j(this);
        this.atw.setAnimationListener(this.atx);
        this.aty = TbadkCoreApplication.m411getInst().getIsFirstUse();
        com.baidu.tbadk.performanceLog.ai.CQ().be(this.aty);
        this.mHandler.post(this.atA);
        new k(this).start();
        HashMap hashMap = new HashMap();
        hashMap.put("type", com.baidu.tbadk.core.frameworkData.a.START);
        hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
        hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
        if (TbConfig.getDebugSwitch()) {
            DS();
        }
        if (!com.baidu.tbadk.core.util.o.fj()) {
            TiebaStatic.file("no SD", "LogoActivity.onCreate");
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    private void DS() {
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
        this.mHandler.removeCallbacks(this.atB);
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
        this.mHandler.removeCallbacks(this.atB);
        this.mHandler.postDelayed(this.atB, TbConfig.NOTIFY_SOUND_INTERVAL);
        com.baidu.tbadk.performanceLog.ai.CQ().y(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(File file) {
        if (file != null) {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (int i = 0; i < listFiles.length; i++) {
                            if (listFiles[i].isDirectory()) {
                                s(listFiles[i]);
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
        this.mHandler.removeCallbacks(this.atA);
        DV();
        LogoActivityConfig.isFirst = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        DV();
        this.mHandler.removeCallbacks(this.atB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap i(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                bitmap.recycle();
                return null;
            }
            return bitmap;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(Context context) {
        this.mHandler.removeCallbacks(this.atB);
        DT();
        if (LogoActivityConfig.mFromSpacial) {
            ej(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.aty) {
                if (MessageManager.getInstance().findTask(2015000) != null) {
                    sendMessage(new CustomMessage(2015000, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE)));
                } else {
                    sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                }
                com.baidu.adp.lib.g.l.hJ().c(new l(this));
                finish();
                return;
            }
            ej(1);
        } else {
            this.atz.a(getPageContext().getPageActivity(), null);
        }
    }

    private void DT() {
        if (this.aty) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.m411getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("frs_first_in", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DU() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.o.rK());
        if (file.isDirectory() && (listFiles = file.listFiles(new m(this))) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void ej(int i) {
        this.atz.a(getPageContext().getPageActivity(), Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ek(int i) {
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
                        ej(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        ej(intExtra);
                        return;
                    } else {
                        ej(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void DV() {
        if (this.atv != null) {
            this.atv.setImageDrawable(null);
        }
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
    }
}
