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
public class f04 implements st1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f04 c;
    public transient /* synthetic */ FieldHolder $fh;
    public a04 a;
    public e04 b;

    public f04() {
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

    public static f04 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (f04.class) {
                    if (c == null) {
                        c = new f04();
                    }
                }
            }
            return c;
        }
        return (f04) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new a04();
            this.b = new e04();
        }
    }

    @Override // com.baidu.tieba.st1
    public xz1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull bl2 bl2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, bl2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, bl2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, bl2Var);
            }
            return new xz1(10001, "authorize fail.");
        }
        return (xz1) invokeLLL.objValue;
    }
}
