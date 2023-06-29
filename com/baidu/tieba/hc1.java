package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.util.NetUtil;
import com.baidu.nadcore.webviewx.container.BaseNativeBrowserContainer;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.bc1;
import com.baidu.tieba.fc1;
import com.baidu.tieba.gc1;
import com.baidu.tieba.z71;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hc1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public BaseNativeBrowserContainer a;
    public WebView b;
    public fc1 c;
    public cc1 d;
    public final ac1 e;
    public mb1 f;
    public boolean g;
    public ViewTreeObserver.OnGlobalLayoutListener h;
    public View.OnLayoutChangeListener i;
    public boolean j;
    public final Object k;
    public long l;
    public int m;
    public ic1 n;
    public final kc1 o;

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public void x(WebView webView, String str, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, webView, str, bitmap) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class d implements gc1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Activity a;
        public final /* synthetic */ hc1 b;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.a.b.b.canGoBack()) {
                        this.a.b.b.goBack();
                    } else {
                        this.a.a.finish();
                    }
                }
            }
        }

        public d(hc1 hc1Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc1Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hc1Var;
            this.a = activity;
        }

        @Override // com.baidu.tieba.gc1.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.b.post(new a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements kc1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc1 a;

        public a(hc1 hc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hc1Var;
        }

        @Override // com.baidu.tieba.kc1
        public void loadUrl(String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, map) == null) && this.a.b != null) {
                this.a.b.loadUrl(str, map);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements z71.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc1 a;

        public b(hc1 hc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hc1Var;
        }

        @Override // com.baidu.tieba.z71.b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a.a.l(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements bc1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WebView a;
        public final /* synthetic */ hc1 b;

        public c(hc1 hc1Var, WebView webView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc1Var, webView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hc1Var;
            this.a = webView;
        }

        @Override // com.baidu.tieba.bc1.a
        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Rect rect = new Rect();
                this.a.getWindowVisibleDisplayFrame(rect);
                int i = this.b.a.getResources().getDisplayMetrics().heightPixels - rect.bottom;
                if (i < 0) {
                    i = 0;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("visibleHeight", this.a.getHeight() - i);
                    jSONObject.put("keyboardHeight", i);
                    jSONObject.put("webviewHeight", this.a.getHeight());
                    jSONObject.put("videoHeight", 0);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return jSONObject.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ hc1 b;

        public e(hc1 hc1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hc1Var;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                Rect rect = new Rect();
                view2.getWindowVisibleDisplayFrame(rect);
                int i9 = rect.bottom;
                int i10 = this.a;
                if (i9 != i10 && i10 != 0) {
                    LinearLayout P = this.b.a.P();
                    int i11 = this.a - rect.bottom;
                    if (i11 <= 200) {
                        if (i3 == i7 && this.b.j) {
                            P.setPadding(P.getPaddingLeft(), P.getPaddingTop(), P.getPaddingRight(), 0);
                            rb1.b(this.b.o, P.getHeight(), 0, P.getHeight(), 0);
                            hc1 hc1Var = this.b;
                            hc1Var.E(hc1Var.b, -1, -1);
                        }
                        this.b.j = false;
                    } else {
                        this.b.j = true;
                        if (i3 == i7) {
                            P.setPadding(P.getPaddingLeft(), P.getPaddingTop(), P.getPaddingRight(), i11);
                            rb1.b(this.b.o, P.getHeight() - i11, i11, P.getHeight(), 0);
                            hc1 hc1Var2 = this.b;
                            hc1Var2.E(hc1Var2.b, -1, -1);
                        }
                    }
                    this.a = rect.bottom;
                    return;
                }
                this.a = rect.bottom;
            }
        }
    }

    public hc1(@NonNull BaseNativeBrowserContainer baseNativeBrowserContainer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseNativeBrowserContainer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new ac1();
        this.g = true;
        this.h = null;
        this.k = new Object();
        this.l = 0L;
        this.n = null;
        this.o = new a(this);
        this.a = baseNativeBrowserContainer;
    }

    public void A(String str) {
        fc1 fc1Var;
        fc1.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && (fc1Var = this.c) != null && (cVar = fc1Var.b) != null && !TextUtils.isEmpty(cVar.a)) {
            this.a.l(this.c.b.a);
        }
    }

    public void m(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, intent) == null) {
            this.c = fc1.b(intent);
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            if (this.l == 0) {
                this.l = System.currentTimeMillis();
            }
            ic1 ic1Var = this.n;
            if (ic1Var != null) {
                ic1Var.e(this.b);
            }
        }
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            cc1 cc1Var = this.d;
            if (cc1Var != null) {
                cc1Var.e();
            }
            ic1 ic1Var = this.n;
            if (ic1Var != null) {
                ic1Var.h();
            }
        }
    }

    public void C() {
        cc1 cc1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (cc1Var = this.d) != null) {
            cc1Var.f();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.a.P() != null && this.i != null) {
            this.a.P().removeOnLayoutChangeListener(this.i);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.d = null;
            mb1 mb1Var = this.f;
            if (mb1Var != null) {
                mb1Var.d();
                this.f = null;
            }
        }
    }

    @Nullable
    public final Intent i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.a.f();
        }
        return (Intent) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            fc1 fc1Var = this.c;
            if (fc1Var == null) {
                return null;
            }
            return fc1Var.g;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            fc1 fc1Var = this.c;
            if (fc1Var == null) {
                return null;
            }
            return fc1Var.a;
        }
        return (String) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.f == null) {
                this.f = new mb1();
            }
            fc1 fc1Var = this.c;
            if (fc1Var != null) {
                this.f.b(fc1Var.j);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.i = new e(this);
            if (this.a.P() != null) {
                this.a.P().addOnLayoutChangeListener(this.i);
            }
        }
    }

    public final void s() {
        Intent i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048596, this) != null) || (i = i()) == null) {
            return;
        }
        m(i);
        n();
        this.d = new cc1();
        f81.a().a(this.k, new b(this));
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            s();
            ic1 ic1Var = new ic1(this.c);
            this.n = ic1Var;
            ic1Var.c();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            cc1 cc1Var = this.d;
            if (cc1Var != null) {
                cc1Var.d();
            }
            ic1 ic1Var = this.n;
            if (ic1Var != null) {
                ic1Var.f();
            }
        }
    }

    public void E(@NonNull View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048580, this, view2, i, i2) == null) {
            if (view2.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                view2.setLayoutParams(new FrameLayout.LayoutParams(i, i2));
            } else if (view2.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                view2.setLayoutParams(new LinearLayout.LayoutParams(i, i2));
            } else if (view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                view2.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
            } else if (view2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                view2.setLayoutParams(new ViewGroup.MarginLayoutParams(i, i2));
            } else if (view2.getLayoutParams() instanceof ViewGroup.LayoutParams) {
                view2.setLayoutParams(new ViewGroup.LayoutParams(i, i2));
            }
        }
    }

    public boolean F(@NonNull WebView webView, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, webView, str, str2)) == null) {
            G(webView, str2);
            fc1 fc1Var = this.c;
            if (fc1Var == null || !fc1Var.a()) {
                return true;
            }
            return !jk0.a(webView.getContext(), str2);
        }
        return invokeLLL.booleanValue;
    }

    public final void G(@NonNull WebView webView, String str) {
        fc1 fc1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, webView, str) == null) && !TextUtils.isEmpty(str) && str.startsWith("tel:") && webView.getContext() != null && (fc1Var = this.c) != null && !TextUtils.isEmpty(fc1Var.f)) {
            new ve1().p(webView.getContext(), this.c.f, "tel");
        }
    }

    public void p(@NonNull Activity activity, @NonNull WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, activity, webView) == null) {
            bc1 bc1Var = new bc1(0);
            bc1Var.a(this.e);
            bc1Var.b(new c(this, webView));
            this.a.H(bc1Var, "NadJsControl");
            this.a.H(new gc1(new d(this, activity)), "go_back_js_interface_name");
        }
    }

    public final void f() {
        ViewTreeObserver viewTreeObserver;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.a.P() != null && this.h != null && (viewTreeObserver = this.a.P().getViewTreeObserver()) != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(this.h);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.d.g();
            if (i() != null) {
                String j = j();
                if (!TextUtils.isEmpty(j)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("Referer", j);
                    this.a.h0(hashMap);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || this.a.P() == null) {
            return;
        }
        if (this.h == null) {
            this.h = new pc1(this.a.P());
        }
        ViewTreeObserver viewTreeObserver = this.a.P().getViewTreeObserver();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(this.h);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || this.a.N() == null) {
            return;
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.a.P().getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setVisibility(8);
        this.a.N().addView(relativeLayout, layoutParams);
        this.a.m0(relativeLayout);
        String str = null;
        if (this.c != null) {
            JSONObject jSONObject = new JSONObject();
            c31.f(jSONObject, LegoListActivityConfig.AD_ID, this.c.c);
            c31.f(jSONObject, "lp_url", this.c.a);
            c31.f(jSONObject, "log_ext", this.c.f);
            c31.f(jSONObject, "business", "native_ads");
            fc1.b bVar = this.c.k;
            if (bVar != null) {
                c31.f(jSONObject, "key", bVar.e);
                c31.f(jSONObject, "url", this.c.k.a);
                c31.f(jSONObject, "close_v_dl", this.c.k.b);
                c31.f(jSONObject, "app_icon", this.c.k.d);
                c31.f(jSONObject, "app_name", this.c.k.c);
            }
            str = jSONObject.toString();
        }
        if (!TextUtils.isEmpty(str)) {
            this.a.p0(str);
        }
    }

    public void t(Context context, ViewGroup viewGroup, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048597, this, context, viewGroup, webView) == null) {
            this.b = webView;
            o();
            if (tb1.g()) {
                f();
                g();
            } else if (this.g) {
                f();
                r();
            } else {
                q();
                g();
            }
        }
    }

    public void v() {
        cc1 cc1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            fc1 fc1Var = this.c;
            if (fc1Var != null && TextUtils.equals(fc1Var.i, "1") && (cc1Var = this.d) != null) {
                this.d.b(this.e.a(), cc1Var.a(this.c.f, this.l, this.m, false), this.c.a, this.a.L(), 0L);
            }
            cc1 cc1Var2 = this.d;
            if (cc1Var2 != null) {
                cc1Var2.c();
            }
            f81.a().release();
            h();
            f();
            g();
            if (this.i != null) {
                this.a.P().removeOnLayoutChangeListener(this.i);
            }
            tn0.a().unregister(this.k);
            ic1 ic1Var = this.n;
            if (ic1Var != null) {
                ic1Var.d();
            }
        }
    }

    public void z(WebView webView, int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048603, this, webView, i, str, str2) == null) {
            if (!NetUtil.a(this.a.P().getContext())) {
                this.m = -1000;
            } else {
                this.m = i;
            }
            ic1 ic1Var = this.n;
            if (ic1Var != null) {
                ic1Var.g(this.m);
            }
        }
    }
}
