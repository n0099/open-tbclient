package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.v84;
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
public class i84 extends y74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements v84.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bq2 a;
        public final /* synthetic */ vp2 b;

        public a(i84 i84Var, bq2 bq2Var, vp2 vp2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i84Var, bq2Var, vp2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bq2Var;
            this.b = vp2Var;
        }

        @Override // com.baidu.tieba.v84.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                m02.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947807364, "Lcom/baidu/tieba/i84;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947807364, "Lcom/baidu/tieba/i84;");
                return;
            }
        }
        boolean z = wj1.a;
    }

    public i84() {
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

    public static i84 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new i84();
        }
        return (i84) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y74
    /* renamed from: d */
    public boolean b(Context context, bq2 bq2Var, vp2 vp2Var, m33 m33Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bq2Var, vp2Var, m33Var, jSONObject)) == null) {
            return f(context, bq2Var, vp2Var, m33Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, bq2 bq2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, bq2Var, vp2Var, m33Var)) == null) {
            m02.i("map", "TranslateMarkerAction start");
            up1 A = zo2.U().A(bq2Var.c);
            if (!(A instanceof sp1)) {
                m02.c("map", "WebViewManager is null");
                return false;
            }
            w84 d = v74.b().c((sp1) A).d(bq2Var.b);
            if (d == null) {
                m02.c("map", "can not find map by id " + bq2Var.b);
                return false;
            }
            return g(bq2Var, d, vp2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(bq2 bq2Var, w84 w84Var, vp2 vp2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, bq2Var, w84Var, vp2Var)) == null) {
            if (!bq2Var.isValid()) {
                return false;
            }
            fq2 fq2Var = bq2Var.A;
            LatLng latLng = new LatLng(fq2Var.a, fq2Var.b);
            List<v84> I = w84Var.I(bq2Var.z);
            m02.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (v84 v84Var : I) {
                    v84Var.c(w84Var, latLng, bq2Var, new a(this, bq2Var, vp2Var));
                }
            }
            m02.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
