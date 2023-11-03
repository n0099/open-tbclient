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
public class bb4 extends sa4<us2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947639189, "Lcom/baidu/tieba/bb4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947639189, "Lcom/baidu/tieba/bb4;");
                return;
            }
        }
        boolean z = rm1.a;
    }

    public bb4() {
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

    public static bb4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new bb4();
        }
        return (bb4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.sa4
    /* renamed from: d */
    public boolean b(Context context, us2 us2Var, ps2 ps2Var, g63 g63Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, us2Var, ps2Var, g63Var, jSONObject)) == null) {
            return g(context, us2Var, ps2Var, g63Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final Bundle f(us2 us2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, us2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", us2Var.c);
            bundle.putDouble("latitude", us2Var.j.a);
            bundle.putDouble("longitude", us2Var.j.b);
            bundle.putDouble("scale", us2Var.k);
            bundle.putString("name", us2Var.z);
            bundle.putString("address", us2Var.A);
            bundle.putStringArrayList("ignoredApps", us2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, us2 us2Var, ps2 ps2Var, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, us2Var, ps2Var, g63Var)) == null) {
            g32.i("map", "OpenLocationAction start");
            if (!us2Var.isValid()) {
                g32.c("map", "model is invalid");
                return false;
            }
            nb4.y3(f(us2Var)).C3();
            g32.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
