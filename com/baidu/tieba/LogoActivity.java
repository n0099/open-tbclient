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
import androidx.annotation.NonNull;
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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
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
    private View gaA;
    private com.baidu.tbadk.g.e gaB;
    private BesAdViewContainer gaC;
    private com.baidu.tbadk.g.d gaE;
    private com.baidu.tbadk.s.a gaF;
    private boolean gar;
    private com.baidu.tbadk.core.dialog.a gau;
    private com.baidu.tbadk.core.dialog.a gav;
    private com.baidu.tbadk.core.dialog.a gaw;
    private com.baidu.tieba.w.d gaz;
    private RelativeLayout mRootView;
    private Bitmap gak = null;
    private boolean gal = false;
    private boolean gam = true;
    private long gan = -1;
    private long gao = -1;
    private int gaq = -1;
    private boolean gas = false;
    private boolean gat = true;
    private int gax = 2;
    private a gay = new a();
    private boolean gaD = false;
    private com.baidu.tbadk.s.b gaG = new com.baidu.tbadk.s.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.s.b
        public void acM() {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(LogoActivity.this.gaN);
            LogoActivity.this.bJz();
        }

        @Override // com.baidu.tbadk.s.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.mB().removeCallbacks(LogoActivity.this.gaN);
            if (LogoActivity.this.gaF.getView() == null) {
                LogoActivity.this.bJE();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.gaF.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.gaF.getView());
            if (LogoActivity.this.gaq == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            com.baidu.tbadk.n.l.bDT().er(System.currentTimeMillis());
            TiebaStatic.log(new aq("c13331").dW("obj_id", str).an("obj_type", z2 ? 2 : 1));
            aq aqVar = new aq("common_exp");
            aqVar.dW("page_type", "a030").an("obj_isad", 1).dW("obj_id", str).an("obj_floor", 1).an("obj_source", 2).an("obj_adlocate", 16);
            if (z) {
                aqVar.an("obj_type", z2 ? 4 : 3);
            } else {
                aqVar.an("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dKg().a(LogoActivity.this.getUniqueId(), str, aqVar);
            com.baidu.tieba.s.c.dKg().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.s.b
        public void onAdDismiss() {
            LogoActivity.this.gas = true;
            if (LogoActivity.this.gat) {
                LogoActivity.this.bJE();
            }
        }

        @Override // com.baidu.tbadk.s.b
        public void az(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.gaF.getView() != null) {
                z2 = LogoActivity.this.gaF.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new aq("c13332").dW("obj_id", str).an("obj_type", z2 ? 2 : 1));
            aq aqVar = new aq("common_click");
            aqVar.dW("page_type", "a030").an("obj_isad", 1).dW("obj_id", str).an("obj_floor", 1).an("obj_source", 2).an("obj_adlocate", 16);
            if (z) {
                aqVar.an("obj_type", z2 ? 4 : 3);
            } else {
                aqVar.an("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dKg().b(LogoActivity.this.getUniqueId(), aqVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bJE();
        }
    };
    private long gaH = -1;
    private d.a gaI = new d.a() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.bJC();
        }

        @Override // com.baidu.tieba.w.d.a
        public void acO() {
            if (LogoActivity.this.gaq != -2) {
                LogoActivity.this.bJD();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener gaJ = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bJt()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(LogoActivity.this.gay);
                    LogoActivity.this.gas = true;
                    if (LogoActivity.this.gat) {
                        LogoActivity.this.bJE();
                    }
                }
            }
        }
    };
    private Runnable gaK = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bJr();
        }
    };
    private Runnable gaL = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bJE();
        }
    };
    private Runnable gaM = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.gaD && LogoActivity.this.gaC != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.gaC);
                com.baidu.adp.lib.f.e.mB().post(LogoActivity.this.gaL);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable gaN = new Runnable() { // from class: com.baidu.tieba.LogoActivity.14
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bJC();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    View.OnClickListener ffD = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes || id == R.id.final_private_yes) {
                if (LogoActivity.this.gau != null && LogoActivity.this.gau.isShowing()) {
                    LogoActivity.this.gau.dismiss();
                }
                if (LogoActivity.this.gaw != null && LogoActivity.this.gaw.isShowing()) {
                    LogoActivity.this.gaw.dismiss();
                }
                ad.jJ(true);
                com.baidu.tbadk.core.sharedPref.b.brx().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bJK() || ad.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bJr();
                    aq aqVar = new aq("c13295");
                    aqVar.dW("obj_locate", "1");
                    TiebaStatic.log(aqVar);
                    return;
                }
                LogoActivity.this.bJL();
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.gau.isShowing()) {
                    LogoActivity.this.gau.dismiss();
                }
                aq aqVar2 = new aq("c13295");
                aqVar2.dW("obj_locate", "2");
                TiebaStatic.log(aqVar2);
                if (LogoActivity.this.gav == null) {
                    LogoActivity.this.bJI();
                }
                LogoActivity.this.gav.bqe();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.gav.isShowing()) {
                    LogoActivity.this.gav.dismiss();
                }
                if (LogoActivity.this.gax > 0) {
                    if (LogoActivity.this.gau == null) {
                        LogoActivity.this.bJH();
                    }
                    LogoActivity.this.gau.bqe();
                    LogoActivity.y(LogoActivity.this);
                    return;
                }
                if (LogoActivity.this.gaw == null) {
                    LogoActivity.this.bJJ();
                }
                LogoActivity.this.gaw.bqe();
            } else if (id == R.id.final_private_no) {
                if (LogoActivity.this.gaw.isShowing()) {
                    LogoActivity.this.gaw.dismiss();
                }
                LogoActivity.this.finish();
            }
        }
    };
    private ClickableSpan gaO = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.7
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

    static /* synthetic */ int y(LogoActivity logoActivity) {
        int i = logoActivity.gax;
        logoActivity.gax = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJr() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.gar = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        com.baidu.adp.lib.f.h.mC().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.15
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.bJG();
                LogoActivity.bJF();
            }
        });
        finish();
    }

    private void M(Intent intent) {
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
        this.gaH = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dKg().z(getUniqueId());
        init(bundle);
    }

    private boolean bJs() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new aq("c11897").dW("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJt() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bJu() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.bkF(), getPageContext().getPageActivity());
            }
        }
        fD(getPageContext().getPageActivity());
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
        if (this.gaF != null && this.gaF.getView() != null && this.gaF.getView().getParent() != null) {
            if (this.gaF.getView() != null) {
                if (this.gaF.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gaF.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.gaF.getView().setLayoutParams(layoutParams);
        }
        if (this.gaB != null && this.gaB.eFb != null) {
            this.gaB.eFb.bjV();
        }
    }

    private void bJv() {
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
        this.gat = false;
        if (this.gaz != null) {
            this.gaz.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gat = true;
        if (this.gam) {
            this.gam = false;
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.brx().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.brx().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (ad.bsf()) {
            NASLib.onAppStart(getActivity());
        }
        if (this.gas) {
            bJE();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.gar) {
            bJr();
            this.gar = false;
        }
        if (this.gaz != null) {
            this.gaz.onResume();
        }
        if (LogoActivityConfig.isFirst && this.gaH >= 0) {
            com.baidu.tbadk.n.l.bDT().eo(System.currentTimeMillis() - this.gaH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gaB != null) {
            this.gaB.setParentView(null);
            this.gaB.a(null);
        }
        if (this.gaE != null) {
            this.gaE.setParentView(null);
            this.gaE.a(null);
        }
        if (this.gaF != null) {
            this.gaF.release();
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gay);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gaK);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gaL);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gaM);
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.gaN);
        if (this.gaz != null) {
            this.gaz.onDestroy();
        }
        if (this.gak != null && !this.gak.isRecycled()) {
            this.gak.recycle();
            this.gak = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.dKg().A(getUniqueId());
        com.baidu.adp.lib.util.d.nI().clearCashBitmap();
    }

    private void fD(Context context) {
        bJw();
        if (LogoActivityConfig.mFromSpacial) {
            sL(2);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.gal) {
                com.baidu.adp.lib.f.e.mB().post(this.gaK);
            } else {
                sL(2);
            }
        } else if (this.gal) {
            com.baidu.adp.lib.f.e.mB().post(this.gaK);
        } else {
            bJx();
        }
    }

    private void bJw() {
        if (this.gal) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.brx().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bJx() {
        if (this.gaq != -2) {
            if (this.gaz == null) {
                this.gaz = new com.baidu.tieba.w.d(this);
            }
            if (this.gaz.dTw()) {
                this.gaA = this.gaz.D(0.8125d);
                this.mRootView.addView(this.gaA);
                this.gaz.a(this.gaI);
                this.gaz.start();
                return;
            }
            this.gaz.dTA();
        }
        bJy();
    }

    private void bJy() {
        this.gan = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.s.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.gaF = (com.baidu.tbadk.s.a) runTask.getData();
            this.gaF.a(this.gaG);
            this.gaF.bEy();
            com.baidu.tbadk.n.l.bDT().ep(System.currentTimeMillis() - this.gan);
            int i = com.baidu.tbadk.core.sharedPref.b.brx().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.mB().postDelayed(this.gaN, i * 1000);
            return;
        }
        bJz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJz() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bJC();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        MessageTask findTask2 = MessageManager.getInstance().findTask(2156676);
        if (findTask2 == null && findTask == null) {
            bJC();
            return;
        }
        boolean yX = com.baidu.tbadk.a.b.yX("ad_xuzhang_splash_sdk");
        if (findTask2 != null && yX) {
            bJA();
        } else if (findTask != null) {
            bJB();
        } else {
            bJC();
        }
    }

    private void bJA() {
        this.gan = System.currentTimeMillis();
        this.gao = System.currentTimeMillis();
        this.gaE = new com.baidu.tbadk.g.d();
        this.gaC = new BesAdViewContainer(getPageContext().getPageActivity());
        this.gaC.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bJE();
            }
        });
        this.gaC.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.gaC);
        this.gaE.setParentView(this.gaC);
        this.gaE.a(new com.baidu.tbadk.g.c() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tbadk.g.c
            public void zd(String str) {
                LogoActivity.this.gaD = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.gaC);
                LogoActivity.this.bJC();
                com.baidu.tbadk.n.l.bDT().eq(System.currentTimeMillis() - LogoActivity.this.gao);
            }

            @Override // com.baidu.tbadk.g.c
            public void bjW() {
                LogoActivity.this.gaD = true;
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
                if (LogoActivity.this.gaq == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mB().removeCallbacks(LogoActivity.this.gaM);
                com.baidu.tbadk.n.l.bDT().er(System.currentTimeMillis());
                com.baidu.tbadk.n.l.bDT().eq(System.currentTimeMillis() - LogoActivity.this.gao);
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdDismiss() {
                LogoActivity.this.gas = true;
                if (LogoActivity.this.gat) {
                    LogoActivity.this.bJE();
                }
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdClick() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2156676, this.gaE));
        com.baidu.tbadk.n.l.bDT().ep(System.currentTimeMillis() - this.gan);
        int i = com.baidu.tbadk.core.sharedPref.b.brx().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.gaM, (i > 0 ? i : 1) * 1000);
    }

    private void bJB() {
        this.gan = System.currentTimeMillis();
        this.gao = System.currentTimeMillis();
        this.gaB = new com.baidu.tbadk.g.e();
        this.gaC = new BesAdViewContainer(getPageContext().getPageActivity());
        this.gaC.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bJE();
            }
        });
        this.gaC.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.gaC);
        this.gaB.setParentView(this.gaC);
        this.gaB.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.5
            @Override // com.baidu.tbadk.g.a
            public void zd(String str) {
                LogoActivity.this.gaD = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.gaC);
                LogoActivity.this.bJC();
                com.baidu.tbadk.n.l.bDT().eq(System.currentTimeMillis() - LogoActivity.this.gao);
            }

            @Override // com.baidu.tbadk.g.a
            public void v(boolean z, boolean z2) {
                LogoActivity.this.gaD = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).an("obj_type", z2 ? 2 : 1));
                aq aqVar = new aq("common_exp");
                aqVar.dW("page_type", "a030").an("obj_isad", 1).an("obj_floor", 1).an("obj_source", 1).an("obj_adlocate", 16);
                if (z) {
                    aqVar.an("obj_type", z2 ? 4 : 3);
                } else {
                    aqVar.an("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dKg().a(LogoActivity.this.getUniqueId(), "bes_ad_id", aqVar);
                com.baidu.tieba.s.c.dKg().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.gaq == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mB().removeCallbacks(LogoActivity.this.gaM);
                com.baidu.tbadk.n.l.bDT().er(System.currentTimeMillis());
                com.baidu.tbadk.n.l.bDT().eq(System.currentTimeMillis() - LogoActivity.this.gao);
            }

            @Override // com.baidu.tbadk.g.a
            public void onAdDismiss() {
                LogoActivity.this.gas = true;
                if (LogoActivity.this.gat) {
                    LogoActivity.this.bJE();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void w(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new aq(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).an("obj_type", z2 ? 2 : 1));
                aq aqVar = new aq("common_click");
                aqVar.dW("page_type", "a030").an("obj_isad", 1).an("obj_floor", 1).an("obj_source", 1).an("obj_adlocate", 16);
                if (z) {
                    aqVar.an("obj_type", z2 ? 4 : 3);
                } else {
                    aqVar.an("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dKg().b(LogoActivity.this.getUniqueId(), aqVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.gaB));
        com.baidu.tbadk.n.l.bDT().ep(System.currentTimeMillis() - this.gan);
        int i = com.baidu.tbadk.core.sharedPref.b.brx().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mB().postDelayed(this.gaM, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJC() {
        if (this.gaq == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.mB().post(this.gaL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJD() {
        if (this.gaq >= 0) {
            sM(this.gaq);
        } else if (this.gaq == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJE() {
        bJD();
        com.baidu.tbadk.n.l.bDT().es(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bJF() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            n.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJG() {
        File[] listFiles;
        File file = new File(n.getCacheDir());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.LogoActivity.6
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

    private void sL(int i) {
        this.gaq = i;
        bJx();
    }

    private void sM(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJH() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.gaO, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0302)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.gau = new com.baidu.tbadk.core.dialog.a(this);
        this.gau.br(inflate);
        this.gau.nx(3);
        this.gau.jE(false);
        this.gau.setAutoNight(false);
        this.gau.jD(false);
        ao.a((View) textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        ao.a((View) textView3, R.color.CAM_X0105, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.ffD);
        textView3.setOnClickListener(this.ffD);
        this.gau.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJI() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        ao.a((View) textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.ffD);
        this.gav = new com.baidu.tbadk.core.dialog.a(this);
        this.gav.br(inflate);
        this.gav.nx(3);
        this.gav.jE(false);
        this.gav.setAutoNight(false);
        this.gav.jD(false);
        this.gav.b(getPageContext());
    }

    private void init(Bundle bundle) {
        if (!ad.bsf()) {
            bJH();
            this.gau.bqe();
            this.gax--;
            TiebaStatic.log(new aq("c13294"));
        } else if (!bJK() && !ad.checkLocationForGoogle(getActivity())) {
            bJL();
        } else {
            if (ad.checkLocationForGoogle(getActivity())) {
                com.baidu.adp.lib.c.a.lI().getAddress(false);
            }
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            if (bJt()) {
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                try {
                    setContentView(R.layout.logo_activity);
                    this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                    LogoActivityConfig.isFirst = true;
                    registerListener(this.gaJ);
                    this.gaq = -2;
                    bJy();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                } catch (Throwable th) {
                    BdLog.e(th);
                    finish();
                }
            } else if (!isTaskRoot() && !bJs()) {
                finish();
            } else {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.HOST_START).an("obj_param1", 2).an(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getStartType()).an(TiebaInitialize.Params.OBJ_PARAM3, TbadkCoreApplication.getInst().getCanShowSplash()));
                TbadkCoreApplication.getInst().onLowMemory();
                if (!TbadkCoreApplication.isLogin()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.METHOD_PASSV6_SWITCH_INITED, null));
                }
                M(getIntent());
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
                this.gal = TbadkCoreApplication.getInst().getIsFirstUse();
                com.baidu.tbadk.n.l.bDT().ll(this.gal);
                registerListener(this.gaJ);
                bJu();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("type", "start");
                hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
                hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                    bJv();
                }
                if (!n.checkSD()) {
                    TiebaStatic.file("no SD", "LogoActivity.onCreate");
                }
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJJ() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.final_private_dialog, (ViewGroup) null);
        inflate.findViewById(R.id.final_private_button_layout).setVisibility(0);
        TextView textView = (TextView) inflate.findViewById(R.id.final_scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.final_private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.final_private_no);
        ao.a((View) textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        ao.a((View) textView3, R.color.CAM_X0105, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.ffD);
        textView3.setOnClickListener(this.ffD);
        this.gaw = new com.baidu.tbadk.core.dialog.a(this);
        this.gaw.br(inflate);
        this.gaw.nx(3);
        this.gaw.jE(false);
        this.gaw.setAutoNight(false);
        this.gaw.jD(false);
        this.gaw.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        sL(2);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        sL(intExtra);
                        return;
                    } else {
                        sL(2);
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
            com.baidu.adp.lib.c.a.lI().getAddress(false);
            bJr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bJK() {
        return at.equals(TbConfig.getVersion(), com.baidu.tbadk.core.sharedPref.b.brx().getString("key_location_request_dialog_last_show_version", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJL() {
        com.baidu.tbadk.core.sharedPref.b.brx().putString("key_location_request_dialog_last_show_version", TbConfig.getVersion());
        ad.a(getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
            public void onClose() {
                LogoActivity.this.bJr();
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
            LogoActivity.this.bJE();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a064";
    }
}
