package com.baidu.tieba;

import android.graphics.Canvas;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class a62 extends n42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v42 a;

    public a62() {
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

    @Override // com.baidu.tieba.n42
    public void a(o42 o42Var, Canvas canvas) {
        v42 v42Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, o42Var, canvas) == null) && (v42Var = this.a) != null && v42Var.d()) {
            if (this.a.c()) {
                o42Var.c.setShader(this.a.b());
                return;
            }
            o42Var.m = this.a.a();
            o42Var.c.setColor(this.a.a());
            o42Var.b.setShader(null);
        }
    }

    @Override // com.baidu.tieba.n42
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) && jSONArray.length() > 0) {
            this.a = new v42(jSONArray);
        }
    }
}
