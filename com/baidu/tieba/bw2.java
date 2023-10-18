package com.baidu.tieba;

import android.graphics.Bitmap;
import com.baidu.tieba.mq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bw2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(zv2 zv2Var, boolean z, Bitmap bitmap, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{zv2Var, Boolean.valueOf(z), bitmap, Boolean.valueOf(z2)})) == null) {
            JSONObject e = yv2.e();
            if (zv2Var != null) {
                try {
                    e.put("page", zv2Var.b);
                } catch (JSONException e2) {
                    if (p53.v) {
                        e2.printStackTrace();
                    }
                }
            }
            e.put("firstPage", z2);
            if (z && bitmap != null) {
                e.put("image", yv2.c(bitmap));
            }
            return e;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public static JSONObject b(zv2 zv2Var) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zv2Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (zv2Var != null) {
                try {
                    if (zv2Var.g == 0) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    jSONObject.put("isH5Componet", str);
                } catch (JSONException e) {
                    if (p53.v) {
                        e.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void c(zv2 zv2Var, int i, boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{zv2Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2)}) == null) {
            d(zv2Var, i, false, null, z, i2);
        }
    }

    public static void d(zv2 zv2Var, int i, boolean z, Bitmap bitmap, boolean z2, int i2) {
        mq2.a X;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{zv2Var, Integer.valueOf(i), Boolean.valueOf(z), bitmap, Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) {
            ih3 ih3Var = new ih3();
            ih3Var.k(5L);
            ih3Var.i(i);
            if (!dc3.d || z2) {
                ih3Var.f(a(zv2Var, z, bitmap, z2).toString());
            }
            String valueOf = String.valueOf(i2);
            qc3 qc3Var = new qc3();
            qc3Var.p(ih3Var);
            qc3Var.q(ic3.n(o53.K().k()));
            qc3Var.m(o53.K().getAppId());
            qc3Var.s = zv2Var.b;
            qc3Var.n(false);
            p53 c0 = p53.c0();
            if (c0 == null) {
                X = null;
            } else {
                X = c0.X();
            }
            if (!dc3.d || z2) {
                qc3Var.s(valueOf);
                qc3Var.r(X);
                qc3Var.e(b(zv2Var));
                qc3Var.e(pb3.d().e());
                qc3Var.e(pb3.d().g());
            }
            ic3.R(qc3Var);
        }
    }
}
