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
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.t;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private View aKp;
    private RelativeLayout mRootView;
    private Bitmap aKq = null;
    private boolean aKr = false;
    private boolean aKs = true;
    private int aKt = -1;
    private Bitmap aKu = null;
    private boolean aKv = false;
    private boolean aKw = false;
    private CustomMessageListener aKx = new b(this, CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK);
    private a aKy = new a(this, null);
    private Runnable aKz = new c(this);
    private Runnable aKA = new e(this);
    private Runnable aKB = new f(this);
    private Runnable aKC = new i(this);
    private Runnable aKD = new k(this);
    private Runnable aKE = new m(this);

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
            LogoActivity.this.Jr();
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
        ao(getPageContext().getPageActivity());
        LogoActivityConfig.isFirst = true;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isTaskRoot() && !Jl()) {
            finish();
            return;
        }
        setSwipeBackEnabled(false);
        TbadkCoreApplication.m411getInst().onLowMemory();
        System.currentTimeMillis();
        if (!TbadkCoreApplication.isLogin()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
        }
        g(getIntent());
        getWindow().setFlags(1024, 1024);
        setContentView(t.h.logo_activity);
        this.mRootView = (RelativeLayout) findViewById(t.g.layout_root);
        if (bundle != null) {
            LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
        } else {
            LogoActivityConfig.isFirst = true;
        }
        this.aKr = TbadkCoreApplication.m411getInst().getIsFirstUse();
        com.baidu.tbadk.performanceLog.ab.Ha().bL(this.aKr);
        registerListener(this.aKx);
        Jm();
        this.mHandler.sendMessage(this.mHandler.obtainMessage());
        HashMap hashMap = new HashMap();
        hashMap.put("type", IntentConfig.START);
        hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
        hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
            Jn();
        }
        if (!com.baidu.tbadk.core.util.m.fr()) {
            com.baidu.tbadk.core.util.TiebaStatic.file("no SD", "LogoActivity.onCreate");
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
        }
    }

    private boolean Jl() {
        return getIntent().getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
    }

    private void Jm() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.qQ(), getPageContext().getPageActivity());
        }
        ao(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    private void Jn() {
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
            com.baidu.tbadk.performanceLog.ab.Ha().Y(System.currentTimeMillis());
        }
        if (this.aKs) {
            this.aKs = false;
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
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.aKy);
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.aKA);
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.aKB);
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.aKC);
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.aKD);
        com.baidu.adp.lib.h.h.hx().removeCallbacks(this.aKz);
        if (this.aKq != null && !this.aKq.isRecycled()) {
            this.aKq.recycle();
            this.aKq = null;
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

    private void ao(Context context) {
        Jo();
        if (LogoActivityConfig.mFromSpacial) {
            fD(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            boolean Mx = com.baidu.tieba.a.a.Mw().Mx();
            if (this.aKr) {
                com.baidu.adp.lib.h.h.hx().post(this.aKB);
            } else if (Mx) {
                com.baidu.adp.lib.h.h.hx().post(this.aKC);
            } else {
                fD(1);
            }
        } else if (this.aKr) {
            com.baidu.adp.lib.h.h.hx().post(this.aKB);
        } else {
            Jp();
        }
    }

    private void Jo() {
        if (this.aKr) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.m411getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("frs_first_in", true);
        }
    }

    private void Jp() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean Jq = Jq();
        this.aKu = Ju();
        com.baidu.tbadk.performanceLog.ab.Ha().Z(System.currentTimeMillis() - currentTimeMillis);
        if (Jq) {
            com.baidu.adp.lib.h.h.hx().post(this.aKA);
        } else {
            com.baidu.adp.lib.h.h.hx().post(this.aKD);
        }
    }

    private boolean Jq() {
        if (com.baidu.adp.lib.c.e.gE().ai("ad_baichuan_open") == 0) {
            return false;
        }
        int B = com.baidu.adp.lib.util.k.B(getPageContext().getPageActivity());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADVERT_SDK_GET_SPLASH, View.class, new com.baidu.tbadk.coreExtra.data.a(getPageContext().getPageActivity(), (com.baidu.adp.lib.util.k.C(getPageContext().getPageActivity()) * 4) / 5, B));
        if (runTask == null || runTask.getData() == null) {
            return false;
        }
        this.aKp = (View) runTask.getData();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jr() {
        if (this.aKt >= 0) {
            fE(this.aKt);
        } else if (!this.aKv || this.aKw) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        } else {
            com.baidu.adp.lib.h.h.hx().post(this.aKE);
        }
        com.baidu.tbadk.performanceLog.ab.Ha().ab(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Js() {
        com.baidu.tieba.tbadkCore.a.a(this, this.mRootView, t.a.fade_out_bg, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jt() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.m.vs());
        if (file.isDirectory() && (listFiles = file.listFiles(new o(this))) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void fD(int i) {
        this.aKt = i;
        Jp();
    }

    private void fE(int i) {
        LogoActivityConfig.isFirst = false;
        if (!this.aKv || this.aKw) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
            finish();
            return;
        }
        com.baidu.adp.lib.h.h.hx().post(this.aKE);
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

    private Bitmap Ju() {
        Integer Mz = com.baidu.tieba.a.a.Mw().Mz();
        if (Mz == null || Mz.intValue() == 0) {
            return null;
        }
        return BitmapHelper.getCashBitmap(Mz.intValue());
    }
}
