package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class e32 extends s22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    public e32() {
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

    @Override // com.baidu.tieba.s22
    public void a(t22 t22Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, t22Var, canvas) == null) && this.a != null) {
            int alpha = t22Var.b.getAlpha();
            t22Var.c(t22Var.b);
            canvas.drawRect(this.a, t22Var.b);
            t22Var.b.setAlpha(alpha);
        }
    }

    @Override // com.baidu.tieba.s22
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g = dn3.g((float) jSONArray.optDouble(0));
                    int g2 = dn3.g((float) jSONArray.optDouble(1));
                    this.a = new Rect(g, g2, dn3.g((float) jSONArray.optDouble(2)) + g, dn3.g((float) jSONArray.optDouble(3)) + g2);
                }
            } catch (Exception e) {
                if (wp1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
