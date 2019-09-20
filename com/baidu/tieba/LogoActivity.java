package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.lib.g.h;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.appsearchlib.NASLib;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.SecretHintActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.p.n;
import com.baidu.tieba.u.d;
import com.baidu.tieba.view.BesAdViewContainer;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private static final String cSB = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    private long cSF;
    private boolean cSH;
    private BesAdViewContainer cSM;
    private com.baidu.tieba.u.d cSN;
    private View cSO;
    private com.baidu.tbadk.g.c cSP;
    private com.baidu.tbadk.u.a cSQ;
    private RelativeLayout mRootView;
    private Bitmap cSC = null;
    private boolean cSD = false;
    private boolean cSE = true;
    private int cSG = -1;
    private boolean cSI = false;
    private boolean cSJ = false;
    private boolean cSK = true;
    private a cSL = new a();
    private com.baidu.tbadk.u.b cSR = new com.baidu.tbadk.u.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.u.b
        public void awj() {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(LogoActivity.this.cSY);
            LogoActivity.this.aBo();
        }

        @Override // com.baidu.tbadk.u.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(LogoActivity.this.cSY);
            if (LogoActivity.this.cSQ.getView() == null) {
                LogoActivity.this.aBs();
                return;
            }
            int af = l.af(LogoActivity.this.getPageContext().getPageActivity());
            int ah = l.ah(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                ah = (int) (l.ah(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.cSQ.getView().setLayoutParams(new RelativeLayout.LayoutParams(af, ah));
            LogoActivity.this.mRootView.addView(LogoActivity.this.cSQ.getView());
            if (LogoActivity.this.cSG == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
            }
            n.avN().by(System.currentTimeMillis());
            TiebaStatic.log(new an("c13331").bT(VideoPlayActivityConfig.OBJ_ID, str).P("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_exp");
            anVar.bT("page_type", "a030").P("obj_isad", 1).bT(VideoPlayActivityConfig.OBJ_ID, str).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            if (z) {
                anVar.P("obj_type", z2 ? 4 : 3);
            } else {
                anVar.P("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.q.c.cpt().a(LogoActivity.this.getUniqueId(), str, anVar);
            com.baidu.tieba.q.c.cpt().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.u.b
        public void aaX() {
            LogoActivity.this.cSJ = true;
            if (LogoActivity.this.cSK) {
                LogoActivity.this.aBs();
            }
        }

        @Override // com.baidu.tbadk.u.b
        public void U(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.cSQ.getView() != null) {
                z2 = LogoActivity.this.cSQ.getView().getHeight() == l.ah(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new an("c13332").bT(VideoPlayActivityConfig.OBJ_ID, str).P("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_click");
            anVar.bT("page_type", "a030").P("obj_isad", 1).bT(VideoPlayActivityConfig.OBJ_ID, str).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            if (z) {
                anVar.P("obj_type", z2 ? 4 : 3);
            } else {
                anVar.P("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.q.c.cpt().b(LogoActivity.this.getUniqueId(), anVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.aBs();
        }
    };
    private long cSS = -1;
    private d.a cST = new d.a() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // com.baidu.tieba.u.d.a
        public void onError() {
            LogoActivity.this.aBp();
        }

        @Override // com.baidu.tieba.u.d.a
        public void aBy() {
            if (LogoActivity.this.cSG != -2) {
                LogoActivity.this.aBr();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener cSU = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.aBi()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(LogoActivity.this.cSL);
                    LogoActivity.this.cSJ = true;
                    if (LogoActivity.this.cSK) {
                        LogoActivity.this.aBs();
                    }
                }
            }
        }
    };
    private Runnable cSV = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aBg();
        }
    };
    private Runnable cSW = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.aBq()) {
                LogoActivity.this.aBs();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
            LogoActivity.this.finish();
        }
    };
    private Runnable cSX = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.cSI) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.cSM);
                com.baidu.adp.lib.g.e.iK().post(LogoActivity.this.cSW);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable cSY = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aBp();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aBg() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.cSH = true;
            return;
        }
        if (MessageManager.getInstance().findTask(2015001) != null) {
            sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        h.iL().d(new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.aBu();
                LogoActivity.aBt();
            }
        });
        finish();
    }

    private void Y(Intent intent) {
        if (intent != null) {
            if (intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) {
                LogoActivityConfig.mFromSpacial = true;
                Intent intent2 = new Intent();
                intent2.putExtra(DealIntentService.KEY_CLASS, 2);
                intent2.putExtra(ImageViewerConfig.FORUM_NAME, intent.getStringExtra(ImageViewerConfig.FORUM_NAME));
                intent2.putExtra(FrsActivityConfig.FROM_SHORT_CUT, true);
                intent2.putExtra("back_special", true);
                intent2.putExtra("from", "short_cut");
                intent.putExtra(LogoActivityConfig.EXTRAINTENT, intent2);
            }
            TbadkCoreApplication.setIntent((Intent) intent.getParcelableExtra(LogoActivityConfig.EXTRAINTENT));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.cSS = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cpt().u(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (aBw()) {
            aBv();
        } else if (aBi()) {
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(1028);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.cSU);
                this.cSG = -2;
                aBn();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !aBh()) {
            finish();
        } else {
            TiebaStatic.log(new an("c11894").P("obj_param1", 2));
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
            }
            Y(getIntent());
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(1028);
            }
            setContentView(R.layout.logo_activity);
            this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
            this.cSD = TbadkCoreApplication.getInst().getIsFirstUse();
            n.avN().fJ(this.cSD);
            registerListener(this.cSU);
            aBj();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                aBk();
            }
            if (!m.gB()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean aBh() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new an("c11897").bT(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBi() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void aBj() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                com.baidu.tbadk.core.e.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.acn(), getPageContext().getPageActivity());
            }
        }
        cU(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z = false;
        super.onConfigurationChanged(configuration);
        if (this.cSQ != null && this.cSQ.getView() != null && this.cSQ.getView().getParent() != null) {
            if (this.cSQ.getView() != null) {
                if (this.cSQ.getView().getHeight() == l.ah(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int af = l.af(getPageContext().getPageActivity());
            int ah = l.ah(getPageContext().getPageActivity());
            if (!z) {
                ah = (int) (l.ah(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cSQ.getView().getLayoutParams();
            layoutParams.width = af;
            layoutParams.height = ah;
            this.cSQ.getView().setLayoutParams(layoutParams);
        }
        if (this.cSP != null && this.cSP.bCg != null) {
            this.cSP.bCg.onScreenSizeChanged();
        }
    }

    private void aBk() {
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
        this.cSK = false;
        if (this.cSN != null) {
            this.cSN.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cSK = true;
        if (this.cSE) {
            this.cSE = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.ahU().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.ahU().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.cSJ) {
            aBs();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.cSH) {
            aBg();
            this.cSH = false;
        }
        if (this.cSN != null) {
            this.cSN.onResume();
        }
        if (LogoActivityConfig.isFirst && this.cSS >= 0) {
            n.avN().bw(System.currentTimeMillis() - this.cSS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cSP != null) {
            this.cSP.l(null);
            this.cSP.a(null);
        }
        if (this.cSQ != null) {
            this.cSQ.release();
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cSL);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cSV);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cSW);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cSX);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cSY);
        if (this.cSN != null) {
            this.cSN.onDestroy();
        }
        if (this.cSC != null && !this.cSC.isRecycled()) {
            this.cSC.recycle();
            this.cSC = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.q.c.cpt().v(getUniqueId());
        com.baidu.adp.lib.util.d.jJ().clearCashBitmap();
    }

    private void cU(Context context) {
        aBl();
        if (LogoActivityConfig.mFromSpacial) {
            ml(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.cSD) {
                com.baidu.adp.lib.g.e.iK().post(this.cSV);
            } else {
                ml(1);
            }
        } else if (this.cSD) {
            com.baidu.adp.lib.g.e.iK().post(this.cSV);
        } else {
            aBm();
        }
    }

    private void aBl() {
        if (this.cSD) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("frs_first_in", true);
        }
    }

    private void aBm() {
        if (this.cSG != -2) {
            if (this.cSN == null) {
                this.cSN = new com.baidu.tieba.u.d(this);
            }
            if (this.cSN.cyR()) {
                this.cSO = this.cSN.o(0.8125d);
                this.mRootView.addView(this.cSO);
                this.cSN.a(this.cST);
                this.cSN.start();
                return;
            }
            this.cSN.cyW();
        }
        aBn();
    }

    private void aBn() {
        this.cSF = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.u.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.cSQ = (com.baidu.tbadk.u.a) runTask.getData();
            this.cSQ.a(this.cSR);
            this.cSQ.awi();
            n.avN().bx(System.currentTimeMillis() - this.cSF);
            int i = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(this.cSY, i * 1000);
            return;
        }
        aBo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBo() {
        int az = com.baidu.adp.lib.b.d.hS().az("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016555);
        if (az == 0 || findTask == null) {
            aBp();
        }
        this.cSF = System.currentTimeMillis();
        this.cSP = new com.baidu.tbadk.g.c();
        this.cSM = new BesAdViewContainer(getPageContext().getPageActivity());
        this.cSM.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.11
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.aBs();
            }
        });
        this.cSM.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.cSM);
        this.cSP.l(this.cSM);
        this.cSP.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.a
            public void lD(String str) {
                LogoActivity.this.cSI = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.cSM);
                LogoActivity.this.aBp();
            }

            @Override // com.baidu.tbadk.g.a
            public void j(boolean z, boolean z2) {
                LogoActivity.this.cSI = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new an("c13042").P("obj_type", z2 ? 2 : 1));
                an anVar = new an("common_exp");
                anVar.bT("page_type", "a030").P("obj_isad", 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1);
                if (z) {
                    anVar.P("obj_type", z2 ? 4 : 3);
                } else {
                    anVar.P("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.q.c.cpt().a(LogoActivity.this.getUniqueId(), "bes_ad_id", anVar);
                com.baidu.tieba.q.c.cpt().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.cSG == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.iK().removeCallbacks(LogoActivity.this.cSX);
                n.avN().by(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.g.a
            public void aaX() {
                LogoActivity.this.cSJ = true;
                if (LogoActivity.this.cSK) {
                    LogoActivity.this.aBs();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void k(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new an("c13043").P("obj_type", z2 ? 2 : 1));
                an anVar = new an("common_click");
                anVar.bT("page_type", "a030").P("obj_isad", 1).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 1);
                if (z) {
                    anVar.P("obj_type", z2 ? 4 : 3);
                } else {
                    anVar.P("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.q.c.cpt().b(LogoActivity.this.getUniqueId(), anVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.cSP));
        n.avN().bx(System.currentTimeMillis() - this.cSF);
        int i = com.baidu.tbadk.core.sharedPref.b.ahU().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.cSX, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBp() {
        if (this.cSG == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.iK().post(this.cSW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBq() {
        try {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016481, Boolean.class, 0);
            if (runTask == null || runTask.getData() == null) {
                return false;
            }
            return ((Boolean) runTask.getData()).booleanValue();
        } catch (Throwable th) {
            BdLog.e(th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBr() {
        if (this.cSG >= 0) {
            mm(this.cSG);
        } else if (this.cSG == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBs() {
        aBr();
        n.avN().bz(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aBt() {
        String str = cSB + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            m.A(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBu() {
        File[] listFiles;
        File file = new File(m.aij());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                String name = file2.getName();
                return !TextUtils.isEmpty(name) && name.contains(LogoActivity.this.getPageContext().getString(R.string.app_name)) && name.endsWith(".apk");
            }
        })) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    private void ml(int i) {
        this.cSG = i;
        aBm();
    }

    private void mm(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private void aBv() {
        sendMessage(new CustomMessage(2002001, new SecretHintActivityConfig(getPageContext().getPageActivity())));
        finish();
    }

    private boolean aBw() {
        return !com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("key_secret_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16001:
                    if (intent == null) {
                        ml(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        ml(intExtra);
                        return;
                    } else {
                        ml(1);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aBs();
        }
    }
}
