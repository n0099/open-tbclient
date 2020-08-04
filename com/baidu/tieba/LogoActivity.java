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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
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
    private View eZA;
    private com.baidu.tbadk.g.e eZB;
    private BesAdViewContainer eZC;
    private com.baidu.tbadk.g.d eZE;
    private com.baidu.tbadk.s.a eZF;
    private boolean eZt;
    private com.baidu.tbadk.core.dialog.a eZw;
    private com.baidu.tbadk.core.dialog.a eZx;
    private com.baidu.tieba.w.d eZz;
    private RelativeLayout mRootView;
    private Bitmap eZn = null;
    private boolean eZo = false;
    private boolean eZp = true;
    private long eZq = -1;
    private long eZr = -1;
    private int eZs = -1;
    private boolean eZu = false;
    private boolean eZv = true;
    private a eZy = new a();
    private boolean eZD = false;
    private com.baidu.tbadk.s.b eZG = new com.baidu.tbadk.s.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.s.b
        public void Pp() {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(LogoActivity.this.eZN);
            LogoActivity.this.bqT();
        }

        @Override // com.baidu.tbadk.s.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.lt().removeCallbacks(LogoActivity.this.eZN);
            if (LogoActivity.this.eZF.getView() == null) {
                LogoActivity.this.bqY();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.eZF.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.eZF.getView());
            if (LogoActivity.this.eZs == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.blF().db(System.currentTimeMillis());
            TiebaStatic.log(new ap("c13331").dn("obj_id", str).ah("obj_type", z2 ? 2 : 1));
            ap apVar = new ap("common_exp");
            apVar.dn("page_type", "a030").ah("obj_isad", 1).dn("obj_id", str).ah("obj_floor", 1).ah("obj_source", 2).ah("obj_adlocate", 16);
            if (z) {
                apVar.ah("obj_type", z2 ? 4 : 3);
            } else {
                apVar.ah("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dkh().a(LogoActivity.this.getUniqueId(), str, apVar);
            com.baidu.tieba.s.c.dkh().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.s.b
        public void aSz() {
            LogoActivity.this.eZu = true;
            if (LogoActivity.this.eZv) {
                LogoActivity.this.bqY();
            }
        }

        @Override // com.baidu.tbadk.s.b
        public void ao(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.eZF.getView() != null) {
                z2 = LogoActivity.this.eZF.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new ap("c13332").dn("obj_id", str).ah("obj_type", z2 ? 2 : 1));
            ap apVar = new ap("common_click");
            apVar.dn("page_type", "a030").ah("obj_isad", 1).dn("obj_id", str).ah("obj_floor", 1).ah("obj_source", 2).ah("obj_adlocate", 16);
            if (z) {
                apVar.ah("obj_type", z2 ? 4 : 3);
            } else {
                apVar.ah("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dkh().b(LogoActivity.this.getUniqueId(), apVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bqY();
        }
    };
    private long eZH = -1;
    private d.a eZI = new d.a() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.bqW();
        }

        @Override // com.baidu.tieba.w.d.a
        public void Pr() {
            if (LogoActivity.this.eZs != -2) {
                LogoActivity.this.bqX();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener eZJ = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bqN()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(LogoActivity.this.eZy);
                    LogoActivity.this.eZu = true;
                    if (LogoActivity.this.eZv) {
                        LogoActivity.this.bqY();
                    }
                }
            }
        }
    };
    private Runnable eZK = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bqL();
        }
    };
    private Runnable eZL = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bqY();
        }
    };
    private Runnable eZM = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.eZD && LogoActivity.this.eZC != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eZC);
                com.baidu.adp.lib.f.e.lt().post(LogoActivity.this.eZL);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable eZN = new Runnable() { // from class: com.baidu.tieba.LogoActivity.14
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bqW();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    private ClickableSpan eZO = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.6
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.LogoActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(LogoActivity.this.getResources().getColor(17170445));
            }
            bd.baV().a(LogoActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(LogoActivity.this.getResources().getColor(R.color.cp_link_tip_c));
        }
    };
    View.OnClickListener ehM = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes) {
                if (LogoActivity.this.eZw.isShowing()) {
                    LogoActivity.this.eZw.dismiss();
                }
                com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("key_secret_is_show", true);
                com.baidu.tbadk.core.sharedPref.b.aZP().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bre() || ad.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bqL();
                    ap apVar = new ap("c13295");
                    apVar.dn("obj_locate", "1");
                    TiebaStatic.log(apVar);
                    return;
                }
                LogoActivity.this.brf();
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.eZw.isShowing()) {
                    LogoActivity.this.eZw.dismiss();
                }
                ap apVar2 = new ap("c13295");
                apVar2.dn("obj_locate", "2");
                TiebaStatic.log(apVar2);
                if (LogoActivity.this.eZx == null) {
                    LogoActivity.this.brd();
                }
                LogoActivity.this.eZx.aYL();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.eZx.isShowing()) {
                    LogoActivity.this.eZx.dismiss();
                }
                if (LogoActivity.this.eZw == null) {
                    LogoActivity.this.brc();
                }
                LogoActivity.this.eZw.aYL();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bqL() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.eZt = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        h.lu().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.15
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.bra();
                LogoActivity.bqZ();
            }
        });
        finish();
    }

    private void J(Intent intent) {
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
        this.eZH = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dkh().A(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (brb()) {
            brc();
            this.eZw.aYL();
            TiebaStatic.log(new ap("c13294"));
        } else if (!bre() && !ad.checkLocationForGoogle(getActivity())) {
            brf();
        } else {
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            if (ad.checkLocationForGoogle(getActivity())) {
                com.baidu.adp.lib.c.a.kG().getAddress(false);
            }
            if (bqN()) {
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                try {
                    setContentView(R.layout.logo_activity);
                    this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                    LogoActivityConfig.isFirst = true;
                    registerListener(this.eZJ);
                    this.eZs = -2;
                    bqS();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                } catch (Throwable th) {
                    BdLog.e(th);
                    finish();
                }
            } else if (!isTaskRoot() && !bqM()) {
                finish();
            } else {
                TiebaStatic.log(new ap(TbadkCoreStatisticKey.HOST_START).ah("obj_param1", 2));
                TbadkCoreApplication.getInst().onLowMemory();
                if (!TbadkCoreApplication.isLogin()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
                }
                J(getIntent());
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
                this.eZo = TbadkCoreApplication.getInst().getIsFirstUse();
                n.blF().je(this.eZo);
                registerListener(this.eZJ);
                bqO();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("type", "start");
                hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
                hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                    bqP();
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

    private boolean bqM() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new ap("c11897").dn("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bqN() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bqO() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.aTz(), getPageContext().getPageActivity());
            }
        }
        ek(getPageContext().getPageActivity());
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
        if (this.eZF != null && this.eZF.getView() != null && this.eZF.getView().getParent() != null) {
            if (this.eZF.getView() != null) {
                if (this.eZF.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eZF.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.eZF.getView().setLayoutParams(layoutParams);
        }
        if (this.eZB != null && this.eZB.dIY != null) {
            this.eZB.dIY.aSA();
        }
    }

    private void bqP() {
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
        this.eZv = false;
        if (this.eZz != null) {
            this.eZz.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eZv = true;
        if (this.eZp) {
            this.eZp = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aZP().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.aZP().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (this.eZu) {
            bqY();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.eZt) {
            bqL();
            this.eZt = false;
        }
        if (this.eZz != null) {
            this.eZz.onResume();
        }
        if (LogoActivityConfig.isFirst && this.eZH >= 0) {
            n.blF().cY(System.currentTimeMillis() - this.eZH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eZB != null) {
            this.eZB.A(null);
            this.eZB.a(null);
        }
        if (this.eZE != null) {
            this.eZE.A(null);
            this.eZE.a(null);
        }
        if (this.eZF != null) {
            this.eZF.release();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eZy);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eZK);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eZL);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eZM);
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.eZN);
        if (this.eZz != null) {
            this.eZz.onDestroy();
        }
        if (this.eZn != null && !this.eZn.isRecycled()) {
            this.eZn.recycle();
            this.eZn = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.dkh().B(getUniqueId());
        com.baidu.adp.lib.util.d.mC().clearCashBitmap();
    }

    private void ek(Context context) {
        bqQ();
        if (LogoActivityConfig.mFromSpacial) {
            pI(2);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.eZo) {
                com.baidu.adp.lib.f.e.lt().post(this.eZK);
            } else {
                pI(2);
            }
        } else if (this.eZo) {
            com.baidu.adp.lib.f.e.lt().post(this.eZK);
        } else {
            bqR();
        }
    }

    private void bqQ() {
        if (this.eZo) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bqR() {
        if (this.eZs != -2) {
            if (this.eZz == null) {
                this.eZz = new com.baidu.tieba.w.d(this);
            }
            if (this.eZz.dtw()) {
                this.eZA = this.eZz.z(0.8125d);
                this.mRootView.addView(this.eZA);
                this.eZz.a(this.eZI);
                this.eZz.start();
                return;
            }
            this.eZz.dtA();
        }
        bqS();
    }

    private void bqS() {
        this.eZq = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.s.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.eZF = (com.baidu.tbadk.s.a) runTask.getData();
            this.eZF.a(this.eZG);
            this.eZF.bmg();
            n.blF().cZ(System.currentTimeMillis() - this.eZq);
            int i = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.lt().postDelayed(this.eZN, i * 1000);
            return;
        }
        bqT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqT() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bqW();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        MessageTask findTask2 = MessageManager.getInstance().findTask(2156676);
        if (findTask2 == null && findTask == null) {
            bqW();
            return;
        }
        boolean vN = com.baidu.tbadk.a.b.vN("ad_xuzhang_splash_sdk");
        if (findTask2 != null && vN) {
            bqU();
        } else if (findTask != null) {
            bqV();
        } else {
            bqW();
        }
    }

    private void bqU() {
        this.eZq = System.currentTimeMillis();
        this.eZr = System.currentTimeMillis();
        this.eZE = new com.baidu.tbadk.g.d();
        this.eZC = new BesAdViewContainer(getPageContext().getPageActivity());
        this.eZC.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.16
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bqY();
            }
        });
        this.eZC.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.eZC);
        this.eZE.A(this.eZC);
        this.eZE.a(new com.baidu.tbadk.g.c() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.c
            public void vP(String str) {
                LogoActivity.this.eZD = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eZC);
                LogoActivity.this.bqW();
                n.blF().da(System.currentTimeMillis() - LogoActivity.this.eZr);
            }

            @Override // com.baidu.tbadk.g.c
            public void aSB() {
                LogoActivity.this.eZD = true;
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
                if (LogoActivity.this.eZs == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.lt().removeCallbacks(LogoActivity.this.eZM);
                n.blF().db(System.currentTimeMillis());
                n.blF().da(System.currentTimeMillis() - LogoActivity.this.eZr);
            }

            @Override // com.baidu.tbadk.g.c
            public void aSz() {
                LogoActivity.this.eZu = true;
                if (LogoActivity.this.eZv) {
                    LogoActivity.this.bqY();
                }
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdClick() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2156676, this.eZE));
        n.blF().cZ(System.currentTimeMillis() - this.eZq);
        int i = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.eZM, (i > 0 ? i : 1) * 1000);
    }

    private void bqV() {
        this.eZq = System.currentTimeMillis();
        this.eZr = System.currentTimeMillis();
        this.eZB = new com.baidu.tbadk.g.e();
        this.eZC = new BesAdViewContainer(getPageContext().getPageActivity());
        this.eZC.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bqY();
            }
        });
        this.eZC.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.eZC);
        this.eZB.A(this.eZC);
        this.eZB.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tbadk.g.a
            public void vP(String str) {
                LogoActivity.this.eZD = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eZC);
                LogoActivity.this.bqW();
                n.blF().da(System.currentTimeMillis() - LogoActivity.this.eZr);
            }

            @Override // com.baidu.tbadk.g.a
            public void s(boolean z, boolean z2) {
                LogoActivity.this.eZD = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new ap(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).ah("obj_type", z2 ? 2 : 1));
                ap apVar = new ap("common_exp");
                apVar.dn("page_type", "a030").ah("obj_isad", 1).ah("obj_floor", 1).ah("obj_source", 1).ah("obj_adlocate", 16);
                if (z) {
                    apVar.ah("obj_type", z2 ? 4 : 3);
                } else {
                    apVar.ah("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dkh().a(LogoActivity.this.getUniqueId(), "bes_ad_id", apVar);
                com.baidu.tieba.s.c.dkh().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.eZs == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.lt().removeCallbacks(LogoActivity.this.eZM);
                n.blF().db(System.currentTimeMillis());
                n.blF().da(System.currentTimeMillis() - LogoActivity.this.eZr);
            }

            @Override // com.baidu.tbadk.g.a
            public void aSz() {
                LogoActivity.this.eZu = true;
                if (LogoActivity.this.eZv) {
                    LogoActivity.this.bqY();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void t(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new ap(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).ah("obj_type", z2 ? 2 : 1));
                ap apVar = new ap("common_click");
                apVar.dn("page_type", "a030").ah("obj_isad", 1).ah("obj_floor", 1).ah("obj_source", 1).ah("obj_adlocate", 16);
                if (z) {
                    apVar.ah("obj_type", z2 ? 4 : 3);
                } else {
                    apVar.ah("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dkh().b(LogoActivity.this.getUniqueId(), apVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.eZB));
        n.blF().cZ(System.currentTimeMillis() - this.eZq);
        int i = com.baidu.tbadk.core.sharedPref.b.aZP().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.lt().postDelayed(this.eZM, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqW() {
        if (this.eZs == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.lt().post(this.eZL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqX() {
        if (this.eZs >= 0) {
            pJ(this.eZs);
        } else if (this.eZs == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqY() {
        bqX();
        n.blF().dc(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bqZ() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            com.baidu.tbadk.core.util.n.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bra() {
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

    private void pI(int i) {
        this.eZs = i;
        bqR();
    }

    private void pJ(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private boolean brb() {
        return !com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_secret_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brc() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.eZO, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cp_link_tip_a)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.eZw = new com.baidu.tbadk.core.dialog.a(this);
        this.eZw.aV(inflate);
        this.eZw.lq(3);
        this.eZw.hK(false);
        this.eZw.setAutoNight(false);
        this.eZw.hJ(false);
        ao.a((View) textView2, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
        ao.a((View) textView3, R.color.cp_cont_b, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.ehM);
        textView3.setOnClickListener(this.ehM);
        this.eZw.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brd() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        ao.a((View) textView2, R.color.cp_link_tip_a, R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.ehM);
        this.eZx = new com.baidu.tbadk.core.dialog.a(this);
        this.eZx.aV(inflate);
        this.eZx.lq(3);
        this.eZx.hK(false);
        this.eZx.setAutoNight(false);
        this.eZx.hJ(false);
        this.eZx.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        pI(2);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        pI(intExtra);
                        return;
                    } else {
                        pI(2);
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
            bqL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bre() {
        return as.equals(TbConfig.getVersion(), com.baidu.tbadk.core.sharedPref.b.aZP().getString("key_location_request_dialog_last_show_version", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brf() {
        com.baidu.tbadk.core.sharedPref.b.aZP().putString("key_location_request_dialog_last_show_version", TbConfig.getVersion());
        ad.a(getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
            public void onClose() {
                LogoActivity.this.bqL();
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
            LogoActivity.this.bqY();
        }
    }
}
