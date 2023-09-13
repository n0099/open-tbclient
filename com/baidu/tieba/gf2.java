package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.df2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public final class gf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public df2 a;
    public ef2 b;
    public ConcurrentHashMap<String, PrefetchEvent> c;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PrefetchEvent a;
        public final /* synthetic */ gf2 b;

        public a(gf2 gf2Var, PrefetchEvent prefetchEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf2Var, prefetchEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gf2Var;
            this.a = prefetchEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.b.e(this.a);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements df2.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PrefetchEvent a;
        public final /* synthetic */ gf2 b;

        public b(gf2 gf2Var, PrefetchEvent prefetchEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gf2Var, prefetchEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gf2Var;
            this.a = prefetchEvent;
        }

        @Override // com.baidu.tieba.df2.e
        public void a(g83 g83Var, PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, g83Var, pMSAppInfo) == null) {
                this.b.b.b(this.a, g83Var, pMSAppInfo);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final gf2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-777719145, "Lcom/baidu/tieba/gf2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-777719145, "Lcom/baidu/tieba/gf2$c;");
                    return;
                }
            }
            a = new gf2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947791926, "Lcom/baidu/tieba/gf2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947791926, "Lcom/baidu/tieba/gf2;");
                return;
            }
        }
        d = rr1.a;
    }

    public static gf2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return c.a;
        }
        return (gf2) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.clear();
        }
    }

    public gf2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new ConcurrentHashMap<>();
        this.a = new df2();
        this.b = new ef2();
    }

    public /* synthetic */ gf2(a aVar) {
        this();
    }

    public void c(PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, prefetchEvent) != null) || prefetchEvent == null) {
            return;
        }
        this.c.put(j32.a(prefetchEvent.appId), prefetchEvent);
    }

    public final void e(PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, prefetchEvent) == null) {
            this.a.g(prefetchEvent, new b(this, prefetchEvent));
        }
    }

    public final boolean h(PrefetchEvent prefetchEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, prefetchEvent)) == null) {
            if (!hf2.h() || prefetchEvent == null || !prefetchEvent.isValid() || !TextUtils.equals(prefetchEvent.state, "show")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void f(PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, prefetchEvent) == null) {
            if (d) {
                Log.d("SwanAppPrefetchManager", "fire preloadEvent abSwitch: " + hf2.h());
            }
            if (h(prefetchEvent)) {
                return;
            }
            if (d) {
                Log.d("SwanAppPrefetchManager", "firePrefetchEvent event: " + prefetchEvent);
            }
            ExecutorUtilsExt.postOnSerial(new a(this, prefetchEvent), "prefetch-event-thread");
        }
    }
}
