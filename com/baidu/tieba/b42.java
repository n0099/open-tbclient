package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class b42 extends f32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int D;
    public String E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b42() {
        super("coverView", "viewId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.E = "";
    }

    @Override // com.baidu.tieba.f32, com.baidu.tieba.h32, com.baidu.tieba.j32, com.baidu.tieba.sx2
    public void a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.D = jSONObject.optInt("scrollTop");
        JSONObject jSONObject3 = this.j;
        if (jSONObject3 != null) {
            this.E = jSONObject3.optString("overflowY");
        }
        zx2 zx2Var = this.h;
        if (zx2Var != null && (jSONObject2 = this.j) != null) {
            zx2Var.i(jSONObject2.optBoolean("fixed", false));
        }
    }
}
