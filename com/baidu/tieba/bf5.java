package com.baidu.tieba;

import android.content.Context;
import androidx.core.app.NotificationManagerCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                return NotificationManagerCompat.from(context.getApplicationContext()).areNotificationsEnabled();
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
