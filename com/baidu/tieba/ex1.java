package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Rect;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class ex1 extends sw1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect a;

    public ex1() {
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

    @Override // com.baidu.tieba.sw1
    public void a(tw1 tw1Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, tw1Var, canvas) == null) && this.a != null) {
            int alpha = tw1Var.b.getAlpha();
            tw1Var.c(tw1Var.b);
            canvas.drawRect(this.a, tw1Var.b);
            tw1Var.b.setAlpha(alpha);
        }
    }

    @Override // com.baidu.tieba.sw1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 4) {
                    int g = dh3.g((float) jSONArray.optDouble(0));
                    int g2 = dh3.g((float) jSONArray.optDouble(1));
                    this.a = new Rect(g, g2, dh3.g((float) jSONArray.optDouble(2)) + g, dh3.g((float) jSONArray.optDouble(3)) + g2);
                }
            } catch (Exception e) {
                if (wj1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
