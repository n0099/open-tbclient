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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.CodedInputStream;
/* loaded from: classes4.dex */
public class h23 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mi3 a;

        public a(mi3 mi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = mi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            mi3 mi3Var;
            View e;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (mi3Var = this.a) == null || (e = mi3Var.e()) == null) {
                return;
            }
            e.setVisibility(0);
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r22 a;
        public final /* synthetic */ View b;

        public b(r22 r22Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r22Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r22Var;
            this.b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            View e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mi3 I1 = this.a.I1();
                if (I1 != null && (e = I1.e()) != null) {
                    e.setVisibility(8);
                }
                LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09017c);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.topMargin = 0;
                linearLayout.setLayoutParams(layoutParams);
                FrameLayout frameLayout = (FrameLayout) linearLayout.findViewById(R.id.obfuscated_res_0x7f09017d);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                layoutParams2.topMargin = 0;
                frameLayout.setLayoutParams(layoutParams2);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                h23.n(h23.e(this.a), this.b);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947771776, "Lcom/baidu/tieba/h23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947771776, "Lcom/baidu/tieba/h23;");
                return;
            }
        }
        a = vj1.a;
        Color.parseColor("#80000000");
        b = j();
        if (TextUtils.equals(Build.MANUFACTURER, "Xiaomi")) {
            return;
        }
        TextUtils.equals(Build.MANUFACTURER, "Meizu");
    }

    public static View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            u22 V = yo2.U().V();
            return c(V != null ? V.m() : null);
        }
        return (View) invokeV.objValue;
    }

    public static View c(r22 r22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, r22Var)) == null) {
            if (r22Var != null) {
                return r22Var.L1();
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public static LinearLayout d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            xe3 z = ls1.z();
            if (z != null) {
                return z.m();
            }
            return null;
        }
        return (LinearLayout) invokeV.objValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, dialog)) == null) ? ((dialog.getWindow().getDecorView().getSystemUiVisibility() | dialog.getWindow().getAttributes().systemUiVisibility) & 2) != 0 : invokeL.booleanValue;
    }

    public static void g() {
        u22 V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, null) == null) || (V = yo2.U().V()) == null) {
            return;
        }
        h(V.m());
    }

    public static void h(r22 r22Var) {
        View V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65544, null, r22Var) == null) || (V = r22Var.V()) == null) {
            return;
        }
        fh3.a0(new b(r22Var, V));
    }

    public static boolean i(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, view2)) == null) ? (!b || view2 == null || view2.findViewById(R.id.obfuscated_res_0x7f090f19) == null) ? false : true : invokeL.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            boolean z = Build.VERSION.SDK_INT >= 21;
            return a ? z & rg3.b("sp_key_immersion_switch", z) : z;
        }
        return invokeV.booleanValue;
    }

    public static void k(Dialog dialog) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65547, null, dialog) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        int color = dialog.getContext().getResources().getColor(R.color.obfuscated_res_0x7f0603a6);
        Window window = dialog.getWindow();
        window.clearFlags(CodedInputStream.DEFAULT_SIZE_LIMIT);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(color);
    }

    public static void l(Activity activity, long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{activity, Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            fh3.b0(new c(activity, z), j);
        }
    }

    public static void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, null, z) == null) {
            l(yo2.U().getActivity(), 100L, z);
        }
    }

    public static void n(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65550, null, view2, z) == null) || view2 == null) {
            return;
        }
        if (z) {
            view2.setSystemUiVisibility(uf3.c());
        } else {
            view2.setSystemUiVisibility(0);
        }
    }

    public static void o() {
        u22 V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65551, null) == null) || (V = yo2.U().V()) == null) {
            return;
        }
        fh3.a0(new a(V.m().I1()));
    }
}
