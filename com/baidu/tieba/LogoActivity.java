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
    private boolean akU;
    private boolean akV;
    private AlphaAnimation akW;
    private Animation.AnimationListener akX;
    private boolean akY;
    private boolean akZ;
    private ImageView alb;
    private SnowView alc;
    private ImageView ald;
    private ImageView ale;
    private Bitmap mBitmap;
    private a ala = new a();
    private final Handler mHandler = new g(this);
    private final Runnable alf = new h(this);
    private final Runnable alg = new i(this);
    private final d akN = new j(this);

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
        this.ala.a(this.akN);
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
        }
        H(getIntent());
        getWindow().setFlags(1024, 1024);
        if (!com.baidu.adp.lib.g.b.ei().a(getPageContext().getPageActivity(), x.logo_activity)) {
            finish();
            return;
        }
        vR();
        if (bundle != null) {
            LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
        } else {
            LogoActivityConfig.isFirst = true;
        }
        this.akW = new AlphaAnimation(1.0f, 1.0f);
        this.akW.setDuration(500L);
        this.akX = new k(this);
        this.akW.setAnimationListener(this.akX);
        this.akY = TbadkCoreApplication.m255getInst().getIsFirstUse();
        com.baidu.tbadk.performanceLog.ad.zw().aZ(this.akY);
        this.mHandler.post(this.alf);
        new l(this).start();
        MessageManager.getInstance().sendMessage(new CustomMessage(2006002, com.baidu.tbadk.core.frameworkData.a.START));
        if (TbConfig.getDebugSwitch()) {
            Av();
        }
        if (!com.baidu.tbadk.core.util.s.bL()) {
            TiebaStatic.file("no SD", "LogoActivity.onCreate");
        }
    }

    private void vR() {
        this.ale = (ImageView) findViewById(w.logo);
        this.ald = (ImageView) findViewById(w.logo_smoke);
        this.alb = (ImageView) findViewById(w.logo_post);
        int M = com.baidu.adp.lib.util.l.M(getActivity());
        int N = com.baidu.adp.lib.util.l.N(getActivity());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.alb.getLayoutParams();
        if (N <= 800) {
            layoutParams.setMargins((M * 48) / 480, (N * 154) / 800, 0, 0);
        } else {
            layoutParams.setMargins((M * 72) / 720, (N * 230) / 1280, 0, 0);
        }
        this.alb.setLayoutParams(layoutParams);
        this.alc = (SnowView) findViewById(w.logo_snow);
    }

    private void Av() {
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
        this.mHandler.removeCallbacks(this.alg);
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
        if (this.akZ) {
            this.mHandler.post(this.alg);
        } else {
            this.mHandler.removeCallbacks(this.alg);
            this.mHandler.postDelayed(this.alg, 3000L);
        }
        com.baidu.tbadk.performanceLog.ad.zw().y(System.currentTimeMillis());
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
        this.mHandler.removeCallbacks(this.alf);
        Az();
        LogoActivityConfig.isFirst = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Az();
        this.mHandler.removeCallbacks(this.alg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aw() {
        this.alb.setVisibility(8);
        this.alc.setVisibility(8);
        this.ald.setVisibility(8);
        this.mBitmap = new o().aj(getPageContext().getPageActivity());
        if (this.mBitmap != null && this.ale != null) {
            this.ale.setImageBitmap(this.mBitmap);
            startAnimation(this.ale, this.akW, this.akX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ai(Context context) {
        this.mHandler.removeCallbacks(this.alg);
        Ax();
        if (LogoActivityConfig.mFromSpacial) {
            ef(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.akY) {
                sendMessage(new CustomMessage(2015001, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
                com.baidu.adp.lib.g.l.ek().c(new m(this));
                finish();
                return;
            }
            ef(1);
        } else {
            this.ala.a(getPageContext().getPageActivity(), null);
        }
    }

    private void Ax() {
        if (this.akY) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.m255getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.oc().putBoolean("frs_first_in", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ay() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.s.on());
        if (file.isDirectory() && (listFiles = file.listFiles(new n(this))) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void ef(int i) {
        this.ala.a(getPageContext().getPageActivity(), Integer.valueOf(i));
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

    private void Az() {
        if (this.ale != null) {
            this.ale.setImageDrawable(null);
        }
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.ald != null) {
            this.ald.setBackgroundResource(0);
        }
        if (this.alb != null) {
            this.alb.setImageBitmap(null);
        }
        if (this.alc != null) {
            this.alc.AB();
        }
    }
}
