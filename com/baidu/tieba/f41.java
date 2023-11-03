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
import com.baidu.tieba.t11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class f41 implements k41, w51, v51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r41 a;
    public o41 b;
    public p41 c;
    public final Activity d;

    @Override // com.baidu.tieba.w51
    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.w51
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
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
                    outline.setRoundRect(rect, t11.c.a(d71.a(), 0.0f));
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
                    outline.setRoundRect(rect, t11.c.a(d71.a(), 18.0f));
                }
            }
        }
    }

    public f41(Activity activity) {
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

    @Override // com.baidu.tieba.k41
    public void e(int i) {
        r41 r41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && (r41Var = this.a) != null && (d = r41Var.d()) != null && (d.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
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

    @Override // com.baidu.tieba.k41
    public void o(h41 controlHelper) {
        p41 p41Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, controlHelper) == null) {
            Intrinsics.checkNotNullParameter(controlHelper, "controlHelper");
            r41 r41Var = this.a;
            if (r41Var != null) {
                p41 p41Var2 = new p41(r41Var);
                this.c = p41Var2;
                if (p41Var2 != null) {
                    p41Var2.q(this.b);
                }
                p41 p41Var3 = this.c;
                if (p41Var3 != null) {
                    p41Var3.o(controlHelper);
                }
                o41 o41Var = this.b;
                if (o41Var != null && o41Var.z() && (p41Var = this.c) != null) {
                    p41Var.k();
                }
                r41Var.n(this.c);
            }
        }
    }

    @Override // com.baidu.tieba.k41
    public void a() {
        p41 p41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (p41Var = this.c) != null) {
            p41Var.j();
        }
    }

    @Override // com.baidu.tieba.k41
    public ViewGroup.LayoutParams b() {
        InterceptResult invokeV;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            r41 r41Var = this.a;
            if (r41Var != null && (d = r41Var.d()) != null) {
                return d.getLayoutParams();
            }
            return null;
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k41
    public void d() {
        r41 r41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (r41Var = this.a) != null && (d = r41Var.d()) != null && Build.VERSION.SDK_INT >= 21) {
            d.setOutlineProvider(new a(d));
            d.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.k41
    public boolean f() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            r41 r41Var = this.a;
            if (r41Var != null && (m = r41Var.m()) != null && m.c()) {
                r41 r41Var2 = this.a;
                if (r41Var2 != null) {
                    r41Var2.i();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.w51
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k41
    public boolean h() {
        InterceptResult invokeV;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            r41 r41Var = this.a;
            if (r41Var != null && (m = r41Var.m()) != null) {
                return m.y();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k41
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            p41 p41Var = this.c;
            if (p41Var != null) {
                return p41Var.h();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.k41
    public void onDestroy() {
        p41 p41Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            o41 o41Var = this.b;
            if (o41Var != null && o41Var.z() && (p41Var = this.c) != null) {
                p41Var.t();
            }
            r41 r41Var = this.a;
            if (r41Var != null) {
                r41Var.onPause();
            }
            r41 r41Var2 = this.a;
            if (r41Var2 != null) {
                r41Var2.onDestroy();
            }
        }
    }

    @Override // com.baidu.tieba.v51
    public void p() {
        p41 p41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (p41Var = this.c) != null) {
            p41Var.g();
        }
    }

    @Override // com.baidu.tieba.k41
    public void u() {
        r41 r41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (r41Var = this.a) != null && (d = r41Var.d()) != null && Build.VERSION.SDK_INT >= 21) {
            d.setOutlineProvider(new b(d));
            d.setClipToOutline(true);
        }
    }

    @Override // com.baidu.tieba.k41
    public void c(View.OnLayoutChangeListener onLayoutChangeListener) {
        r41 r41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, onLayoutChangeListener) == null) && (r41Var = this.a) != null && (d = r41Var.d()) != null) {
            d.removeOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.k41
    public void g(FrameLayout.LayoutParams params) {
        LinearLayout d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, params) == null) {
            Intrinsics.checkNotNullParameter(params, "params");
            r41 r41Var = this.a;
            if (r41Var != null && (d = r41Var.d()) != null) {
                d.setLayoutParams(params);
            }
        }
    }

    @Override // com.baidu.tieba.k41
    public void i(int i) {
        r41 r41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048587, this, i) == null) && (r41Var = this.a) != null && (d = r41Var.d()) != null) {
            ViewGroup.LayoutParams layoutParams = d.getLayoutParams();
            layoutParams.height = i;
            d.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.k41
    public void j(o41 o41Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, o41Var) == null) {
            this.b = o41Var;
        }
    }

    @Override // com.baidu.tieba.k41
    public void k(boolean z) {
        p41 p41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (p41Var = this.c) != null) {
            p41Var.n(z);
        }
    }

    @Override // com.baidu.tieba.k41
    public void q(String str) {
        r41 r41Var;
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, str) == null) && (r41Var = this.a) != null && (m = r41Var.m()) != null) {
            AbsNadBrowserView.C(m, str, null, 2, null);
        }
    }

    @Override // com.baidu.tieba.k41
    public void r(View.OnLayoutChangeListener onLayoutChangeListener) {
        r41 r41Var;
        LinearLayout d;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, onLayoutChangeListener) == null) && (r41Var = this.a) != null && (d = r41Var.d()) != null) {
            d.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    @Override // com.baidu.tieba.k41
    public void t(m41 m41Var) {
        p41 p41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, m41Var) == null) && (p41Var = this.c) != null) {
            p41Var.p(m41Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r0.putExtra("lp_org_type", r2) != null) goto L34;
     */
    @Override // com.baidu.tieba.w51
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
            o41 o41Var = this.b;
            if (o41Var != null && (n = o41Var.n()) != null) {
                hashMap.put("url", n);
                hashMap.put("lp_real_url", n);
                intent.putExtra("url", n);
                intent.putExtra("lp_real_url", n);
            }
            o41 o41Var2 = this.b;
            if (o41Var2 != null && (m = o41Var2.m()) != null) {
                hashMap.put("sdk_script", m);
                intent.putExtra("sdk_script", m);
            }
            o41 o41Var3 = this.b;
            if (o41Var3 != null && (i = o41Var3.i()) != null) {
                hashMap.put("log_switch", i);
                intent.putExtra("log_switch", i);
            }
            o41 o41Var4 = this.b;
            if (o41Var4 != null && (f = o41Var4.f()) != null) {
                hashMap.put(MigrateStatisticUtils.EXT_INFO, f);
                intent.putExtra(MigrateStatisticUtils.EXT_INFO, f);
            }
            o41 o41Var5 = this.b;
            if (o41Var5 != null && (e = o41Var5.e()) != null) {
                hashMap.put("charge_url", e);
                intent.putExtra("charge_url", e);
            }
            o41 o41Var6 = this.b;
            if (o41Var6 != null && (j = o41Var6.j()) != null) {
                hashMap.put("lp_org_type", j);
            }
            hashMap.put("lp_org_type", "pop_web");
            intent.putExtra("lp_org_type", "pop_web");
            o41 o41Var7 = this.b;
            if (o41Var7 != null && (b2 = o41Var7.b()) != null) {
                hashMap.put("ad_invoke_flag", b2);
                intent.putExtra("ad_invoke_flag", b2);
            }
            intent.putExtra("map", hashMap);
            return intent;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k41
    public void n(ViewGroup parent) {
        ViewParent viewParent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            ViewGroup viewGroup = null;
            WebPanelBrowserContainer webPanelBrowserContainer = new WebPanelBrowserContainer(this, new x41(), null);
            this.a = webPanelBrowserContainer;
            webPanelBrowserContainer.x0(false);
            webPanelBrowserContainer.v0(false);
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

    @Override // com.baidu.tieba.k41
    public void s(int i, boolean z) {
        p41 p41Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (p41Var = this.c) != null) {
            p41Var.i(i, z);
        }
    }
}
