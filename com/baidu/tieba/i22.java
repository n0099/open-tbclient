package com.baidu.tieba;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class i22 extends a12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    public i22() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
    }

    @Override // com.baidu.tieba.a12
    public void a(b12 b12Var, Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, b12Var, canvas) == null) {
            b12Var.k = this.a;
        }
    }

    @Override // com.baidu.tieba.a12
    public void b(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray) == null) {
            try {
                if (jSONArray.length() > 0) {
                    String optString = jSONArray.optString(0);
                    if (TextUtils.equals(optString, "top")) {
                        this.a = 1;
                    } else if (TextUtils.equals(optString, NativeConstants.MIDDLE)) {
                        this.a = 2;
                    } else if (TextUtils.equals(optString, "bottom")) {
                        this.a = 3;
                    } else {
                        this.a = 0;
                    }
                }
            } catch (Exception e) {
                if (eo1.a) {
                    e.printStackTrace();
                }
            }
        }
    }
}
