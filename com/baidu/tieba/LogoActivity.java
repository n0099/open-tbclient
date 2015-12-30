package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.NASLib;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.performanceLog.z;
import com.baidu.tieba.n;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private Bitmap aGA = null;
    private boolean aGB = false;
    private boolean aGC = true;
    private int aGD = -1;
    private CustomMessageListener aGE = new b(this, CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK);
    private a aGF = new a(this, null);
    private Runnable aGG = new c(this);
    private Runnable aGH = new d(this);
    private Runnable aGI = new g(this);
    private View aGz;
    private RelativeLayout mRootView;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(LogoActivity logoActivity, a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.Gw();
        }
    }

    private void K(Intent intent) {
        if (intent != null) {
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
        K(intent);
        aq(getPageContext().getPageActivity());
        LogoActivityConfig.isFirst = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isTaskRoot() && !Gq()) {
            finish();
            return;
        }
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().onLowMemory();
        System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        }
        K(getIntent());
        getWindow().setFlags(1024, 1024);
        setContentView(n.h.logo_activity);
        this.mRootView = (RelativeLayout) findViewById(n.g.layout_root);
        if (bundle != null) {
            LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
        } else {
            LogoActivityConfig.isFirst = true;
        }
        this.aGB = TbadkCoreApplication.m411getInst().getIsFirstUse();
        z.EN().bD(this.aGB);
        registerListener(this.aGE);
        Gr();
        this.mHandler.sendMessage(this.mHandler.obtainMessage());
        HashMap hashMap = new HashMap();
        hashMap.put("type", IntentConfig.START);
        hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
            Gs();
        }
        if (!com.baidu.tbadk.core.util.n.fi()) {
            TiebaStatic.file("no SD", "LogoActivity.onCreate");
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
        }
    }

    private boolean Gq() {
        return getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
    }

    private void Gr() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.rc(), getPageContext().getPageActivity());
        }
        aq(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void Gs() {
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
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (LogoActivityConfig.isFirst) {
            z.EN().R(System.currentTimeMillis());
        }
        if (this.aGC) {
            this.aGC = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.h.h.hj().removeCallbacks(this.aGF);
        com.baidu.adp.lib.h.h.hj().removeCallbacks(this.aGG);
        com.baidu.adp.lib.h.h.hj().removeCallbacks(this.aGH);
        com.baidu.adp.lib.h.h.hj().removeCallbacks(this.aGI);
        if (this.aGA != null && !this.aGA.isRecycled()) {
            this.aGA.recycle();
            this.aGA = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    private void aq(Context context) {
        Gt();
        if (LogoActivityConfig.mFromSpacial) {
            eU(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.aGB) {
                com.baidu.adp.lib.h.h.hj().post(this.aGH);
            } else {
                eU(1);
            }
        } else {
            Gu();
        }
    }

    private void Gt() {
        if (this.aGB) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.m411getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("frs_first_in", true);
        }
    }

    private void Gu() {
        z.EN().S(System.currentTimeMillis() - System.currentTimeMillis());
        if (Gv()) {
            com.baidu.adp.lib.h.h.hj().post(this.aGG);
        } else {
            com.baidu.adp.lib.h.h.hj().post(this.aGI);
        }
    }

    private boolean Gv() {
        if (com.baidu.adp.lib.c.e.gw().aj("ad_baichuan_open") == 0) {
            return false;
        }
        int K = com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH, View.class, new com.baidu.tbadk.coreExtra.data.a(getPageContext().getPageActivity(), (com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity()) * 4) / 5, K));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.aGz = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gw() {
        if (this.aGD >= 0) {
            eV(this.aGD);
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
            finish();
        }
        z.EN().U(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gx() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.n.tS());
        if (file.isDirectory() && (listFiles = file.listFiles(new i(this))) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void eU(int i) {
        this.aGD = i;
        Gu();
    }

    private void eV(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16001:
                    if (intent == null) {
                        eU(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        eU(intExtra);
                        return;
                    } else {
                        eU(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
