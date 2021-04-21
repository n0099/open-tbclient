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
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.util.Log;
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
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.appsearchlib.NASLib;
import com.baidu.mobads.container.util.SDKLogTypeConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.AdSdkSwitch;
import d.b.j0.t3.d;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes4.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
    public static final int ACCOUNT_PROTOCOL_END = 132;
    public static final int ACCOUNT_PROTOCOL_START = 126;
    public static final String DOWNLOAD_DIR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    public static final double FOOT_HEIGHT_RATIO = 0.1875d;
    public static final long ONE_DAY = 86400000;
    public static final int PRIVICY_END = 125;
    public static final int PRIVICY_START = 119;
    public static final String QUICK_WEB_VIEW_DIR_NAME = "bdtbWCache";
    public static final int RESUME_SPLASH = -2;
    public d.b.i0.k.c besAdData;
    public ViewGroup besSplashHolder;
    public d.b.i0.r.s.a mFinalPrivateDialog;
    public d.b.i0.r.s.a mPrivateDialog;
    public RelativeLayout mRootView;
    public d.b.i0.w0.a mTbAdController;
    public d.b.i0.r.s.a mTipDialog;
    public d.b.j0.t3.d mVideoSplashController;
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
    public int mPrivatePopupTimes = 2;
    public int mAdSource = 0;
    public long mShowAdInternal = 0;
    public r mShowADEndRunnable = new r(this, null);
    public boolean hasLoadBesFinish = false;
    public d.b.i0.w0.b mTbAdCallback = new h();
    public long logoCreateTime = -1;
    public d.g mVideoSplashCallback = new i();
    public CustomMessageListener splashClickListener = new j(2016311);
    public Runnable mFirstLogoAniRunnable = new k();
    public Runnable mNormalLogoAniRunnable = new l();
    public Runnable mRequirTimeOutRunnable = new m();
    public Runnable mTimeOutRunnable = new n();
    public Runnable mTbTimeOutRunnable = new o();
    public View.OnClickListener mListener = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (id != R.id.private_yes && id != R.id.final_private_yes) {
                if (id == R.id.private_no) {
                    if (LogoActivity.this.mPrivateDialog.isShowing()) {
                        LogoActivity.this.mPrivateDialog.dismiss();
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEERET_HINT_BUTTON_CLICK);
                    statisticItem.param("obj_locate", "2");
                    TiebaStatic.log(statisticItem);
                    if (LogoActivity.this.mTipDialog == null) {
                        LogoActivity.this.createTipForPrivateDialog();
                    }
                    LogoActivity.this.mTipDialog.show();
                    d.b.j0.g.b("2");
                    d.b.j0.g.a("1", "2");
                    return;
                } else if (id == R.id.private_close_btn) {
                    if (LogoActivity.this.mTipDialog.isShowing()) {
                        LogoActivity.this.mTipDialog.dismiss();
                    }
                    if (LogoActivity.this.mPrivatePopupTimes > 0) {
                        if (LogoActivity.this.mPrivateDialog == null) {
                            LogoActivity.this.createSecretHitDialog();
                        }
                        LogoActivity.this.mPrivateDialog.show();
                        LogoActivity.access$2710(LogoActivity.this);
                        d.b.j0.g.b("1");
                    } else {
                        if (LogoActivity.this.mFinalPrivateDialog == null) {
                            LogoActivity.this.createFinalPrivateDialog();
                        }
                        LogoActivity.this.mFinalPrivateDialog.show();
                        d.b.j0.g.b("3");
                    }
                    d.b.j0.g.a("2", "3");
                    return;
                } else if (id == R.id.final_private_no) {
                    if (LogoActivity.this.mFinalPrivateDialog.isShowing()) {
                        LogoActivity.this.mFinalPrivateDialog.dismiss();
                    }
                    d.b.j0.g.a("3", "2");
                    LogoActivity.this.finish();
                    return;
                } else {
                    return;
                }
            }
            if (id == R.id.private_yes) {
                d.b.j0.g.a("1", "1");
            } else if (id == R.id.final_private_yes) {
                d.b.j0.g.a("3", "1");
            }
            if (LogoActivity.this.mPrivateDialog != null && LogoActivity.this.mPrivateDialog.isShowing()) {
                LogoActivity.this.mPrivateDialog.dismiss();
            }
            if (LogoActivity.this.mFinalPrivateDialog != null && LogoActivity.this.mFinalPrivateDialog.isShowing()) {
                LogoActivity.this.mFinalPrivateDialog.dismiss();
            }
            PermissionUtil.setIsAgreePrivacyPolicy(true);
            d.b.i0.r.d0.b.j().w("key_first_enter_app_timestamp", System.currentTimeMillis());
            if (LogoActivity.this.isLocationRequestDialogShow() || PermissionUtil.checkLocationForGoogle(LogoActivity.this.getActivity())) {
                LogoActivity.this.goToNextPage();
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_SEERET_HINT_BUTTON_CLICK);
                statisticItem2.param("obj_locate", "1");
                TiebaStatic.log(statisticItem2);
                return;
            }
            LogoActivity.this.showLocationRequestDialog();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.i0.k.a {
        public b() {
        }

        @Override // d.b.i0.k.a
        public void a(String str) {
            LogoActivity.this.hasLoadBesFinish = true;
            LogoActivity.this.mRootView.removeView(LogoActivity.this.besSplashHolder);
            LogoActivity.this.showNormalAniView();
            d.b.i0.m0.l.b().k(System.currentTimeMillis() - LogoActivity.this.adReqeustStartTime);
        }

        @Override // d.b.i0.k.a
        public void b(boolean z, boolean z2, int i) {
            LogoActivity.this.overridePendingTransition(0, 0);
            if (i == 1 || i == 7 || i == 5) {
                LogoActivity.this.isAdDismiss = true;
            } else {
                LogoActivity.this.showADEnd();
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK).param("obj_type", z2 ? 2 : 1).param("obj_source", i));
            StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", i).param("obj_type", "a030").param("obj_locate", 0).eventStat();
            StatisticItem statisticItem = new StatisticItem("common_click");
            statisticItem.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (z) {
                statisticItem.param("obj_type", z2 ? 4 : 3);
            } else {
                statisticItem.param("obj_type", z2 ? 2 : 1);
            }
            d.b.j0.c3.c.g().c(LogoActivity.this.getUniqueId(), statisticItem);
        }

        @Override // d.b.i0.k.a
        public void c(boolean z, boolean z2, int i) {
            LogoActivity.this.hasLoadBesFinish = true;
            LogoActivity.this.mAdSource = i;
            if (LogoActivity.this.mShowAdInternal > 0) {
                d.b.i0.r.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "internal", Long.valueOf(System.currentTimeMillis() - LogoActivity.this.mShowAdInternal));
            }
            d.b.c.e.m.e.a().removeCallbacks(LogoActivity.this.mRequirTimeOutRunnable);
            d.b.c.e.m.e.a().removeCallbacks(LogoActivity.this.mTimeOutRunnable);
            if (z2) {
                LogoActivity.this.mRootView.setBackgroundDrawable(null);
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).param("obj_type", z2 ? 2 : 1).param("obj_source", i));
            StatisticItem statisticItem = new StatisticItem("common_exp");
            statisticItem.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
            if (z) {
                statisticItem.param("obj_type", z2 ? 4 : 3);
            } else {
                statisticItem.param("obj_type", z2 ? 2 : 1);
            }
            d.b.j0.c3.c.g().d(LogoActivity.this.getUniqueId(), "bes_ad_id", statisticItem);
            d.b.j0.c3.c.g().h(LogoActivity.this.getUniqueId(), false);
            if (LogoActivity.this.mGoto == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
            }
            d.b.i0.m0.l.b().m(System.currentTimeMillis());
            d.b.i0.m0.l.b().k(System.currentTimeMillis() - LogoActivity.this.adReqeustStartTime);
        }

        @Override // d.b.i0.k.a
        public void onAdDismiss() {
            LogoActivity.this.isAdDismiss = true;
            if (LogoActivity.this.isActivityInForeground) {
                LogoActivity.this.showADEnd();
            }
        }

        @Override // d.b.i0.k.a
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
    public class d extends q {
        public d() {
            super(LogoActivity.this, null);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            d.b.i0.l.a.j(LogoActivity.this.getActivity(), "http://tieba.baidu.com/tb/cms/client/wise_secretright.html");
        }
    }

    /* loaded from: classes4.dex */
    public class e extends q {
        public e() {
            super(LogoActivity.this, null);
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            d.b.i0.l.a.j(LogoActivity.this.getActivity(), "https://gsp0.baidu.com/5aAHeD3nKhI2p27j8IqW0jdnxx1xbK/tb/eula.html");
        }
    }

    /* loaded from: classes4.dex */
    public class f implements PermissionJudgePolicy.IExtraDialogCloseCallback {
        public f() {
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.IExtraDialogCloseCallback
        public void onClose() {
            LogoActivity.this.goToNextPage();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements PermissionJudgePolicy.ISystemPermissionDialogShowCallBack {
        public g() {
        }

        @Override // com.baidu.tbadk.core.util.permission.PermissionJudgePolicy.ISystemPermissionDialogShowCallBack
        public void onShow() {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LOCATION_PERMISSION_SHOW);
            statisticItem.param("obj_type", 2);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes4.dex */
    public class h implements d.b.i0.w0.b {
        public h() {
        }

        @Override // d.b.i0.w0.b
        public void a(String str, boolean z, boolean z2) {
            d.b.c.e.m.e.a().removeCallbacks(LogoActivity.this.mTbTimeOutRunnable);
            if (LogoActivity.this.mTbAdController.getView() == null) {
                LogoActivity.this.showADEnd();
                return;
            }
            int k = d.b.c.e.p.l.k(LogoActivity.this.getPageContext().getPageActivity());
            int i = d.b.c.e.p.l.i(LogoActivity.this.getPageContext().getPageActivity());
            if (!z2) {
                i = (int) (d.b.c.e.p.l.i(LogoActivity.this.getPageContext().getPageActivity()) * 0.8125d);
            }
            LogoActivity.this.mTbAdController.getView().setLayoutParams(new RelativeLayout.LayoutParams(k, i));
            LogoActivity.this.mRootView.addView(LogoActivity.this.mTbAdController.getView());
            if (LogoActivity.this.mGoto == -2) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, LogoActivity.this));
            }
            d.b.i0.m0.l.b().m(System.currentTimeMillis());
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
            d.b.j0.c3.c.g().d(LogoActivity.this.getUniqueId(), str, statisticItem);
            d.b.j0.c3.c.g().h(LogoActivity.this.getUniqueId(), false);
        }

        @Override // d.b.i0.w0.b
        public void b() {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_type", "a064").param(TiebaStatic.Params.RESOURCE_ID, 0).param("obj_locate", 1));
            d.b.c.e.m.e.a().removeCallbacks(LogoActivity.this.mTbTimeOutRunnable);
            LogoActivity.this.showADView();
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0099  */
        @Override // d.b.i0.w0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(String str, boolean z) {
            boolean z2;
            if (LogoActivity.this.mTbAdController.getView() != null) {
                if (LogoActivity.this.mTbAdController.getView().getHeight() == d.b.c.e.p.l.i(LogoActivity.this.getPageContext().getPageActivity())) {
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
                    d.b.j0.c3.c.g().c(LogoActivity.this.getUniqueId(), statisticItem);
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
            d.b.j0.c3.c.g().c(LogoActivity.this.getUniqueId(), statisticItem2);
            LogoActivity.this.overridePendingTransition(0, 0);
            LogoActivity.this.showADEnd();
        }

        @Override // d.b.i0.w0.b
        public void onAdDismiss() {
            LogoActivity.this.isAdDismiss = true;
            if (LogoActivity.this.isActivityInForeground) {
                LogoActivity.this.showADEnd();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements d.g {
        public i() {
        }

        @Override // d.b.j0.t3.d.g
        public void onError() {
            LogoActivity.this.showNormalAniView();
        }

        @Override // d.b.j0.t3.d.g
        public void onSkip() {
            boolean z = false;
            if (LogoActivity.this.mTbAdController.getView() != null) {
                if (LogoActivity.this.mTbAdController.getView().getHeight() == d.b.c.e.p.l.i(LogoActivity.this.getPageContext().getPageActivity())) {
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
    public class j extends CustomMessageListener {
        public j(int i) {
            super(i);
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
                d.b.c.e.m.e.a().removeCallbacks(LogoActivity.this.mShowADEndRunnable);
                LogoActivity.this.isAdDismiss = true;
                if (LogoActivity.this.isActivityInForeground) {
                    LogoActivity.this.showADEnd();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.goToNextPage();
        }
    }

    /* loaded from: classes4.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.showADEnd();
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LogoActivity.this.hasLoadBesFinish) {
                return;
            }
            if (TbadkCoreApplication.getInst().isDebugMode()) {
                Log.d("IAdSdkSplash", "请求time out and switch next");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2921536, LogoActivity.this.besAdData));
            LogoActivity.this.mShowAdInternal = System.currentTimeMillis();
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Runnable {
        public n() {
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
            d.b.c.e.m.e.a().post(LogoActivity.this.mNormalLogoAniRunnable);
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    }

    /* loaded from: classes4.dex */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.showNormalAniView();
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    }

    /* loaded from: classes4.dex */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.deleteApkFile();
            LogoActivity.deleteH5File();
        }
    }

    /* loaded from: classes4.dex */
    public abstract class q extends ClickableSpan {
        public q() {
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(LogoActivity.this.getResources().getColor(R.color.CAM_X0303));
        }

        public /* synthetic */ q(LogoActivity logoActivity, h hVar) {
            this();
        }
    }

    /* loaded from: classes4.dex */
    public class r implements Runnable {
        public r() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogoActivity.this.showADEnd();
        }

        public /* synthetic */ r(LogoActivity logoActivity, h hVar) {
            this();
        }
    }

    public static /* synthetic */ int access$2710(LogoActivity logoActivity) {
        int i2 = logoActivity.mPrivatePopupTimes;
        logoActivity.mPrivatePopupTimes = i2 - 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createFinalPrivateDialog() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.final_private_dialog, (ViewGroup) null);
        inflate.findViewById(R.id.final_private_button_layout).setVisibility(0);
        TextView textView = (TextView) inflate.findViewById(R.id.final_scrollable_textview);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.final_private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.final_private_no);
        SkinManager.setViewTextColorSelector(textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        SkinManager.setViewTextColorSelector(textView3, R.color.CAM_X0105, R.color.cp_cont_b_alpha50, 0);
        textView2.setOnClickListener(this.mListener);
        textView3.setOnClickListener(this.mListener);
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this);
        this.mFinalPrivateDialog = aVar;
        aVar.setContentView(inflate);
        this.mFinalPrivateDialog.setContentViewSize(3);
        this.mFinalPrivateDialog.setCanceledOnTouchOutside(false);
        this.mFinalPrivateDialog.setAutoNight(false);
        this.mFinalPrivateDialog.setCancelable(false);
        this.mFinalPrivateDialog.create(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createSecretHitDialog() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        inflate.findViewById(R.id.protocol_layout).setVisibility(0);
        TextView textView = (TextView) inflate.findViewById(R.id.protocol_scrollable_textview);
        textView.setHighlightColor(0);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_yes);
        TextView textView3 = (TextView) inflate.findViewById(R.id.private_no);
        ((TextView) inflate.findViewById(R.id.private_title)).setText(R.string.secret_hint_head);
        String format = String.format(getResources().getString(R.string.secret_hint_format), getResources().getString(R.string.secret_hint_title), getResources().getString(R.string.secret_hint_footer), getResources().getString(R.string.secret_hint_content_1), getResources().getString(R.string.secret_hint_content_2), getResources().getString(R.string.secret_hint_content_3), getResources().getString(R.string.secret_hint_content_4));
        SpannableString spannableString = new SpannableString(format);
        spannableString.setSpan(new d(), 119, 125, 33);
        spannableString.setSpan(new e(), 126, 132, 33);
        Matcher matcher = Pattern.compile("\n\n").matcher(format);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(2, true), matcher.start() + 1, matcher.end(), 33);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this);
        this.mPrivateDialog = aVar;
        aVar.setContentView(inflate);
        this.mPrivateDialog.setContentViewSize(7);
        this.mPrivateDialog.setCanceledOnTouchOutside(false);
        this.mPrivateDialog.setAutoNight(false);
        this.mPrivateDialog.setCancelable(false);
        d.b.i0.r.u.c d2 = d.b.i0.r.u.c.d(textView2);
        d2.k(R.string.J_X01);
        d2.f(R.color.CAM_X0303);
        SkinManager.setViewTextColorSelector(textView2, R.color.CAM_X0101, R.color.CAM_X0618, 0);
        int i2 = R.color.CAM_X0110;
        SkinManager.setViewTextColorSelector(textView3, i2, i2, 0);
        textView2.setOnClickListener(this.mListener);
        textView3.setOnClickListener(this.mListener);
        this.mPrivateDialog.create(getPageContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createTipForPrivateDialog() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.private_hint_dialog, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.private_title)).setVisibility(8);
        inflate.findViewById(R.id.private_button_layout).setVisibility(8);
        TextView textView = (TextView) inflate.findViewById(R.id.scrollable_textview);
        textView.setVisibility(0);
        textView.setText(getString(R.string.secret_hint_dialog_content));
        textView.setGravity(1);
        TextView textView2 = (TextView) inflate.findViewById(R.id.private_close_btn);
        textView2.setVisibility(0);
        SkinManager.setViewTextColorSelector(textView2, R.color.CAM_X0302, R.color.cp_link_tip_a_alpha50, 0);
        textView2.setOnClickListener(this.mListener);
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this);
        this.mTipDialog = aVar;
        aVar.setContentView(inflate);
        this.mTipDialog.setContentViewSize(3);
        this.mTipDialog.setCanceledOnTouchOutside(false);
        this.mTipDialog.setAutoNight(false);
        this.mTipDialog.setCancelable(false);
        this.mTipDialog.create(getPageContext());
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
        d.b.c.e.m.h.a().b(new p());
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
        if (!PermissionUtil.isAgreePrivacyPolicy()) {
            createSecretHitDialog();
            this.mPrivateDialog.show();
            this.mPrivatePopupTimes--;
            d.b.j0.g.b("1");
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SEERET_HINT_ACTIVITY_SHOW));
        } else if (!isLocationRequestDialogShow() && !PermissionUtil.checkLocationForGoogle(getActivity())) {
            showLocationRequestDialog();
        } else {
            if (PermissionUtil.checkLocationForGoogle(getActivity())) {
                d.b.c.e.i.a.l().h(false);
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
                d.b.i0.m0.l.b().A(this.mIsFirstUse);
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
            d.b.i0.r.d0.b.j().t("frs_first_in", true);
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
        return StringHelper.equals(TbConfig.getVersion(), d.b.i0.r.d0.b.j().p("key_location_request_dialog_last_show_version", ""));
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
        d.b.i0.m0.l.b().l(System.currentTimeMillis());
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
        this.besAdData = new d.b.i0.k.c();
        this.besSplashHolder = new RelativeLayout(getPageContext().getPageActivity());
        this.besSplashHolder.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.mRootView.addView(this.besSplashHolder);
        this.besAdData.d(this.besSplashHolder);
        this.besAdData.c(new b());
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016555, Long.class, this.besAdData);
        d.b.i0.m0.l.b().j(System.currentTimeMillis() - this.adCreateStartTime);
        long longValue = runTask != null ? ((Long) runTask.getData()).longValue() : 1000L;
        d.b.c.e.m.e.a().postDelayed(this.mRequirTimeOutRunnable, longValue);
        d.b.c.e.m.e.a().postDelayed(this.mTimeOutRunnable, longValue + 500);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLocationRequestDialog() {
        d.b.i0.r.d0.b.j().x("key_location_request_dialog_last_show_version", TbConfig.getVersion());
        PermissionUtil.reuqestLocation(getActivity(), 22001, new f(), new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalAniView() {
        if (this.mGoto == -2) {
            finish();
        } else {
            d.b.c.e.m.e.a().post(this.mNormalLogoAniRunnable);
        }
    }

    private void showTbSplash() {
        this.adCreateStartTime = System.currentTimeMillis();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, d.b.i0.w0.a.class, getActivity());
        if (runTask != null && runTask.getData() != null) {
            d.b.i0.w0.a aVar = (d.b.i0.w0.a) runTask.getData();
            this.mTbAdController = aVar;
            aVar.b(this.mTbAdCallback);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_type", "a064"));
            this.mTbAdController.a();
            d.b.i0.m0.l.b().j(System.currentTimeMillis() - this.adCreateStartTime);
            int k2 = d.b.i0.r.d0.b.j().k("video_splash_timeout", 1);
            d.b.c.e.m.e.a().postDelayed(this.mTbTimeOutRunnable, (k2 > 0 ? k2 : 1) * 1000);
            return;
        }
        showADView();
    }

    private void showVideoSplash() {
        if (this.mGoto != -2) {
            if (this.mVideoSplashController == null) {
                this.mVideoSplashController = new d.b.j0.t3.d(this);
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
                d.b.c.e.m.e.a().post(this.mFirstLogoAniRunnable);
            } else {
                gotoMainTab(2);
            }
        } else if (this.mIsFirstUse) {
            d.b.c.e.m.e.a().post(this.mFirstLogoAniRunnable);
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
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000996, new d.b.c.b.a.b(getPageContext().getPageActivity())));
    }

    private void syncAccountAndStart() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            d.b.i0.r.z.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
            if (!getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                d.b.i0.r.z.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                TbadkCoreApplication.setCurrentAccount(d.b.i0.r.l.c.e(), getPageContext().getPageActivity());
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

    @Override // com.baidu.tbadk.BaseActivity, d.b.i0.k0.a
    public String getCurrentPageKey() {
        return "a064";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d.b.i0.k0.d getPageStayDurationItem() {
        d.b.i0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
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
        d.b.i0.k.b bVar;
        super.onConfigurationChanged(configuration);
        d.b.i0.w0.a aVar = this.mTbAdController;
        if (aVar != null && aVar.getView() != null && this.mTbAdController.getView().getParent() != null) {
            boolean z = false;
            if (this.mTbAdController.getView() != null) {
                if (this.mTbAdController.getView().getHeight() == d.b.c.e.p.l.i(getPageContext().getPageActivity())) {
                    z = true;
                }
            }
            int k2 = d.b.c.e.p.l.k(getPageContext().getPageActivity());
            int i2 = d.b.c.e.p.l.i(getPageContext().getPageActivity());
            if (!z) {
                i2 = (int) (d.b.c.e.p.l.i(getPageContext().getPageActivity()) * 0.8125d);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTbAdController.getView().getLayoutParams();
            layoutParams.width = k2;
            layoutParams.height = i2;
            this.mTbAdController.getView().setLayoutParams(layoutParams);
        }
        d.b.i0.k.c cVar = this.besAdData;
        if (cVar == null || (bVar = cVar.f50981c) == null) {
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
        d.b.j0.c3.c.g().i(getUniqueId());
        init(bundle);
        TbadkCoreApplication.getInst().initTrackConfig();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.b.i0.k.c cVar = this.besAdData;
        if (cVar != null) {
            cVar.d(null);
            this.besAdData.c(null);
        }
        d.b.i0.w0.a aVar = this.mTbAdController;
        if (aVar != null) {
            aVar.release();
        }
        d.b.c.e.m.e.a().removeCallbacks(this.mShowADEndRunnable);
        d.b.c.e.m.e.a().removeCallbacks(this.mFirstLogoAniRunnable);
        d.b.c.e.m.e.a().removeCallbacks(this.mNormalLogoAniRunnable);
        d.b.c.e.m.e.a().removeCallbacks(this.mTimeOutRunnable);
        d.b.c.e.m.e.a().removeCallbacks(this.mRequirTimeOutRunnable);
        d.b.c.e.m.e.a().removeCallbacks(this.mTbTimeOutRunnable);
        d.b.j0.t3.d dVar = this.mVideoSplashController;
        if (dVar != null) {
            dVar.n();
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
        d.b.j0.c3.c.g().k(getUniqueId());
        d.b.c.e.p.d.d().b();
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
        d.b.j0.t3.d dVar = this.mVideoSplashController;
        if (dVar != null) {
            dVar.o();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 22001) {
            judgeLocationPermissionGranted(iArr);
            d.b.c.e.i.a.l().h(false);
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
            if (System.currentTimeMillis() - d.b.i0.r.d0.b.j().l("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                TbadkCoreApplication.getInst().setInstalledAppIds(d.b.i0.r.d0.b.j().p("applist_intalled_apk_ids", ""));
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
        d.b.j0.t3.d dVar = this.mVideoSplashController;
        if (dVar != null) {
            dVar.p();
        }
        if (!LogoActivityConfig.isFirst || this.logoCreateTime < 0) {
            return;
        }
        d.b.i0.m0.l.b().w(System.currentTimeMillis() - this.logoCreateTime);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("is_first", LogoActivityConfig.isFirst);
    }
}
