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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.SecretHintActivityConfig;
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
    private static final String dbe = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    private long dbi;
    private boolean dbk;
    private BesAdViewContainer dbp;
    private com.baidu.tieba.u.d dbq;
    private View dbr;
    private com.baidu.tbadk.g.c dbs;
    private com.baidu.tbadk.u.a dbt;
    private RelativeLayout mRootView;
    private Bitmap dbf = null;
    private boolean dbg = false;
    private boolean dbh = true;
    private int dbj = -1;
    private boolean dbl = false;
    private boolean dbm = false;
    private boolean dbn = true;
    private a dbo = new a();
    private com.baidu.tbadk.u.b dbu = new com.baidu.tbadk.u.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.u.b
        public void axm() {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(LogoActivity.this.dbB);
            LogoActivity.this.aBx();
        }

        @Override // com.baidu.tbadk.u.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.g.e.fZ().removeCallbacks(LogoActivity.this.dbB);
            if (LogoActivity.this.dbt.getView() == null) {
                LogoActivity.this.aBB();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.dbt.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.dbt.getView());
            if (LogoActivity.this.dbj == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.awQ().bm(System.currentTimeMillis());
            TiebaStatic.log(new an("c13331").bS("obj_id", str).O("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_exp");
            anVar.bS("page_type", "a030").O("obj_isad", 1).bS("obj_id", str).O("obj_source", 2);
            if (z) {
                anVar.O("obj_type", z2 ? 4 : 3);
            } else {
                anVar.O("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.q.c.cni().a(LogoActivity.this.getUniqueId(), str, anVar);
            com.baidu.tieba.q.c.cni().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.u.b
        public void afB() {
            LogoActivity.this.dbm = true;
            if (LogoActivity.this.dbn) {
                LogoActivity.this.aBB();
            }
        }

        @Override // com.baidu.tbadk.u.b
        public void R(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.dbt.getView() != null) {
                z2 = LogoActivity.this.dbt.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new an("c13332").bS("obj_id", str).O("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_click");
            anVar.bS("page_type", "a030").O("obj_isad", 1).bS("obj_id", str).O("obj_source", 2);
            if (z) {
                anVar.O("obj_type", z2 ? 4 : 3);
            } else {
                anVar.O("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.q.c.cni().b(LogoActivity.this.getUniqueId(), anVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.aBB();
        }
    };
    private long dbv = -1;
    private d.a dbw = new d.a() { // from class: com.baidu.tieba.LogoActivity.4
        @Override // com.baidu.tieba.u.d.a
        public void onError() {
            LogoActivity.this.aBy();
        }

        @Override // com.baidu.tieba.u.d.a
        public void aBH() {
            if (LogoActivity.this.dbj != -2) {
                LogoActivity.this.aBA();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener dbx = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.aBr()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.g.e.fZ().removeCallbacks(LogoActivity.this.dbo);
                    LogoActivity.this.dbm = true;
                    if (LogoActivity.this.dbn) {
                        LogoActivity.this.aBB();
                    }
                }
            }
        }
    };
    private Runnable dby = new Runnable() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aBp();
        }
    };
    private Runnable dbz = new Runnable() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.aBz()) {
                LogoActivity.this.aBB();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, LogoActivity.this.getPageContext()));
            LogoActivity.this.finish();
        }
    };
    private Runnable dbA = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.dbl) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.dbp);
                com.baidu.adp.lib.g.e.fZ().post(LogoActivity.this.dbz);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable dbB = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aBy();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aBp() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.dbk = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        h.ga().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.aBD();
                LogoActivity.aBC();
            }
        });
        finish();
    }

    private void ae(Intent intent) {
        if (intent != null) {
            if (intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false)) {
                LogoActivityConfig.mFromSpacial = true;
                Intent intent2 = new Intent();
                intent2.putExtra(DealIntentService.KEY_CLASS, 2);
                intent2.putExtra("fname", intent.getStringExtra("fname"));
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
        this.dbv = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.q.c.cni().v(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (aBF()) {
            aBE();
        } else if (aBr()) {
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(1028);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
            try {
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.dbx);
                this.dbj = -2;
                aBw();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !aBq()) {
            finish();
        } else {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.HOST_START).O("obj_param1", 2));
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
            }
            ae(getIntent());
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
            this.dbg = TbadkCoreApplication.getInst().getIsFirstUse();
            n.awQ().fy(this.dbg);
            registerListener(this.dbx);
            aBs();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                aBt();
            }
            if (!m.checkSD()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean aBq() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new an("c11897").bS("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBr() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void aBs() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.e.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.e.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.ags(), getPageContext().getPageActivity());
            }
        }
        cG(getPageContext().getPageActivity());
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
        if (this.dbt != null && this.dbt.getView() != null && this.dbt.getView().getParent() != null) {
            if (this.dbt.getView() != null) {
                if (this.dbt.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dbt.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.dbt.getView().setLayoutParams(layoutParams);
        }
        if (this.dbs != null && this.dbs.bTK != null) {
            this.dbs.bTK.afC();
        }
    }

    private void aBt() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(MessageConfig.DEBUGTOOL_START, new com.baidu.adp.a.a.c(getPageContext().getPageActivity())));
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
        this.dbn = false;
        if (this.dbq != null) {
            this.dbq.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dbn = true;
        if (this.dbh) {
            this.dbh = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.alP().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.alP().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (this.dbm) {
            aBB();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.dbk) {
            aBp();
            this.dbk = false;
        }
        if (this.dbq != null) {
            this.dbq.onResume();
        }
        if (LogoActivityConfig.isFirst && this.dbv >= 0) {
            n.awQ().bk(System.currentTimeMillis() - this.dbv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dbs != null) {
            this.dbs.o(null);
            this.dbs.a(null);
        }
        if (this.dbt != null) {
            this.dbt.release();
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.dbo);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.dby);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.dbz);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.dbA);
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.dbB);
        if (this.dbq != null) {
            this.dbq.onDestroy();
        }
        if (this.dbf != null && !this.dbf.isRecycled()) {
            this.dbf.recycle();
            this.dbf = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.q.c.cni().w(getUniqueId());
        com.baidu.adp.lib.util.d.gW().clearCashBitmap();
    }

    private void cG(Context context) {
        aBu();
        if (LogoActivityConfig.mFromSpacial) {
            lp(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.dbg) {
                com.baidu.adp.lib.g.e.fZ().post(this.dby);
            } else {
                lp(1);
            }
        } else if (this.dbg) {
            com.baidu.adp.lib.g.e.fZ().post(this.dby);
        } else {
            aBv();
        }
    }

    private void aBu() {
        if (this.dbg) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.alP().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void aBv() {
        if (this.dbj != -2) {
            if (this.dbq == null) {
                this.dbq = new com.baidu.tieba.u.d(this);
            }
            if (this.dbq.cwE()) {
                this.dbr = this.dbq.o(0.8125d);
                this.mRootView.addView(this.dbr);
                this.dbq.a(this.dbw);
                this.dbq.start();
                return;
            }
            this.dbq.cwJ();
        }
        aBw();
    }

    private void aBw() {
        this.dbi = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.u.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.dbt = (com.baidu.tbadk.u.a) runTask.getData();
            this.dbt.a(this.dbu);
            this.dbt.axl();
            n.awQ().bl(System.currentTimeMillis() - this.dbi);
            int i = com.baidu.tbadk.core.sharedPref.b.alP().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.dbB, i * 1000);
            return;
        }
        aBx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBx() {
        int af = com.baidu.adp.lib.b.d.ft().af("ad_baichuan_open");
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        if (af == 0 || findTask == null) {
            aBy();
        }
        this.dbi = System.currentTimeMillis();
        this.dbs = new com.baidu.tbadk.g.c();
        this.dbp = new BesAdViewContainer(getPageContext().getPageActivity());
        this.dbp.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.11
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.aBB();
            }
        });
        this.dbp.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.dbp);
        this.dbs.o(this.dbp);
        this.dbs.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.a
            public void me(String str) {
                LogoActivity.this.dbl = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.dbp);
                LogoActivity.this.aBy();
            }

            @Override // com.baidu.tbadk.g.a
            public void n(boolean z, boolean z2) {
                LogoActivity.this.dbl = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new an(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).O("obj_type", z2 ? 2 : 1));
                an anVar = new an("common_exp");
                anVar.bS("page_type", "a030").O("obj_isad", 1).O("obj_source", 1);
                if (z) {
                    anVar.O("obj_type", z2 ? 4 : 3);
                } else {
                    anVar.O("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.q.c.cni().a(LogoActivity.this.getUniqueId(), "bes_ad_id", anVar);
                com.baidu.tieba.q.c.cni().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.dbj == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.g.e.fZ().removeCallbacks(LogoActivity.this.dbA);
                n.awQ().bm(System.currentTimeMillis());
            }

            @Override // com.baidu.tbadk.g.a
            public void afB() {
                LogoActivity.this.dbm = true;
                if (LogoActivity.this.dbn) {
                    LogoActivity.this.aBB();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void o(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new an(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).O("obj_type", z2 ? 2 : 1));
                an anVar = new an("common_click");
                anVar.bS("page_type", "a030").O("obj_isad", 1).O("obj_source", 1);
                if (z) {
                    anVar.O("obj_type", z2 ? 4 : 3);
                } else {
                    anVar.O("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.q.c.cni().b(LogoActivity.this.getUniqueId(), anVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.dbs));
        n.awQ().bl(System.currentTimeMillis() - this.dbi);
        int i = com.baidu.tbadk.core.sharedPref.b.alP().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.g.e.fZ().postDelayed(this.dbA, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBy() {
        if (this.dbj == -2) {
            finish();
        } else {
            com.baidu.adp.lib.g.e.fZ().post(this.dbz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aBz() {
        try {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_VR_LOGO_CAN_OPEN, Boolean.class, 0);
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
    public void aBA() {
        if (this.dbj >= 0) {
            lq(this.dbj);
        } else if (this.dbj == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBB() {
        aBA();
        n.awQ().bn(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aBC() {
        String str = dbe + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            m.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBD() {
        File[] listFiles;
        File file = new File(m.getCacheDir());
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

    private void lp(int i) {
        this.dbj = i;
        aBv();
    }

    private void lq(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private void aBE() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SecretHintActivityConfig(getPageContext().getPageActivity())));
        finish();
    }

    private boolean aBF() {
        boolean z = com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("key_secret_is_show", false);
        TbSingleton.getInstance().setHasAgreeSecretProtocol(z);
        return !z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        lp(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        lp(intExtra);
                        return;
                    } else {
                        lp(1);
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
            LogoActivity.this.aBB();
        }
    }
}
