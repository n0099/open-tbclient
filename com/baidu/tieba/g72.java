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
/* loaded from: classes4.dex */
public class g72 extends h72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean P0;
    public transient /* synthetic */ FieldHolder $fh;
    public int N0;
    public FrameLayout O0;

    /* loaded from: classes4.dex */
    public class a extends e92 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g72 c;

        public a(g72 g72Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g72Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g72Var;
        }

        @Override // com.baidu.tieba.e92, com.baidu.tieba.h92
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return super.a(str);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                return hg3.a().getBoolean("SP_SwanAppWebModeFragment_DEBUG", false);
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947746759, "Lcom/baidu/tieba/g72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947746759, "Lcom/baidu/tieba/g72;");
                return;
            }
        }
        P0 = do1.a;
    }

    public g72() {
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

    @Override // com.baidu.tieba.h72
    public h92 c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new a(this);
        }
        return (h92) invokeV.objValue;
    }

    public URI j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return new URI(ln3.c().a().e());
            } catch (Exception e) {
                if (P0) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    @Override // com.baidu.tieba.h72
    public cu1 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ne2.U().f0().a(getContext());
        }
        return (cu1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.z62
    public void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.k2();
            on3.a().j();
        }
    }

    public URI k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                return new URI(ln3.c().e());
            } catch (Exception e) {
                if (P0) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    public final int l3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (g2()) {
                return 19;
            }
            return this.N0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.z62
    public void P2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
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
            au1 au1Var = this.H0;
            if (au1Var != null) {
                hashMap.put("webViewUrl", au1Var.getUrl());
            }
            uh2 uh2Var = new uh2("sharebtn", hashMap);
            gt2.U().m(a2, uh2Var);
            t42.i("SwanAppWebModeFragment", "share msg: " + uh2Var.s().toString());
        }
    }

    @Override // com.baidu.tieba.h72, com.baidu.tieba.z62
    public void X1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.X1(view2);
            this.f0.setRightMenuStyle();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f0.getLayoutParams();
            layoutParams.topMargin = kl3.t();
            this.f0.setLayoutParams(layoutParams);
        }
    }

    public void m3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.N0 = i;
        }
    }

    @Override // com.baidu.tieba.h72
    public void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity != null && this.g0 == null) {
                this.g0 = new ae4(activity, this.f0, l3(), ar2.K(), new cn3());
                new jx2(this.g0, this, this.h0).z();
            }
        }
    }

    @Override // com.baidu.tieba.h72, com.baidu.tieba.z62
    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            d3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(re2.n(s73.K().getAppId()));
            }
            this.g0.u(ar2.M().a(), K1(), this.h0, false);
        }
    }

    @Override // com.baidu.tieba.z62, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            URI k3 = k3();
            URI j3 = j3();
            if (k3 != null && j3 != null) {
                if (!TextUtils.equals(k3.getPath(), j3.getPath()) && !TextUtils.equals(k3.getQuery(), j3.getQuery())) {
                    this.G0.loadUrl(j3.toString());
                    if (P0) {
                        Log.i("SwanAppWebModeFragment", "onResume: refresh url " + j3.toString());
                    }
                    ln3.c().m("3");
                    on3.b("3");
                    on3.a().m();
                    if (P0) {
                        Log.i("SwanAppWebModeFragment", "onResume: reset statistic for warm refresh.");
                        return;
                    }
                    return;
                }
                de3.s(s73.K().q().W());
                if (P0) {
                    Log.i("SwanAppWebModeFragment", "onResume: warm without refresh.");
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.baidu.tieba.au1] */
    @Override // com.baidu.tieba.h72, com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e0, viewGroup, false);
            X1(inflate);
            cu1 k = k();
            this.G0 = k;
            k.Y(c3());
            this.H0 = this.G0.r();
            on3.a().i(this.I0);
            ln3.c().m("0");
            this.G0.loadUrl(this.I0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901b1);
            this.O0 = frameLayout;
            this.G0.j(frameLayout, this.H0.covertToView());
            Z2(this.O0);
            if (W1()) {
                inflate = Z1(inflate);
                A1(0, true);
            }
            kl3.Q(getActivity());
            ln3.c().p(this.G0.a());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
