package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d0c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
        }
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            return "SecurityComp10105310: " + str;
        }
        return (String) invokeL.objValue;
    }

    public static void c(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, th) == null) {
            Log.e(a(str), str2, th);
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            Log.e(a(str), str2);
        }
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            Log.i(a(str), str2);
        }
    }

    public static void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) {
            Log.w(a(str), str2);
        }
    }
}
