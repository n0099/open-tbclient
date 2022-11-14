package com.baidu.tieba;

import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static long a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            SharedPreferences a = oh4.a();
            return a.getLong("latest_update_time" + i, 0L);
        }
        return invokeI.longValue;
    }

    public static long b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            SharedPreferences a = oh4.a();
            return a.getLong("max_age" + i, 0L);
        }
        return invokeI.longValue;
    }

    public static boolean c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if ((System.currentTimeMillis() - a(i)) / 1000 > b(i)) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static void d(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            SharedPreferences.Editor edit = oh4.a().edit();
            edit.putLong("latest_update_time" + i, j).apply();
        }
    }

    public static void e(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (j <= 0 || j >= 259200) {
                j = 0;
            }
            oh4.a().edit().putLong("max_age" + i, j).apply();
        }
    }
}
