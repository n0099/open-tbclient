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
public class ht3 implements vm1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ht3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ct3 a;
    public gt3 b;

    public ht3() {
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

    public static ht3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (ht3.class) {
                    if (c == null) {
                        c = new ht3();
                    }
                }
            }
            return c;
        }
        return (ht3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vm1
    public at1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull ee2 ee2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, ee2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, ee2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, ee2Var);
            }
            return new at1(10001, "authorize fail.");
        }
        return (at1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new ct3();
            this.b = new gt3();
        }
    }
}
