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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.u;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private View aHT;
    private Bitmap aHU = null;
    private boolean aHV = false;
    private boolean aHW = true;
    private int aHX = -1;
    private Bitmap aHY = null;
    private boolean aHZ = false;
    private boolean aIa = false;
    private CustomMessageListener aIb = new c(this, CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK);
    private a aIc = new a(this, null);
    private Runnable aId = new d(this);
    private Runnable aIe = new f(this);
    private Runnable aIf = new g(this);
    private Runnable aIg = new j(this);
    private Runnable aIh = new l(this);
    private Runnable aIi = new n(this);
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
            LogoActivity.this.HK();
        }
    }

    private void h(Intent intent) {
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
        h(intent);
        al(getPageContext().getPageActivity());
        LogoActivityConfig.isFirst = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isTaskRoot() && !HE()) {
            finish();
            return;
        }
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m10getInst().onLowMemory();
        System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        }
        h(getIntent());
        getWindow().setFlags(1024, 1024);
        setContentView(u.h.logo_activity);
        this.mRootView = (RelativeLayout) findViewById(u.g.layout_root);
        if (bundle != null) {
            LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
        } else {
            LogoActivityConfig.isFirst = true;
        }
        this.aHV = TbadkCoreApplication.m10getInst().getIsFirstUse();
        com.baidu.tbadk.performanceLog.ab.Fb().bT(this.aHV);
        registerListener(this.aIb);
        HF();
        this.mHandler.sendMessage(this.mHandler.obtainMessage());
        HashMap hashMap = new HashMap();
        hashMap.put("type", IntentConfig.START);
        hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
            HG();
        }
        if (!com.baidu.tbadk.core.util.m.bF()) {
            com.baidu.tbadk.core.util.TiebaStatic.file("no SD", "LogoActivity.onCreate");
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
        }
    }

    private boolean HE() {
        return getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
    }

    private void HF() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.nX(), getPageContext().getPageActivity());
        }
        al(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void HG() {
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
            com.baidu.tbadk.performanceLog.ab.Fb().X(System.currentTimeMillis());
        }
        if (this.aHW) {
            this.aHW = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
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
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aIc);
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aIe);
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aIf);
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aIg);
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aIh);
        com.baidu.adp.lib.h.h.dL().removeCallbacks(this.aId);
        if (this.aHU != null && !this.aHU.isRecycled()) {
            this.aHU.recycle();
            this.aHU = null;
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

    private void al(Context context) {
        HH();
        if (LogoActivityConfig.mFromSpacial) {
            fn(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            boolean Me = com.baidu.tieba.c.a.Md().Me();
            if (this.aHV) {
                com.baidu.adp.lib.h.h.dL().post(this.aIf);
            } else if (Me) {
                com.baidu.adp.lib.h.h.dL().post(this.aIg);
            } else {
                fn(1);
            }
        } else if (this.aHV) {
            com.baidu.adp.lib.h.h.dL().post(this.aIf);
        } else {
            HI();
        }
    }

    private void HH() {
        if (this.aHV) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.m10getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("frs_first_in", true);
        }
    }

    private void HI() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean HJ = HJ();
        this.aHY = HN();
        com.baidu.tbadk.performanceLog.ab.Fb().Y(System.currentTimeMillis() - currentTimeMillis);
        if (HJ) {
            com.baidu.adp.lib.h.h.dL().post(this.aIe);
        } else {
            com.baidu.adp.lib.h.h.dL().post(this.aIh);
        }
    }

    private boolean HJ() {
        if (com.baidu.adp.lib.c.e.cS().ab("ad_baichuan_open") == 0) {
            return false;
        }
        int A = com.baidu.adp.lib.util.k.A(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH, View.class, new com.baidu.tbadk.coreExtra.data.b(getPageContext().getPageActivity(), (com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity()) * 4) / 5, A));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.aHT = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HK() {
        if (this.aHX >= 0) {
            fo(this.aHX);
        } else if (!this.aHZ || this.aIa) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
            finish();
        } else {
            com.baidu.adp.lib.h.h.dL().post(this.aIi);
        }
        com.baidu.tbadk.performanceLog.ab.Fb().aa(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HL() {
        com.baidu.tieba.tbadkCore.a.a(this, this.mRootView, u.a.fade_out_bg, new o(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HM() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.m.getCacheDir());
        if (file.isDirectory() && (listFiles = file.listFiles(new p(this))) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void fn(int i) {
        this.aHX = i;
        HI();
    }

    private void fo(int i) {
        LogoActivityConfig.isFirst = false;
        if (!this.aHZ || this.aIa) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
            finish();
            return;
        }
        com.baidu.adp.lib.h.h.dL().post(this.aIi);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16001:
                    if (intent == null) {
                        fn(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        fn(intExtra);
                        return;
                    } else {
                        fn(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private Bitmap HN() {
        Integer Mg = com.baidu.tieba.c.a.Md().Mg();
        if (Mg == null || Mg.intValue() == 0) {
            return null;
        }
        return BitmapHelper.getCashBitmap(Mg.intValue());
    }
}
