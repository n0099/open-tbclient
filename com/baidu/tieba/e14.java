package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e14 implements ru1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e14 c;
    public transient /* synthetic */ FieldHolder $fh;
    public z04 a;
    public d14 b;

    public e14() {
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

    public static e14 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (e14.class) {
                    if (c == null) {
                        c = new e14();
                    }
                }
            }
            return c;
        }
        return (e14) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new z04();
            this.b = new d14();
        }
    }

    @Override // com.baidu.tieba.ru1
    public w02 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull am2 am2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, am2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, am2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, am2Var);
            }
            return new w02(10001, "authorize fail.");
        }
        return (w02) invokeLLL.objValue;
    }
}
