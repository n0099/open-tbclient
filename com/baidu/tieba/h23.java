package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.sw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(f23 f23Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{f23Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = e23.e();
            if (f23Var != null) {
                try {
                    e.put("page", f23Var.b);
                } catch (JSONException e2) {
                    if (vb3.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", e23.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(f23 f23Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, f23Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (f23Var != null) {
                try {
                    if (f23Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (vb3.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(f23 f23Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{f23Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(f23Var, i, false, null, z, i2);
        }
    }

    public static void d(f23 f23Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        sw2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{f23Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            on3 on3Var = new on3();
            on3Var.k(5L);
            on3Var.i(i);
            if (!ji3.d || z2) {
                on3Var.f(a(f23Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            wi3 wi3Var = new wi3();
            wi3Var.p(on3Var);
            wi3Var.q(oi3.n(ub3.K().k()));
            wi3Var.m(ub3.K().getAppId());
            wi3Var.s = f23Var.b;
            wi3Var.n(false);
            vb3 b0 = vb3.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!ji3.d || z2) {
                wi3Var.s(valueOf);
                wi3Var.r(W);
                wi3Var.e(b(f23Var));
                wi3Var.e(vh3.d().e());
                wi3Var.e(vh3.d().g());
            }
            oi3.R(wi3Var);
        }
    }
}
