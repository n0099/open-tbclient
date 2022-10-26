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
/* loaded from: classes4.dex */
public class h84 extends y74 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
        boolean z = wj1.a;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new h84();
        }
        return (h84) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.y74
    /* renamed from: d */
    public boolean b(Context context, aq2 aq2Var, vp2 vp2Var, m33 m33Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aq2Var, vp2Var, m33Var, jSONObject)) == null) {
            return g(context, aq2Var, vp2Var, m33Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final Bundle f(aq2 aq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aq2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", aq2Var.c);
            bundle.putDouble("latitude", aq2Var.j.a);
            bundle.putDouble("longitude", aq2Var.j.b);
            bundle.putDouble("scale", aq2Var.k);
            bundle.putString("name", aq2Var.z);
            bundle.putString("address", aq2Var.A);
            bundle.putStringArrayList("ignoredApps", aq2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, aq2 aq2Var, vp2 vp2Var, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, aq2Var, vp2Var, m33Var)) == null) {
            m02.i("map", "OpenLocationAction start");
            if (!aq2Var.isValid()) {
                m02.c("map", "model is invalid");
                return false;
            }
            t84.r3(f(aq2Var)).v3();
            m02.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
