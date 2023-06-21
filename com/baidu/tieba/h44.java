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
public class h44 implements ux1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h44 c;
    public transient /* synthetic */ FieldHolder $fh;
    public c44 a;
    public g44 b;

    public h44() {
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

    public static h44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (h44.class) {
                    if (c == null) {
                        c = new h44();
                    }
                }
            }
            return c;
        }
        return (h44) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new c44();
            this.b = new g44();
        }
    }

    @Override // com.baidu.tieba.ux1
    public z32 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull dp2 dp2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, dp2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, dp2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, dp2Var);
            }
            return new z32(10001, "authorize fail.");
        }
        return (z32) invokeLLL.objValue;
    }
}
