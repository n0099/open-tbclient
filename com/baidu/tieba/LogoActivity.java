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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.n.m;
import com.baidu.tbadk.switchs.AdSdkSwitch;
import com.baidu.tieba.view.BesAdViewContainer;
import com.baidu.tieba.x.d;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    private static final String DOWNLOAD_DIR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    private com.baidu.tieba.x.d fVC;
    private View fVD;
    private com.baidu.tbadk.g.e fVE;
    private BesAdViewContainer fVF;
    private com.baidu.tbadk.g.d fVH;
    private com.baidu.tbadk.s.a fVI;
    private boolean fVu;
    private com.baidu.tbadk.core.dialog.a fVx;
    private com.baidu.tbadk.core.dialog.a fVy;
    private com.baidu.tbadk.core.dialog.a fVz;
    private RelativeLayout mRootView;
    private Bitmap fVo = null;
    private boolean fVp = false;
    private boolean fVq = true;
    private long fVr = -1;
    private long fVs = -1;
    private int fVt = -1;
    private boolean fVv = false;
    private boolean fVw = true;
    private int fVA = 2;
    private a fVB = new a();
    private boolean fVG = false;
    private com.baidu.tbadk.s.b fVJ = new com.baidu.tbadk.s.b() { // from class: com.baidu.tieba.LogoActivity.1
        @Override // com.baidu.tbadk.s.b
        public void aeJ() {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fVQ);
            LogoActivity.this.bKY();
        }

        @Override // com.baidu.tbadk.s.b
        public void g(String str, boolean z, boolean z2) {
            com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fVQ);
            if (LogoActivity.this.fVI.getView() == null) {
                LogoActivity.this.bLd();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(LogoActivity.this.getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                equipmentHeight = (int) (l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.fVI.getView().setLayoutParams(new RelativeLayout.LayoutParams(equipmentWidth, equipmentHeight));
            LogoActivity.this.mRootView.addView(LogoActivity.this.fVI.getView());
            if (LogoActivity.this.fVt == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
            }
            m.bFp().er(System.currentTimeMillis());
            TiebaStatic.log(new ar("c13331").dY("obj_id", str).al("obj_type", z2 ? 2 : 1));
            ar arVar = new ar("common_exp");
            arVar.dY("page_type", "a030").al("obj_isad", 1).dY("obj_id", str).al("obj_floor", 1).al("obj_source", 2).al("obj_adlocate", 16);
            if (z) {
                arVar.al("obj_type", z2 ? 4 : 3);
            } else {
                arVar.al("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.t.c.dOf().a(LogoActivity.this.getUniqueId(), str, arVar);
            com.baidu.tieba.t.c.dOf().b(LogoActivity.this.getUniqueId(), false);
        }

        @Override // com.baidu.tbadk.s.b
        public void blp() {
            LogoActivity.this.fVv = true;
            if (LogoActivity.this.fVw) {
                LogoActivity.this.bLd();
            }
        }

        @Override // com.baidu.tbadk.s.b
        public void az(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.fVI.getView() != null) {
                z2 = LogoActivity.this.fVI.getView().getHeight() == l.getEquipmentHeight(LogoActivity.this.getPageContext().getPageActivity());
            } else {
                z2 = false;
            }
            TiebaStatic.log(new ar("c13332").dY("obj_id", str).al("obj_type", z2 ? 2 : 1));
            ar arVar = new ar("common_click");
            arVar.dY("page_type", "a030").al("obj_isad", 1).dY("obj_id", str).al("obj_floor", 1).al("obj_source", 2).al("obj_adlocate", 16);
            if (z) {
                arVar.al("obj_type", z2 ? 4 : 3);
            } else {
                arVar.al("obj_type", z2 ? 2 : 1);
            }
            com.baidu.tieba.t.c.dOf().b(LogoActivity.this.getUniqueId(), arVar);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.bLd();
        }
    };
    private long fVK = -1;
    private d.a fVL = new d.a() { // from class: com.baidu.tieba.LogoActivity.9
        @Override // com.baidu.tieba.x.d.a
        public void onError() {
            LogoActivity.this.bLb();
        }

        @Override // com.baidu.tieba.x.d.a
        public void aeL() {
            if (LogoActivity.this.fVt != -2) {
                LogoActivity.this.bLc();
            } else {
                LogoActivity.this.finish();
            }
        }
    };
    private CustomMessageListener fVM = new CustomMessageListener(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK) { // from class: com.baidu.tieba.LogoActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (LogoActivity.this.bKS()) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SPLASH_AD_JUMP_URL, str));
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra(BigdayActivityConfig.JUMP_URL, str);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        }
                    }
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fVB);
                    LogoActivity.this.fVv = true;
                    if (LogoActivity.this.fVw) {
                        LogoActivity.this.bLd();
                    }
                }
            }
        }
    };
    private Runnable fVN = new Runnable() { // from class: com.baidu.tieba.LogoActivity.11
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bKQ();
        }
    };
    private Runnable fVO = new Runnable() { // from class: com.baidu.tieba.LogoActivity.12
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bLd();
        }
    };
    private Runnable fVP = new Runnable() { // from class: com.baidu.tieba.LogoActivity.13
        @Override // java.lang.Runnable
        public void run() {
            if (!LogoActivity.this.fVG && LogoActivity.this.fVF != null) {
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fVF);
                com.baidu.adp.lib.f.e.mY().post(LogoActivity.this.fVO);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    };
    private Runnable fVQ = new Runnable() { // from class: com.baidu.tieba.LogoActivity.14
        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.bLb();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    };
    View.OnClickListener faK = new View.OnClickListener() { // from class: com.baidu.tieba.LogoActivity.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes || id == R.id.final_private_yes) {
                if (LogoActivity.this.fVx != null && LogoActivity.this.fVx.isShowing()) {
                    LogoActivity.this.fVx.dismiss();
                }
                if (LogoActivity.this.fVz != null && LogoActivity.this.fVz.isShowing()) {
                    LogoActivity.this.fVz.dismiss();
                }
                ae.jr(true);
                com.baidu.tbadk.core.sharedPref.b.bsO().putLong("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.bLj() || ae.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.bKQ();
                    ar arVar = new ar("c13295");
                    arVar.dY("obj_locate", "1");
                    TiebaStatic.log(arVar);
                    return;
                }
                LogoActivity.this.bLk();
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.fVx.isShowing()) {
                    LogoActivity.this.fVx.dismiss();
                }
                ar arVar2 = new ar("c13295");
                arVar2.dY("obj_locate", "2");
                TiebaStatic.log(arVar2);
                if (LogoActivity.this.fVy == null) {
                    LogoActivity.this.bLh();
                }
                LogoActivity.this.fVy.brv();
            } else if (id == R.id.private_close_btn) {
                if (LogoActivity.this.fVy.isShowing()) {
                    LogoActivity.this.fVy.dismiss();
                }
                if (LogoActivity.this.fVA > 0) {
                    if (LogoActivity.this.fVx == null) {
                        LogoActivity.this.bLg();
                    }
                    LogoActivity.this.fVx.brv();
                    LogoActivity.y(LogoActivity.this);
                    return;
                }
                if (LogoActivity.this.fVz == null) {
                    LogoActivity.this.bLi();
                }
                LogoActivity.this.fVz.brv();
            } else if (id == R.id.final_private_no) {
                if (LogoActivity.this.fVz.isShowing()) {
                    LogoActivity.this.fVz.dismiss();
                }
                LogoActivity.this.finish();
            }
        }
    };
    private ClickableSpan fVR = new ClickableSpan() { // from class: com.baidu.tieba.LogoActivity.7
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
        int i = logoActivity.fVA;
        logoActivity.fVA = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKQ() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.fVu = true;
            return;
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.START_GUILD) != null) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GUILD, new GuildActivityConfig(getPageContext().getPageActivity()).createNormalCfg(GuildActivityConfig.FROM_LOGO_PAGE, 1)));
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        com.baidu.adp.lib.f.h.mZ().submitTask(new Runnable() { // from class: com.baidu.tieba.LogoActivity.15
            @Override // java.lang.Runnable
            public void run() {
                LogoActivity.this.bLf();
                LogoActivity.bLe();
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
        this.fVK = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        com.baidu.tieba.t.c.dOf().z(getUniqueId());
        init(bundle);
    }

    private boolean bKR() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new ar("c11897").dY("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bKS() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private void bKT() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath("baidu_tieba.db").exists()) {
                com.baidu.tbadk.core.d.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.b.blZ(), getPageContext().getPageActivity());
            }
        }
        fl(getPageContext().getPageActivity());
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
        if (this.fVI != null && this.fVI.getView() != null && this.fVI.getView().getParent() != null) {
            if (this.fVI.getView() != null) {
                if (this.fVI.getView().getHeight() == l.getEquipmentHeight(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int equipmentWidth = l.getEquipmentWidth(getPageContext().getPageActivity());
            int equipmentHeight = l.getEquipmentHeight(getPageContext().getPageActivity());
            if (!z) {
                equipmentHeight = (int) (l.getEquipmentHeight(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fVI.getView().getLayoutParams();
            layoutParams.width = equipmentWidth;
            layoutParams.height = equipmentHeight;
            this.fVI.getView().setLayoutParams(layoutParams);
        }
        if (this.fVE != null && this.fVE.eAj != null) {
            this.fVE.eAj.blq();
        }
    }

    private void bKU() {
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
        this.fVw = false;
        if (this.fVC != null) {
            this.fVC.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fVw = true;
        if (this.fVq) {
            this.fVq = false;
            MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_APPLIST);
            MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_APPLIST));
            if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.bsO().getLong(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS_TIMESTAMP, 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(com.baidu.tbadk.core.sharedPref.b.bsO().getString(SharedPrefConfig.APPLIST_INSTALLED_APK_IDS, ""));
            }
        }
        if (ae.btD()) {
            NASLib.onAppStart(getActivity());
        }
        if (this.fVv) {
            bLd();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.fVu) {
            bKQ();
            this.fVu = false;
        }
        if (this.fVC != null) {
            this.fVC.onResume();
        }
        if (LogoActivityConfig.isFirst && this.fVK >= 0) {
            m.bFp().eo(System.currentTimeMillis() - this.fVK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fVE != null) {
            this.fVE.setParentView(null);
            this.fVE.a(null);
        }
        if (this.fVH != null) {
            this.fVH.setParentView(null);
            this.fVH.a(null);
        }
        if (this.fVI != null) {
            this.fVI.release();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fVB);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fVN);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fVO);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fVP);
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.fVQ);
        if (this.fVC != null) {
            this.fVC.onDestroy();
        }
        if (this.fVo != null && !this.fVo.isRecycled()) {
            this.fVo.recycle();
            this.fVo = null;
        }
        if (this.mRootView != null) {
            this.mRootView.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        com.baidu.tieba.t.c.dOf().A(getUniqueId());
        com.baidu.adp.lib.util.d.oh().clearCashBitmap();
    }

    private void fl(Context context) {
        bKV();
        if (LogoActivityConfig.mFromSpacial) {
            uf(2);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.fVp) {
                com.baidu.adp.lib.f.e.mY().post(this.fVN);
            } else {
                uf(2);
            }
        } else if (this.fVp) {
            com.baidu.adp.lib.f.e.mY().post(this.fVN);
        } else {
            bKW();
        }
    }

    private void bKV() {
        if (this.fVp) {
            TbadkSettings.getInst().saveBoolean(SharedPrefConfig.FIRST_SYNC_IMAGE_QUALITY, true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean(SharedPrefConfig.FRS_FIRST_IN, true);
        }
    }

    private void bKW() {
        if (this.fVt != -2) {
            if (this.fVC == null) {
                this.fVC = new com.baidu.tieba.x.d(this);
            }
            if (this.fVC.dXK()) {
                this.fVD = this.fVC.K(0.8125d);
                this.mRootView.addView(this.fVD);
                this.fVC.a(this.fVL);
                this.fVC.start();
                return;
            }
            this.fVC.dXO();
        }
        bKX();
    }

    private void bKX() {
        this.fVr = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, com.baidu.tbadk.s.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            this.fVI = (com.baidu.tbadk.s.a) runTask.getData();
            this.fVI.a(this.fVJ);
            this.fVI.bFU();
            m.bFp().ep(System.currentTimeMillis() - this.fVr);
            int i = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("video_splash_timeout", 1);
            if (i <= 0) {
                i = 1;
            }
            com.baidu.adp.lib.f.e.mY().postDelayed(this.fVQ, i * 1000);
            return;
        }
        bKY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKY() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            bLb();
            return;
        }
        MessageTask findTask = MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD);
        MessageTask findTask2 = MessageManager.getInstance().findTask(2156676);
        if (findTask2 == null && findTask == null) {
            bLb();
            return;
        }
        boolean An = com.baidu.tbadk.a.b.An("ad_xuzhang_splash_sdk");
        if (findTask2 != null && An) {
            bKZ();
        } else if (findTask != null) {
            bLa();
        } else {
            bLb();
        }
    }

    private void bKZ() {
        this.fVr = System.currentTimeMillis();
        this.fVs = System.currentTimeMillis();
        this.fVH = new com.baidu.tbadk.g.d();
        this.fVF = new BesAdViewContainer(getPageContext().getPageActivity());
        this.fVF.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.2
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bLd();
            }
        });
        this.fVF.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.fVF);
        this.fVH.setParentView(this.fVF);
        this.fVH.a(new com.baidu.tbadk.g.c() { // from class: com.baidu.tieba.LogoActivity.3
            @Override // com.baidu.tbadk.g.c
            public void Aq(String str) {
                LogoActivity.this.fVG = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fVF);
                LogoActivity.this.bLb();
                m.bFp().eq(System.currentTimeMillis() - LogoActivity.this.fVs);
            }

            @Override // com.baidu.tbadk.g.c
            public void blr() {
                LogoActivity.this.fVG = true;
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
                if (LogoActivity.this.fVt == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fVP);
                m.bFp().er(System.currentTimeMillis());
                m.bFp().eq(System.currentTimeMillis() - LogoActivity.this.fVs);
            }

            @Override // com.baidu.tbadk.g.c
            public void blp() {
                LogoActivity.this.fVv = true;
                if (LogoActivity.this.fVw) {
                    LogoActivity.this.bLd();
                }
            }

            @Override // com.baidu.tbadk.g.c
            public void onAdClick() {
                LogoActivity.this.overridePendingTransition(0, 0);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage(2156676, this.fVH));
        m.bFp().ep(System.currentTimeMillis() - this.fVr);
        int i = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.fVP, (i > 0 ? i : 1) * 1000);
    }

    private void bLa() {
        this.fVr = System.currentTimeMillis();
        this.fVs = System.currentTimeMillis();
        this.fVE = new com.baidu.tbadk.g.e();
        this.fVF = new BesAdViewContainer(getPageContext().getPageActivity());
        this.fVF.setListener(new BesAdViewContainer.a() { // from class: com.baidu.tieba.LogoActivity.4
            @Override // com.baidu.tieba.view.BesAdViewContainer.a
            public void a(BesAdViewContainer besAdViewContainer) {
                LogoActivity.this.bLd();
            }
        });
        this.fVF.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.fVF);
        this.fVE.setParentView(this.fVF);
        this.fVE.a(new com.baidu.tbadk.g.a() { // from class: com.baidu.tieba.LogoActivity.5
            @Override // com.baidu.tbadk.g.a
            public void Aq(String str) {
                LogoActivity.this.fVG = true;
                LogoActivity.this.mRootView.removeView(LogoActivity.this.fVF);
                LogoActivity.this.bLb();
                m.bFp().eq(System.currentTimeMillis() - LogoActivity.this.fVs);
            }

            @Override // com.baidu.tbadk.g.a
            public void v(boolean z, boolean z2) {
                LogoActivity.this.fVG = true;
                if (z2) {
                    LogoActivity.this.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new ar(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).al("obj_type", z2 ? 2 : 1));
                ar arVar = new ar("common_exp");
                arVar.dY("page_type", "a030").al("obj_isad", 1).al("obj_floor", 1).al("obj_source", 1).al("obj_adlocate", 16);
                if (z) {
                    arVar.al("obj_type", z2 ? 4 : 3);
                } else {
                    arVar.al("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.t.c.dOf().a(LogoActivity.this.getUniqueId(), "bes_ad_id", arVar);
                com.baidu.tieba.t.c.dOf().b(LogoActivity.this.getUniqueId(), false);
                if (LogoActivity.this.fVt == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOT_SPLASH_SHOW, LogoActivity.this));
                }
                com.baidu.adp.lib.f.e.mY().removeCallbacks(LogoActivity.this.fVP);
                m.bFp().er(System.currentTimeMillis());
                m.bFp().eq(System.currentTimeMillis() - LogoActivity.this.fVs);
            }

            @Override // com.baidu.tbadk.g.a
            public void blp() {
                LogoActivity.this.fVv = true;
                if (LogoActivity.this.fVw) {
                    LogoActivity.this.bLd();
                }
            }

            @Override // com.baidu.tbadk.g.a
            public void w(boolean z, boolean z2) {
                LogoActivity.this.overridePendingTransition(0, 0);
                TiebaStatic.log(new ar(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).al("obj_type", z2 ? 2 : 1));
                ar arVar = new ar("common_click");
                arVar.dY("page_type", "a030").al("obj_isad", 1).al("obj_floor", 1).al("obj_source", 1).al("obj_adlocate", 16);
                if (z) {
                    arVar.al("obj_type", z2 ? 4 : 3);
                } else {
                    arVar.al("obj_type", z2 ? 2 : 1);
                }
                com.baidu.tieba.t.c.dOf().b(LogoActivity.this.getUniqueId(), arVar);
            }
        });
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_REQUEST_BES_AD, this.fVE));
        m.bFp().ep(System.currentTimeMillis() - this.fVr);
        int i = com.baidu.tbadk.core.sharedPref.b.bsO().getInt("video_splash_timeout", 1);
        com.baidu.adp.lib.f.e.mY().postDelayed(this.fVP, (i > 0 ? i : 1) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLb() {
        if (this.fVt == -2) {
            finish();
        } else {
            com.baidu.adp.lib.f.e.mY().post(this.fVO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLc() {
        if (this.fVt >= 0) {
            ug(this.fVt);
        } else if (this.fVt == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLd() {
        bLc();
        m.bFp().es(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bLe() {
        String str = DOWNLOAD_DIR + "bdtbWCache";
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            n.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLf() {
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

    private void uf(int i) {
        this.fVt = i;
        bKW();
    }

    private void ug(int i) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i)));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLg() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(this.fVR, 111, 117, 33);
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.CAM_X0302)), 111, 117, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        this.fVx = new com.baidu.tbadk.core.dialog.a(this);
        this.fVx.bi(inflate);
        this.fVx.oT(3);
        this.fVx.jm(false);
        this.fVx.setAutoNight(false);
        this.fVx.jl(false);
        ap.a((View) textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        ap.a((View) textView3, R.color.CAM_X0105, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.faK);
        textView3.setOnClickListener(this.faK);
        this.fVx.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLh() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        ap.a((View) textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.faK);
        this.fVy = new com.baidu.tbadk.core.dialog.a(this);
        this.fVy.bi(inflate);
        this.fVy.oT(3);
        this.fVy.jm(false);
        this.fVy.setAutoNight(false);
        this.fVy.jl(false);
        this.fVy.b(getPageContext());
    }

    private void init(Bundle bundle) {
        if (!ae.btD()) {
            bLg();
            this.fVx.brv();
            this.fVA--;
            TiebaStatic.log(new ar("c13294"));
        } else if (!bLj() && !ae.checkLocationForGoogle(getActivity())) {
            bLk();
        } else {
            if (ae.checkLocationForGoogle(getActivity())) {
                com.baidu.adp.lib.c.a.mk().getAddress(false);
            }
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            if (bKS()) {
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PERSON_POLYMERIC_CHECK_FEEDBACK_RED_TIP));
                try {
                    setContentView(R.layout.logo_activity);
                    this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                    LogoActivityConfig.isFirst = true;
                    registerListener(this.fVM);
                    this.fVt = -2;
                    bKX();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                } catch (Throwable th) {
                    BdLog.e(th);
                    finish();
                }
            } else if (!isTaskRoot() && !bKR()) {
                finish();
            } else {
                TiebaStatic.log(new ar(TbadkCoreStatisticKey.HOST_START).al("obj_param1", 2));
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
                this.fVp = TbadkCoreApplication.getInst().getIsFirstUse();
                m.bFp().kT(this.fVp);
                registerListener(this.fVM);
                bKT();
                this.mHandler.sendMessage(this.mHandler.obtainMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("type", "start");
                hashMap.put(BdStatsConstant.StatsKey.UNAME, TbadkCoreApplication.getCurrentAccountName());
                hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.TIEBA_FATAL_ERROR, hashMap));
                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_DEBUG_TOOL_START) != null) {
                    bKU();
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
    public void bLi() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.final_private_dialog, (ViewGroup) null);
        inflate.findViewById(R.id.final_private_button_layout).setVisibility(0);
        TextView textView = (TextView) inflate.findViewById(R.id.final_scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.final_private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.final_private_no);
        ap.a((View) textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        ap.a((View) textView3, R.color.CAM_X0105, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.faK);
        textView3.setOnClickListener(this.faK);
        this.fVz = new com.baidu.tbadk.core.dialog.a(this);
        this.fVz.bi(inflate);
        this.fVz.oT(3);
        this.fVz.jm(false);
        this.fVz.setAutoNight(false);
        this.fVz.jl(false);
        this.fVz.b(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_GUIDE_VIEW /* 16001 */:
                    if (intent == null) {
                        uf(2);
                        return;
                    }
                    int intExtra = intent.getIntExtra("go_to", -1);
                    if (intExtra >= 0) {
                        uf(intExtra);
                        return;
                    } else {
                        uf(2);
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
            com.baidu.adp.lib.c.a.mk().getAddress(false);
            bKQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bLj() {
        return au.equals(TbConfig.getVersion(), com.baidu.tbadk.core.sharedPref.b.bsO().getString("key_location_request_dialog_last_show_version", ""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLk() {
        com.baidu.tbadk.core.sharedPref.b.bsO().putString("key_location_request_dialog_last_show_version", TbConfig.getVersion());
        ae.a(getActivity(), RequestResponseCode.REQUEST_SETTING_LOCATION_SOURCE, new PermissionJudgePolicy.a() { // from class: com.baidu.tieba.LogoActivity.8
            @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.a
            public void onClose() {
                LogoActivity.this.bKQ();
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
            LogoActivity.this.bLd();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a064";
    }
}
