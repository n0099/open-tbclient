package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d23 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static int f;
    public static boolean g;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface b {
        void onSoftInputShowing(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947652612, "Lcom/baidu/tieba/d23;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947652612, "Lcom/baidu/tieba/d23;");
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d23.m(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final h23 a;
        public final ViewGroup b;
        public final b c;
        public int d;
        public boolean e;
        public final Activity f;
        public int g;

        public c(Activity activity, ViewGroup viewGroup, h23 h23Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {activity, viewGroup, h23Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = 0;
            this.f = activity;
            this.c = bVar;
            this.b = viewGroup;
            this.a = h23Var;
        }

        private Context getContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                return this.b.getContext();
            }
            return (Context) invokeV.objValue;
        }

        public final void a(int i) {
            int abs;
            int j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.d == 0) {
                    this.d = i;
                    this.a.refreshHeight(d23.j(getContext()));
                }
                if (a23.e(this.b.getContext())) {
                    abs = ((View) this.b.getParent()).getHeight() - i;
                } else {
                    abs = Math.abs(i - this.d);
                }
                if (abs <= d23.g(getContext())) {
                    if (Math.abs(abs) == d23.i(this.b.getContext())) {
                        this.d -= abs;
                    }
                } else if (d23.l(getContext(), abs) && this.a.getHeight() != (j = d23.j(getContext()))) {
                    this.a.refreshHeight(j);
                }
            }
        }

        public final void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                View view2 = (View) this.b.getParent();
                int height = view2.getHeight() - view2.getPaddingTop();
                boolean z = true;
                if (a23.e(this.b.getContext())) {
                    if (height <= i) {
                        z = false;
                    }
                } else {
                    int i2 = this.g;
                    if (i2 == 0) {
                        z = this.e;
                    } else if (i >= i2 - d23.g(getContext())) {
                        z = false;
                    }
                    this.g = Math.max(this.g, height);
                }
                if (this.e != z) {
                    this.a.onSoftInputShowing(z);
                    b bVar = this.c;
                    if (bVar != null) {
                        bVar.onSoftInputShowing(z);
                    }
                }
                this.e = z;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                View childAt = this.b.getChildAt(0);
                Rect rect = new Rect();
                if (childAt != null) {
                    if (!a23.e(this.b.getContext()) && (!f23.e(this.f) || !f23.c(this.f))) {
                        i = childAt.getHeight();
                    } else {
                        childAt.getWindowVisibleDisplayFrame(rect);
                        i = rect.bottom - rect.top;
                    }
                } else {
                    i = -1;
                }
                if (i == -1) {
                    return;
                }
                a(i);
                b(i);
            }
        }
    }

    public static int d(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, resources)) == null) {
            if (d == 0) {
                d = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070153);
            }
            return d;
        }
        return invokeL.intValue;
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (b == 0) {
                b = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070154);
            }
            return b;
        }
        return invokeL.intValue;
    }

    public static int f(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, resources)) == null) {
            if (c == 0) {
                c = resources.getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070155);
            }
            return c;
        }
        return invokeL.intValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (a == 0) {
                a = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070156);
            }
            return a;
        }
        return invokeL.intValue;
    }

    public static int h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (e == 0) {
                e = u13.a(context, f(context.getResources()));
            }
            return e;
        }
        return invokeL.intValue;
    }

    public static int j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            return Math.min(d(context.getResources()), Math.max(f(context.getResources()), h(context)));
        }
        return invokeL.intValue;
    }

    public static void k(@NonNull View view2) {
        InputMethodManager inputMethodManager;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65547, null, view2) == null) && (inputMethodManager = (InputMethodManager) view2.getContext().getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(view2.getWindowToken(), 0);
        }
    }

    public static void m(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, view2) == null) {
            view2.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) view2.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(view2, 0);
            }
        }
    }

    public static boolean l(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, context, i)) == null) {
            if (e == i || i < 0) {
                return false;
            }
            e = i;
            return u13.b(context, i);
        }
        return invokeLI.booleanValue;
    }

    public static void n(View view2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65550, null, view2, j) == null) {
            view2.postDelayed(new a(view2), j);
        }
    }

    public static ViewTreeObserver.OnGlobalLayoutListener c(Activity activity, ViewGroup viewGroup, h23 h23Var, b bVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, activity, viewGroup, h23Var, bVar)) == null) {
            if (viewGroup == null) {
                viewGroup = (ViewGroup) activity.findViewById(16908290);
            }
            c cVar = new c(activity, viewGroup, h23Var, bVar);
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(cVar);
            return cVar;
        }
        return (ViewTreeObserver.OnGlobalLayoutListener) invokeLLLL.objValue;
    }

    public static synchronized int i(Context context) {
        InterceptResult invokeL;
        int i;
        int identifier;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            synchronized (d23.class) {
                if (!g && (identifier = context.getResources().getIdentifier(SapiSystemBarTintManager.SystemBarConfig.g, EMABTest.TYPE_DIMEN, "android")) > 0) {
                    f = context.getResources().getDimensionPixelSize(identifier);
                    g = true;
                }
                i = f;
            }
            return i;
        }
        return invokeL.intValue;
    }
}
