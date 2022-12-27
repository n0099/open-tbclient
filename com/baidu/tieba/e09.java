package com.baidu.tieba;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class e09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            try {
                return Integer.valueOf(Build.VERSION.SDK).intValue();
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return invokeV.intValue;
    }

    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (((SensorManager) context.getSystemService("sensor")).getDefaultSensor(4) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
