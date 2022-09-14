package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class hx2 implements rh3<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean b = true;
    public static int c = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(hx2 hx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sg3.Y();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947839015, "Lcom/baidu/tieba/hx2;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947839015, "Lcom/baidu/tieba/hx2;");
        }
    }

    public hx2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
    }

    public final void b(@NonNull HybridUbcFlow hybridUbcFlow) {
        UbcFlowEvent g;
        UbcFlowEvent a2;
        UbcFlowEvent a3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) || (g = hybridUbcFlow.g("na_first_meaningful_paint")) == null) {
            return;
        }
        l92 l92Var = (l92) hybridUbcFlow.k("fmp_data_record");
        if ("fmp_callback".equals(this.a)) {
            String name = hx2.class.getName();
            Log.d(name, "Current Record FMP - " + g.a + ":" + g.g());
            if (l92Var == null || (a3 = l92Var.a()) == null) {
                return;
            }
            String name2 = hx2.class.getName();
            Log.d(name2, "First Page Record FMP - " + a3.a + ":" + a3.g());
        } else if ("callback_on_submit".equals(this.a)) {
            String name3 = hx2.class.getName();
            Log.d(name3, "Real Report FMP - " + g.a + ":" + g.g());
            if (l92Var == null || (a2 = l92Var.a()) == null) {
                return;
            }
            String name4 = hx2.class.getName();
            Log.d(name4, "First Page Report FMP - " + a2.a + ":" + a2.g());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rh3
    /* renamed from: c */
    public synchronized void a(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hybridUbcFlow) == null) {
            synchronized (this) {
                if (b) {
                    if (c == -1) {
                        fm2.g0().getSwitch("swan_next_env_delay", 600);
                        c = 600;
                    }
                    sg3.b0(new a(this), c);
                }
                if (ij1.a) {
                    String name = getClass().getName();
                    Log.d(name, "enable=" + b + ", delay=" + c);
                }
                if ("fmp_callback".equals(this.a)) {
                    b = false;
                } else if ("callback_on_submit".equals(this.a)) {
                    b = true;
                }
                if (ij1.a && hybridUbcFlow != null) {
                    b(hybridUbcFlow);
                }
            }
        }
    }
}
