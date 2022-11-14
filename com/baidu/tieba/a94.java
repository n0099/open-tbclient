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
/* loaded from: classes3.dex */
public class a94 extends r84<tq2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
        boolean z = pk1.a;
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
    @Override // com.baidu.tieba.r84
    /* renamed from: d */
    public boolean b(Context context, tq2 tq2Var, oq2 oq2Var, f43 f43Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, tq2Var, oq2Var, f43Var, jSONObject)) == null) {
            return g(context, tq2Var, oq2Var, f43Var);
        }
        return invokeLLLLL.booleanValue;
    }

    public final Bundle f(tq2 tq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tq2Var)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("slaveId", tq2Var.c);
            bundle.putDouble("latitude", tq2Var.j.a);
            bundle.putDouble("longitude", tq2Var.j.b);
            bundle.putDouble("scale", tq2Var.k);
            bundle.putString("name", tq2Var.z);
            bundle.putString("address", tq2Var.A);
            bundle.putStringArrayList("ignoredApps", tq2Var.B);
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public final boolean g(Context context, tq2 tq2Var, oq2 oq2Var, f43 f43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, context, tq2Var, oq2Var, f43Var)) == null) {
            f12.i("map", "OpenLocationAction start");
            if (!tq2Var.isValid()) {
                f12.c("map", "model is invalid");
                return false;
            }
            m94.r3(f(tq2Var)).v3();
            f12.i("map", "OpenLocationAction end");
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
