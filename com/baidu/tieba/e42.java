package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class e42 extends b32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String L;
    public boolean M;
    public boolean N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e42() {
        super("input", "viewId");
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
    }

    @Override // com.baidu.tieba.b32, com.baidu.tieba.g32, com.baidu.tieba.i32, com.baidu.tieba.k32, com.baidu.tieba.tx2
    public void a(JSONObject jSONObject) throws JSONException {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        if (this.h == null) {
            this.h = new ay2();
        }
        this.t = jSONObject.optString("value");
        this.L = jSONObject.optString("type");
        boolean z2 = false;
        if (jSONObject.optInt("confirmHold") == 1) {
            z = true;
        } else {
            z = false;
        }
        this.M = z;
        if (jSONObject.optInt("adjustPosition", 1) == 1) {
            z2 = true;
        }
        this.N = z2;
    }
}
