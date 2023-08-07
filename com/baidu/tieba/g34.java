package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g34 implements tw1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g34 c;
    public transient /* synthetic */ FieldHolder $fh;
    public b34 a;
    public f34 b;

    public g34() {
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

    public static g34 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (g34.class) {
                    if (c == null) {
                        c = new g34();
                    }
                }
            }
            return c;
        }
        return (g34) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new b34();
            this.b = new f34();
        }
    }

    @Override // com.baidu.tieba.tw1
    public y22 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull co2 co2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, co2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, co2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, co2Var);
            }
            return new y22(10001, "authorize fail.");
        }
        return (y22) invokeLLL.objValue;
    }
}
