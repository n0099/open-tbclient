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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.m;
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
    private boolean etV;
    private com.baidu.tbadk.core.dialog.a etY;
    private com.baidu.tbadk.core.dialog.a etZ;
    private com.baidu.tieba.w.d eub;
    private View euc;
    private com.baidu.tbadk.g.e eud;
    private BesAdViewContainer eue;
    private com.baidu.tbadk.g.d eug;
    private com.baidu.tbadk.r.a euh;
    private RelativeLayout mRootView;
    private Bitmap etP = null;
    private boolean etQ = false;
    private boolean etR = true;
    private long etS = -1;
    private long etT = -1;
    private int etU = -1;
    private boolean etW = false;
    private boolean etX = true;
    private a eua = new a();
    private boolean euf = false;
    private com.baidu.tbadk.r.b eui = new com.baidu.tbadk.r.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.r.b
        public void LI() {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(LogoActivity.this.eup);
            LogoActivity.this.ben();
        }

        @Override // com.baidu.tbadk.r.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(LogoActivity.this.eup);
            if (LogoActivity.this.euh.getView() == null) {
                LogoActivity.this.bes();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.euh.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.euh.getView());
            if (LogoActivity.this.etU == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.aZF().cD(System.currentTimeMillis());
            TiebaStatic.log(new an("c13331").cI("obj_id", str).af("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_exp");
            anVar.cI("page_type", "a030").af("obj_isad", 1).cI("obj_id", str).af("obj_floor", 1).af("obj_source", 2).af("obj_adlocate", 16);
            if (z) {
                anVar.af("obj_type", z2 ? 4 : 3);
            } else {
                anVar.af("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.cVr().a(LogoActivity.this.getUniqueId(), str, anVar);
            com.baidu.tieba.s.c.cVr().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.r.b
        public void aHp() {
            LogoActivity.this.etW = true;
            if (LogoActivity.this.etX) {
                LogoActivity.this.bes();
            }
        }

        @Override // com.baidu.tbadk.r.b
        public void aa(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.euh.getView() != null) {
                z2 = LogoActivity.this.euh.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new an("c13332").cI("obj_id", str).af("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_click");
            anVar.cI("page_type", "a030").af("obj_isad", 1).cI("obj_id", str).af("obj_floor", 1).af("obj_source", 2).af("obj_adlocate", 16);
            if (z) {
                anVar.af("obj_type", z2 ? 4 : 3);
            } else {
                anVar.af("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.cVr().b(LogoActivity.this.getUniqueId(), anVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bes();
        }
    };
    private long euj = -1;
    private d.a euk = new d.a() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.beq();
        }

        @Override // com.baidu.tieba.w.d.a
        public void LK() {
            if (LogoActivity.this.etU != -2) {
                LogoActivity.this.ber();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener eul = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.beh()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(LogoActivity.this.eua);
                    LogoActivity.this.etW = true;
                    if (LogoActivity.this.etX) {
                        LogoActivity.this.bes();
                    }
                }
            }
        }
    };
    private Runnable eum = new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bef();
        }
    };
    private Runnable eun = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bes();
        }
    };
    private Runnable euo = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.euf && LogoActivity.this.eue != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eue);
                com.baidu.adp.lib.f.e.lb().post(LogoActivity.this.eun);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable eup = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.beq();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    private ClickableSpan euq = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.6
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.LogoActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(LogoActivity.this.getResources().getColor(17170445));
            }
            ba.aOY().a(LogoActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(LogoActivity.this.getResources().getColor(R.color.cp_link_tip_c));
        }
    };
    View.OnClickListener dFV = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes) {
                if (LogoActivity.this.etY.isShowing()) {
                    LogoActivity.this.etY.dismiss();
                }
                com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("key_secret_is_show", true);
                if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                    LogoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
                } else {
                    LogoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(2)));
                }
                LogoActivity.this.sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
                LogoActivity.this.finish();
                an anVar = new an("c13295");
                anVar.cI("obj_locate", "1");
                TiebaStatic.log(anVar);
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.etY.isShowing()) {
                    LogoActivity.this.etY.dismiss();
                }
                an anVar2 = new an("c13295");
                anVar2.cI("obj_locate", "2");
                TiebaStatic.log(anVar2);
                if (LogoActivity.this.etZ == null) {
                    LogoActivity.this.bex();
                }
                LogoActivity.this.etZ.aMU();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.etZ.isShowing()) {
                    LogoActivity.this.etZ.dismiss();
                }
                if (LogoActivity.this.etY == null) {
                    LogoActivity.this.bew();
                }
                LogoActivity.this.etY.aMU();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bef() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.etV = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        h.lc().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.14
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.beu();
                LogoActivity.bet();
            }
        });
        finish();
    }

    private void Y(Intent intent) {
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
        this.euj = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cVr().w(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (bev()) {
            bew();
            this.etY.aMU();
            TiebaStatic.log(new an("c13294"));
            return;
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        if (beh()) {
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
            try {
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.eul);
                this.etU = -2;
                bem();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !beg()) {
            finish();
        } else {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.HOST_START).af("obj_param1", 2));
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
            }
            Y(getIntent());
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
            this.etQ = TbadkCoreApplication.getInst().getIsFirstUse();
            n.aZF().hU(this.etQ);
            registerListener(this.eul);
            bei();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                bej();
            }
            if (!m.checkSD()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean beg() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new an("c11897").cI("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean beh() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bei() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.aIi(), getPageContext().getPageActivity());
            }
        }
        dZ(getPageContext().getPageActivity());
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
        if (this.euh != null && this.euh.getView() != null && this.euh.getView().getParent() != null) {
            if (this.euh.getView() != null) {
                if (this.euh.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.euh.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.euh.getView().setLayoutParams(layoutParams);
        }
        if (this.eud != null && this.eud.djR != null) {
            this.eud.djR.aHq();
        }
    }

    private void bej() {
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
        this.etX = false;
        if (this.eub != null) {
            this.eub.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.etX = true;
        if (this.etR) {
            this.etR = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aNV().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.aNV().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (this.etW) {
            bes();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.etV) {
            bef();
            this.etV = false;
        }
        if (this.eub != null) {
            this.eub.onResume();
        }
        if (LogoActivityConfig.isFirst && this.euj >= 0) {
            n.aZF().cA(System.currentTimeMillis() - this.euj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eud != null) {
            this.eud.t(null);
            this.eud.a(null);
        }
        if (this.eug != null) {
            this.eug.t(null);
            this.eug.a(null);
        }
        if (this.euh != null) {
            this.euh.release();
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.eua);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.eum);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.eun);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.euo);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.eup);
        if (this.eub != null) {
            this.eub.onDestroy();
        }
        if (this.etP != null && !this.etP.isRecycled()) {
            this.etP.recycle();
            this.etP = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.cVr().x(getUniqueId());
        com.baidu.adp.lib.util.d.mk().clearCashBitmap();
    }

    private void dZ(Context context) {
        bek();
        if (LogoActivityConfig.mFromSpacial) {
            oj(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.etQ) {
                com.baidu.adp.lib.f.e.lb().post(this.eum);
            } else {
                oj(1);
            }
        } else if (this.etQ) {
            com.baidu.adp.lib.f.e.lb().post(this.eum);
        } else {
            bel();
        }
    }

    private void bek() {
        if (this.etQ) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bel() {
        if (this.etU != -2) {
            if (this.eub == null) {
                this.eub = new com.baidu.tieba.w.d(this);
            }
            if (this.eub.dev()) {
                this.euc = this.eub.x(0.8125d);
                this.mRootView.addView(this.euc);
                this.eub.a(this.euk);
                this.eub.start();
                return;
            }
            this.eub.dez();
        }
        bem();
    }

    private void bem() {
        this.etS = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.r.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.euh = (com.baidu.tbadk.r.a) runTask.getData();
            this.euh.a(this.eui);
            this.euh.aZY();
            n.aZF().cB(System.currentTimeMillis() - this.etS);
            int i = com.baidu.tbadk.core.sharedPref.b.aNV().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.lb().postDelayed(this.eup, i * 1000);
            return;
        }
        ben();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ben() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            beq();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        MessageTask findTask2 = MessageManager.getInstance().findTask(2156676);
        if (findTask2 == null && findTask == null) {
            beq();
            return;
        }
        boolean sV = com.baidu.tbadk.a.b.sV("ad_xuzhang_splash_sdk");
        if (findTask2 != null && sV) {
            beo();
        } else if (findTask != null) {
            bep();
        } else {
            beq();
        }
    }

    private void beo() {
        this.etS = System.currentTimeMillis();
        this.etT = System.currentTimeMillis();
        this.eug = new com.baidu.tbadk.g.d();
        this.eue = new BesAdViewContainer(getPageContext().getPageActivity());
        this.eue.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.15
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bes();
            }
        });
        this.eue.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.eue);
        this.eug.t(this.eue);
        this.eug.a(new com.baidu.tbadk.g.c() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.c
            public void sW(String str) {
                LogoActivity.this.euf = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eue);
                LogoActivity.this.beq();
                n.aZF().cC(System.currentTimeMillis() - LogoActivity.this.etT);
            }

            @Override // com.baidu.tbadk.g.c
            public void aHr() {
                LogoActivity.this.euf = true;
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
                if (LogoActivity.this.etU == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.lb().removeCallbacks(LogoActivity.this.euo);
                n.aZF().cD(System.currentTimeMillis());
                n.aZF().cC(System.currentTimeMillis() - LogoActivity.this.etT);
            }

            @Override // com.baidu.tbadk.g.c
            public void aHp() {
                LogoActivity.this.etW = true;
                if (LogoActivity.this.etX) {
                    LogoActivity.this.bes();
                }
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdClick() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2156676, this.eug));
        n.aZF().cB(System.currentTimeMillis() - this.etS);
        int i = com.baidu.tbadk.core.sharedPref.b.aNV().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.euo, (i > 0 ? i : 1) * 1000);
    }

    private void bep() {
        this.etS = System.currentTimeMillis();
        this.etT = System.currentTimeMillis();
        this.eud = new com.baidu.tbadk.g.e();
        this.eue = new BesAdViewContainer(getPageContext().getPageActivity());
        this.eue.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bes();
            }
        });
        this.eue.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.eue);
        this.eud.t(this.eue);
        this.eud.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tbadk.g.a
            public void sW(String str) {
                LogoActivity.this.euf = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.eue);
                LogoActivity.this.beq();
                n.aZF().cC(System.currentTimeMillis() - LogoActivity.this.etT);
            }

            @Override // com.baidu.tbadk.g.a
            public void o(boolean z, boolean z2) {
                LogoActivity.this.euf = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new an(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).af("obj_type", z2 ? 2 : 1));
                an anVar = new an("common_exp");
                anVar.cI("page_type", "a030").af("obj_isad", 1).af("obj_floor", 1).af("obj_source", 1).af("obj_adlocate", 16);
                if (z) {
                    anVar.af("obj_type", z2 ? 4 : 3);
                } else {
                    anVar.af("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.cVr().a(LogoActivity.this.getUniqueId(), "bes_ad_id", anVar);
                com.baidu.tieba.s.c.cVr().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.etU == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.lb().removeCallbacks(LogoActivity.this.euo);
                n.aZF().cD(System.currentTimeMillis());
                n.aZF().cC(System.currentTimeMillis() - LogoActivity.this.etT);
            }

            @Override // com.baidu.tbadk.g.a
            public void aHp() {
                LogoActivity.this.etW = true;
                if (LogoActivity.this.etX) {
                    LogoActivity.this.bes();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void p(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new an(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).af("obj_type", z2 ? 2 : 1));
                an anVar = new an("common_click");
                anVar.cI("page_type", "a030").af("obj_isad", 1).af("obj_floor", 1).af("obj_source", 1).af("obj_adlocate", 16);
                if (z) {
                    anVar.af("obj_type", z2 ? 4 : 3);
                } else {
                    anVar.af("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.cVr().b(LogoActivity.this.getUniqueId(), anVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.eud));
        n.aZF().cB(System.currentTimeMillis() - this.etS);
        int i = com.baidu.tbadk.core.sharedPref.b.aNV().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.euo, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beq() {
        if (this.etU == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.lb().post(this.eun);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ber() {
        if (this.etU >= 0) {
            ok(this.etU);
        } else if (this.etU == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bes() {
        ber();
        n.aZF().cE(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bet() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            m.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beu() {
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

    private void oj(int i) {
        this.etU = i;
        bel();
    }

    private void ok(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private boolean bev() {
        return !com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("key_secret_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bew() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.euq, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cp_link_tip_a)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.etY = new com.baidu.tbadk.core.dialog.a(this);
        this.etY.aP(inflate);
        this.etY.kg(3);
        this.etY.gF(false);
        this.etY.setAutoNight(false);
        this.etY.gE(false);
        am.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        am.a((View) textView3, (int) R.color.cp_cont_b, (int) R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.dFV);
        textView3.setOnClickListener(this.dFV);
        this.etY.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bex() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        am.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.dFV);
        this.etZ = new com.baidu.tbadk.core.dialog.a(this);
        this.etZ.aP(inflate);
        this.etZ.kg(3);
        this.etZ.gF(false);
        this.etZ.setAutoNight(false);
        this.etZ.gE(false);
        this.etZ.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        oj(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        oj(intExtra);
                        return;
                    } else {
                        oj(1);
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
            LogoActivity.this.bes();
        }
    }
}
