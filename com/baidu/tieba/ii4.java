package com.baidu.tieba;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ii4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(@NonNull Context context, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, str)) == null) {
            if (str != null) {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            }
            throw new IllegalArgumentException("permission is null");
        }
        return invokeLL.intValue;
    }

    public static final int b(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, context, i)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return ki4.a(context, i);
            }
            return context.getResources().getColor(i);
        }
        return invokeLI.intValue;
    }

    public static final ColorStateList c(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return ki4.b(context, i);
            }
            return context.getResources().getColorStateList(i);
        }
        return (ColorStateList) invokeLI.objValue;
    }

    public static final Drawable d(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return ji4.a(context, i);
            }
            return context.getResources().getDrawable(i);
        }
        return (Drawable) invokeLI.objValue;
    }
}
