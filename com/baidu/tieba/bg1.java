package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.payment.PaymentManager;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes5.dex */
public class bg1 implements dg1 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.dg1
    public void i(Activity activity, JSONObject jSONObject, yf1 yf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, activity, jSONObject, yf1Var) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947643901, "Lcom/baidu/tieba/bg1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947643901, "Lcom/baidu/tieba/bg1;");
                return;
            }
        }
        a = SchemeConfig.getSchemeHead() + "://swan/";
    }

    public bg1() {
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

    @Override // com.baidu.tieba.dg1
    public void a(Activity activity, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, activity, str, str2) == null) {
            ku2.S().a(activity, str, str2);
        }
    }

    @Override // com.baidu.tieba.dg1
    public void aLiAuth(Activity activity, String str, kg1<JSONObject> kg1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, str, kg1Var) == null) {
            ku2.S().f(activity, str, kg1Var);
        }
    }

    @Override // com.baidu.tieba.dg1
    public void c(Activity activity, String str, yf1 yf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, activity, str, yf1Var) == null) {
            ku2.S().c(activity, str, yf1Var);
        }
    }

    @Override // com.baidu.tieba.dg1
    public void d(Context context, JSONObject jSONObject, yf1 yf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, context, jSONObject, yf1Var) == null) {
            ku2.S().d(context, jSONObject, yf1Var);
        }
    }

    @Override // com.baidu.tieba.dg1
    public void e(Activity activity, String str, yf1 yf1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, activity, str, yf1Var) == null) {
            ku2.S().e(activity, str, yf1Var);
        }
    }

    @Override // com.baidu.tieba.dg1
    public boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            return ku2.S().b(context);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.dg1
    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            r33.b().a = str;
        }
    }

    @Override // com.baidu.tieba.dg1
    public String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, context)) == null) {
            return ku2.G0().a(context);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dg1
    public void f(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, context, jSONObject) == null) {
            if (jSONObject == null) {
                PaymentManager.i(3, "支付信息不能为空");
                return;
            }
            String optString = jSONObject.optString("appKey");
            String optString2 = jSONObject.optString("redirectUrl");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                SchemeRouter.invoke(context, a + optString + optString2);
                return;
            }
            PaymentManager.i(3, "支付信息不能为空");
        }
    }

    @Override // com.baidu.tieba.dg1
    public void g(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            String str = r33.b().a;
            if (TextUtils.isEmpty(str)) {
                vf1.a(bundle);
                return;
            }
            t73 e = t73.e();
            v73 v73Var = new v73(119, bundle);
            v73Var.c(str);
            v73Var.p(true);
            e.h(v73Var);
        }
    }
}
