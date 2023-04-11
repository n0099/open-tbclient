package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class b22 extends a12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DashPathEffect a;

    public b22() {
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

    @Override // com.baidu.tieba.a12
    public void a(b12 b12Var, Canvas canvas) {
        DashPathEffect dashPathEffect;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, b12Var, canvas) == null) && (dashPathEffect = this.a) != null) {
            b12Var.c.setPathEffect(dashPathEffect);
        }
    }

    @Override // com.baidu.tieba.a12
    public void b(JSONArray jSONArray) {
        float[] fArr;
        JSONArray optJSONArray;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            int i = 0;
            if (jSONArray.length() > 0 && (optJSONArray = jSONArray.optJSONArray(0)) != null && (length = optJSONArray.length()) > 0) {
                fArr = new float[length];
                for (int i2 = 0; i2 < length; i2++) {
                    fArr[i2] = ll3.g((float) optJSONArray.optDouble(i2));
                }
            } else {
                fArr = null;
            }
            if (jSONArray.length() > 1) {
                i = ll3.g((float) jSONArray.optDouble(1));
            }
            if (fArr != null && i >= 0) {
                this.a = new DashPathEffect(fArr, i);
            }
        }
    }
}
