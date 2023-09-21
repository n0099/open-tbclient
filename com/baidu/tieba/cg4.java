package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.pg4;
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
public class cg4 extends sf4<vx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements pg4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vx2 a;
        public final /* synthetic */ px2 b;

        public a(cg4 cg4Var, vx2 vx2Var, px2 px2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cg4Var, vx2Var, px2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vx2Var;
            this.b = px2Var;
        }

        @Override // com.baidu.tieba.pg4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                g82.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947673785, "Lcom/baidu/tieba/cg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947673785, "Lcom/baidu/tieba/cg4;");
                return;
            }
        }
        boolean z = qr1.a;
    }

    public cg4() {
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

    public static cg4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new cg4();
        }
        return (cg4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sf4
    /* renamed from: d */
    public boolean b(Context context, vx2 vx2Var, px2 px2Var, gb3 gb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vx2Var, px2Var, gb3Var, jSONObject)) == null) {
            return f(context, vx2Var, px2Var, gb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, vx2 vx2Var, px2 px2Var, gb3 gb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, vx2Var, px2Var, gb3Var)) == null) {
            g82.i("map", "TranslateMarkerAction start");
            ox1 A = tw2.T().A(vx2Var.c);
            if (!(A instanceof mx1)) {
                g82.c("map", "WebViewManager is null");
                return false;
            }
            qg4 d = pf4.b().c((mx1) A).d(vx2Var.b);
            if (d == null) {
                g82.c("map", "can not find map by id " + vx2Var.b);
                return false;
            }
            return g(vx2Var, d, px2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(vx2 vx2Var, qg4 qg4Var, px2 px2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, vx2Var, qg4Var, px2Var)) == null) {
            if (!vx2Var.isValid()) {
                return false;
            }
            zx2 zx2Var = vx2Var.A;
            LatLng latLng = new LatLng(zx2Var.a, zx2Var.b);
            List<pg4> I = qg4Var.I(vx2Var.z);
            g82.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (pg4 pg4Var : I) {
                    pg4Var.c(qg4Var, latLng, vx2Var, new a(this, vx2Var, px2Var));
                }
            }
            g82.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
