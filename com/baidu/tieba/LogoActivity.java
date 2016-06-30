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
    private View aHc;
    private Bitmap aHd = null;
    private boolean aHe = false;
    private boolean aHf = true;
    private int aHg = -1;
    private Bitmap aHh = null;
    private boolean aHi = false;
    private boolean aHj = false;
    private CustomMessageListener aHk = new c(this, CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK);
    private a aHl = new a(this, null);
    private Runnable aHm = new d(this);
    private Runnable aHn = new f(this);
    private Runnable aHo = new g(this);
    private Runnable aHp = new j(this);
    private Runnable aHq = new l(this);
    private Runnable aHr = new n(this);
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
            LogoActivity.this.HM();
        }
    }

    private void g(Intent intent) {
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
        g(intent);
        al(getPageContext().getPageActivity());
        LogoActivityConfig.isFirst = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isTaskRoot() && !HG()) {
            finish();
            return;
        }
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m9getInst().onLowMemory();
        System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        }
        g(getIntent());
        getWindow().setFlags(1024, 1024);
        setContentView(u.h.logo_activity);
        this.mRootView = (RelativeLayout) findViewById(u.g.layout_root);
        if (bundle != null) {
            LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
        } else {
            LogoActivityConfig.isFirst = true;
        }
        this.aHe = TbadkCoreApplication.m9getInst().getIsFirstUse();
        com.baidu.tbadk.performanceLog.ab.Fc().bQ(this.aHe);
        registerListener(this.aHk);
        HH();
        this.mHandler.sendMessage(this.mHandler.obtainMessage());
        HashMap hashMap = new HashMap();
        hashMap.put("type", IntentConfig.START);
        hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
            HI();
        }
        if (!com.baidu.tbadk.core.util.m.bG()) {
            com.baidu.tbadk.core.util.TiebaStatic.file("no SD", "LogoActivity.onCreate");
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
        }
    }

    private boolean HG() {
        return getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
    }

    private void HH() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.oi(), getPageContext().getPageActivity());
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

    private void HI() {
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
            com.baidu.tbadk.performanceLog.ab.Fc().ac(System.currentTimeMillis());
        }
        if (this.aHf) {
            this.aHf = false;
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
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.aHl);
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.aHn);
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.aHo);
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.aHp);
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.aHq);
        com.baidu.adp.lib.h.h.dM().removeCallbacks(this.aHm);
        if (this.aHd != null && !this.aHd.isRecycled()) {
            this.aHd.recycle();
            this.aHd = null;
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
        HJ();
        if (LogoActivityConfig.mFromSpacial) {
            fo(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            boolean Mf = com.baidu.tieba.c.a.Me().Mf();
            if (this.aHe) {
                com.baidu.adp.lib.h.h.dM().post(this.aHo);
            } else if (Mf) {
                com.baidu.adp.lib.h.h.dM().post(this.aHp);
            } else {
                fo(1);
            }
        } else if (this.aHe) {
            com.baidu.adp.lib.h.h.dM().post(this.aHo);
        } else {
            HK();
        }
    }

    private void HJ() {
        if (this.aHe) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.m9getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.sO().putBoolean("frs_first_in", true);
        }
    }

    private void HK() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean HL = HL();
        this.aHh = HP();
        com.baidu.tbadk.performanceLog.ab.Fc().ad(System.currentTimeMillis() - currentTimeMillis);
        if (HL) {
            com.baidu.adp.lib.h.h.dM().post(this.aHn);
        } else {
            com.baidu.adp.lib.h.h.dM().post(this.aHq);
        }
    }

    private boolean HL() {
        if (com.baidu.adp.lib.c.e.cT().Z("ad_baichuan_open") == 0) {
            return false;
        }
        int A = com.baidu.adp.lib.util.k.A(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH, View.class, new com.baidu.tbadk.coreExtra.data.b(getPageContext().getPageActivity(), (com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity()) * 4) / 5, A));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.aHc = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HM() {
        if (this.aHg >= 0) {
            fp(this.aHg);
        } else if (!this.aHi || this.aHj) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_LOGO)));
            finish();
        } else {
            com.baidu.adp.lib.h.h.dM().post(this.aHr);
        }
        com.baidu.tbadk.performanceLog.ab.Fc().af(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HN() {
        com.baidu.tieba.tbadkCore.a.a(this, this.mRootView, u.a.fade_out_bg, new o(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HO() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.m.getCacheDir());
        if (file.isDirectory() && (listFiles = file.listFiles(new p(this))) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void fo(int i) {
        this.aHg = i;
        HK();
    }

    private void fp(int i) {
        LogoActivityConfig.isFirst = false;
        if (!this.aHi || this.aHj) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
            finish();
            return;
        }
        com.baidu.adp.lib.h.h.dM().post(this.aHr);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16001:
                    if (intent == null) {
                        fo(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        fo(intExtra);
                        return;
                    } else {
                        fo(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private Bitmap HP() {
        Integer Mh = com.baidu.tieba.c.a.Me().Mh();
        if (Mh == null || Mh.intValue() == 0) {
            return null;
        }
        return BitmapHelper.getCashBitmap(Mh.intValue());
    }
}
