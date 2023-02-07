package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.res.ui.BdShimmerView;
import com.baidu.swan.apps.res.widget.loadingview.LoadingView;
import com.baidu.tieba.d83;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.WeakHashMap;
/* loaded from: classes4.dex */
public final class e83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final WeakHashMap<ViewGroup, f83> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d83 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;

        public a(d83 d83Var, Context context, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d83Var, context, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d83Var;
            this.b = context;
            this.c = str;
            this.d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingView loadingView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View d = this.a.d();
                if (d instanceof LoadingView) {
                    loadingView = (LoadingView) d;
                } else {
                    loadingView = new LoadingView(this.b);
                    FrameLayout frameLayout = new FrameLayout(this.b);
                    frameLayout.setPadding(0, 0, 0, nm3.g(160.0f));
                    frameLayout.addView(loadingView);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    this.a.o(frameLayout, layoutParams);
                }
                if (!TextUtils.isEmpty(this.c)) {
                    loadingView.setMsg(this.c);
                }
                this.a.k(this.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c82 a;

        public b(c82 c82Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c82Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c82Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            d83 d;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (d = ((d83.a) this.a).d()) != null && (d.d() instanceof FrameLayout) && (((FrameLayout) d.d()).getChildAt(0) instanceof LoadingView)) {
                d.g();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947688169, "Lcom/baidu/tieba/e83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947688169, "Lcom/baidu/tieba/e83;");
                return;
            }
        }
        a = gp1.a & true;
        b = new WeakHashMap<>();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            for (ViewGroup viewGroup : b.keySet()) {
                f83 f83Var = b.get(viewGroup);
                if (f83Var != null && f83Var.getLoadingView() != null) {
                    viewGroup.removeView(f83Var.getLoadingView());
                }
            }
            b.clear();
        }
    }

    public static boolean b(ViewGroup viewGroup) {
        InterceptResult invokeL;
        f83 f83Var;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            f83 f83Var2 = b.get(viewGroup);
            if (f83Var2 != null && f83Var2.getLoadingView() != null) {
                f83Var2.getLoadingView().setVisibility(8);
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if ((viewGroup.getChildAt(i) instanceof f83) && (loadingView = (f83Var = (f83) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                    loadingView.setVisibility(8);
                    b.put(viewGroup, f83Var);
                    if (a) {
                        Log.d("LoadingViewHelper", "The count of cached loading views is : " + b.size());
                        Log.d("LoadingViewHelper", "The content of cached views is : " + b.toString());
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(ViewGroup viewGroup) {
        InterceptResult invokeL;
        f83 f83Var;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            f83 f83Var2 = b.get(viewGroup);
            if (f83Var2 != null && f83Var2.getLoadingView() != null) {
                f83Var2.getLoadingView().setVisibility(0);
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if ((viewGroup.getChildAt(i) instanceof f83) && (loadingView = (f83Var = (f83) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                    loadingView.setVisibility(0);
                    b.put(viewGroup, f83Var);
                    if (a) {
                        Log.d("LoadingViewHelper", "The count of cached loading views is : " + b.size());
                        Log.d("LoadingViewHelper", "The content of cached views is : " + b.toString());
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void c(@NonNull c82 c82Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, c82Var) != null) || !(c82Var instanceof d83.a)) {
            return;
        }
        qm3.e0(new b(c82Var));
    }

    public static boolean d(ViewGroup viewGroup) {
        InterceptResult invokeL;
        f83 f83Var;
        View loadingView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, viewGroup)) == null) {
            if (viewGroup == null) {
                return false;
            }
            f83 f83Var2 = b.get(viewGroup);
            if (f83Var2 != null) {
                View loadingView2 = f83Var2.getLoadingView();
                if (loadingView2 != null) {
                    if (loadingView2 instanceof BdShimmerView) {
                        ((BdShimmerView) loadingView2).p();
                    }
                    loadingView2.setVisibility(8);
                    viewGroup.removeView(loadingView2);
                    b.remove(viewGroup);
                    if (a) {
                        Log.d("LoadingViewHelper", "The count of cached loading views is : " + b.size());
                        Log.d("LoadingViewHelper", "The content of cached views is : " + b.toString());
                    }
                }
                return true;
            }
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if ((viewGroup.getChildAt(i) instanceof f83) && (loadingView = (f83Var = (f83) viewGroup.getChildAt(i)).getLoadingView()) != null) {
                    loadingView.setVisibility(8);
                    viewGroup.removeView((View) f83Var);
                    b.remove(viewGroup);
                    if (a) {
                        Log.d("LoadingViewHelper", "The count of cached loading views is : " + b.size());
                        Log.d("LoadingViewHelper", "The content of cached views is : " + b.toString());
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void f(@NonNull d83 d83Var, @NonNull Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{d83Var, context, str, Boolean.valueOf(z)}) == null) {
            qm3.e0(new a(d83Var, context, str, z));
        }
    }

    public static boolean g(Context context, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, viewGroup)) == null) {
            return h(context, viewGroup, "");
        }
        return invokeLL.booleanValue;
    }

    public static boolean h(Context context, ViewGroup viewGroup, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, context, viewGroup, str)) == null) {
            if (context != null && viewGroup != null) {
                if (e(viewGroup)) {
                    return true;
                }
                LoadingView loadingView = new LoadingView(context);
                LoadingView loadingView2 = loadingView.getLoadingView();
                if (loadingView2 == null) {
                    return false;
                }
                if (!TextUtils.isEmpty(str)) {
                    loadingView2.setMsg(str);
                }
                ViewGroup viewGroup2 = (ViewGroup) loadingView2.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(loadingView2);
                }
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    viewGroup.addView(loadingView2, layoutParams);
                } else if (viewGroup instanceof LinearLayout) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 17;
                    viewGroup.addView(loadingView2, layoutParams2);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams3.gravity = 17;
                    viewGroup.addView(loadingView2, layoutParams3);
                }
                b.put(viewGroup, loadingView);
                loadingView2.setVisibility(0);
                if (a) {
                    Log.d("LoadingViewHelper", "The count of cached loading views is : " + b.size());
                    Log.d("LoadingViewHelper", "The content of cached views is : " + b.toString());
                }
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
