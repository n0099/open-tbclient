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
public class c04 implements pt1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c04 c;
    public transient /* synthetic */ FieldHolder $fh;
    public xz3 a;
    public b04 b;

    public c04() {
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

    public static c04 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (c04.class) {
                    if (c == null) {
                        c = new c04();
                    }
                }
            }
            return c;
        }
        return (c04) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new xz3();
            this.b = new b04();
        }
    }

    @Override // com.baidu.tieba.pt1
    public uz1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull yk2 yk2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, yk2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, yk2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, yk2Var);
            }
            return new uz1(10001, "authorize fail.");
        }
        return (uz1) invokeLLL.objValue;
    }
}
