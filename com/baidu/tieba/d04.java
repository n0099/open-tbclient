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
public class d04 implements qt1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d04 c;
    public transient /* synthetic */ FieldHolder $fh;
    public yz3 a;
    public c04 b;

    public d04() {
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

    public static d04 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (d04.class) {
                    if (c == null) {
                        c = new d04();
                    }
                }
            }
            return c;
        }
        return (d04) invokeV.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new yz3();
            this.b = new c04();
        }
    }

    @Override // com.baidu.tieba.qt1
    public vz1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull zk2 zk2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, zk2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, zk2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, zk2Var);
            }
            return new vz1(10001, "authorize fail.");
        }
        return (vz1) invokeLLL.objValue;
    }
}
