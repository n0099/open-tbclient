package com.baidu.tieba;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.widget.ImmersionHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class da3 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ iq3 a;

        public a(iq3 iq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = iq3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            iq3 iq3Var;
            View e;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (iq3Var = this.a) != null && (e = iq3Var.e()) != null) {
                e.setVisibility(0);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na2 a;
        public final /* synthetic */ View b;

        public b(na2 na2Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na2Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = na2Var;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            View e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                iq3 J1 = this.a.J1();
                if (J1 != null && (e = J1.e()) != null) {
                    e.setVisibility(8);
                }
                LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f090189);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                linearLayout.setLayoutParams(layoutParams);
                FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f09018a);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams2.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ boolean b;

        public c(Activity activity, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = activity;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.getWindow().clearFlags(2048);
                da3.n(da3.e(this.a), this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947697779, "Lcom/baidu/tieba/da3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947697779, "Lcom/baidu/tieba/da3;");
                return;
            }
        }
        a = rr1.a;
        Color.parseColor("#80000000");
        b = j();
        if (!TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            TextUtils.equals(Build.MANUFACTURER, "Meizu");
        }
    }

    public static void n(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65550, null, view2, z) == null) && view2 != null) {
            if (z) {
                view2.setSystemUiVisibility(qn3.c());
            } else {
                view2.setSystemUiVisibility(0);
            }
        }
    }

    public static View b() {
        InterceptResult invokeV;
        na2 na2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            qa2 U = uw2.T().U();
            if (U != null) {
                na2Var = U.m();
            } else {
                na2Var = null;
            }
            return c(na2Var);
        }
        return (View) invokeV.objValue;
    }

    public static LinearLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            tm3 z = h02.z();
            if (z != null) {
                return z.m();
            }
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public static void g() {
        qa2 U;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65543, null) != null) || (U = uw2.T().U()) == null) {
            return;
        }
        h(U.m());
    }

    public static boolean j() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                z = true;
            } else {
                z = false;
            }
            if (a) {
                return z & no3.b(ImmersionHelper.SP_KEY_IMMERSION_SWITCH, z);
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static void o() {
        qa2 U;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65551, null) != null) || (U = uw2.T().U()) == null) {
            return;
        }
        bp3.a0(new a(U.m().J1()));
    }

    public static View c(na2 na2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, na2Var)) == null) {
            if (na2Var != null) {
                return na2Var.M1();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public static ViewGroup e(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, activity)) == null) {
            if (activity != null) {
                return (ViewGroup) activity.getWindow().getDecorView();
            }
            return null;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public static boolean f(Dialog dialog) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, dialog)) == null) {
            if (((dialog.getWindow().getDecorView().getSystemUiVisibility() | dialog.getWindow().getAttributes().systemUiVisibility) & 2) != 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void h(na2 na2Var) {
        View b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65544, null, na2Var) != null) || (b0 = na2Var.b0()) == null) {
            return;
        }
        bp3.a0(new b(na2Var, b0));
    }

    public static boolean i(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, view2)) == null) {
            if (!b || view2 == null || view2.findViewById(R.id.obfuscated_res_0x7f091128) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            l(uw2.T().getActivity(), 100L, z);
        }
    }

    public static void k(Dialog dialog) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, dialog) == null) && Build.VERSION.SDK_INT >= 21) {
            int color = dialog.getContext().getResources().getColor(R.color.obfuscated_res_0x7f060418);
            Window window = dialog.getWindow();
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(color);
        }
    }

    public static void l(Activity activity, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{activity, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            bp3.b0(new c(activity, z), j);
        }
    }
}
