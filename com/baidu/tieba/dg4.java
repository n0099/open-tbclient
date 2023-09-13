package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.model.LatLng;
import com.baidu.tieba.qg4;
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
public class dg4 extends tf4<wx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements qg4.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wx2 a;
        public final /* synthetic */ qx2 b;

        public a(dg4 dg4Var, wx2 wx2Var, qx2 qx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dg4Var, wx2Var, qx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wx2Var;
            this.b = qx2Var;
        }

        @Override // com.baidu.tieba.qg4.b
        public void onAnimationEnd() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!TextUtils.isEmpty(this.a.y)) {
                    this.b.c(this.a.y, null);
                }
                h82.i("map", "TranslateMarkerAction animation end");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947703576, "Lcom/baidu/tieba/dg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947703576, "Lcom/baidu/tieba/dg4;");
                return;
            }
        }
        boolean z = rr1.a;
    }

    public dg4() {
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

    public static dg4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new dg4();
        }
        return (dg4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tf4
    /* renamed from: d */
    public boolean b(Context context, wx2 wx2Var, qx2 qx2Var, hb3 hb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, wx2Var, qx2Var, hb3Var, jSONObject)) == null) {
            return f(context, wx2Var, qx2Var, hb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final boolean f(Context context, wx2 wx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, wx2Var, qx2Var, hb3Var)) == null) {
            h82.i("map", "TranslateMarkerAction start");
            px1 A = uw2.T().A(wx2Var.c);
            if (!(A instanceof nx1)) {
                h82.c("map", "WebViewManager is null");
                return false;
            }
            rg4 d = qf4.b().c((nx1) A).d(wx2Var.b);
            if (d == null) {
                h82.c("map", "can not find map by id " + wx2Var.b);
                return false;
            }
            return g(wx2Var, d, qx2Var);
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean g(wx2 wx2Var, rg4 rg4Var, qx2 qx2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, wx2Var, rg4Var, qx2Var)) == null) {
            if (!wx2Var.isValid()) {
                return false;
            }
            ay2 ay2Var = wx2Var.A;
            LatLng latLng = new LatLng(ay2Var.a, ay2Var.b);
            List<qg4> I = rg4Var.I(wx2Var.z);
            h82.i("map", "TranslateMarkerAction animation start");
            if (I != null) {
                for (qg4 qg4Var : I) {
                    qg4Var.c(rg4Var, latLng, wx2Var, new a(this, wx2Var, qx2Var));
                }
            }
            h82.i("map", "TranslateMarkerAction end");
            return true;
        }
        return invokeLLL.booleanValue;
    }
}
