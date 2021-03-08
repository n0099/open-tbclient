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
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
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
    private com.baidu.tbadk.g.c geA;
    private BesAdViewContainer geB;
    private com.baidu.tbadk.s.a geD;
    private boolean gen;
    private com.baidu.tbadk.core.dialog.a ger;
    private com.baidu.tbadk.core.dialog.a ges;
    private com.baidu.tbadk.core.dialog.a get;
    private com.baidu.tieba.w.d gey;
    private View gez;
    private RelativeLayout mRootView;
    private Bitmap mBgBitmap = null;
    private boolean gei = false;
    private boolean gej = true;
    private long gek = -1;
    private long gel = -1;
    private int gem = -1;
    private boolean gep = false;
    private boolean geq = true;
    private int geu = 2;
    private int gev = 0;
    private long gew = 0;
    private b gex = new b();
    private boolean geC = false;
    private com.baidu.tbadk.s.b geE = new com.baidu.tbadk.s.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.s.b
        public void bEV() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(LogoActivity.this.geM);
            LogoActivity.this.bKc();
        }

        @Override // com.baidu.tbadk.s.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(LogoActivity.this.geM);
            if (LogoActivity.this.geD.getView() == null) {
                LogoActivity.this.bKg();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.geD.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.geD.getView());
            if (LogoActivity.this.gem == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            com.baidu.tbadk.n.l.bEp().ex(System.currentTimeMillis());
            TiebaStatic.log(new ar("c13331").dR("obj_id", str).aq("obj_type", z2 ? 2 : 1));
            ar arVar = new ar("common_exp");
            arVar.dR("page_type", "a030").aq("obj_isad", 1).dR("obj_id", str).aq("obj_floor", 1).aq("obj_source", 2).aq("obj_adlocate", 16);
            if (z) {
                arVar.aq("obj_type", z2 ? 4 : 3);
            } else {
                arVar.aq("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dMH().a(LogoActivity.this.getUniqueId(), str, arVar);
            com.baidu.tieba.s.c.dMH().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.s.b
        public void onAdDismiss() {
            LogoActivity.this.gep = true;
            if (LogoActivity.this.geq) {
                LogoActivity.this.bKg();
            }
        }

        @Override // com.baidu.tbadk.s.b
        public void ay(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.geD.getView() != null) {
                z2 = LogoActivity.this.geD.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new ar("c13332").dR("obj_id", str).aq("obj_type", z2 ? 2 : 1));
            ar arVar = new ar("common_click");
            arVar.dR("page_type", "a030").aq("obj_isad", 1).dR("obj_id", str).aq("obj_floor", 1).aq("obj_source", 2).aq("obj_adlocate", 16);
            if (z) {
                arVar.aq("obj_type", z2 ? 4 : 3);
            } else {
                arVar.aq("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dMH().b(LogoActivity.this.getUniqueId(), arVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bKg();
        }
    };
    private long geF = -1;
    private d.a geG = new d.a() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.bKe();
        }

        @Override // com.baidu.tieba.w.d.a
        public void bKp() {
            if (LogoActivity.this.gem != -2) {
                LogoActivity.this.bKf();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener geH = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bJW()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(LogoActivity.this.gex);
                    LogoActivity.this.gep = true;
                    if (LogoActivity.this.geq) {
                        LogoActivity.this.bKg();
                    }
                }
            }
        }
    };
    private Runnable geI = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bJU();
        }
    };
    private Runnable geJ = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bKg();
        }
    };
    private Runnable geK = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.geC) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2921533, LogoActivity.this.geA));
                LogoActivity.this.gew = System.currentTimeMillis();
            }
        }
    };
    private Runnable geL = new Runnable() { // from class: com.baidu.tieba.LogoActivity.14
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.geC && LogoActivity.this.geB != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.geB);
                com.baidu.adp.lib.f.e.mA().post(LogoActivity.this.geJ);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable geM = new Runnable() { // from class: com.baidu.tieba.LogoActivity.15
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bKe();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    View.OnClickListener fjv = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes || id == R.id.final_private_yes) {
                if (id == R.id.private_yes) {
                    f.ef("1", "1");
                } else if (id == R.id.final_private_yes) {
                    f.ef("3", "1");
                }
                if (LogoActivity.this.ger != null && LogoActivity.this.ger.isShowing()) {
                    LogoActivity.this.ger.dismiss();
                }
                if (LogoActivity.this.get != null && LogoActivity.this.get.isShowing()) {
                    LogoActivity.this.get.dismiss();
                }
                ae.jM(true);
                com.baidu.tbadk.core.sharedPref.b.brR().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bKm() || ae.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bJU();
                    ar arVar = new ar("c13295");
                    arVar.dR("obj_locate", "1");
                    TiebaStatic.log(arVar);
                    return;
                }
                LogoActivity.this.bKn();
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.ger.isShowing()) {
                    LogoActivity.this.ger.dismiss();
                }
                ar arVar2 = new ar("c13295");
                arVar2.dR("obj_locate", "2");
                TiebaStatic.log(arVar2);
                if (LogoActivity.this.ges == null) {
                    LogoActivity.this.bKk();
                }
                LogoActivity.this.ges.bqz();
                f.Ex("2");
                f.ef("1", "2");
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.ges.isShowing()) {
                    LogoActivity.this.ges.dismiss();
                }
                if (LogoActivity.this.geu > 0) {
                    if (LogoActivity.this.ger == null) {
                        LogoActivity.this.bKj();
                    }
                    LogoActivity.this.ger.bqz();
                    LogoActivity.z(LogoActivity.this);
                    f.Ex("1");
                } else {
                    if (LogoActivity.this.get == null) {
                        LogoActivity.this.bKl();
                    }
                    LogoActivity.this.get.bqz();
                    f.Ex("3");
                }
                f.ef("2", "3");
            } else if (id == R.id.final_private_no) {
                if (LogoActivity.this.get.isShowing()) {
                    LogoActivity.this.get.dismiss();
                }
                f.ef("3", "2");
                LogoActivity.this.finish();
            }
        }
    };

    static /* synthetic */ int z(LogoActivity logoActivity) {
        int i = logoActivity.geu;
        logoActivity.geu = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJU() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.gen = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.16
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.bKi();
                LogoActivity.bKh();
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
        getWindow().getDecorView().setBackgroundResource(R.drawable.pic_splash_logo);
        this.geF = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMH().B(getUniqueId());
        init(bundle);
    }

    private boolean bJV() {
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
    public boolean bJW() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bJX() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.bkZ(), getPageContext().getPageActivity());
            }
        }
        fB(getPageContext().getPageActivity());
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
        if (this.geD != null && this.geD.getView() != null && this.geD.getView().getParent() != null) {
            if (this.geD.getView() != null) {
                if (this.geD.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.geD.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.geD.getView().setLayoutParams(layoutParams);
        }
        if (this.geA != null && this.geA.eII != null) {
            this.geA.eII.bkr();
        }
    }

    private void bJY() {
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
        this.geq = false;
        if (this.gey != null) {
            this.gey.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.geq = true;
        if (this.gej) {
            this.gej = false;
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.brR().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.brR().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (ae.bsC()) {
            NASLib.onAppStart(getActivity());
        }
        if (this.gep) {
            bKg();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.gen) {
            bJU();
            this.gen = false;
        }
        if (this.gey != null) {
            this.gey.onResume();
        }
        if (LogoActivityConfig.isFirst && this.geF >= 0) {
            com.baidu.tbadk.n.l.bEp().eu(System.currentTimeMillis() - this.geF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.geA != null) {
            this.geA.setParentView(null);
            this.geA.a(null);
        }
        if (this.geD != null) {
            this.geD.release();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gex);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.geI);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.geJ);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.geL);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.geK);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.geM);
        if (this.gey != null) {
            this.gey.onDestroy();
        }
        if (this.mBgBitmap != null && !this.mBgBitmap.isRecycled()) {
            this.mBgBitmap.recycle();
            this.mBgBitmap = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.dMH().C(getUniqueId());
        com.baidu.adp.lib.util.d.nH().clearCashBitmap();
    }

    private void fB(Context context) {
        bJZ();
        if (LogoActivityConfig.mFromSpacial) {
            sS(2);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.gei) {
                com.baidu.adp.lib.f.e.mA().post(this.geI);
            } else {
                sS(2);
            }
        } else if (this.gei) {
            com.baidu.adp.lib.f.e.mA().post(this.geI);
        } else {
            bKa();
        }
    }

    private void bJZ() {
        if (this.gei) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bKa() {
        if (this.gem != -2) {
            if (this.gey == null) {
                this.gey = new com.baidu.tieba.w.d(this);
            }
            if (this.gey.dVY()) {
                this.gez = this.gey.D(0.8125d);
                this.mRootView.addView(this.gez);
                this.gey.a(this.geG);
                this.gey.start();
                return;
            }
            this.gey.dWc();
        }
        bKb();
    }

    private void bKb() {
        this.gek = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.s.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.geD = (com.baidu.tbadk.s.a) runTask.getData();
            this.geD.a(this.geE);
            this.geD.bEU();
            com.baidu.tbadk.n.l.bEp().ev(System.currentTimeMillis() - this.gek);
            int i = com.baidu.tbadk.core.sharedPref.b.brR().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.mA().postDelayed(this.geM, i * 1000);
            return;
        }
        bKc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKc() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bKe();
        } else if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD) == null) {
            bKe();
        } else {
            bKd();
        }
    }

    private void bKd() {
        this.gek = System.currentTimeMillis();
        this.gel = System.currentTimeMillis();
        this.geA = new com.baidu.tbadk.g.c();
        this.geB = new BesAdViewContainer(getPageContext().getPageActivity());
        this.geB.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bKg();
            }
        });
        this.geB.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.geB);
        this.geA.setParentView(this.geB);
        this.geA.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tbadk.g.a
            public void zC(String str) {
                LogoActivity.this.geC = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.geB);
                LogoActivity.this.bKe();
                com.baidu.tbadk.n.l.bEp().ew(System.currentTimeMillis() - LogoActivity.this.gel);
            }

            @Override // com.baidu.tbadk.g.a
            public void e(boolean z, boolean z2, int i) {
                LogoActivity.this.geC = true;
                LogoActivity.this.gev = i;
                if (LogoActivity.this.gew > 0) {
                    com.baidu.tbadk.core.d.a.a("homePage", -1L, 0, "logo_splash", 0, "", "internal", Long.valueOf(System.currentTimeMillis() - LogoActivity.this.gew));
                }
                com.baidu.adp.lib.f.e.mA().removeCallbacks(LogoActivity.this.geK);
                com.baidu.adp.lib.f.e.mA().removeCallbacks(LogoActivity.this.geL);
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new ar(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).aq("obj_type", z2 ? 2 : 1).aq("obj_source", i));
                ar arVar = new ar("common_exp");
                arVar.dR("page_type", "a030").aq("obj_isad", 1).aq("obj_floor", 1).aq("obj_source", i).aq("obj_adlocate", 16);
                if (z) {
                    arVar.aq("obj_type", z2 ? 4 : 3);
                } else {
                    arVar.aq("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dMH().a(LogoActivity.this.getUniqueId(), "bes_ad_id", arVar);
                com.baidu.tieba.s.c.dMH().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.gem == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.tbadk.n.l.bEp().ex(System.currentTimeMillis());
                com.baidu.tbadk.n.l.bEp().ew(System.currentTimeMillis() - LogoActivity.this.gel);
            }

            @Override // com.baidu.tbadk.g.a
            public void onAdDismiss() {
                LogoActivity.this.gep = true;
                if (LogoActivity.this.geq) {
                    LogoActivity.this.bKg();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void f(boolean z, boolean z2, int i) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new ar(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).aq("obj_type", z2 ? 2 : 1).aq("obj_source", i));
                ar arVar = new ar("common_click");
                arVar.dR("page_type", "a030").aq("obj_isad", 1).aq("obj_floor", 1).aq("obj_source", i).aq("obj_adlocate", 16);
                if (z) {
                    arVar.aq("obj_type", z2 ? 4 : 3);
                } else {
                    arVar.aq("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dMH().b(LogoActivity.this.getUniqueId(), arVar);
            }
        });
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD, Long.class, this.geA);
        com.baidu.tbadk.n.l.bEp().ev(System.currentTimeMillis() - this.gek);
        long j = 1000;
        if (runTask != null) {
            j = ((Long) runTask.getData()).longValue();
        }
        com.baidu.adp.lib.f.e.mA().postDelayed(this.geK, j);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.geL, j + 500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKe() {
        if (this.gem == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.mA().post(this.geJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKf() {
        if (this.gem >= 0) {
            sT(this.gem);
        } else if (this.gem == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKg() {
        bKf();
        com.baidu.tbadk.n.l.bEp().ey(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bKh() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            o.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKi() {
        File[] listFiles;
        File file = new File(o.getCacheDir());
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

    private void sS(int i) {
        this.gem = i;
        bKa();
    }

    private void sT(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKj() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        inflate.findViewById(R.id.protocol_layout).setVisibility(0);
        TextView textView = (TextView) inflate.findViewById(R.id.protocol_scrollable_textview);
        textView.setHighlightColor(0);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new a() { // from class: com.baidu.tieba.LogoActivity.6
            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                com.baidu.tbadk.browser.a.startExternWebActivity(LogoActivity.this.getActivity(), "http://tieba.baidu.com/tb/cms/client/wise_secretright.html");
            }
        }, 119, Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, 33);
        spannableString.setSpan(new a() { // from class: com.baidu.tieba.LogoActivity.7
            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                com.baidu.tbadk.browser.a.startExternWebActivity(LogoActivity.this.getActivity(), "https://gsp0.baidu.com/5aAHeD3nKhI2p27j8IqW0jdnxx1xbK/tb/eula.html");
            }
        }, Opcodes.IAND, IMPushPb.PushImClient.ACTIONS_FIELD_NUMBER, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.ger = new com.baidu.tbadk.core.dialog.a(this);
        this.ger.bn(inflate);
        this.ger.nB(7);
        this.ger.jG(false);
        this.ger.setAutoNight(false);
        this.ger.jF(false);
        com.baidu.tbadk.core.elementsMaven.c.br(textView2).oh(R.string.J_X01).setBackGroundColor(R.color.CAM_X0303);
        ap.a((View) textView2, R.color.CAM_X0101, R.color.CAM_X0618, 0);
        ap.a((View) textView3, R.color.CAM_X0110, R.color.CAM_X0110, 0);
        textView2.setOnClickListener(this.fjv);
        textView3.setOnClickListener(this.fjv);
        this.ger.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKk() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setVisibility(0);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        ap.a((View) textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.fjv);
        this.ges = new com.baidu.tbadk.core.dialog.a(this);
        this.ges.bn(inflate);
        this.ges.nB(3);
        this.ges.jG(false);
        this.ges.setAutoNight(false);
        this.ges.jF(false);
        this.ges.b(getPageContext());
    }

    /* loaded from: classes.dex */
    private abstract class a extends ClickableSpan {
        private a() {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(LogoActivity.this.getResources().getColor(R.color.CAM_X0303));
        }
    }

    private void init(Bundle bundle) {
        if (!ae.bsC()) {
            bKj();
            this.ger.bqz();
            this.geu--;
            f.Ex("1");
            TiebaStatic.log(new ar("c13294"));
        } else if (!bKm() && !ae.checkLocationForGoogle(getActivity())) {
            bKn();
        } else {
            if (ae.checkLocationForGoogle(getActivity())) {
                com.baidu.adp.lib.c.a.lH().getAddress(false);
            }
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            if (bJW()) {
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                try {
                    setContentView(R.layout.logo_activity);
                    this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                    LogoActivityConfig.isFirst = true;
                    registerListener(this.geH);
                    this.gem = -2;
                    bKb();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                } catch (Throwable th) {
                    BdLog.e(th);
                    finish();
                }
            } else if (!isTaskRoot() && !bJV()) {
                finish();
            } else {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.HOST_START).aq("obj_param1", 2).aq(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getStartType()).aq(TiebaInitialize.Params.OBJ_PARAM3, TbadkCoreApplication.getInst().getCanShowSplash()));
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
                this.gei = TbadkCoreApplication.getInst().getIsFirstUse();
                com.baidu.tbadk.n.l.bEp().lo(this.gei);
                registerListener(this.geH);
                bJX();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("type", "start");
                hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
                hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                    bJY();
                }
                if (!o.checkSD()) {
                    TiebaStatic.file("no SD", "LogoActivity.onCreate");
                }
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_DEBUG_PLUGIN_SERVICE, new IntentConfig(getPageContext().getContext())));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKl() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.final_private_dialog, (ViewGroup) null);
        inflate.findViewById(R.id.final_private_button_layout).setVisibility(0);
        TextView textView = (TextView) inflate.findViewById(R.id.final_scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.final_private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.final_private_no);
        ap.a((View) textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        ap.a((View) textView3, R.color.CAM_X0105, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.fjv);
        textView3.setOnClickListener(this.fjv);
        this.get = new com.baidu.tbadk.core.dialog.a(this);
        this.get.bn(inflate);
        this.get.nB(3);
        this.get.jG(false);
        this.get.setAutoNight(false);
        this.get.jF(false);
        this.get.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        sS(2);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        sS(intExtra);
                        return;
                    } else {
                        sS(2);
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
            com.baidu.adp.lib.c.a.lH().getAddress(false);
            bJU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKm() {
        return au.equals(TbConfig.getVersion(), com.baidu.tbadk.core.sharedPref.b.brR().getString("key_location_request_dialog_last_show_version", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKn() {
        com.baidu.tbadk.core.sharedPref.b.brR().putString("key_location_request_dialog_last_show_version", TbConfig.getVersion());
        ae.a(getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
            public void onClose() {
                LogoActivity.this.bJU();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bKg();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a064";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.rv(this.gev);
        }
        return pageStayDurationItem;
    }
}
