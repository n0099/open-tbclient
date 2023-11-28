package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.tieba.hl3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/* loaded from: classes6.dex */
public class il3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean i;
    public static int j;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public Activity a;
    @NonNull
    public ViewGroup b;
    @Nullable
    public View c;
    @Nullable
    public View d;
    public int e;
    public boolean f;
    public hl3 g;
    public View.OnSystemUiVisibilityChangeListener h;

    public static int a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65539, null, i2, i3)) == null) {
            if (i3 == 0) {
                return i2;
            }
            float f = 1.0f - (i3 / 255.0f);
            return ((int) (((i2 & 255) * f) + 0.5d)) | (((int) ((((i2 >> 16) & 255) * f) + 0.5d)) << 16) | (-16777216) | (((int) ((((i2 >> 8) & 255) * f) + 0.5d)) << 8);
        }
        return invokeII.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnSystemUiVisibilityChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        public a(il3 il3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947857305, "Lcom/baidu/tieba/il3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947857305, "Lcom/baidu/tieba/il3;");
                return;
            }
        }
        i = j();
        j = 0;
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            j = 1;
        } else if (TextUtils.equals(Build.MANUFACTURER, "Meizu")) {
            j = 2;
        }
    }

    public final int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return this.a.getResources().getColor(R.color.obfuscated_res_0x7f060468);
            }
            return this.a.getResources().getColor(R.color.obfuscated_res_0x7f060469);
        }
        return invokeV.intValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Window window = this.a.getWindow();
            window.clearFlags(1024);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                if (j == 1) {
                    q(window, d().d);
                }
            } else if (i2 >= 19) {
                window.addFlags(67108864);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public il3(@NonNull Activity activity) {
        this(activity, (ViewGroup) activity.findViewById(16908290));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Activity) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void o(@NonNull hl3 hl3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hl3Var) == null) {
            if (j == 2) {
                p(hl3Var);
            } else {
                r();
                s(hl3Var);
            }
            View view2 = this.c;
            if (view2 != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
                if (hl3Var.f) {
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.topMargin = yj3.t();
                }
                this.c.setLayoutParams(layoutParams);
            }
        }
    }

    public il3(@NonNull Activity activity, @NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, viewGroup};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.e = 1;
        this.a = activity;
        this.b = viewGroup;
        this.c = viewGroup.getChildAt(0);
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int f = f();
            this.g = b(f, g(f), false, false, true);
        }
    }

    @NonNull
    public hl3 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.g == null) {
                c();
            }
            return this.g;
        }
        return (hl3) invokeV.objValue;
    }

    @Nullable
    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (View) invokeV.objValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.g = null;
            this.e = 1;
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            o(d());
        }
    }

    public final hl3 b(int i2, int i3, boolean z, boolean z2, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)})) == null) {
            hl3.b b = hl3.b.b();
            b.i(z);
            b.h(true);
            b.g(false);
            b.f(i3);
            b.e(i2);
            b.c(z2);
            b.d(z3);
            return b.a();
        }
        return (hl3) invokeCommon.objValue;
    }

    public final int g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return 0;
            }
            return a(i2, 45);
        }
        return invokeI.intValue;
    }

    public final View h(@NonNull hl3 hl3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, hl3Var)) == null) {
            if (!hl3Var.g) {
                return null;
            }
            View view2 = this.d;
            if (view2 != null) {
                if (!hl3Var.e) {
                    this.b.removeView(view2);
                    this.d = null;
                    return null;
                }
                return view2;
            } else if (!hl3Var.e) {
                this.d = null;
                return null;
            } else {
                int t = yj3.t();
                View view3 = new View(this.a);
                view3.setTag(ImmersionHelper.VIEW_TAG);
                view3.setId(R.id.obfuscated_res_0x7f091196);
                this.b.addView(view3, new ViewGroup.LayoutParams(-1, t));
                this.d = view3;
                return view3;
            }
        }
        return (View) invokeL.objValue;
    }

    public final void p(hl3 hl3Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, hl3Var) == null) {
            try {
                Window window = this.a.getWindow();
                window.addFlags(67108864);
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i3 = declaredField.getInt(null);
                int i4 = declaredField2.getInt(attributes);
                if (hl3Var.d) {
                    i2 = i3 | i4;
                } else {
                    i2 = (~i3) & i4;
                }
                declaredField2.setInt(attributes, i2);
                window.setAttributes(attributes);
                int i5 = hl3Var.b;
                if (i5 == 1) {
                    i5 = f();
                }
                View h = h(hl3Var);
                if (h != null) {
                    h.setBackgroundColor(i5);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    public final void s(hl3 hl3Var) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, hl3Var) == null) {
            Window window = this.a.getWindow();
            boolean z = hl3Var.c;
            if (hl3Var.d) {
                i2 = 13312;
            } else {
                i2 = 5120;
            }
            if (!hl3Var.e) {
                i3 = i2 & (-257);
            } else {
                i3 = i2 | 256;
            }
            int i4 = hl3Var.b;
            if (i4 == 1) {
                i4 = f();
            }
            window.getDecorView().setSystemUiVisibility(i3);
            if (Build.VERSION.SDK_INT >= 21) {
                window.setStatusBarColor(hl3Var.a);
            }
            View h = h(hl3Var);
            if (h != null) {
                h.setBackgroundColor(i4);
            }
            if (this.h == null) {
                this.h = new a(this);
                window.getDecorView().setOnSystemUiVisibilityChangeListener(this.h);
            }
        }
    }

    public void m(int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            n(i2, z, true, z2);
        }
    }

    public void n(int i2, boolean z, boolean z2, boolean z3) {
        hl3 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) != null) || !i) {
            return;
        }
        if (i2 == 1) {
            if (this.e != 1) {
                k();
            }
            this.e = i2;
            b = d();
        } else {
            this.e = i2;
            b = b(i2, g(i2), z3, z, z2);
            this.g = b;
        }
        this.f = z;
        o(b);
    }

    @SuppressLint({"PrivateApi"})
    public final boolean q(Window window, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, window, z)) == null) {
            if (window != null) {
                Class<?> cls = window.getClass();
                try {
                    Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
                    int i2 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
                    Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                    if (z) {
                        method.invoke(window, Integer.valueOf(i2), Integer.valueOf(i2));
                    } else {
                        method.invoke(window, 0, Integer.valueOf(i2));
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }
}
