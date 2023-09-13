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
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.tieba.q61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class c91 implements h91, ta1, sa1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o91 a;
    public l91 b;
    public m91 c;
    public final Activity d;

    @Override // com.baidu.tieba.ta1
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ta1
    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
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
                    outline.setRoundRect(rect, q61.c.a(ac1.a(), 0.0f));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
                    outline.setRoundRect(rect, q61.c.a(ac1.a(), 18.0f));
                }
            }
        }
    }

    public c91(Activity activity) {
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

    @Override // com.baidu.tieba.h91
    public void e(int i) {
        o91 o91Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (o91Var = this.a) != null && (e = o91Var.e()) != null && (e.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
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

    @Override // com.baidu.tieba.h91
    public void o(e91 controlHelper) {
        m91 m91Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, controlHelper) == null) {
            Intrinsics.checkNotNullParameter(controlHelper, "controlHelper");
            o91 o91Var = this.a;
            if (o91Var != null) {
                m91 m91Var2 = new m91(o91Var);
                this.c = m91Var2;
                if (m91Var2 != null) {
                    m91Var2.q(this.b);
                }
                m91 m91Var3 = this.c;
                if (m91Var3 != null) {
                    m91Var3.o(controlHelper);
                }
                l91 l91Var = this.b;
                if (l91Var != null && l91Var.z() && (m91Var = this.c) != null) {
                    m91Var.k();
                }
                o91Var.n(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.h91
    public void a() {
        m91 m91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (m91Var = this.c) != null) {
            m91Var.j();
        }
    }

    @Override // com.baidu.tieba.h91
    public ViewGroup.LayoutParams b() {
        InterceptResult invokeV;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            o91 o91Var = this.a;
            if (o91Var != null && (e = o91Var.e()) != null) {
                return e.getLayoutParams();
            }
            return null;
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h91
    public void d() {
        o91 o91Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (o91Var = this.a) != null && (e = o91Var.e()) != null && Build.VERSION.SDK_INT >= 21) {
            e.setOutlineProvider(new a(e));
            e.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.h91
    public boolean f() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            o91 o91Var = this.a;
            if (o91Var != null && (m = o91Var.m()) != null && m.d()) {
                o91 o91Var2 = this.a;
                if (o91Var2 != null) {
                    o91Var2.i();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ta1
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h91
    public boolean h() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            o91 o91Var = this.a;
            if (o91Var != null && (m = o91Var.m()) != null) {
                return m.x();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h91
    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            m91 m91Var = this.c;
            if (m91Var != null) {
                return m91Var.h();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.h91
    public void onDestroy() {
        m91 m91Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            l91 l91Var = this.b;
            if (l91Var != null && l91Var.z() && (m91Var = this.c) != null) {
                m91Var.t();
            }
            o91 o91Var = this.a;
            if (o91Var != null) {
                o91Var.onPause();
            }
            o91 o91Var2 = this.a;
            if (o91Var2 != null) {
                o91Var2.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.sa1
    public void p() {
        m91 m91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (m91Var = this.c) != null) {
            m91Var.g();
        }
    }

    @Override // com.baidu.tieba.h91
    public void u() {
        o91 o91Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (o91Var = this.a) != null && (e = o91Var.e()) != null && Build.VERSION.SDK_INT >= 21) {
            e.setOutlineProvider(new b(e));
            e.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.h91
    public void c(View.OnLayoutChangeListener onLayoutChangeListener) {
        o91 o91Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, onLayoutChangeListener) == null) && (o91Var = this.a) != null && (e = o91Var.e()) != null) {
            e.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.h91
    public void g(FrameLayout.LayoutParams params) {
        LinearLayout e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            o91 o91Var = this.a;
            if (o91Var != null && (e = o91Var.e()) != null) {
                e.setLayoutParams(params);
            }
        }
    }

    @Override // com.baidu.tieba.h91
    public void i(int i) {
        o91 o91Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (o91Var = this.a) != null && (e = o91Var.e()) != null) {
            ViewGroup.LayoutParams layoutParams = e.getLayoutParams();
            layoutParams.height = i;
            e.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.h91
    public void j(l91 l91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, l91Var) == null) {
            this.b = l91Var;
        }
    }

    @Override // com.baidu.tieba.h91
    public void k(boolean z) {
        m91 m91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (m91Var = this.c) != null) {
            m91Var.n(z);
        }
    }

    @Override // com.baidu.tieba.h91
    public void q(String str) {
        o91 o91Var;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (o91Var = this.a) != null && (m = o91Var.m()) != null) {
            AbsNadBrowserView.C(m, str, null, 2, null);
        }
    }

    @Override // com.baidu.tieba.h91
    public void r(View.OnLayoutChangeListener onLayoutChangeListener) {
        o91 o91Var;
        LinearLayout e;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onLayoutChangeListener) == null) && (o91Var = this.a) != null && (e = o91Var.e()) != null) {
            e.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.h91
    public void t(j91 j91Var) {
        m91 m91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, j91Var) == null) && (m91Var = this.c) != null) {
            m91Var.p(j91Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r0.putExtra("lp_org_type", r2) != null) goto L34;
     */
    @Override // com.baidu.tieba.ta1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Intent getIntent() {
        InterceptResult invokeV;
        String b2;
        String j;
        String e;
        String f;
        String i;
        String m;
        String n;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Intent intent = new Intent();
            HashMap hashMap = new HashMap();
            l91 l91Var = this.b;
            if (l91Var != null && (n = l91Var.n()) != null) {
                hashMap.put("url", n);
                hashMap.put("lp_real_url", n);
                intent.putExtra("url", n);
                intent.putExtra("lp_real_url", n);
            }
            l91 l91Var2 = this.b;
            if (l91Var2 != null && (m = l91Var2.m()) != null) {
                hashMap.put("sdk_script", m);
                intent.putExtra("sdk_script", m);
            }
            l91 l91Var3 = this.b;
            if (l91Var3 != null && (i = l91Var3.i()) != null) {
                hashMap.put("log_switch", i);
                intent.putExtra("log_switch", i);
            }
            l91 l91Var4 = this.b;
            if (l91Var4 != null && (f = l91Var4.f()) != null) {
                hashMap.put(MigrateStatisticUtils.EXT_INFO, f);
                intent.putExtra(MigrateStatisticUtils.EXT_INFO, f);
            }
            l91 l91Var5 = this.b;
            if (l91Var5 != null && (e = l91Var5.e()) != null) {
                hashMap.put("charge_url", e);
                intent.putExtra("charge_url", e);
            }
            l91 l91Var6 = this.b;
            if (l91Var6 != null && (j = l91Var6.j()) != null) {
                hashMap.put("lp_org_type", j);
            }
            hashMap.put("lp_org_type", "pop_web");
            intent.putExtra("lp_org_type", "pop_web");
            l91 l91Var7 = this.b;
            if (l91Var7 != null && (b2 = l91Var7.b()) != null) {
                hashMap.put("ad_invoke_flag", b2);
                intent.putExtra("ad_invoke_flag", b2);
            }
            intent.putExtra("map", hashMap);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h91
    public void n(ViewGroup parent) {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ViewGroup viewGroup = null;
            WebPanelBrowserContainer webPanelBrowserContainer = new WebPanelBrowserContainer(this, new u91(), null);
            this.a = webPanelBrowserContainer;
            webPanelBrowserContainer.u0(false);
            webPanelBrowserContainer.t0(false);
            webPanelBrowserContainer.u();
            webPanelBrowserContainer.A(this);
            webPanelBrowserContainer.w();
            u();
            LinearLayout e = webPanelBrowserContainer.e();
            if (e != null) {
                e.setPadding(0, 0, 0, PanelScrollView.B);
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            FrameLayout j = webPanelBrowserContainer.j();
            if (j != null) {
                viewParent = j.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                viewGroup = viewParent;
            }
            ViewGroup viewGroup2 = viewGroup;
            if (viewGroup2 != null) {
                viewGroup2.removeView(j);
            }
            parent.addView(j, layoutParams);
        }
    }

    @Override // com.baidu.tieba.h91
    public void s(int i, boolean z) {
        m91 m91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (m91Var = this.c) != null) {
            m91Var.i(i, z);
        }
    }
}
