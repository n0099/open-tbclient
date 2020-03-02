package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.MessageTask;
import com.baidu.adp.lib.f.h;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
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
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.n.n;
import com.baidu.tbadk.switchs.AdSdkSwitch;
import com.baidu.tieba.view.BesAdViewContainer;
import com.baidu.tieba.w.d;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private static final String DOWNLOAD_DIR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    private View dTA;
    private com.baidu.tbadk.g.c dTB;
    private com.baidu.tbadk.core.dialog.a dTC;
    private com.baidu.tbadk.core.dialog.a dTD;
    private com.baidu.tbadk.r.a dTE;
    private boolean dTt;
    private BesAdViewContainer dTy;
    private com.baidu.tieba.w.d dTz;
    private RelativeLayout mRootView;
    private Bitmap dTn = null;
    private boolean dTo = false;
    private boolean dTp = true;
    private long dTq = -1;
    private long dTr = -1;
    private int dTs = -1;
    private boolean dTu = false;
    private boolean dTv = false;
    private boolean dTw = true;
    private a dTx = new a();
    private com.baidu.tbadk.r.b dTF = new com.baidu.tbadk.r.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.r.b
        public void aRK() {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(LogoActivity.this.dTM);
            LogoActivity.this.aVY();
        }

        @Override // com.baidu.tbadk.r.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(LogoActivity.this.dTM);
            if (LogoActivity.this.dTE.getView() == null) {
                LogoActivity.this.aWb();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.dTE.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.dTE.getView());
            if (LogoActivity.this.dTs == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.aRq().bW(System.currentTimeMillis());
            TiebaStatic.log(new an("c13331").cy("obj_id", str).X("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_exp");
            anVar.cy("page_type", "a030").X("obj_isad", 1).cy("obj_id", str).X("obj_floor", 1).X("obj_source", 2).X("obj_adlocate", 16);
            if (z) {
                anVar.X("obj_type", z2 ? 4 : 3);
            } else {
                anVar.X("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.cKa().a(LogoActivity.this.getUniqueId(), str, anVar);
            com.baidu.tieba.s.c.cKa().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.r.b
        public void azb() {
            LogoActivity.this.dTv = true;
            if (LogoActivity.this.dTw) {
                LogoActivity.this.aWb();
            }
        }

        @Override // com.baidu.tbadk.r.b
        public void V(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.dTE.getView() != null) {
                z2 = LogoActivity.this.dTE.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new an("c13332").cy("obj_id", str).X("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_click");
            anVar.cy("page_type", "a030").X("obj_isad", 1).cy("obj_id", str).X("obj_floor", 1).X("obj_source", 2).X("obj_adlocate", 16);
            if (z) {
                anVar.X("obj_type", z2 ? 4 : 3);
            } else {
                anVar.X("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.cKa().b(LogoActivity.this.getUniqueId(), anVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.aWb();
        }
    };
    private long dTG = -1;
    private d.a dTH = new d.a() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.aVZ();
        }

        @Override // com.baidu.tieba.w.d.a
        public void aWi() {
            if (LogoActivity.this.dTs != -2) {
                LogoActivity.this.aWa();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener dTI = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.aVS()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(LogoActivity.this.dTx);
                    LogoActivity.this.dTv = true;
                    if (LogoActivity.this.dTw) {
                        LogoActivity.this.aWb();
                    }
                }
            }
        }
    };
    private Runnable dTJ = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aVQ();
        }
    };
    private Runnable dTK = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aWb();
        }
    };
    private Runnable dTL = new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.dTu) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.dTy);
                com.baidu.adp.lib.f.e.gx().post(LogoActivity.this.dTK);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable dTM = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aVZ();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    private ClickableSpan dTN = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.4
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.LogoActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(LogoActivity.this.getResources().getColor(17170445));
            }
            ba.aGG().a(LogoActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(LogoActivity.this.getResources().getColor(R.color.cp_link_tip_c));
        }
    };
    View.OnClickListener dfY = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes) {
                if (LogoActivity.this.dTC.isShowing()) {
                    LogoActivity.this.dTC.dismiss();
                }
                com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("key_secret_is_show", true);
                if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                    LogoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
                } else {
                    LogoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(2)));
                }
                LogoActivity.this.sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
                LogoActivity.this.finish();
                an anVar = new an("c13295");
                anVar.cy("obj_locate", "1");
                TiebaStatic.log(anVar);
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.dTC.isShowing()) {
                    LogoActivity.this.dTC.dismiss();
                }
                an anVar2 = new an("c13295");
                anVar2.cy("obj_locate", "2");
                TiebaStatic.log(anVar2);
                if (LogoActivity.this.dTD == null) {
                    LogoActivity.this.aWg();
                }
                LogoActivity.this.dTD.aEC();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.dTD.isShowing()) {
                    LogoActivity.this.dTD.dismiss();
                }
                if (LogoActivity.this.dTC == null) {
                    LogoActivity.this.aWf();
                }
                LogoActivity.this.dTC.aEC();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aVQ() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.dTt = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.aWd();
                LogoActivity.aWc();
            }
        });
        finish();
    }

    private void Z(Intent intent) {
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
        this.dTG = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cKa().w(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (aWe()) {
            aWf();
            this.dTC.aEC();
            TiebaStatic.log(new an("c13294"));
            return;
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        if (aVS()) {
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(1028);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
            try {
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.dTI);
                this.dTs = -2;
                aVX();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !aVR()) {
            finish();
        } else {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.HOST_START).X("obj_param1", 2));
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
            }
            Z(getIntent());
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
            this.dTo = TbadkCoreApplication.getInst().getIsFirstUse();
            n.aRq().gV(this.dTo);
            registerListener(this.dTI);
            aVT();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                aVU();
            }
            if (!m.checkSD()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean aVR() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new an("c11897").cy("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVS() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void aVT() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.azS(), getPageContext().getPageActivity());
            }
        }
        em(getPageContext().getPageActivity());
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
        if (this.dTE != null && this.dTE.getView() != null && this.dTE.getView().getParent() != null) {
            if (this.dTE.getView() != null) {
                if (this.dTE.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dTE.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.dTE.getView().setLayoutParams(layoutParams);
        }
        if (this.dTB != null && this.dTB.cKy != null) {
            this.dTB.cKy.azc();
        }
    }

    private void aVU() {
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
        this.dTw = false;
        if (this.dTz != null) {
            this.dTz.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dTw = true;
        if (this.dTp) {
            this.dTp = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aFD().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.aFD().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (this.dTv) {
            aWb();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.dTt) {
            aVQ();
            this.dTt = false;
        }
        if (this.dTz != null) {
            this.dTz.onResume();
        }
        if (LogoActivityConfig.isFirst && this.dTG >= 0) {
            n.aRq().bT(System.currentTimeMillis() - this.dTG);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dTB != null) {
            this.dTB.s(null);
            this.dTB.a(null);
        }
        if (this.dTE != null) {
            this.dTE.release();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dTx);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dTJ);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dTK);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dTL);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dTM);
        if (this.dTz != null) {
            this.dTz.onDestroy();
        }
        if (this.dTn != null && !this.dTn.isRecycled()) {
            this.dTn.recycle();
            this.dTn = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.cKa().x(getUniqueId());
        com.baidu.adp.lib.util.d.hG().clearCashBitmap();
    }

    private void em(Context context) {
        aVV();
        if (LogoActivityConfig.mFromSpacial) {
            nU(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.dTo) {
                com.baidu.adp.lib.f.e.gx().post(this.dTJ);
            } else {
                nU(1);
            }
        } else if (this.dTo) {
            com.baidu.adp.lib.f.e.gx().post(this.dTJ);
        } else {
            aVW();
        }
    }

    private void aVV() {
        if (this.dTo) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void aVW() {
        if (this.dTs != -2) {
            if (this.dTz == null) {
                this.dTz = new com.baidu.tieba.w.d(this);
            }
            if (this.dTz.cTn()) {
                this.dTA = this.dTz.r(0.8125d);
                this.mRootView.addView(this.dTA);
                this.dTz.a(this.dTH);
                this.dTz.start();
                return;
            }
            this.dTz.cTq();
        }
        aVX();
    }

    private void aVX() {
        this.dTq = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.r.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.dTE = (com.baidu.tbadk.r.a) runTask.getData();
            this.dTE.a(this.dTF);
            this.dTE.aRJ();
            n.aRq().bU(System.currentTimeMillis() - this.dTq);
            int i = com.baidu.tbadk.core.sharedPref.b.aFD().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(this.dTM, i * 1000);
            return;
        }
        aVY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVY() {
        int findType = SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH);
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        if (findType == 0 || findTask == null) {
            aVZ();
        }
        this.dTq = System.currentTimeMillis();
        this.dTr = System.currentTimeMillis();
        this.dTB = new com.baidu.tbadk.g.c();
        this.dTy = new BesAdViewContainer(getPageContext().getPageActivity());
        this.dTy.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.13
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.aWb();
            }
        });
        this.dTy.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.dTy);
        this.dTB.s(this.dTy);
        this.dTB.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.a
            public void rI(String str) {
                LogoActivity.this.dTu = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.dTy);
                LogoActivity.this.aVZ();
                n.aRq().bV(System.currentTimeMillis() - LogoActivity.this.dTr);
            }

            @Override // com.baidu.tbadk.g.a
            public void o(boolean z, boolean z2) {
                LogoActivity.this.dTu = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new an(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).X("obj_type", z2 ? 2 : 1));
                an anVar = new an("common_exp");
                anVar.cy("page_type", "a030").X("obj_isad", 1).X("obj_floor", 1).X("obj_source", 1).X("obj_adlocate", 16);
                if (z) {
                    anVar.X("obj_type", z2 ? 4 : 3);
                } else {
                    anVar.X("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.cKa().a(LogoActivity.this.getUniqueId(), "bes_ad_id", anVar);
                com.baidu.tieba.s.c.cKa().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.dTs == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.gx().removeCallbacks(LogoActivity.this.dTL);
                n.aRq().bW(System.currentTimeMillis());
                n.aRq().bV(System.currentTimeMillis() - LogoActivity.this.dTr);
            }

            @Override // com.baidu.tbadk.g.a
            public void azb() {
                LogoActivity.this.dTv = true;
                if (LogoActivity.this.dTw) {
                    LogoActivity.this.aWb();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void p(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new an(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).X("obj_type", z2 ? 2 : 1));
                an anVar = new an("common_click");
                anVar.cy("page_type", "a030").X("obj_isad", 1).X("obj_floor", 1).X("obj_source", 1).X("obj_adlocate", 16);
                if (z) {
                    anVar.X("obj_type", z2 ? 4 : 3);
                } else {
                    anVar.X("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.cKa().b(LogoActivity.this.getUniqueId(), anVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.dTB));
        n.aRq().bU(System.currentTimeMillis() - this.dTq);
        int i = com.baidu.tbadk.core.sharedPref.b.aFD().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.dTL, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVZ() {
        if (this.dTs == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.gx().post(this.dTK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWa() {
        if (this.dTs >= 0) {
            nV(this.dTs);
        } else if (this.dTs == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWb() {
        aWa();
        n.aRq().bX(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aWc() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            m.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWd() {
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

    private void nU(int i) {
        this.dTs = i;
        aVW();
    }

    private void nV(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private boolean aWe() {
        return !com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_secret_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWf() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4), getResources().getString(R.string.secret_hint_footer));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.dTN, 290, 296, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cp_link_tip_a)), 290, 296, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.dTC = new com.baidu.tbadk.core.dialog.a(this);
        this.dTC.aO(inflate);
        this.dTC.jZ(3);
        this.dTC.fH(false);
        this.dTC.setAutoNight(false);
        this.dTC.fG(false);
        am.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        am.a((View) textView3, (int) R.color.cp_cont_b, (int) R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.dfY);
        textView3.setOnClickListener(this.dfY);
        this.dTC.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWg() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        am.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.dfY);
        this.dTD = new com.baidu.tbadk.core.dialog.a(this);
        this.dTD.aO(inflate);
        this.dTD.jZ(3);
        this.dTD.fH(false);
        this.dTD.setAutoNight(false);
        this.dTD.fG(false);
        this.dTD.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        nU(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        nU(intExtra);
                        return;
                    } else {
                        nU(1);
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
            LogoActivity.this.aWb();
        }
    }
}
