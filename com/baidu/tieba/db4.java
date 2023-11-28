package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.qb4;
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
public class db4 extends ta4<ws2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements qb4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ws2 a;
        public final /* synthetic */ qs2 b;

        public a(db4 db4Var, ws2 ws2Var, qs2 qs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {db4Var, ws2Var, qs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ws2Var;
            this.b = qs2Var;
        }

        @Override // com.baidu.tieba.qb4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                h32.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947698771, "Lcom/baidu/tieba/db4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947698771, "Lcom/baidu/tieba/db4;");
                return;
            }
        }
        boolean z = sm1.a;
    }

    public db4() {
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

    public static db4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new db4();
        }
        return (db4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ta4
    /* renamed from: d */
    public boolean b(Context context, ws2 ws2Var, qs2 qs2Var, h63 h63Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ws2Var, qs2Var, h63Var, jSONObject)) == null) {
            return f(context, ws2Var, qs2Var, h63Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, ws2 ws2Var, qs2 qs2Var, h63 h63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, ws2Var, qs2Var, h63Var)) == null) {
            h32.i("map", "TranslateMarkerAction start");
            qs1 B = ur2.V().B(ws2Var.c);
            if (!(B instanceof os1)) {
                h32.c("map", "WebViewManager is null");
                return false;
            }
            rb4 d = qa4.b().c((os1) B).d(ws2Var.b);
            if (d == null) {
                h32.c("map", "can not find map by id " + ws2Var.b);
                return false;
            }
            return g(ws2Var, d, qs2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(ws2 ws2Var, rb4 rb4Var, qs2 qs2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, ws2Var, rb4Var, qs2Var)) == null) {
            if (!ws2Var.isValid()) {
                return false;
            }
            at2 at2Var = ws2Var.A;
            LatLng latLng = new LatLng(at2Var.a, at2Var.b);
            List<qb4> K = rb4Var.K(ws2Var.z);
            h32.i("map", "TranslateMarkerAction animation start");
            if (K != null) {
                for (qb4 qb4Var : K) {
                    qb4Var.c(rb4Var, latLng, ws2Var, new a(this, ws2Var, qs2Var));
                }
            }
            h32.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
