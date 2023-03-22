package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.qs2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fy2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(dy2 dy2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{dy2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = cy2.e();
            if (dy2Var != null) {
                try {
                    e.put("page", dy2Var.b);
                } catch (JSONException e2) {
                    if (t73.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", cy2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(dy2 dy2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dy2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (dy2Var != null) {
                try {
                    if (dy2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (t73.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(dy2 dy2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{dy2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(dy2Var, i, false, null, z, i2);
        }
    }

    public static void d(dy2 dy2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        qs2.a W;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{dy2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            mj3 mj3Var = new mj3();
            mj3Var.k(5L);
            mj3Var.i(i);
            if (!he3.d || z2) {
                mj3Var.f(a(dy2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            ue3 ue3Var = new ue3();
            ue3Var.p(mj3Var);
            ue3Var.q(me3.n(s73.K().k()));
            ue3Var.m(s73.K().getAppId());
            ue3Var.s = dy2Var.b;
            ue3Var.n(false);
            t73 b0 = t73.b0();
            if (b0 == null) {
                W = null;
            } else {
                W = b0.W();
            }
            if (!he3.d || z2) {
                ue3Var.s(valueOf);
                ue3Var.r(W);
                ue3Var.e(b(dy2Var));
                ue3Var.e(td3.d().e());
                ue3Var.e(td3.d().g());
            }
            me3.R(ue3Var);
        }
    }
}
