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
import com.baidu.tieba.t;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private View aLk;
    private Bitmap aLl = null;
    private boolean aLm = false;
    private boolean aLn = true;
    private int aLo = -1;
    private Bitmap aLp = null;
    private boolean aLq = false;
    private boolean aLr = false;
    private CustomMessageListener aLs = new b(this, CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK);
    private a aLt = new a(this, null);
    private Runnable aLu = new c(this);
    private Runnable aLv = new e(this);
    private Runnable aLw = new f(this);
    private Runnable aLx = new i(this);
    private Runnable aLy = new k(this);
    private Runnable aLz = new m(this);
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
            LogoActivity.this.Je();
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
        av(getPageContext().getPageActivity());
        LogoActivityConfig.isFirst = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isTaskRoot() && !IX()) {
            finish();
            return;
        }
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m9getInst().onLowMemory();
        System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        }
        h(getIntent());
        getWindow().setFlags(1024, 1024);
        setContentView(t.h.logo_activity);
        this.mRootView = (RelativeLayout) findViewById(t.g.layout_root);
        if (bundle != null) {
            LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
        } else {
            LogoActivityConfig.isFirst = true;
        }
        this.aLm = TbadkCoreApplication.m9getInst().getIsFirstUse();
        com.baidu.tbadk.performanceLog.ab.Gv().bV(this.aLm);
        registerListener(this.aLs);
        IY();
        this.mHandler.sendMessage(this.mHandler.obtainMessage());
        HashMap hashMap = new HashMap();
        hashMap.put("type", IntentConfig.START);
        hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
            IZ();
        }
        if (!com.baidu.tbadk.core.util.m.cA()) {
            com.baidu.tbadk.core.util.TiebaStatic.file("no SD", "LogoActivity.onCreate");
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
        }
    }

    private boolean IX() {
        return getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
    }

    private void IY() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.oS(), getPageContext().getPageActivity());
        }
        av(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void IZ() {
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
            com.baidu.tbadk.performanceLog.ab.Gv().ab(System.currentTimeMillis());
        }
        if (this.aLn) {
            this.aLn = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.tS().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.m9getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.tS().getString("applist_intalled_apk_ids", ""));
            }
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
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aLt);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aLv);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aLw);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aLx);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aLy);
        com.baidu.adp.lib.h.h.eG().removeCallbacks(this.aLu);
        if (this.aLl != null && !this.aLl.isRecycled()) {
            this.aLl.recycle();
            this.aLl = null;
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

    private void av(Context context) {
        Ja();
        if (LogoActivityConfig.mFromSpacial) {
            fD(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            boolean OJ = com.baidu.tieba.d.a.OI().OJ();
            if (this.aLm) {
                com.baidu.adp.lib.h.h.eG().post(this.aLw);
            } else if (OJ) {
                com.baidu.adp.lib.h.h.eG().post(this.aLx);
            } else {
                fD(1);
            }
        } else if (this.aLm) {
            com.baidu.adp.lib.h.h.eG().post(this.aLw);
        } else {
            Jb();
        }
    }

    private void Ja() {
        if (this.aLm) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.m9getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("frs_first_in", true);
        }
    }

    private void Jb() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean Jd = Jd();
        this.aLp = Jh();
        com.baidu.tbadk.performanceLog.ab.Gv().ac(System.currentTimeMillis() - currentTimeMillis);
        if (Jd) {
            com.baidu.adp.lib.h.h.eG().post(this.aLv);
        } else {
            com.baidu.adp.lib.h.h.eG().post(this.aLy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jc() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_LOGO_OPEN, Boolean.class, getPageContext());
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        return ((Boolean) runTask.getData()).booleanValue();
    }

    private boolean Jd() {
        if (com.baidu.adp.lib.c.e.dN().ac("ad_baichuan_open") == 0) {
            return false;
        }
        int K = com.baidu.adp.lib.util.k.K(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH, View.class, new com.baidu.tbadk.coreExtra.data.e(getPageContext().getPageActivity(), (com.baidu.adp.lib.util.k.L(getPageContext().getPageActivity()) * 4) / 5, K));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.aLk = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Je() {
        if (this.aLo >= 0) {
            fE(this.aLo);
        } else if (!this.aLq || this.aLr) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
            finish();
        } else {
            com.baidu.adp.lib.h.h.eG().post(this.aLz);
        }
        com.baidu.tbadk.performanceLog.ab.Gv().ae(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jf() {
        com.baidu.tieba.tbadkCore.a.a(this, this.mRootView, t.a.fade_out_bg, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jg() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.m.getCacheDir());
        if (file.isDirectory() && (listFiles = file.listFiles(new o(this))) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void fD(int i) {
        this.aLo = i;
        Jb();
    }

    private void fE(int i) {
        LogoActivityConfig.isFirst = false;
        if (!this.aLq || this.aLr) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
            finish();
            return;
        }
        com.baidu.adp.lib.h.h.eG().post(this.aLz);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16001:
                    if (intent == null) {
                        fD(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        fD(intExtra);
                        return;
                    } else {
                        fD(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private Bitmap Jh() {
        Integer OL = com.baidu.tieba.d.a.OI().OL();
        if (OL == null || OL.intValue() == 0) {
            return null;
        }
        return BitmapHelper.getCashBitmap(OL.intValue());
    }
}
