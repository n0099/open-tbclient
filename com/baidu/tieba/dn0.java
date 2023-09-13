package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class dn0 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Activity, Set<Object>> a;
    public static final dn0 b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, activity, bundle) == null) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048580, this, activity, outState) == null) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(outState, "outState");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, activity) == null) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, activity) == null) {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        public a() {
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

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                dn0.b.e(activity);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947710179, "Lcom/baidu/tieba/dn0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947710179, "Lcom/baidu/tieba/dn0;");
                return;
            }
        }
        b = new dn0();
        a = new LinkedHashMap();
        Context b2 = tj0.b();
        if (b2 != null) {
            if (!(b2 instanceof Application)) {
                b2 = null;
            }
            Application application = (Application) b2;
            if (application != null) {
                application.registerActivityLifecycleCallbacks(new a());
            }
        }
    }

    public dn0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final <T extends gn0> void b(Activity activity, Object event, int i, jn0<T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048576, this, activity, event, i, subscriber) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(subscriber, "subscriber");
            fn0.a().c(event, i, subscriber);
            d(activity, subscriber);
        }
    }

    public final <T extends gn0> void c(Activity activity, Object event, jn0<T> subscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, event, subscriber) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(subscriber, "subscriber");
            b(activity, event, 0, subscriber);
        }
    }

    public final void d(Activity activity, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, activity, obj) == null) {
            if (!a.containsKey(activity) || a.get(activity) == null) {
                a.put(activity, new LinkedHashSet());
            }
            Set<Object> set = a.get(activity);
            if (set != null) {
                set.add(obj);
            }
        }
    }

    public final void e(Activity activity) {
        Set<Object> set;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, activity) == null) && (set = a.get(activity)) != null) {
            for (Object obj : set) {
                fn0.a().unregister(obj);
            }
            a.remove(activity);
        }
    }
}
