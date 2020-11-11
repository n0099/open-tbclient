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
    private boolean fOh;
    private com.baidu.tbadk.core.dialog.a fOk;
    private com.baidu.tbadk.core.dialog.a fOl;
    private com.baidu.tieba.w.d fOn;
    private View fOo;
    private com.baidu.tbadk.g.e fOp;
    private BesAdViewContainer fOq;
    private com.baidu.tbadk.g.d fOs;
    private com.baidu.tbadk.s.a fOt;
    private RelativeLayout mRootView;
    private Bitmap fOb = null;
    private boolean fOc = false;
    private boolean fOd = true;
    private long fOe = -1;
    private long fOf = -1;
    private int fOg = -1;
    private boolean fOi = false;
    private boolean fOj = true;
    private a fOm = new a();
    private boolean fOr = false;
    private com.baidu.tbadk.s.b fOu = new com.baidu.tbadk.s.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.s.b
        public void ack() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fOB);
            LogoActivity.this.bIf();
        }

        @Override // com.baidu.tbadk.s.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fOB);
            if (LogoActivity.this.fOt.getView() == null) {
                LogoActivity.this.bIk();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.fOt.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.fOt.getView());
            if (LogoActivity.this.fOg == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.bCz().dT(System.currentTimeMillis());
            TiebaStatic.log(new aq("c13331").dR("obj_id", str).al("obj_type", z2 ? 2 : 1));
            aq aqVar = new aq("common_exp");
            aqVar.dR("page_type", "a030").al("obj_isad", 1).dR("obj_id", str).al("obj_floor", 1).al("obj_source", 2).al("obj_adlocate", 16);
            if (z) {
                aqVar.al("obj_type", z2 ? 4 : 3);
            } else {
                aqVar.al("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dIX().a(LogoActivity.this.getUniqueId(), str, aqVar);
            com.baidu.tieba.s.c.dIX().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.s.b
        public void biL() {
            LogoActivity.this.fOi = true;
            if (LogoActivity.this.fOj) {
                LogoActivity.this.bIk();
            }
        }

        @Override // com.baidu.tbadk.s.b
        public void ay(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.fOt.getView() != null) {
                z2 = LogoActivity.this.fOt.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new aq("c13332").dR("obj_id", str).al("obj_type", z2 ? 2 : 1));
            aq aqVar = new aq("common_click");
            aqVar.dR("page_type", "a030").al("obj_isad", 1).dR("obj_id", str).al("obj_floor", 1).al("obj_source", 2).al("obj_adlocate", 16);
            if (z) {
                aqVar.al("obj_type", z2 ? 4 : 3);
            } else {
                aqVar.al("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dIX().b(LogoActivity.this.getUniqueId(), aqVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bIk();
        }
    };
    private long fOv = -1;
    private d.a fOw = new d.a() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.bIi();
        }

        @Override // com.baidu.tieba.w.d.a
        public void acm() {
            if (LogoActivity.this.fOg != -2) {
                LogoActivity.this.bIj();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener fOx = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bHZ()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fOm);
                    LogoActivity.this.fOi = true;
                    if (LogoActivity.this.fOj) {
                        LogoActivity.this.bIk();
                    }
                }
            }
        }
    };
    private Runnable fOy = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bHX();
        }
    };
    private Runnable fOz = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bIk();
        }
    };
    private Runnable fOA = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.fOr && LogoActivity.this.fOq != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fOq);
                com.baidu.adp.lib.f.e.mY().post(LogoActivity.this.fOz);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable fOB = new Runnable() { // from class: com.baidu.tieba.LogoActivity.14
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bIi();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    private ClickableSpan fOC = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.6
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
    View.OnClickListener eUh = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes) {
                if (LogoActivity.this.fOk.isShowing()) {
                    LogoActivity.this.fOk.dismiss();
                }
                ae.jb(true);
                com.baidu.tbadk.core.sharedPref.b.bqh().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bIp() || ae.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bHX();
                    aq aqVar = new aq("c13295");
                    aqVar.dR("obj_locate", "1");
                    TiebaStatic.log(aqVar);
                    return;
                }
                LogoActivity.this.bIq();
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.fOk.isShowing()) {
                    LogoActivity.this.fOk.dismiss();
                }
                aq aqVar2 = new aq("c13295");
                aqVar2.dR("obj_locate", "2");
                TiebaStatic.log(aqVar2);
                if (LogoActivity.this.fOl == null) {
                    LogoActivity.this.bIo();
                }
                LogoActivity.this.fOl.bpc();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.fOl.isShowing()) {
                    LogoActivity.this.fOl.dismiss();
                }
                if (LogoActivity.this.fOk == null) {
                    LogoActivity.this.bIn();
                }
                LogoActivity.this.fOk.bpc();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bHX() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.fOh = true;
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
                LogoActivity.this.bIm();
                LogoActivity.bIl();
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
        this.fOv = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dIX().z(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (!ae.bqV()) {
            bIn();
            this.fOk.bpc();
            TiebaStatic.log(new aq("c13294"));
        } else if (!bIp() && !ae.checkLocationForGoogle(getActivity())) {
            bIq();
        } else {
            if (ae.checkLocationForGoogle(getActivity())) {
                com.baidu.adp.lib.c.a.mk().getAddress(false);
            }
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            if (bHZ()) {
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                try {
                    setContentView(R.layout.logo_activity);
                    this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                    LogoActivityConfig.isFirst = true;
                    registerListener(this.fOx);
                    this.fOg = -2;
                    bIe();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                } catch (Throwable th) {
                    BdLog.e(th);
                    finish();
                }
            } else if (!isTaskRoot() && !bHY()) {
                finish();
            } else {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.HOST_START).al("obj_param1", 2));
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
                this.fOc = TbadkCoreApplication.getInst().getIsFirstUse();
                n.bCz().kz(this.fOc);
                registerListener(this.fOx);
                bIa();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("type", "start");
                hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
                hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                    bIb();
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

    private boolean bHY() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new aq("c11897").dR("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHZ() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bIa() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.bjL(), getPageContext().getPageActivity());
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
        if (this.fOt != null && this.fOt.getView() != null && this.fOt.getView().getParent() != null) {
            if (this.fOt.getView() != null) {
                if (this.fOt.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fOt.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.fOt.getView().setLayoutParams(layoutParams);
        }
        if (this.fOp != null && this.fOp.euM != null) {
            this.fOp.euM.biM();
        }
    }

    private void bIb() {
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
        this.fOj = false;
        if (this.fOn != null) {
            this.fOn.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fOj = true;
        if (this.fOd) {
            this.fOd = false;
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bqh().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.bqh().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (ae.bqV()) {
            NASLib.onAppStart(getActivity());
        }
        if (this.fOi) {
            bIk();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.fOh) {
            bHX();
            this.fOh = false;
        }
        if (this.fOn != null) {
            this.fOn.onResume();
        }
        if (LogoActivityConfig.isFirst && this.fOv >= 0) {
            n.bCz().dQ(System.currentTimeMillis() - this.fOv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fOp != null) {
            this.fOp.setParentView(null);
            this.fOp.a(null);
        }
        if (this.fOs != null) {
            this.fOs.setParentView(null);
            this.fOs.a(null);
        }
        if (this.fOt != null) {
            this.fOt.release();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fOm);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fOy);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fOz);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fOA);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fOB);
        if (this.fOn != null) {
            this.fOn.onDestroy();
        }
        if (this.fOb != null && !this.fOb.isRecycled()) {
            this.fOb.recycle();
            this.fOb = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.dIX().A(getUniqueId());
        com.baidu.adp.lib.util.d.oi().clearCashBitmap();
    }

    private void eF(Context context) {
        bIc();
        if (LogoActivityConfig.mFromSpacial) {
            te(2);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.fOc) {
                com.baidu.adp.lib.f.e.mY().post(this.fOy);
            } else {
                te(2);
            }
        } else if (this.fOc) {
            com.baidu.adp.lib.f.e.mY().post(this.fOy);
        } else {
            bId();
        }
    }

    private void bIc() {
        if (this.fOc) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bId() {
        if (this.fOg != -2) {
            if (this.fOn == null) {
                this.fOn = new com.baidu.tieba.w.d(this);
            }
            if (this.fOn.dSq()) {
                this.fOo = this.fOn.J(0.8125d);
                this.mRootView.addView(this.fOo);
                this.fOn.a(this.fOw);
                this.fOn.start();
                return;
            }
            this.fOn.dSu();
        }
        bIe();
    }

    private void bIe() {
        this.fOe = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.s.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.fOt = (com.baidu.tbadk.s.a) runTask.getData();
            this.fOt.a(this.fOu);
            this.fOt.bDa();
            n.bCz().dR(System.currentTimeMillis() - this.fOe);
            int i = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(this.fOB, i * 1000);
            return;
        }
        bIf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIf() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bIi();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        MessageTask findTask2 = MessageManager.getInstance().findTask(2156676);
        if (findTask2 == null && findTask == null) {
            bIi();
            return;
        }
        boolean zM = com.baidu.tbadk.a.b.zM("ad_xuzhang_splash_sdk");
        if (findTask2 != null && zM) {
            bIg();
        } else if (findTask != null) {
            bIh();
        } else {
            bIi();
        }
    }

    private void bIg() {
        this.fOe = System.currentTimeMillis();
        this.fOf = System.currentTimeMillis();
        this.fOs = new com.baidu.tbadk.g.d();
        this.fOq = new BesAdViewContainer(getPageContext().getPageActivity());
        this.fOq.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.16
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bIk();
            }
        });
        this.fOq.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.fOq);
        this.fOs.setParentView(this.fOq);
        this.fOs.a(new com.baidu.tbadk.g.c() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.c
            public void zP(String str) {
                LogoActivity.this.fOr = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fOq);
                LogoActivity.this.bIi();
                n.bCz().dS(System.currentTimeMillis() - LogoActivity.this.fOf);
            }

            @Override // com.baidu.tbadk.g.c
            public void biN() {
                LogoActivity.this.fOr = true;
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
                if (LogoActivity.this.fOg == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fOA);
                n.bCz().dT(System.currentTimeMillis());
                n.bCz().dS(System.currentTimeMillis() - LogoActivity.this.fOf);
            }

            @Override // com.baidu.tbadk.g.c
            public void biL() {
                LogoActivity.this.fOi = true;
                if (LogoActivity.this.fOj) {
                    LogoActivity.this.bIk();
                }
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdClick() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2156676, this.fOs));
        n.bCz().dR(System.currentTimeMillis() - this.fOe);
        int i = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.fOA, (i > 0 ? i : 1) * 1000);
    }

    private void bIh() {
        this.fOe = System.currentTimeMillis();
        this.fOf = System.currentTimeMillis();
        this.fOp = new com.baidu.tbadk.g.e();
        this.fOq = new BesAdViewContainer(getPageContext().getPageActivity());
        this.fOq.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bIk();
            }
        });
        this.fOq.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.fOq);
        this.fOp.setParentView(this.fOq);
        this.fOp.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tbadk.g.a
            public void zP(String str) {
                LogoActivity.this.fOr = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fOq);
                LogoActivity.this.bIi();
                n.bCz().dS(System.currentTimeMillis() - LogoActivity.this.fOf);
            }

            @Override // com.baidu.tbadk.g.a
            public void v(boolean z, boolean z2) {
                LogoActivity.this.fOr = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).al("obj_type", z2 ? 2 : 1));
                aq aqVar = new aq("common_exp");
                aqVar.dR("page_type", "a030").al("obj_isad", 1).al("obj_floor", 1).al("obj_source", 1).al("obj_adlocate", 16);
                if (z) {
                    aqVar.al("obj_type", z2 ? 4 : 3);
                } else {
                    aqVar.al("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dIX().a(LogoActivity.this.getUniqueId(), "bes_ad_id", aqVar);
                com.baidu.tieba.s.c.dIX().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.fOg == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fOA);
                n.bCz().dT(System.currentTimeMillis());
                n.bCz().dS(System.currentTimeMillis() - LogoActivity.this.fOf);
            }

            @Override // com.baidu.tbadk.g.a
            public void biL() {
                LogoActivity.this.fOi = true;
                if (LogoActivity.this.fOj) {
                    LogoActivity.this.bIk();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void w(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).al("obj_type", z2 ? 2 : 1));
                aq aqVar = new aq("common_click");
                aqVar.dR("page_type", "a030").al("obj_isad", 1).al("obj_floor", 1).al("obj_source", 1).al("obj_adlocate", 16);
                if (z) {
                    aqVar.al("obj_type", z2 ? 4 : 3);
                } else {
                    aqVar.al("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dIX().b(LogoActivity.this.getUniqueId(), aqVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.fOp));
        n.bCz().dR(System.currentTimeMillis() - this.fOe);
        int i = com.baidu.tbadk.core.sharedPref.b.bqh().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.fOA, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIi() {
        if (this.fOg == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.mY().post(this.fOz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIj() {
        if (this.fOg >= 0) {
            tf(this.fOg);
        } else if (this.fOg == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIk() {
        bIj();
        n.bCz().dU(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bIl() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            com.baidu.tbadk.core.util.n.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIm() {
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

    private void te(int i) {
        this.fOg = i;
        bId();
    }

    private void tf(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIn() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.fOC, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cp_link_tip_a)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.fOk = new com.baidu.tbadk.core.dialog.a(this);
        this.fOk.bf(inflate);
        this.fOk.oz(3);
        this.fOk.iW(false);
        this.fOk.setAutoNight(false);
        this.fOk.iV(false);
        ap.a((View) textView2, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
        ap.a((View) textView3, R.color.cp_cont_b, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.eUh);
        textView3.setOnClickListener(this.eUh);
        this.fOk.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIo() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        ap.a((View) textView2, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.eUh);
        this.fOl = new com.baidu.tbadk.core.dialog.a(this);
        this.fOl.bf(inflate);
        this.fOl.oz(3);
        this.fOl.iW(false);
        this.fOl.setAutoNight(false);
        this.fOl.iV(false);
        this.fOl.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        te(2);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        te(intExtra);
                        return;
                    } else {
                        te(2);
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
            bHX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bIp() {
        return at.equals(TbConfig.getVersion(), com.baidu.tbadk.core.sharedPref.b.bqh().getString("key_location_request_dialog_last_show_version", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIq() {
        com.baidu.tbadk.core.sharedPref.b.bqh().putString("key_location_request_dialog_last_show_version", TbConfig.getVersion());
        ae.a(getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
            public void onClose() {
                LogoActivity.this.bHX();
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
            LogoActivity.this.bIk();
        }
    }
}
