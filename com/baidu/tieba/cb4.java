package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.pb4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cb4 extends sa4<vs2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements pb4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vs2 a;
        public final /* synthetic */ ps2 b;

        public a(cb4 cb4Var, vs2 vs2Var, ps2 ps2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb4Var, vs2Var, ps2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vs2Var;
            this.b = ps2Var;
        }

        @Override // com.baidu.tieba.pb4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                g32.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947668980, "Lcom/baidu/tieba/cb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947668980, "Lcom/baidu/tieba/cb4;");
                return;
            }
        }
        boolean z = rm1.a;
    }

    public cb4() {
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

    public static cb4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new cb4();
        }
        return (cb4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sa4
    /* renamed from: d */
    public boolean b(Context context, vs2 vs2Var, ps2 ps2Var, g63 g63Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vs2Var, ps2Var, g63Var, jSONObject)) == null) {
            return f(context, vs2Var, ps2Var, g63Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, vs2 vs2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, vs2Var, ps2Var, g63Var)) == null) {
            g32.i("map", "TranslateMarkerAction start");
            ps1 B = tr2.V().B(vs2Var.c);
            if (!(B instanceof ns1)) {
                g32.c("map", "WebViewManager is null");
                return false;
            }
            qb4 d = pa4.b().c((ns1) B).d(vs2Var.b);
            if (d == null) {
                g32.c("map", "can not find map by id " + vs2Var.b);
                return false;
            }
            return g(vs2Var, d, ps2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(vs2 vs2Var, qb4 qb4Var, ps2 ps2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, vs2Var, qb4Var, ps2Var)) == null) {
            if (!vs2Var.isValid()) {
                return false;
            }
            zs2 zs2Var = vs2Var.A;
            LatLng latLng = new LatLng(zs2Var.a, zs2Var.b);
            List<pb4> K = qb4Var.K(vs2Var.z);
            g32.i("map", "TranslateMarkerAction animation start");
            if (K != null) {
                for (pb4 pb4Var : K) {
                    pb4Var.c(qb4Var, latLng, vs2Var, new a(this, vs2Var, ps2Var));
                }
            }
            g32.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
