package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.Lifecycle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedRuntimeProvider;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.browser.TBWebViewActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.CurrentPageTypeHelper;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.schemeaction.SchemeActionHelper;
import com.baidu.tbadk.mutiprocess.currentpagetype.CurrentPageTypeEvent;
import com.baidu.tbadk.mutiprocess.thirdpartylifecycle.ThirdPartyActivityLifecycleEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class cr4 implements Application.ActivityLifecycleCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, activity, bundle) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;

        public a(cr4 cr4Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cr4Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lm4.E().H(this.a);
            }
        }
    }

    public cr4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, activity) != null) || activity == null) {
            return;
        }
        String name = activity.getClass().getName();
        if (jx4.a().d() && !SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) && !SpeedStats.PUSH_ACTIVITY.equals(name) && !"com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name)) {
            if (SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name)) {
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                    jx4.a().k(true);
                    return;
                } else if (!SchemeActionHelper.isToMaintab(activity.getIntent())) {
                    return;
                }
            }
            jx4.a().h(name);
        }
    }

    public final void b(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) != null) || activity == null) {
            return;
        }
        String name = activity.getClass().getName();
        if (jx4.a().d() && !SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) && !SpeedStats.PUSH_ACTIVITY.equals(name) && !"com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name)) {
            if (SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name)) {
                if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                    jx4.a().l(true);
                    return;
                } else if (!SchemeActionHelper.isToMaintab(activity.getIntent())) {
                    return;
                }
            }
            jx4.a().g(name);
        }
    }

    public final void c(@Nullable Activity activity, @NonNull Lifecycle.Event event) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, event) == null) && activity != null && !BaseActivity.class.isAssignableFrom(activity.getClass()) && !BaseFragmentActivity.class.isAssignableFrom(activity.getClass())) {
            if (TbadkCoreApplication.getInst().isMainProcess(false)) {
                xu4 xu4Var = new xu4();
                xu4Var.a = TbadkCoreApplication.getInst();
                xu4Var.b = activity;
                xu4Var.c = event;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921698, xu4Var));
                return;
            }
            ThirdPartyActivityLifecycleEvent thirdPartyActivityLifecycleEvent = new ThirdPartyActivityLifecycleEvent();
            thirdPartyActivityLifecycleEvent.event = event;
            mc5.i(thirdPartyActivityLifecycleEvent);
        }
    }

    public final void d(Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, activity) != null) || activity == null || !PermissionUtil.isAgreePrivacyPolicy()) {
            return;
        }
        if (activity.getClass().getName().equals(yi.y())) {
            CurrentPageTypeHelper.PageType pageType = CurrentPageTypeHelper.PageType.OTHER;
            if (TBWebViewActivity.class.isAssignableFrom(activity.getClass())) {
                pageType = CurrentPageTypeHelper.PageType.WEB;
            } else if (activity.getClass().getName().contains("SwanAppActivity")) {
                pageType = CurrentPageTypeHelper.PageType.SMART_APP;
            } else if (activity.getClass().getName().contains("FlutterPageActivity")) {
                pageType = CurrentPageTypeHelper.PageType.FLUTTER;
            } else if (activity.getClass().getName().contains("NewSquareSearchActivity")) {
                pageType = CurrentPageTypeHelper.PageType.NATIVE_WEB;
            } else if (BaseActivity.class.isAssignableFrom(activity.getClass()) || BaseFragmentActivity.class.isAssignableFrom(activity.getClass())) {
                pageType = CurrentPageTypeHelper.PageType.NATIVE;
            }
            mc5.i(new CurrentPageTypeEvent(pageType));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, activity, bundle) != null) || activity == null) {
            return;
        }
        oy4.q().w(activity);
        if (oy4.q().v(activity)) {
            return;
        }
        String name = activity.getClass().getName();
        if (!SpeedRuntimeProvider.SPLASH_ACTIVITY_NAME.equals(name) && !SpeedRuntimeProvider.MAIN_ACTIVITY_NAME.equals(name) && ((!"com.baidu.tieba.pb.pb.main.PbActivity".equals(name) && !"com.baidu.tieba.tblauncher.SchemaRouteActivity".equals(name) && !SpeedStats.PUSH_ACTIVITY.equals(name)) || !ix4.a().a)) {
            hc.b().e();
        }
        if (ec5.b().e(name)) {
            ec5.b().a();
        } else if (ec5.b().h(activity)) {
            ec5.b().c();
            if (ec5.b().g(name)) {
                ec5.b().l(true);
            }
        } else if (ec5.b().f(name)) {
            ec5.b().o();
            if (!ec5.b().g(name)) {
                ec5.b().l(false);
            } else {
                ec5.b().l(true);
            }
        }
        ix4.a().e(activity);
        c(activity, Lifecycle.Event.ON_CREATE);
        cw4.i();
        iw4.m(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (activity != null && currentActivity != null && ec5.b().h(activity) && !ec5.b().h(currentActivity)) {
                ec5.b().o();
                if (!ec5.b().g(currentActivity.getClass().getName())) {
                    ec5.b().l(false);
                }
            }
            if (l45.c() != null && activity == l45.c().getActivity()) {
                l45.c().m();
            }
            if (l35.b() != null && activity == l35.b().getActivity()) {
                l35.b().t();
            }
            c(activity, Lifecycle.Event.ON_DESTROY);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, activity) == null) {
            if (activity != null) {
                if (!activity.getClass().getSimpleName().equals("LogoActivity")) {
                    hc.b().a("BdTokenController", new a(this, UtilHelper.isActivityStartFromScheme(activity)));
                }
                String name = activity.getClass().getName();
                if (ec5.b().e(name)) {
                    ec5.b().a();
                } else if (ec5.b().h(activity)) {
                    ec5.b().c();
                    if (ec5.b().g(name)) {
                        ec5.b().l(true);
                    }
                }
            }
            d(activity);
            b(activity);
            a(activity);
            c(activity, Lifecycle.Event.ON_RESUME);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
            c(activity, Lifecycle.Event.ON_PAUSE);
            boolean z = false;
            if (activity.isFinishing()) {
                cw4.i();
                if ((activity instanceof TBWebViewActivity) && activity.getIntent() != null && !TextUtils.isEmpty(activity.getIntent().getStringExtra(WebViewActivityConfig.TAG_WEB_DIALOG_NAME))) {
                    z = true;
                }
                iw4.m(z);
                return;
            }
            iw4.m(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, activity) == null) {
            c(activity, Lifecycle.Event.ON_START);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, activity) == null) {
            TbadkCoreApplication.getInst().setStartType(1);
            oy4.q().x(activity);
            c(activity, Lifecycle.Event.ON_STOP);
        }
    }
}
