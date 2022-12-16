package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.n94;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a94 extends q84<tq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements n94.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tq2 a;
        public final /* synthetic */ nq2 b;

        public a(a94 a94Var, tq2 tq2Var, nq2 nq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a94Var, tq2Var, nq2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tq2Var;
            this.b = nq2Var;
        }

        @Override // com.baidu.tieba.n94.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                e12.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947569997, "Lcom/baidu/tieba/a94;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947569997, "Lcom/baidu/tieba/a94;");
                return;
            }
        }
        boolean z = ok1.a;
    }

    public a94() {
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

    public static a94 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new a94();
        }
        return (a94) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.q84
    /* renamed from: d */
    public boolean b(Context context, tq2 tq2Var, nq2 nq2Var, e43 e43Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, tq2Var, nq2Var, e43Var, jSONObject)) == null) {
            return f(context, tq2Var, nq2Var, e43Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, tq2 tq2Var, nq2 nq2Var, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, tq2Var, nq2Var, e43Var)) == null) {
            e12.i("map", "TranslateMarkerAction start");
            mq1 A = rp2.U().A(tq2Var.c);
            if (!(A instanceof kq1)) {
                e12.c("map", "WebViewManager is null");
                return false;
            }
            o94 d = n84.b().c((kq1) A).d(tq2Var.b);
            if (d == null) {
                e12.c("map", "can not find map by id " + tq2Var.b);
                return false;
            }
            return g(tq2Var, d, nq2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(tq2 tq2Var, o94 o94Var, nq2 nq2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, tq2Var, o94Var, nq2Var)) == null) {
            if (!tq2Var.isValid()) {
                return false;
            }
            xq2 xq2Var = tq2Var.A;
            LatLng latLng = new LatLng(xq2Var.a, xq2Var.b);
            List<n94> I = o94Var.I(tq2Var.z);
            e12.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (n94 n94Var : I) {
                    n94Var.c(o94Var, latLng, tq2Var, new a(this, tq2Var, nq2Var));
                }
            }
            e12.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
