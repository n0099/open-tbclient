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
import com.baidu.tieba.v.d;
import com.baidu.tieba.view.BesAdViewContainer;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private static final String DOWNLOAD_DIR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    private boolean dPm;
    private BesAdViewContainer dPr;
    private com.baidu.tieba.v.d dPs;
    private View dPt;
    private com.baidu.tbadk.g.c dPu;
    private com.baidu.tbadk.core.dialog.a dPv;
    private com.baidu.tbadk.core.dialog.a dPw;
    private com.baidu.tbadk.r.a dPx;
    private RelativeLayout mRootView;
    private Bitmap dPg = null;
    private boolean dPh = false;
    private boolean dPi = true;
    private long dPj = -1;
    private long dPk = -1;
    private int dPl = -1;
    private boolean dPn = false;
    private boolean dPo = false;
    private boolean dPp = true;
    private a dPq = new a();
    private com.baidu.tbadk.r.b dPy = new com.baidu.tbadk.r.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.r.b
        public void aPs() {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(LogoActivity.this.dPF);
            LogoActivity.this.aTF();
        }

        @Override // com.baidu.tbadk.r.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(LogoActivity.this.dPF);
            if (LogoActivity.this.dPx.getView() == null) {
                LogoActivity.this.aTJ();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.dPx.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.dPx.getView());
            if (LogoActivity.this.dPl == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.aOY().bS(System.currentTimeMillis());
            TiebaStatic.log(new an("c13331").cp("obj_id", str).Z("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_exp");
            anVar.cp("page_type", "a030").Z("obj_isad", 1).cp("obj_id", str).Z("obj_floor", 1).Z("obj_source", 2).Z("obj_adlocate", 16);
            if (z) {
                anVar.Z("obj_type", z2 ? 4 : 3);
            } else {
                anVar.Z("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.r.c.cIu().a(LogoActivity.this.getUniqueId(), str, anVar);
            com.baidu.tieba.r.c.cIu().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.r.b
        public void awM() {
            LogoActivity.this.dPo = true;
            if (LogoActivity.this.dPp) {
                LogoActivity.this.aTJ();
            }
        }

        @Override // com.baidu.tbadk.r.b
        public void V(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.dPx.getView() != null) {
                z2 = LogoActivity.this.dPx.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new an("c13332").cp("obj_id", str).Z("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_click");
            anVar.cp("page_type", "a030").Z("obj_isad", 1).cp("obj_id", str).Z("obj_floor", 1).Z("obj_source", 2).Z("obj_adlocate", 16);
            if (z) {
                anVar.Z("obj_type", z2 ? 4 : 3);
            } else {
                anVar.Z("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.r.c.cIu().b(LogoActivity.this.getUniqueId(), anVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.aTJ();
        }
    };
    private long dPz = -1;
    private d.a dPA = new d.a() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // com.baidu.tieba.v.d.a
        public void onError() {
            LogoActivity.this.aTG();
        }

        @Override // com.baidu.tieba.v.d.a
        public void aTQ() {
            if (LogoActivity.this.dPl != -2) {
                LogoActivity.this.aTI();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener dPB = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.aTz()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(LogoActivity.this.dPq);
                    LogoActivity.this.dPo = true;
                    if (LogoActivity.this.dPp) {
                        LogoActivity.this.aTJ();
                    }
                }
            }
        }
    };
    private Runnable dPC = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aTx();
        }
    };
    private Runnable dPD = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.aTH()) {
                LogoActivity.this.aTJ();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VR_LOGO_OPEN, LogoActivity.this.getPageContext()));
            LogoActivity.this.finish();
        }
    };
    private Runnable dPE = new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.dPn) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.dPr);
                com.baidu.adp.lib.f.e.gx().post(LogoActivity.this.dPD);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable dPF = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aTG();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    private ClickableSpan dPG = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.4
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.LogoActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(LogoActivity.this.getResources().getColor(17170445));
            }
            ba.aEt().a(LogoActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(LogoActivity.this.getResources().getColor(R.color.cp_link_tip_c));
        }
    };
    View.OnClickListener dbS = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes) {
                if (LogoActivity.this.dPv.isShowing()) {
                    LogoActivity.this.dPv.dismiss();
                }
                com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("key_secret_is_show", true);
                if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                    LogoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
                } else {
                    LogoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(2)));
                }
                LogoActivity.this.sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
                LogoActivity.this.finish();
                an anVar = new an("c13295");
                anVar.cp("obj_locate", "1");
                TiebaStatic.log(anVar);
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.dPv.isShowing()) {
                    LogoActivity.this.dPv.dismiss();
                }
                an anVar2 = new an("c13295");
                anVar2.cp("obj_locate", "2");
                TiebaStatic.log(anVar2);
                if (LogoActivity.this.dPw == null) {
                    LogoActivity.this.aTO();
                }
                LogoActivity.this.dPw.aCp();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.dPw.isShowing()) {
                    LogoActivity.this.dPw.dismiss();
                }
                if (LogoActivity.this.dPv == null) {
                    LogoActivity.this.aTN();
                }
                LogoActivity.this.dPv.aCp();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aTx() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.dPm = true;
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
                LogoActivity.this.aTL();
                LogoActivity.aTK();
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
        this.dPz = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.r.c.cIu().w(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (aTM()) {
            aTN();
            this.dPv.aCp();
            TiebaStatic.log(new an("c13294"));
            return;
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        if (aTz()) {
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(1028);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
            try {
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.dPB);
                this.dPl = -2;
                aTE();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !aTy()) {
            finish();
        } else {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.HOST_START).Z("obj_param1", 2));
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
            this.dPh = TbadkCoreApplication.getInst().getIsFirstUse();
            n.aOY().gO(this.dPh);
            registerListener(this.dPB);
            aTA();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                aTB();
            }
            if (!m.checkSD()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean aTy() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new an("c11897").cp("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aTz() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void aTA() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.axC(), getPageContext().getPageActivity());
            }
        }
        ej(getPageContext().getPageActivity());
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
        if (this.dPx != null && this.dPx.getView() != null && this.dPx.getView().getParent() != null) {
            if (this.dPx.getView() != null) {
                if (this.dPx.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dPx.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.dPx.getView().setLayoutParams(layoutParams);
        }
        if (this.dPu != null && this.dPu.cGt != null) {
            this.dPu.cGt.awN();
        }
    }

    private void aTB() {
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
        this.dPp = false;
        if (this.dPs != null) {
            this.dPs.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dPp = true;
        if (this.dPi) {
            this.dPi = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aDr().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.aDr().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (this.dPo) {
            aTJ();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.dPm) {
            aTx();
            this.dPm = false;
        }
        if (this.dPs != null) {
            this.dPs.onResume();
        }
        if (LogoActivityConfig.isFirst && this.dPz >= 0) {
            n.aOY().bP(System.currentTimeMillis() - this.dPz);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dPu != null) {
            this.dPu.r(null);
            this.dPu.a(null);
        }
        if (this.dPx != null) {
            this.dPx.release();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dPq);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dPC);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dPD);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dPE);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dPF);
        if (this.dPs != null) {
            this.dPs.onDestroy();
        }
        if (this.dPg != null && !this.dPg.isRecycled()) {
            this.dPg.recycle();
            this.dPg = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.r.c.cIu().x(getUniqueId());
        com.baidu.adp.lib.util.d.hs().clearCashBitmap();
    }

    private void ej(Context context) {
        aTC();
        if (LogoActivityConfig.mFromSpacial) {
            nD(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.dPh) {
                com.baidu.adp.lib.f.e.gx().post(this.dPC);
            } else {
                nD(1);
            }
        } else if (this.dPh) {
            com.baidu.adp.lib.f.e.gx().post(this.dPC);
        } else {
            aTD();
        }
    }

    private void aTC() {
        if (this.dPh) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void aTD() {
        if (this.dPl != -2) {
            if (this.dPs == null) {
                this.dPs = new com.baidu.tieba.v.d(this);
            }
            if (this.dPs.cRQ()) {
                this.dPt = this.dPs.r(0.8125d);
                this.mRootView.addView(this.dPt);
                this.dPs.a(this.dPA);
                this.dPs.start();
                return;
            }
            this.dPs.cRT();
        }
        aTE();
    }

    private void aTE() {
        this.dPj = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.r.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.dPx = (com.baidu.tbadk.r.a) runTask.getData();
            this.dPx.a(this.dPy);
            this.dPx.aPr();
            n.aOY().bQ(System.currentTimeMillis() - this.dPj);
            int i = com.baidu.tbadk.core.sharedPref.b.aDr().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(this.dPF, i * 1000);
            return;
        }
        aTF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTF() {
        int findType = SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH);
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        if (findType == 0 || findTask == null) {
            aTG();
        }
        this.dPj = System.currentTimeMillis();
        this.dPk = System.currentTimeMillis();
        this.dPu = new com.baidu.tbadk.g.c();
        this.dPr = new BesAdViewContainer(getPageContext().getPageActivity());
        this.dPr.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.13
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.aTJ();
            }
        });
        this.dPr.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.dPr);
        this.dPu.r(this.dPr);
        this.dPu.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.a
            public void rt(String str) {
                LogoActivity.this.dPn = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.dPr);
                LogoActivity.this.aTG();
                n.aOY().bR(System.currentTimeMillis() - LogoActivity.this.dPk);
            }

            @Override // com.baidu.tbadk.g.a
            public void m(boolean z, boolean z2) {
                LogoActivity.this.dPn = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new an(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).Z("obj_type", z2 ? 2 : 1));
                an anVar = new an("common_exp");
                anVar.cp("page_type", "a030").Z("obj_isad", 1).Z("obj_floor", 1).Z("obj_source", 1).Z("obj_adlocate", 16);
                if (z) {
                    anVar.Z("obj_type", z2 ? 4 : 3);
                } else {
                    anVar.Z("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.r.c.cIu().a(LogoActivity.this.getUniqueId(), "bes_ad_id", anVar);
                com.baidu.tieba.r.c.cIu().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.dPl == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.gx().removeCallbacks(LogoActivity.this.dPE);
                n.aOY().bS(System.currentTimeMillis());
                n.aOY().bR(System.currentTimeMillis() - LogoActivity.this.dPk);
            }

            @Override // com.baidu.tbadk.g.a
            public void awM() {
                LogoActivity.this.dPo = true;
                if (LogoActivity.this.dPp) {
                    LogoActivity.this.aTJ();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void n(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new an(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).Z("obj_type", z2 ? 2 : 1));
                an anVar = new an("common_click");
                anVar.cp("page_type", "a030").Z("obj_isad", 1).Z("obj_floor", 1).Z("obj_source", 1).Z("obj_adlocate", 16);
                if (z) {
                    anVar.Z("obj_type", z2 ? 4 : 3);
                } else {
                    anVar.Z("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.r.c.cIu().b(LogoActivity.this.getUniqueId(), anVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.dPu));
        n.aOY().bQ(System.currentTimeMillis() - this.dPj);
        int i = com.baidu.tbadk.core.sharedPref.b.aDr().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.dPE, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTG() {
        if (this.dPl == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.gx().post(this.dPD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aTH() {
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
    public void aTI() {
        if (this.dPl >= 0) {
            nE(this.dPl);
        } else if (this.dPl == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTJ() {
        aTI();
        n.aOY().bT(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aTK() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            m.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTL() {
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

    private void nD(int i) {
        this.dPl = i;
        aTD();
    }

    private void nE(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private boolean aTM() {
        return !com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_secret_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTN() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4), getResources().getString(R.string.secret_hint_footer));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.dPG, 290, 296, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cp_link_tip_a)), 290, 296, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.dPv = new com.baidu.tbadk.core.dialog.a(this);
        this.dPv.aO(inflate);
        this.dPv.jI(3);
        this.dPv.fA(false);
        this.dPv.setAutoNight(false);
        this.dPv.fz(false);
        am.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        am.a((View) textView3, (int) R.color.cp_cont_b, (int) R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.dbS);
        textView3.setOnClickListener(this.dbS);
        this.dPv.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTO() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        am.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.dbS);
        this.dPw = new com.baidu.tbadk.core.dialog.a(this);
        this.dPw.aO(inflate);
        this.dPw.jI(3);
        this.dPw.fA(false);
        this.dPw.setAutoNight(false);
        this.dPw.fz(false);
        this.dPw.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        nD(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        nD(intExtra);
                        return;
                    } else {
                        nD(1);
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
            LogoActivity.this.aTJ();
        }
    }
}
