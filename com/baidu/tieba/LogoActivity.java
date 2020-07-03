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
import com.baidu.adp.lib.f.h;
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
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.GuildActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
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
    private boolean eSY;
    private com.baidu.tbadk.core.dialog.a eTb;
    private com.baidu.tbadk.core.dialog.a eTc;
    private com.baidu.tieba.w.d eTe;
    private View eTf;
    private com.baidu.tbadk.g.e eTg;
    private BesAdViewContainer eTh;
    private com.baidu.tbadk.g.d eTj;
    private com.baidu.tbadk.s.a eTk;
    private RelativeLayout mRootView;
    private Bitmap eSS = null;
    private boolean eST = false;
    private boolean eSU = true;
    private long eSV = -1;
    private long eSW = -1;
    private int eSX = -1;
    private boolean eSZ = false;
    private boolean eTa = true;
    private a eTd = new a();
    private boolean eTi = false;
    private com.baidu.tbadk.s.b eTl = new com.baidu.tbadk.s.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.s.b
        public void Pa() {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(LogoActivity.this.eTs);
            LogoActivity.this.bmY();
        }

        @Override // com.baidu.tbadk.s.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(LogoActivity.this.eTs);
            if (LogoActivity.this.eTk.getView() == null) {
                LogoActivity.this.bnd();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.eTk.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.eTk.getView());
            if (LogoActivity.this.eSX == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.bhU().cH(System.currentTimeMillis());
            TiebaStatic.log(new ao("c13331").dk("obj_id", str).ag("obj_type", z2 ? 2 : 1));
            ao aoVar = new ao("common_exp");
            aoVar.dk("page_type", "a030").ag("obj_isad", 1).dk("obj_id", str).ag("obj_floor", 1).ag("obj_source", 2).ag("obj_adlocate", 16);
            if (z) {
                aoVar.ag("obj_type", z2 ? 4 : 3);
            } else {
                aoVar.ag("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dgX().a(LogoActivity.this.getUniqueId(), str, aoVar);
            com.baidu.tieba.s.c.dgX().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.s.b
        public void aOE() {
            LogoActivity.this.eSZ = true;
            if (LogoActivity.this.eTa) {
                LogoActivity.this.bnd();
            }
        }

        @Override // com.baidu.tbadk.s.b
        public void ap(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.eTk.getView() != null) {
                z2 = LogoActivity.this.eTk.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new ao("c13332").dk("obj_id", str).ag("obj_type", z2 ? 2 : 1));
            ao aoVar = new ao("common_click");
            aoVar.dk("page_type", "a030").ag("obj_isad", 1).dk("obj_id", str).ag("obj_floor", 1).ag("obj_source", 2).ag("obj_adlocate", 16);
            if (z) {
                aoVar.ag("obj_type", z2 ? 4 : 3);
            } else {
                aoVar.ag("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dgX().b(LogoActivity.this.getUniqueId(), aoVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bnd();
        }
    };
    private long eTm = -1;
    private d.a eTn = new d.a() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.bnb();
        }

        @Override // com.baidu.tieba.w.d.a
        public void Pc() {
            if (LogoActivity.this.eSX != -2) {
                LogoActivity.this.bnc();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener eTo = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bmS()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(LogoActivity.this.eTd);
                    LogoActivity.this.eSZ = true;
                    if (LogoActivity.this.eTa) {
                        LogoActivity.this.bnd();
                    }
                }
            }
        }
    };
    private Runnable eTp = new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bmQ();
        }
    };
    private Runnable eTq = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bnd();
        }
    };
    private Runnable eTr = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.eTi && LogoActivity.this.eTh != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eTh);
                com.baidu.adp.lib.f.e.lt().post(LogoActivity.this.eTq);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable eTs = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bnb();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    private ClickableSpan eTt = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.6
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.LogoActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(LogoActivity.this.getResources().getColor(17170445));
            }
            bc.aWU().a(LogoActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(LogoActivity.this.getResources().getColor(R.color.cp_link_tip_c));
        }
    };
    View.OnClickListener ebA = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes) {
                if (LogoActivity.this.eTb.isShowing()) {
                    LogoActivity.this.eTb.dismiss();
                }
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_secret_is_show", true);
                com.baidu.tbadk.core.sharedPref.b.aVP().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bnj() || ac.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bmQ();
                    ao aoVar = new ao("c13295");
                    aoVar.dk("obj_locate", "1");
                    TiebaStatic.log(aoVar);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean("key_location_request_dialog_has_shown", true);
                ac.a(LogoActivity.this.getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.7.1
                    @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
                    public void onClose() {
                        LogoActivity.this.bmQ();
                    }
                });
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.eTb.isShowing()) {
                    LogoActivity.this.eTb.dismiss();
                }
                ao aoVar2 = new ao("c13295");
                aoVar2.dk("obj_locate", "2");
                TiebaStatic.log(aoVar2);
                if (LogoActivity.this.eTc == null) {
                    LogoActivity.this.bni();
                }
                LogoActivity.this.eTc.aUN();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.eTc.isShowing()) {
                    LogoActivity.this.eTc.dismiss();
                }
                if (LogoActivity.this.eTb == null) {
                    LogoActivity.this.bnh();
                }
                LogoActivity.this.eTb.aUN();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bmQ() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.eSY = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        h.lu().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.14
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.bnf();
                LogoActivity.bne();
            }
        });
        finish();
    }

    private void I(Intent intent) {
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
        this.eTm = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dgX().z(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (bng()) {
            bnh();
            this.eTb.aUN();
            TiebaStatic.log(new ao("c13294"));
            return;
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        if (ac.checkLocationForGoogle(getActivity())) {
            com.baidu.adp.lib.c.a.kG().getAddress(false);
        }
        if (bmS()) {
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
            try {
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.eTo);
                this.eSX = -2;
                bmX();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !bmR()) {
            finish();
        } else {
            TiebaStatic.log(new ao(TbadkCoreStatisticKey.HOST_START).ag("obj_param1", 2));
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
            }
            I(getIntent());
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
            this.eST = TbadkCoreApplication.getInst().getIsFirstUse();
            n.bhU().iz(this.eST);
            registerListener(this.eTo);
            bmT();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                bmU();
            }
            if (!com.baidu.tbadk.core.util.n.checkSD()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean bmR() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new ao("c11897").dk("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bmS() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bmT() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.aPE(), getPageContext().getPageActivity());
            }
        }
        ef(getPageContext().getPageActivity());
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
        if (this.eTk != null && this.eTk.getView() != null && this.eTk.getView().getParent() != null) {
            if (this.eTk.getView() != null) {
                if (this.eTk.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eTk.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.eTk.getView().setLayoutParams(layoutParams);
        }
        if (this.eTg != null && this.eTg.dDb != null) {
            this.eTg.dDb.aOF();
        }
    }

    private void bmU() {
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
        this.eTa = false;
        if (this.eTe != null) {
            this.eTe.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eTa = true;
        if (this.eSU) {
            this.eSU = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aVP().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.aVP().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (this.eSZ) {
            bnd();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.eSY) {
            bmQ();
            this.eSY = false;
        }
        if (this.eTe != null) {
            this.eTe.onResume();
        }
        if (LogoActivityConfig.isFirst && this.eTm >= 0) {
            n.bhU().cE(System.currentTimeMillis() - this.eTm);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eTg != null) {
            this.eTg.z(null);
            this.eTg.a(null);
        }
        if (this.eTj != null) {
            this.eTj.z(null);
            this.eTj.a(null);
        }
        if (this.eTk != null) {
            this.eTk.release();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eTd);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eTp);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eTq);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eTr);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eTs);
        if (this.eTe != null) {
            this.eTe.onDestroy();
        }
        if (this.eSS != null && !this.eSS.isRecycled()) {
            this.eSS.recycle();
            this.eSS = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.dgX().A(getUniqueId());
        com.baidu.adp.lib.util.d.mC().clearCashBitmap();
    }

    private void ef(Context context) {
        bmV();
        if (LogoActivityConfig.mFromSpacial) {
            pr(2);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.eST) {
                com.baidu.adp.lib.f.e.lt().post(this.eTp);
            } else {
                pr(2);
            }
        } else if (this.eST) {
            com.baidu.adp.lib.f.e.lt().post(this.eTp);
        } else {
            bmW();
        }
    }

    private void bmV() {
        if (this.eST) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.aVP().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bmW() {
        if (this.eSX != -2) {
            if (this.eTe == null) {
                this.eTe = new com.baidu.tieba.w.d(this);
            }
            if (this.eTe.dqi()) {
                this.eTf = this.eTe.z(0.8125d);
                this.mRootView.addView(this.eTf);
                this.eTe.a(this.eTn);
                this.eTe.start();
                return;
            }
            this.eTe.dqm();
        }
        bmX();
    }

    private void bmX() {
        bnc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmY() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bnb();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        MessageTask findTask2 = MessageManager.getInstance().findTask(2156676);
        if (findTask2 == null && findTask == null) {
            bnb();
            return;
        }
        boolean uL = com.baidu.tbadk.a.b.uL("ad_xuzhang_splash_sdk");
        if (findTask2 != null && uL) {
            bmZ();
        } else if (findTask != null) {
            bna();
        } else {
            bnb();
        }
    }

    private void bmZ() {
        this.eSV = System.currentTimeMillis();
        this.eSW = System.currentTimeMillis();
        this.eTj = new com.baidu.tbadk.g.d();
        this.eTh = new BesAdViewContainer(getPageContext().getPageActivity());
        this.eTh.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.15
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bnd();
            }
        });
        this.eTh.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.eTh);
        this.eTj.z(this.eTh);
        this.eTj.a(new com.baidu.tbadk.g.c() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.c
            public void uN(String str) {
                LogoActivity.this.eTi = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eTh);
                LogoActivity.this.bnb();
                n.bhU().cG(System.currentTimeMillis() - LogoActivity.this.eSW);
            }

            @Override // com.baidu.tbadk.g.c
            public void aOG() {
                LogoActivity.this.eTi = true;
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
                if (LogoActivity.this.eSX == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.lt().removeCallbacks(LogoActivity.this.eTr);
                n.bhU().cH(System.currentTimeMillis());
                n.bhU().cG(System.currentTimeMillis() - LogoActivity.this.eSW);
            }

            @Override // com.baidu.tbadk.g.c
            public void aOE() {
                LogoActivity.this.eSZ = true;
                if (LogoActivity.this.eTa) {
                    LogoActivity.this.bnd();
                }
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdClick() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2156676, this.eTj));
        n.bhU().cF(System.currentTimeMillis() - this.eSV);
        int i = com.baidu.tbadk.core.sharedPref.b.aVP().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.eTr, (i > 0 ? i : 1) * 1000);
    }

    private void bna() {
        this.eSV = System.currentTimeMillis();
        this.eSW = System.currentTimeMillis();
        this.eTg = new com.baidu.tbadk.g.e();
        this.eTh = new BesAdViewContainer(getPageContext().getPageActivity());
        this.eTh.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bnd();
            }
        });
        this.eTh.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.eTh);
        this.eTg.z(this.eTh);
        this.eTg.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tbadk.g.a
            public void uN(String str) {
                LogoActivity.this.eTi = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eTh);
                LogoActivity.this.bnb();
                n.bhU().cG(System.currentTimeMillis() - LogoActivity.this.eSW);
            }

            @Override // com.baidu.tbadk.g.a
            public void r(boolean z, boolean z2) {
                LogoActivity.this.eTi = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new ao(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).ag("obj_type", z2 ? 2 : 1));
                ao aoVar = new ao("common_exp");
                aoVar.dk("page_type", "a030").ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_source", 1).ag("obj_adlocate", 16);
                if (z) {
                    aoVar.ag("obj_type", z2 ? 4 : 3);
                } else {
                    aoVar.ag("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dgX().a(LogoActivity.this.getUniqueId(), "bes_ad_id", aoVar);
                com.baidu.tieba.s.c.dgX().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.eSX == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.lt().removeCallbacks(LogoActivity.this.eTr);
                n.bhU().cH(System.currentTimeMillis());
                n.bhU().cG(System.currentTimeMillis() - LogoActivity.this.eSW);
            }

            @Override // com.baidu.tbadk.g.a
            public void aOE() {
                LogoActivity.this.eSZ = true;
                if (LogoActivity.this.eTa) {
                    LogoActivity.this.bnd();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void s(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new ao(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).ag("obj_type", z2 ? 2 : 1));
                ao aoVar = new ao("common_click");
                aoVar.dk("page_type", "a030").ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_source", 1).ag("obj_adlocate", 16);
                if (z) {
                    aoVar.ag("obj_type", z2 ? 4 : 3);
                } else {
                    aoVar.ag("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dgX().b(LogoActivity.this.getUniqueId(), aoVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.eTg));
        n.bhU().cF(System.currentTimeMillis() - this.eSV);
        int i = com.baidu.tbadk.core.sharedPref.b.aVP().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.eTr, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnb() {
        if (this.eSX == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.lt().post(this.eTq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnc() {
        if (this.eSX >= 0) {
            ps(this.eSX);
        } else if (this.eSX == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnd() {
        bnc();
        n.bhU().cI(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bne() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            com.baidu.tbadk.core.util.n.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnf() {
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

    private void pr(int i) {
        this.eSX = i;
        bmW();
    }

    private void ps(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private boolean bng() {
        return !com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_secret_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnh() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.eTt, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cp_link_tip_a)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.eTb = new com.baidu.tbadk.core.dialog.a(this);
        this.eTb.aP(inflate);
        this.eTb.kW(3);
        this.eTb.hg(false);
        this.eTb.setAutoNight(false);
        this.eTb.hf(false);
        an.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        an.a((View) textView3, (int) R.color.cp_cont_b, (int) R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.ebA);
        textView3.setOnClickListener(this.ebA);
        this.eTb.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bni() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        an.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.ebA);
        this.eTc = new com.baidu.tbadk.core.dialog.a(this);
        this.eTc.aP(inflate);
        this.eTc.kW(3);
        this.eTc.hg(false);
        this.eTc.setAutoNight(false);
        this.eTc.hf(false);
        this.eTc.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        pr(2);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        pr(intExtra);
                        return;
                    } else {
                        pr(2);
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
            com.baidu.adp.lib.c.a.kG().getAddress(false);
            bmQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bnj() {
        return com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_location_request_dialog_has_shown", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bnd();
        }
    }
}
