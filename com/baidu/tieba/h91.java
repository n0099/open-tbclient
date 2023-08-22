package com.baidu.tieba;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.webpanel.PanelScrollView;
import com.baidu.nadcore.webpanel.model.AdData;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class h91 extends i91 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Object e;
    public e91 f;
    public z81 g;
    public g91 h;
    public boolean i;
    public final j91 j;

    /* loaded from: classes6.dex */
    public static final class a extends in0<h81> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h91 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(h91 h91Var, Class cls) {
            super(cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h91Var, cls};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Class) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h91Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.in0
        public void onEvent(h81 event) {
            AbsNadBrowserView m;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
                Intrinsics.checkNotNullParameter(event, "event");
                if (!TextUtils.isEmpty(event.a()) && (m = this.b.j.m()) != null) {
                    AbsNadBrowserView.C(m, event.a(), null, 2, null);
                }
            }
        }
    }

    public h91(j91 container) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {container};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(container, "container");
        this.j = container;
        this.a = "bdmedialive://bdmedialive/common/closeWebview";
        this.b = "bdmedialive://bdmedialive/common/panelSwitchHalfScreen";
        this.c = "bdmedialive://bdmedialive/common/panelSwitchFullScreen";
        this.d = "nadcorevendor://vendor/ad/webPanelControl";
        this.e = new Object();
    }

    public final void l(int i) {
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (g = this.j.g()) != null) {
            ViewGroup.LayoutParams layoutParams = g.getLayoutParams();
            layoutParams.height = i;
            g.setLayoutParams(layoutParams);
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.i = z;
        }
    }

    public final void o(z81 helper) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, helper) == null) {
            Intrinsics.checkNotNullParameter(helper, "helper");
            this.g = helper;
        }
    }

    public final void p(e91 e91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, e91Var) == null) {
            this.f = e91Var;
        }
    }

    public final void q(g91 g91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, g91Var) == null) {
            this.h = g91Var;
        }
    }

    @Override // com.baidu.tieba.i91
    public boolean c(k91 container, String url) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, container, url)) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(url, "url");
            if (TextUtils.isEmpty(url)) {
                return false;
            }
            if (TextUtils.equals(this.a, url)) {
                g();
                return true;
            } else if (TextUtils.equals(this.b, url)) {
                s();
                return true;
            } else if (TextUtils.equals(this.c, url)) {
                r();
                return true;
            } else if (!StringsKt__StringsJVMKt.startsWith$default(url, this.d, false, 2, null)) {
                return false;
            } else {
                return f(new gj0(url));
            }
        }
        return invokeLL.booleanValue;
    }

    public final void i(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            AbsNadBrowserView m = this.j.m();
            if (z) {
                if (i == 1) {
                    if (m != null) {
                        AbsNadBrowserView.C(m, "javascript:window.onDxdInvoke({'key':'1','value':'start'})", null, 2, null);
                    }
                } else if (i == 2 && m != null) {
                    AbsNadBrowserView.C(m, "javascript:window.onDxdInvoke({'key':'2','value':'start'})", null, 2, null);
                }
            } else if (i == 1) {
                if (m != null) {
                    AbsNadBrowserView.C(m, "javascript:window.onDxdInvoke({'key':'1','value':'end'})", null, 2, null);
                }
            } else if (i == 2) {
                u81.b.b(true);
                if (m != null) {
                    AbsNadBrowserView.C(m, "javascript:window.onDxdInvoke({'key':'2','value':'end'})", null, 2, null);
                }
            }
        }
    }

    @Override // com.baidu.tieba.i91
    public void d(k91 container, String url) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, container, url) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(url, "url");
            AbsNadBrowserView m = container.m();
            if (m != null) {
                AbsNadBrowserView.C(m, "javascript:window.onDxdInvoke({'key':'0'})", null, 2, null);
            }
        }
    }

    public final boolean f(gj0 gj0Var) {
        InterceptResult invokeL;
        boolean z;
        z81 z81Var;
        z81 z81Var2;
        z81 z81Var3;
        z81 z81Var4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gj0Var)) == null) {
            HashMap<String, String> d = gj0Var.d();
            Intrinsics.checkNotNullExpressionValue(d, "model.params");
            String str = (String) f31.b(d, "params");
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            JSONObject c = e31.c(str);
            Intrinsics.checkNotNullExpressionValue(c, "JSONUtils.newJSONObject(paramsJson)");
            String optString = c.optString("type");
            if (c.optInt(PackageTable.DISABLE, 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (optString != null) {
                switch (optString.hashCode()) {
                    case -2119262164:
                        if (optString.equals("slideUp") && (z81Var = this.g) != null) {
                            z81Var.j(z);
                            break;
                        }
                        break;
                    case -796944909:
                        if (optString.equals("slideDown") && (z81Var2 = this.g) != null) {
                            z81Var2.i(z);
                            break;
                        }
                        break;
                    case -102095252:
                        if (optString.equals("slideControl") && (z81Var3 = this.g) != null) {
                            z81Var3.h(z);
                            break;
                        }
                        break;
                    case 1538155302:
                        if (optString.equals("topAreaClick") && (z81Var4 = this.g) != null) {
                            z81Var4.k(z);
                            break;
                        }
                        break;
                }
            }
            String str2 = (String) f31.b(d, WebChromeClient.KEY_ARG_CALLBACK);
            if (!TextUtils.isEmpty(str2)) {
                Map<String, String> v = pj0.v(optString, c.optInt(PackageTable.DISABLE, 0));
                f31.e(v, WebChromeClient.KEY_ARG_CALLBACK, str2);
                AbsNadBrowserView m = this.j.m();
                if (m != null) {
                    AbsNadBrowserView.C(m, pj0.p(v), null, 2, null);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void g() {
        e91 e91Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (e91Var = this.f) != null) {
            e91Var.a(1);
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return invokeV.booleanValue;
    }

    public final void j() {
        AbsNadBrowserView m;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (m = this.j.m()) != null) {
            AbsNadBrowserView.C(m, "javascript:window.onDxdInvoke({'key':'3'})", null, 2, null);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            en0.a().c(this.e, 1, new a(this, h81.class));
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            en0.a().unregister(this.e);
        }
    }

    public final void m(int i) {
        LinearLayout g;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (g = this.j.g()) != null && (g.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            ViewGroup.LayoutParams layoutParams = g.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = i;
                g.setLayoutParams(layoutParams2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }

    public final void r() {
        AdData adData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            z81 z81Var = this.g;
            if (z81Var != null) {
                l(z81Var.f() + PanelScrollView.B);
                m(0);
                gn0 a2 = en0.a();
                g91 g91Var = this.h;
                if (g91Var != null) {
                    adData = g91Var.a();
                } else {
                    adData = null;
                }
                a2.a(new b91(3, adData));
                this.i = true;
            }
            g91 g91Var2 = this.h;
            if (g91Var2 != null) {
                n91.a(ClogBuilder.LogType.DAZZLE_TRANS_SLIDING_COUNT, "", MapBundleKey.OfflineMapKey.OFFLINE_UPDATE, g91Var2.d());
            }
            u81.b.b(true);
        }
    }

    public final void s() {
        AdData adData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            z81 z81Var = this.g;
            if (z81Var != null) {
                l((z81Var.f() - z81Var.e()) + PanelScrollView.B);
                m(z81Var.e());
                gn0 a2 = en0.a();
                g91 g91Var = this.h;
                if (g91Var != null) {
                    adData = g91Var.a();
                } else {
                    adData = null;
                }
                a2.a(new b91(4, adData));
                this.i = true;
            }
            g91 g91Var2 = this.h;
            if (g91Var2 != null) {
                n91.a(ClogBuilder.LogType.DAZZLE_TRANS_SLIDING_COUNT, "", "down", g91Var2.d());
            }
            u81.b.b(false);
        }
    }
}
