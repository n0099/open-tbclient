package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.appsearchlib.NASLib;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
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
    private com.baidu.tbadk.core.dialog.a fAa;
    private com.baidu.tieba.w.d fAc;
    private View fAd;
    private com.baidu.tbadk.g.e fAe;
    private BesAdViewContainer fAf;
    private com.baidu.tbadk.g.d fAh;
    private com.baidu.tbadk.s.a fAi;
    private boolean fzW;
    private com.baidu.tbadk.core.dialog.a fzZ;
    private RelativeLayout mRootView;
    private Bitmap fzQ = null;
    private boolean fzR = false;
    private boolean fzS = true;
    private long fzT = -1;
    private long fzU = -1;
    private int fzV = -1;
    private boolean fzX = false;
    private boolean fzY = true;
    private a fAb = new a();
    private boolean fAg = false;
    private com.baidu.tbadk.s.b fAj = new com.baidu.tbadk.s.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.s.b
        public void XR() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fAq);
            LogoActivity.this.bDN();
        }

        @Override // com.baidu.tbadk.s.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fAq);
            if (LogoActivity.this.fAi.getView() == null) {
                LogoActivity.this.bDS();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.fAi.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.fAi.getView());
            if (LogoActivity.this.fzV == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.byh().dv(System.currentTimeMillis());
            TiebaStatic.log(new aq("c13331").dK("obj_id", str).aj("obj_type", z2 ? 2 : 1));
            aq aqVar = new aq("common_exp");
            aqVar.dK("page_type", "a030").aj("obj_isad", 1).dK("obj_id", str).aj("obj_floor", 1).aj("obj_source", 2).aj("obj_adlocate", 16);
            if (z) {
                aqVar.aj("obj_type", z2 ? 4 : 3);
            } else {
                aqVar.aj("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dDn().a(LogoActivity.this.getUniqueId(), str, aqVar);
            com.baidu.tieba.s.c.dDn().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.s.b
        public void bes() {
            LogoActivity.this.fzX = true;
            if (LogoActivity.this.fzY) {
                LogoActivity.this.bDS();
            }
        }

        @Override // com.baidu.tbadk.s.b
        public void aw(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.fAi.getView() != null) {
                z2 = LogoActivity.this.fAi.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new aq("c13332").dK("obj_id", str).aj("obj_type", z2 ? 2 : 1));
            aq aqVar = new aq("common_click");
            aqVar.dK("page_type", "a030").aj("obj_isad", 1).dK("obj_id", str).aj("obj_floor", 1).aj("obj_source", 2).aj("obj_adlocate", 16);
            if (z) {
                aqVar.aj("obj_type", z2 ? 4 : 3);
            } else {
                aqVar.aj("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dDn().b(LogoActivity.this.getUniqueId(), aqVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bDS();
        }
    };
    private long fAk = -1;
    private d.a fAl = new d.a() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.bDQ();
        }

        @Override // com.baidu.tieba.w.d.a
        public void XT() {
            if (LogoActivity.this.fzV != -2) {
                LogoActivity.this.bDR();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener fAm = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bDH()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fAb);
                    LogoActivity.this.fzX = true;
                    if (LogoActivity.this.fzY) {
                        LogoActivity.this.bDS();
                    }
                }
            }
        }
    };
    private Runnable fAn = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bDF();
        }
    };
    private Runnable fAo = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bDS();
        }
    };
    private Runnable fAp = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.fAg && LogoActivity.this.fAf != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fAf);
                com.baidu.adp.lib.f.e.mY().post(LogoActivity.this.fAo);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable fAq = new Runnable() { // from class: com.baidu.tieba.LogoActivity.14
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bDQ();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    private ClickableSpan fAr = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(LogoActivity.this.getResources().getColor(17170445));
            }
            com.baidu.tbadk.browser.a.startExternWebActivity(LogoActivity.this.getActivity(), "http://tieba.baidu.com/tb/cms/client/wise_secretright.html");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(LogoActivity.this.getResources().getColor(R.color.cp_link_tip_c));
        }
    };
    View.OnClickListener eFW = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes) {
                if (LogoActivity.this.fzZ.isShowing()) {
                    LogoActivity.this.fzZ.dismiss();
                }
                ae.iF(true);
                com.baidu.tbadk.core.sharedPref.b.blO().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bDX() || ae.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bDF();
                    aq aqVar = new aq("c13295");
                    aqVar.dK("obj_locate", "1");
                    TiebaStatic.log(aqVar);
                    return;
                }
                LogoActivity.this.bDY();
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.fzZ.isShowing()) {
                    LogoActivity.this.fzZ.dismiss();
                }
                aq aqVar2 = new aq("c13295");
                aqVar2.dK("obj_locate", "2");
                TiebaStatic.log(aqVar2);
                if (LogoActivity.this.fAa == null) {
                    LogoActivity.this.bDW();
                }
                LogoActivity.this.fAa.bkJ();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.fAa.isShowing()) {
                    LogoActivity.this.fAa.dismiss();
                }
                if (LogoActivity.this.fzZ == null) {
                    LogoActivity.this.bDV();
                }
                LogoActivity.this.fzZ.bkJ();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bDF() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.fzW = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.15
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.bDU();
                LogoActivity.bDT();
            }
        });
        finish();
    }

    private void L(Intent intent) {
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
        this.fAk = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dDn().z(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (!ae.bmC()) {
            bDV();
            this.fzZ.bkJ();
            TiebaStatic.log(new aq("c13294"));
        } else if (!bDX() && !ae.checkLocationForGoogle(getActivity())) {
            bDY();
        } else {
            if (ae.checkLocationForGoogle(getActivity())) {
                com.baidu.adp.lib.c.a.mk().getAddress(false);
            }
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            if (bDH()) {
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                try {
                    setContentView(R.layout.logo_activity);
                    this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                    LogoActivityConfig.isFirst = true;
                    registerListener(this.fAm);
                    this.fzV = -2;
                    bDM();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                } catch (Throwable th) {
                    BdLog.e(th);
                    finish();
                }
            } else if (!isTaskRoot() && !bDG()) {
                finish();
            } else {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.HOST_START).aj("obj_param1", 2));
                TbadkCoreApplication.getInst().onLowMemory();
                if (!TbadkCoreApplication.isLogin()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
                }
                L(getIntent());
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                }
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                if (bundle != null) {
                    LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
                } else {
                    LogoActivityConfig.isFirst = true;
                }
                this.fzR = TbadkCoreApplication.getInst().getIsFirstUse();
                n.byh().kd(this.fzR);
                registerListener(this.fAm);
                bDI();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("type", "start");
                hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
                hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                    bDJ();
                }
                if (!com.baidu.tbadk.core.util.n.checkSD()) {
                    TiebaStatic.file("no SD", "LogoActivity.onCreate");
                }
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
                }
            }
        }
    }

    private boolean bDG() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new aq("c11897").dK("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDH() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bDI() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.bfs(), getPageContext().getPageActivity());
            }
        }
        eF(getPageContext().getPageActivity());
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
        if (this.fAi != null && this.fAi.getView() != null && this.fAi.getView().getParent() != null) {
            if (this.fAi.getView() != null) {
                if (this.fAi.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fAi.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.fAi.getView().setLayoutParams(layoutParams);
        }
        if (this.fAe != null && this.fAe.egv != null) {
            this.fAe.egv.bet();
        }
    }

    private void bDJ() {
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
        this.fzY = false;
        if (this.fAc != null) {
            this.fAc.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fzY = true;
        if (this.fzS) {
            this.fzS = false;
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.blO().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.blO().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (ae.bmC()) {
            NASLib.onAppStart(getActivity());
        }
        if (this.fzX) {
            bDS();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.fzW) {
            bDF();
            this.fzW = false;
        }
        if (this.fAc != null) {
            this.fAc.onResume();
        }
        if (LogoActivityConfig.isFirst && this.fAk >= 0) {
            n.byh().ds(System.currentTimeMillis() - this.fAk);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fAe != null) {
            this.fAe.setParentView(null);
            this.fAe.a(null);
        }
        if (this.fAh != null) {
            this.fAh.setParentView(null);
            this.fAh.a(null);
        }
        if (this.fAi != null) {
            this.fAi.release();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fAb);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fAn);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fAo);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fAp);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fAq);
        if (this.fAc != null) {
            this.fAc.onDestroy();
        }
        if (this.fzQ != null && !this.fzQ.isRecycled()) {
            this.fzQ.recycle();
            this.fzQ = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.dDn().A(getUniqueId());
        com.baidu.adp.lib.util.d.oi().clearCashBitmap();
    }

    private void eF(Context context) {
        bDK();
        if (LogoActivityConfig.mFromSpacial) {
            sJ(2);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.fzR) {
                com.baidu.adp.lib.f.e.mY().post(this.fAn);
            } else {
                sJ(2);
            }
        } else if (this.fzR) {
            com.baidu.adp.lib.f.e.mY().post(this.fAn);
        } else {
            bDL();
        }
    }

    private void bDK() {
        if (this.fzR) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.blO().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bDL() {
        if (this.fzV != -2) {
            if (this.fAc == null) {
                this.fAc = new com.baidu.tieba.w.d(this);
            }
            if (this.fAc.dMG()) {
                this.fAd = this.fAc.I(0.8125d);
                this.mRootView.addView(this.fAd);
                this.fAc.a(this.fAl);
                this.fAc.start();
                return;
            }
            this.fAc.dMK();
        }
        bDM();
    }

    private void bDM() {
        this.fzT = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.s.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.fAi = (com.baidu.tbadk.s.a) runTask.getData();
            this.fAi.a(this.fAj);
            this.fAi.byI();
            n.byh().dt(System.currentTimeMillis() - this.fzT);
            int i = com.baidu.tbadk.core.sharedPref.b.blO().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(this.fAq, i * 1000);
            return;
        }
        bDN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDN() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bDQ();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        MessageTask findTask2 = MessageManager.getInstance().findTask(2156676);
        if (findTask2 == null && findTask == null) {
            bDQ();
            return;
        }
        boolean zf = com.baidu.tbadk.a.b.zf("ad_xuzhang_splash_sdk");
        if (findTask2 != null && zf) {
            bDO();
        } else if (findTask != null) {
            bDP();
        } else {
            bDQ();
        }
    }

    private void bDO() {
        this.fzT = System.currentTimeMillis();
        this.fzU = System.currentTimeMillis();
        this.fAh = new com.baidu.tbadk.g.d();
        this.fAf = new BesAdViewContainer(getPageContext().getPageActivity());
        this.fAf.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.16
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bDS();
            }
        });
        this.fAf.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.fAf);
        this.fAh.setParentView(this.fAf);
        this.fAh.a(new com.baidu.tbadk.g.c() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.c
            public void zi(String str) {
                LogoActivity.this.fAg = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fAf);
                LogoActivity.this.bDQ();
                n.byh().du(System.currentTimeMillis() - LogoActivity.this.fzU);
            }

            @Override // com.baidu.tbadk.g.c
            public void beu() {
                LogoActivity.this.fAg = true;
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
                if (LogoActivity.this.fzV == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fAp);
                n.byh().dv(System.currentTimeMillis());
                n.byh().du(System.currentTimeMillis() - LogoActivity.this.fzU);
            }

            @Override // com.baidu.tbadk.g.c
            public void bes() {
                LogoActivity.this.fzX = true;
                if (LogoActivity.this.fzY) {
                    LogoActivity.this.bDS();
                }
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdClick() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2156676, this.fAh));
        n.byh().dt(System.currentTimeMillis() - this.fzT);
        int i = com.baidu.tbadk.core.sharedPref.b.blO().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.fAp, (i > 0 ? i : 1) * 1000);
    }

    private void bDP() {
        this.fzT = System.currentTimeMillis();
        this.fzU = System.currentTimeMillis();
        this.fAe = new com.baidu.tbadk.g.e();
        this.fAf = new BesAdViewContainer(getPageContext().getPageActivity());
        this.fAf.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bDS();
            }
        });
        this.fAf.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.fAf);
        this.fAe.setParentView(this.fAf);
        this.fAe.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tbadk.g.a
            public void zi(String str) {
                LogoActivity.this.fAg = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fAf);
                LogoActivity.this.bDQ();
                n.byh().du(System.currentTimeMillis() - LogoActivity.this.fzU);
            }

            @Override // com.baidu.tbadk.g.a
            public void v(boolean z, boolean z2) {
                LogoActivity.this.fAg = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).aj("obj_type", z2 ? 2 : 1));
                aq aqVar = new aq("common_exp");
                aqVar.dK("page_type", "a030").aj("obj_isad", 1).aj("obj_floor", 1).aj("obj_source", 1).aj("obj_adlocate", 16);
                if (z) {
                    aqVar.aj("obj_type", z2 ? 4 : 3);
                } else {
                    aqVar.aj("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dDn().a(LogoActivity.this.getUniqueId(), "bes_ad_id", aqVar);
                com.baidu.tieba.s.c.dDn().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.fzV == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fAp);
                n.byh().dv(System.currentTimeMillis());
                n.byh().du(System.currentTimeMillis() - LogoActivity.this.fzU);
            }

            @Override // com.baidu.tbadk.g.a
            public void bes() {
                LogoActivity.this.fzX = true;
                if (LogoActivity.this.fzY) {
                    LogoActivity.this.bDS();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void w(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).aj("obj_type", z2 ? 2 : 1));
                aq aqVar = new aq("common_click");
                aqVar.dK("page_type", "a030").aj("obj_isad", 1).aj("obj_floor", 1).aj("obj_source", 1).aj("obj_adlocate", 16);
                if (z) {
                    aqVar.aj("obj_type", z2 ? 4 : 3);
                } else {
                    aqVar.aj("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dDn().b(LogoActivity.this.getUniqueId(), aqVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.fAe));
        n.byh().dt(System.currentTimeMillis() - this.fzT);
        int i = com.baidu.tbadk.core.sharedPref.b.blO().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.fAp, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDQ() {
        if (this.fzV == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.mY().post(this.fAo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDR() {
        if (this.fzV >= 0) {
            sK(this.fzV);
        } else if (this.fzV == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDS() {
        bDR();
        n.byh().dw(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bDT() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            com.baidu.tbadk.core.util.n.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDU() {
        File[] listFiles;
        File file = new File(com.baidu.tbadk.core.util.n.getCacheDir());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.LogoActivity.5
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

    private void sJ(int i) {
        this.fzV = i;
        bDL();
    }

    private void sK(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDV() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.fAr, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cp_link_tip_a)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.fzZ = new com.baidu.tbadk.core.dialog.a(this);
        this.fzZ.ba(inflate);
        this.fzZ.oe(3);
        this.fzZ.iA(false);
        this.fzZ.setAutoNight(false);
        this.fzZ.iz(false);
        ap.a((View) textView2, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
        ap.a((View) textView3, R.color.cp_cont_b, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.eFW);
        textView3.setOnClickListener(this.eFW);
        this.fzZ.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDW() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        ap.a((View) textView2, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.eFW);
        this.fAa = new com.baidu.tbadk.core.dialog.a(this);
        this.fAa.ba(inflate);
        this.fAa.oe(3);
        this.fAa.iA(false);
        this.fAa.setAutoNight(false);
        this.fAa.iz(false);
        this.fAa.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        sJ(2);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        sJ(intExtra);
                        return;
                    } else {
                        sJ(2);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 22001) {
            com.baidu.adp.lib.c.a.mk().getAddress(false);
            bDF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bDX() {
        return at.equals(TbConfig.getVersion(), com.baidu.tbadk.core.sharedPref.b.blO().getString("key_location_request_dialog_last_show_version", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDY() {
        com.baidu.tbadk.core.sharedPref.b.blO().putString("key_location_request_dialog_last_show_version", TbConfig.getVersion());
        ae.a(getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
            public void onClose() {
                LogoActivity.this.bDF();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bDS();
        }
    }
}
