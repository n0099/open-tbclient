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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.appsearchlib.NASLib;
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
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.switchs.AdSdkSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.y3.d;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
@SuppressLint({"HandlerLeak"})
/* loaded from: classes3.dex */
public class LogoActivity extends BaseActivity<LogoActivity> {
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
    public d.a.p0.l.d besAdData;
    public ViewGroup besSplashHolder;
    public boolean hasLoadBesFinish;
    public boolean isActivityInForeground;
    public boolean isAdDismiss;
    public long logoCreateTime;
    public int mAdSource;
    public Bitmap mBgBitmap;
    public Runnable mFirstLogoAniRunnable;
    public int mGoto;
    public boolean mIsFirstOnResume;
    public boolean mIsFirstUse;
    public View.OnClickListener mListener;
    public Runnable mNormalLogoAniRunnable;
    public int mPrivacyPolicyDialogGuideClickTimes;
    public d.a.p0.s.s.a mPrivacyPolicyDialogGuideOne;
    public d.a.p0.s.s.a mPrivacyPolicyDialogGuideTwo;
    public d.a.p0.s.s.a mPrivacyPolicyDialogRemind;
    public Runnable mRequirTimeOutRunnable;
    public RelativeLayout mRootView;
    public m mShowADEndRunnable;
    public long mShowAdInternal;
    public d.a.p0.y0.b mTbAdCallback;
    public d.a.p0.y0.a mTbAdController;
    public Runnable mTbTimeOutRunnable;
    public Runnable mTimeOutRunnable;
    public d.g mVideoSplashCallback;
    public d.a.q0.y3.d mVideoSplashController;
    public View mVideoSplashView;
    public boolean needGoNext;
    public CustomMessageListener splashClickListener;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f13686e;

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
            this.f13686e = logoActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                int id = view.getId();
                if (id == R.id.private_yes || id == R.id.yesBtn) {
                    if (this.f13686e.mPrivacyPolicyDialogRemind != null && this.f13686e.mPrivacyPolicyDialogRemind.isShowing()) {
                        this.f13686e.mPrivacyPolicyDialogRemind.dismiss();
                        d.a.q0.g.a("1", "1");
                    }
                    if (this.f13686e.mPrivacyPolicyDialogGuideOne != null && this.f13686e.mPrivacyPolicyDialogGuideOne.isShowing()) {
                        this.f13686e.mPrivacyPolicyDialogGuideOne.dismiss();
                        d.a.q0.g.a("2", "1");
                    }
                    if (this.f13686e.mPrivacyPolicyDialogGuideTwo != null && this.f13686e.mPrivacyPolicyDialogGuideTwo.isShowing()) {
                        this.f13686e.mPrivacyPolicyDialogGuideTwo.dismiss();
                        d.a.q0.g.a("3", "1");
                    }
                    PermissionUtil.setIsAgreePrivacyPolicy(true);
                    d.a.p0.s.d0.b.j().w("key_first_enter_app_timestamp", System.currentTimeMillis());
                    this.f13686e.goToNextPage();
                } else if (id == R.id.private_no) {
                    if (this.f13686e.mPrivacyPolicyDialogRemind.isShowing()) {
                        this.f13686e.mPrivacyPolicyDialogRemind.dismiss();
                        d.a.q0.g.a("1", "2");
                    }
                    if (this.f13686e.mPrivacyPolicyDialogGuideOne == null) {
                        LogoActivity logoActivity = this.f13686e;
                        logoActivity.mPrivacyPolicyDialogGuideOne = d.a.q0.j.a(logoActivity.getPageContext(), this.f13686e.mListener, R.string.privacy_policy_guide_one, R.string.secret_hint_no_agree);
                    }
                    this.f13686e.mPrivacyPolicyDialogGuideOne.show();
                    d.a.q0.g.b("2");
                } else if (id == R.id.browseBtn) {
                    LogoActivity.access$2508(this.f13686e);
                    if (this.f13686e.mPrivacyPolicyDialogGuideOne.isShowing()) {
                        this.f13686e.mPrivacyPolicyDialogGuideOne.dismiss();
                        d.a.q0.g.a("2", "2");
                        if (this.f13686e.mPrivacyPolicyDialogGuideTwo == null) {
                            LogoActivity logoActivity2 = this.f13686e;
                            logoActivity2.mPrivacyPolicyDialogGuideTwo = d.a.q0.j.a(logoActivity2.getPageContext(), this.f13686e.mListener, R.string.privacy_policy_guide_two, R.string.secret_hint_browser_exit);
                            this.f13686e.mPrivacyPolicyDialogGuideTwo.show();
                            d.a.q0.g.b("3");
                        }
                    }
                    if (this.f13686e.mPrivacyPolicyDialogGuideTwo.isShowing() && this.f13686e.mPrivacyPolicyDialogGuideClickTimes == 2) {
                        this.f13686e.mPrivacyPolicyDialogGuideTwo.dismiss();
                        d.a.q0.g.a("3", "2");
                        this.f13686e.finish();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.p0.l.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f13687a;

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
            this.f13687a = logoActivity;
        }

        @Override // d.a.p0.l.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f13687a.hasLoadBesFinish = true;
                this.f13687a.mRootView.removeView(this.f13687a.besSplashHolder);
                this.f13687a.showNormalAniView();
                d.a.p0.o0.l.b().k(System.currentTimeMillis() - this.f13687a.adReqeustStartTime);
            }
        }

        @Override // d.a.p0.l.a
        public void b(boolean z, boolean z2, int i2, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), str, str2}) == null) {
                this.f13687a.overridePendingTransition(0, 0);
                this.f13687a.isAdDismiss = true;
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_CLICK);
                statisticItem.param("obj_type", z2 ? 2 : 1).param("obj_source", i2);
                if (str != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_TO, str);
                }
                if (str2 != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                }
                TiebaStatic.log(statisticItem);
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK);
                statisticItem2.param("obj_source", i2).param("obj_type", "a030").param("obj_locate", 0);
                TiebaStatic.log(statisticItem2);
                StatisticItem statisticItem3 = new StatisticItem("common_click");
                statisticItem3.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
                if (z) {
                    statisticItem3.param("obj_type", z2 ? 4 : 3);
                } else {
                    statisticItem3.param("obj_type", z2 ? 2 : 1);
                }
                d.a.q0.g3.c.g().c(this.f13687a.getUniqueId(), statisticItem3);
            }
        }

        @Override // d.a.p0.l.a
        public void c(boolean z, boolean z2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
                this.f13687a.hasLoadBesFinish = true;
                this.f13687a.mAdSource = i2;
                if (this.f13687a.mShowAdInternal > 0) {
                    d.a.p0.s.z.a.a("homePage", -1L, 0, "logo_splash", 0, "", "internal", Long.valueOf(System.currentTimeMillis() - this.f13687a.mShowAdInternal));
                }
                d.a.d.e.m.e.a().removeCallbacks(this.f13687a.mRequirTimeOutRunnable);
                d.a.d.e.m.e.a().removeCallbacks(this.f13687a.mTimeOutRunnable);
                if (z2) {
                    this.f13687a.mRootView.setBackgroundDrawable(null);
                }
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STATISTICS_MOBADS_SHOW).param("obj_type", z2 ? 2 : 1).param("obj_source", i2));
                StatisticItem statisticItem = new StatisticItem("common_exp");
                statisticItem.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", i2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
                if (z) {
                    statisticItem.param("obj_type", z2 ? 4 : 3);
                } else {
                    statisticItem.param("obj_type", z2 ? 2 : 1);
                }
                d.a.q0.g3.c.g().d(this.f13687a.getUniqueId(), "bes_ad_id", statisticItem);
                d.a.q0.g3.c.g().h(this.f13687a.getUniqueId(), false);
                if (this.f13687a.mGoto == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this.f13687a));
                }
                d.a.p0.o0.l.b().m(System.currentTimeMillis());
                d.a.p0.o0.l.b().k(System.currentTimeMillis() - this.f13687a.adReqeustStartTime);
            }
        }

        @Override // d.a.p0.l.a
        public void onAdDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f13687a.isAdDismiss = true;
                if (this.f13687a.isActivityInForeground) {
                    this.f13687a.showADEnd();
                }
            }
        }

        @Override // d.a.p0.l.a
        public void onLpClosed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements FileFilter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f13688a;

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
            this.f13688a = logoActivity;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                String name = file.getName();
                return !TextUtils.isEmpty(name) && name.contains(this.f13688a.getPageContext().getString(R.string.app_name)) && name.endsWith(".apk");
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.p0.y0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f13689a;

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
            this.f13689a = logoActivity;
        }

        @Override // d.a.p0.y0.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_type", "a064").param(TiebaStatic.Params.RESOURCE_ID, 0).param("obj_locate", 1));
                d.a.d.e.m.e.a().removeCallbacks(this.f13689a.mTbTimeOutRunnable);
                this.f13689a.showADView();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x009d  */
        @Override // d.a.p0.y0.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(String str, boolean z) {
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z) == null) {
                if (this.f13689a.mTbAdController.getView() != null) {
                    if (this.f13689a.mTbAdController.getView().getHeight() == d.a.d.e.p.l.i(this.f13689a.getPageContext().getPageActivity())) {
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
                        d.a.q0.g3.c.g().c(this.f13689a.getUniqueId(), statisticItem);
                        this.f13689a.overridePendingTransition(0, 0);
                        this.f13689a.showADEnd();
                    }
                }
                z2 = false;
                TiebaStatic.log(new StatisticItem("c13332").param("obj_id", str).param("obj_type", !z2 ? 2 : 1));
                StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 2).param("obj_type", "a030").param("obj_locate", 0).eventStat();
                StatisticItem statisticItem2 = new StatisticItem("common_click");
                statisticItem2.param("page_type", "a030").param(TiebaStatic.Params.OBJ_ISAD, 1).param("obj_id", str).param(TiebaStatic.Params.OBJ_FLOOR, 1).param("obj_source", 2).param(TiebaStatic.Params.OBJ_AD_LOCATE, 16);
                if (!z) {
                }
                d.a.q0.g3.c.g().c(this.f13689a.getUniqueId(), statisticItem2);
                this.f13689a.overridePendingTransition(0, 0);
                this.f13689a.showADEnd();
            }
        }

        @Override // d.a.p0.y0.b
        public void c(String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                d.a.d.e.m.e.a().removeCallbacks(this.f13689a.mTbTimeOutRunnable);
                if (this.f13689a.mTbAdController.getView() == null) {
                    this.f13689a.showADEnd();
                    return;
                }
                int k = d.a.d.e.p.l.k(this.f13689a.getPageContext().getPageActivity());
                int i2 = d.a.d.e.p.l.i(this.f13689a.getPageContext().getPageActivity());
                if (!z2) {
                    i2 = (int) (d.a.d.e.p.l.i(this.f13689a.getPageContext().getPageActivity()) * 0.8125d);
                }
                this.f13689a.mTbAdController.getView().setLayoutParams(new RelativeLayout.LayoutParams(k, i2));
                this.f13689a.mRootView.addView(this.f13689a.mTbAdController.getView());
                if (this.f13689a.mGoto == -2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016522, this.f13689a));
                }
                d.a.p0.o0.l.b().m(System.currentTimeMillis());
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
                d.a.q0.g3.c.g().d(this.f13689a.getUniqueId(), str, statisticItem);
                d.a.q0.g3.c.g().h(this.f13689a.getUniqueId(), false);
            }
        }

        @Override // d.a.p0.y0.b
        public void onAdDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f13689a.isAdDismiss = true;
                if (this.f13689a.isActivityInForeground) {
                    this.f13689a.showADEnd();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements d.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f13690a;

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
            this.f13690a = logoActivity;
        }

        @Override // d.a.q0.y3.d.g
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13690a.showNormalAniView();
            }
        }

        @Override // d.a.q0.y3.d.g
        public void onSkip() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                boolean z = false;
                if (this.f13690a.mTbAdController.getView() != null) {
                    if (this.f13690a.mTbAdController.getView().getHeight() == d.a.d.e.p.l.i(this.f13690a.getPageContext().getPageActivity())) {
                        z = true;
                    }
                }
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_SPLASH_SKIP).param("obj_source", 2).param("obj_type", z ? 4 : 3));
                if (this.f13690a.mGoto != -2) {
                    this.f13690a.startGoto();
                } else {
                    this.f13690a.finish();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f13691a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(LogoActivity logoActivity, int i2) {
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
            this.f13691a = logoActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016311) {
                Object data = customResponsedMessage.getData();
                if (data instanceof String) {
                    String str = (String) data;
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals("advertevent", Uri.parse(str).getScheme())) {
                        if (this.f13691a.isFromHotSplash()) {
                            Intent intent = new Intent();
                            intent.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent.putExtra("jump_url", str);
                            intent.putExtra("is_ad", true);
                            UtilHelper.commenDealIntent(this.f13691a, intent);
                        } else {
                            Intent intent2 = new Intent();
                            intent2.putExtra(DealIntentService.KEY_CLASS, 30);
                            intent2.putExtra("jump_url", str);
                            intent2.putExtra("is_ad", true);
                            TbadkCoreApplication.setIntent(intent2);
                        }
                    }
                    d.a.d.e.m.e.a().removeCallbacks(this.f13691a.mShowADEndRunnable);
                    this.f13691a.isAdDismiss = true;
                    if (this.f13691a.isActivityInForeground || DeviceInfoUtil.isHuaWeiP40Pro()) {
                        this.f13691a.showADEnd();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f13692e;

        public g(LogoActivity logoActivity) {
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
            this.f13692e = logoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13692e.goToNextPage();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f13693e;

        public h(LogoActivity logoActivity) {
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
            this.f13693e = logoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13693e.showADEnd();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f13694e;

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
            this.f13694e = logoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13694e.hasLoadBesFinish) {
                return;
            }
            if (TbadkCoreApplication.getInst().isDebugMode()) {
                Log.d("IAdSdkSplash", "请求time out and switch next");
            }
            d.a.d.e.m.e.a().postDelayed(this.f13694e.mTimeOutRunnable, 500L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2921536, this.f13694e.besAdData));
            this.f13694e.mShowAdInternal = System.currentTimeMillis();
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f13695e;

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
            this.f13695e = logoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f13695e.hasLoadBesFinish || this.f13695e.besSplashHolder == null) {
                return;
            }
            if (TbadkCoreApplication.getInst().isDebugMode()) {
                Log.d("IAdSdkSplash", "兜底time out and jump maintab");
            }
            this.f13695e.mRootView.removeView(this.f13695e.besSplashHolder);
            d.a.d.e.m.e.a().post(this.f13695e.mNormalLogoAniRunnable);
            BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f13696e;

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
            this.f13696e = logoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13696e.showNormalAniView();
                BdStatisticsManager.getInstance().newDebug("VideoSplashTimeOut", 0L, null, "splashTimeOut", "true");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f13697e;

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
            this.f13697e = logoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13697e.deleteApkFile();
                LogoActivity.deleteH5File();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LogoActivity f13698e;

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
            this.f13698e = logoActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13698e.showADEnd();
            }
        }

        public /* synthetic */ m(LogoActivity logoActivity, d dVar) {
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
        this.mAdSource = 0;
        this.mShowAdInternal = 0L;
        this.mShowADEndRunnable = new m(this, null);
        this.hasLoadBesFinish = false;
        this.mTbAdCallback = new d(this);
        this.logoCreateTime = -1L;
        this.mVideoSplashCallback = new e(this);
        this.splashClickListener = new f(this, 2016311);
        this.mFirstLogoAniRunnable = new g(this);
        this.mNormalLogoAniRunnable = new h(this);
        this.mRequirTimeOutRunnable = new i(this);
        this.mTimeOutRunnable = new j(this);
        this.mTbTimeOutRunnable = new k(this);
        this.mListener = new a(this);
    }

    public static /* synthetic */ int access$2508(LogoActivity logoActivity) {
        int i2 = logoActivity.mPrivacyPolicyDialogGuideClickTimes;
        logoActivity.mPrivacyPolicyDialogGuideClickTimes = i2 + 1;
        return i2;
    }

    private void dealIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65571, this, intent) == null) || intent == null) {
            return;
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteApkFile() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65572, this) == null) {
            File file = new File(FileHelper.getCacheDir());
            if (!file.isDirectory() || (listFiles = file.listFiles(new c(this))) == null || listFiles.length <= 0) {
                return;
            }
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    public static void deleteH5File() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65573, null) == null) {
            String str = DOWNLOAD_DIR + QUICK_WEB_VIEW_DIR_NAME;
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                FileHelper.deleteFileOrDir(new File(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToNextPage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65574, this) == null) {
            if (TbadkCoreApplication.getInst().getResumeNum() == 0) {
                this.needGoNext = true;
                return;
            }
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            d.a.d.e.m.h.a().b(new l(this));
            finish();
        }
    }

    private void gotoMainTab(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65575, this, i2) == null) {
            this.mGoto = i2;
            showVideoSplash();
        }
    }

    private void gotoMainTabInternal(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65576, this, i2) == null) {
            LogoActivityConfig.isFirst = false;
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(i2)));
            finish();
        }
    }

    private void init(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65577, this, bundle) == null) {
            if (!PermissionUtil.isAgreePrivacyPolicy() && !TbSingleton.getInstance().isBrowseMode()) {
                d.a.p0.s.s.a b2 = d.a.q0.j.b(getPageContext(), this.mListener);
                this.mPrivacyPolicyDialogRemind = b2;
                b2.show();
                d.a.q0.g.b("1");
                return;
            }
            if (PermissionUtil.checkLocationForGoogle(getActivity())) {
                d.a.d.e.i.a.l().h(false);
            }
            sendMessage(new CustomMessage(2921438, TbadkCoreApplication.getInst().getApp()));
            if (isFromHotSplash()) {
                getWindow().setFlags(1024, 1024);
                if (Build.VERSION.SDK_INT > 16) {
                    getWindow().getDecorView().setSystemUiVisibility(1028);
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
                    getWindow().getDecorView().setSystemUiVisibility(1028);
                }
                setContentView(R.layout.logo_activity);
                this.mRootView = (RelativeLayout) findViewById(R.id.layout_root);
                if (bundle != null) {
                    LogoActivityConfig.isFirst = bundle.getBoolean("is_first", true);
                } else {
                    LogoActivityConfig.isFirst = true;
                }
                this.mIsFirstUse = TbadkCoreApplication.getInst().getIsFirstUse();
                d.a.p0.o0.l.b().A(this.mIsFirstUse);
                registerListener(this.splashClickListener);
                syncAccountAndStart();
                Handler handler = this.mHandler;
                handler.sendMessage(handler.obtainMessage());
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
        }
    }

    private void initializationApp() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65578, this) == null) && this.mIsFirstUse) {
            TbadkSettings.getInst().saveBoolean("first_sync_image_quality", true);
            TbadkCoreApplication.getInst().setIsAbstractOn(0);
            d.a.p0.s.d0.b.j().t("frs_first_in", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isFromHotSplash() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65579, this)) == null) ? getIntent().getBooleanExtra("splash", false) : invokeV.booleanValue;
    }

    private boolean isFromShortcut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, this)) == null) {
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
        return invokeV.booleanValue;
    }

    private boolean judgeLocationPermissionGranted(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, this, iArr)) == null) {
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
        if (interceptable == null || interceptable.invokeV(65582, this) == null) {
            startGoto();
            d.a.p0.o0.l.b().l(System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showADView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65583, this) == null) {
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
        if (interceptable == null || interceptable.invokeV(65584, this) == null) {
            this.adCreateStartTime = System.currentTimeMillis();
            this.adReqeustStartTime = System.currentTimeMillis();
            this.besAdData = new d.a.p0.l.d();
            this.besSplashHolder = new RelativeLayout(getPageContext().getPageActivity());
            this.besSplashHolder.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.mRootView.addView(this.besSplashHolder);
            this.besAdData.d(this.besSplashHolder);
            this.besAdData.c(new b(this));
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2016555, Long.class, this.besAdData);
            d.a.p0.o0.l.b().j(System.currentTimeMillis() - this.adCreateStartTime);
            d.a.d.e.m.e.a().postDelayed(this.mRequirTimeOutRunnable, runTask != null ? ((Long) runTask.getData()).longValue() : 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNormalAniView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65585, this) == null) {
            if (this.mGoto == -2) {
                finish();
            } else {
                d.a.d.e.m.e.a().post(this.mNormalLogoAniRunnable);
            }
        }
    }

    private void showTbSplash() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65586, this) == null) {
            this.adCreateStartTime = System.currentTimeMillis();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921390, d.a.p0.y0.a.class, getActivity());
            if (runTask != null && runTask.getData() != null) {
                d.a.p0.y0.a aVar = (d.a.p0.y0.a) runTask.getData();
                this.mTbAdController = aVar;
                aVar.b(this.mTbAdCallback);
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 2).param("obj_locate", 2).param("obj_type", "a064"));
                this.mTbAdController.a();
                d.a.p0.o0.l.b().j(System.currentTimeMillis() - this.adCreateStartTime);
                int k2 = d.a.p0.s.d0.b.j().k("video_splash_timeout", 1);
                d.a.d.e.m.e.a().postDelayed(this.mTbTimeOutRunnable, (k2 > 0 ? k2 : 1) * 1000);
                return;
            }
            showADView();
        }
    }

    private void showVideoSplash() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65587, this) == null) {
            if (this.mGoto != -2) {
                if (this.mVideoSplashController == null) {
                    this.mVideoSplashController = new d.a.q0.y3.d(this);
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
        if (interceptable == null || interceptable.invokeL(65588, this, context) == null) {
            initializationApp();
            if (LogoActivityConfig.mFromSpacial) {
                gotoMainTab(2);
                LogoActivityConfig.mFromSpacial = false;
            } else if (TbadkCoreApplication.isLogin()) {
                if (this.mIsFirstUse) {
                    d.a.d.e.m.e.a().post(this.mFirstLogoAniRunnable);
                } else {
                    gotoMainTab(2);
                }
            } else if (this.mIsFirstUse) {
                d.a.d.e.m.e.a().post(this.mFirstLogoAniRunnable);
            } else {
                showVideoSplash();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGoto() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65589, this) == null) {
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
    }

    private void startSwitchDebugService() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65590, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2000996, new d.a.d.b.a.b(getPageContext().getPageActivity())));
        }
    }

    private void syncAccountAndStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65591, this) == null) {
            if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
                d.a.p0.s.z.a.a("account", -1L, 0, "logo_activity_uninit_account", 0, "", new Object[0]);
                if (!getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                    d.a.p0.s.z.a.a("account", -1L, 0, "logo_activity_sync_account", 0, "", new Object[0]);
                    TbadkCoreApplication.setCurrentAccount(d.a.p0.s.l.c.e(), getPageContext().getPageActivity());
                }
            }
            startApp(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, d.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "a064" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public d.a.p0.m0.d getPageStayDurationItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            d.a.p0.m0.d pageStayDurationItem = super.getPageStayDurationItem();
            if (pageStayDurationItem != null) {
                pageStayDurationItem.o(this.mAdSource);
            }
            return pageStayDurationItem;
        }
        return (d.a.p0.m0.d) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i2, i3, intent) == null) {
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
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        d.a.p0.l.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            d.a.p0.y0.a aVar = this.mTbAdController;
            if (aVar != null && aVar.getView() != null && this.mTbAdController.getView().getParent() != null) {
                boolean z = false;
                if (this.mTbAdController.getView() != null) {
                    if (this.mTbAdController.getView().getHeight() == d.a.d.e.p.l.i(getPageContext().getPageActivity())) {
                        z = true;
                    }
                }
                int k2 = d.a.d.e.p.l.k(getPageContext().getPageActivity());
                int i2 = d.a.d.e.p.l.i(getPageContext().getPageActivity());
                if (!z) {
                    i2 = (int) (d.a.d.e.p.l.i(getPageContext().getPageActivity()) * 0.8125d);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTbAdController.getView().getLayoutParams();
                layoutParams.width = k2;
                layoutParams.height = i2;
                this.mTbAdController.getView().setLayoutParams(layoutParams);
            }
            d.a.p0.l.d dVar = this.besAdData;
            if (dVar == null || (bVar = dVar.f52711c) == null) {
                return;
            }
            bVar.a();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bundle) == null) {
            getWindow().getDecorView().setBackgroundResource(R.drawable.pic_splash_logo);
            this.logoCreateTime = System.currentTimeMillis();
            setIsAddSwipeBackLayout(false);
            setUseStyleImmersiveSticky(false);
            super.onCreate(bundle);
            d.a.q0.g3.c.g().i(getUniqueId());
            init(bundle);
            TbadkCoreApplication.getInst().initTrackConfig();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.onDestroy();
            d.a.p0.l.d dVar = this.besAdData;
            if (dVar != null) {
                dVar.d(null);
                this.besAdData.c(null);
            }
            d.a.p0.y0.a aVar = this.mTbAdController;
            if (aVar != null) {
                aVar.release();
            }
            d.a.d.e.m.e.a().removeCallbacks(this.mShowADEndRunnable);
            d.a.d.e.m.e.a().removeCallbacks(this.mFirstLogoAniRunnable);
            d.a.d.e.m.e.a().removeCallbacks(this.mNormalLogoAniRunnable);
            d.a.d.e.m.e.a().removeCallbacks(this.mTimeOutRunnable);
            d.a.d.e.m.e.a().removeCallbacks(this.mRequirTimeOutRunnable);
            d.a.d.e.m.e.a().removeCallbacks(this.mTbTimeOutRunnable);
            d.a.q0.y3.d dVar2 = this.mVideoSplashController;
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
            d.a.q0.g3.c.g().k(getUniqueId());
            d.a.d.e.p.d.d().b();
            MessageManager.getInstance().runTask(2921555, (Class) null);
            d.a.p0.s.s.a aVar2 = this.mPrivacyPolicyDialogRemind;
            if (aVar2 != null) {
                aVar2.dismiss();
            }
            d.a.p0.s.s.a aVar3 = this.mPrivacyPolicyDialogGuideOne;
            if (aVar3 != null) {
                aVar3.dismiss();
            }
            d.a.p0.s.s.a aVar4 = this.mPrivacyPolicyDialogGuideTwo;
            if (aVar4 != null) {
                aVar4.dismiss();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, keyEvent)) == null) {
            if (i2 == 4 && LogoActivityConfig.isFirst) {
                return true;
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            this.isActivityInForeground = false;
            d.a.q0.y3.d dVar = this.mVideoSplashController;
            if (dVar != null) {
                dVar.o();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048586, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (i2 == 22001) {
                judgeLocationPermissionGranted(iArr);
                d.a.d.e.i.a.l().h(false);
                goToNextPage();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            this.isActivityInForeground = true;
            if (this.mIsFirstOnResume) {
                this.mIsFirstOnResume = false;
                MessageManager.getInstance().registerStickyMode(2001370);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001370));
                if (System.currentTimeMillis() - d.a.p0.s.d0.b.j().l("applist_intalled_apk_ids_timestamp", 0L) < 86400000) {
                    TbadkCoreApplication.getInst().setInstalledAppIds(d.a.p0.s.d0.b.j().p("applist_intalled_apk_ids", ""));
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
            d.a.q0.y3.d dVar = this.mVideoSplashController;
            if (dVar != null) {
                dVar.p();
            }
            if (!LogoActivityConfig.isFirst || this.logoCreateTime < 0) {
                return;
            }
            d.a.p0.o0.l.b().w(System.currentTimeMillis() - this.logoCreateTime);
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            bundle.putBoolean("is_first", LogoActivityConfig.isFirst);
        }
    }
}
