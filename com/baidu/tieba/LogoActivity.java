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
    private static final String cRB = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    private long cRF;
    private boolean cRH;
    private BesAdViewContainer cRM;
    private com.baidu.tieba.u.d cRN;
    private View cRO;
    private com.baidu.tbadk.g.c cRP;
    private com.baidu.tbadk.u.a cRQ;
    private RelativeLayout mRootView;
    private Bitmap cRC = null;
    private boolean cRD = false;
    private boolean cRE = true;
    private int cRG = -1;
    private boolean cRI = false;
    private boolean cRJ = false;
    private boolean cRK = true;
    private a cRL = new a();
    private com.baidu.tbadk.u.b cRR = new com.baidu.tbadk.u.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.u.b
        public void avV() {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(LogoActivity.this.cRY);
            LogoActivity.this.aAY();
        }

        @Override // com.baidu.tbadk.u.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(LogoActivity.this.cRY);
            if (LogoActivity.this.cRQ.getView() == null) {
                LogoActivity.this.aBc();
                return;
            }
            int af = l.af(LogoActivity.this.getPageContext().getPageActivity());
            int ah = l.ah(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                ah = (int) (l.ah(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.cRQ.getView().setLayoutParams(new RelativeLayout.LayoutParams(af, ah));
            LogoActivity.this.mRootView.addView(LogoActivity.this.cRQ.getView());
            if (LogoActivity.this.cRG == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
            }
            n.avz().bv(System.currentTimeMillis());
            TiebaStatic.log(new an("c13331").bT(VideoPlayActivityConfig.OBJ_ID, str).P("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_exp");
            anVar.bT("page_type", "a030").P("obj_isad", 1).bT(VideoPlayActivityConfig.OBJ_ID, str).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            if (z) {
                anVar.P("obj_type", z2 ? 4 : 3);
            } else {
                anVar.P("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.q.c.coo().a(LogoActivity.this.getUniqueId(), str, anVar);
            com.baidu.tieba.q.c.coo().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.u.b
        public void aaT() {
            LogoActivity.this.cRJ = true;
            if (LogoActivity.this.cRK) {
                LogoActivity.this.aBc();
            }
        }

        @Override // com.baidu.tbadk.u.b
        public void U(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.cRQ.getView() != null) {
                z2 = LogoActivity.this.cRQ.getView().getHeight() == l.ah(LogoActivity.this.getPageContext().getPageActivity());
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
            com.baidu.tieba.q.c.coo().b(LogoActivity.this.getUniqueId(), anVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.aBc();
        }
    };
    private long cRS = -1;
    private d.a cRT = new d.a() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // com.baidu.tieba.u.d.a
        public void onError() {
            LogoActivity.this.aAZ();
        }

        @Override // com.baidu.tieba.u.d.a
        public void aBi() {
            if (LogoActivity.this.cRG != -2) {
                LogoActivity.this.aBb();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener cRU = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.aAS()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(LogoActivity.this.cRL);
                    LogoActivity.this.cRJ = true;
                    if (LogoActivity.this.cRK) {
                        LogoActivity.this.aBc();
                    }
                }
            }
        }
    };
    private Runnable cRV = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aAQ();
        }
    };
    private Runnable cRW = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.aBa()) {
                LogoActivity.this.aBc();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
            LogoActivity.this.finish();
        }
    };
    private Runnable cRX = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.cRI) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.cRM);
                com.baidu.adp.lib.g.e.iK().post(LogoActivity.this.cRW);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable cRY = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aAZ();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aAQ() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.cRH = true;
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
                LogoActivity.this.aBe();
                LogoActivity.aBd();
            }
        });
        finish();
    }

    private void W(Intent intent) {
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
        this.cRS = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.q.c.coo().u(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (aBg()) {
            aBf();
        } else if (aAS()) {
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(1028);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.cRU);
                this.cRG = -2;
                aAX();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !aAR()) {
            finish();
        } else {
            TiebaStatic.log(new an("c11894").P("obj_param1", 2));
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
            }
            W(getIntent());
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
            this.cRD = TbadkCoreApplication.getInst().getIsFirstUse();
            n.avz().fG(this.cRD);
            registerListener(this.cRU);
            aAT();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                aAU();
            }
            if (!m.gB()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean aAR() {
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
    public boolean aAS() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void aAT() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                com.baidu.tbadk.core.e.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.acj(), getPageContext().getPageActivity());
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
        if (this.cRQ != null && this.cRQ.getView() != null && this.cRQ.getView().getParent() != null) {
            if (this.cRQ.getView() != null) {
                if (this.cRQ.getView().getHeight() == l.ah(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int af = l.af(getPageContext().getPageActivity());
            int ah = l.ah(getPageContext().getPageActivity());
            if (!z) {
                ah = (int) (l.ah(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cRQ.getView().getLayoutParams();
            layoutParams.width = af;
            layoutParams.height = ah;
            this.cRQ.getView().setLayoutParams(layoutParams);
        }
        if (this.cRP != null && this.cRP.bBI != null) {
            this.cRP.bBI.onScreenSizeChanged();
        }
    }

    private void aAU() {
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
        this.cRK = false;
        if (this.cRN != null) {
            this.cRN.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cRK = true;
        if (this.cRE) {
            this.cRE = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.ahO().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.ahO().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.cRJ) {
            aBc();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.cRH) {
            aAQ();
            this.cRH = false;
        }
        if (this.cRN != null) {
            this.cRN.onResume();
        }
        if (LogoActivityConfig.isFirst && this.cRS >= 0) {
            n.avz().bt(System.currentTimeMillis() - this.cRS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cRP != null) {
            this.cRP.l(null);
            this.cRP.a(null);
        }
        if (this.cRQ != null) {
            this.cRQ.release();
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cRL);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cRV);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cRW);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cRX);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cRY);
        if (this.cRN != null) {
            this.cRN.onDestroy();
        }
        if (this.cRC != null && !this.cRC.isRecycled()) {
            this.cRC.recycle();
            this.cRC = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.q.c.coo().v(getUniqueId());
        com.baidu.adp.lib.util.d.jJ().clearCashBitmap();
    }

    private void cU(Context context) {
        aAV();
        if (LogoActivityConfig.mFromSpacial) {
            mg(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.cRD) {
                com.baidu.adp.lib.g.e.iK().post(this.cRV);
            } else {
                mg(1);
            }
        } else if (this.cRD) {
            com.baidu.adp.lib.g.e.iK().post(this.cRV);
        } else {
            aAW();
        }
    }

    private void aAV() {
        if (this.cRD) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("frs_first_in", true);
        }
    }

    private void aAW() {
        if (this.cRG != -2) {
            if (this.cRN == null) {
                this.cRN = new com.baidu.tieba.u.d(this);
            }
            if (this.cRN.cxH()) {
                this.cRO = this.cRN.o(0.8125d);
                this.mRootView.addView(this.cRO);
                this.cRN.a(this.cRT);
                this.cRN.start();
                return;
            }
            this.cRN.cxM();
        }
        aAX();
    }

    private void aAX() {
        this.cRF = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.u.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.cRQ = (com.baidu.tbadk.u.a) runTask.getData();
            this.cRQ.a(this.cRR);
            this.cRQ.avU();
            n.avz().bu(System.currentTimeMillis() - this.cRF);
            int i = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(this.cRY, i * 1000);
            return;
        }
        aAY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAY() {
        int az = com.baidu.adp.lib.b.d.hS().az("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016555);
        if (az == 0 || findTask == null) {
            aAZ();
        }
        this.cRF = System.currentTimeMillis();
        this.cRP = new com.baidu.tbadk.g.c();
        this.cRM = new BesAdViewContainer(getPageContext().getPageActivity());
        this.cRM.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.11
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.aBc();
            }
        });
        this.cRM.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.cRM);
        this.cRP.l(this.cRM);
        this.cRP.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.a
            public void lB(String str) {
                LogoActivity.this.cRI = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.cRM);
                LogoActivity.this.aAZ();
            }

            @Override // com.baidu.tbadk.g.a
            public void j(boolean z, boolean z2) {
                LogoActivity.this.cRI = true;
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
                com.baidu.tieba.q.c.coo().a(LogoActivity.this.getUniqueId(), "bes_ad_id", anVar);
                com.baidu.tieba.q.c.coo().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.cRG == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.iK().removeCallbacks(LogoActivity.this.cRX);
                n.avz().bv(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.g.a
            public void aaT() {
                LogoActivity.this.cRJ = true;
                if (LogoActivity.this.cRK) {
                    LogoActivity.this.aBc();
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
                com.baidu.tieba.q.c.coo().b(LogoActivity.this.getUniqueId(), anVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.cRP));
        n.avz().bu(System.currentTimeMillis() - this.cRF);
        int i = com.baidu.tbadk.core.sharedPref.b.ahO().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.cRX, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAZ() {
        if (this.cRG == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.iK().post(this.cRW);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBa() {
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
    public void aBb() {
        if (this.cRG >= 0) {
            mh(this.cRG);
        } else if (this.cRG == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBc() {
        aBb();
        n.avz().bw(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aBd() {
        String str = cRB + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            m.A(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBe() {
        File[] listFiles;
        File file = new File(m.aid());
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

    private void mg(int i) {
        this.cRG = i;
        aAW();
    }

    private void mh(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private void aBf() {
        sendMessage(new CustomMessage(2002001, new SecretHintActivityConfig(getPageContext().getPageActivity())));
        finish();
    }

    private boolean aBg() {
        return !com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("key_secret_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16001:
                    if (intent == null) {
                        mg(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        mg(intExtra);
                        return;
                    } else {
                        mg(1);
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
            LogoActivity.this.aBc();
        }
    }
}
