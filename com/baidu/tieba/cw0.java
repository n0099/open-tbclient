package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class cw0 {
    public static /* synthetic */ Interceptable $ic;
    public static final cw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public final boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i == 0 : invokeI.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947689037, "Lcom/baidu/tieba/cw0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947689037, "Lcom/baidu/tieba/cw0;");
                return;
            }
        }
        a = new cw0();
    }

    public cw0() {
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

    @JvmStatic
    public static final JSONArray b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            iw0 c = a.c(str);
            if (c != null) {
                JSONArray jSONArray = new JSONArray();
                dw0.a(c, jSONArray);
                bw0.a(c, jSONArray);
                return jSONArray;
            }
            return null;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final iw0 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("version", -1);
                if (!a.a(optInt)) {
                    return null;
                }
                iw0 iw0Var = new iw0();
                iw0Var.e(optInt);
                iw0Var.d(jSONObject.optString("mode"));
                dw0.b(iw0Var, jSONObject);
                bw0.b(iw0Var, jSONObject);
                Unit unit = Unit.INSTANCE;
                return iw0Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (iw0) invokeL.objValue;
    }
}
