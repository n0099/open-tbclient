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
import com.baidu.tieba.w11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class i41 implements n41, z51, y51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public u41 a;
    public r41 b;
    public s41 c;
    public final Activity d;

    @Override // com.baidu.tieba.z51
    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z51
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
                    outline.setRoundRect(rect, w11.c.a(g71.a(), 0.0f));
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
                    outline.setRoundRect(rect, w11.c.a(g71.a(), 18.0f));
                }
            }
        }
    }

    public i41(Activity activity) {
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

    @Override // com.baidu.tieba.n41
    public void e(int i) {
        u41 u41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (u41Var = this.a) != null && (d = u41Var.d()) != null && (d.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
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

    @Override // com.baidu.tieba.n41
    public void o(k41 controlHelper) {
        s41 s41Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, controlHelper) == null) {
            Intrinsics.checkNotNullParameter(controlHelper, "controlHelper");
            u41 u41Var = this.a;
            if (u41Var != null) {
                s41 s41Var2 = new s41(u41Var);
                this.c = s41Var2;
                if (s41Var2 != null) {
                    s41Var2.q(this.b);
                }
                s41 s41Var3 = this.c;
                if (s41Var3 != null) {
                    s41Var3.o(controlHelper);
                }
                r41 r41Var = this.b;
                if (r41Var != null && r41Var.z() && (s41Var = this.c) != null) {
                    s41Var.k();
                }
                u41Var.n(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.n41
    public void a() {
        s41 s41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (s41Var = this.c) != null) {
            s41Var.j();
        }
    }

    @Override // com.baidu.tieba.n41
    public ViewGroup.LayoutParams b() {
        InterceptResult invokeV;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            u41 u41Var = this.a;
            if (u41Var != null && (d = u41Var.d()) != null) {
                return d.getLayoutParams();
            }
            return null;
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n41
    public void d() {
        u41 u41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (u41Var = this.a) != null && (d = u41Var.d()) != null && Build.VERSION.SDK_INT >= 21) {
            d.setOutlineProvider(new a(d));
            d.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.n41
    public boolean f() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            u41 u41Var = this.a;
            if (u41Var != null && (m = u41Var.m()) != null && m.c()) {
                u41 u41Var2 = this.a;
                if (u41Var2 != null) {
                    u41Var2.i();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.z51
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n41
    public boolean h() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            u41 u41Var = this.a;
            if (u41Var != null && (m = u41Var.m()) != null) {
                return m.y();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n41
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            s41 s41Var = this.c;
            if (s41Var != null) {
                return s41Var.h();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.n41
    public void onDestroy() {
        s41 s41Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            r41 r41Var = this.b;
            if (r41Var != null && r41Var.z() && (s41Var = this.c) != null) {
                s41Var.t();
            }
            u41 u41Var = this.a;
            if (u41Var != null) {
                u41Var.onPause();
            }
            u41 u41Var2 = this.a;
            if (u41Var2 != null) {
                u41Var2.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.y51
    public void p() {
        s41 s41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (s41Var = this.c) != null) {
            s41Var.g();
        }
    }

    @Override // com.baidu.tieba.n41
    public void u() {
        u41 u41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (u41Var = this.a) != null && (d = u41Var.d()) != null && Build.VERSION.SDK_INT >= 21) {
            d.setOutlineProvider(new b(d));
            d.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.n41
    public void c(View.OnLayoutChangeListener onLayoutChangeListener) {
        u41 u41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, onLayoutChangeListener) == null) && (u41Var = this.a) != null && (d = u41Var.d()) != null) {
            d.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.n41
    public void g(FrameLayout.LayoutParams params) {
        LinearLayout d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            u41 u41Var = this.a;
            if (u41Var != null && (d = u41Var.d()) != null) {
                d.setLayoutParams(params);
            }
        }
    }

    @Override // com.baidu.tieba.n41
    public void i(int i) {
        u41 u41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (u41Var = this.a) != null && (d = u41Var.d()) != null) {
            ViewGroup.LayoutParams layoutParams = d.getLayoutParams();
            layoutParams.height = i;
            d.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.n41
    public void j(r41 r41Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, r41Var) == null) {
            this.b = r41Var;
        }
    }

    @Override // com.baidu.tieba.n41
    public void k(boolean z) {
        s41 s41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (s41Var = this.c) != null) {
            s41Var.n(z);
        }
    }

    @Override // com.baidu.tieba.n41
    public void q(String str) {
        u41 u41Var;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (u41Var = this.a) != null && (m = u41Var.m()) != null) {
            AbsNadBrowserView.C(m, str, null, 2, null);
        }
    }

    @Override // com.baidu.tieba.n41
    public void r(View.OnLayoutChangeListener onLayoutChangeListener) {
        u41 u41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onLayoutChangeListener) == null) && (u41Var = this.a) != null && (d = u41Var.d()) != null) {
            d.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.n41
    public void t(p41 p41Var) {
        s41 s41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, p41Var) == null) && (s41Var = this.c) != null) {
            s41Var.p(p41Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r0.putExtra("lp_org_type", r2) != null) goto L34;
     */
    @Override // com.baidu.tieba.z51
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
            r41 r41Var = this.b;
            if (r41Var != null && (n = r41Var.n()) != null) {
                hashMap.put("url", n);
                hashMap.put("lp_real_url", n);
                intent.putExtra("url", n);
                intent.putExtra("lp_real_url", n);
            }
            r41 r41Var2 = this.b;
            if (r41Var2 != null && (m = r41Var2.m()) != null) {
                hashMap.put("sdk_script", m);
                intent.putExtra("sdk_script", m);
            }
            r41 r41Var3 = this.b;
            if (r41Var3 != null && (i = r41Var3.i()) != null) {
                hashMap.put("log_switch", i);
                intent.putExtra("log_switch", i);
            }
            r41 r41Var4 = this.b;
            if (r41Var4 != null && (f = r41Var4.f()) != null) {
                hashMap.put(MigrateStatisticUtils.EXT_INFO, f);
                intent.putExtra(MigrateStatisticUtils.EXT_INFO, f);
            }
            r41 r41Var5 = this.b;
            if (r41Var5 != null && (e = r41Var5.e()) != null) {
                hashMap.put("charge_url", e);
                intent.putExtra("charge_url", e);
            }
            r41 r41Var6 = this.b;
            if (r41Var6 != null && (j = r41Var6.j()) != null) {
                hashMap.put("lp_org_type", j);
            }
            hashMap.put("lp_org_type", "pop_web");
            intent.putExtra("lp_org_type", "pop_web");
            r41 r41Var7 = this.b;
            if (r41Var7 != null && (b2 = r41Var7.b()) != null) {
                hashMap.put("ad_invoke_flag", b2);
                intent.putExtra("ad_invoke_flag", b2);
            }
            intent.putExtra("map", hashMap);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.n41
    public void m(ViewGroup parent) {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ViewGroup viewGroup = null;
            WebPanelBrowserContainer webPanelBrowserContainer = new WebPanelBrowserContainer(this, new a51(), null);
            this.a = webPanelBrowserContainer;
            webPanelBrowserContainer.E0(false);
            webPanelBrowserContainer.D0(false);
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

    @Override // com.baidu.tieba.n41
    public void s(int i, boolean z) {
        s41 s41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (s41Var = this.c) != null) {
            s41Var.i(i, z);
        }
    }
}
