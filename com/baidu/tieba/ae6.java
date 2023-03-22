package com.baidu.tieba;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes3.dex */
public class ae6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bitmap a(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bitmap)) == null) {
            if (bitmap == null) {
                return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            }
            return bitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static void c(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, view2) != null) || view2 == null) {
            return;
        }
        try {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        } catch (Exception unused) {
        }
    }

    public static void b(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, view2) == null) {
            try {
                ViewParent parent = view2.getRootView().getParent();
                Method declaredMethod = parent.getClass().getDeclaredMethod("handleDispatchDoneAnimating", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(parent, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void d(View view2) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, view2) == null) && (i = Build.VERSION.SDK_INT) <= 23 && i >= 17) {
            if (i < 17) {
                b(view2);
                return;
            }
            try {
                ViewParent parent = view2.getRootView().getParent();
                Method declaredMethod = parent.getClass().getDeclaredMethod("setDrawDuringWindowsAnimating", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(parent, Boolean.TRUE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void e(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, view2, i) == null) && view2.getVisibility() != i) {
            view2.setVisibility(i);
        }
    }
}
