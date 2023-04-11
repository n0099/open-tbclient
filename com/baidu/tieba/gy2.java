package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.rs2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(ey2 ey2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{ey2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = dy2.e();
            if (ey2Var != null) {
                try {
                    e.put("page", ey2Var.b);
                } catch (JSONException e2) {
                    if (u73.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", dy2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(ey2 ey2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ey2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (ey2Var != null) {
                try {
                    if (ey2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (u73.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(ey2 ey2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{ey2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(ey2Var, i, false, null, z, i2);
        }
    }

    public static void d(ey2 ey2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        rs2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{ey2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            nj3 nj3Var = new nj3();
            nj3Var.k(5L);
            nj3Var.i(i);
            if (!ie3.d || z2) {
                nj3Var.f(a(ey2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            ve3 ve3Var = new ve3();
            ve3Var.p(nj3Var);
            ve3Var.q(ne3.n(t73.K().k()));
            ve3Var.m(t73.K().getAppId());
            ve3Var.s = ey2Var.b;
            ve3Var.n(false);
            u73 b0 = u73.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!ie3.d || z2) {
                ve3Var.s(valueOf);
                ve3Var.r(W);
                ve3Var.e(b(ey2Var));
                ve3Var.e(ud3.d().e());
                ve3Var.e(ud3.d().g());
            }
            ne3.R(ve3Var);
        }
    }
}
