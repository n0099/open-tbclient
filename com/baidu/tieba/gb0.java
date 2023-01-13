package com.baidu.tieba;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gb0 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947788020, "Lcom/baidu/tieba/gb0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947788020, "Lcom/baidu/tieba/gb0;");
        }
    }

    /* loaded from: classes4.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final ViewGroup b;
        public final db0 c;
        public final boolean d;
        public final boolean e;
        public final boolean f;
        public final int g;
        public boolean h;
        public final b i;
        public final int j;
        public boolean k;
        public int l;

        public a(boolean z, boolean z2, boolean z3, ViewGroup viewGroup, db0 db0Var, b bVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), viewGroup, db0Var, bVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 0;
            this.k = false;
            this.b = viewGroup;
            this.c = db0Var;
            this.d = z;
            this.e = z2;
            this.f = z3;
            this.g = hb0.a(viewGroup.getContext());
            this.i = bVar;
            this.j = i;
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (this.a == 0) {
                    this.a = i;
                    db0 db0Var = this.c;
                    if (db0Var != null) {
                        db0Var.refreshHeight(gb0.g(getContext()));
                        return;
                    }
                    return;
                }
                if (eb0.a(this.d, this.e, this.f)) {
                    abs = ((View) this.b.getParent()).getHeight() - i;
                    Log.d("KeyboardStatusListener", String.format("action bar over layout %d display height: %d", Integer.valueOf(((View) this.b.getParent()).getHeight()), Integer.valueOf(i)));
                } else {
                    abs = Math.abs(i - this.a);
                }
                if (abs <= gb0.e(getContext())) {
                    return;
                }
                Log.d("KeyboardStatusListener", String.format("pre display height: %d display height: %d keyboard: %d ", Integer.valueOf(this.a), Integer.valueOf(i), Integer.valueOf(abs)));
                if (abs == this.g) {
                    Log.w("KeyboardStatusListener", String.format("On global layout change get keyboard height just equal statusBar height %d", Integer.valueOf(abs)));
                } else if (gb0.i(getContext(), abs)) {
                    int g = gb0.g(getContext());
                    db0 db0Var2 = this.c;
                    if (db0Var2 != null && db0Var2.getHeight() != g) {
                        this.c.refreshHeight(g);
                    }
                }
            }
        }

        public final void b(int i) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                View view2 = (View) this.b.getParent();
                int height = view2.getHeight() - view2.getPaddingTop();
                if (eb0.a(this.d, this.e, this.f)) {
                    if (!this.e && height - i == this.g) {
                        z = this.h;
                    } else if (height > i) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    int i2 = this.b.getResources().getDisplayMetrics().heightPixels;
                    if (!this.e && i2 == height) {
                        Log.w("KeyboardStatusListener", String.format("skip the keyboard status calculate, the current activity is paused. and phone-display-height %d, root-height+actionbar-height %d", Integer.valueOf(i2), Integer.valueOf(height)));
                        return;
                    }
                    int i3 = this.l;
                    if (i3 == 0) {
                        z = this.h;
                    } else if (i < i3 - gb0.e(getContext())) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.l = Math.max(this.l, height);
                }
                if (this.h != z) {
                    Log.d("KeyboardStatusListener", String.format("displayHeight %d actionBarOverlayLayoutHeight %d keyboard status change: %B", Integer.valueOf(i), Integer.valueOf(height), Boolean.valueOf(z)));
                    db0 db0Var = this.c;
                    if (db0Var != null) {
                        db0Var.a(z);
                    }
                    b bVar = this.i;
                    if (bVar != null) {
                        bVar.a(z);
                    }
                }
                this.h = z;
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @TargetApi(13)
        public void onGlobalLayout() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                boolean z = false;
                View childAt = this.b.getChildAt(0);
                View view2 = (View) this.b.getParent();
                Rect rect = new Rect();
                if (this.e) {
                    view2.getWindowVisibleDisplayFrame(rect);
                    i = rect.bottom - rect.top;
                    if (!this.k) {
                        if (i == this.j) {
                            z = true;
                        }
                        this.k = z;
                    }
                    if (!this.k) {
                        i += this.g;
                    }
                } else if (childAt != null) {
                    childAt.getWindowVisibleDisplayFrame(rect);
                    i = rect.bottom - rect.top;
                } else {
                    Log.w("KeyBordUtil", "user root view not ready so ignore global layout changed!");
                    i = -1;
                }
                if (i == -1) {
                    return;
                }
                a(i);
                b(i);
                this.a = i;
            }
        }
    }

    @TargetApi(13)
    public static ViewTreeObserver.OnGlobalLayoutListener b(Activity activity, db0 db0Var, b bVar) {
        InterceptResult invokeLLL;
        int height;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, activity, db0Var, bVar)) == null) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            boolean b2 = ib0.b(activity);
            boolean c2 = ib0.c(activity);
            boolean a2 = ib0.a(activity);
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                Point point = new Point();
                defaultDisplay.getSize(point);
                height = point.y;
            } else {
                height = defaultDisplay.getHeight();
            }
            a aVar = new a(b2, c2, a2, viewGroup, db0Var, bVar, height);
            viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
            return aVar;
        }
        return (ViewTreeObserver.OnGlobalLayoutListener) invokeLLL.objValue;
    }

    public static int c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (a == 0) {
                a = fb0.a(context, f(context.getResources()));
            }
            return a;
        }
        return invokeL.intValue;
    }

    public static int d(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, resources)) == null) {
            if (b == 0) {
                b = resources.getDimensionPixelSize(R.dimen.max_panel_height);
            }
            return b;
        }
        return invokeL.intValue;
    }

    public static int e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (d == 0) {
                d = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07042b);
            }
            return d;
        }
        return invokeL.intValue;
    }

    public static int f(Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, resources)) == null) {
            if (c == 0) {
                c = resources.getDimensionPixelSize(R.dimen.min_panel_height);
            }
            return c;
        }
        return invokeL.intValue;
    }

    public static int g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            return Math.min(d(context.getResources()), Math.max(f(context.getResources()), c(context)));
        }
        return invokeL.intValue;
    }

    public static void h(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, view2) == null) {
            ((InputMethodManager) view2.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view2.getWindowToken(), 0);
        }
    }

    public static boolean i(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i)) == null) {
            if (a == i || i < 0) {
                return false;
            }
            a = i;
            Log.d("KeyBordUtil", String.format("save keyboard: %d", Integer.valueOf(i)));
            return fb0.b(context, i);
        }
        return invokeLI.booleanValue;
    }
}
