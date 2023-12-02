package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bj4 extends sh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public bj4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.sh4, com.baidu.tieba.vh4
    public void b(JSONObject jSONObject, fe4 fe4Var, @Nullable fe4 fe4Var2, @Nullable fe4 fe4Var3) {
        JSONObject optJSONObject;
        yi4 a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048576, this, jSONObject, fe4Var, fe4Var2, fe4Var3) == null) && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("base_info")) != null && (a = yi4.a(optJSONObject)) != null) {
            zi4.e().i(a);
            zi4.e().j(a.k);
        }
    }
}
