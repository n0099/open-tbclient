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
    private boolean fnI;
    private com.baidu.tbadk.core.dialog.a fnL;
    private com.baidu.tbadk.core.dialog.a fnM;
    private com.baidu.tieba.w.d fnO;
    private View fnP;
    private com.baidu.tbadk.g.e fnQ;
    private BesAdViewContainer fnR;
    private com.baidu.tbadk.g.d fnT;
    private com.baidu.tbadk.s.a fnU;
    private RelativeLayout mRootView;
    private Bitmap fnC = null;
    private boolean fnD = false;
    private boolean fnE = true;
    private long fnF = -1;
    private long fnG = -1;
    private int fnH = -1;
    private boolean fnJ = false;
    private boolean fnK = true;
    private a fnN = new a();
    private boolean fnS = false;
    private com.baidu.tbadk.s.b fnV = new com.baidu.tbadk.s.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.s.b
        public void VU() {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(LogoActivity.this.foc);
            LogoActivity.this.bBb();
        }

        @Override // com.baidu.tbadk.s.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.mX().removeCallbacks(LogoActivity.this.foc);
            if (LogoActivity.this.fnU.getView() == null) {
                LogoActivity.this.bBg();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.fnU.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.fnU.getView());
            if (LogoActivity.this.fnH == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.bvx().dn(System.currentTimeMillis());
            TiebaStatic.log(new aq("c13331").dF("obj_id", str).ai("obj_type", z2 ? 2 : 1));
            aq aqVar = new aq("common_exp");
            aqVar.dF("page_type", "a030").ai("obj_isad", 1).dF("obj_id", str).ai("obj_floor", 1).ai("obj_source", 2).ai("obj_adlocate", 16);
            if (z) {
                aqVar.ai("obj_type", z2 ? 4 : 3);
            } else {
                aqVar.ai("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dzC().a(LogoActivity.this.getUniqueId(), str, aqVar);
            com.baidu.tieba.s.c.dzC().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.s.b
        public void bbK() {
            LogoActivity.this.fnJ = true;
            if (LogoActivity.this.fnK) {
                LogoActivity.this.bBg();
            }
        }

        @Override // com.baidu.tbadk.s.b
        public void as(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.fnU.getView() != null) {
                z2 = LogoActivity.this.fnU.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new aq("c13332").dF("obj_id", str).ai("obj_type", z2 ? 2 : 1));
            aq aqVar = new aq("common_click");
            aqVar.dF("page_type", "a030").ai("obj_isad", 1).dF("obj_id", str).ai("obj_floor", 1).ai("obj_source", 2).ai("obj_adlocate", 16);
            if (z) {
                aqVar.ai("obj_type", z2 ? 4 : 3);
            } else {
                aqVar.ai("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dzC().b(LogoActivity.this.getUniqueId(), aqVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bBg();
        }
    };
    private long fnW = -1;
    private d.a fnX = new d.a() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.bBe();
        }

        @Override // com.baidu.tieba.w.d.a
        public void VW() {
            if (LogoActivity.this.fnH != -2) {
                LogoActivity.this.bBf();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener fnY = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bAV()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.mX().removeCallbacks(LogoActivity.this.fnN);
                    LogoActivity.this.fnJ = true;
                    if (LogoActivity.this.fnK) {
                        LogoActivity.this.bBg();
                    }
                }
            }
        }
    };
    private Runnable fnZ = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bAT();
        }
    };
    private Runnable foa = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bBg();
        }
    };
    private Runnable fob = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.fnS && LogoActivity.this.fnR != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fnR);
                com.baidu.adp.lib.f.e.mX().post(LogoActivity.this.foa);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable foc = new Runnable() { // from class: com.baidu.tieba.LogoActivity.14
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bBe();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    private ClickableSpan fod = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.6
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
    View.OnClickListener etM = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes) {
                if (LogoActivity.this.fnL.isShowing()) {
                    LogoActivity.this.fnL.dismiss();
                }
                ae.ij(true);
                com.baidu.tbadk.core.sharedPref.b.bjf().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bBl() || ae.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bAT();
                    aq aqVar = new aq("c13295");
                    aqVar.dF("obj_locate", "1");
                    TiebaStatic.log(aqVar);
                    return;
                }
                LogoActivity.this.bBm();
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.fnL.isShowing()) {
                    LogoActivity.this.fnL.dismiss();
                }
                aq aqVar2 = new aq("c13295");
                aqVar2.dF("obj_locate", "2");
                TiebaStatic.log(aqVar2);
                if (LogoActivity.this.fnM == null) {
                    LogoActivity.this.bBk();
                }
                LogoActivity.this.fnM.bia();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.fnM.isShowing()) {
                    LogoActivity.this.fnM.dismiss();
                }
                if (LogoActivity.this.fnL == null) {
                    LogoActivity.this.bBj();
                }
                LogoActivity.this.fnL.bia();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bAT() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.fnI = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        com.baidu.adp.lib.f.h.mY().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.15
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.bBi();
                LogoActivity.bBh();
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
        this.fnW = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dzC().z(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (!ae.bjT()) {
            bBj();
            this.fnL.bia();
            TiebaStatic.log(new aq("c13294"));
        } else if (!bBl() && !ae.checkLocationForGoogle(getActivity())) {
            bBm();
        } else {
            if (ae.checkLocationForGoogle(getActivity())) {
                com.baidu.adp.lib.c.a.mj().getAddress(false);
            }
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            if (bAV()) {
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                try {
                    setContentView(R.layout.logo_activity);
                    this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                    LogoActivityConfig.isFirst = true;
                    registerListener(this.fnY);
                    this.fnH = -2;
                    bBa();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                } catch (Throwable th) {
                    BdLog.e(th);
                    finish();
                }
            } else if (!isTaskRoot() && !bAU()) {
                finish();
            } else {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.HOST_START).ai("obj_param1", 2));
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
                this.fnD = TbadkCoreApplication.getInst().getIsFirstUse();
                n.bvx().jF(this.fnD);
                registerListener(this.fnY);
                bAW();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("type", "start");
                hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
                hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                    bAX();
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

    private boolean bAU() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new aq("c11897").dF("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAV() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bAW() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.bcK(), getPageContext().getPageActivity());
            }
        }
        ey(getPageContext().getPageActivity());
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
        if (this.fnU != null && this.fnU.getView() != null && this.fnU.getView().getParent() != null) {
            if (this.fnU.getView() != null) {
                if (this.fnU.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fnU.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.fnU.getView().setLayoutParams(layoutParams);
        }
        if (this.fnQ != null && this.fnQ.dUt != null) {
            this.fnQ.dUt.bbL();
        }
    }

    private void bAX() {
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
        this.fnK = false;
        if (this.fnO != null) {
            this.fnO.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fnK = true;
        if (this.fnE) {
            this.fnE = false;
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bjf().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.bjf().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (ae.bjT()) {
            NASLib.onAppStart(getActivity());
        }
        if (this.fnJ) {
            bBg();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.fnI) {
            bAT();
            this.fnI = false;
        }
        if (this.fnO != null) {
            this.fnO.onResume();
        }
        if (LogoActivityConfig.isFirst && this.fnW >= 0) {
            n.bvx().dk(System.currentTimeMillis() - this.fnW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fnQ != null) {
            this.fnQ.setParentView(null);
            this.fnQ.a(null);
        }
        if (this.fnT != null) {
            this.fnT.setParentView(null);
            this.fnT.a(null);
        }
        if (this.fnU != null) {
            this.fnU.release();
        }
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.fnN);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.fnZ);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.foa);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.fob);
        com.baidu.adp.lib.f.e.mX().removeCallbacks(this.foc);
        if (this.fnO != null) {
            this.fnO.onDestroy();
        }
        if (this.fnC != null && !this.fnC.isRecycled()) {
            this.fnC.recycle();
            this.fnC = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.dzC().A(getUniqueId());
        com.baidu.adp.lib.util.d.oh().clearCashBitmap();
    }

    private void ey(Context context) {
        bAY();
        if (LogoActivityConfig.mFromSpacial) {
            sl(2);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.fnD) {
                com.baidu.adp.lib.f.e.mX().post(this.fnZ);
            } else {
                sl(2);
            }
        } else if (this.fnD) {
            com.baidu.adp.lib.f.e.mX().post(this.fnZ);
        } else {
            bAZ();
        }
    }

    private void bAY() {
        if (this.fnD) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bAZ() {
        if (this.fnH != -2) {
            if (this.fnO == null) {
                this.fnO = new com.baidu.tieba.w.d(this);
            }
            if (this.fnO.dIU()) {
                this.fnP = this.fnO.F(0.8125d);
                this.mRootView.addView(this.fnP);
                this.fnO.a(this.fnX);
                this.fnO.start();
                return;
            }
            this.fnO.dIY();
        }
        bBa();
    }

    private void bBa() {
        this.fnF = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.s.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.fnU = (com.baidu.tbadk.s.a) runTask.getData();
            this.fnU.a(this.fnV);
            this.fnU.bvY();
            n.bvx().dl(System.currentTimeMillis() - this.fnF);
            int i = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.mX().postDelayed(this.foc, i * 1000);
            return;
        }
        bBb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBb() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bBe();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        MessageTask findTask2 = MessageManager.getInstance().findTask(2156676);
        if (findTask2 == null && findTask == null) {
            bBe();
            return;
        }
        boolean yt = com.baidu.tbadk.a.b.yt("ad_xuzhang_splash_sdk");
        if (findTask2 != null && yt) {
            bBc();
        } else if (findTask != null) {
            bBd();
        } else {
            bBe();
        }
    }

    private void bBc() {
        this.fnF = System.currentTimeMillis();
        this.fnG = System.currentTimeMillis();
        this.fnT = new com.baidu.tbadk.g.d();
        this.fnR = new BesAdViewContainer(getPageContext().getPageActivity());
        this.fnR.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.16
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bBg();
            }
        });
        this.fnR.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.fnR);
        this.fnT.setParentView(this.fnR);
        this.fnT.a(new com.baidu.tbadk.g.c() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.c
            public void yw(String str) {
                LogoActivity.this.fnS = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fnR);
                LogoActivity.this.bBe();
                n.bvx().dm(System.currentTimeMillis() - LogoActivity.this.fnG);
            }

            @Override // com.baidu.tbadk.g.c
            public void bbM() {
                LogoActivity.this.fnS = true;
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
                if (LogoActivity.this.fnH == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mX().removeCallbacks(LogoActivity.this.fob);
                n.bvx().dn(System.currentTimeMillis());
                n.bvx().dm(System.currentTimeMillis() - LogoActivity.this.fnG);
            }

            @Override // com.baidu.tbadk.g.c
            public void bbK() {
                LogoActivity.this.fnJ = true;
                if (LogoActivity.this.fnK) {
                    LogoActivity.this.bBg();
                }
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdClick() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2156676, this.fnT));
        n.bvx().dl(System.currentTimeMillis() - this.fnF);
        int i = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mX().postDelayed(this.fob, (i > 0 ? i : 1) * 1000);
    }

    private void bBd() {
        this.fnF = System.currentTimeMillis();
        this.fnG = System.currentTimeMillis();
        this.fnQ = new com.baidu.tbadk.g.e();
        this.fnR = new BesAdViewContainer(getPageContext().getPageActivity());
        this.fnR.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bBg();
            }
        });
        this.fnR.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.fnR);
        this.fnQ.setParentView(this.fnR);
        this.fnQ.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tbadk.g.a
            public void yw(String str) {
                LogoActivity.this.fnS = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fnR);
                LogoActivity.this.bBe();
                n.bvx().dm(System.currentTimeMillis() - LogoActivity.this.fnG);
            }

            @Override // com.baidu.tbadk.g.a
            public void v(boolean z, boolean z2) {
                LogoActivity.this.fnS = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).ai("obj_type", z2 ? 2 : 1));
                aq aqVar = new aq("common_exp");
                aqVar.dF("page_type", "a030").ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_source", 1).ai("obj_adlocate", 16);
                if (z) {
                    aqVar.ai("obj_type", z2 ? 4 : 3);
                } else {
                    aqVar.ai("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dzC().a(LogoActivity.this.getUniqueId(), "bes_ad_id", aqVar);
                com.baidu.tieba.s.c.dzC().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.fnH == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mX().removeCallbacks(LogoActivity.this.fob);
                n.bvx().dn(System.currentTimeMillis());
                n.bvx().dm(System.currentTimeMillis() - LogoActivity.this.fnG);
            }

            @Override // com.baidu.tbadk.g.a
            public void bbK() {
                LogoActivity.this.fnJ = true;
                if (LogoActivity.this.fnK) {
                    LogoActivity.this.bBg();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void w(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).ai("obj_type", z2 ? 2 : 1));
                aq aqVar = new aq("common_click");
                aqVar.dF("page_type", "a030").ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_source", 1).ai("obj_adlocate", 16);
                if (z) {
                    aqVar.ai("obj_type", z2 ? 4 : 3);
                } else {
                    aqVar.ai("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dzC().b(LogoActivity.this.getUniqueId(), aqVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.fnQ));
        n.bvx().dl(System.currentTimeMillis() - this.fnF);
        int i = com.baidu.tbadk.core.sharedPref.b.bjf().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mX().postDelayed(this.fob, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBe() {
        if (this.fnH == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.mX().post(this.foa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBf() {
        if (this.fnH >= 0) {
            sm(this.fnH);
        } else if (this.fnH == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBg() {
        bBf();
        n.bvx().m39do(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bBh() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            com.baidu.tbadk.core.util.n.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBi() {
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

    private void sl(int i) {
        this.fnH = i;
        bAZ();
    }

    private void sm(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBj() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.fod, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cp_link_tip_a)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.fnL = new com.baidu.tbadk.core.dialog.a(this);
        this.fnL.aZ(inflate);
        this.fnL.nH(3);
        this.fnL.ie(false);
        this.fnL.setAutoNight(false);
        this.fnL.id(false);
        ap.a((View) textView2, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
        ap.a((View) textView3, R.color.cp_cont_b, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.etM);
        textView3.setOnClickListener(this.etM);
        this.fnL.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBk() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        ap.a((View) textView2, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.etM);
        this.fnM = new com.baidu.tbadk.core.dialog.a(this);
        this.fnM.aZ(inflate);
        this.fnM.nH(3);
        this.fnM.ie(false);
        this.fnM.setAutoNight(false);
        this.fnM.id(false);
        this.fnM.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        sl(2);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        sl(intExtra);
                        return;
                    } else {
                        sl(2);
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
            com.baidu.adp.lib.c.a.mj().getAddress(false);
            bAT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBl() {
        return at.equals(TbConfig.getVersion(), com.baidu.tbadk.core.sharedPref.b.bjf().getString("key_location_request_dialog_last_show_version", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBm() {
        com.baidu.tbadk.core.sharedPref.b.bjf().putString("key_location_request_dialog_last_show_version", TbConfig.getVersion());
        ae.a(getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
            public void onClose() {
                LogoActivity.this.bAT();
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
            LogoActivity.this.bBg();
        }
    }
}
