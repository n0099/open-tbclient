package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.File;
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private boolean akX;
    private boolean akY;
    private AlphaAnimation akZ;
    private Animation.AnimationListener ala;
    private boolean alb;
    private boolean alc;
    private ImageView ale;
    private SnowView alf;
    private ImageView alg;
    private ImageView alh;
    private Bitmap mBitmap;
    private a ald = new a();
    private final Handler mHandler = new g(this);
    private final Runnable ali = new h(this);
    private final Runnable alj = new i(this);
    private final d akQ = new j(this);

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
        this.ald.a(this.akQ);
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        }
        H(getIntent());
        getWindow().setFlags(1024, 1024);
        if (!com.baidu.adp.lib.g.b.ei().a(getPageContext().getPageActivity(), x.logo_activity)) {
            finish();
            return;
        }
        vX();
        if (bundle != null) {
            LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
        } else {
            LogoActivityConfig.isFirst = true;
        }
        this.akZ = new AlphaAnimation(1.0f, 1.0f);
        this.akZ.setDuration(500L);
        this.ala = new k(this);
        this.akZ.setAnimationListener(this.ala);
        this.alb = TbadkCoreApplication.m255getInst().getIsFirstUse();
        com.baidu.tbadk.performanceLog.ad.zC().aZ(this.alb);
        this.mHandler.post(this.ali);
        new l(this).start();
        MessageManager.getInstance().sendMessage(new CustomMessage(2006002, com.baidu.tbadk.core.frameworkData.a.START));
        if (TbConfig.getDebugSwitch()) {
            AB();
        }
        if (!com.baidu.tbadk.core.util.s.bL()) {
            TiebaStatic.file("no SD", "LogoActivity.onCreate");
        }
    }

    private void vX() {
        this.alh = (ImageView) findViewById(w.logo);
        this.alg = (ImageView) findViewById(w.logo_smoke);
        this.ale = (ImageView) findViewById(w.logo_post);
        int M = com.baidu.adp.lib.util.l.M(getActivity());
        int N = com.baidu.adp.lib.util.l.N(getActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ale.getLayoutParams();
        layoutParams.setMargins((M * 72) / 720, (N * 230) / 1280, 0, 0);
        this.ale.setLayoutParams(layoutParams);
        this.alf = (SnowView) findViewById(w.logo_snow);
    }

    private void AB() {
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
        this.mHandler.removeCallbacks(this.alj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.e("testxiaomilanuch", "logo activity onresume");
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.alc) {
            this.mHandler.post(this.alj);
        } else {
            this.mHandler.removeCallbacks(this.alj);
            this.mHandler.postDelayed(this.alj, 3000L);
        }
        com.baidu.tbadk.performanceLog.ad.zC().y(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(File file) {
        File[] listFiles;
        if (file != null) {
            try {
                if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (int i = 0; i < listFiles.length; i++) {
                        if (listFiles[i].isDirectory()) {
                            t(listFiles[i]);
                        }
                    }
                }
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.ali);
        AF();
        LogoActivityConfig.isFirst = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        AF();
        this.mHandler.removeCallbacks(this.alj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AC() {
        this.ale.setVisibility(8);
        this.alf.setVisibility(8);
        this.alg.setVisibility(8);
        this.mBitmap = new o().aj(getPageContext().getPageActivity());
        if (this.mBitmap != null && !this.mBitmap.isRecycled() && this.alh != null) {
            this.alh.setImageBitmap(this.mBitmap);
            startAnimation(this.alh, this.akZ, this.ala);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(Context context) {
        this.mHandler.removeCallbacks(this.alj);
        AD();
        if (LogoActivityConfig.mFromSpacial) {
            ef(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.alb) {
                sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                com.baidu.adp.lib.g.l.ek().c(new m(this));
                finish();
                return;
            }
            ef(1);
        } else {
            this.ald.a(getPageContext().getPageActivity(), null);
        }
    }

    private void AD() {
        if (this.alb) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.m255getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.oj().putBoolean("frs_first_in", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AE() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.s.ou());
        if (file.isDirectory() && (listFiles = file.listFiles(new n(this))) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void ef(int i) {
        this.ald.a(getPageContext().getPageActivity(), Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eg(int i) {
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
                        ef(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        ef(intExtra);
                        return;
                    } else {
                        ef(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void AF() {
        if (this.alh != null) {
            this.alh.setImageDrawable(null);
        }
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.alg != null) {
            this.alg.setBackgroundResource(0);
        }
        if (this.ale != null) {
            this.ale.setImageBitmap(null);
        }
        if (this.alf != null) {
            this.alf.AH();
        }
    }
}
