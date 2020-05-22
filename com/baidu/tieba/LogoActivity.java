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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.m;
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
    private boolean eIB;
    private com.baidu.tbadk.core.dialog.a eIE;
    private com.baidu.tbadk.core.dialog.a eIF;
    private com.baidu.tieba.w.d eIH;
    private View eII;
    private com.baidu.tbadk.g.e eIJ;
    private BesAdViewContainer eIK;
    private com.baidu.tbadk.g.d eIM;
    private com.baidu.tbadk.r.a eIN;
    private RelativeLayout mRootView;
    private Bitmap eIv = null;
    private boolean eIw = false;
    private boolean eIx = true;
    private long eIy = -1;
    private long eIz = -1;
    private int eIA = -1;
    private boolean eIC = false;
    private boolean eID = true;
    private a eIG = new a();
    private boolean eIL = false;
    private com.baidu.tbadk.r.b eIO = new com.baidu.tbadk.r.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.r.b
        public void NU() {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(LogoActivity.this.eIV);
            LogoActivity.this.bkx();
        }

        @Override // com.baidu.tbadk.r.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(LogoActivity.this.eIV);
            if (LogoActivity.this.eIN.getView() == null) {
                LogoActivity.this.bkC();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.eIN.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.eIN.getView());
            if (LogoActivity.this.eIA == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.bfN().cF(System.currentTimeMillis());
            TiebaStatic.log(new an("c13331").dh("obj_id", str).ag("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_exp");
            anVar.dh("page_type", "a030").ag("obj_isad", 1).dh("obj_id", str).ag("obj_floor", 1).ag("obj_source", 2).ag("obj_adlocate", 16);
            if (z) {
                anVar.ag("obj_type", z2 ? 4 : 3);
            } else {
                anVar.ag("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dct().a(LogoActivity.this.getUniqueId(), str, anVar);
            com.baidu.tieba.s.c.dct().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.r.b
        public void aNb() {
            LogoActivity.this.eIC = true;
            if (LogoActivity.this.eID) {
                LogoActivity.this.bkC();
            }
        }

        @Override // com.baidu.tbadk.r.b
        public void an(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.eIN.getView() != null) {
                z2 = LogoActivity.this.eIN.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new an("c13332").dh("obj_id", str).ag("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_click");
            anVar.dh("page_type", "a030").ag("obj_isad", 1).dh("obj_id", str).ag("obj_floor", 1).ag("obj_source", 2).ag("obj_adlocate", 16);
            if (z) {
                anVar.ag("obj_type", z2 ? 4 : 3);
            } else {
                anVar.ag("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dct().b(LogoActivity.this.getUniqueId(), anVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bkC();
        }
    };
    private long eIP = -1;
    private d.a eIQ = new d.a() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.bkA();
        }

        @Override // com.baidu.tieba.w.d.a
        public void NW() {
            if (LogoActivity.this.eIA != -2) {
                LogoActivity.this.bkB();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener eIR = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bkr()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(LogoActivity.this.eIG);
                    LogoActivity.this.eIC = true;
                    if (LogoActivity.this.eID) {
                        LogoActivity.this.bkC();
                    }
                }
            }
        }
    };
    private Runnable eIS = new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bkp();
        }
    };
    private Runnable eIT = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bkC();
        }
    };
    private Runnable eIU = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.eIL && LogoActivity.this.eIK != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eIK);
                com.baidu.adp.lib.f.e.ld().post(LogoActivity.this.eIT);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable eIV = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bkA();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    private ClickableSpan eIW = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.6
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.LogoActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(LogoActivity.this.getResources().getColor(17170445));
            }
            ba.aUZ().a(LogoActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(LogoActivity.this.getResources().getColor(R.color.cp_link_tip_c));
        }
    };
    View.OnClickListener dUl = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes) {
                if (LogoActivity.this.eIE.isShowing()) {
                    LogoActivity.this.eIE.dismiss();
                }
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("key_secret_is_show", true);
                com.baidu.tbadk.core.sharedPref.b.aTX().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bkI() || ab.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bkp();
                    an anVar = new an("c13295");
                    anVar.dh("obj_locate", "1");
                    TiebaStatic.log(anVar);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("key_location_request_dialog_has_shown", true);
                ab.a(LogoActivity.this.getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.7.1
                    @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
                    public void onClose() {
                        LogoActivity.this.bkp();
                    }
                });
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.eIE.isShowing()) {
                    LogoActivity.this.eIE.dismiss();
                }
                an anVar2 = new an("c13295");
                anVar2.dh("obj_locate", "2");
                TiebaStatic.log(anVar2);
                if (LogoActivity.this.eIF == null) {
                    LogoActivity.this.bkH();
                }
                LogoActivity.this.eIF.aST();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.eIF.isShowing()) {
                    LogoActivity.this.eIF.dismiss();
                }
                if (LogoActivity.this.eIE == null) {
                    LogoActivity.this.bkG();
                }
                LogoActivity.this.eIE.aST();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bkp() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.eIB = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        h.le().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.14
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.bkE();
                LogoActivity.bkD();
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
        this.eIP = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dct().z(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (bkF()) {
            bkG();
            this.eIE.aST();
            TiebaStatic.log(new an("c13294"));
            return;
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        if (ab.checkLocationForGoogle(getActivity())) {
            com.baidu.adp.lib.c.a.kq().getAddress(false);
        }
        if (bkr()) {
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
            try {
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.eIR);
                this.eIA = -2;
                bkw();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !bkq()) {
            finish();
        } else {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.HOST_START).ag("obj_param1", 2));
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
            this.eIw = TbadkCoreApplication.getInst().getIsFirstUse();
            n.bfN().iq(this.eIw);
            registerListener(this.eIR);
            bks();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                bkt();
            }
            if (!m.checkSD()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean bkq() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new an("c11897").dh("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkr() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bks() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.aNU(), getPageContext().getPageActivity());
            }
        }
        ee(getPageContext().getPageActivity());
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
        if (this.eIN != null && this.eIN.getView() != null && this.eIN.getView().getParent() != null) {
            if (this.eIN.getView() != null) {
                if (this.eIN.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eIN.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.eIN.getView().setLayoutParams(layoutParams);
        }
        if (this.eIJ != null && this.eIJ.dxV != null) {
            this.eIJ.dxV.aNc();
        }
    }

    private void bkt() {
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
        this.eID = false;
        if (this.eIH != null) {
            this.eIH.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eID = true;
        if (this.eIx) {
            this.eIx = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (this.eIC) {
            bkC();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.eIB) {
            bkp();
            this.eIB = false;
        }
        if (this.eIH != null) {
            this.eIH.onResume();
        }
        if (LogoActivityConfig.isFirst && this.eIP >= 0) {
            n.bfN().cC(System.currentTimeMillis() - this.eIP);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eIJ != null) {
            this.eIJ.x(null);
            this.eIJ.a(null);
        }
        if (this.eIM != null) {
            this.eIM.x(null);
            this.eIM.a(null);
        }
        if (this.eIN != null) {
            this.eIN.release();
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eIG);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eIS);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eIT);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eIU);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eIV);
        if (this.eIH != null) {
            this.eIH.onDestroy();
        }
        if (this.eIv != null && !this.eIv.isRecycled()) {
            this.eIv.recycle();
            this.eIv = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.dct().A(getUniqueId());
        com.baidu.adp.lib.util.d.mm().clearCashBitmap();
    }

    private void ee(Context context) {
        bku();
        if (LogoActivityConfig.mFromSpacial) {
            oQ(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.eIw) {
                com.baidu.adp.lib.f.e.ld().post(this.eIS);
            } else {
                oQ(1);
            }
        } else if (this.eIw) {
            com.baidu.adp.lib.f.e.ld().post(this.eIS);
        } else {
            bkv();
        }
    }

    private void bku() {
        if (this.eIw) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bkv() {
        if (this.eIA != -2) {
            if (this.eIH == null) {
                this.eIH = new com.baidu.tieba.w.d(this);
            }
            if (this.eIH.dlI()) {
                this.eII = this.eIH.y(0.8125d);
                this.mRootView.addView(this.eII);
                this.eIH.a(this.eIQ);
                this.eIH.start();
                return;
            }
            this.eIH.dlM();
        }
        bkw();
    }

    private void bkw() {
        this.eIy = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.r.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.eIN = (com.baidu.tbadk.r.a) runTask.getData();
            this.eIN.a(this.eIO);
            this.eIN.bgg();
            n.bfN().cD(System.currentTimeMillis() - this.eIy);
            int i = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.ld().postDelayed(this.eIV, i * 1000);
            return;
        }
        bkx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkx() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bkA();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        MessageTask findTask2 = MessageManager.getInstance().findTask(2156676);
        if (findTask2 == null && findTask == null) {
            bkA();
            return;
        }
        boolean uD = com.baidu.tbadk.a.b.uD("ad_xuzhang_splash_sdk");
        if (findTask2 != null && uD) {
            bky();
        } else if (findTask != null) {
            bkz();
        } else {
            bkA();
        }
    }

    private void bky() {
        this.eIy = System.currentTimeMillis();
        this.eIz = System.currentTimeMillis();
        this.eIM = new com.baidu.tbadk.g.d();
        this.eIK = new BesAdViewContainer(getPageContext().getPageActivity());
        this.eIK.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.15
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bkC();
            }
        });
        this.eIK.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.eIK);
        this.eIM.x(this.eIK);
        this.eIM.a(new com.baidu.tbadk.g.c() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.c
            public void uF(String str) {
                LogoActivity.this.eIL = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eIK);
                LogoActivity.this.bkA();
                n.bfN().cE(System.currentTimeMillis() - LogoActivity.this.eIz);
            }

            @Override // com.baidu.tbadk.g.c
            public void aNd() {
                LogoActivity.this.eIL = true;
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
                if (LogoActivity.this.eIA == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.ld().removeCallbacks(LogoActivity.this.eIU);
                n.bfN().cF(System.currentTimeMillis());
                n.bfN().cE(System.currentTimeMillis() - LogoActivity.this.eIz);
            }

            @Override // com.baidu.tbadk.g.c
            public void aNb() {
                LogoActivity.this.eIC = true;
                if (LogoActivity.this.eID) {
                    LogoActivity.this.bkC();
                }
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdClick() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2156676, this.eIM));
        n.bfN().cD(System.currentTimeMillis() - this.eIy);
        int i = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.eIU, (i > 0 ? i : 1) * 1000);
    }

    private void bkz() {
        this.eIy = System.currentTimeMillis();
        this.eIz = System.currentTimeMillis();
        this.eIJ = new com.baidu.tbadk.g.e();
        this.eIK = new BesAdViewContainer(getPageContext().getPageActivity());
        this.eIK.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bkC();
            }
        });
        this.eIK.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.eIK);
        this.eIJ.x(this.eIK);
        this.eIJ.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tbadk.g.a
            public void uF(String str) {
                LogoActivity.this.eIL = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eIK);
                LogoActivity.this.bkA();
                n.bfN().cE(System.currentTimeMillis() - LogoActivity.this.eIz);
            }

            @Override // com.baidu.tbadk.g.a
            public void r(boolean z, boolean z2) {
                LogoActivity.this.eIL = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new an(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).ag("obj_type", z2 ? 2 : 1));
                an anVar = new an("common_exp");
                anVar.dh("page_type", "a030").ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_source", 1).ag("obj_adlocate", 16);
                if (z) {
                    anVar.ag("obj_type", z2 ? 4 : 3);
                } else {
                    anVar.ag("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dct().a(LogoActivity.this.getUniqueId(), "bes_ad_id", anVar);
                com.baidu.tieba.s.c.dct().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.eIA == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.ld().removeCallbacks(LogoActivity.this.eIU);
                n.bfN().cF(System.currentTimeMillis());
                n.bfN().cE(System.currentTimeMillis() - LogoActivity.this.eIz);
            }

            @Override // com.baidu.tbadk.g.a
            public void aNb() {
                LogoActivity.this.eIC = true;
                if (LogoActivity.this.eID) {
                    LogoActivity.this.bkC();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void s(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new an(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).ag("obj_type", z2 ? 2 : 1));
                an anVar = new an("common_click");
                anVar.dh("page_type", "a030").ag("obj_isad", 1).ag("obj_floor", 1).ag("obj_source", 1).ag("obj_adlocate", 16);
                if (z) {
                    anVar.ag("obj_type", z2 ? 4 : 3);
                } else {
                    anVar.ag("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dct().b(LogoActivity.this.getUniqueId(), anVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.eIJ));
        n.bfN().cD(System.currentTimeMillis() - this.eIy);
        int i = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.eIU, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkA() {
        if (this.eIA == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.ld().post(this.eIT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkB() {
        if (this.eIA >= 0) {
            oR(this.eIA);
        } else if (this.eIA == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkC() {
        bkB();
        n.bfN().cG(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bkD() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            m.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkE() {
        File[] listFiles;
        File file = new File(m.getCacheDir());
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

    private void oQ(int i) {
        this.eIA = i;
        bkv();
    }

    private void oR(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private boolean bkF() {
        return !com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_secret_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkG() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.eIW, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cp_link_tip_a)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.eIE = new com.baidu.tbadk.core.dialog.a(this);
        this.eIE.aP(inflate);
        this.eIE.kG(3);
        this.eIE.gX(false);
        this.eIE.setAutoNight(false);
        this.eIE.gW(false);
        am.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        am.a((View) textView3, (int) R.color.cp_cont_b, (int) R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.dUl);
        textView3.setOnClickListener(this.dUl);
        this.eIE.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkH() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        am.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.dUl);
        this.eIF = new com.baidu.tbadk.core.dialog.a(this);
        this.eIF.aP(inflate);
        this.eIF.kG(3);
        this.eIF.gX(false);
        this.eIF.setAutoNight(false);
        this.eIF.gW(false);
        this.eIF.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        oQ(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        oQ(intExtra);
                        return;
                    } else {
                        oQ(1);
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
            com.baidu.adp.lib.c.a.kq().getAddress(false);
            bkp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkI() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_location_request_dialog_has_shown", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bkC();
        }
    }
}
