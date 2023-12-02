package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.tb4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gb4 extends wa4<zs2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements tb4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zs2 a;
        public final /* synthetic */ ts2 b;

        public a(gb4 gb4Var, zs2 zs2Var, ts2 ts2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb4Var, zs2Var, ts2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zs2Var;
            this.b = ts2Var;
        }

        @Override // com.baidu.tieba.tb4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                k32.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947788144, "Lcom/baidu/tieba/gb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947788144, "Lcom/baidu/tieba/gb4;");
                return;
            }
        }
        boolean z = vm1.a;
    }

    public gb4() {
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

    public static gb4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new gb4();
        }
        return (gb4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wa4
    /* renamed from: d */
    public boolean b(Context context, zs2 zs2Var, ts2 ts2Var, k63 k63Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, zs2Var, ts2Var, k63Var, jSONObject)) == null) {
            return f(context, zs2Var, ts2Var, k63Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, zs2 zs2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, zs2Var, ts2Var, k63Var)) == null) {
            k32.i("map", "TranslateMarkerAction start");
            ts1 B = xr2.V().B(zs2Var.c);
            if (!(B instanceof rs1)) {
                k32.c("map", "WebViewManager is null");
                return false;
            }
            ub4 d = ta4.b().c((rs1) B).d(zs2Var.b);
            if (d == null) {
                k32.c("map", "can not find map by id " + zs2Var.b);
                return false;
            }
            return g(zs2Var, d, ts2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(zs2 zs2Var, ub4 ub4Var, ts2 ts2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, zs2Var, ub4Var, ts2Var)) == null) {
            if (!zs2Var.isValid()) {
                return false;
            }
            dt2 dt2Var = zs2Var.A;
            LatLng latLng = new LatLng(dt2Var.a, dt2Var.b);
            List<tb4> K = ub4Var.K(zs2Var.z);
            k32.i("map", "TranslateMarkerAction animation start");
            if (K != null) {
                for (tb4 tb4Var : K) {
                    tb4Var.c(ub4Var, latLng, zs2Var, new a(this, zs2Var, ts2Var));
                }
            }
            k32.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
