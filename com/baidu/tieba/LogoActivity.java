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
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.SecretHintActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
    private static final String cQe = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    private long cQi;
    private boolean cQk;
    private BesAdViewContainer cQp;
    private com.baidu.tieba.u.d cQq;
    private View cQr;
    private com.baidu.tbadk.g.c cQs;
    private com.baidu.tbadk.u.a cQt;
    private RelativeLayout mRootView;
    private Bitmap cQf = null;
    private boolean cQg = false;
    private boolean cQh = true;
    private int cQj = -1;
    private boolean cQl = false;
    private boolean cQm = false;
    private boolean cQn = true;
    private a cQo = new a();
    private com.baidu.tbadk.u.b cQu = new com.baidu.tbadk.u.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.u.b
        public void auM() {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(LogoActivity.this.cQB);
            LogoActivity.this.azK();
        }

        @Override // com.baidu.tbadk.u.b
        public void S(String str, boolean z) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(LogoActivity.this.cQB);
            if (LogoActivity.this.cQt.getView() == null) {
                LogoActivity.this.azO();
                return;
            }
            int af = l.af(LogoActivity.this.getPageContext().getPageActivity());
            int ah = l.ah(LogoActivity.this.getPageContext().getPageActivity());
            if (!z) {
                ah = (int) (l.ah(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.cQt.getView().setLayoutParams(new RelativeLayout.LayoutParams(af, ah));
            LogoActivity.this.mRootView.addView(LogoActivity.this.cQt.getView());
            if (LogoActivity.this.cQj == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
            }
            n.auq().bu(System.currentTimeMillis());
            TiebaStatic.log(new am("c13331").bT(VideoPlayActivityConfig.OBJ_ID, str).P("obj_type", z ? 2 : 1));
        }

        @Override // com.baidu.tbadk.u.b
        public void ZU() {
            LogoActivity.this.cQm = true;
            if (LogoActivity.this.cQn) {
                LogoActivity.this.azO();
            }
        }

        @Override // com.baidu.tbadk.u.b
        public void qJ(String str) {
            boolean z;
            if (LogoActivity.this.cQt.getView() != null) {
                z = LogoActivity.this.cQt.getView().getHeight() == l.ah(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z = false;
            }
            TiebaStatic.log(new am("c13332").bT(VideoPlayActivityConfig.OBJ_ID, str).P("obj_type", z ? 2 : 1));
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.azO();
        }
    };
    private long cQv = -1;
    private d.a cQw = new d.a() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // com.baidu.tieba.u.d.a
        public void onError() {
            LogoActivity.this.azL();
        }

        @Override // com.baidu.tieba.u.d.a
        public void azU() {
            if (LogoActivity.this.cQj != -2) {
                LogoActivity.this.azN();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener cQx = new CustomMessageListener(2016311) { // from class: com.baidu.tieba.LogoActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.azE()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.iB().removeCallbacks(LogoActivity.this.cQo);
                    LogoActivity.this.cQm = true;
                    if (LogoActivity.this.cQn) {
                        LogoActivity.this.azO();
                    }
                }
            }
        }
    };
    private Runnable cQy = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.azC();
        }
    };
    private Runnable cQz = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.azM()) {
                LogoActivity.this.azO();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016499, LogoActivity.this.getPageContext()));
            LogoActivity.this.finish();
        }
    };
    private Runnable cQA = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.cQl) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.cQp);
                com.baidu.adp.lib.g.e.iB().post(LogoActivity.this.cQz);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable cQB = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.azL();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void azC() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.cQk = true;
            return;
        }
        if (MessageManager.getInstance().findTask(2015001) != null) {
            sendMessage(new CustomMessage(2015001, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        h.iC().d(new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.azQ();
                LogoActivity.azP();
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
        this.cQv = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (azS()) {
            azR();
        } else if (azE()) {
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(1028);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
            try {
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.cQx);
                this.cQj = -2;
                azJ();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !azD()) {
            finish();
        } else {
            TiebaStatic.log(new am("c11894").P("obj_param1", 2));
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
            this.cQg = TbadkCoreApplication.getInst().getIsFirstUse();
            n.auq().fC(this.cQg);
            registerListener(this.cQx);
            azF();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", IntentConfig.START);
            hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
            if (MessageManager.getInstance().findTask(2010002) != null) {
                azG();
            }
            if (!m.gs()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(2001345) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean azD() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra(ImageViewerConfig.FORUM_NAME);
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new am("c11897").bT(ImageViewerConfig.FORUM_NAME, stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azE() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void azF() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && !getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
            TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.abk(), getPageContext().getPageActivity());
        }
        cT(getPageContext().getPageActivity());
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
        if (this.cQt != null && this.cQt.getView() != null && this.cQt.getView().getParent() != null) {
            if (this.cQt.getView() != null) {
                if (this.cQt.getView().getHeight() == l.ah(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int af = l.af(getPageContext().getPageActivity());
            int ah = l.ah(getPageContext().getPageActivity());
            if (!z) {
                ah = (int) (l.ah(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.cQt.getView().getLayoutParams();
            layoutParams.width = af;
            layoutParams.height = ah;
            this.cQt.getView().setLayoutParams(layoutParams);
        }
        if (this.cQs != null && this.cQs.bAL != null) {
            this.cQs.bAL.onScreenSizeChanged();
        }
    }

    private void azG() {
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
        this.cQn = false;
        if (this.cQq != null) {
            this.cQq.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.cQn = true;
        if (this.cQh) {
            this.cQh = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.agM().getLong("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.agM().getString("applist_intalled_apk_ids", ""));
            }
        }
        if (this.cQm) {
            azO();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.cQk) {
            azC();
            this.cQk = false;
        }
        if (this.cQq != null) {
            this.cQq.onResume();
        }
        if (LogoActivityConfig.isFirst && this.cQv >= 0) {
            n.auq().bs(System.currentTimeMillis() - this.cQv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.cQs != null) {
            this.cQs.l(null);
            this.cQs.a(null);
        }
        if (this.cQt != null) {
            this.cQt.release();
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cQo);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cQy);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cQz);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cQA);
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.cQB);
        if (this.cQq != null) {
            this.cQq.onDestroy();
        }
        if (this.cQf != null && !this.cQf.isRecycled()) {
            this.cQf.recycle();
            this.cQf = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.adp.lib.util.d.jA().clearCashBitmap();
    }

    private void cT(Context context) {
        azH();
        if (LogoActivityConfig.mFromSpacial) {
            lZ(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.cQg) {
                com.baidu.adp.lib.g.e.iB().post(this.cQy);
            } else {
                lZ(1);
            }
        } else if (this.cQg) {
            com.baidu.adp.lib.g.e.iB().post(this.cQy);
        } else {
            azI();
        }
    }

    private void azH() {
        if (this.cQg) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("frs_first_in", true);
        }
    }

    private void azI() {
        if (this.cQj != -2) {
            if (this.cQq == null) {
                this.cQq = new com.baidu.tieba.u.d(this);
            }
            if (this.cQq.cuT()) {
                this.cQr = this.cQq.o(0.8125d);
                this.mRootView.addView(this.cQr);
                this.cQq.a(this.cQw);
                this.cQq.start();
                return;
            }
            this.cQq.cuY();
        }
        azJ();
    }

    private void azJ() {
        this.cQi = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.u.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.cQt = (com.baidu.tbadk.u.a) runTask.getData();
            this.cQt.a(this.cQu);
            this.cQt.auL();
            n.auq().bt(System.currentTimeMillis() - this.cQi);
            int i = com.baidu.tbadk.core.sharedPref.b.agM().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.g.e.iB().postDelayed(this.cQB, i * 1000);
            return;
        }
        azK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azK() {
        int ay = com.baidu.adp.lib.b.d.hI().ay("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(2016310);
        if (ay == 0 || findTask == null) {
            azL();
        }
        this.cQi = System.currentTimeMillis();
        this.cQs = new com.baidu.tbadk.g.c();
        this.cQp = new BesAdViewContainer(getPageContext().getPageActivity());
        this.cQp.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.11
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.azO();
            }
        });
        this.cQp.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.cQp);
        this.cQs.l(this.cQp);
        this.cQs.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.a
            public void lt(String str) {
                LogoActivity.this.cQl = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.cQp);
                LogoActivity.this.azL();
            }

            @Override // com.baidu.tbadk.g.a
            public void du(boolean z) {
                LogoActivity.this.cQl = true;
                if (z) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                if (LogoActivity.this.cQj == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.iB().removeCallbacks(LogoActivity.this.cQA);
                n.auq().bu(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.g.a
            public void ZU() {
                LogoActivity.this.cQm = true;
                if (LogoActivity.this.cQn) {
                    LogoActivity.this.azO();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void tX() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2016555, this.cQs));
        n.auq().bt(System.currentTimeMillis() - this.cQi);
        int i = com.baidu.tbadk.core.sharedPref.b.agM().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.iB().postDelayed(this.cQA, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azL() {
        if (this.cQj == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.iB().post(this.cQz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azM() {
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
    public void azN() {
        if (this.cQj >= 0) {
            ma(this.cQj);
        } else if (this.cQj == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azO() {
        azN();
        n.auq().bv(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void azP() {
        String str = cQe + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            m.A(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azQ() {
        File[] listFiles;
        File file = new File(m.ahb());
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

    private void lZ(int i) {
        this.cQj = i;
        azI();
    }

    private void ma(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private void azR() {
        sendMessage(new CustomMessage(2002001, new SecretHintActivityConfig(getPageContext().getPageActivity())));
        finish();
    }

    private boolean azS() {
        return !com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_secret_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16001:
                    if (intent == null) {
                        lZ(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        lZ(intExtra);
                        return;
                    } else {
                        lZ(1);
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
            LogoActivity.this.azO();
        }
    }
}
