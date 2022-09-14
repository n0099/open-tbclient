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
public class gv3 implements to1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gv3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public bv3 a;
    public fv3 b;

    public gv3() {
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

    public static gv3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (gv3.class) {
                    if (c == null) {
                        c = new gv3();
                    }
                }
            }
            return c;
        }
        return (gv3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.to1
    public yu1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull cg2 cg2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, cg2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, cg2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, cg2Var);
            }
            return new yu1(10001, "authorize fail.");
        }
        return (yu1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new bv3();
            this.b = new fv3();
        }
    }
}
