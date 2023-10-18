package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Matrix;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class f02 extends wy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public float b;
    public float c;
    public float d;
    public int e;
    public int f;

    public f02() {
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

    @Override // com.baidu.tieba.wy1
    public void a(xy1 xy1Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, xy1Var, canvas) == null) {
            if (xy1Var.a() == 0) {
                xy1Var.b(canvas.save());
            } else {
                canvas.restoreToCount(xy1Var.a());
                xy1Var.b(canvas.save());
            }
            Matrix matrix = new Matrix();
            matrix.setValues(new float[]{this.a, this.c, this.e, this.b, this.d, this.f, 0.0f, 0.0f, 1.0f});
            canvas.concat(matrix);
        }
    }

    @Override // com.baidu.tieba.wy1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() == 6) {
                    this.a = (float) jSONArray.optDouble(0);
                    this.b = (float) jSONArray.optDouble(1);
                    this.c = (float) jSONArray.optDouble(2);
                    this.d = (float) jSONArray.optDouble(3);
                    this.e = gj3.g((float) jSONArray.optDouble(4));
                    this.f = gj3.g((float) jSONArray.optDouble(5));
                }
            } catch (Exception e) {
                if (am1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
