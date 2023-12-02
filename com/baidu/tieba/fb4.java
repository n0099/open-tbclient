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
public class fb4 extends wa4<ys2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947758353, "Lcom/baidu/tieba/fb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947758353, "Lcom/baidu/tieba/fb4;");
                return;
            }
        }
        boolean z = vm1.a;
    }

    public fb4() {
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

    public static fb4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new fb4();
        }
        return (fb4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wa4
    /* renamed from: d */
    public boolean b(Context context, ys2 ys2Var, ts2 ts2Var, k63 k63Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, ys2Var, ts2Var, k63Var, jSONObject)) == null) {
            return g(context, ys2Var, ts2Var, k63Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final Bundle f(ys2 ys2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ys2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", ys2Var.c);
            bundle.putDouble("latitude", ys2Var.j.a);
            bundle.putDouble("longitude", ys2Var.j.b);
            bundle.putDouble("scale", ys2Var.k);
            bundle.putString("name", ys2Var.z);
            bundle.putString("address", ys2Var.A);
            bundle.putStringArrayList("ignoredApps", ys2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, ys2 ys2Var, ts2 ts2Var, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, ys2Var, ts2Var, k63Var)) == null) {
            k32.i("map", "OpenLocationAction start");
            if (!ys2Var.isValid()) {
                k32.c("map", "model is invalid");
                return false;
            }
            rb4.y3(f(ys2Var)).C3();
            k32.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
