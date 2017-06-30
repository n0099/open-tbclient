package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.NASLib;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.w;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private View aRJ;
    private boolean aRO;
    private RelativeLayout mRootView;
    private int aRI = 3100;
    private Bitmap aRK = null;
    private boolean aRL = false;
    private boolean aRM = true;
    private int aRN = -1;
    private CustomMessageListener aRP = new g(this, CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK);
    private a aRQ = new a(this, null);
    private Runnable aRR = new h(this);
    private Runnable aRS = new i(this);
    private Runnable aRT = new k(this);
    private Runnable aRU = new m(this);
    private Runnable aRV = new o(this);

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
            LogoActivity.this.JC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jt() {
        if (TbadkCoreApplication.m9getInst().getResumeNum() == 0) {
            this.aRO = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("has_shown_app_guide", false) ? 1 : 3)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        com.baidu.adp.lib.g.k.fS().f(new p(this));
        finish();
    }

    private void E(Intent intent) {
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
        E(intent);
        aW(getPageContext().getPageActivity());
        LogoActivityConfig.isFirst = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Jv()) {
            setSwipeBackEnabled(false);
            getWindow().setFlags(1024, 1024);
            try {
                setContentView(w.j.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(w.h.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.aRP);
                this.aRN = -2;
                Jz();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !Ju()) {
            finish();
        } else {
            TiebaStatic.log(new au("c11894").r("obj_param1", 2));
            setSwipeBackEnabled(false);
            TbadkCoreApplication.m9getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
            }
            E(getIntent());
            getWindow().setFlags(1024, 1024);
            setContentView(w.j.logo_activity);
            this.mRootView = (RelativeLayout) findViewById(w.h.layout_root);
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
            this.aRL = TbadkCoreApplication.m9getInst().getIsFirstUse();
            com.baidu.tbadk.j.ab.Gh().bY(this.aRL);
            registerListener(this.aRP);
            Jw();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                Jx();
            }
            if (!com.baidu.tbadk.core.util.n.dH()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean Ju() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new au("c11897").Z(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jv() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void Jw() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.oW(), getPageContext().getPageActivity());
        }
        aW(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void Jx() {
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
    public void onResume() {
        super.onResume();
        if (LogoActivityConfig.isFirst) {
            com.baidu.tbadk.j.ab.Gh().aa(System.currentTimeMillis());
        }
        if (this.aRM) {
            this.aRM = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.m9getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.getInstance().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
        } else if (this.aRO) {
            Jt();
            this.aRO = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.aRQ);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.aRR);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.aRS);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.aRT);
        com.baidu.adp.lib.g.h.fR().removeCallbacks(this.aRU);
        if (this.aRK != null && !this.aRK.isRecycled()) {
            this.aRK.recycle();
            this.aRK = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.gR().clearCashBitmap();
    }

    private void aW(Context context) {
        Jy();
        if (LogoActivityConfig.mFromSpacial) {
            fF(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.aRL) {
                com.baidu.adp.lib.g.h.fR().post(this.aRS);
            } else {
                fF(1);
            }
        } else if (this.aRL) {
            com.baidu.adp.lib.g.h.fR().post(this.aRS);
        } else {
            Jz();
        }
    }

    private void Jy() {
        if (this.aRL) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.m9getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("frs_first_in", true);
        }
    }

    private void Jz() {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH) == null) {
            Log.e("LogoActivity", "Advert sdk is not available now");
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean JB = JB();
        com.baidu.tbadk.j.ab.Gh().ab(System.currentTimeMillis() - currentTimeMillis);
        if (JB) {
            com.baidu.adp.lib.g.h.fR().post(this.aRR);
            if (this.aRN == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, this));
            }
        } else if (this.aRN == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.h.fR().post(this.aRU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean JA() {
        try {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN, Boolean.class, 0);
            if (runTask == null || runTask.getData() == null) {
                return false;
            }
            return ((Boolean) runTask.getData()).booleanValue();
        } catch (Exception e) {
            BdLog.e(e);
            return false;
        }
    }

    private boolean JB() {
        if (com.baidu.adp.lib.b.e.eY().ad("ad_baichuan_open") == 0) {
            return false;
        }
        int af = com.baidu.adp.lib.util.k.af(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH, View.class, new com.baidu.tbadk.coreExtra.data.e(getPageContext(), (int) (com.baidu.adp.lib.util.k.ag(getPageContext().getPageActivity()) * 0.8125d), af));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.aRJ = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JC() {
        if (this.aRN >= 0) {
            fG(this.aRN);
        } else if (this.aRN == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
        com.baidu.tbadk.j.ab.Gh().ad(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JD() {
        com.baidu.tieba.tbadkCore.a.a(this, this.mRootView, w.a.anim_alpha_1_to_0_duration_1500_accelerate, new q(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JE() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.n.uu());
        if (file.isDirectory() && (listFiles = file.listFiles(new r(this))) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void fF(int i) {
        this.aRN = i;
        Jz();
    }

    private void fG(int i) {
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
                        fF(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        fF(intExtra);
                        return;
                    } else {
                        fF(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
