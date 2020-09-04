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
    private boolean fkP;
    private com.baidu.tbadk.core.dialog.a fkS;
    private com.baidu.tbadk.core.dialog.a fkT;
    private com.baidu.tieba.w.d fkV;
    private View fkW;
    private com.baidu.tbadk.g.e fkX;
    private BesAdViewContainer fkY;
    private com.baidu.tbadk.g.d fla;
    private com.baidu.tbadk.s.a flb;
    private RelativeLayout mRootView;
    private Bitmap fkJ = null;
    private boolean fkK = false;
    private boolean fkL = true;
    private long fkM = -1;
    private long fkN = -1;
    private int fkO = -1;
    private boolean fkQ = false;
    private boolean fkR = true;
    private a fkU = new a();
    private boolean fkZ = false;
    private com.baidu.tbadk.s.b flc = new com.baidu.tbadk.s.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.s.b
        public void Vl() {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(LogoActivity.this.flj);
            LogoActivity.this.bzS();
        }

        @Override // com.baidu.tbadk.s.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.mS().removeCallbacks(LogoActivity.this.flj);
            if (LogoActivity.this.flb.getView() == null) {
                LogoActivity.this.bzX();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.flb.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.flb.getView());
            if (LogoActivity.this.fkO == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.but().dm(System.currentTimeMillis());
            TiebaStatic.log(new aq("c13331").dD("obj_id", str).ai("obj_type", z2 ? 2 : 1));
            aq aqVar = new aq("common_exp");
            aqVar.dD("page_type", "a030").ai("obj_isad", 1).dD("obj_id", str).ai("obj_floor", 1).ai("obj_source", 2).ai("obj_adlocate", 16);
            if (z) {
                aqVar.ai("obj_type", z2 ? 4 : 3);
            } else {
                aqVar.ai("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dvJ().a(LogoActivity.this.getUniqueId(), str, aqVar);
            com.baidu.tieba.s.c.dvJ().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.s.b
        public void baQ() {
            LogoActivity.this.fkQ = true;
            if (LogoActivity.this.fkR) {
                LogoActivity.this.bzX();
            }
        }

        @Override // com.baidu.tbadk.s.b
        public void as(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.flb.getView() != null) {
                z2 = LogoActivity.this.flb.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new aq("c13332").dD("obj_id", str).ai("obj_type", z2 ? 2 : 1));
            aq aqVar = new aq("common_click");
            aqVar.dD("page_type", "a030").ai("obj_isad", 1).dD("obj_id", str).ai("obj_floor", 1).ai("obj_source", 2).ai("obj_adlocate", 16);
            if (z) {
                aqVar.ai("obj_type", z2 ? 4 : 3);
            } else {
                aqVar.ai("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dvJ().b(LogoActivity.this.getUniqueId(), aqVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bzX();
        }
    };
    private long fld = -1;
    private d.a fle = new d.a() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.bzV();
        }

        @Override // com.baidu.tieba.w.d.a
        public void Vn() {
            if (LogoActivity.this.fkO != -2) {
                LogoActivity.this.bzW();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener flf = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bzM()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(LogoActivity.this.fkU);
                    LogoActivity.this.fkQ = true;
                    if (LogoActivity.this.fkR) {
                        LogoActivity.this.bzX();
                    }
                }
            }
        }
    };
    private Runnable flg = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bzK();
        }
    };
    private Runnable flh = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bzX();
        }
    };
    private Runnable fli = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.fkZ && LogoActivity.this.fkY != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fkY);
                com.baidu.adp.lib.f.e.mS().post(LogoActivity.this.flh);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable flj = new Runnable() { // from class: com.baidu.tieba.LogoActivity.14
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bzV();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    private ClickableSpan flk = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.6
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
    View.OnClickListener erH = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes) {
                if (LogoActivity.this.fkS.isShowing()) {
                    LogoActivity.this.fkS.dismiss();
                }
                ae.im(true);
                com.baidu.tbadk.core.sharedPref.b.bik().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bAc() || ae.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bzK();
                    aq aqVar = new aq("c13295");
                    aqVar.dD("obj_locate", "1");
                    TiebaStatic.log(aqVar);
                    return;
                }
                LogoActivity.this.bAd();
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.fkS.isShowing()) {
                    LogoActivity.this.fkS.dismiss();
                }
                aq aqVar2 = new aq("c13295");
                aqVar2.dD("obj_locate", "2");
                TiebaStatic.log(aqVar2);
                if (LogoActivity.this.fkT == null) {
                    LogoActivity.this.bAb();
                }
                LogoActivity.this.fkT.bhg();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.fkT.isShowing()) {
                    LogoActivity.this.fkT.dismiss();
                }
                if (LogoActivity.this.fkS == null) {
                    LogoActivity.this.bAa();
                }
                LogoActivity.this.fkS.bhg();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bzK() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.fkP = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        h.mT().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.15
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.bzZ();
                LogoActivity.bzY();
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
        this.fld = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dvJ().A(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (!ae.biY()) {
            bAa();
            this.fkS.bhg();
            TiebaStatic.log(new aq("c13294"));
        } else if (!bAc() && !ae.checkLocationForGoogle(getActivity())) {
            bAd();
        } else {
            if (ae.checkLocationForGoogle(getActivity())) {
                com.baidu.adp.lib.c.a.mf().getAddress(false);
            }
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            if (bzM()) {
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                try {
                    setContentView(R.layout.logo_activity);
                    this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                    LogoActivityConfig.isFirst = true;
                    registerListener(this.flf);
                    this.fkO = -2;
                    bzR();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                } catch (Throwable th) {
                    BdLog.e(th);
                    finish();
                }
            } else if (!isTaskRoot() && !bzL()) {
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
                this.fkK = TbadkCoreApplication.getInst().getIsFirstUse();
                n.but().jE(this.fkK);
                registerListener(this.flf);
                bzN();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("type", "start");
                hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
                hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                    bzO();
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

    private boolean bzL() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new aq("c11897").dD("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bzM() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bzN() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.bbQ(), getPageContext().getPageActivity());
            }
        }
        es(getPageContext().getPageActivity());
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
        if (this.flb != null && this.flb.getView() != null && this.flb.getView().getParent() != null) {
            if (this.flb.getView() != null) {
                if (this.flb.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.flb.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.flb.getView().setLayoutParams(layoutParams);
        }
        if (this.fkX != null && this.fkX.dSj != null) {
            this.fkX.dSj.baR();
        }
    }

    private void bzO() {
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
        this.fkR = false;
        if (this.fkV != null) {
            this.fkV.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fkR = true;
        if (this.fkL) {
            this.fkL = false;
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bik().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.bik().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (ae.biY()) {
            NASLib.onAppStart(getActivity());
        }
        if (this.fkQ) {
            bzX();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.fkP) {
            bzK();
            this.fkP = false;
        }
        if (this.fkV != null) {
            this.fkV.onResume();
        }
        if (LogoActivityConfig.isFirst && this.fld >= 0) {
            n.but().dj(System.currentTimeMillis() - this.fld);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fkX != null) {
            this.fkX.B(null);
            this.fkX.a(null);
        }
        if (this.fla != null) {
            this.fla.B(null);
            this.fla.a(null);
        }
        if (this.flb != null) {
            this.flb.release();
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fkU);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.flg);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.flh);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.fli);
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.flj);
        if (this.fkV != null) {
            this.fkV.onDestroy();
        }
        if (this.fkJ != null && !this.fkJ.isRecycled()) {
            this.fkJ.recycle();
            this.fkJ = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.dvJ().B(getUniqueId());
        com.baidu.adp.lib.util.d.ob().clearCashBitmap();
    }

    private void es(Context context) {
        bzP();
        if (LogoActivityConfig.mFromSpacial) {
            rU(2);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.fkK) {
                com.baidu.adp.lib.f.e.mS().post(this.flg);
            } else {
                rU(2);
            }
        } else if (this.fkK) {
            com.baidu.adp.lib.f.e.mS().post(this.flg);
        } else {
            bzQ();
        }
    }

    private void bzP() {
        if (this.fkK) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.bik().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bzQ() {
        if (this.fkO != -2) {
            if (this.fkV == null) {
                this.fkV = new com.baidu.tieba.w.d(this);
            }
            if (this.fkV.dFa()) {
                this.fkW = this.fkV.F(0.8125d);
                this.mRootView.addView(this.fkW);
                this.fkV.a(this.fle);
                this.fkV.start();
                return;
            }
            this.fkV.dFe();
        }
        bzR();
    }

    private void bzR() {
        this.fkM = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.s.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.flb = (com.baidu.tbadk.s.a) runTask.getData();
            this.flb.a(this.flc);
            this.flb.buU();
            n.but().dk(System.currentTimeMillis() - this.fkM);
            int i = com.baidu.tbadk.core.sharedPref.b.bik().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.mS().postDelayed(this.flj, i * 1000);
            return;
        }
        bzS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzS() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bzV();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        MessageTask findTask2 = MessageManager.getInstance().findTask(2156676);
        if (findTask2 == null && findTask == null) {
            bzV();
            return;
        }
        boolean xZ = com.baidu.tbadk.a.b.xZ("ad_xuzhang_splash_sdk");
        if (findTask2 != null && xZ) {
            bzT();
        } else if (findTask != null) {
            bzU();
        } else {
            bzV();
        }
    }

    private void bzT() {
        this.fkM = System.currentTimeMillis();
        this.fkN = System.currentTimeMillis();
        this.fla = new com.baidu.tbadk.g.d();
        this.fkY = new BesAdViewContainer(getPageContext().getPageActivity());
        this.fkY.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.16
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bzX();
            }
        });
        this.fkY.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.fkY);
        this.fla.B(this.fkY);
        this.fla.a(new com.baidu.tbadk.g.c() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.c
            public void yb(String str) {
                LogoActivity.this.fkZ = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fkY);
                LogoActivity.this.bzV();
                n.but().dl(System.currentTimeMillis() - LogoActivity.this.fkN);
            }

            @Override // com.baidu.tbadk.g.c
            public void baS() {
                LogoActivity.this.fkZ = true;
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
                if (LogoActivity.this.fkO == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mS().removeCallbacks(LogoActivity.this.fli);
                n.but().dm(System.currentTimeMillis());
                n.but().dl(System.currentTimeMillis() - LogoActivity.this.fkN);
            }

            @Override // com.baidu.tbadk.g.c
            public void baQ() {
                LogoActivity.this.fkQ = true;
                if (LogoActivity.this.fkR) {
                    LogoActivity.this.bzX();
                }
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdClick() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2156676, this.fla));
        n.but().dk(System.currentTimeMillis() - this.fkM);
        int i = com.baidu.tbadk.core.sharedPref.b.bik().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.fli, (i > 0 ? i : 1) * 1000);
    }

    private void bzU() {
        this.fkM = System.currentTimeMillis();
        this.fkN = System.currentTimeMillis();
        this.fkX = new com.baidu.tbadk.g.e();
        this.fkY = new BesAdViewContainer(getPageContext().getPageActivity());
        this.fkY.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bzX();
            }
        });
        this.fkY.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.fkY);
        this.fkX.B(this.fkY);
        this.fkX.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tbadk.g.a
            public void yb(String str) {
                LogoActivity.this.fkZ = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fkY);
                LogoActivity.this.bzV();
                n.but().dl(System.currentTimeMillis() - LogoActivity.this.fkN);
            }

            @Override // com.baidu.tbadk.g.a
            public void v(boolean z, boolean z2) {
                LogoActivity.this.fkZ = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).ai("obj_type", z2 ? 2 : 1));
                aq aqVar = new aq("common_exp");
                aqVar.dD("page_type", "a030").ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_source", 1).ai("obj_adlocate", 16);
                if (z) {
                    aqVar.ai("obj_type", z2 ? 4 : 3);
                } else {
                    aqVar.ai("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dvJ().a(LogoActivity.this.getUniqueId(), "bes_ad_id", aqVar);
                com.baidu.tieba.s.c.dvJ().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.fkO == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mS().removeCallbacks(LogoActivity.this.fli);
                n.but().dm(System.currentTimeMillis());
                n.but().dl(System.currentTimeMillis() - LogoActivity.this.fkN);
            }

            @Override // com.baidu.tbadk.g.a
            public void baQ() {
                LogoActivity.this.fkQ = true;
                if (LogoActivity.this.fkR) {
                    LogoActivity.this.bzX();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void w(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).ai("obj_type", z2 ? 2 : 1));
                aq aqVar = new aq("common_click");
                aqVar.dD("page_type", "a030").ai("obj_isad", 1).ai("obj_floor", 1).ai("obj_source", 1).ai("obj_adlocate", 16);
                if (z) {
                    aqVar.ai("obj_type", z2 ? 4 : 3);
                } else {
                    aqVar.ai("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dvJ().b(LogoActivity.this.getUniqueId(), aqVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.fkX));
        n.but().dk(System.currentTimeMillis() - this.fkM);
        int i = com.baidu.tbadk.core.sharedPref.b.bik().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mS().postDelayed(this.fli, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzV() {
        if (this.fkO == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.mS().post(this.flh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzW() {
        if (this.fkO >= 0) {
            rV(this.fkO);
        } else if (this.fkO == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzX() {
        bzW();
        n.but().dn(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bzY() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            com.baidu.tbadk.core.util.n.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzZ() {
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

    private void rU(int i) {
        this.fkO = i;
        bzQ();
    }

    private void rV(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAa() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.flk, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cp_link_tip_a)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.fkS = new com.baidu.tbadk.core.dialog.a(this);
        this.fkS.aX(inflate);
        this.fkS.nw(3);
        this.fkS.ih(false);
        this.fkS.setAutoNight(false);
        this.fkS.ig(false);
        ap.a((View) textView2, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
        ap.a((View) textView3, R.color.cp_cont_b, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.erH);
        textView3.setOnClickListener(this.erH);
        this.fkS.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAb() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        ap.a((View) textView2, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.erH);
        this.fkT = new com.baidu.tbadk.core.dialog.a(this);
        this.fkT.aX(inflate);
        this.fkT.nw(3);
        this.fkT.ih(false);
        this.fkT.setAutoNight(false);
        this.fkT.ig(false);
        this.fkT.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        rU(2);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        rU(intExtra);
                        return;
                    } else {
                        rU(2);
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
            com.baidu.adp.lib.c.a.mf().getAddress(false);
            bzK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bAc() {
        return at.equals(TbConfig.getVersion(), com.baidu.tbadk.core.sharedPref.b.bik().getString("key_location_request_dialog_last_show_version", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAd() {
        com.baidu.tbadk.core.sharedPref.b.bik().putString("key_location_request_dialog_last_show_version", TbConfig.getVersion());
        ae.a(getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
            public void onClose() {
                LogoActivity.this.bzK();
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
            LogoActivity.this.bzX();
        }
    }
}
