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
    private boolean dTW;
    private BesAdViewContainer dUb;
    private com.baidu.tieba.w.d dUc;
    private View dUd;
    private com.baidu.tbadk.g.c dUe;
    private com.baidu.tbadk.core.dialog.a dUf;
    private com.baidu.tbadk.core.dialog.a dUg;
    private com.baidu.tbadk.r.a dUh;
    private RelativeLayout mRootView;
    private Bitmap dTQ = null;
    private boolean dTR = false;
    private boolean dTS = true;
    private long dTT = -1;
    private long dTU = -1;
    private int dTV = -1;
    private boolean dTX = false;
    private boolean dTY = false;
    private boolean dTZ = true;
    private a dUa = new a();
    private com.baidu.tbadk.r.b dUi = new com.baidu.tbadk.r.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.r.b
        public void aRP() {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(LogoActivity.this.dUp);
            LogoActivity.this.aWd();
        }

        @Override // com.baidu.tbadk.r.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.gx().removeCallbacks(LogoActivity.this.dUp);
            if (LogoActivity.this.dUh.getView() == null) {
                LogoActivity.this.aWg();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.dUh.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.dUh.getView());
            if (LogoActivity.this.dTV == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            n.aRv().bW(System.currentTimeMillis());
            TiebaStatic.log(new an("c13331").cx("obj_id", str).X("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_exp");
            anVar.cx("page_type", "a030").X("obj_isad", 1).cx("obj_id", str).X("obj_floor", 1).X("obj_source", 2).X("obj_adlocate", 16);
            if (z) {
                anVar.X("obj_type", z2 ? 4 : 3);
            } else {
                anVar.X("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.cKv().a(LogoActivity.this.getUniqueId(), str, anVar);
            com.baidu.tieba.s.c.cKv().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.r.b
        public void aze() {
            LogoActivity.this.dTY = true;
            if (LogoActivity.this.dTZ) {
                LogoActivity.this.aWg();
            }
        }

        @Override // com.baidu.tbadk.r.b
        public void V(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.dUh.getView() != null) {
                z2 = LogoActivity.this.dUh.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new an("c13332").cx("obj_id", str).X("obj_type", z2 ? 2 : 1));
            an anVar = new an("common_click");
            anVar.cx("page_type", "a030").X("obj_isad", 1).cx("obj_id", str).X("obj_floor", 1).X("obj_source", 2).X("obj_adlocate", 16);
            if (z) {
                anVar.X("obj_type", z2 ? 4 : 3);
            } else {
                anVar.X("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.cKv().b(LogoActivity.this.getUniqueId(), anVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.aWg();
        }
    };
    private long dUj = -1;
    private d.a dUk = new d.a() { // from class: com.baidu.tieba.LogoActivity.6
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.aWe();
        }

        @Override // com.baidu.tieba.w.d.a
        public void aWn() {
            if (LogoActivity.this.dTV != -2) {
                LogoActivity.this.aWf();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener dUl = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.aVX()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.gx().removeCallbacks(LogoActivity.this.dUa);
                    LogoActivity.this.dTY = true;
                    if (LogoActivity.this.dTZ) {
                        LogoActivity.this.aWg();
                    }
                }
            }
        }
    };
    private Runnable dUm = new Runnable() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aVV();
        }
    };
    private Runnable dUn = new Runnable() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aWg();
        }
    };
    private Runnable dUo = new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.dTX) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.dUb);
                com.baidu.adp.lib.f.e.gx().post(LogoActivity.this.dUn);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable dUp = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.aWe();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    private ClickableSpan dUq = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.4
        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.LogoActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            if (view != null) {
                ((TextView) view).setHighlightColor(LogoActivity.this.getResources().getColor(17170445));
            }
            ba.aGK().a(LogoActivity.this.getPageContext(), new String[]{"http://tieba.baidu.com/tb/cms/client/wise_secretright.html"}, true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(LogoActivity.this.getResources().getColor(R.color.cp_link_tip_c));
        }
    };
    View.OnClickListener dgy = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes) {
                if (LogoActivity.this.dUf.isShowing()) {
                    LogoActivity.this.dUf.dismiss();
                }
                com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("key_secret_is_show", true);
                if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
                    LogoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
                } else {
                    LogoActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(LogoActivity.this.getPageContext().getPageActivity()).createNormalCfg(2)));
                }
                LogoActivity.this.sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
                LogoActivity.this.finish();
                an anVar = new an("c13295");
                anVar.cx("obj_locate", "1");
                TiebaStatic.log(anVar);
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.dUf.isShowing()) {
                    LogoActivity.this.dUf.dismiss();
                }
                an anVar2 = new an("c13295");
                anVar2.cx("obj_locate", "2");
                TiebaStatic.log(anVar2);
                if (LogoActivity.this.dUg == null) {
                    LogoActivity.this.aWl();
                }
                LogoActivity.this.dUg.aEG();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.dUg.isShowing()) {
                    LogoActivity.this.dUg.dismiss();
                }
                if (LogoActivity.this.dUf == null) {
                    LogoActivity.this.aWk();
                }
                LogoActivity.this.dUf.aEG();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void aVV() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.dTW = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(1)));
        }
        h.gy().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.aWi();
                LogoActivity.aWh();
            }
        });
        finish();
    }

    private void Z(Intent intent) {
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
        this.dUj = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.cKv().w(getUniqueId());
        init(bundle);
    }

    private void init(Bundle bundle) {
        if (aWj()) {
            aWk();
            this.dUf.aEG();
            TiebaStatic.log(new an("c13294"));
            return;
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        if (aVX()) {
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(1028);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
            try {
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                LogoActivityConfig.isFirst = true;
                registerListener(this.dUl);
                this.dTV = -2;
                aWc();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
            } catch (Throwable th) {
                BdLog.e(th);
                finish();
            }
        } else if (!isTaskRoot() && !aVW()) {
            finish();
        } else {
            TiebaStatic.log(new an(TbadkCoreStatisticKey.HOST_START).X("obj_param1", 2));
            TbadkCoreApplication.getInst().onLowMemory();
            if (!TbadkCoreApplication.isLogin()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
            }
            Z(getIntent());
            getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT > 16) {
                getWindow().getDecorView().setSystemUiVisibility(1028);
            }
            setContentView(R.layout.logo_activity);
            this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
            if (bundle != null) {
                LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
            } else {
                LogoActivityConfig.isFirst = true;
            }
            this.dTR = TbadkCoreApplication.getInst().getIsFirstUse();
            n.aRv().gW(this.dTR);
            registerListener(this.dUl);
            aVY();
            this.mHandler.sendMessage(this.mHandler.obtainMessage());
            HashMap hashMap = new HashMap();
            hashMap.put("type", "start");
            hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
            hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                aVZ();
            }
            if (!m.checkSD()) {
                TiebaStatic.file("no SD", "LogoActivity.onCreate");
            }
            if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
            }
        }
    }

    private boolean aVW() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new an("c11897").cx("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aVX() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void aVY() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.azV(), getPageContext().getPageActivity());
            }
        }
        el(getPageContext().getPageActivity());
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
        if (this.dUh != null && this.dUh.getView() != null && this.dUh.getView().getParent() != null) {
            if (this.dUh.getView() != null) {
                if (this.dUh.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dUh.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.dUh.getView().setLayoutParams(layoutParams);
        }
        if (this.dUe != null && this.dUe.cKK != null) {
            this.dUe.cKK.azf();
        }
    }

    private void aVZ() {
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
        this.dTZ = false;
        if (this.dUc != null) {
            this.dUc.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dTZ = true;
        if (this.dTS) {
            this.dTS = false;
            NASLib.onAppStart(getActivity());
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.aFH().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.aFH().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (this.dTY) {
            aWg();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.dTW) {
            aVV();
            this.dTW = false;
        }
        if (this.dUc != null) {
            this.dUc.onResume();
        }
        if (LogoActivityConfig.isFirst && this.dUj >= 0) {
            n.aRv().bT(System.currentTimeMillis() - this.dUj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.dUe != null) {
            this.dUe.s(null);
            this.dUe.a(null);
        }
        if (this.dUh != null) {
            this.dUh.release();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dUa);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dUm);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dUn);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dUo);
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.dUp);
        if (this.dUc != null) {
            this.dUc.onDestroy();
        }
        if (this.dTQ != null && !this.dTQ.isRecycled()) {
            this.dTQ.recycle();
            this.dTQ = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.cKv().x(getUniqueId());
        com.baidu.adp.lib.util.d.hG().clearCashBitmap();
    }

    private void el(Context context) {
        aWa();
        if (LogoActivityConfig.mFromSpacial) {
            nW(1);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.dTR) {
                com.baidu.adp.lib.f.e.gx().post(this.dUm);
            } else {
                nW(1);
            }
        } else if (this.dTR) {
            com.baidu.adp.lib.f.e.gx().post(this.dUm);
        } else {
            aWb();
        }
    }

    private void aWa() {
        if (this.dTR) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void aWb() {
        if (this.dTV != -2) {
            if (this.dUc == null) {
                this.dUc = new com.baidu.tieba.w.d(this);
            }
            if (this.dUc.cTI()) {
                this.dUd = this.dUc.r(0.8125d);
                this.mRootView.addView(this.dUd);
                this.dUc.a(this.dUk);
                this.dUc.start();
                return;
            }
            this.dUc.cTL();
        }
        aWc();
    }

    private void aWc() {
        this.dTT = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.r.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.dUh = (com.baidu.tbadk.r.a) runTask.getData();
            this.dUh.a(this.dUi);
            this.dUh.aRO();
            n.aRv().bU(System.currentTimeMillis() - this.dTT);
            int i = com.baidu.tbadk.core.sharedPref.b.aFH().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.gx().postDelayed(this.dUp, i * 1000);
            return;
        }
        aWd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWd() {
        int findType = SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH);
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        if (findType == 0 || findTask == null) {
            aWe();
        }
        this.dTT = System.currentTimeMillis();
        this.dTU = System.currentTimeMillis();
        this.dUe = new com.baidu.tbadk.g.c();
        this.dUb = new BesAdViewContainer(getPageContext().getPageActivity());
        this.dUb.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.13
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.aWg();
            }
        });
        this.dUb.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.dUb);
        this.dUe.s(this.dUb);
        this.dUe.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tbadk.g.a
            public void rI(String str) {
                LogoActivity.this.dTX = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.dUb);
                LogoActivity.this.aWe();
                n.aRv().bV(System.currentTimeMillis() - LogoActivity.this.dTU);
            }

            @Override // com.baidu.tbadk.g.a
            public void p(boolean z, boolean z2) {
                LogoActivity.this.dTX = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new an(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).X("obj_type", z2 ? 2 : 1));
                an anVar = new an("common_exp");
                anVar.cx("page_type", "a030").X("obj_isad", 1).X("obj_floor", 1).X("obj_source", 1).X("obj_adlocate", 16);
                if (z) {
                    anVar.X("obj_type", z2 ? 4 : 3);
                } else {
                    anVar.X("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.cKv().a(LogoActivity.this.getUniqueId(), "bes_ad_id", anVar);
                com.baidu.tieba.s.c.cKv().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.dTV == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.gx().removeCallbacks(LogoActivity.this.dUo);
                n.aRv().bW(System.currentTimeMillis());
                n.aRv().bV(System.currentTimeMillis() - LogoActivity.this.dTU);
            }

            @Override // com.baidu.tbadk.g.a
            public void aze() {
                LogoActivity.this.dTY = true;
                if (LogoActivity.this.dTZ) {
                    LogoActivity.this.aWg();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void q(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new an(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).X("obj_type", z2 ? 2 : 1));
                an anVar = new an("common_click");
                anVar.cx("page_type", "a030").X("obj_isad", 1).X("obj_floor", 1).X("obj_source", 1).X("obj_adlocate", 16);
                if (z) {
                    anVar.X("obj_type", z2 ? 4 : 3);
                } else {
                    anVar.X("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.cKv().b(LogoActivity.this.getUniqueId(), anVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.dUe));
        n.aRv().bU(System.currentTimeMillis() - this.dTT);
        int i = com.baidu.tbadk.core.sharedPref.b.aFH().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.gx().postDelayed(this.dUo, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWe() {
        if (this.dTV == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.gx().post(this.dUn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWf() {
        if (this.dTV >= 0) {
            nX(this.dTV);
        } else if (this.dTV == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWg() {
        aWf();
        n.aRv().bX(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aWh() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            m.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWi() {
        File[] listFiles;
        File file = new File(m.getCacheDir());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.LogoActivity.3
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

    private void nW(int i) {
        this.dTV = i;
        aWb();
    }

    private void nX(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    private boolean aWj() {
        return !com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("key_secret_is_show", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWk() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.dUq, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cp_link_tip_a)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.dUf = new com.baidu.tbadk.core.dialog.a(this);
        this.dUf.aO(inflate);
        this.dUf.jZ(3);
        this.dUf.fI(false);
        this.dUf.setAutoNight(false);
        this.dUf.fH(false);
        am.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        am.a((View) textView3, (int) R.color.cp_cont_b, (int) R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.dgy);
        textView3.setOnClickListener(this.dgy);
        this.dUf.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWl() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        am.a((View) textView2, (int) R.color.cp_link_tip_a, (int) R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.dgy);
        this.dUg = new com.baidu.tbadk.core.dialog.a(this);
        this.dUg.aO(inflate);
        this.dUg.jZ(3);
        this.dUg.fI(false);
        this.dUg.setAutoNight(false);
        this.dUg.fH(false);
        this.dUg.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        nW(1);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        nW(intExtra);
                        return;
                    } else {
                        nW(1);
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
            LogoActivity.this.aWg();
        }
    }
}
