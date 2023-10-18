package com.baidu.tieba;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ez1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public Shader c;

    public ez1(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONArray};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = "";
        e(jSONArray);
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public Shader b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (Shader) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!TextUtils.equals(this.a, "linearGradient") && !TextUtils.equals(this.a, "circularGradient")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return !TextUtils.isEmpty(this.a);
        }
        return invokeV.booleanValue;
    }

    public void e(JSONArray jSONArray) {
        float[] fArr;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONArray) == null) {
            int i = 0;
            try {
                String optString = jSONArray.optString(0);
                int i2 = 4;
                int i3 = 1;
                if (TextUtils.equals(optString, "normal")) {
                    JSONArray optJSONArray = jSONArray.optJSONArray(1);
                    if (optJSONArray.length() == 4) {
                        this.b = Color.argb(optJSONArray.optInt(3), optJSONArray.optInt(0), optJSONArray.optInt(1), optJSONArray.optInt(2));
                        this.a = "normal";
                    }
                } else if (TextUtils.equals(optString, "linearGradient") || TextUtils.equals(optString, "circularGradient")) {
                    JSONArray optJSONArray2 = jSONArray.optJSONArray(1);
                    int[] iArr = null;
                    if (optJSONArray2 != null && (length = optJSONArray2.length()) > 0) {
                        iArr = new int[length];
                        fArr = new float[length];
                        int i4 = 0;
                        while (i4 < length) {
                            JSONObject optJSONObject = optJSONArray2.optJSONObject(i4);
                            JSONArray optJSONArray3 = optJSONObject.optJSONArray("color");
                            if (optJSONArray3.length() == i2) {
                                iArr[i4] = Color.argb(optJSONArray3.optInt(3), optJSONArray3.optInt(i), optJSONArray3.optInt(i3), optJSONArray3.optInt(2));
                            }
                            fArr[i4] = (float) optJSONObject.optDouble("stop");
                            i4++;
                            i = 0;
                            i2 = 4;
                            i3 = 1;
                        }
                    } else {
                        fArr = null;
                    }
                    if (iArr != null && fArr != null && iArr.length >= 2 && iArr.length == fArr.length) {
                        JSONObject optJSONObject2 = jSONArray.optJSONObject(2);
                        if (TextUtils.equals(optString, "linearGradient")) {
                            this.c = new LinearGradient(gj3.g(optJSONObject2.optInt("x0")), gj3.g(optJSONObject2.optInt("y0")), gj3.g(optJSONObject2.optInt(GestureAR.SDK_TO_LUA_GESTURE_RESULT_X1)), gj3.g(optJSONObject2.optInt(GestureAR.SDK_TO_LUA_GESTURE_RESULT_Y1)), iArr, fArr, Shader.TileMode.CLAMP);
                            this.a = "linearGradient";
                            return;
                        }
                        this.c = new RadialGradient(gj3.g(optJSONObject2.optInt("x")), gj3.g(optJSONObject2.optInt("y")), gj3.g(optJSONObject2.optInt("r")), iArr, fArr, Shader.TileMode.CLAMP);
                        this.a = "circularGradient";
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
