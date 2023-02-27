package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.container.PullToRefreshBaseWebView;
import com.baidu.swan.apps.view.SwanAppNARootViewScrollView;
import com.baidu.swan.apps.view.narootview.SwanAppInlineFullScreenContainer;
import com.baidu.tieba.tv1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ap3<T extends tv1> implements za2, qo3, PullToRefreshBaseWebView.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public transient /* synthetic */ FieldHolder $fh;
    public FrameLayout a;
    public FrameLayout b;
    public T c;
    public PullToRefreshBaseWebView d;
    public Context e;
    public sv1 f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947622821, "Lcom/baidu/tieba/ap3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947622821, "Lcom/baidu/tieba/ap3;");
                return;
            }
        }
        g = wp1.a;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f.U(this);
        }
    }

    public ap3(Context context, @NonNull sv1<T> sv1Var, @NonNull FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, sv1Var, frameLayout};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = context;
        this.a = frameLayout;
        this.f = sv1Var;
        e(sv1Var);
    }

    @Override // com.baidu.tieba.qo3
    public boolean a(View view2, sz2 sz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, sz2Var)) == null) {
            if (view2 == null || this.b == null || sz2Var == null) {
                return false;
            }
            if (g) {
                Log.d("NAParentViewManager", "updateView pos: " + sz2Var);
            }
            if (d(view2, this.b)) {
                Object tag = view2.getTag(R.id.obfuscated_res_0x7f0901a0);
                if (tag instanceof bp3) {
                    bp3 bp3Var = (bp3) tag;
                    cp3.a(bp3Var, sz2Var);
                    view2.setTag(R.id.obfuscated_res_0x7f0901a0, bp3Var);
                }
                this.b.updateViewLayout(view2, cp3.b(this.c, sz2Var));
            } else if (!g(view2)) {
                return false;
            } else {
                Object tag2 = view2.getTag(R.id.obfuscated_res_0x7f0901a0);
                if (tag2 instanceof bp3) {
                    bp3 bp3Var2 = (bp3) tag2;
                    cp3.a(bp3Var2, sz2Var);
                    view2.setTag(R.id.obfuscated_res_0x7f0901a0, bp3Var2);
                }
                ((ViewGroup) view2.getParent()).updateViewLayout(view2, cp3.b(this.c, sz2Var));
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.swan.apps.core.container.PullToRefreshBaseWebView.a
    public void b(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            this.b.scrollTo(i, i2);
        }
    }

    @Override // com.baidu.tieba.qo3
    public boolean c(View view2, sz2 sz2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, sz2Var)) == null) {
            if (this.e != null && sz2Var != null) {
                bp3 bp3Var = new bp3();
                cp3.a(bp3Var, sz2Var);
                view2.setTag(R.id.obfuscated_res_0x7f0901a0, bp3Var);
                if (this.b.indexOfChild(view2) >= 0) {
                    f62.a("NAParentViewManager", "repeat insert view!");
                    this.b.removeView(view2);
                }
                this.b.addView(view2, cp3.b(this.c, sz2Var));
                return true;
            } else if (g) {
                Log.d("NAParentViewManager", "insertView failed");
                return false;
            } else {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final boolean d(View view2, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, viewGroup)) == null) {
            if (view2 == null || viewGroup == null || view2.getParent() != viewGroup || viewGroup.indexOfChild(view2) < 0) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean e(sv1<T> sv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sv1Var)) == null) {
            if (g) {
                Log.d("NAParentViewManager", "createViewAndListener");
            }
            sv1Var.t(this);
            T r = sv1Var.r();
            this.c = r;
            if (r == null) {
                return false;
            }
            SwanAppNARootViewScrollView swanAppNARootViewScrollView = new SwanAppNARootViewScrollView(this.e);
            this.a.addView(swanAppNARootViewScrollView, new FrameLayout.LayoutParams(-1, -1));
            this.b = new FrameLayout(this.e);
            swanAppNARootViewScrollView.addView(this.b, new FrameLayout.LayoutParams(-1, -1));
            swanAppNARootViewScrollView.setFillViewport(true);
            PullToRefreshBaseWebView h0 = sv1Var.h0();
            this.d = h0;
            if (h0 != null) {
                h0.setOnPullToRefreshScrollChangeListener(this);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean g(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            return view2.getParent() instanceof SwanAppInlineFullScreenContainer;
        }
        return invokeL.booleanValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.b.setVisibility(i);
        }
    }

    @Override // com.baidu.tieba.za2
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2, i3, i4) == null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.b.getLayoutParams();
            marginLayoutParams.leftMargin = -i;
            marginLayoutParams.topMargin = -i2;
            this.b.setLayoutParams(marginLayoutParams);
            for (int i5 = 0; i5 < this.b.getChildCount(); i5++) {
                View childAt = this.b.getChildAt(i5);
                if (childAt != null) {
                    Object tag = childAt.getTag(R.id.obfuscated_res_0x7f0901a0);
                    bp3 bp3Var = null;
                    if (tag instanceof bp3) {
                        bp3Var = (bp3) tag;
                    }
                    if (bp3Var != null && bp3Var.d()) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                        marginLayoutParams2.leftMargin = bp3Var.b() + i;
                        marginLayoutParams2.topMargin = bp3Var.c() + i2;
                        childAt.setLayoutParams(marginLayoutParams2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.qo3
    public boolean removeView(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, view2)) == null) {
            if (d(view2, this.b)) {
                try {
                    this.b.removeView(view2);
                } catch (Exception e) {
                    if (g) {
                        e.printStackTrace();
                    }
                }
                return true;
            } else if (g(view2)) {
                try {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                } catch (Exception e2) {
                    if (g) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
