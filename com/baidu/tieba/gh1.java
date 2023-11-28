package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tieba.u11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gh1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public gh1(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
    }

    public final int b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            return jSONObject.optInt("l_gravity");
        }
        return invokeL.intValue;
    }

    public final void a(RelativeLayout.LayoutParams layoutParams, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(1048576, this, layoutParams, i, i2, i3) == null) && (i & i2) == i2) {
            layoutParams.addRule(i3);
        }
    }

    public final int[] c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            int[] iArr = {0, 0, 0, 0};
            String optString = jSONObject.optString(CriusAttrConstants.MARGIN);
            boolean z = true;
            if (jSONObject.optInt("is_equal_bottom_logo", 0) != 1) {
                z = false;
            }
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split("_");
                if (split.length == 4) {
                    for (int i = 0; i < 4; i++) {
                        try {
                            iArr[i] = Integer.parseInt(split[i]);
                        } catch (Exception unused) {
                            iArr[i] = 0;
                        }
                        if (i == 3 && z) {
                            iArr[i] = iArr[i] + ue1.b();
                        }
                    }
                }
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public final void d(RelativeLayout.LayoutParams layoutParams, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, layoutParams, i) == null) && i > 0) {
            a(layoutParams, i, 1, 10);
            a(layoutParams, i, 2, 12);
            a(layoutParams, i, 4, 9);
            a(layoutParams, i, 8, 11);
            a(layoutParams, i, 16, 14);
            a(layoutParams, i, 32, 15);
        }
    }

    public final void e(ViewGroup.MarginLayoutParams marginLayoutParams, int[] iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, marginLayoutParams, iArr) == null) && iArr != null && iArr.length == 4) {
            marginLayoutParams.setMargins(u11.c.a(this.a, iArr[0]), u11.c.a(this.a, iArr[1]), u11.c.a(this.a, iArr[2]), u11.c.a(this.a, iArr[3]));
        }
    }

    public final void f(RelativeLayout.LayoutParams layoutParams, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, layoutParams, jSONObject) == null) && jSONObject != null) {
            d(layoutParams, b(jSONObject));
            e(layoutParams, c(jSONObject));
        }
    }

    public void g(ViewGroup.LayoutParams layoutParams, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, layoutParams, jSONObject) == null) && layoutParams != null && jSONObject != null && (layoutParams instanceof RelativeLayout.LayoutParams)) {
            f((RelativeLayout.LayoutParams) layoutParams, jSONObject);
        }
    }
}
