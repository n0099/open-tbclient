package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.adlanding.SwanAppAdLandingFragment;
import com.baidu.swan.apps.core.slave.SwanAppWebViewWidget;
import com.baidu.swan.apps.view.SwanAppActionBar;
import com.baidu.tieba.y42;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d52 extends v42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean M0;
    public transient /* synthetic */ FieldHolder $fh;
    public zr1 G0;
    public xr1 H0;
    public String I0;
    public String J0;
    public String K0;
    public boolean L0;

    public void d3(FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, frameLayout) == null) {
        }
    }

    public void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    @Override // com.baidu.tieba.v42
    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a extends SwanAppWebViewWidget {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d52 b0;

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
        public boolean S1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d52 d52Var, Context context) {
            super(context);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d52Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Context) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b0 = d52Var;
        }

        @Override // com.baidu.swan.apps.core.slave.SwanAppWebViewWidget
        public boolean R1() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b0.L0;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b extends a72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d52 c;

        public b(d52 d52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = d52Var;
        }

        @Override // com.baidu.tieba.a72, com.baidu.tieba.d72
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.c.e3(str) && this.c.K0 != null) {
                    d52 d52Var = this.c;
                    d52Var.f0.setTitle(d52Var.K0);
                    return;
                }
                this.c.f0.setTitle(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d52 a;

        public c(d52 d52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d52Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.H0.canGoBack()) {
                    this.a.H0.goBack();
                } else {
                    this.a.o2();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public pv2 a;
        public JSONObject b;

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new JSONObject();
            this.a = pv2.d(str, str);
        }

        public void c(kj4 kj4Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kj4Var) != null) || kj4Var == null) {
                return;
            }
            this.a.b = this.b.toString();
            d52 j3 = d52.j3(this.a, "default_webview");
            mj4 a = kj4Var.a();
            a.a(R.id.obfuscated_res_0x7f090187, j3);
            a.d(null);
            a.e();
        }

        public d a(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                try {
                    this.b.put("should_check_domain", z);
                } catch (JSONException e) {
                    if (d52.M0) {
                        e.printStackTrace();
                    }
                }
                return this;
            }
            return (d) invokeZ.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.b = this.b.toString();
                d52.k3("default_webview", this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947655464, "Lcom/baidu/tieba/d52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947655464, "Lcom/baidu/tieba/d52;");
                return;
            }
        }
        M0 = am1.a;
    }

    public d52() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.L0 = true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            zr1 zr1Var = this.G0;
            if (zr1Var != null) {
                zr1Var.destroy();
                this.G0 = null;
            }
            super.C0();
        }
    }

    @Override // com.baidu.tieba.v42
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            xr1 xr1Var = this.H0;
            if (xr1Var != null && xr1Var.canGoBack()) {
                this.H0.goBack();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public d72 g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return new b(this);
        }
        return (d72) invokeV.objValue;
    }

    public zr1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return new a(this, s());
        }
        return (zr1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v42
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.G0.Q();
            h3();
            this.g0.s(wo2.M().a(), N1());
        }
    }

    public static d i3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            return new d(str);
        }
        return (d) invokeL.objValue;
    }

    @Override // com.baidu.tieba.v42, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            zr1 zr1Var = this.G0;
            if (zr1Var != null) {
                return zr1Var.isSlidable(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void m3(pv2 pv2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, pv2Var) == null) && pv2Var != null) {
            Bundle bundle = new Bundle();
            bundle.putString("url", pv2Var.c);
            bundle.putString("params", pv2Var.b);
            n1(bundle);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void y0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bundle) == null) {
            super.y0(bundle);
            l3();
            if (M0) {
                Log.d("SwanAppWebViewFragment", "onCreate() : " + this);
            }
        }
    }

    public static boolean f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            y42 W = cr2.V().W();
            if (W == null) {
                p22.i("SwanAppWebViewFragment", "close page failed");
                return false;
            }
            p22.i("SwanAppWebViewFragment", "page closed! ");
            y42.b h = W.h();
            h.n(y42.i, y42.h);
            h.g();
            h.a();
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static d52 j3(pv2 pv2Var, String str) {
        InterceptResult invokeLL;
        char c2;
        d52 jy2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, pv2Var, str)) == null) {
            switch (str.hashCode()) {
                case -1750679182:
                    if (str.equals("allianceLogin")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -718660690:
                    if (str.equals("web_mode")) {
                        c2 = 6;
                        break;
                    }
                    c2 = 65535;
                    break;
                case -130826522:
                    if (str.equals("allianceChooseAddress")) {
                        c2 = 4;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 113553927:
                    if (str.equals("wxPay")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 570452084:
                    if (str.equals("adLanding")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1221126139:
                    if (str.equals("default_webview")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1339472410:
                    if (str.equals("qrCodePay")) {
                        c2 = 5;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            switch (c2) {
                case 0:
                    jy2Var = new jy2();
                    break;
                case 1:
                    jy2Var = new SwanAppAdLandingFragment();
                    break;
                case 2:
                    jy2Var = new d52();
                    break;
                case 3:
                    jy2Var = new ct1();
                    break;
                case 4:
                    jy2Var = new kt1();
                    break;
                case 5:
                    jy2Var = new fy2();
                    break;
                case 6:
                    jy2Var = new c52();
                    break;
                default:
                    if (M0) {
                        Log.e("SwanAppWebViewFragment", "error type of SwanAppWebViewFragment!");
                    }
                    jy2Var = null;
                    break;
            }
            if (jy2Var != null) {
                jy2Var.m3(pv2Var);
            }
            return jy2Var;
        }
        return (d52) invokeLL.objValue;
    }

    public static boolean k3(String str, pv2 pv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, str, pv2Var)) == null) {
            y42 W = cr2.V().W();
            if (W == null) {
                p22.i("SwanAppWebViewFragment", "open page failed");
                return false;
            }
            p22.i("SwanAppWebViewFragment", "open page url=" + pv2Var.c);
            y42.b h = W.h();
            h.n(y42.g, y42.i);
            h.k(str, pv2Var).b();
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.baidu.tieba.xr1] */
    @Override // com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e4, viewGroup, false);
            b2(inflate);
            zr1 j = j();
            this.G0 = j;
            j.V(g3());
            this.H0 = this.G0.getWebView();
            this.G0.loadUrl(this.I0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901bc);
            this.G0.i(frameLayout, this.H0.covertToView());
            d3(frameLayout);
            if (a2()) {
                inflate = d2(inflate);
            }
            return J1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.v42
    public void b2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            super.b2(view2);
            A2(-1);
            J2(-16777216);
            SwanAppActionBar swanAppActionBar = this.f0;
            String str = this.K0;
            if (str == null) {
                str = "";
            }
            swanAppActionBar.setTitle(str);
            this.f0.setRightZoneVisibility(false);
            E2(true);
            this.f0.setLeftBackViewClickListener(new c(this));
        }
    }

    public final boolean e3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (!TextUtils.equals(this.I0, str) && !TextUtils.equals(this.I0.replace("http://", "").replace("https://", ""), str)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void l3() {
        Bundle p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (p = p()) != null) {
            this.I0 = p.getString("url");
            String string = p.getString("params");
            this.J0 = string;
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.J0);
                this.K0 = jSONObject.optString("fallback_title", null);
                this.L0 = jSONObject.optBoolean("should_check_domain", true);
            } catch (JSONException e) {
                if (M0) {
                    e.printStackTrace();
                }
            }
        }
    }
}
