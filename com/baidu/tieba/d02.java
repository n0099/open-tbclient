package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class d02 extends wy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Paint.Align a;

    public d02() {
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
        Paint.Align align;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, xy1Var, canvas) == null) && (align = this.a) != null) {
            xy1Var.e.setTextAlign(align);
        }
    }

    @Override // com.baidu.tieba.wy1
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 0) {
                    String optString = jSONArray.optString(0);
                    if (TextUtils.equals(optString, "left")) {
                        this.a = Paint.Align.LEFT;
                    } else if (TextUtils.equals(optString, "center")) {
                        this.a = Paint.Align.CENTER;
                    } else if (TextUtils.equals(optString, "right")) {
                        this.a = Paint.Align.RIGHT;
                    }
                }
            } catch (Exception e) {
                if (am1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
