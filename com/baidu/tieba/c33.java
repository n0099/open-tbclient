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
/* loaded from: classes5.dex */
public class c33 implements rp3<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements a33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UbcFlowEvent a;
        public final /* synthetic */ UbcFlowEvent b;
        public final /* synthetic */ c33 c;

        public a(c33 c33Var, UbcFlowEvent ubcFlowEvent, UbcFlowEvent ubcFlowEvent2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c33Var, ubcFlowEvent, ubcFlowEvent2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c33Var;
            this.a = ubcFlowEvent;
            this.b = ubcFlowEvent2;
        }

        @Override // com.baidu.tieba.a33
        public boolean a(d33 d33Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d33Var)) == null) {
                if (d33Var == null) {
                    return false;
                }
                return this.c.c(d33Var, this.a, this.b);
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947623782, "Lcom/baidu/tieba/c33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947623782, "Lcom/baidu/tieba/c33;");
                return;
            }
        }
        a = ir1.a;
    }

    public c33() {
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
        b33.f().g();
        if (a) {
            Log.d("MaUpdateReporter", "MaUpdateReporter init - " + System.currentTimeMillis());
        }
    }

    public final boolean c(@NonNull d33 d33Var, @NonNull UbcFlowEvent ubcFlowEvent, @NonNull UbcFlowEvent ubcFlowEvent2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d33Var, ubcFlowEvent, ubcFlowEvent2)) == null) {
            long b = d33Var.b();
            if (b >= ubcFlowEvent.g() && b <= ubcFlowEvent2.g()) {
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.rp3
    /* renamed from: d */
    public void a(HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hybridUbcFlow) == null) {
            if (a) {
                Log.i("MaUpdateReporter", "report: flow=" + hybridUbcFlow);
            }
            if (hybridUbcFlow == null) {
                return;
            }
            UbcFlowEvent g = hybridUbcFlow.g("naStart");
            UbcFlowEvent g2 = hybridUbcFlow.g("na_first_meaningful_paint");
            if (g != null && g2 != null) {
                b33.f().h(new a(this, g, g2));
                b33.f().a(hybridUbcFlow);
                if (a) {
                    Log.d("MaUpdateReporter", "na_start ts - " + g.g());
                    Log.d("MaUpdateReporter", "fmp_end ts - " + g2.g());
                    return;
                }
                return;
            }
            if (a) {
                if (g == null) {
                    Log.w("MaUpdateReporter", "MaUpdateReporter: na_start = null !!!");
                } else {
                    Log.w("MaUpdateReporter", "MaUpdateReporter: na_first_meaningful_paint = null !!!");
                }
            }
            b33.f().c();
        }
    }
}
