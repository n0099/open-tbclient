package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] a = d70.a(str.getBytes());
            if (a != null && a.length > 2) {
                a[0] = 117;
                a[1] = 123;
            }
            return a;
        }
        return (byte[]) invokeL.objValue;
    }

    public static boolean b(Context context, JSONArray jSONArray, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{context, jSONArray, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            if (jSONArray != null && jSONArray.length() != 0) {
                e70.a("UBCUploader", "uploadjson:" + jSONArray.toString() + ", isReal:" + z + ", isSave:" + z2);
                if (z2) {
                    e70.a("UBCUploader", "save ubcdata");
                    return true;
                }
                c(context, jSONArray, z, z2, z3);
                return true;
            }
            e70.a("UBCUploader", "upload json is null");
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static void c(Context context, JSONArray jSONArray, boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, jSONArray, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            JSONObject b = new b70(z, jSONArray).b();
            if (b == null) {
                e70.a("UBCUploader", "uploadJsonData is null");
                return;
            }
            byte[] a = a(b.toString());
            if (a != null && a.length >= 3) {
                e70.a("UBCUploader", "gzip success, length:" + a.length);
                e70.a("UBCUploader", "start execute http upload data");
                y60 y60Var = new y60(context);
                v60.e(context).b(context, y60Var, y60Var, a, z3);
                return;
            }
            e70.a("UBCUploader", "uploadGzip is null or uploadGzip length<3");
        }
    }
}
