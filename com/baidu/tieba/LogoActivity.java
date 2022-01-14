package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.t0.o;
import c.a.t0.r3.g.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearchlib.NASLib;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.nps.utils.Constant;
import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.searchbox.launch.stats.ActivitySpeedStats;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.launch.stats.SpeedStatsStampTable;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.AdSdkSwitch;
import com.baidu.tbadk.switchs.AdToMainTabActivitySwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes11.dex */
public class LogoActivity extends BaseFragmentActivity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DOWNLOAD_DIR;
    public static final double FOOT_HEIGHT_RATIO = 0.1875d;
    public static final long ONE_DAY = 86400000;
    public static final int PRIVACY_POLICY_GUIDE_DIALOG_CLICK_TIMES = 2;
    public static final String QUICK_WEB_VIEW_DIR_NAME = "bdtbWCache";
    public static final int RESUME_SPLASH = -2;
    public transient /* synthetic */ FieldHolder $fh;
    public long adCreateStartTime;
    public long adReqeustStartTime;
    public c.a.s0.l.d besAdData;
    public ViewGroup besSplashHolder;
    public boolean hasLoadBesFinish;
    public boolean isActivityInForeground;
    public boolean isAdDismiss;
    public boolean isLaunchOpOn;
    public long logoCreateTime;
    public int mAdSource;
    public Bitmap mBgBitmap;
    public Runnable mFirstLogoAniRunnable;
    public int mGoto;
    public boolean mIsFirstOnResume;
    public boolean mIsFirstUse;
    public View.OnClickListener mListener;
    public final CustomMessageListener mNightInstallListener;
    public Runnable mNormalLogoAniRunnable;
    public int mPrivacyPolicyDialogGuideClickTimes;
    public c.a.s0.s.s.a mPrivacyPolicyDialogGuideOne;
    public c.a.s0.s.s.a mPrivacyPolicyDialogGuideTwo;
    public c.a.s0.s.s.a mPrivacyPolicyDialogRemind;
    public Runnable mRequirTimeOutRunnable;
    public RelativeLayout mRootView;
    public n mShowADEndRunnable;
    public long mShowAdInternal;
    public c.a.s0.b1.b mTbAdCallback;
    public c.a.s0.b1.a mTbAdController;
    public Runnable mTbTimeOutRunnable;
    public Runnable mTimeOutRunnable;
    public int mTriggerSafeModeStatus;
    public f.g mVideoSplashCallback;
    public c.a.t0.r3.g.f mVideoSplashController;
    public View mVideoSplashView;
    public boolean needGoNext;
    public c.a.t0.m newLogoDelegate;
    public PermissionJudgePolicy permissionJudgePolicy;
    public CustomMessageListener splashClickListener;
    public long uniqueId;

    /* loaded from: classes11.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f41618e;

        public a(LogoActivity logoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41618e = logoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41618e.deleteApkFile();
                LogoActivity.deleteH5File();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f41619e;

        public b(LogoActivity logoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41619e = logoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == R.id.private_yes || id == R.id.yesBtn) {
                    if (this.f41619e.mPrivacyPolicyDialogRemind != null && this.f41619e.mPrivacyPolicyDialogRemind.isShowing()) {
                        this.f41619e.mPrivacyPolicyDialogRemind.dismiss();
                        SmartLaunchStats.onConfirmPrivacy();
                        c.a.t0.r3.f.a.a("1", "1");
                        c.a.s0.s.y.a.j(ActivitySpeedStats.LOGO_ACTIVITY_DURATION, false);
                    }
                    if (this.f41619e.mPrivacyPolicyDialogGuideOne != null && this.f41619e.mPrivacyPolicyDialogGuideOne.isShowing()) {
                        this.f41619e.mPrivacyPolicyDialogGuideOne.dismiss();
                        c.a.t0.r3.f.a.a("2", "1");
                        c.a.s0.s.y.a.j(ActivitySpeedStats.LOGO_ACTIVITY_DURATION, false);
                    }
                    if (this.f41619e.mPrivacyPolicyDialogGuideTwo != null && this.f41619e.mPrivacyPolicyDialogGuideTwo.isShowing()) {
                        this.f41619e.mPrivacyPolicyDialogGuideTwo.dismiss();
                        c.a.t0.r3.f.a.a("3", "1");
                        c.a.s0.s.y.a.j(ActivitySpeedStats.LOGO_ACTIVITY_DURATION, false);
                    }
                    c.a.s0.s.h0.b.k().x("key_first_enter_app_timestamp", System.currentTimeMillis());
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    this.f41619e.goToNextPage();
                } else if (id == R.id.private_no) {
                    if (this.f41619e.mPrivacyPolicyDialogRemind.isShowing()) {
                        this.f41619e.mPrivacyPolicyDialogRemind.dismiss();
                        c.a.t0.r3.f.a.a("1", "2");
                    }
                    if (this.f41619e.mPrivacyPolicyDialogGuideOne == null) {
                        LogoActivity logoActivity = this.f41619e;
                        logoActivity.mPrivacyPolicyDialogGuideOne = o.a(logoActivity.getPageContext(), this.f41619e.mListener, R.string.privacy_policy_guide_one, R.string.secret_hint_no_agree);
                    }
                    this.f41619e.mPrivacyPolicyDialogGuideOne.show();
                    c.a.t0.r3.f.a.b("2");
                } else if (id == R.id.browseBtn) {
                    LogoActivity.access$2708(this.f41619e);
                    if (this.f41619e.mPrivacyPolicyDialogGuideOne.isShowing()) {
                        this.f41619e.mPrivacyPolicyDialogGuideOne.dismiss();
                        c.a.t0.r3.f.a.a("2", "2");
                        if (this.f41619e.mPrivacyPolicyDialogGuideTwo == null) {
                            LogoActivity logoActivity2 = this.f41619e;
                            logoActivity2.mPrivacyPolicyDialogGuideTwo = o.a(logoActivity2.getPageContext(), this.f41619e.mListener, R.string.privacy_policy_guide_two, R.string.secret_hint_browser_exit);
                            this.f41619e.mPrivacyPolicyDialogGuideTwo.show();
                            c.a.t0.r3.f.a.b("3");
                        }
                    }
                    if (this.f41619e.mPrivacyPolicyDialogGuideTwo.isShowing() && this.f41619e.mPrivacyPolicyDialogGuideClickTimes == 2) {
                        this.f41619e.mPrivacyPolicyDialogGuideTwo.dismiss();
                        c.a.t0.r3.f.a.a("3", "2");
                        this.f41619e.finish();
                    }
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class c implements c.a.s0.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LogoActivity a;

        public c(LogoActivity logoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = logoActivity;
        }

        @Override // c.a.s0.l.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                SpeedStatsManager.getInstance().setAdSource(str);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SDK_DO_SHOW_STAMP_KEY);
            }
        }

        @Override // c.a.s0.l.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SDK_WILL_SHOW_STAMP_KEY);
            }
        }

        @Override // c.a.s0.l.a
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a.hasLoadBesFinish = true;
                this.a.mRootView.removeView(this.a.besSplashHolder);
                this.a.showNormalAniView();
                c.a.s0.s0.l.b().k(System.currentTimeMillis() - this.a.adReqeustStartTime);
            }
        }

        @Override // c.a.s0.l.a
        public void d(boolean z, boolean z2, int i2, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), str, str2, str3}) == null) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
                SpeedStatsManager.getInstance().setStatsFlag(false);
                this.a.overridePendingTransition(0, 0);
                this.a.isAdDismiss = true;
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK);
                statisticItem.param("obj_type", z2 ? 2 : 1).param("obj_source", i2);
                if (str2 != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_TO, str2);
                }
                if (str3 != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str3);
                }
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK);
                statisticItem2.param("obj_source", i2).param("obj_type", "a064").param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.a.uniqueId);
                if (!StringUtils.isNull(str)) {
                    statisticItem2.param("nid", str);
                }
                if (!StringUtils.isNull(str2)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_TO, str2);
                }
                if (!StringUtils.isNull(str3)) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str3);
                }
                TiebaStatic.log(statisticItem2);
                StatisticItem statisticItem3 = new StatisticItem("common_click");
                statisticItem3.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
                if (z) {
                    statisticItem3.param("obj_type", z2 ? 4 : 3);
                } else {
                    statisticItem3.param("obj_type", z2 ? 2 : 1);
                }
                c.a.t0.v3.c.g().c(this.a.getUniqueId(), statisticItem3);
            }
        }

        @Override // c.a.s0.l.a
        public void e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                if ("5".equals(str)) {
                    SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_XUZHANG_LOAD_END_STAMP_KEY);
                } else if ("6".equals(str)) {
                    SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_XIAOXIONG_LOAD_END_STAMP_KEY);
                }
            }
        }

        @Override // c.a.s0.l.a
        public void f(boolean z, boolean z2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
                this.a.hasLoadBesFinish = true;
                this.a.mAdSource = i2;
                if (this.a.mShowAdInternal > 0) {
                    c.a.s0.s.b0.a.a("homePage", -1L, 0, "logo_splash", 0, "", "internal", Long.valueOf(System.currentTimeMillis() - this.a.mShowAdInternal));
                }
                c.a.d.f.m.e.a().removeCallbacks(this.a.mRequirTimeOutRunnable);
                c.a.d.f.m.e.a().removeCallbacks(this.a.mTimeOutRunnable);
                if (z2) {
                    this.a.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).param("obj_type", z2 ? 2 : 1).param("obj_source", i2));
                StatisticItem statisticItem = new StatisticItem("common_exp");
                statisticItem.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
                if (z) {
                    statisticItem.param("obj_type", z2 ? 4 : 3);
                } else {
                    statisticItem.param("obj_type", z2 ? 2 : 1);
                }
                c.a.t0.v3.c.g().d(this.a.getUniqueId(), "bes_ad_id", statisticItem);
                c.a.t0.v3.c.g().h(this.a.getUniqueId(), false);
                if (this.a.mGoto == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this.a));
                }
                c.a.s0.s0.l.b().m(System.currentTimeMillis());
                c.a.s0.s0.l.b().k(System.currentTimeMillis() - this.a.adReqeustStartTime);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_START_STAMP_KEY);
            }
        }

        @Override // c.a.s0.l.a
        public void onAdDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
                this.a.isAdDismiss = true;
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 1).param(TiebaStatic.Params.OBJ_PARAM2, hashCode()).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(this.a.isActivityInForeground)));
                if (this.a.isActivityInForeground) {
                    this.a.showADEnd();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class d implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LogoActivity a;

        public d(LogoActivity logoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = logoActivity;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                String name = file.getName();
                return !TextUtils.isEmpty(name) && name.contains(this.a.getPageContext().getString(R.string.app_name)) && name.endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes11.dex */
    public class e implements c.a.s0.b1.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LogoActivity a;

        public e(LogoActivity logoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = logoActivity;
        }

        @Override // c.a.s0.b1.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_type", "a064").param(TiebaStatic.Params.RESOURCE_ID, 0).param("aid", this.a.isFromHotSplash() ? 2 : 1).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.a.uniqueId).param("obj_locate", 1));
                c.a.d.f.m.e.a().removeCallbacks(this.a.mTbTimeOutRunnable);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_TB_LOAD_END_STAMP_KEY);
                this.a.showADView();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x009d  */
        @Override // c.a.s0.b1.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(String str, boolean z) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
                if (this.a.mTbAdController.getView() != null) {
                    if (this.a.mTbAdController.getView().getHeight() == c.a.d.f.p.n.i(this.a.getPageContext().getPageActivity())) {
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
                        c.a.t0.v3.c.g().c(this.a.getUniqueId(), statisticItem);
                        SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
                        this.a.overridePendingTransition(0, 0);
                        this.a.showADEnd();
                    }
                }
                z2 = false;
                TiebaStatic.log(new StatisticItem("c13332").param("obj_id", str).param("obj_type", !z2 ? 2 : 1));
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 2).param("obj_type", "a030").param("obj_locate", 0).eventStat();
                StatisticItem statisticItem2 = new StatisticItem("common_click");
                statisticItem2.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param("obj_id", str).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", 2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
                if (!z) {
                }
                c.a.t0.v3.c.g().c(this.a.getUniqueId(), statisticItem2);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
                this.a.overridePendingTransition(0, 0);
                this.a.showADEnd();
            }
        }

        @Override // c.a.s0.b1.b
        public void c(String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                c.a.d.f.m.e.a().removeCallbacks(this.a.mTbTimeOutRunnable);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_TB_LOAD_END_STAMP_KEY);
                if (this.a.mTbAdController.getView() == null) {
                    this.a.showADEnd();
                    return;
                }
                int k = c.a.d.f.p.n.k(this.a.getPageContext().getPageActivity());
                int i2 = c.a.d.f.p.n.i(this.a.getPageContext().getPageActivity());
                if (!z2) {
                    i2 = (int) (c.a.d.f.p.n.i(this.a.getPageContext().getPageActivity()) * 0.8125d);
                }
                this.a.mTbAdController.getView().setLayoutParams(new RelativeLayout.LayoutParams(k, i2));
                this.a.mRootView.addView(this.a.mTbAdController.getView());
                if (this.a.mGoto == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this.a));
                }
                c.a.s0.s0.l.b().m(System.currentTimeMillis());
                TiebaStatic.log(new StatisticItem("c13331").param("obj_id", str).param("obj_type", z2 ? 2 : 1));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_type", "a064").param("aid", this.a.isFromHotSplash() ? 2 : 1).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.a.uniqueId).param("obj_locate", 0));
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 2).param("obj_type", "a064").param("obj_locate", 0));
                StatisticItem statisticItem = new StatisticItem("common_exp");
                statisticItem.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param("obj_id", str).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", 2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
                if (z) {
                    statisticItem.param("obj_type", z2 ? 4 : 3);
                } else {
                    statisticItem.param("obj_type", z2 ? 2 : 1);
                }
                c.a.t0.v3.c.g().d(this.a.getUniqueId(), str, statisticItem);
                c.a.t0.v3.c.g().h(this.a.getUniqueId(), false);
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_START_STAMP_KEY);
            }
        }

        @Override // c.a.s0.b1.b
        public void onAdDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
                this.a.isAdDismiss = true;
                if (this.a.isActivityInForeground) {
                    this.a.showADEnd();
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class f implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LogoActivity a;

        public f(LogoActivity logoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = logoActivity;
        }

        @Override // c.a.t0.r3.g.f.g
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                boolean z = false;
                if (this.a.mTbAdController.getView() != null) {
                    if (this.a.mTbAdController.getView().getHeight() == c.a.d.f.p.n.i(this.a.getPageContext().getPageActivity())) {
                        z = true;
                    }
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 4 : 3));
                if (this.a.mGoto != -2) {
                    this.a.startGoto();
                } else {
                    this.a.finish();
                }
            }
        }

        @Override // c.a.t0.r3.g.f.g
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.showNormalAniView();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LogoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(LogoActivity logoActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logoActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = logoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_SHOW_END_STAMP_KEY);
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        Intent intent = new Intent();
                        int indexOf = str.indexOf("&extInfo=");
                        String substring = indexOf > 0 ? str.substring(0, indexOf) : str;
                        String substring2 = str.substring(substring.length() + 9, str.length());
                        if (substring.startsWith("https://") || substring.startsWith("http://")) {
                            intent.putExtra("gd_ad", true);
                            intent.putExtra("ext_info", substring2);
                        }
                        if (!this.a.isFromHotSplash() && (StringUtils.isNull(substring) || !substring.startsWith("bdtiebalive"))) {
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra("jump_url", substring);
                            intent.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent);
                        } else {
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra("jump_url", substring);
                            intent.putExtra("is_ad", true);
                            UtilHelper.commenDealIntent(this.a, intent);
                        }
                    }
                    c.a.d.f.m.e.a().removeCallbacks(this.a.mShowADEndRunnable);
                    this.a.isAdDismiss = true;
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", this.a.getClass().getSimpleName()).param("obj_param1", 5).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(this.a.isActivityInForeground)));
                    if (this.a.isActivityInForeground || DeviceInfoUtil.isHuaWeiP40Pro()) {
                        this.a.showADEnd();
                    }
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LogoActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(LogoActivity logoActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logoActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = logoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.gotoMainTabInternal((customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Integer)) ? -1 : ((Integer) customResponsedMessage.getData()).intValue());
            }
        }
    }

    /* loaded from: classes11.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f41620e;

        public i(LogoActivity logoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41620e = logoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41620e.goToNextPage();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f41621e;

        public j(LogoActivity logoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41621e = logoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41621e.showADEnd();
            }
        }
    }

    /* loaded from: classes11.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f41622e;

        public k(LogoActivity logoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41622e = logoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f41622e.hasLoadBesFinish) {
                return;
            }
            TiebaStatic.log(new StatisticItem("splash_request_timeout"));
            TbadkCoreApplication.getInst().isDebugMode();
            c.a.d.f.m.e.a().postDelayed(this.f41622e.mTimeOutRunnable, 500L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2921536, this.f41622e.besAdData));
            this.f41622e.mShowAdInternal = System.currentTimeMillis();
        }
    }

    /* loaded from: classes11.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f41623e;

        public l(LogoActivity logoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41623e = logoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f41623e.hasLoadBesFinish || this.f41623e.besSplashHolder == null) {
                return;
            }
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921657, Boolean.class);
            if (runTask == null || runTask.getData() == null || !((Boolean) runTask.getData()).booleanValue()) {
                TiebaStatic.log(new StatisticItem("splash_timeout_go_maintab"));
                new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME).param("obj_source", 0).param("obj_type", "a064").param("obj_param1", 1).eventStat();
                TbadkCoreApplication.getInst().isDebugMode();
                this.f41623e.mRootView.removeView(this.f41623e.besSplashHolder);
                c.a.d.f.m.e.a().post(this.f41623e.mNormalLogoAniRunnable);
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    }

    /* loaded from: classes11.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f41624e;

        public m(LogoActivity logoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41624e = logoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41624e.showNormalAniView();
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    }

    /* loaded from: classes11.dex */
    public class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f41625e;

        public n(LogoActivity logoActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {logoActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41625e = logoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f41625e.showADEnd();
            }
        }

        public /* synthetic */ n(LogoActivity logoActivity, e eVar) {
            this(logoActivity);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1364535693, "Lcom/baidu/tieba/LogoActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1364535693, "Lcom/baidu/tieba/LogoActivity;");
                return;
            }
        }
        DOWNLOAD_DIR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/";
    }

    public LogoActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mBgBitmap = null;
        this.mIsFirstUse = false;
        this.mIsFirstOnResume = true;
        this.adCreateStartTime = -1L;
        this.adReqeustStartTime = -1L;
        this.mGoto = -1;
        this.isAdDismiss = false;
        this.isActivityInForeground = true;
        this.mPrivacyPolicyDialogGuideClickTimes = 0;
        this.isLaunchOpOn = AdToMainTabActivitySwitch.getIsOn();
        this.mAdSource = 0;
        this.mShowAdInternal = 0L;
        this.mShowADEndRunnable = new n(this, null);
        this.hasLoadBesFinish = false;
        this.uniqueId = -1L;
        this.mTbAdCallback = new e(this);
        this.logoCreateTime = -1L;
        this.mVideoSplashCallback = new f(this);
        this.splashClickListener = new g(this, 2016311);
        this.mNightInstallListener = new h(this, 2921608);
        this.mFirstLogoAniRunnable = new i(this);
        this.mNormalLogoAniRunnable = new j(this);
        this.mRequirTimeOutRunnable = new k(this);
        this.mTimeOutRunnable = new l(this);
        this.mTbTimeOutRunnable = new m(this);
        this.mListener = new b(this);
    }

    public static /* synthetic */ int access$2708(LogoActivity logoActivity) {
        int i2 = logoActivity.mPrivacyPolicyDialogGuideClickTimes;
        logoActivity.mPrivacyPolicyDialogGuideClickTimes = i2 + 1;
        return i2;
    }

    private void dealIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65573, this, intent) == null) || intent == null) {
            return;
        }
        if (intent.getBooleanExtra("from_short_cut", false)) {
            LogoActivityConfig.mFromSpacial = true;
            Intent intent2 = new Intent();
            intent2.putExtra(DealIntentService.KEY_CLASS, 2);
            intent2.putExtra("fname", intent.getStringExtra("fname"));
            intent2.putExtra("from_short_cut", true);
            intent2.putExtra("back_special", true);
            intent2.putExtra("from", "short_cut");
            intent.putExtra(LogoActivityConfig.EXTRAINTENT, intent2);
        }
        TbadkCoreApplication.setIntent((Intent) intent.getParcelableExtra(LogoActivityConfig.EXTRAINTENT));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteApkFile() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            File file = new File(FileHelper.getCacheDir());
            if (!file.isDirectory() || (listFiles = file.listFiles(new d(this))) == null || listFiles.length <= 0) {
                return;
            }
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    public static void deleteH5File() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65575, null) == null) {
            String str = DOWNLOAD_DIR + "bdtbWCache";
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                FileHelper.deleteFileOrDir(new File(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToNextPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65576, this) == null) {
            if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
                this.needGoNext = true;
                return;
            }
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            c.a.d.f.m.h.a().b(new a(this));
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
            if (runTask == null || StringUtils.isNull((String) runTask.getData())) {
                return;
            }
            gotoMainTabInternal(2);
        }
    }

    private void gotoMainTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65577, this, i2) == null) {
            this.mGoto = i2;
            showVideoSplash();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoMainTabInternal(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65578, this, i2) == null) {
            MainTabActivityConfig createNormalCfg = new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i2);
            if (TbSingleton.getInstance().getFirstOpenScheme() != null) {
                createNormalCfg.getIntent().setData(TbSingleton.getInstance().getFirstOpenScheme());
                TbSingleton.getInstance().setFirstOpenScheme(null);
            }
            sendMessage(new CustomMessage(2015002, createNormalCfg));
            finish();
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", LogoActivity.class.getSimpleName()).param("obj_param1", 4));
        }
    }

    private void init(Bundle bundle) {
        long currentTimeMillis;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, this, bundle) == null) {
            long currentTimeMillis2 = System.currentTimeMillis();
            try {
                registerListener(this.mNightInstallListener);
                if (!isFromHotSplash() && (isTaskRoot() || isFromShortcut())) {
                    dealIntent(getIntent());
                }
                if (!PermissionUtil.isAgreePrivacyPolicy() && !TbSingleton.getInstance().isBrowseMode()) {
                    c.a.s0.s.s.a b2 = o.b(getPageContext(), this.mListener);
                    this.mPrivacyPolicyDialogRemind = b2;
                    b2.show();
                    SmartLaunchStats.onPrivacyDialogShow();
                    c.a.t0.r3.f.a.b("1");
                    return;
                }
                sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
                if (isFromHotSplash()) {
                    getWindow().setFlags(1024, 1024);
                    if (Build.VERSION.SDK_INT > 16) {
                        getWindow().getDecorView().setSystemUiVisibility(ARPMessageType.MSG_TYPE_VIDEO_STOP_RES);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016560));
                    setContentView(R.layout.logo_activity);
                    this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                    LogoActivityConfig.isFirst = true;
                    registerListener(this.splashClickListener);
                    this.mGoto = -2;
                    statSplashRequest();
                    showTbSplash();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                } else if (!isTaskRoot() && !isFromShortcut()) {
                    finish();
                } else {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.HOST_START).param("obj_param1", 2).param(TiebaStatic.Params.OBJ_PARAM2, TbadkCoreApplication.getInst().getStartType()).param(TiebaStatic.Params.OBJ_PARAM3, TbadkCoreApplication.getInst().getCanShowSplash()));
                    TbadkCoreApplication.getInst().onLowMemory();
                    if (!TbadkCoreApplication.isLogin()) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2005015, null));
                    }
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
                    this.mIsFirstUse = TbadkCoreApplication.getInst().getIsFirstUse();
                    c.a.s0.s0.l.b().A(this.mIsFirstUse);
                    registerListener(this.splashClickListener);
                    syncAccountAndStart();
                    this.mHandler.sendMessage(this.mHandler.obtainMessage());
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", "start");
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
            } finally {
                TTIStats.record("LogoActivity.init", System.currentTimeMillis() - currentTimeMillis2);
            }
        }
    }

    private void initializationApp() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65580, this) == null) && this.mIsFirstUse) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            c.a.s0.s.h0.b.k().u("frs_first_in", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFromHotSplash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65581, this)) == null) ? getIntent().getBooleanExtra(SpeedStatsUtils.UBC_VALUE_SPLASH, false) : invokeV.booleanValue;
    }

    private boolean isFromShortcut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65582, this)) == null) {
            Intent intent = getIntent();
            boolean booleanExtra = intent.getBooleanExtra("from_short_cut", false);
            if (booleanExtra) {
                String stringExtra = intent.getStringExtra("fname");
                if (!StringUtils.isNull(stringExtra)) {
                    TiebaStatic.log(new StatisticItem("c11897").param("fname", stringExtra));
                }
            }
            return booleanExtra;
        }
        return invokeV.booleanValue;
    }

    private boolean judgeLocationPermissionGranted(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, this, iArr)) == null) {
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
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showADEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65584, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_VIEW_END_STAMP_KEY);
            startGoto();
            c.a.s0.s0.l.b().l(System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showADView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65585, this) == null) {
            if (SwitchManager.getInstance().findType(AdSdkSwitch.KEY_AD_SDK_SWITCH) == 0) {
                showNormalAniView();
            } else if (MessageManager.getInstance().findTask(2016555) == null) {
                showNormalAniView();
            } else {
                showBesAdView();
            }
        }
    }

    private void showBesAdView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65586, this) == null) {
            this.adCreateStartTime = System.currentTimeMillis();
            this.adReqeustStartTime = System.currentTimeMillis();
            this.besAdData = new c.a.s0.l.d(isFromHotSplash(), this.uniqueId);
            this.besSplashHolder = new RelativeLayout(getPageContext().getPageActivity());
            this.besSplashHolder.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.mRootView.addView(this.besSplashHolder);
            this.besAdData.f(this.besSplashHolder);
            this.besAdData.e(new c(this));
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016555, Long.class, this.besAdData);
            c.a.s0.s0.l.b().j(System.currentTimeMillis() - this.adCreateStartTime);
            c.a.d.f.m.e.a().postDelayed(this.mRequirTimeOutRunnable, runTask != null ? ((Long) runTask.getData()).longValue() : 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalAniView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65587, this) == null) {
            if (this.mGoto == -2) {
                finish();
            } else {
                c.a.d.f.m.e.a().post(this.mNormalLogoAniRunnable);
            }
        }
    }

    private void showTbSplash() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65588, this) == null) {
            this.adCreateStartTime = System.currentTimeMillis();
            SpeedStatsManager.getInstance().addStatsTimeStamp(SpeedStatsStampTable.AD_START_STAMP_KEY);
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, c.a.s0.b1.a.class, getActivity());
            if (runTask != null && runTask.getData() != null) {
                c.a.s0.b1.a aVar = (c.a.s0.b1.a) runTask.getData();
                this.mTbAdController = aVar;
                aVar.b(this.mTbAdCallback);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_locate", 2).param("obj_type", "a064"));
                int l2 = c.a.s0.s.h0.b.k().l("video_splash_timeout", 1);
                c.a.d.f.m.e.a().postDelayed(this.mTbTimeOutRunnable, (l2 > 0 ? l2 : 1) * 1000);
                this.mTbAdController.a();
                c.a.s0.s0.l.b().j(System.currentTimeMillis() - this.adCreateStartTime);
                return;
            }
            showADView();
        }
    }

    private void showVideoSplash() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65589, this) == null) {
            statSplashRequest();
            if (this.mGoto != -2) {
                if (this.mVideoSplashController == null) {
                    this.mVideoSplashController = new c.a.t0.r3.g.f(this);
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
    }

    private void startApp(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65590, this, context) == null) {
            initializationApp();
            if (LogoActivityConfig.mFromSpacial) {
                gotoMainTab(2);
                LogoActivityConfig.mFromSpacial = false;
            } else if (TbadkCoreApplication.isLogin()) {
                if (this.mIsFirstUse) {
                    c.a.d.f.m.e.a().post(this.mFirstLogoAniRunnable);
                } else {
                    gotoMainTab(2);
                }
            } else if (this.mIsFirstUse) {
                c.a.d.f.m.e.a().post(this.mFirstLogoAniRunnable);
            } else {
                showVideoSplash();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGoto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65591, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SPLASH_GOTO_MAIN_TAB).param("obj_locate", LogoActivity.class.getSimpleName()).param("obj_param1", 3).param(TiebaStatic.Params.OBJ_PARAM2, this.mGoto));
            SpeedStatsManager.getInstance().addStatsTimeStamp(3006);
            int i2 = this.mGoto;
            if (i2 >= 0) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001281, String.class);
                if (runTask == null || StringUtils.isNull((String) runTask.getData())) {
                    return;
                }
                LogoActivityConfig.isFirst = false;
                gotoMainTabInternal(this.mGoto);
            } else if (i2 != -2) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001281, String.class);
                if (runTask2 == null || StringUtils.isNull((String) runTask2.getData())) {
                    return;
                }
                gotoMainTabInternal(2);
            } else {
                finish();
            }
        }
    }

    private void startSwitchDebugService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65592, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000996, new c.a.d.b.a.b(getPageContext().getPageActivity())));
        }
    }

    private void statSplashRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65593, this) == null) {
            boolean isNeedBearAd = TbadkCoreApplication.getInst().isNeedBearAd(c.a.s0.s.h0.b.k().l("splash_ad_strategy_key", 0));
            StatisticItem.make(TbadkCoreStatisticKey.REQUEST_AD_TIME).param("obj_type", "a064").param("tid", isNeedBearAd ? 1 : 0).param("pid", c.a.s0.s.h0.b.k().l("splash_origin_ad_strategy_key", 1) != 0 ? 1 : 0).param("obj_param1", isFromHotSplash() ? 2 : 1).param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis()).param("fid", this.uniqueId).eventStat();
        }
    }

    private void syncAccountAndStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65594, this) == null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                c.a.s0.s.b0.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
                if (!getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                    c.a.s0.s.b0.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                    TbadkCoreApplication.setCurrentAccount(c.a.s0.s.l.c.e(), getPageContext().getPageActivity());
                }
            }
            startApp(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, c.a.s0.q0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a064" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public c.a.s0.q0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.s0.q0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.r(this.mAdSource);
            }
            return pageStayDurationItem;
        }
        return (c.a.s0.q0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (!this.isLaunchOpOn && i3 == -1 && i2 == 16001) {
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
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        c.a.s0.l.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            if (this.isLaunchOpOn) {
                return;
            }
            c.a.s0.b1.a aVar = this.mTbAdController;
            if (aVar != null && aVar.getView() != null && this.mTbAdController.getView().getParent() != null) {
                boolean z = false;
                if (this.mTbAdController.getView() != null) {
                    if (this.mTbAdController.getView().getHeight() == c.a.d.f.p.n.i(getPageContext().getPageActivity())) {
                        z = true;
                    }
                }
                int k2 = c.a.d.f.p.n.k(getPageContext().getPageActivity());
                int i2 = c.a.d.f.p.n.i(getPageContext().getPageActivity());
                if (!z) {
                    i2 = (int) (c.a.d.f.p.n.i(getPageContext().getPageActivity()) * 0.8125d);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTbAdController.getView().getLayoutParams();
                layoutParams.width = k2;
                layoutParams.height = i2;
                this.mTbAdController.getView().setLayoutParams(layoutParams);
            }
            c.a.s0.l.d dVar = this.besAdData;
            if (dVar == null || (bVar = dVar.f12850c) == null) {
                return;
            }
            bVar.a();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            this.mTriggerSafeModeStatus = c.a.s0.s.f0.a.q().i(this);
            SpeedStatsManager.getInstance().addStatsTimeStamp(3000);
            if (this.isLaunchOpOn) {
                setIsAddSwipeBackLayout(false);
                setUseStyleImmersiveSticky(false);
                super.onCreate(bundle);
                c.a.t0.m mVar = new c.a.t0.m(this);
                this.newLogoDelegate = mVar;
                mVar.d(bundle);
                SpeedStatsManager.getInstance().addStatsTimeStamp(3001);
                return;
            }
            getWindow().getDecorView().setBackgroundResource(R.drawable.pic_splash_logo);
            long currentTimeMillis = System.currentTimeMillis();
            this.logoCreateTime = currentTimeMillis;
            this.uniqueId = currentTimeMillis;
            setIsAddSwipeBackLayout(false);
            setUseStyleImmersiveSticky(false);
            super.onCreate(bundle);
            if (this.mTriggerSafeModeStatus == 2) {
                return;
            }
            if ("MuMu".equals(Build.MODEL) && "6.0.1".equals(Build.VERSION.RELEASE)) {
                finish();
                return;
            }
            c.a.t0.v3.c.g().i(getUniqueId());
            init(bundle);
            TbadkCoreApplication.getInst().initTrackConfig();
            SpeedStatsManager.getInstance().addStatsTimeStamp(3001);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(3004);
            super.onDestroy();
            if (this.isLaunchOpOn) {
                this.newLogoDelegate.e();
                SpeedStatsManager.getInstance().addStatsTimeStamp(3005);
                return;
            }
            c.a.s0.l.d dVar = this.besAdData;
            if (dVar != null) {
                dVar.f(null);
                this.besAdData.e(null);
            }
            c.a.s0.b1.a aVar = this.mTbAdController;
            if (aVar != null) {
                aVar.release();
            }
            c.a.d.f.m.e.a().removeCallbacks(this.mShowADEndRunnable);
            c.a.d.f.m.e.a().removeCallbacks(this.mFirstLogoAniRunnable);
            c.a.d.f.m.e.a().removeCallbacks(this.mNormalLogoAniRunnable);
            c.a.d.f.m.e.a().removeCallbacks(this.mTimeOutRunnable);
            c.a.d.f.m.e.a().removeCallbacks(this.mRequirTimeOutRunnable);
            c.a.d.f.m.e.a().removeCallbacks(this.mTbTimeOutRunnable);
            c.a.t0.r3.g.f fVar = this.mVideoSplashController;
            if (fVar != null) {
                fVar.n();
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
            c.a.t0.v3.c.g().k(getUniqueId());
            c.a.d.f.p.f.d().b();
            MessageManager.getInstance().runTask(2921555, (Class) null);
            c.a.s0.s.s.a aVar2 = this.mPrivacyPolicyDialogRemind;
            if (aVar2 != null) {
                aVar2.dismiss();
            }
            c.a.s0.s.s.a aVar3 = this.mPrivacyPolicyDialogGuideOne;
            if (aVar3 != null) {
                aVar3.dismiss();
            }
            c.a.s0.s.s.a aVar4 = this.mPrivacyPolicyDialogGuideTwo;
            if (aVar4 != null) {
                aVar4.dismiss();
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(3005);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048585, this, i2, keyEvent)) == null) {
            if (i2 == 4 && LogoActivityConfig.isFirst) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            if (this.isLaunchOpOn) {
                return;
            }
            this.isActivityInForeground = false;
            c.a.t0.r3.g.f fVar = this.mVideoSplashController;
            if (fVar != null) {
                fVar.o();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048587, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (!this.isLaunchOpOn && i2 == 22001) {
                judgeLocationPermissionGranted(iArr);
                c.a.d.f.i.a.n().j(false);
                goToNextPage();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            SpeedStatsManager.getInstance().addStatsTimeStamp(3002);
            super.onResume();
            if (this.mTriggerSafeModeStatus == 2) {
                return;
            }
            if (this.isLaunchOpOn) {
                this.newLogoDelegate.f();
                return;
            }
            this.isActivityInForeground = true;
            if (this.mIsFirstOnResume) {
                this.mIsFirstOnResume = false;
                MessageManager.getInstance().registerStickyMode(2001370);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
                if (System.currentTimeMillis() - c.a.s0.s.h0.b.k().m("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    TbadkCoreApplication.getInst().setInstalledAppIds(c.a.s0.s.h0.b.k().q("applist_intalled_apk_ids", ""));
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
                SpeedStatsManager.getInstance().addStatsTimeStamp(3003);
                return;
            }
            if (this.needGoNext) {
                goToNextPage();
                this.needGoNext = false;
            }
            c.a.t0.r3.g.f fVar = this.mVideoSplashController;
            if (fVar != null) {
                fVar.p();
            }
            if (LogoActivityConfig.isFirst && this.logoCreateTime >= 0) {
                c.a.s0.s0.l.b().w(System.currentTimeMillis() - this.logoCreateTime);
            }
            SpeedStatsManager.getInstance().addStatsTimeStamp(3003);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean("is_first", LogoActivityConfig.isFirst);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onStart();
        }
    }
}
