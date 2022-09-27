package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.u84;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h84 extends x74<aq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements u84.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aq2 a;
        public final /* synthetic */ up2 b;

        public a(h84 h84Var, aq2 aq2Var, up2 up2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h84Var, aq2Var, up2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aq2Var;
            this.b = up2Var;
        }

        @Override // com.baidu.tieba.u84.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                l02.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947777573, "Lcom/baidu/tieba/h84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947777573, "Lcom/baidu/tieba/h84;");
                return;
            }
        }
        boolean z = vj1.a;
    }

    public h84() {
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

    public static h84 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? new h84() : (h84) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.x74
    /* renamed from: d */
    public boolean b(Context context, aq2 aq2Var, up2 up2Var, l33 l33Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aq2Var, up2Var, l33Var, jSONObject)) == null) ? f(context, aq2Var, up2Var, l33Var) : invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, aq2 aq2Var, up2 up2Var, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, aq2Var, up2Var, l33Var)) == null) {
            l02.i("map", "TranslateMarkerAction start");
            tp1 A = yo2.U().A(aq2Var.c);
            if (!(A instanceof rp1)) {
                l02.c("map", "WebViewManager is null");
                return false;
            }
            v84 d = u74.b().c((rp1) A).d(aq2Var.b);
            if (d == null) {
                l02.c("map", "can not find map by id " + aq2Var.b);
                return false;
            }
            return g(aq2Var, d, up2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(aq2 aq2Var, v84 v84Var, up2 up2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, aq2Var, v84Var, up2Var)) == null) {
            if (aq2Var.isValid()) {
                eq2 eq2Var = aq2Var.A;
                LatLng latLng = new LatLng(eq2Var.a, eq2Var.b);
                List<u84> I = v84Var.I(aq2Var.z);
                l02.i("map", "TranslateMarkerAction animation start");
                if (I != null) {
                    for (u84 u84Var : I) {
                        u84Var.c(v84Var, latLng, aq2Var, new a(this, aq2Var, up2Var));
                    }
                }
                l02.i("map", "TranslateMarkerAction end");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
