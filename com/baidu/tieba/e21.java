package com.baidu.tieba;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PendingIntent a(Context context, int i, Intent intent, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{context, Integer.valueOf(i), intent, Integer.valueOf(i2)})) == null) {
            if (Build.VERSION.SDK_INT >= 31) {
                return PendingIntent.getBroadcast(context, i, intent, i2 | 67108864);
            }
            return PendingIntent.getBroadcast(context, i, intent, i2);
        }
        return (PendingIntent) invokeCommon.objValue;
    }
}
