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
    private boolean eua;
    private com.baidu.tbadk.core.dialog.a eud;
    private com.baidu.tbadk.core.dialog.a eue;
    private com.baidu.tieba.w.d eug;
    private View euh;
    private com.baidu.tbadk.g.e eui;
    private BesAdViewContainer euj;
    private com.baidu.tbadk.g.d eul;
    private com.baidu.tbadk.r.a eum;
    private RelativeLayout mRootView;
    private Bitmap etU = null;
    private boolean etV = false;
    private boolean etW = true;
    private long etX = -1;
    private long etY = -1;
    private int etZ = -1;
    private boolean eub = false;
    private boolean euc = true;
    private a euf = new a();
    private boolean euk = false;
    private com.baidu.tbadk.r.b eun = new com.baidu.tbadk.r.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.r.b
        public void LH() {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(LogoActivity.this.euu);
            LogoActivity.this.bel();
        }

        @Override // com.baidu.tbadk.r.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.lb().removeCallbacks(LogoActivity.this.euu);
            if (LogoActivity.this.eum.getView() == null) {
                LogoActivity.this.beq();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.eum.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.eum.getView());
            if (LogoActivity.this.etZ == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.aZD().cD(System.currentTimeMillis());
            TiebaStatic.log(new an("c13331").cI("obj_id", str).af("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_exp");
            anVar.cI("page_type", "a030").af("obj_isad", 1).cI("obj_id", str).af("obj_floor", 1).af("obj_source", 2).af("obj_adlocate", 16);
            if (z) {
                anVar.af("obj_type", z2 ? 4 : 3);
            } else {
                anVar.af("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.cVp().a(LogoActivity.this.getUniqueId(), str, anVar);
            com.baidu.tieba.s.c.cVp().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.r.b
        public void aHn() {
            LogoActivity.this.eub = true;
            if (LogoActivity.this.euc) {
                LogoActivity.this.beq();
            }
        }

        @Override // com.baidu.tbadk.r.b
        public void aa(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.eum.getView() != null) {
                z2 = LogoActivity.this.eum.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
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
            com.baidu.tieba.s.c.cVp().b(LogoActivity.this.getUniqueId(), anVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.beq();
        }
    };
    private long euo = -1;
    private d.a eup = new d.a() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.beo();
        }

        @Override // com.baidu.tieba.w.d.a
        public void LJ() {
            if (LogoActivity.this.etZ != -2) {
                LogoActivity.this.bep();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener euq = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bef()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(LogoActivity.this.euf);
                    LogoActivity.this.eub = true;
                    if (LogoActivity.this.euc) {
                        LogoActivity.this.beq();
                    }
                }
            }
        }
    };
    private Runnable eur = new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bed();
        }
    };
    private Runnable eus = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.beq();
        }
    };
    private Runnable eut = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.euk && LogoActivity.this.euj != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.euj);
                com.baidu.adp.lib.f.e.lb().post(LogoActivity.this.eus);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable euu = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.beo();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    private ClickableSpan euv = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.6
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.LogoActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(LogoActivity.this.getResources().getColor(17170445));
            }
            ba.aOV().a(LogoActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(LogoActivity.this.getResources().getColor(R.color.cp_link_tip_c));
        }
    };
    View.OnClickListener dFZ = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes) {
                if (LogoActivity.this.eud.isShowing()) {
                    LogoActivity.this.eud.dismiss();
                }
                com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("key_secret_is_show", true);
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
                if (LogoActivity.this.eud.isShowing()) {
                    LogoActivity.this.eud.dismiss();
                }
                an anVar2 = new an("c13295");
                anVar2.cI("obj_locate", "2");
                TiebaStatic.log(anVar2);
                if (LogoActivity.this.eue == null) {
                    LogoActivity.this.bev();
                }
                LogoActivity.this.eue.aMS();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.eue.isShowing()) {
                    LogoActivity.this.eue.dismiss();
                }
                if (LogoActivity.this.eud == null) {
                    LogoActivity.this.beu();
                }
                LogoActivity.this.eud.aMS();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bed() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.eua = true;
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
                LogoActivity.this.bes();
                LogoActivity.ber();
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
        this.euo = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cVp().w(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (bet()) {
            beu();
            this.eud.aMS();
            TiebaStatic.log(new an("c13294"));
            return;
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        if (bef()) {
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
            try {
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.euq);
                this.etZ = -2;
                bek();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !bee()) {
            finish();
        } else {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.HOST_START).af("obj_param1", 2));
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
            this.etV = TbadkCoreApplication.getInst().getIsFirstUse();
            n.aZD().hU(this.etV);
            registerListener(this.euq);
            beg();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                beh();
            }
            if (!m.checkSD()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean bee() {
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
    public boolean bef() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void beg() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.aIg(), getPageContext().getPageActivity());
            }
        }
        dN(getPageContext().getPageActivity());
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
        if (this.eum != null && this.eum.getView() != null && this.eum.getView().getParent() != null) {
            if (this.eum.getView() != null) {
                if (this.eum.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eum.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.eum.getView().setLayoutParams(layoutParams);
        }
        if (this.eui != null && this.eui.djV != null) {
            this.eui.djV.aHo();
        }
    }

    private void beh() {
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
        this.euc = false;
        if (this.eug != null) {
            this.eug.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.euc = true;
        if (this.etW) {
            this.etW = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aNT().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.aNT().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (this.eub) {
            beq();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.eua) {
            bed();
            this.eua = false;
        }
        if (this.eug != null) {
            this.eug.onResume();
        }
        if (LogoActivityConfig.isFirst && this.euo >= 0) {
            n.aZD().cA(System.currentTimeMillis() - this.euo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eui != null) {
            this.eui.t(null);
            this.eui.a(null);
        }
        if (this.eul != null) {
            this.eul.t(null);
            this.eul.a(null);
        }
        if (this.eum != null) {
            this.eum.release();
        }
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.euf);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.eur);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.eus);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.eut);
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.euu);
        if (this.eug != null) {
            this.eug.onDestroy();
        }
        if (this.etU != null && !this.etU.isRecycled()) {
            this.etU.recycle();
            this.etU = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.cVp().x(getUniqueId());
        com.baidu.adp.lib.util.d.mk().clearCashBitmap();
    }

    private void dN(Context context) {
        bei();
        if (LogoActivityConfig.mFromSpacial) {
            oj(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.etV) {
                com.baidu.adp.lib.f.e.lb().post(this.eur);
            } else {
                oj(1);
            }
        } else if (this.etV) {
            com.baidu.adp.lib.f.e.lb().post(this.eur);
        } else {
            bej();
        }
    }

    private void bei() {
        if (this.etV) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bej() {
        if (this.etZ != -2) {
            if (this.eug == null) {
                this.eug = new com.baidu.tieba.w.d(this);
            }
            if (this.eug.det()) {
                this.euh = this.eug.x(0.8125d);
                this.mRootView.addView(this.euh);
                this.eug.a(this.eup);
                this.eug.start();
                return;
            }
            this.eug.dex();
        }
        bek();
    }

    private void bek() {
        this.etX = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.r.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.eum = (com.baidu.tbadk.r.a) runTask.getData();
            this.eum.a(this.eun);
            this.eum.aZW();
            n.aZD().cB(System.currentTimeMillis() - this.etX);
            int i = com.baidu.tbadk.core.sharedPref.b.aNT().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.lb().postDelayed(this.euu, i * 1000);
            return;
        }
        bel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bel() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            beo();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        MessageTask findTask2 = MessageManager.getInstance().findTask(2156676);
        if (findTask2 == null && findTask == null) {
            beo();
            return;
        }
        boolean sY = com.baidu.tbadk.a.b.sY("ad_xuzhang_splash_sdk");
        if (findTask2 != null && sY) {
            bem();
        } else if (findTask != null) {
            ben();
        } else {
            beo();
        }
    }

    private void bem() {
        this.etX = System.currentTimeMillis();
        this.etY = System.currentTimeMillis();
        this.eul = new com.baidu.tbadk.g.d();
        this.euj = new BesAdViewContainer(getPageContext().getPageActivity());
        this.euj.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.15
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.beq();
            }
        });
        this.euj.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.euj);
        this.eul.t(this.euj);
        this.eul.a(new com.baidu.tbadk.g.c() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.c
            public void sZ(String str) {
                LogoActivity.this.euk = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.euj);
                LogoActivity.this.beo();
                n.aZD().cC(System.currentTimeMillis() - LogoActivity.this.etY);
            }

            @Override // com.baidu.tbadk.g.c
            public void aHp() {
                LogoActivity.this.euk = true;
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
                if (LogoActivity.this.etZ == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.lb().removeCallbacks(LogoActivity.this.eut);
                n.aZD().cD(System.currentTimeMillis());
                n.aZD().cC(System.currentTimeMillis() - LogoActivity.this.etY);
            }

            @Override // com.baidu.tbadk.g.c
            public void aHn() {
                LogoActivity.this.eub = true;
                if (LogoActivity.this.euc) {
                    LogoActivity.this.beq();
                }
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdClick() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2156676, this.eul));
        n.aZD().cB(System.currentTimeMillis() - this.etX);
        int i = com.baidu.tbadk.core.sharedPref.b.aNT().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.eut, (i > 0 ? i : 1) * 1000);
    }

    private void ben() {
        this.etX = System.currentTimeMillis();
        this.etY = System.currentTimeMillis();
        this.eui = new com.baidu.tbadk.g.e();
        this.euj = new BesAdViewContainer(getPageContext().getPageActivity());
        this.euj.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.beq();
            }
        });
        this.euj.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.euj);
        this.eui.t(this.euj);
        this.eui.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tbadk.g.a
            public void sZ(String str) {
                LogoActivity.this.euk = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.euj);
                LogoActivity.this.beo();
                n.aZD().cC(System.currentTimeMillis() - LogoActivity.this.etY);
            }

            @Override // com.baidu.tbadk.g.a
            public void o(boolean z, boolean z2) {
                LogoActivity.this.euk = true;
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
                com.baidu.tieba.s.c.cVp().a(LogoActivity.this.getUniqueId(), "bes_ad_id", anVar);
                com.baidu.tieba.s.c.cVp().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.etZ == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.lb().removeCallbacks(LogoActivity.this.eut);
                n.aZD().cD(System.currentTimeMillis());
                n.aZD().cC(System.currentTimeMillis() - LogoActivity.this.etY);
            }

            @Override // com.baidu.tbadk.g.a
            public void aHn() {
                LogoActivity.this.eub = true;
                if (LogoActivity.this.euc) {
                    LogoActivity.this.beq();
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
                com.baidu.tieba.s.c.cVp().b(LogoActivity.this.getUniqueId(), anVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.eui));
        n.aZD().cB(System.currentTimeMillis() - this.etX);
        int i = com.baidu.tbadk.core.sharedPref.b.aNT().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.lb().postDelayed(this.eut, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beo() {
        if (this.etZ == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.lb().post(this.eus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bep() {
        if (this.etZ >= 0) {
            ok(this.etZ);
        } else if (this.etZ == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beq() {
        bep();
        n.aZD().cE(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ber() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            m.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bes() {
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
        this.etZ = i;
        bej();
    }

    private void ok(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private boolean bet() {
        return !com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("key_secret_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beu() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.euv, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cp_link_tip_a)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.eud = new com.baidu.tbadk.core.dialog.a(this);
        this.eud.aP(inflate);
        this.eud.kg(3);
        this.eud.gF(false);
        this.eud.setAutoNight(false);
        this.eud.gE(false);
        am.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        am.a((View) textView3, (int) R.color.cp_cont_b, (int) R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.dFZ);
        textView3.setOnClickListener(this.dFZ);
        this.eud.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bev() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        am.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.dFZ);
        this.eue = new com.baidu.tbadk.core.dialog.a(this);
        this.eue.aP(inflate);
        this.eue.kg(3);
        this.eue.gF(false);
        this.eue.setAutoNight(false);
        this.eue.gE(false);
        this.eue.b(getPageContext());
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
            LogoActivity.this.beq();
        }
    }
}
