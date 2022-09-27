package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bq2 extends xp2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public eq2 z;

    public bq2() {
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

    @Override // com.baidu.tieba.xp2, com.baidu.tieba.bz1, com.baidu.tieba.kt2
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        jSONObject.optString("cb");
        double optDouble = jSONObject.optDouble("latitude");
        double optDouble2 = jSONObject.optDouble("longitude");
        jSONObject.optString("guideKey");
        jSONObject.optString("guideIcon");
        if (Double.isNaN(optDouble) || Double.isNaN(optDouble2) || optDouble < -90.0d || optDouble > 90.0d || optDouble2 < -180.0d || optDouble2 > 180.0d) {
            return;
        }
        eq2 eq2Var = new eq2();
        this.z = eq2Var;
        eq2Var.a(jSONObject);
    }

    @Override // com.baidu.tieba.bz1, com.baidu.tieba.kt2
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.z != null : invokeV.booleanValue;
    }
}
