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
    private boolean gcN;
    private com.baidu.tbadk.core.dialog.a gcQ;
    private com.baidu.tbadk.core.dialog.a gcR;
    private com.baidu.tbadk.core.dialog.a gcS;
    private com.baidu.tieba.w.d gcV;
    private View gcW;
    private com.baidu.tbadk.g.c gcX;
    private BesAdViewContainer gcY;
    private com.baidu.tbadk.s.a gda;
    private RelativeLayout mRootView;
    private Bitmap mBgBitmap = null;
    private boolean gcI = false;
    private boolean gcJ = true;
    private long gcK = -1;
    private long gcL = -1;
    private int gcM = -1;
    private boolean gcO = false;
    private boolean gcP = true;
    private int gcT = 2;
    private b gcU = new b();
    private boolean gcZ = false;
    private com.baidu.tbadk.s.b gdb = new com.baidu.tbadk.s.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.s.b
        public void bER() {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(LogoActivity.this.gdi);
            LogoActivity.this.bJY();
        }

        @Override // com.baidu.tbadk.s.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.mA().removeCallbacks(LogoActivity.this.gdi);
            if (LogoActivity.this.gda.getView() == null) {
                LogoActivity.this.bKc();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.gda.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.gda.getView());
            if (LogoActivity.this.gcM == -2) {
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
            com.baidu.tieba.s.c.dMz().a(LogoActivity.this.getUniqueId(), str, arVar);
            com.baidu.tieba.s.c.dMz().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.s.b
        public void onAdDismiss() {
            LogoActivity.this.gcO = true;
            if (LogoActivity.this.gcP) {
                LogoActivity.this.bKc();
            }
        }

        @Override // com.baidu.tbadk.s.b
        public void ay(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.gda.getView() != null) {
                z2 = LogoActivity.this.gda.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
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
            com.baidu.tieba.s.c.dMz().b(LogoActivity.this.getUniqueId(), arVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bKc();
        }
    };
    private long gdc = -1;
    private d.a gdd = new d.a() { // from class: com.baidu.tieba.LogoActivity.8
        @Override // com.baidu.tieba.w.d.a
        public void onError() {
            LogoActivity.this.bKa();
        }

        @Override // com.baidu.tieba.w.d.a
        public void bKl() {
            if (LogoActivity.this.gcM != -2) {
                LogoActivity.this.bKb();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener gde = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bJS()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(LogoActivity.this.gcU);
                    LogoActivity.this.gcO = true;
                    if (LogoActivity.this.gcP) {
                        LogoActivity.this.bKc();
                    }
                }
            }
        }
    };
    private Runnable gdf = new Runnable() { // from class: com.baidu.tieba.LogoActivity.10
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bJQ();
        }
    };
    private Runnable gdg = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bKc();
        }
    };
    private Runnable gdh = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.gcZ && LogoActivity.this.gcY != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.gcY);
                com.baidu.adp.lib.f.e.mA().post(LogoActivity.this.gdg);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable gdi = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bKa();
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
                if (LogoActivity.this.gcQ != null && LogoActivity.this.gcQ.isShowing()) {
                    LogoActivity.this.gcQ.dismiss();
                }
                if (LogoActivity.this.gcS != null && LogoActivity.this.gcS.isShowing()) {
                    LogoActivity.this.gcS.dismiss();
                }
                ae.jM(true);
                com.baidu.tbadk.core.sharedPref.b.brQ().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bKi() || ae.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bJQ();
                    ar arVar = new ar("c13295");
                    arVar.dR("obj_locate", "1");
                    TiebaStatic.log(arVar);
                    return;
                }
                LogoActivity.this.bKj();
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.gcQ.isShowing()) {
                    LogoActivity.this.gcQ.dismiss();
                }
                ar arVar2 = new ar("c13295");
                arVar2.dR("obj_locate", "2");
                TiebaStatic.log(arVar2);
                if (LogoActivity.this.gcR == null) {
                    LogoActivity.this.bKg();
                }
                LogoActivity.this.gcR.bqx();
                f.Eq("2");
                f.ef("1", "2");
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.gcR.isShowing()) {
                    LogoActivity.this.gcR.dismiss();
                }
                if (LogoActivity.this.gcT > 0) {
                    if (LogoActivity.this.gcQ == null) {
                        LogoActivity.this.bKf();
                    }
                    LogoActivity.this.gcQ.bqx();
                    LogoActivity.y(LogoActivity.this);
                    f.Eq("1");
                } else {
                    if (LogoActivity.this.gcS == null) {
                        LogoActivity.this.bKh();
                    }
                    LogoActivity.this.gcS.bqx();
                    f.Eq("3");
                }
                f.ef("2", "3");
            } else if (id == R.id.final_private_no) {
                if (LogoActivity.this.gcS.isShowing()) {
                    LogoActivity.this.gcS.dismiss();
                }
                f.ef("3", "2");
                LogoActivity.this.finish();
            }
        }
    };

    static /* synthetic */ int y(LogoActivity logoActivity) {
        int i = logoActivity.gcT;
        logoActivity.gcT = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJQ() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.gcN = true;
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
                LogoActivity.this.bKe();
                LogoActivity.bKd();
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
        this.gdc = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.s.c.dMz().A(getUniqueId());
        init(bundle);
    }

    private boolean bJR() {
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
    public boolean bJS() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bJT() {
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
        if (this.gda != null && this.gda.getView() != null && this.gda.getView().getParent() != null) {
            if (this.gda.getView() != null) {
                if (this.gda.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gda.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.gda.getView().setLayoutParams(layoutParams);
        }
        if (this.gcX != null && this.gcX.eHh != null) {
            this.gcX.eHh.bkp();
        }
    }

    private void bJU() {
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
        this.gcP = false;
        if (this.gcV != null) {
            this.gcV.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gcP = true;
        if (this.gcJ) {
            this.gcJ = false;
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.brQ().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.brQ().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (ae.bsz()) {
            NASLib.onAppStart(getActivity());
        }
        if (this.gcO) {
            bKc();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.gcN) {
            bJQ();
            this.gcN = false;
        }
        if (this.gcV != null) {
            this.gcV.onResume();
        }
        if (LogoActivityConfig.isFirst && this.gdc >= 0) {
            com.baidu.tbadk.n.l.bEl().eu(System.currentTimeMillis() - this.gdc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gcX != null) {
            this.gcX.setParentView(null);
            this.gcX.a(null);
        }
        if (this.gda != null) {
            this.gda.release();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gcU);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gdf);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gdg);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gdh);
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.gdi);
        if (this.gcV != null) {
            this.gcV.onDestroy();
        }
        if (this.mBgBitmap != null && !this.mBgBitmap.isRecycled()) {
            this.mBgBitmap.recycle();
            this.mBgBitmap = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.s.c.dMz().B(getUniqueId());
        com.baidu.adp.lib.util.d.nH().clearCashBitmap();
    }

    private void fC(Context context) {
        bJV();
        if (LogoActivityConfig.mFromSpacial) {
            sQ(2);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.gcI) {
                com.baidu.adp.lib.f.e.mA().post(this.gdf);
            } else {
                sQ(2);
            }
        } else if (this.gcI) {
            com.baidu.adp.lib.f.e.mA().post(this.gdf);
        } else {
            bJW();
        }
    }

    private void bJV() {
        if (this.gcI) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bJW() {
        if (this.gcM != -2) {
            if (this.gcV == null) {
                this.gcV = new com.baidu.tieba.w.d(this);
            }
            if (this.gcV.dVQ()) {
                this.gcW = this.gcV.D(0.8125d);
                this.mRootView.addView(this.gcW);
                this.gcV.a(this.gdd);
                this.gcV.start();
                return;
            }
            this.gcV.dVU();
        }
        bJX();
    }

    private void bJX() {
        this.gcK = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.s.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.gda = (com.baidu.tbadk.s.a) runTask.getData();
            this.gda.a(this.gdb);
            this.gda.bEQ();
            com.baidu.tbadk.n.l.bEl().ev(System.currentTimeMillis() - this.gcK);
            int i = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.mA().postDelayed(this.gdi, i * 1000);
            return;
        }
        bJY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJY() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bKa();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        if (MessageManager.getInstance().findTask(2156676) == null && findTask == null) {
            bKa();
        } else if (findTask != null) {
            bJZ();
        } else {
            bKa();
        }
    }

    private void bJZ() {
        this.gcK = System.currentTimeMillis();
        this.gcL = System.currentTimeMillis();
        this.gcX = new com.baidu.tbadk.g.c();
        this.gcY = new BesAdViewContainer(getPageContext().getPageActivity());
        this.gcY.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bKc();
            }
        });
        this.gcY.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.gcY);
        this.gcX.setParentView(this.gcY);
        this.gcX.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tbadk.g.a
            public void zv(String str) {
                LogoActivity.this.gcZ = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.gcY);
                LogoActivity.this.bKa();
                com.baidu.tbadk.n.l.bEl().ew(System.currentTimeMillis() - LogoActivity.this.gcL);
            }

            @Override // com.baidu.tbadk.g.a
            public void e(boolean z, boolean z2, int i) {
                LogoActivity.this.gcZ = true;
                com.baidu.adp.lib.f.e.mA().removeCallbacks(LogoActivity.this.gdh);
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
                com.baidu.tieba.s.c.dMz().a(LogoActivity.this.getUniqueId(), "bes_ad_id", arVar);
                com.baidu.tieba.s.c.dMz().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.gcM == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.tbadk.n.l.bEl().ex(System.currentTimeMillis());
                com.baidu.tbadk.n.l.bEl().ew(System.currentTimeMillis() - LogoActivity.this.gcL);
            }

            @Override // com.baidu.tbadk.g.a
            public void onAdDismiss() {
                LogoActivity.this.gcO = true;
                if (LogoActivity.this.gcP) {
                    LogoActivity.this.bKc();
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
                com.baidu.tieba.s.c.dMz().b(LogoActivity.this.getUniqueId(), arVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.gcX));
        com.baidu.tbadk.n.l.bEl().ev(System.currentTimeMillis() - this.gcK);
        int i = com.baidu.tbadk.core.sharedPref.b.brQ().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mA().postDelayed(this.gdh, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKa() {
        if (this.gcM == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.mA().post(this.gdg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKb() {
        if (this.gcM >= 0) {
            sR(this.gcM);
        } else if (this.gcM == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKc() {
        bKb();
        com.baidu.tbadk.n.l.bEl().ey(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bKd() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            o.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKe() {
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
        this.gcM = i;
        bJW();
    }

    private void sR(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKf() {
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
        this.gcQ = new com.baidu.tbadk.core.dialog.a(this);
        this.gcQ.bn(inflate);
        this.gcQ.nA(7);
        this.gcQ.jG(false);
        this.gcQ.setAutoNight(false);
        this.gcQ.jF(false);
        com.baidu.tbadk.core.elementsMaven.c.br(textView2).og(R.string.J_X01).setBackGroundColor(R.color.CAM_X0303);
        ap.a((View) textView2, R.color.CAM_X0101, R.color.CAM_X0618, 0);
        ap.a((View) textView3, R.color.CAM_X0110, R.color.CAM_X0110, 0);
        textView2.setOnClickListener(this.fhT);
        textView3.setOnClickListener(this.fhT);
        this.gcQ.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKg() {
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
        this.gcR = new com.baidu.tbadk.core.dialog.a(this);
        this.gcR.bn(inflate);
        this.gcR.nA(3);
        this.gcR.jG(false);
        this.gcR.setAutoNight(false);
        this.gcR.jF(false);
        this.gcR.b(getPageContext());
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
            bKf();
            this.gcQ.bqx();
            this.gcT--;
            f.Eq("1");
            TiebaStatic.log(new ar("c13294"));
        } else if (!bKi() && !ae.checkLocationForGoogle(getActivity())) {
            bKj();
        } else {
            if (ae.checkLocationForGoogle(getActivity())) {
                com.baidu.adp.lib.c.a.lH().getAddress(false);
            }
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            if (bJS()) {
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                try {
                    setContentView(R.layout.logo_activity);
                    this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                    LogoActivityConfig.isFirst = true;
                    registerListener(this.gde);
                    this.gcM = -2;
                    bJX();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                } catch (Throwable th) {
                    BdLog.e(th);
                    finish();
                }
            } else if (!isTaskRoot() && !bJR()) {
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
                this.gcI = TbadkCoreApplication.getInst().getIsFirstUse();
                com.baidu.tbadk.n.l.bEl().lo(this.gcI);
                registerListener(this.gde);
                bJT();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("type", "start");
                hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
                hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                    bJU();
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
    public void bKh() {
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
        this.gcS = new com.baidu.tbadk.core.dialog.a(this);
        this.gcS.bn(inflate);
        this.gcS.nA(3);
        this.gcS.jG(false);
        this.gcS.setAutoNight(false);
        this.gcS.jF(false);
        this.gcS.b(getPageContext());
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
            bJQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKi() {
        return au.equals(TbConfig.getVersion(), com.baidu.tbadk.core.sharedPref.b.brQ().getString("key_location_request_dialog_last_show_version", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKj() {
        com.baidu.tbadk.core.sharedPref.b.brQ().putString("key_location_request_dialog_last_show_version", TbConfig.getVersion());
        ae.a(getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.7
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
            public void onClose() {
                LogoActivity.this.bJQ();
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
            LogoActivity.this.bKc();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a064";
    }
}
