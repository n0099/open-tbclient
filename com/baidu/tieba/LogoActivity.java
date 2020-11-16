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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.n.n;
import com.baidu.tbadk.switchs.AdSdkSwitch;
import com.baidu.tieba.view.BesAdViewContainer;
import com.baidu.tieba.x.d;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private static final String DOWNLOAD_DIR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    private boolean fNK;
    private com.baidu.tbadk.core.dialog.a fNN;
    private com.baidu.tbadk.core.dialog.a fNO;
    private com.baidu.tieba.x.d fNQ;
    private View fNR;
    private com.baidu.tbadk.g.e fNS;
    private BesAdViewContainer fNT;
    private com.baidu.tbadk.g.d fNV;
    private com.baidu.tbadk.s.a fNW;
    private RelativeLayout mRootView;
    private Bitmap fNE = null;
    private boolean fNF = false;
    private boolean fNG = true;
    private long fNH = -1;
    private long fNI = -1;
    private int fNJ = -1;
    private boolean fNL = false;
    private boolean fNM = true;
    private a fNP = new a();
    private boolean fNU = false;
    private com.baidu.tbadk.s.b fNX = new com.baidu.tbadk.s.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.s.b
        public void abB() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fOe);
            LogoActivity.this.bHy();
        }

        @Override // com.baidu.tbadk.s.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fOe);
            if (LogoActivity.this.fNW.getView() == null) {
                LogoActivity.this.bHD();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.fNW.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.fNW.getView());
            if (LogoActivity.this.fNJ == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.bBO().dS(System.currentTimeMillis());
            TiebaStatic.log(new ar("c13331").dR("obj_id", str).ak("obj_type", z2 ? 2 : 1));
            ar arVar = new ar("common_exp");
            arVar.dR("page_type", "a030").ak("obj_isad", 1).dR("obj_id", str).ak("obj_floor", 1).ak("obj_source", 2).ak("obj_adlocate", 16);
            if (z) {
                arVar.ak("obj_type", z2 ? 4 : 3);
            } else {
                arVar.ak("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.t.c.dIO().a(LogoActivity.this.getUniqueId(), str, arVar);
            com.baidu.tieba.t.c.dIO().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.s.b
        public void bif() {
            LogoActivity.this.fNL = true;
            if (LogoActivity.this.fNM) {
                LogoActivity.this.bHD();
            }
        }

        @Override // com.baidu.tbadk.s.b
        public void ay(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.fNW.getView() != null) {
                z2 = LogoActivity.this.fNW.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new ar("c13332").dR("obj_id", str).ak("obj_type", z2 ? 2 : 1));
            ar arVar = new ar("common_click");
            arVar.dR("page_type", "a030").ak("obj_isad", 1).dR("obj_id", str).ak("obj_floor", 1).ak("obj_source", 2).ak("obj_adlocate", 16);
            if (z) {
                arVar.ak("obj_type", z2 ? 4 : 3);
            } else {
                arVar.ak("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.t.c.dIO().b(LogoActivity.this.getUniqueId(), arVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bHD();
        }
    };
    private long fNY = -1;
    private d.a fNZ = new d.a() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // com.baidu.tieba.x.d.a
        public void onError() {
            LogoActivity.this.bHB();
        }

        @Override // com.baidu.tieba.x.d.a
        public void abD() {
            if (LogoActivity.this.fNJ != -2) {
                LogoActivity.this.bHC();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener fOa = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bHs()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fNP);
                    LogoActivity.this.fNL = true;
                    if (LogoActivity.this.fNM) {
                        LogoActivity.this.bHD();
                    }
                }
            }
        }
    };
    private Runnable fOb = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bHq();
        }
    };
    private Runnable fOc = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bHD();
        }
    };
    private Runnable fOd = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.fNU && LogoActivity.this.fNT != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fNT);
                com.baidu.adp.lib.f.e.mY().post(LogoActivity.this.fOc);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable fOe = new Runnable() { // from class: com.baidu.tieba.LogoActivity.14
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bHB();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    private ClickableSpan fOf = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(LogoActivity.this.getResources().getColor(17170445));
            }
            com.baidu.tbadk.browser.a.startExternWebActivity(LogoActivity.this.getActivity(), "http://tieba.baidu.com/tb/cms/client/wise_secretright.html");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(LogoActivity.this.getResources().getColor(R.color.CAM_X0304));
        }
    };
    View.OnClickListener eTp = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes) {
                if (LogoActivity.this.fNN.isShowing()) {
                    LogoActivity.this.fNN.dismiss();
                }
                ae.jc(true);
                com.baidu.tbadk.core.sharedPref.b.bpu().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bHI() || ae.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bHq();
                    ar arVar = new ar("c13295");
                    arVar.dR("obj_locate", "1");
                    TiebaStatic.log(arVar);
                    return;
                }
                LogoActivity.this.bHJ();
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.fNN.isShowing()) {
                    LogoActivity.this.fNN.dismiss();
                }
                ar arVar2 = new ar("c13295");
                arVar2.dR("obj_locate", "2");
                TiebaStatic.log(arVar2);
                if (LogoActivity.this.fNO == null) {
                    LogoActivity.this.bHH();
                }
                LogoActivity.this.fNO.bog();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.fNO.isShowing()) {
                    LogoActivity.this.fNO.dismiss();
                }
                if (LogoActivity.this.fNN == null) {
                    LogoActivity.this.bHG();
                }
                LogoActivity.this.fNN.bog();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bHq() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.fNK = true;
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
                LogoActivity.this.bHF();
                LogoActivity.bHE();
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
        this.fNY = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.t.c.dIO().z(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (!ae.bqi()) {
            bHG();
            this.fNN.bog();
            TiebaStatic.log(new ar("c13294"));
        } else if (!bHI() && !ae.checkLocationForGoogle(getActivity())) {
            bHJ();
        } else {
            if (ae.checkLocationForGoogle(getActivity())) {
                com.baidu.adp.lib.c.a.mk().getAddress(false);
            }
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            if (bHs()) {
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                try {
                    setContentView(R.layout.logo_activity);
                    this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                    LogoActivityConfig.isFirst = true;
                    registerListener(this.fOa);
                    this.fNJ = -2;
                    bHx();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                } catch (Throwable th) {
                    BdLog.e(th);
                    finish();
                }
            } else if (!isTaskRoot() && !bHr()) {
                finish();
            } else {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.HOST_START).ak("obj_param1", 2));
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
                this.fNF = TbadkCoreApplication.getInst().getIsFirstUse();
                n.bBO().kA(this.fNF);
                registerListener(this.fOa);
                bHt();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("type", "start");
                hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
                hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                    bHu();
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

    private boolean bHr() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new ar("c11897").dR("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHs() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bHt() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.biP(), getPageContext().getPageActivity());
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
        if (this.fNW != null && this.fNW.getView() != null && this.fNW.getView().getParent() != null) {
            if (this.fNW.getView() != null) {
                if (this.fNW.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fNW.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.fNW.getView().setLayoutParams(layoutParams);
        }
        if (this.fNS != null && this.fNS.eth != null) {
            this.fNS.eth.big();
        }
    }

    private void bHu() {
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
        this.fNM = false;
        if (this.fNQ != null) {
            this.fNQ.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fNM = true;
        if (this.fNG) {
            this.fNG = false;
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bpu().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.bpu().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (ae.bqi()) {
            NASLib.onAppStart(getActivity());
        }
        if (this.fNL) {
            bHD();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.fNK) {
            bHq();
            this.fNK = false;
        }
        if (this.fNQ != null) {
            this.fNQ.onResume();
        }
        if (LogoActivityConfig.isFirst && this.fNY >= 0) {
            n.bBO().dP(System.currentTimeMillis() - this.fNY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fNS != null) {
            this.fNS.setParentView(null);
            this.fNS.a(null);
        }
        if (this.fNV != null) {
            this.fNV.setParentView(null);
            this.fNV.a(null);
        }
        if (this.fNW != null) {
            this.fNW.release();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fNP);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fOb);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fOc);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fOd);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fOe);
        if (this.fNQ != null) {
            this.fNQ.onDestroy();
        }
        if (this.fNE != null && !this.fNE.isRecycled()) {
            this.fNE.recycle();
            this.fNE = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.t.c.dIO().A(getUniqueId());
        com.baidu.adp.lib.util.d.oi().clearCashBitmap();
    }

    private void eF(Context context) {
        bHv();
        if (LogoActivityConfig.mFromSpacial) {
            tC(2);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.fNF) {
                com.baidu.adp.lib.f.e.mY().post(this.fOb);
            } else {
                tC(2);
            }
        } else if (this.fNF) {
            com.baidu.adp.lib.f.e.mY().post(this.fOb);
        } else {
            bHw();
        }
    }

    private void bHv() {
        if (this.fNF) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bHw() {
        if (this.fNJ != -2) {
            if (this.fNQ == null) {
                this.fNQ = new com.baidu.tieba.x.d(this);
            }
            if (this.fNQ.dSp()) {
                this.fNR = this.fNQ.J(0.8125d);
                this.mRootView.addView(this.fNR);
                this.fNQ.a(this.fNZ);
                this.fNQ.start();
                return;
            }
            this.fNQ.dSt();
        }
        bHx();
    }

    private void bHx() {
        this.fNH = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.s.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.fNW = (com.baidu.tbadk.s.a) runTask.getData();
            this.fNW.a(this.fNX);
            this.fNW.bCt();
            n.bBO().dQ(System.currentTimeMillis() - this.fNH);
            int i = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(this.fOe, i * 1000);
            return;
        }
        bHy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHy() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bHB();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        MessageTask findTask2 = MessageManager.getInstance().findTask(2156676);
        if (findTask2 == null && findTask == null) {
            bHB();
            return;
        }
        boolean zG = com.baidu.tbadk.a.b.zG("ad_xuzhang_splash_sdk");
        if (findTask2 != null && zG) {
            bHz();
        } else if (findTask != null) {
            bHA();
        } else {
            bHB();
        }
    }

    private void bHz() {
        this.fNH = System.currentTimeMillis();
        this.fNI = System.currentTimeMillis();
        this.fNV = new com.baidu.tbadk.g.d();
        this.fNT = new BesAdViewContainer(getPageContext().getPageActivity());
        this.fNT.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.16
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bHD();
            }
        });
        this.fNT.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.fNT);
        this.fNV.setParentView(this.fNT);
        this.fNV.a(new com.baidu.tbadk.g.c() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.c
            public void zJ(String str) {
                LogoActivity.this.fNU = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fNT);
                LogoActivity.this.bHB();
                n.bBO().dR(System.currentTimeMillis() - LogoActivity.this.fNI);
            }

            @Override // com.baidu.tbadk.g.c
            public void bih() {
                LogoActivity.this.fNU = true;
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
                if (LogoActivity.this.fNJ == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fOd);
                n.bBO().dS(System.currentTimeMillis());
                n.bBO().dR(System.currentTimeMillis() - LogoActivity.this.fNI);
            }

            @Override // com.baidu.tbadk.g.c
            public void bif() {
                LogoActivity.this.fNL = true;
                if (LogoActivity.this.fNM) {
                    LogoActivity.this.bHD();
                }
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdClick() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2156676, this.fNV));
        n.bBO().dQ(System.currentTimeMillis() - this.fNH);
        int i = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.fOd, (i > 0 ? i : 1) * 1000);
    }

    private void bHA() {
        this.fNH = System.currentTimeMillis();
        this.fNI = System.currentTimeMillis();
        this.fNS = new com.baidu.tbadk.g.e();
        this.fNT = new BesAdViewContainer(getPageContext().getPageActivity());
        this.fNT.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bHD();
            }
        });
        this.fNT.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.fNT);
        this.fNS.setParentView(this.fNT);
        this.fNS.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tbadk.g.a
            public void zJ(String str) {
                LogoActivity.this.fNU = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fNT);
                LogoActivity.this.bHB();
                n.bBO().dR(System.currentTimeMillis() - LogoActivity.this.fNI);
            }

            @Override // com.baidu.tbadk.g.a
            public void v(boolean z, boolean z2) {
                LogoActivity.this.fNU = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new ar(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).ak("obj_type", z2 ? 2 : 1));
                ar arVar = new ar("common_exp");
                arVar.dR("page_type", "a030").ak("obj_isad", 1).ak("obj_floor", 1).ak("obj_source", 1).ak("obj_adlocate", 16);
                if (z) {
                    arVar.ak("obj_type", z2 ? 4 : 3);
                } else {
                    arVar.ak("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.t.c.dIO().a(LogoActivity.this.getUniqueId(), "bes_ad_id", arVar);
                com.baidu.tieba.t.c.dIO().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.fNJ == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fOd);
                n.bBO().dS(System.currentTimeMillis());
                n.bBO().dR(System.currentTimeMillis() - LogoActivity.this.fNI);
            }

            @Override // com.baidu.tbadk.g.a
            public void bif() {
                LogoActivity.this.fNL = true;
                if (LogoActivity.this.fNM) {
                    LogoActivity.this.bHD();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void w(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new ar(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).ak("obj_type", z2 ? 2 : 1));
                ar arVar = new ar("common_click");
                arVar.dR("page_type", "a030").ak("obj_isad", 1).ak("obj_floor", 1).ak("obj_source", 1).ak("obj_adlocate", 16);
                if (z) {
                    arVar.ak("obj_type", z2 ? 4 : 3);
                } else {
                    arVar.ak("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.t.c.dIO().b(LogoActivity.this.getUniqueId(), arVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.fNS));
        n.bBO().dQ(System.currentTimeMillis() - this.fNH);
        int i = com.baidu.tbadk.core.sharedPref.b.bpu().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.fOd, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHB() {
        if (this.fNJ == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.mY().post(this.fOc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHC() {
        if (this.fNJ >= 0) {
            tD(this.fNJ);
        } else if (this.fNJ == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHD() {
        bHC();
        n.bBO().dT(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bHE() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            com.baidu.tbadk.core.util.n.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHF() {
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

    private void tC(int i) {
        this.fNJ = i;
        bHw();
    }

    private void tD(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHG() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.fOf, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0302)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.fNN = new com.baidu.tbadk.core.dialog.a(this);
        this.fNN.bg(inflate);
        this.fNN.ov(3);
        this.fNN.iX(false);
        this.fNN.setAutoNight(false);
        this.fNN.iW(false);
        ap.a((View) textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        ap.a((View) textView3, R.color.CAM_X0105, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.eTp);
        textView3.setOnClickListener(this.eTp);
        this.fNN.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHH() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        ap.a((View) textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.eTp);
        this.fNO = new com.baidu.tbadk.core.dialog.a(this);
        this.fNO.bg(inflate);
        this.fNO.ov(3);
        this.fNO.iX(false);
        this.fNO.setAutoNight(false);
        this.fNO.iW(false);
        this.fNO.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        tC(2);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        tC(intExtra);
                        return;
                    } else {
                        tC(2);
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
            bHq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bHI() {
        return au.equals(TbConfig.getVersion(), com.baidu.tbadk.core.sharedPref.b.bpu().getString("key_location_request_dialog_last_show_version", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHJ() {
        com.baidu.tbadk.core.sharedPref.b.bpu().putString("key_location_request_dialog_last_show_version", TbConfig.getVersion());
        ae.a(getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
            public void onClose() {
                LogoActivity.this.bHq();
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
            LogoActivity.this.bHD();
        }
    }
}
