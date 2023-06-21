package com.baidu.tieba;

import android.content.Context;
import android.media.AudioManager;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class i21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static AudioManager a(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            if (context == null) {
                return null;
            }
            try {
                return (AudioManager) context.getSystemService("audio");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (AudioManager) invokeL.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            AudioManager a = a(context);
            if (a != null) {
                return a.getStreamMaxVolume(3);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            AudioManager a = a(context);
            if (a != null) {
                return a.getStreamVolume(3);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static void d(Context context, int i) {
        AudioManager a;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65539, null, context, i) == null) && (a = a(context)) != null) {
            a.setStreamVolume(3, i, 8);
        }
    }
}
