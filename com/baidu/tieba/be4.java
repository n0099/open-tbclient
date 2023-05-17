package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class be4 extends sd4<uv2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947642072, "Lcom/baidu/tieba/be4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947642072, "Lcom/baidu/tieba/be4;");
                return;
            }
        }
        boolean z = qp1.a;
    }

    public be4() {
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

    public static be4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new be4();
        }
        return (be4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sd4
    /* renamed from: d */
    public boolean b(Context context, uv2 uv2Var, pv2 pv2Var, g93 g93Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, uv2Var, pv2Var, g93Var, jSONObject)) == null) {
            return g(context, uv2Var, pv2Var, g93Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final Bundle f(uv2 uv2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, uv2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", uv2Var.c);
            bundle.putDouble("latitude", uv2Var.j.a);
            bundle.putDouble("longitude", uv2Var.j.b);
            bundle.putDouble("scale", uv2Var.k);
            bundle.putString("name", uv2Var.z);
            bundle.putString("address", uv2Var.A);
            bundle.putStringArrayList("ignoredApps", uv2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, uv2 uv2Var, pv2 pv2Var, g93 g93Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, uv2Var, pv2Var, g93Var)) == null) {
            g62.i("map", "OpenLocationAction start");
            if (!uv2Var.isValid()) {
                g62.c("map", "model is invalid");
                return false;
            }
            ne4.u3(f(uv2Var)).y3();
            g62.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
