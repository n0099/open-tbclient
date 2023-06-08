package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class hq8 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<String> a;
    public static Application.ActivityLifecycleCallbacks b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                BdLog.e("activity is " + activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
                BdLog.e("activity is " + activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
                BdLog.e("activity is " + activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
                BdLog.e("activity is " + activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, bundle) == null) {
                BdLog.e("activity is " + activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                BdLog.e("activity is " + activity);
                if (hq8.c(activity) || hq8.d(activity)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016521, activity));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
                BdLog.e("activity is " + activity);
                if ((hq8.c(activity) || hq8.d(activity)) && TbadkCoreApplication.getInst().canSendForegroundMessage()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016520, activity));
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947832474, "Lcom/baidu/tieba/hq8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947832474, "Lcom/baidu/tieba/hq8;");
                return;
            }
        }
        a = Arrays.asList("com.baidu.sapi2.activity.LoginActivity", "com.baidu.sapi2.activity.social.WXLoginActivity");
    }

    public static boolean d(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, activity)) == null) {
            return a.contains(activity.getComponentName().getClassName());
        }
        return invokeL.booleanValue;
    }

    public static void e(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, application) == null) {
            if (b == null) {
                b = new b(null);
            }
            application.registerActivityLifecycleCallbacks(b);
        }
    }

    public static boolean c(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, activity)) == null) {
            String className = activity.getComponentName().getClassName();
            if (!className.contains("AlaMasterLiveRoomActivity") && !className.contains("LivePlayerActivity") && !className.contains("LiveShowActivity") && !className.contains("AlaLiveEndActivity") && !className.contains("LiveListActivity") && !className.contains("BuyTBeanActivity") && !className.contains("YuyinLivePlayerActivity") && !className.contains("YuyinAlaCreateLiveRoomActivity")) {
                if (className.equals("com.baidu.megapp.proxy.activity.ActivityProxy")) {
                    String stringExtra = activity.getIntent().getStringExtra("megapp_extra_target_activity");
                    if (!TextUtils.isEmpty(stringExtra) && (stringExtra.contains("AlaMasterLiveRoomActivity") || stringExtra.contains("LivePlayerActivity") || stringExtra.contains("AlaLiveEndActivity"))) {
                        return true;
                    }
                }
                if (!className.contains("com.yy.mobile") && !className.contains("com.duowan.mobile")) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
