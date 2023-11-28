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
import com.baidu.tieba.u11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class g41 implements l41, x51, w51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public s41 a;
    public p41 b;
    public q41 c;
    public final Activity d;

    @Override // com.baidu.tieba.x51
    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.x51
    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
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
                    outline.setRoundRect(rect, u11.c.a(e71.a(), 0.0f));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                    outline.setRoundRect(rect, u11.c.a(e71.a(), 18.0f));
                }
            }
        }
    }

    public g41(Activity activity) {
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

    @Override // com.baidu.tieba.l41
    public void e(int i) {
        s41 s41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (s41Var = this.a) != null && (d = s41Var.d()) != null && (d.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            ViewGroup.LayoutParams layoutParams = d.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = i;
                d.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    @Override // com.baidu.tieba.l41
    public void o(i41 controlHelper) {
        q41 q41Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, controlHelper) == null) {
            Intrinsics.checkNotNullParameter(controlHelper, "controlHelper");
            s41 s41Var = this.a;
            if (s41Var != null) {
                q41 q41Var2 = new q41(s41Var);
                this.c = q41Var2;
                if (q41Var2 != null) {
                    q41Var2.q(this.b);
                }
                q41 q41Var3 = this.c;
                if (q41Var3 != null) {
                    q41Var3.o(controlHelper);
                }
                p41 p41Var = this.b;
                if (p41Var != null && p41Var.z() && (q41Var = this.c) != null) {
                    q41Var.k();
                }
                s41Var.n(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.l41
    public void a() {
        q41 q41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (q41Var = this.c) != null) {
            q41Var.j();
        }
    }

    @Override // com.baidu.tieba.l41
    public ViewGroup.LayoutParams b() {
        InterceptResult invokeV;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            s41 s41Var = this.a;
            if (s41Var != null && (d = s41Var.d()) != null) {
                return d.getLayoutParams();
            }
            return null;
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l41
    public void d() {
        s41 s41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (s41Var = this.a) != null && (d = s41Var.d()) != null && Build.VERSION.SDK_INT >= 21) {
            d.setOutlineProvider(new a(d));
            d.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.l41
    public boolean f() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            s41 s41Var = this.a;
            if (s41Var != null && (m = s41Var.m()) != null && m.c()) {
                s41 s41Var2 = this.a;
                if (s41Var2 != null) {
                    s41Var2.i();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.x51
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l41
    public boolean h() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            s41 s41Var = this.a;
            if (s41Var != null && (m = s41Var.m()) != null) {
                return m.y();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l41
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            q41 q41Var = this.c;
            if (q41Var != null) {
                return q41Var.h();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.l41
    public void onDestroy() {
        q41 q41Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            p41 p41Var = this.b;
            if (p41Var != null && p41Var.z() && (q41Var = this.c) != null) {
                q41Var.t();
            }
            s41 s41Var = this.a;
            if (s41Var != null) {
                s41Var.onPause();
            }
            s41 s41Var2 = this.a;
            if (s41Var2 != null) {
                s41Var2.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.w51
    public void p() {
        q41 q41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (q41Var = this.c) != null) {
            q41Var.g();
        }
    }

    @Override // com.baidu.tieba.l41
    public void u() {
        s41 s41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (s41Var = this.a) != null && (d = s41Var.d()) != null && Build.VERSION.SDK_INT >= 21) {
            d.setOutlineProvider(new b(d));
            d.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.l41
    public void c(View.OnLayoutChangeListener onLayoutChangeListener) {
        s41 s41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, onLayoutChangeListener) == null) && (s41Var = this.a) != null && (d = s41Var.d()) != null) {
            d.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.l41
    public void g(FrameLayout.LayoutParams params) {
        LinearLayout d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            s41 s41Var = this.a;
            if (s41Var != null && (d = s41Var.d()) != null) {
                d.setLayoutParams(params);
            }
        }
    }

    @Override // com.baidu.tieba.l41
    public void i(int i) {
        s41 s41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (s41Var = this.a) != null && (d = s41Var.d()) != null) {
            ViewGroup.LayoutParams layoutParams = d.getLayoutParams();
            layoutParams.height = i;
            d.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.l41
    public void j(p41 p41Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, p41Var) == null) {
            this.b = p41Var;
        }
    }

    @Override // com.baidu.tieba.l41
    public void k(boolean z) {
        q41 q41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (q41Var = this.c) != null) {
            q41Var.n(z);
        }
    }

    @Override // com.baidu.tieba.l41
    public void q(String str) {
        s41 s41Var;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (s41Var = this.a) != null && (m = s41Var.m()) != null) {
            AbsNadBrowserView.C(m, str, null, 2, null);
        }
    }

    @Override // com.baidu.tieba.l41
    public void r(View.OnLayoutChangeListener onLayoutChangeListener) {
        s41 s41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onLayoutChangeListener) == null) && (s41Var = this.a) != null && (d = s41Var.d()) != null) {
            d.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.l41
    public void t(n41 n41Var) {
        q41 q41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, n41Var) == null) && (q41Var = this.c) != null) {
            q41Var.p(n41Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r0.putExtra("lp_org_type", r2) != null) goto L34;
     */
    @Override // com.baidu.tieba.x51
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
            p41 p41Var = this.b;
            if (p41Var != null && (n = p41Var.n()) != null) {
                hashMap.put("url", n);
                hashMap.put("lp_real_url", n);
                intent.putExtra("url", n);
                intent.putExtra("lp_real_url", n);
            }
            p41 p41Var2 = this.b;
            if (p41Var2 != null && (m = p41Var2.m()) != null) {
                hashMap.put("sdk_script", m);
                intent.putExtra("sdk_script", m);
            }
            p41 p41Var3 = this.b;
            if (p41Var3 != null && (i = p41Var3.i()) != null) {
                hashMap.put("log_switch", i);
                intent.putExtra("log_switch", i);
            }
            p41 p41Var4 = this.b;
            if (p41Var4 != null && (f = p41Var4.f()) != null) {
                hashMap.put(MigrateStatisticUtils.EXT_INFO, f);
                intent.putExtra(MigrateStatisticUtils.EXT_INFO, f);
            }
            p41 p41Var5 = this.b;
            if (p41Var5 != null && (e = p41Var5.e()) != null) {
                hashMap.put("charge_url", e);
                intent.putExtra("charge_url", e);
            }
            p41 p41Var6 = this.b;
            if (p41Var6 != null && (j = p41Var6.j()) != null) {
                hashMap.put("lp_org_type", j);
            }
            hashMap.put("lp_org_type", "pop_web");
            intent.putExtra("lp_org_type", "pop_web");
            p41 p41Var7 = this.b;
            if (p41Var7 != null && (b2 = p41Var7.b()) != null) {
                hashMap.put("ad_invoke_flag", b2);
                intent.putExtra("ad_invoke_flag", b2);
            }
            intent.putExtra("map", hashMap);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.l41
    public void m(ViewGroup parent) {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ViewGroup viewGroup = null;
            WebPanelBrowserContainer webPanelBrowserContainer = new WebPanelBrowserContainer(this, new y41(), null);
            this.a = webPanelBrowserContainer;
            webPanelBrowserContainer.y0(false);
            webPanelBrowserContainer.x0(false);
            webPanelBrowserContainer.v();
            webPanelBrowserContainer.B(this);
            webPanelBrowserContainer.y();
            u();
            LinearLayout d = webPanelBrowserContainer.d();
            if (d != null) {
                d.setPadding(0, 0, 0, PanelScrollView.B);
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

    @Override // com.baidu.tieba.l41
    public void s(int i, boolean z) {
        q41 q41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (q41Var = this.c) != null) {
            q41Var.i(i, z);
        }
    }
}
