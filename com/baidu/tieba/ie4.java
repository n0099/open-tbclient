package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.ve4;
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
public class ie4 extends yd4<bw2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements ve4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bw2 a;
        public final /* synthetic */ vv2 b;

        public a(ie4 ie4Var, bw2 bw2Var, vv2 vv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ie4Var, bw2Var, vv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bw2Var;
            this.b = vv2Var;
        }

        @Override // com.baidu.tieba.ve4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                m62.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947850609, "Lcom/baidu/tieba/ie4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947850609, "Lcom/baidu/tieba/ie4;");
                return;
            }
        }
        boolean z = wp1.a;
    }

    public ie4() {
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

    public static ie4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new ie4();
        }
        return (ie4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.yd4
    /* renamed from: d */
    public boolean b(Context context, bw2 bw2Var, vv2 vv2Var, m93 m93Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bw2Var, vv2Var, m93Var, jSONObject)) == null) {
            return f(context, bw2Var, vv2Var, m93Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, bw2 bw2Var, vv2 vv2Var, m93 m93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, bw2Var, vv2Var, m93Var)) == null) {
            m62.i("map", "TranslateMarkerAction start");
            uv1 A = zu2.U().A(bw2Var.c);
            if (!(A instanceof sv1)) {
                m62.c("map", "WebViewManager is null");
                return false;
            }
            we4 d = vd4.b().c((sv1) A).d(bw2Var.b);
            if (d == null) {
                m62.c("map", "can not find map by id " + bw2Var.b);
                return false;
            }
            return g(bw2Var, d, vv2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(bw2 bw2Var, we4 we4Var, vv2 vv2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, bw2Var, we4Var, vv2Var)) == null) {
            if (!bw2Var.isValid()) {
                return false;
            }
            fw2 fw2Var = bw2Var.A;
            LatLng latLng = new LatLng(fw2Var.a, fw2Var.b);
            List<ve4> I = we4Var.I(bw2Var.z);
            m62.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (ve4 ve4Var : I) {
                    ve4Var.c(we4Var, latLng, bw2Var, new a(this, bw2Var, vv2Var));
                }
            }
            m62.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
