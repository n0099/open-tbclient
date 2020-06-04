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
    private boolean eIM;
    private com.baidu.tbadk.core.dialog.a eIP;
    private com.baidu.tbadk.core.dialog.a eIQ;
    private com.baidu.tieba.w.d eIS;
    private View eIT;
    private com.baidu.tbadk.g.e eIU;
    private BesAdViewContainer eIV;
    private com.baidu.tbadk.g.d eIX;
    private com.baidu.tbadk.r.a eIY;
    private RelativeLayout mRootView;
    private Bitmap eIG = null;
    private boolean eIH = false;
    private boolean eII = true;
    private long eIJ = -1;
    private long eIK = -1;
    private int eIL = -1;
    private boolean eIN = false;
    private boolean eIO = true;
    private a eIR = new a();
    private boolean eIW = false;
    private com.baidu.tbadk.r.b eIZ = new com.baidu.tbadk.r.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.r.b
        public void NU() {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(LogoActivity.this.eJg);
            LogoActivity.this.bkz();
        }

        @Override // com.baidu.tbadk.r.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.ld().removeCallbacks(LogoActivity.this.eJg);
            if (LogoActivity.this.eIY.getView() == null) {
                LogoActivity.this.bkE();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.eIY.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.eIY.getView());
            if (LogoActivity.this.eIL == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.bfO().cF(System.currentTimeMillis());
            TiebaStatic.log(new an("c13331").dh("obj_id", str).ag("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_exp");
            anVar.dh("page_type", "a030").ag("obj_isad", 1).dh("obj_id", str).ag("obj_floor", 1).ag("obj_source", 2).ag("obj_adlocate", 16);
            if (z) {
                anVar.ag("obj_type", z2 ? 4 : 3);
            } else {
                anVar.ag("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dcI().a(LogoActivity.this.getUniqueId(), str, anVar);
            com.baidu.tieba.s.c.dcI().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.r.b
        public void aNb() {
            LogoActivity.this.eIN = true;
            if (LogoActivity.this.eIO) {
                LogoActivity.this.bkE();
            }
        }

        @Override // com.baidu.tbadk.r.b
        public void an(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.eIY.getView() != null) {
                z2 = LogoActivity.this.eIY.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
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
            com.baidu.tieba.s.c.dcI().b(LogoActivity.this.getUniqueId(), anVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bkE();
        }
    };
    private long eJa = -1;
    private d.a eJb = new d.a() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.bkC();
        }

        @Override // com.baidu.tieba.w.d.a
        public void NW() {
            if (LogoActivity.this.eIL != -2) {
                LogoActivity.this.bkD();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener eJc = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bkt()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.ld().removeCallbacks(LogoActivity.this.eIR);
                    LogoActivity.this.eIN = true;
                    if (LogoActivity.this.eIO) {
                        LogoActivity.this.bkE();
                    }
                }
            }
        }
    };
    private Runnable eJd = new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bkr();
        }
    };
    private Runnable eJe = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bkE();
        }
    };
    private Runnable eJf = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.eIW && LogoActivity.this.eIV != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eIV);
                com.baidu.adp.lib.f.e.ld().post(LogoActivity.this.eJe);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable eJg = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bkC();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    private ClickableSpan eJh = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.6
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.LogoActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(LogoActivity.this.getResources().getColor(17170445));
            }
            ba.aVa().a(LogoActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
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
                if (LogoActivity.this.eIP.isShowing()) {
                    LogoActivity.this.eIP.dismiss();
                }
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("key_secret_is_show", true);
                com.baidu.tbadk.core.sharedPref.b.aTX().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bkK() || ab.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bkr();
                    an anVar = new an("c13295");
                    anVar.dh("obj_locate", "1");
                    TiebaStatic.log(anVar);
                    return;
                }
                com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("key_location_request_dialog_has_shown", true);
                ab.a(LogoActivity.this.getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.7.1
                    @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
                    public void onClose() {
                        LogoActivity.this.bkr();
                    }
                });
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.eIP.isShowing()) {
                    LogoActivity.this.eIP.dismiss();
                }
                an anVar2 = new an("c13295");
                anVar2.dh("obj_locate", "2");
                TiebaStatic.log(anVar2);
                if (LogoActivity.this.eIQ == null) {
                    LogoActivity.this.bkJ();
                }
                LogoActivity.this.eIQ.aST();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.eIQ.isShowing()) {
                    LogoActivity.this.eIQ.dismiss();
                }
                if (LogoActivity.this.eIP == null) {
                    LogoActivity.this.bkI();
                }
                LogoActivity.this.eIP.aST();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bkr() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.eIM = true;
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
                LogoActivity.this.bkG();
                LogoActivity.bkF();
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
        this.eJa = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dcI().z(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (bkH()) {
            bkI();
            this.eIP.aST();
            TiebaStatic.log(new an("c13294"));
            return;
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        if (ab.checkLocationForGoogle(getActivity())) {
            com.baidu.adp.lib.c.a.kq().getAddress(false);
        }
        if (bkt()) {
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
            try {
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.eJc);
                this.eIL = -2;
                bky();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !bks()) {
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
            this.eIH = TbadkCoreApplication.getInst().getIsFirstUse();
            n.bfO().iq(this.eIH);
            registerListener(this.eJc);
            bku();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                bkv();
            }
            if (!m.checkSD()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean bks() {
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
    public boolean bkt() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bku() {
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
        if (this.eIY != null && this.eIY.getView() != null && this.eIY.getView().getParent() != null) {
            if (this.eIY.getView() != null) {
                if (this.eIY.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eIY.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.eIY.getView().setLayoutParams(layoutParams);
        }
        if (this.eIU != null && this.eIU.dxV != null) {
            this.eIU.dxV.aNc();
        }
    }

    private void bkv() {
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
        this.eIO = false;
        if (this.eIS != null) {
            this.eIS.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eIO = true;
        if (this.eII) {
            this.eII = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aTX().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.aTX().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (this.eIN) {
            bkE();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.eIM) {
            bkr();
            this.eIM = false;
        }
        if (this.eIS != null) {
            this.eIS.onResume();
        }
        if (LogoActivityConfig.isFirst && this.eJa >= 0) {
            n.bfO().cC(System.currentTimeMillis() - this.eJa);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eIU != null) {
            this.eIU.x(null);
            this.eIU.a(null);
        }
        if (this.eIX != null) {
            this.eIX.x(null);
            this.eIX.a(null);
        }
        if (this.eIY != null) {
            this.eIY.release();
        }
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eIR);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eJd);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eJe);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eJf);
        com.baidu.adp.lib.f.e.ld().removeCallbacks(this.eJg);
        if (this.eIS != null) {
            this.eIS.onDestroy();
        }
        if (this.eIG != null && !this.eIG.isRecycled()) {
            this.eIG.recycle();
            this.eIG = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.dcI().A(getUniqueId());
        com.baidu.adp.lib.util.d.mm().clearCashBitmap();
    }

    private void ee(Context context) {
        bkw();
        if (LogoActivityConfig.mFromSpacial) {
            oS(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.eIH) {
                com.baidu.adp.lib.f.e.ld().post(this.eJd);
            } else {
                oS(1);
            }
        } else if (this.eIH) {
            com.baidu.adp.lib.f.e.ld().post(this.eJd);
        } else {
            bkx();
        }
    }

    private void bkw() {
        if (this.eIH) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bkx() {
        if (this.eIL != -2) {
            if (this.eIS == null) {
                this.eIS = new com.baidu.tieba.w.d(this);
            }
            if (this.eIS.dlX()) {
                this.eIT = this.eIS.y(0.8125d);
                this.mRootView.addView(this.eIT);
                this.eIS.a(this.eJb);
                this.eIS.start();
                return;
            }
            this.eIS.dmb();
        }
        bky();
    }

    private void bky() {
        this.eIJ = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.r.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.eIY = (com.baidu.tbadk.r.a) runTask.getData();
            this.eIY.a(this.eIZ);
            this.eIY.bgh();
            n.bfO().cD(System.currentTimeMillis() - this.eIJ);
            int i = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.ld().postDelayed(this.eJg, i * 1000);
            return;
        }
        bkz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkz() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bkC();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        MessageTask findTask2 = MessageManager.getInstance().findTask(2156676);
        if (findTask2 == null && findTask == null) {
            bkC();
            return;
        }
        boolean uD = com.baidu.tbadk.a.b.uD("ad_xuzhang_splash_sdk");
        if (findTask2 != null && uD) {
            bkA();
        } else if (findTask != null) {
            bkB();
        } else {
            bkC();
        }
    }

    private void bkA() {
        this.eIJ = System.currentTimeMillis();
        this.eIK = System.currentTimeMillis();
        this.eIX = new com.baidu.tbadk.g.d();
        this.eIV = new BesAdViewContainer(getPageContext().getPageActivity());
        this.eIV.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.15
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bkE();
            }
        });
        this.eIV.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.eIV);
        this.eIX.x(this.eIV);
        this.eIX.a(new com.baidu.tbadk.g.c() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.c
            public void uF(String str) {
                LogoActivity.this.eIW = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eIV);
                LogoActivity.this.bkC();
                n.bfO().cE(System.currentTimeMillis() - LogoActivity.this.eIK);
            }

            @Override // com.baidu.tbadk.g.c
            public void aNd() {
                LogoActivity.this.eIW = true;
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
                if (LogoActivity.this.eIL == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.ld().removeCallbacks(LogoActivity.this.eJf);
                n.bfO().cF(System.currentTimeMillis());
                n.bfO().cE(System.currentTimeMillis() - LogoActivity.this.eIK);
            }

            @Override // com.baidu.tbadk.g.c
            public void aNb() {
                LogoActivity.this.eIN = true;
                if (LogoActivity.this.eIO) {
                    LogoActivity.this.bkE();
                }
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdClick() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2156676, this.eIX));
        n.bfO().cD(System.currentTimeMillis() - this.eIJ);
        int i = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.eJf, (i > 0 ? i : 1) * 1000);
    }

    private void bkB() {
        this.eIJ = System.currentTimeMillis();
        this.eIK = System.currentTimeMillis();
        this.eIU = new com.baidu.tbadk.g.e();
        this.eIV = new BesAdViewContainer(getPageContext().getPageActivity());
        this.eIV.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bkE();
            }
        });
        this.eIV.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.eIV);
        this.eIU.x(this.eIV);
        this.eIU.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tbadk.g.a
            public void uF(String str) {
                LogoActivity.this.eIW = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eIV);
                LogoActivity.this.bkC();
                n.bfO().cE(System.currentTimeMillis() - LogoActivity.this.eIK);
            }

            @Override // com.baidu.tbadk.g.a
            public void r(boolean z, boolean z2) {
                LogoActivity.this.eIW = true;
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
                com.baidu.tieba.s.c.dcI().a(LogoActivity.this.getUniqueId(), "bes_ad_id", anVar);
                com.baidu.tieba.s.c.dcI().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.eIL == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.ld().removeCallbacks(LogoActivity.this.eJf);
                n.bfO().cF(System.currentTimeMillis());
                n.bfO().cE(System.currentTimeMillis() - LogoActivity.this.eIK);
            }

            @Override // com.baidu.tbadk.g.a
            public void aNb() {
                LogoActivity.this.eIN = true;
                if (LogoActivity.this.eIO) {
                    LogoActivity.this.bkE();
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
                com.baidu.tieba.s.c.dcI().b(LogoActivity.this.getUniqueId(), anVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.eIU));
        n.bfO().cD(System.currentTimeMillis() - this.eIJ);
        int i = com.baidu.tbadk.core.sharedPref.b.aTX().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.ld().postDelayed(this.eJf, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkC() {
        if (this.eIL == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.ld().post(this.eJe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkD() {
        if (this.eIL >= 0) {
            oT(this.eIL);
        } else if (this.eIL == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkE() {
        bkD();
        n.bfO().cG(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bkF() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            m.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkG() {
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

    private void oS(int i) {
        this.eIL = i;
        bkx();
    }

    private void oT(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private boolean bkH() {
        return !com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_secret_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkI() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.eJh, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cp_link_tip_a)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.eIP = new com.baidu.tbadk.core.dialog.a(this);
        this.eIP.aP(inflate);
        this.eIP.kI(3);
        this.eIP.gX(false);
        this.eIP.setAutoNight(false);
        this.eIP.gW(false);
        am.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        am.a((View) textView3, (int) R.color.cp_cont_b, (int) R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.dUl);
        textView3.setOnClickListener(this.dUl);
        this.eIP.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkJ() {
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
        this.eIQ = new com.baidu.tbadk.core.dialog.a(this);
        this.eIQ.aP(inflate);
        this.eIQ.kI(3);
        this.eIQ.gX(false);
        this.eIQ.setAutoNight(false);
        this.eIQ.gW(false);
        this.eIQ.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        oS(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        oS(intExtra);
                        return;
                    } else {
                        oS(1);
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
            bkr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bkK() {
        return com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_location_request_dialog_has_shown", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bkE();
        }
    }
}
