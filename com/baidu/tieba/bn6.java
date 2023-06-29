package com.baidu.tieba;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Method;
/* loaded from: classes5.dex */
public class bn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, view2) == null) && view2 != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(800L);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            alphaAnimation.setRepeatCount(-1);
            alphaAnimation.setRepeatMode(2);
            view2.startAnimation(alphaAnimation);
        }
    }

    public static void c(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, view2) == null) {
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

    public static Bitmap b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bitmap)) == null) {
            if (bitmap == null) {
                return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            }
            return bitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public static void d(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, view2) != null) || view2 == null) {
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

    public static void e(View view2) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, view2) == null) && (i = Build.VERSION.SDK_INT) <= 23 && i >= 17) {
            if (i < 17) {
                c(view2);
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

    public static void f(@NonNull View view2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65541, null, view2, i) == null) && view2.getVisibility() != i) {
            view2.setVisibility(i);
        }
    }
}
