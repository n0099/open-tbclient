package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.webpanel.PanelScrollView;
import com.baidu.nadcore.webpanel.proxy.WebPanelBrowserContainer;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.t41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class b71 implements f71, r81, q81 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m71 a;
    public j71 b;
    public k71 c;
    public final Activity d;

    @Override // com.baidu.tieba.r81, com.baidu.tieba.ca1
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.tieba.r81, com.baidu.tieba.ca1
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public static final class a extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinearLayout a;

        public a(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = linearLayout;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view2, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, outline) == null) {
                Rect rect = new Rect(0, 0, this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
                if (outline != null) {
                    outline.setRoundRect(rect, t41.c.a(jb1.a(), 0.0f));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends ViewOutlineProvider {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LinearLayout a;

        public b(LinearLayout linearLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {linearLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = linearLayout;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view2, Outline outline) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, outline) == null) {
                Rect rect = new Rect(0, 0, this.a.getMeasuredWidth(), this.a.getMeasuredHeight());
                if (outline != null) {
                    outline.setRoundRect(rect, t41.c.a(jb1.a(), 18.0f));
                }
            }
        }
    }

    public b71(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.d = activity;
    }

    @Override // com.baidu.tieba.f71
    public void g(int i) {
        m71 m71Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (m71Var = this.a) != null && (e = m71Var.e()) != null && (e.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            ViewGroup.LayoutParams layoutParams = e.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = i;
                e.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    @Override // com.baidu.tieba.f71
    public void p(d71 controlHelper) {
        k71 k71Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, controlHelper) == null) {
            Intrinsics.checkNotNullParameter(controlHelper, "controlHelper");
            m71 m71Var = this.a;
            if (m71Var != null) {
                k71 k71Var2 = new k71(m71Var);
                this.c = k71Var2;
                if (k71Var2 != null) {
                    k71Var2.q(this.b);
                }
                k71 k71Var3 = this.c;
                if (k71Var3 != null) {
                    k71Var3.o(controlHelper);
                }
                j71 j71Var = this.b;
                if (j71Var != null && j71Var.t() && (k71Var = this.c) != null) {
                    k71Var.k();
                }
                m71Var.n(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.f71
    public void a() {
        k71 k71Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (k71Var = this.c) != null) {
            k71Var.j();
        }
    }

    @Override // com.baidu.tieba.f71
    public ViewGroup.LayoutParams b() {
        InterceptResult invokeV;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            m71 m71Var = this.a;
            if (m71Var != null && (e = m71Var.e()) != null) {
                return e.getLayoutParams();
            }
            return null;
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f71
    public void e() {
        m71 m71Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (m71Var = this.a) != null && (e = m71Var.e()) != null && Build.VERSION.SDK_INT >= 21) {
            e.setOutlineProvider(new a(e));
            e.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.r81, com.baidu.tieba.ca1
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f71
    public boolean h() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            m71 m71Var = this.a;
            if (m71Var != null && (m = m71Var.m()) != null && m.d()) {
                m71 m71Var2 = this.a;
                if (m71Var2 != null) {
                    m71Var2.g();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.f71
    public boolean j() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            m71 m71Var = this.a;
            if (m71Var != null && (m = m71Var.m()) != null) {
                return m.w();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.f71
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            k71 k71Var = this.c;
            if (k71Var != null) {
                return k71Var.h();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.f71
    public void onDestroy() {
        k71 k71Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            j71 j71Var = this.b;
            if (j71Var != null && j71Var.t() && (k71Var = this.c) != null) {
                k71Var.t();
            }
            m71 m71Var = this.a;
            if (m71Var != null) {
                m71Var.onPause();
            }
            m71 m71Var2 = this.a;
            if (m71Var2 != null) {
                m71Var2.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.q81
    public void q() {
        k71 k71Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (k71Var = this.c) != null) {
            k71Var.g();
        }
    }

    @Override // com.baidu.tieba.f71
    public void v() {
        m71 m71Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (m71Var = this.a) != null && (e = m71Var.e()) != null && Build.VERSION.SDK_INT >= 21) {
            e.setOutlineProvider(new b(e));
            e.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.f71
    public void c(View.OnLayoutChangeListener onLayoutChangeListener) {
        m71 m71Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onLayoutChangeListener) == null) && (m71Var = this.a) != null && (e = m71Var.e()) != null) {
            e.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.f71
    public void i(FrameLayout.LayoutParams params) {
        LinearLayout e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            m71 m71Var = this.a;
            if (m71Var != null && (e = m71Var.e()) != null) {
                e.setLayoutParams(params);
            }
        }
    }

    @Override // com.baidu.tieba.f71
    public void k(int i) {
        m71 m71Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048588, this, i) == null) && (m71Var = this.a) != null && (e = m71Var.e()) != null) {
            ViewGroup.LayoutParams layoutParams = e.getLayoutParams();
            layoutParams.height = i;
            e.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.f71
    public void l(j71 j71Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, j71Var) == null) {
            this.b = j71Var;
        }
    }

    @Override // com.baidu.tieba.f71
    public void m(boolean z) {
        k71 k71Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (k71Var = this.c) != null) {
            k71Var.n(z);
        }
    }

    @Override // com.baidu.tieba.f71
    public void r(String str) {
        m71 m71Var;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (m71Var = this.a) != null && (m = m71Var.m()) != null) {
            AbsNadBrowserView.B(m, str, null, 2, null);
        }
    }

    @Override // com.baidu.tieba.f71
    public void s(View.OnLayoutChangeListener onLayoutChangeListener) {
        m71 m71Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onLayoutChangeListener) == null) && (m71Var = this.a) != null && (e = m71Var.e()) != null) {
            e.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.f71
    public void u(h71 h71Var) {
        k71 k71Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, h71Var) == null) && (k71Var = this.c) != null) {
            k71Var.p(h71Var);
        }
    }

    @Override // com.baidu.tieba.r81, com.baidu.tieba.ca1
    public Intent getIntent() {
        InterceptResult invokeV;
        String b2;
        String c;
        String f;
        String h;
        String i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Intent intent = new Intent();
            HashMap hashMap = new HashMap();
            j71 j71Var = this.b;
            if (j71Var != null && (i = j71Var.i()) != null) {
                hashMap.put("url", i);
                hashMap.put("lp_real_url", i);
                intent.putExtra("url", i);
                intent.putExtra("lp_real_url", i);
            }
            j71 j71Var2 = this.b;
            if (j71Var2 != null && (h = j71Var2.h()) != null) {
                hashMap.put("sdk_script", h);
                intent.putExtra("sdk_script", h);
            }
            j71 j71Var3 = this.b;
            if (j71Var3 != null && (f = j71Var3.f()) != null) {
                hashMap.put("log_switch", f);
                intent.putExtra("log_switch", f);
            }
            j71 j71Var4 = this.b;
            if (j71Var4 != null && (c = j71Var4.c()) != null) {
                hashMap.put("ext_info", c);
                intent.putExtra("ext_info", c);
            }
            j71 j71Var5 = this.b;
            if (j71Var5 != null && (b2 = j71Var5.b()) != null) {
                hashMap.put("charge_url", b2);
                intent.putExtra("charge_url", b2);
            }
            hashMap.put("lp_org_type", "pop_web");
            intent.putExtra("lp_org_type", "pop_web");
            intent.putExtra("map", hashMap);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.f71
    public void o(ViewGroup parent) {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ViewGroup viewGroup = null;
            WebPanelBrowserContainer webPanelBrowserContainer = new WebPanelBrowserContainer(this, new s71(), null);
            this.a = webPanelBrowserContainer;
            webPanelBrowserContainer.t0(false);
            webPanelBrowserContainer.s0(false);
            webPanelBrowserContainer.t();
            webPanelBrowserContainer.z(this);
            webPanelBrowserContainer.v();
            v();
            LinearLayout e = webPanelBrowserContainer.e();
            if (e != null) {
                e.setPadding(0, 0, 0, PanelScrollView.A);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            FrameLayout h = webPanelBrowserContainer.h();
            if (h != null) {
                viewParent = h.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                viewGroup = viewParent;
            }
            ViewGroup viewGroup2 = viewGroup;
            if (viewGroup2 != null) {
                viewGroup2.removeView(h);
            }
            parent.addView(h, layoutParams);
        }
    }

    @Override // com.baidu.tieba.f71
    public void t(int i, boolean z) {
        k71 k71Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (k71Var = this.c) != null) {
            k71Var.i(i, z);
        }
    }
}
