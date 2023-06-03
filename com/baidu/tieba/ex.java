package com.baidu.tieba;

import android.os.Environment;
import android.os.StatFs;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class ex {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448303962, "Lcom/baidu/tieba/ex;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448303962, "Lcom/baidu/tieba/ex;");
        }
    }

    public static float a() {
        InterceptResult invokeV;
        long j;
        StatFs statFs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            long j2 = 0;
            try {
                statFs = new StatFs(Environment.getDataDirectory().getPath());
                j = statFs.getBlockSize();
            } catch (Exception e) {
                e = e;
                j = 0;
            }
            try {
                j2 = statFs.getAvailableBlocks();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return ((float) (j2 * j)) / 1024.0f;
            }
            return ((float) (j2 * j)) / 1024.0f;
        }
        return invokeV.floatValue;
    }
}
