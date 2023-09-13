package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.LiveFontSizeService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
/* loaded from: classes5.dex */
public final class fd0 {
    public static /* synthetic */ Interceptable $ic;
    public static final LiveFontSizeService a;
    public transient /* synthetic */ FieldHolder $fh;

    @JvmStatic
    @JvmOverloads
    public static final int c(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(65539, null, f)) == null) ? e(f, 0, 0, 6, null) : invokeF.intValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final void f(View view2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            j(view2, f, f2, 0, 0, 12, null);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void h(TextView textView, int i, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{textView, Integer.valueOf(i), Float.valueOf(f)}) == null) {
            k(textView, i, f, 0, 0, 12, null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947760151, "Lcom/baidu/tieba/fd0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947760151, "Lcom/baidu/tieba/fd0;");
                return;
            }
        }
        a = (LiveFontSizeService) ServiceManager.getService(LiveFontSizeService.Companion.getSERVICE_REFERENCE());
    }

    @JvmStatic
    @JvmOverloads
    public static final Drawable a(Drawable drawable, int i, int i2) {
        InterceptResult invokeLII;
        Drawable scaledDrawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65537, null, drawable, i, i2)) == null) {
            LiveFontSizeService liveFontSizeService = a;
            if (liveFontSizeService != null && (scaledDrawable = liveFontSizeService.getScaledDrawable(drawable, i, i2)) != null) {
                return scaledDrawable;
            }
            return drawable;
        }
        return (Drawable) invokeLII.objValue;
    }

    public static /* synthetic */ Drawable b(Drawable drawable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        return a(drawable, i, i2);
    }

    public static /* synthetic */ int e(float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        return d(f, i, i2);
    }

    @JvmStatic
    @JvmOverloads
    public static final int d(float f, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            LiveFontSizeService liveFontSizeService = a;
            if (liveFontSizeService != null) {
                return liveFontSizeService.getScaledSize(f, i, i2);
            }
            return (int) f;
        }
        return invokeCommon.intValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final void g(View view2, float f, float f2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{view2, Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            LiveFontSizeService liveFontSizeService = a;
            if (liveFontSizeService == null) {
                if (view2.getLayoutParams() == null) {
                    view2.setLayoutParams(new ViewGroup.LayoutParams((int) f, (int) f2));
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                layoutParams.width = (int) f;
                layoutParams.height = (int) f2;
                view2.setLayoutParams(layoutParams);
                return;
            }
            liveFontSizeService.setScaledSize(view2, f, f2, i, i2);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void i(TextView textView, int i, float f, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{textView, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            LiveFontSizeService liveFontSizeService = a;
            if (liveFontSizeService == null) {
                textView.setTextSize(i, f);
            } else {
                liveFontSizeService.setScaledSize(textView, i, f, i2, i3);
            }
        }
    }

    public static /* synthetic */ void j(View view2, float f, float f2, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 2;
        }
        g(view2, f, f2, i, i2);
    }

    public static /* synthetic */ void k(TextView textView, int i, float f, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = 2;
        }
        i(textView, i, f, i2, i3);
    }

    @JvmStatic
    @JvmOverloads
    public static final void l(View view2, float f, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{view2, Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            LiveFontSizeService liveFontSizeService = a;
            if (liveFontSizeService == null) {
                if (view2.getLayoutParams() == null) {
                    view2.setLayoutParams(new ViewGroup.LayoutParams((int) f, -2));
                    return;
                }
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                layoutParams.width = (int) f;
                view2.setLayoutParams(layoutParams);
                return;
            }
            liveFontSizeService.setScaledWidth(view2, f, i, i2);
        }
    }

    public static /* synthetic */ void m(View view2, float f, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 2;
        }
        l(view2, f, i, i2);
    }
}
