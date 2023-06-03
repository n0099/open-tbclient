package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g44 implements tx1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g44 c;
    public transient /* synthetic */ FieldHolder $fh;
    public b44 a;
    public f44 b;

    public g44() {
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

    public static g44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (g44.class) {
                    if (c == null) {
                        c = new g44();
                    }
                }
            }
            return c;
        }
        return (g44) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new b44();
            this.b = new f44();
        }
    }

    @Override // com.baidu.tieba.tx1
    public y32 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull cp2 cp2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, cp2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, cp2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, cp2Var);
            }
            return new y32(10001, "authorize fail.");
        }
        return (y32) invokeLLL.objValue;
    }
}
