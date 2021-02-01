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
import com.baidu.adp.framework.task.MessageTask;
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
    private boolean gcI;
    private com.baidu.tbadk.core.dialog.a gcL;
    private com.baidu.tbadk.core.dialog.a gcM;
    private com.baidu.tbadk.core.dialog.a gcN;
    private com.baidu.tieba.w.d gcQ;
    private View gcR;
    private com.baidu.tbadk.g.c gcS;
    private BesAdViewContainer gcT;
    private com.baidu.tbadk.s.a gcV;
    private RelativeLayout mRootView;
    private Bitmap mBgBitmap = null;
    private boolean gcD = false;
    private boolean gcE = true;
    private long gcF = -1;
    private long gcG = -1;
    private int gcH = -1;
    private boolean gcJ = false;
    private boolean gcK = true;
    private int gcO = 2;
    private b gcP = new b();
    private boolean gcU = false;
    private com.baidu.tbadk.s.b gcW = new com.baidu.tbadk.s.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.s.b
        public void bER() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(LogoActivity.this.gdd);
            LogoActivity.this.bJT();
        }

        @Override // com.baidu.tbadk.s.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(LogoActivity.this.gdd);
            if (LogoActivity.this.gcV.getView() == null) {
                LogoActivity.this.bJX();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.gcV.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.gcV.getView());
            if (LogoActivity.this.gcH == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            com.baidu.tbadk.n.l.bEl().ex(System.currentTimeMillis());
            TiebaStatic.log(new ar("c13331").dR("obj_id", str).ap("obj_type", z2 ? 2 : 1));
            ar arVar = new ar("common_exp");
            arVar.dR("page_type", "a030").ap("obj_isad", 1).dR("obj_id", str).ap("obj_floor", 1).ap("obj_source", 2).ap("obj_adlocate", 16);
            if (z) {
                arVar.ap("obj_type", z2 ? 4 : 3);
            } else {
                arVar.ap("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dMr().a(LogoActivity.this.getUniqueId(), str, arVar);
            com.baidu.tieba.s.c.dMr().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.s.b
        public void onAdDismiss() {
            LogoActivity.this.gcJ = true;
            if (LogoActivity.this.gcK) {
                LogoActivity.this.bJX();
            }
        }

        @Override // com.baidu.tbadk.s.b
        public void ay(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.gcV.getView() != null) {
                z2 = LogoActivity.this.gcV.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new ar("c13332").dR("obj_id", str).ap("obj_type", z2 ? 2 : 1));
            ar arVar = new ar("common_click");
            arVar.dR("page_type", "a030").ap("obj_isad", 1).dR("obj_id", str).ap("obj_floor", 1).ap("obj_source", 2).ap("obj_adlocate", 16);
            if (z) {
                arVar.ap("obj_type", z2 ? 4 : 3);
            } else {
                arVar.ap("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.s.c.dMr().b(LogoActivity.this.getUniqueId(), arVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bJX();
        }
    };
    private long gcX = -1;
    private d.a gcY = new d.a() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.bJV();
        }

        @Override // com.baidu.tieba.w.d.a
        public void bKg() {
            if (LogoActivity.this.gcH != -2) {
                LogoActivity.this.bJW();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener gcZ = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bJN()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(LogoActivity.this.gcP);
                    LogoActivity.this.gcJ = true;
                    if (LogoActivity.this.gcK) {
                        LogoActivity.this.bJX();
                    }
                }
            }
        }
    };
    private Runnable gda = new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bJL();
        }
    };
    private Runnable gdb = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bJX();
        }
    };
    private Runnable gdc = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.gcU && LogoActivity.this.gcT != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.gcT);
                com.baidu.adp.lib.f.e.mA().post(LogoActivity.this.gdb);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable gdd = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bJV();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    View.OnClickListener fhT = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.15
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes || id == R.id.final_private_yes) {
                if (id == R.id.private_yes) {
                    f.ef("1", "1");
                } else if (id == R.id.final_private_yes) {
                    f.ef("3", "1");
                }
                if (LogoActivity.this.gcL != null && LogoActivity.this.gcL.isShowing()) {
                    LogoActivity.this.gcL.dismiss();
                }
                if (LogoActivity.this.gcN != null && LogoActivity.this.gcN.isShowing()) {
                    LogoActivity.this.gcN.dismiss();
                }
                ae.jM(true);
                com.baidu.tbadk.core.sharedPref.b.brQ().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bKd() || ae.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bJL();
                    ar arVar = new ar("c13295");
                    arVar.dR("obj_locate", "1");
                    TiebaStatic.log(arVar);
                    return;
                }
                LogoActivity.this.bKe();
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.gcL.isShowing()) {
                    LogoActivity.this.gcL.dismiss();
                }
                ar arVar2 = new ar("c13295");
                arVar2.dR("obj_locate", "2");
                TiebaStatic.log(arVar2);
                if (LogoActivity.this.gcM == null) {
                    LogoActivity.this.bKb();
                }
                LogoActivity.this.gcM.bqx();
                f.Es("2");
                f.ef("1", "2");
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.gcM.isShowing()) {
                    LogoActivity.this.gcM.dismiss();
                }
                if (LogoActivity.this.gcO > 0) {
                    if (LogoActivity.this.gcL == null) {
                        LogoActivity.this.bKa();
                    }
                    LogoActivity.this.gcL.bqx();
                    LogoActivity.y(LogoActivity.this);
                    f.Es("1");
                } else {
                    if (LogoActivity.this.gcN == null) {
                        LogoActivity.this.bKc();
                    }
                    LogoActivity.this.gcN.bqx();
                    f.Es("3");
                }
                f.ef("2", "3");
            } else if (id == R.id.final_private_no) {
                if (LogoActivity.this.gcN.isShowing()) {
                    LogoActivity.this.gcN.dismiss();
                }
                f.ef("3", "2");
                LogoActivity.this.finish();
            }
        }
    };

    static /* synthetic */ int y(LogoActivity logoActivity) {
        int i = logoActivity.gcO;
        logoActivity.gcO = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJL() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.gcI = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        com.baidu.adp.lib.f.h.mB().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.14
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.bJZ();
                LogoActivity.bJY();
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
        this.gcX = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMr().A(getUniqueId());
        init(bundle);
    }

    private boolean bJM() {
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
    public boolean bJN() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bJO() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.bkX(), getPageContext().getPageActivity());
            }
        }
        fC(getPageContext().getPageActivity());
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
        if (this.gcV != null && this.gcV.getView() != null && this.gcV.getView().getParent() != null) {
            if (this.gcV.getView() != null) {
                if (this.gcV.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gcV.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.gcV.getView().setLayoutParams(layoutParams);
        }
        if (this.gcS != null && this.gcS.eHh != null) {
            this.gcS.eHh.bkp();
        }
    }

    private void bJP() {
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
        this.gcK = false;
        if (this.gcQ != null) {
            this.gcQ.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gcK = true;
        if (this.gcE) {
            this.gcE = false;
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (ae.bsz()) {
            NASLib.onAppStart(getActivity());
        }
        if (this.gcJ) {
            bJX();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.gcI) {
            bJL();
            this.gcI = false;
        }
        if (this.gcQ != null) {
            this.gcQ.onResume();
        }
        if (LogoActivityConfig.isFirst && this.gcX >= 0) {
            com.baidu.tbadk.n.l.bEl().eu(System.currentTimeMillis() - this.gcX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gcS != null) {
            this.gcS.setParentView(null);
            this.gcS.a(null);
        }
        if (this.gcV != null) {
            this.gcV.release();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gcP);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gda);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gdb);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gdc);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gdd);
        if (this.gcQ != null) {
            this.gcQ.onDestroy();
        }
        if (this.mBgBitmap != null && !this.mBgBitmap.isRecycled()) {
            this.mBgBitmap.recycle();
            this.mBgBitmap = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.dMr().B(getUniqueId());
        com.baidu.adp.lib.util.d.nH().clearCashBitmap();
    }

    private void fC(Context context) {
        bJQ();
        if (LogoActivityConfig.mFromSpacial) {
            sQ(2);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.gcD) {
                com.baidu.adp.lib.f.e.mA().post(this.gda);
            } else {
                sQ(2);
            }
        } else if (this.gcD) {
            com.baidu.adp.lib.f.e.mA().post(this.gda);
        } else {
            bJR();
        }
    }

    private void bJQ() {
        if (this.gcD) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bJR() {
        if (this.gcH != -2) {
            if (this.gcQ == null) {
                this.gcQ = new com.baidu.tieba.w.d(this);
            }
            if (this.gcQ.dVI()) {
                this.gcR = this.gcQ.D(0.8125d);
                this.mRootView.addView(this.gcR);
                this.gcQ.a(this.gcY);
                this.gcQ.start();
                return;
            }
            this.gcQ.dVM();
        }
        bJS();
    }

    private void bJS() {
        this.gcF = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.s.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.gcV = (com.baidu.tbadk.s.a) runTask.getData();
            this.gcV.a(this.gcW);
            this.gcV.bEQ();
            com.baidu.tbadk.n.l.bEl().ev(System.currentTimeMillis() - this.gcF);
            int i = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.mA().postDelayed(this.gdd, i * 1000);
            return;
        }
        bJT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJT() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bJV();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        if (MessageManager.getInstance().findTask(2156676) == null && findTask == null) {
            bJV();
        } else if (findTask != null) {
            bJU();
        } else {
            bJV();
        }
    }

    private void bJU() {
        this.gcF = System.currentTimeMillis();
        this.gcG = System.currentTimeMillis();
        this.gcS = new com.baidu.tbadk.g.c();
        this.gcT = new BesAdViewContainer(getPageContext().getPageActivity());
        this.gcT.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bJX();
            }
        });
        this.gcT.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.gcT);
        this.gcS.setParentView(this.gcT);
        this.gcS.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tbadk.g.a
            public void zv(String str) {
                LogoActivity.this.gcU = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.gcT);
                LogoActivity.this.bJV();
                com.baidu.tbadk.n.l.bEl().ew(System.currentTimeMillis() - LogoActivity.this.gcG);
            }

            @Override // com.baidu.tbadk.g.a
            public void e(boolean z, boolean z2, int i) {
                LogoActivity.this.gcU = true;
                com.baidu.adp.lib.f.e.mA().removeCallbacks(LogoActivity.this.gdc);
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new ar(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).ap("obj_type", z2 ? 2 : 1));
                ar arVar = new ar("common_exp");
                arVar.dR("page_type", "a030").ap("obj_isad", 1).ap("obj_floor", 1).ap("obj_source", i).ap("obj_adlocate", 16);
                if (z) {
                    arVar.ap("obj_type", z2 ? 4 : 3);
                } else {
                    arVar.ap("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dMr().a(LogoActivity.this.getUniqueId(), "bes_ad_id", arVar);
                com.baidu.tieba.s.c.dMr().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.gcH == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.tbadk.n.l.bEl().ex(System.currentTimeMillis());
                com.baidu.tbadk.n.l.bEl().ew(System.currentTimeMillis() - LogoActivity.this.gcG);
            }

            @Override // com.baidu.tbadk.g.a
            public void onAdDismiss() {
                LogoActivity.this.gcJ = true;
                if (LogoActivity.this.gcK) {
                    LogoActivity.this.bJX();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void f(boolean z, boolean z2, int i) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new ar(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).ap("obj_type", z2 ? 2 : 1));
                ar arVar = new ar("common_click");
                arVar.dR("page_type", "a030").ap("obj_isad", 1).ap("obj_floor", 1).ap("obj_source", i).ap("obj_adlocate", 16);
                if (z) {
                    arVar.ap("obj_type", z2 ? 4 : 3);
                } else {
                    arVar.ap("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.s.c.dMr().b(LogoActivity.this.getUniqueId(), arVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.gcS));
        com.baidu.tbadk.n.l.bEl().ev(System.currentTimeMillis() - this.gcF);
        int i = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.gdc, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJV() {
        if (this.gcH == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.mA().post(this.gdb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJW() {
        if (this.gcH >= 0) {
            sR(this.gcH);
        } else if (this.gcH == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJX() {
        bJW();
        com.baidu.tbadk.n.l.bEl().ey(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bJY() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            o.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJZ() {
        File[] listFiles;
        File file = new File(o.getCacheDir());
        if (file.isDirectory() && (listFiles = file.listFiles(new FileFilter() { // from class: com.baidu.tieba.LogoActivity.4
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

    private void sQ(int i) {
        this.gcH = i;
        bJR();
    }

    private void sR(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKa() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        inflate.findViewById(R.id.protocol_layout).setVisibility(0);
        TextView textView = (TextView) inflate.findViewById(R.id.protocol_scrollable_textview);
        textView.setHighlightColor(0);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new a() { // from class: com.baidu.tieba.LogoActivity.5
            @Override // android.text.style.ClickableSpan
            public void onClick(@NonNull View view) {
                com.baidu.tbadk.browser.a.startExternWebActivity(LogoActivity.this.getActivity(), "http://tieba.baidu.com/tb/cms/client/wise_secretright.html");
            }
        }, 119, Constants.METHOD_IM_FRIEND_GROUP_ASSIGN, 33);
        spannableString.setSpan(new a() { // from class: com.baidu.tieba.LogoActivity.6
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
        this.gcL = new com.baidu.tbadk.core.dialog.a(this);
        this.gcL.bn(inflate);
        this.gcL.nA(7);
        this.gcL.jG(false);
        this.gcL.setAutoNight(false);
        this.gcL.jF(false);
        com.baidu.tbadk.core.elementsMaven.c.br(textView2).og(R.string.J_X01).setBackGroundColor(R.color.CAM_X0303);
        ap.a((View) textView2, R.color.CAM_X0101, R.color.CAM_X0618, 0);
        ap.a((View) textView3, R.color.CAM_X0110, R.color.CAM_X0110, 0);
        textView2.setOnClickListener(this.fhT);
        textView3.setOnClickListener(this.fhT);
        this.gcL.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKb() {
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
        textView2.setOnClickListener(this.fhT);
        this.gcM = new com.baidu.tbadk.core.dialog.a(this);
        this.gcM.bn(inflate);
        this.gcM.nA(3);
        this.gcM.jG(false);
        this.gcM.setAutoNight(false);
        this.gcM.jF(false);
        this.gcM.b(getPageContext());
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
        if (!ae.bsz()) {
            bKa();
            this.gcL.bqx();
            this.gcO--;
            f.Es("1");
            TiebaStatic.log(new ar("c13294"));
        } else if (!bKd() && !ae.checkLocationForGoogle(getActivity())) {
            bKe();
        } else {
            if (ae.checkLocationForGoogle(getActivity())) {
                com.baidu.adp.lib.c.a.lH().getAddress(false);
            }
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            if (bJN()) {
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                try {
                    setContentView(R.layout.logo_activity);
                    this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                    LogoActivityConfig.isFirst = true;
                    registerListener(this.gcZ);
                    this.gcH = -2;
                    bJS();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                } catch (Throwable th) {
                    BdLog.e(th);
                    finish();
                }
            } else if (!isTaskRoot() && !bJM()) {
                finish();
            } else {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.HOST_START).ap("obj_param1", 2).ap(TiebaInitialize.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getStartType()).ap(TiebaInitialize.Params.OBJ_PARAM3, TbadkCoreApplication.getInst().getCanShowSplash()));
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
                this.gcD = TbadkCoreApplication.getInst().getIsFirstUse();
                com.baidu.tbadk.n.l.bEl().lo(this.gcD);
                registerListener(this.gcZ);
                bJO();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("type", "start");
                hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
                hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                    bJP();
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
    public void bKc() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.final_private_dialog, (ViewGroup) null);
        inflate.findViewById(R.id.final_private_button_layout).setVisibility(0);
        TextView textView = (TextView) inflate.findViewById(R.id.final_scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.final_private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.final_private_no);
        ap.a((View) textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        ap.a((View) textView3, R.color.CAM_X0105, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.fhT);
        textView3.setOnClickListener(this.fhT);
        this.gcN = new com.baidu.tbadk.core.dialog.a(this);
        this.gcN.bn(inflate);
        this.gcN.nA(3);
        this.gcN.jG(false);
        this.gcN.setAutoNight(false);
        this.gcN.jF(false);
        this.gcN.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        sQ(2);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        sQ(intExtra);
                        return;
                    } else {
                        sQ(2);
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
            bJL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKd() {
        return au.equals(TbConfig.getVersion(), com.baidu.tbadk.core.sharedPref.b.brQ().getString("key_location_request_dialog_last_show_version", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKe() {
        com.baidu.tbadk.core.sharedPref.b.brQ().putString("key_location_request_dialog_last_show_version", TbConfig.getVersion());
        ae.a(getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.7
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
            public void onClose() {
                LogoActivity.this.bJL();
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
            LogoActivity.this.bJX();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a064";
    }
}
