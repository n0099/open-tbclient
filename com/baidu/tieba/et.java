package com.baidu.tieba;

import android.app.Activity;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class et {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, activity)) == null) {
            if (activity == null || activity.isFinishing()) {
                return true;
            }
            if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
