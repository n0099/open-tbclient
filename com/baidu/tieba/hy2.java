package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.ss2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class hy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(fy2 fy2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{fy2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = ey2.e();
            if (fy2Var != null) {
                try {
                    e.put("page", fy2Var.b);
                } catch (JSONException e2) {
                    if (v73.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", ey2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(fy2 fy2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fy2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (fy2Var != null) {
                try {
                    if (fy2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (v73.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(fy2 fy2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{fy2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(fy2Var, i, false, null, z, i2);
        }
    }

    public static void d(fy2 fy2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        ss2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{fy2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            oj3 oj3Var = new oj3();
            oj3Var.k(5L);
            oj3Var.i(i);
            if (!je3.d || z2) {
                oj3Var.f(a(fy2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            we3 we3Var = new we3();
            we3Var.p(oj3Var);
            we3Var.q(oe3.n(u73.K().k()));
            we3Var.m(u73.K().getAppId());
            we3Var.s = fy2Var.b;
            we3Var.n(false);
            v73 b0 = v73.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!je3.d || z2) {
                we3Var.s(valueOf);
                we3Var.r(W);
                we3Var.e(b(fy2Var));
                we3Var.e(vd3.d().e());
                we3Var.e(vd3.d().g());
            }
            oe3.R(we3Var);
        }
    }
}
