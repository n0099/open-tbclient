package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class g3c {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            if (context == null) {
                return "";
            }
            try {
                b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            } catch (Throwable unused) {
                b = null;
            }
            return b;
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            if (context == null) {
                return "";
            }
            try {
                a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return a;
        }
        return (String) invokeL.objValue;
    }
}
