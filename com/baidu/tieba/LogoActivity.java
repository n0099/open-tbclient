package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.NASLib;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.AdSdkSwitch;
import d.a.o0.u3.d;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes4.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    public static final String DOWNLOAD_DIR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    public static final double FOOT_HEIGHT_RATIO = 0.1875d;
    public static final long ONE_DAY = 86400000;
    public static final int PRIVACY_POLICY_GUIDE_DIALOG_CLICK_TIMES = 2;
    public static final String QUICK_WEB_VIEW_DIR_NAME = "bdtbWCache";
    public static final int RESUME_SPLASH = -2;
    public d.a.n0.k.d besAdData;
    public ViewGroup besSplashHolder;
    public d.a.n0.r.s.a mPrivacyPolicyDialogGuideOne;
    public d.a.n0.r.s.a mPrivacyPolicyDialogGuideTwo;
    public d.a.n0.r.s.a mPrivacyPolicyDialogRemind;
    public RelativeLayout mRootView;
    public d.a.n0.w0.a mTbAdController;
    public d.a.o0.u3.d mVideoSplashController;
    public View mVideoSplashView;
    public boolean needGoNext;
    public Bitmap mBgBitmap = null;
    public boolean mIsFirstUse = false;
    public boolean mIsFirstOnResume = true;
    public long adCreateStartTime = -1;
    public long adReqeustStartTime = -1;
    public int mGoto = -1;
    public boolean isAdDismiss = false;
    public boolean isActivityInForeground = true;
    public int mPrivacyPolicyDialogGuideClickTimes = 0;
    public int mAdSource = 0;
    public long mShowAdInternal = 0;
    public o mShowADEndRunnable = new o(this, null);
    public boolean hasLoadBesFinish = false;
    public d.a.n0.w0.b mTbAdCallback = new f();
    public long logoCreateTime = -1;
    public d.g mVideoSplashCallback = new g();
    public CustomMessageListener splashClickListener = new h(2016311);
    public Runnable mFirstLogoAniRunnable = new i();
    public Runnable mNormalLogoAniRunnable = new j();
    public Runnable mRequirTimeOutRunnable = new k();
    public Runnable mTimeOutRunnable = new l();
    public Runnable mTbTimeOutRunnable = new m();
    public View.OnClickListener mListener = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.private_yes || id == R.id.yesBtn) {
                if (LogoActivity.this.mPrivacyPolicyDialogRemind != null && LogoActivity.this.mPrivacyPolicyDialogRemind.isShowing()) {
                    LogoActivity.this.mPrivacyPolicyDialogRemind.dismiss();
                    d.a.o0.g.a("1", "1");
                }
                if (LogoActivity.this.mPrivacyPolicyDialogGuideOne != null && LogoActivity.this.mPrivacyPolicyDialogGuideOne.isShowing()) {
                    LogoActivity.this.mPrivacyPolicyDialogGuideOne.dismiss();
                    d.a.o0.g.a("2", "1");
                }
                if (LogoActivity.this.mPrivacyPolicyDialogGuideTwo != null && LogoActivity.this.mPrivacyPolicyDialogGuideTwo.isShowing()) {
                    LogoActivity.this.mPrivacyPolicyDialogGuideTwo.dismiss();
                    d.a.o0.g.a("3", "1");
                }
                PermissionUtil.setIsAgreePrivacyPolicy(true);
                d.a.n0.r.d0.b.j().w("key_first_enter_app_timestamp", System.currentTimeMillis());
                if (LogoActivity.this.isLocationRequestDialogShow() || PermissionUtil.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                    LogoActivity.this.goToNextPage();
                } else {
                    LogoActivity.this.showLocationRequestDialog();
                }
            } else if (id == R.id.private_no) {
                if (LogoActivity.this.mPrivacyPolicyDialogRemind.isShowing()) {
                    LogoActivity.this.mPrivacyPolicyDialogRemind.dismiss();
                    d.a.o0.g.a("1", "2");
                }
                if (LogoActivity.this.mPrivacyPolicyDialogGuideOne == null) {
                    LogoActivity logoActivity = LogoActivity.this;
                    logoActivity.mPrivacyPolicyDialogGuideOne = d.a.o0.j.a(logoActivity.getPageContext(), LogoActivity.this.mListener, R.string.privacy_policy_guide_one, R.string.secret_hint_no_agree);
                }
                LogoActivity.this.mPrivacyPolicyDialogGuideOne.show();
                d.a.o0.g.b("2");
            } else if (id == R.id.browseBtn) {
                LogoActivity.access$2708(LogoActivity.this);
                if (LogoActivity.this.mPrivacyPolicyDialogGuideOne.isShowing()) {
                    LogoActivity.this.mPrivacyPolicyDialogGuideOne.dismiss();
                    d.a.o0.g.a("2", "2");
                    if (LogoActivity.this.mPrivacyPolicyDialogGuideTwo == null) {
                        LogoActivity logoActivity2 = LogoActivity.this;
                        logoActivity2.mPrivacyPolicyDialogGuideTwo = d.a.o0.j.a(logoActivity2.getPageContext(), LogoActivity.this.mListener, R.string.privacy_policy_guide_two, R.string.secret_hint_browser_exit);
                        LogoActivity.this.mPrivacyPolicyDialogGuideTwo.show();
                        d.a.o0.g.b("3");
                    }
                }
                if (LogoActivity.this.mPrivacyPolicyDialogGuideTwo.isShowing() && LogoActivity.this.mPrivacyPolicyDialogGuideClickTimes == 2) {
                    LogoActivity.this.mPrivacyPolicyDialogGuideTwo.dismiss();
                    d.a.o0.g.a("3", "2");
                    LogoActivity.this.finish();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.n0.k.a {
        public b() {
        }

        @Override // d.a.n0.k.a
        public void a(String str) {
            LogoActivity.this.hasLoadBesFinish = true;
            LogoActivity.this.mRootView.removeView(LogoActivity.this.besSplashHolder);
            LogoActivity.this.showNormalAniView();
            d.a.n0.m0.l.b().k(System.currentTimeMillis() - LogoActivity.this.adReqeustStartTime);
        }

        @Override // d.a.n0.k.a
        public void b(boolean z, boolean z2, int i2) {
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.isAdDismiss = true;
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).param("obj_type", z2 ? 2 : 1).param("obj_source", i2));
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", i2).param("obj_type", "a030").param("obj_locate", 0).eventStat();
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (z) {
                statisticItem.param("obj_type", z2 ? 4 : 3);
            } else {
                statisticItem.param("obj_type", z2 ? 2 : 1);
            }
            d.a.o0.d3.c.g().c(LogoActivity.this.getUniqueId(), statisticItem);
        }

        @Override // d.a.n0.k.a
        public void c(boolean z, boolean z2, int i2) {
            LogoActivity.this.hasLoadBesFinish = true;
            LogoActivity.this.mAdSource = i2;
            if (LogoActivity.this.mShowAdInternal > 0) {
                d.a.n0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "internal", Long.valueOf(System.currentTimeMillis() - LogoActivity.this.mShowAdInternal));
            }
            d.a.c.e.m.e.a().removeCallbacks(LogoActivity.this.mRequirTimeOutRunnable);
            d.a.c.e.m.e.a().removeCallbacks(LogoActivity.this.mTimeOutRunnable);
            if (z2) {
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).param("obj_type", z2 ? 2 : 1).param("obj_source", i2));
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (z) {
                statisticItem.param("obj_type", z2 ? 4 : 3);
            } else {
                statisticItem.param("obj_type", z2 ? 2 : 1);
            }
            d.a.o0.d3.c.g().d(LogoActivity.this.getUniqueId(), "bes_ad_id", statisticItem);
            d.a.o0.d3.c.g().h(LogoActivity.this.getUniqueId(), false);
            if (LogoActivity.this.mGoto == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
            }
            d.a.n0.m0.l.b().m(System.currentTimeMillis());
            d.a.n0.m0.l.b().k(System.currentTimeMillis() - LogoActivity.this.adReqeustStartTime);
        }

        @Override // d.a.n0.k.a
        public void onAdDismiss() {
            LogoActivity.this.isAdDismiss = true;
            if (LogoActivity.this.isActivityInForeground) {
                LogoActivity.this.showADEnd();
            }
        }

        @Override // d.a.n0.k.a
        public void onLpClosed() {
        }
    }

    /* loaded from: classes4.dex */
    public class c implements FileFilter {
        public c() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            return !TextUtils.isEmpty(name) && name.contains(LogoActivity.this.getPageContext().getString(R.string.app_name)) && name.endsWith(".apk");
        }
    }

    /* loaded from: classes4.dex */
    public class d implements PermissionJudgePolicy.IExtraDialogCloseCallback {
        public d() {
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.IExtraDialogCloseCallback
        public void onClose() {
            LogoActivity.this.goToNextPage();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements PermissionJudgePolicy.ISystemPermissionDialogShowCallBack {
        public e() {
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.ISystemPermissionDialogShowCallBack
        public void onShow() {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCATION_PERMISSION_SHOW);
            statisticItem.param("obj_type", 2);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.n0.w0.b {
        public f() {
        }

        @Override // d.a.n0.w0.b
        public void a() {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_type", "a064").param(TiebaStatic.Params.RESOURCE_ID, 0).param("obj_locate", 1));
            d.a.c.e.m.e.a().removeCallbacks(LogoActivity.this.mTbTimeOutRunnable);
            LogoActivity.this.showADView();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0099  */
        @Override // d.a.n0.w0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.mTbAdController.getView() != null) {
                if (LogoActivity.this.mTbAdController.getView().getHeight() == d.a.c.e.p.l.i(LogoActivity.this.getPageContext().getPageActivity())) {
                    z2 = true;
                    TiebaStatic.log(new StatisticItem("c13332").param("obj_id", str).param("obj_type", !z2 ? 2 : 1));
                    StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 2).param("obj_type", "a030").param("obj_locate", 0).eventStat();
                    StatisticItem statisticItem = new StatisticItem("common_click");
                    statisticItem.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param("obj_id", str).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", 2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
                    if (!z) {
                        statisticItem.param("obj_type", z2 ? 4 : 3);
                    } else {
                        statisticItem.param("obj_type", z2 ? 2 : 1);
                    }
                    d.a.o0.d3.c.g().c(LogoActivity.this.getUniqueId(), statisticItem);
                    LogoActivity.this.overridePendingTransition(0, 0);
                    LogoActivity.this.showADEnd();
                }
            }
            z2 = false;
            TiebaStatic.log(new StatisticItem("c13332").param("obj_id", str).param("obj_type", !z2 ? 2 : 1));
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 2).param("obj_type", "a030").param("obj_locate", 0).eventStat();
            StatisticItem statisticItem2 = new StatisticItem("common_click");
            statisticItem2.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param("obj_id", str).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", 2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (!z) {
            }
            d.a.o0.d3.c.g().c(LogoActivity.this.getUniqueId(), statisticItem2);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.showADEnd();
        }

        @Override // d.a.n0.w0.b
        public void c(String str, boolean z, boolean z2) {
            d.a.c.e.m.e.a().removeCallbacks(LogoActivity.this.mTbTimeOutRunnable);
            if (LogoActivity.this.mTbAdController.getView() == null) {
                LogoActivity.this.showADEnd();
                return;
            }
            int k = d.a.c.e.p.l.k(LogoActivity.this.getPageContext().getPageActivity());
            int i2 = d.a.c.e.p.l.i(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                i2 = (int) (d.a.c.e.p.l.i(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.mTbAdController.getView().setLayoutParams(new RelativeLayout.LayoutParams(k, i2));
            LogoActivity.this.mRootView.addView(LogoActivity.this.mTbAdController.getView());
            if (LogoActivity.this.mGoto == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
            }
            d.a.n0.m0.l.b().m(System.currentTimeMillis());
            TiebaStatic.log(new StatisticItem("c13331").param("obj_id", str).param("obj_type", z2 ? 2 : 1));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_type", "a064").param("obj_locate", 0));
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 2).param("obj_type", "a064").param("obj_locate", 0));
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param("obj_id", str).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", 2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (z) {
                statisticItem.param("obj_type", z2 ? 4 : 3);
            } else {
                statisticItem.param("obj_type", z2 ? 2 : 1);
            }
            d.a.o0.d3.c.g().d(LogoActivity.this.getUniqueId(), str, statisticItem);
            d.a.o0.d3.c.g().h(LogoActivity.this.getUniqueId(), false);
        }

        @Override // d.a.n0.w0.b
        public void onAdDismiss() {
            LogoActivity.this.isAdDismiss = true;
            if (LogoActivity.this.isActivityInForeground) {
                LogoActivity.this.showADEnd();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements d.g {
        public g() {
        }

        @Override // d.a.o0.u3.d.g
        public void onError() {
            LogoActivity.this.showNormalAniView();
        }

        @Override // d.a.o0.u3.d.g
        public void onSkip() {
            boolean z = false;
            if (LogoActivity.this.mTbAdController.getView() != null) {
                if (LogoActivity.this.mTbAdController.getView().getHeight() == d.a.c.e.p.l.i(LogoActivity.this.getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 4 : 3));
            if (LogoActivity.this.mGoto != -2) {
                LogoActivity.this.startGoto();
            } else {
                LogoActivity.this.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h extends CustomMessageListener {
        public h(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2016311) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                    if (LogoActivity.this.isFromHotSplash()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921022, str));
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra(DealIntentService.KEY_CLASS, 30);
                        intent.putExtra("jump_url", str);
                        intent.putExtra("is_ad", true);
                        TbadkCoreApplication.setIntent(intent);
                    }
                }
                d.a.c.e.m.e.a().removeCallbacks(LogoActivity.this.mShowADEndRunnable);
                LogoActivity.this.isAdDismiss = true;
                if (LogoActivity.this.isActivityInForeground) {
                    LogoActivity.this.showADEnd();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.goToNextPage();
        }
    }

    /* loaded from: classes4.dex */
    public class j implements Runnable {
        public j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.showADEnd();
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.hasLoadBesFinish) {
                return;
            }
            if (TbadkCoreApplication.getInst().isDebugMode()) {
                Log.d("IAdSdkSplash", "请求time out and switch next");
            }
            d.a.c.e.m.e.a().postDelayed(LogoActivity.this.mTimeOutRunnable, 500L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2921536, LogoActivity.this.besAdData));
            LogoActivity.this.mShowAdInternal = System.currentTimeMillis();
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.hasLoadBesFinish || LogoActivity.this.besSplashHolder == null) {
                return;
            }
            if (TbadkCoreApplication.getInst().isDebugMode()) {
                Log.d("IAdSdkSplash", "兜底time out and jump maintab");
            }
            LogoActivity.this.mRootView.removeView(LogoActivity.this.besSplashHolder);
            d.a.c.e.m.e.a().post(LogoActivity.this.mNormalLogoAniRunnable);
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.showNormalAniView();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.deleteApkFile();
            LogoActivity.deleteH5File();
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.showADEnd();
        }

        public /* synthetic */ o(LogoActivity logoActivity, f fVar) {
            this();
        }
    }

    public static /* synthetic */ int access$2708(LogoActivity logoActivity) {
        int i2 = logoActivity.mPrivacyPolicyDialogGuideClickTimes;
        logoActivity.mPrivacyPolicyDialogGuideClickTimes = i2 + 1;
        return i2;
    }

    private void dealIntent(Intent intent) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteApkFile() {
        File[] listFiles;
        File file = new File(FileHelper.getCacheDir());
        if (!file.isDirectory() || (listFiles = file.listFiles(new c())) == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            file2.delete();
        }
    }

    public static void deleteH5File() {
        String str = DOWNLOAD_DIR + QUICK_WEB_VIEW_DIR_NAME;
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            FileHelper.deleteFileOrDir(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToNextPage() {
        if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
            this.needGoNext = true;
            return;
        }
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
        d.a.c.e.m.h.a().b(new n());
        finish();
    }

    private void gotoMainTab(int i2) {
        this.mGoto = i2;
        showVideoSplash();
    }

    private void gotoMainTabInternal(int i2) {
        LogoActivityConfig.isFirst = false;
        sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i2)));
        finish();
    }

    private void init(Bundle bundle) {
        if (!PermissionUtil.isAgreePrivacyPolicy() && !TbSingleton.getInstance().isBrowseMode()) {
            d.a.n0.r.s.a b2 = d.a.o0.j.b(getPageContext(), this.mListener);
            this.mPrivacyPolicyDialogRemind = b2;
            b2.show();
            d.a.o0.g.b("1");
        } else if (!isLocationRequestDialogShow() && !PermissionUtil.checkLocationForGoogle(getActivity())) {
            showLocationRequestDialog();
        } else {
            if (PermissionUtil.checkLocationForGoogle(getActivity())) {
                d.a.c.e.i.a.k().g(false);
            }
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            if (isFromHotSplash()) {
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(SDKLogTypeConstants.EXPTYPE_LITEINC_INSTALL);
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
                try {
                    setContentView(R.layout.logo_activity);
                    this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                    LogoActivityConfig.isFirst = true;
                    registerListener(this.splashClickListener);
                    this.mGoto = -2;
                    showTbSplash();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                } catch (Throwable th) {
                    BdLog.e(th);
                    finish();
                }
            } else if (!isTaskRoot() && !isFromShortcut()) {
                finish();
            } else {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.HOST_START).param("obj_param1", 2).param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, TbadkCoreApplication.getInst().getCanShowSplash()));
                TbadkCoreApplication.getInst().onLowMemory();
                if (!TbadkCoreApplication.isLogin()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
                }
                dealIntent(getIntent());
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(SDKLogTypeConstants.EXPTYPE_LITEINC_INSTALL);
                }
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                if (bundle != null) {
                    LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
                } else {
                    LogoActivityConfig.isFirst = true;
                }
                this.mIsFirstUse = TbadkCoreApplication.getInst().getIsFirstUse();
                d.a.n0.m0.l.b().A(this.mIsFirstUse);
                registerListener(this.splashClickListener);
                syncAccountAndStart();
                Handler handler = this.mHandler;
                handler.sendMessage(handler.obtainMessage());
                HashMap hashMap = new HashMap();
                hashMap.put("type", IntentConfig.START);
                hashMap.put("uname", TbadkCoreApplication.getCurrentAccountName());
                hashMap.put("uid", TbadkCoreApplication.getCurrentAccount());
                MessageManager.getInstance().sendMessage(new CustomMessage(2006002, hashMap));
                if (MessageManager.getInstance().findTask(2010002) != null) {
                    startSwitchDebugService();
                }
                if (!FileHelper.checkSD()) {
                    TiebaStatic.file("no SD", "LogoActivity.onCreate");
                }
                if (MessageManager.getInstance().findTask(2001345) != null) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2001345, new IntentConfig(getPageContext().getContext())));
                }
            }
        }
    }

    private void initializationApp() {
        if (this.mIsFirstUse) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            d.a.n0.r.d0.b.j().t("frs_first_in", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFromHotSplash() {
        return getIntent().getBooleanExtra("splash", false);
    }

    private boolean isFromShortcut() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
        if (booleanExtra) {
            String stringExtra = intent.getStringExtra("fname");
            if (!StringUtils.isNull(stringExtra)) {
                TiebaStatic.log(new StatisticItem("c11897").param("fname", stringExtra));
            }
        }
        return booleanExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLocationRequestDialogShow() {
        return StringHelper.equals(TbConfig.getVersion(), d.a.n0.r.d0.b.j().p("key_location_request_dialog_last_show_version", ""));
    }

    private boolean judgeLocationPermissionGranted(int[] iArr) {
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= iArr.length) {
                z = true;
                break;
            } else if (iArr[i2] != 0) {
                break;
            } else {
                i2++;
            }
        }
        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCATION_PERMISSION_CLICK);
        statisticItem.param("obj_type", 2);
        statisticItem.param("obj_name", z ? 1 : 2);
        TiebaStatic.log(statisticItem);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showADEnd() {
        startGoto();
        d.a.n0.m0.l.b().l(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showADView() {
        if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
            showNormalAniView();
        } else if (MessageManager.getInstance().findTask(2016555) == null) {
            showNormalAniView();
        } else {
            showBesAdView();
        }
    }

    private void showBesAdView() {
        this.adCreateStartTime = System.currentTimeMillis();
        this.adReqeustStartTime = System.currentTimeMillis();
        this.besAdData = new d.a.n0.k.d();
        this.besSplashHolder = new RelativeLayout(getPageContext().getPageActivity());
        this.besSplashHolder.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.besSplashHolder);
        this.besAdData.d(this.besSplashHolder);
        this.besAdData.c(new b());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016555, Long.class, this.besAdData);
        d.a.n0.m0.l.b().j(System.currentTimeMillis() - this.adCreateStartTime);
        d.a.c.e.m.e.a().postDelayed(this.mRequirTimeOutRunnable, runTask != null ? ((Long) runTask.getData()).longValue() : 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLocationRequestDialog() {
        d.a.n0.r.d0.b.j().x("key_location_request_dialog_last_show_version", TbConfig.getVersion());
        PermissionUtil.reuqestLocation(getActivity(), 22001, new d(), new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalAniView() {
        if (this.mGoto == -2) {
            finish();
        } else {
            d.a.c.e.m.e.a().post(this.mNormalLogoAniRunnable);
        }
    }

    private void showTbSplash() {
        this.adCreateStartTime = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, d.a.n0.w0.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            d.a.n0.w0.a aVar = (d.a.n0.w0.a) runTask.getData();
            this.mTbAdController = aVar;
            aVar.b(this.mTbAdCallback);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_locate", 2).param("obj_type", "a064"));
            this.mTbAdController.a();
            d.a.n0.m0.l.b().j(System.currentTimeMillis() - this.adCreateStartTime);
            int k2 = d.a.n0.r.d0.b.j().k("video_splash_timeout", 1);
            d.a.c.e.m.e.a().postDelayed(this.mTbTimeOutRunnable, (k2 > 0 ? k2 : 1) * 1000);
            return;
        }
        showADView();
    }

    private void showVideoSplash() {
        if (this.mGoto != -2) {
            if (this.mVideoSplashController == null) {
                this.mVideoSplashController = new d.a.o0.u3.d(this);
            }
            if (this.mVideoSplashController.h()) {
                View k2 = this.mVideoSplashController.k(0.8125d);
                this.mVideoSplashView = k2;
                this.mRootView.addView(k2);
                this.mVideoSplashController.r(this.mVideoSplashCallback);
                this.mVideoSplashController.t();
                return;
            }
            this.mVideoSplashController.i();
        }
        showTbSplash();
    }

    private void startApp(Context context) {
        initializationApp();
        if (LogoActivityConfig.mFromSpacial) {
            gotoMainTab(2);
            LogoActivityConfig.mFromSpacial = false;
        } else if (TbadkCoreApplication.isLogin()) {
            if (this.mIsFirstUse) {
                d.a.c.e.m.e.a().post(this.mFirstLogoAniRunnable);
            } else {
                gotoMainTab(2);
            }
        } else if (this.mIsFirstUse) {
            d.a.c.e.m.e.a().post(this.mFirstLogoAniRunnable);
        } else {
            showVideoSplash();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGoto() {
        int i2 = this.mGoto;
        if (i2 >= 0) {
            gotoMainTabInternal(i2);
        } else if (i2 == -2) {
            finish();
        } else {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            finish();
        }
    }

    private void startSwitchDebugService() {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000996, new d.a.c.b.a.b(getPageContext().getPageActivity())));
    }

    private void syncAccountAndStart() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            d.a.n0.r.z.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                d.a.n0.r.z.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(d.a.n0.r.l.c.e(), getPageContext().getPageActivity());
            }
        }
        startApp(getPageContext().getPageActivity());
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.n0.k0.a
    public String getCurrentPageKey() {
        return "a064";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d.a.n0.k0.d getPageStayDurationItem() {
        d.a.n0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            pageStayDurationItem.o(this.mAdSource);
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 16001) {
            if (intent == null) {
                gotoMainTab(2);
                return;
            }
            int intExtra = intent.getIntExtra("go_to", -1);
            if (intExtra >= 0) {
                gotoMainTab(intExtra);
            } else {
                gotoMainTab(2);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        d.a.n0.k.b bVar;
        super.onConfigurationChanged(configuration);
        d.a.n0.w0.a aVar = this.mTbAdController;
        if (aVar != null && aVar.getView() != null && this.mTbAdController.getView().getParent() != null) {
            boolean z = false;
            if (this.mTbAdController.getView() != null) {
                if (this.mTbAdController.getView().getHeight() == d.a.c.e.p.l.i(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int k2 = d.a.c.e.p.l.k(getPageContext().getPageActivity());
            int i2 = d.a.c.e.p.l.i(getPageContext().getPageActivity());
            if (!z) {
                i2 = (int) (d.a.c.e.p.l.i(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTbAdController.getView().getLayoutParams();
            layoutParams.width = k2;
            layoutParams.height = i2;
            this.mTbAdController.getView().setLayoutParams(layoutParams);
        }
        d.a.n0.k.d dVar = this.besAdData;
        if (dVar == null || (bVar = dVar.f53216c) == null) {
            return;
        }
        bVar.a();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().getDecorView().setBackgroundResource(R.drawable.pic_splash_logo);
        this.logoCreateTime = System.currentTimeMillis();
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(false);
        super.onCreate(bundle);
        d.a.o0.d3.c.g().i(getUniqueId());
        init(bundle);
        TbadkCoreApplication.getInst().initTrackConfig();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.a.n0.k.d dVar = this.besAdData;
        if (dVar != null) {
            dVar.d(null);
            this.besAdData.c(null);
        }
        d.a.n0.w0.a aVar = this.mTbAdController;
        if (aVar != null) {
            aVar.release();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.mShowADEndRunnable);
        d.a.c.e.m.e.a().removeCallbacks(this.mFirstLogoAniRunnable);
        d.a.c.e.m.e.a().removeCallbacks(this.mNormalLogoAniRunnable);
        d.a.c.e.m.e.a().removeCallbacks(this.mTimeOutRunnable);
        d.a.c.e.m.e.a().removeCallbacks(this.mRequirTimeOutRunnable);
        d.a.c.e.m.e.a().removeCallbacks(this.mTbTimeOutRunnable);
        d.a.o0.u3.d dVar2 = this.mVideoSplashController;
        if (dVar2 != null) {
            dVar2.n();
        }
        Bitmap bitmap = this.mBgBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mBgBitmap.recycle();
            this.mBgBitmap = null;
        }
        RelativeLayout relativeLayout = this.mRootView;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundDrawable(null);
        }
        LogoActivityConfig.isFirst = true;
        d.a.o0.d3.c.g().k(getUniqueId());
        d.a.c.e.p.d.d().b();
        MessageManager.getInstance().runTask(2921555, (Class) null);
        d.a.n0.r.s.a aVar2 = this.mPrivacyPolicyDialogRemind;
        if (aVar2 != null) {
            aVar2.dismiss();
        }
        d.a.n0.r.s.a aVar3 = this.mPrivacyPolicyDialogGuideOne;
        if (aVar3 != null) {
            aVar3.dismiss();
        }
        d.a.n0.r.s.a aVar4 = this.mPrivacyPolicyDialogGuideTwo;
        if (aVar4 != null) {
            aVar4.dismiss();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && LogoActivityConfig.isFirst) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.isActivityInForeground = false;
        d.a.o0.u3.d dVar = this.mVideoSplashController;
        if (dVar != null) {
            dVar.o();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 22001) {
            judgeLocationPermissionGranted(iArr);
            d.a.c.e.i.a.k().g(false);
            goToNextPage();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.isActivityInForeground = true;
        if (this.mIsFirstOnResume) {
            this.mIsFirstOnResume = false;
            MessageManager.getInstance().registerStickyMode(2001370);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
            if (System.currentTimeMillis() - d.a.n0.r.d0.b.j().l("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(d.a.n0.r.d0.b.j().p("applist_intalled_apk_ids", ""));
            }
        }
        if (PermissionUtil.isAgreePrivacyPolicy()) {
            NASLib.onAppStart(getActivity());
        }
        if (this.isAdDismiss) {
            showADEnd();
        }
        if (!LogoActivityConfig.isFirst) {
            LogoActivityConfig.isFirst = true;
            finish();
            return;
        }
        if (this.needGoNext) {
            goToNextPage();
            this.needGoNext = false;
        }
        d.a.o0.u3.d dVar = this.mVideoSplashController;
        if (dVar != null) {
            dVar.p();
        }
        if (!LogoActivityConfig.isFirst || this.logoCreateTime < 0) {
            return;
        }
        d.a.n0.m0.l.b().w(System.currentTimeMillis() - this.logoCreateTime);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_first", LogoActivityConfig.isFirst);
    }
}
