package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b04 implements ot1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b04 c;
    public transient /* synthetic */ FieldHolder $fh;
    public wz3 a;
    public a04 b;

    public b04() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }

    public static b04 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (b04.class) {
                    if (c == null) {
                        c = new b04();
                    }
                }
            }
            return c;
        }
        return (b04) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new wz3();
            this.b = new a04();
        }
    }

    @Override // com.baidu.tieba.ot1
    public tz1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull xk2 xk2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, xk2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, xk2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, xk2Var);
            }
            return new tz1(10001, "authorize fail.");
        }
        return (tz1) invokeLLL.objValue;
    }
}
