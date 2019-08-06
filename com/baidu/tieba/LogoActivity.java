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
    private static final String cRI = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    private long cRM;
    private boolean cRO;
    private BesAdViewContainer cRT;
    private com.baidu.tieba.u.d cRU;
    private View cRV;
    private com.baidu.tbadk.g.c cRW;
    private com.baidu.tbadk.u.a cRX;
    private RelativeLayout mRootView;
    private Bitmap cRJ = null;
    private boolean cRK = false;
    private boolean cRL = true;
    private int cRN = -1;
    private boolean cRP = false;
    private boolean cRQ = false;
    private boolean cRR = true;
    private a cRS = new a();
    private com.baidu.tbadk.u.b cRY = new com.baidu.tbadk.u.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.u.b
        public void avX() {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(LogoActivity.this.cSf);
            LogoActivity.this.aBa();
        }

        @Override // com.baidu.tbadk.u.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(LogoActivity.this.cSf);
            if (LogoActivity.this.cRX.getView() == null) {
                LogoActivity.this.aBe();
                return;
            }
            int af = l.af(LogoActivity.this.getPageContext().getPageActivity());
            int ah = l.ah(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                ah = (int) (l.ah(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.cRX.getView().setLayoutParams(new RelativeLayout.LayoutParams(af, ah));
            LogoActivity.this.mRootView.addView(LogoActivity.this.cRX.getView());
            if (LogoActivity.this.cRN == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
            }
            n.avB().bv(System.currentTimeMillis());
            TiebaStatic.log(new an("c13331").bT(VideoPlayActivityConfig.OBJ_ID, str).P("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_exp");
            anVar.bT("page_type", "a030").P("obj_isad", 1).bT(VideoPlayActivityConfig.OBJ_ID, str).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, 2);
            if (z) {
                anVar.P("obj_type", z2 ? 4 : 3);
            } else {
                anVar.P("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.q.c.coG().a(LogoActivity.this.getUniqueId(), str, anVar);
            com.baidu.tieba.q.c.coG().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.u.b
        public void aaT() {
            LogoActivity.this.cRQ = true;
            if (LogoActivity.this.cRR) {
                LogoActivity.this.aBe();
            }
        }

        @Override // com.baidu.tbadk.u.b
        public void U(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.cRX.getView() != null) {
                z2 = LogoActivity.this.cRX.getView().getHeight() == l.ah(LogoActivity.this.getPageContext().getPageActivity());
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
            com.baidu.tieba.q.c.coG().b(LogoActivity.this.getUniqueId(), anVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.aBe();
        }
    };
    private long cRZ = -1;
    private d.a cSa = new d.a() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // com.baidu.tieba.u.d.a
        public void onError() {
            LogoActivity.this.aBb();
        }

        @Override // com.baidu.tieba.u.d.a
        public void aBk() {
            if (LogoActivity.this.cRN != -2) {
                LogoActivity.this.aBd();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener cSb = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.aAU()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.iK().removeCallbacks(LogoActivity.this.cRS);
                    LogoActivity.this.cRQ = true;
                    if (LogoActivity.this.cRR) {
                        LogoActivity.this.aBe();
                    }
                }
            }
        }
    };
    private Runnable cSc = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aAS();
        }
    };
    private Runnable cSd = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.aBc()) {
                LogoActivity.this.aBe();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
            LogoActivity.this.finish();
        }
    };
    private Runnable cSe = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.cRP) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.cRT);
                com.baidu.adp.lib.g.e.iK().post(LogoActivity.this.cSd);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable cSf = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aBb();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aAS() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.cRO = true;
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
                LogoActivity.this.aBg();
                LogoActivity.aBf();
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
        this.cRZ = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.q.c.coG().u(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (aBi()) {
            aBh();
        } else if (aAU()) {
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(1028);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.cSb);
                this.cRN = -2;
                aAZ();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !aAT()) {
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
            this.cRK = TbadkCoreApplication.getInst().getIsFirstUse();
            n.avB().fG(this.cRK);
            registerListener(this.cSb);
            aAV();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                aAW();
            }
            if (!m.gB()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean aAT() {
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
    public boolean aAU() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void aAV() {
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
        if (this.cRX != null && this.cRX.getView() != null && this.cRX.getView().getParent() != null) {
            if (this.cRX.getView() != null) {
                if (this.cRX.getView().getHeight() == l.ah(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int af = l.af(getPageContext().getPageActivity());
            int ah = l.ah(getPageContext().getPageActivity());
            if (!z) {
                ah = (int) (l.ah(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cRX.getView().getLayoutParams();
            layoutParams.width = af;
            layoutParams.height = ah;
            this.cRX.getView().setLayoutParams(layoutParams);
        }
        if (this.cRW != null && this.cRW.bBI != null) {
            this.cRW.bBI.onScreenSizeChanged();
        }
    }

    private void aAW() {
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
        this.cRR = false;
        if (this.cRU != null) {
            this.cRU.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cRR = true;
        if (this.cRL) {
            this.cRL = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.ahQ().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.ahQ().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.cRQ) {
            aBe();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.cRO) {
            aAS();
            this.cRO = false;
        }
        if (this.cRU != null) {
            this.cRU.onResume();
        }
        if (LogoActivityConfig.isFirst && this.cRZ >= 0) {
            n.avB().bt(System.currentTimeMillis() - this.cRZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cRW != null) {
            this.cRW.l(null);
            this.cRW.a(null);
        }
        if (this.cRX != null) {
            this.cRX.release();
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cRS);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cSc);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cSd);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cSe);
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.cSf);
        if (this.cRU != null) {
            this.cRU.onDestroy();
        }
        if (this.cRJ != null && !this.cRJ.isRecycled()) {
            this.cRJ.recycle();
            this.cRJ = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.q.c.coG().v(getUniqueId());
        com.baidu.adp.lib.util.d.jJ().clearCashBitmap();
    }

    private void cU(Context context) {
        aAX();
        if (LogoActivityConfig.mFromSpacial) {
            mh(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.cRK) {
                com.baidu.adp.lib.g.e.iK().post(this.cSc);
            } else {
                mh(1);
            }
        } else if (this.cRK) {
            com.baidu.adp.lib.g.e.iK().post(this.cSc);
        } else {
            aAY();
        }
    }

    private void aAX() {
        if (this.cRK) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.ahQ().putBoolean("frs_first_in", true);
        }
    }

    private void aAY() {
        if (this.cRN != -2) {
            if (this.cRU == null) {
                this.cRU = new com.baidu.tieba.u.d(this);
            }
            if (this.cRU.cyd()) {
                this.cRV = this.cRU.o(0.8125d);
                this.mRootView.addView(this.cRV);
                this.cRU.a(this.cSa);
                this.cRU.start();
                return;
            }
            this.cRU.cyi();
        }
        aAZ();
    }

    private void aAZ() {
        this.cRM = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.u.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.cRX = (com.baidu.tbadk.u.a) runTask.getData();
            this.cRX.a(this.cRY);
            this.cRX.avW();
            n.avB().bu(System.currentTimeMillis() - this.cRM);
            int i = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.g.e.iK().postDelayed(this.cSf, i * 1000);
            return;
        }
        aBa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBa() {
        int az = com.baidu.adp.lib.b.d.hS().az("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016555);
        if (az == 0 || findTask == null) {
            aBb();
        }
        this.cRM = System.currentTimeMillis();
        this.cRW = new com.baidu.tbadk.g.c();
        this.cRT = new BesAdViewContainer(getPageContext().getPageActivity());
        this.cRT.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.11
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.aBe();
            }
        });
        this.cRT.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.cRT);
        this.cRW.l(this.cRT);
        this.cRW.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.a
            public void lB(String str) {
                LogoActivity.this.cRP = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.cRT);
                LogoActivity.this.aBb();
            }

            @Override // com.baidu.tbadk.g.a
            public void j(boolean z, boolean z2) {
                LogoActivity.this.cRP = true;
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
                com.baidu.tieba.q.c.coG().a(LogoActivity.this.getUniqueId(), "bes_ad_id", anVar);
                com.baidu.tieba.q.c.coG().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.cRN == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.iK().removeCallbacks(LogoActivity.this.cSe);
                n.avB().bv(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.g.a
            public void aaT() {
                LogoActivity.this.cRQ = true;
                if (LogoActivity.this.cRR) {
                    LogoActivity.this.aBe();
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
                com.baidu.tieba.q.c.coG().b(LogoActivity.this.getUniqueId(), anVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.cRW));
        n.avB().bu(System.currentTimeMillis() - this.cRM);
        int i = com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.iK().postDelayed(this.cSe, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBb() {
        if (this.cRN == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.iK().post(this.cSd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBc() {
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
    public void aBd() {
        if (this.cRN >= 0) {
            mi(this.cRN);
        } else if (this.cRN == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBe() {
        aBd();
        n.avB().bw(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aBf() {
        String str = cRI + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            m.A(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBg() {
        File[] listFiles;
        File file = new File(m.aif());
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

    private void mh(int i) {
        this.cRN = i;
        aAY();
    }

    private void mi(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private void aBh() {
        sendMessage(new CustomMessage(2002001, new SecretHintActivityConfig(getPageContext().getPageActivity())));
        finish();
    }

    private boolean aBi() {
        return !com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("key_secret_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16001:
                    if (intent == null) {
                        mh(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        mh(intExtra);
                        return;
                    } else {
                        mh(1);
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
            LogoActivity.this.aBe();
        }
    }
}
