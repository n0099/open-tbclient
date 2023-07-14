package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c44 implements qx1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, b44> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947624774, "Lcom/baidu/tieba/c44;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947624774, "Lcom/baidu/tieba/c44;");
                return;
            }
        }
        b = fs1.a;
    }

    public c44() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        c();
    }

    @Override // com.baidu.tieba.qx1
    public v32 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull zo2 zo2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, zo2Var)) == null) {
            return b(str, jSONObject, zo2Var);
        }
        return (v32) invokeLLL.objValue;
    }

    public final v32 b(String str, JSONObject jSONObject, zo2 zo2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, zo2Var)) == null) {
            b44 b44Var = this.a.get(str);
            if (b44Var != null) {
                if (b) {
                    Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
                }
                return b44Var.a(jSONObject, zo2Var);
            }
            if (b) {
                Log.i("GameCenterDispatcher", "action has not found: " + str + ", params: " + jSONObject);
            }
            return new v32(10002, "no such api.");
        }
        return (v32) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d(new z34());
            d(new a44());
            d(new x24());
            d(new b34());
            d(new y24());
            d(new q44());
            d(new z24());
            d(new g44());
            d(new n44());
            d(new w24());
            d(new d34());
            d(new a34());
            d(new c34());
            d(new j44());
            d(new p44());
            d(new k44());
            d(new m44());
            d(new l44());
        }
    }

    public void d(b44 b44Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b44Var) == null) {
            if (b && TextUtils.isEmpty(b44Var.a)) {
                throw new IllegalArgumentException("action name is null");
            }
            if (b && this.a.containsKey(b44Var.a)) {
                throw new IllegalArgumentException("duplicate action: " + b44Var);
            }
            this.a.put(b44Var.a, b44Var);
        }
    }
}
