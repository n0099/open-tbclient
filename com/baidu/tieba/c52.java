package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.view.menu.SwanAppMenuHeaderView;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URI;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c52 extends d52 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean P0;
    public transient /* synthetic */ FieldHolder $fh;
    public int N0;
    public FrameLayout O0;

    /* loaded from: classes5.dex */
    public class a extends a72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c52 c;

        public a(c52 c52Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c52Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c52Var;
        }

        @Override // com.baidu.tieba.a72, com.baidu.tieba.d72
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return super.a(str);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                return de3.a().getBoolean("SP_SwanAppWebModeFragment_DEBUG", false);
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947625673, "Lcom/baidu/tieba/c52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947625673, "Lcom/baidu/tieba/c52;");
                return;
            }
        }
        P0 = am1.a;
    }

    public c52() {
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
        this.N0 = 20;
    }

    @Override // com.baidu.tieba.d52
    public d72 g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new a(this);
        }
        return (d72) invokeV.objValue;
    }

    @Override // com.baidu.tieba.d52
    public zr1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return jc2.V().g0().a(s());
        }
        return (zr1) invokeV.objValue;
    }

    public URI n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            try {
                return new URI(hl3.c().a().e());
            } catch (Exception e) {
                if (P0) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v42
    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.o2();
            kl3.a().j();
        }
    }

    public URI o3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            try {
                return new URI(hl3.c().e());
            } catch (Exception e) {
                if (P0) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    public final int p3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (k2()) {
                return 19;
            }
            return this.N0;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.baidu.tieba.xr1] */
    @Override // com.baidu.tieba.d52, com.baidu.swan.support.v4.app.Fragment
    public View B0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e3, viewGroup, false);
            b2(inflate);
            zr1 j = j();
            this.G0 = j;
            j.V(g3());
            this.H0 = this.G0.getWebView();
            kl3.a().i(this.I0);
            hl3.c().m("0");
            this.G0.loadUrl(this.I0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901bc);
            this.O0 = frameLayout;
            this.G0.i(frameLayout, this.H0.covertToView());
            d3(this.O0);
            if (a2()) {
                inflate = d2(inflate);
                D1(0, true);
            }
            gj3.Q(m());
            hl3.c().p(this.G0.a());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.v42
    public void T2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.G0 == null) {
                if (P0) {
                    Log.e("SwanAppWebModeFragment", Log.getStackTraceString(new Exception("mCurWebViewManager is null.")));
                    return;
                }
                return;
            }
            HashMap hashMap = new HashMap();
            String a2 = this.G0.a();
            hashMap.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, a2);
            xr1 xr1Var = this.H0;
            if (xr1Var != null) {
                hashMap.put("webViewUrl", xr1Var.getUrl());
            }
            qf2 qf2Var = new qf2("sharebtn", hashMap);
            cr2.V().n(a2, qf2Var);
            p22.i("SwanAppWebModeFragment", "share msg: " + qf2Var.s().toString());
        }
    }

    @Override // com.baidu.tieba.d52, com.baidu.tieba.v42
    public void b2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.b2(view2);
            this.f0.setRightMenuStyle();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f0.getLayoutParams();
            layoutParams.topMargin = gj3.t();
            this.f0.setLayoutParams(layoutParams);
        }
    }

    public void q3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.N0 = i;
        }
    }

    @Override // com.baidu.tieba.d52
    public void h3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            FragmentActivity m = m();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(s());
            }
            if (m != null && this.g0 == null) {
                this.g0 = new wb4(m, this.f0, p3(), wo2.K(), new yk3());
                new fv2(this.g0, this, this.h0).z();
            }
        }
    }

    @Override // com.baidu.tieba.v42, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            URI o3 = o3();
            URI n3 = n3();
            if (o3 != null && n3 != null) {
                if (!TextUtils.equals(o3.getPath(), n3.getPath()) && !TextUtils.equals(o3.getQuery(), n3.getQuery())) {
                    this.G0.loadUrl(n3.toString());
                    if (P0) {
                        Log.i("SwanAppWebModeFragment", "onResume: refresh url " + n3.toString());
                    }
                    hl3.c().m("3");
                    kl3.b("3");
                    kl3.a().m();
                    if (P0) {
                        Log.i("SwanAppWebModeFragment", "onResume: reset statistic for warm refresh.");
                        return;
                    }
                    return;
                }
                zb3.s(o53.K().q().X());
                if (P0) {
                    Log.i("SwanAppWebModeFragment", "onResume: warm without refresh.");
                }
            }
        }
    }

    @Override // com.baidu.tieba.d52, com.baidu.tieba.v42
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            h3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(nc2.n(o53.K().getAppId()));
            }
            this.g0.t(wo2.M().a(), N1(), this.h0, false);
        }
    }
}
