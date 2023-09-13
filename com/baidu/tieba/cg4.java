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
public class cg4 extends tf4<vx2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947673785, "Lcom/baidu/tieba/cg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947673785, "Lcom/baidu/tieba/cg4;");
                return;
            }
        }
        boolean z = rr1.a;
    }

    public cg4() {
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

    public static cg4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new cg4();
        }
        return (cg4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tf4
    /* renamed from: d */
    public boolean b(Context context, vx2 vx2Var, qx2 qx2Var, hb3 hb3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, vx2Var, qx2Var, hb3Var, jSONObject)) == null) {
            return g(context, vx2Var, qx2Var, hb3Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final Bundle f(vx2 vx2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vx2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", vx2Var.c);
            bundle.putDouble("latitude", vx2Var.j.a);
            bundle.putDouble("longitude", vx2Var.j.b);
            bundle.putDouble("scale", vx2Var.k);
            bundle.putString("name", vx2Var.z);
            bundle.putString("address", vx2Var.A);
            bundle.putStringArrayList("ignoredApps", vx2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, vx2 vx2Var, qx2 qx2Var, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, vx2Var, qx2Var, hb3Var)) == null) {
            h82.i("map", "OpenLocationAction start");
            if (!vx2Var.isValid()) {
                h82.c("map", "model is invalid");
                return false;
            }
            og4.t3(f(vx2Var)).x3();
            h82.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
