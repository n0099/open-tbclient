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
/* loaded from: classes6.dex */
public class ib2 extends jb2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean P0;
    public transient /* synthetic */ FieldHolder $fh;
    public int N0;
    public FrameLayout O0;

    /* loaded from: classes6.dex */
    public class a extends gd2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ib2 c;

        public a(ib2 ib2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ib2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ib2Var;
        }

        @Override // com.baidu.tieba.gd2, com.baidu.tieba.jd2
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return super.a(str);
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
                return jk3.a().getBoolean("SP_SwanAppWebModeFragment_DEBUG", false);
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947847664, "Lcom/baidu/tieba/ib2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947847664, "Lcom/baidu/tieba/ib2;");
                return;
            }
        }
        P0 = fs1.a;
    }

    public ib2() {
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

    @Override // com.baidu.tieba.jb2
    public jd2 b3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new a(this);
        }
        return (jd2) invokeV.objValue;
    }

    public URI i3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                return new URI(nr3.c().a().e());
            } catch (Exception e) {
                if (P0) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jb2
    public ey1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return pi2.U().f0().a(getContext());
        }
        return (ey1) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bb2
    public void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.j2();
            qr3.a().j();
        }
    }

    public URI j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                return new URI(nr3.c().e());
            } catch (Exception e) {
                if (P0) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (URI) invokeV.objValue;
    }

    public final int k3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (f2()) {
                return 19;
            }
            return this.N0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.bb2
    public void O2() {
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
            cy1 cy1Var = this.H0;
            if (cy1Var != null) {
                hashMap.put("webViewUrl", cy1Var.getUrl());
            }
            wl2 wl2Var = new wl2("sharebtn", hashMap);
            ix2.T().m(a2, wl2Var);
            v82.i("SwanAppWebModeFragment", "share msg: " + wl2Var.s().toString());
        }
    }

    @Override // com.baidu.tieba.jb2, com.baidu.tieba.bb2
    public void W1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            super.W1(view2);
            this.f0.setRightMenuStyle();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f0.getLayoutParams();
            layoutParams.topMargin = mp3.t();
            this.f0.setLayoutParams(layoutParams);
        }
    }

    public void l3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.N0 = i;
        }
    }

    @Override // com.baidu.tieba.jb2
    public void c3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FragmentActivity activity = getActivity();
            if (this.h0 == null) {
                this.h0 = new SwanAppMenuHeaderView(getContext());
            }
            if (activity != null && this.g0 == null) {
                this.g0 = new ci4(activity, this.f0, k3(), cv2.K(), new er3());
                new l13(this.g0, this, this.h0).z();
            }
        }
    }

    @Override // com.baidu.tieba.jb2, com.baidu.tieba.bb2
    public void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            c3();
            SwanAppMenuHeaderView swanAppMenuHeaderView = this.h0;
            if (swanAppMenuHeaderView != null) {
                swanAppMenuHeaderView.setAttentionBtnStates(ti2.n(ub3.K().getAppId()));
            }
            this.g0.u(cv2.M().a(), J1(), this.h0, false);
        }
    }

    @Override // com.baidu.tieba.bb2, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            URI j3 = j3();
            URI i3 = i3();
            if (j3 != null && i3 != null) {
                if (!TextUtils.equals(j3.getPath(), i3.getPath()) && !TextUtils.equals(j3.getQuery(), i3.getQuery())) {
                    this.G0.loadUrl(i3.toString());
                    if (P0) {
                        Log.i("SwanAppWebModeFragment", "onResume: refresh url " + i3.toString());
                    }
                    nr3.c().m("3");
                    qr3.b("3");
                    qr3.a().m();
                    if (P0) {
                        Log.i("SwanAppWebModeFragment", "onResume: reset statistic for warm refresh.");
                        return;
                    }
                    return;
                }
                fi3.s(ub3.K().q().W());
                if (P0) {
                    Log.i("SwanAppWebModeFragment", "onResume: warm without refresh.");
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.baidu.tieba.cy1] */
    @Override // com.baidu.tieba.jb2, com.baidu.swan.support.v4.app.Fragment
    public View y0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e1, viewGroup, false);
            W1(inflate);
            ey1 j = j();
            this.G0 = j;
            j.W(b3());
            this.H0 = this.G0.r();
            qr3.a().i(this.I0);
            nr3.c().m("0");
            this.G0.loadUrl(this.I0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901bc);
            this.O0 = frameLayout;
            this.G0.i(frameLayout, this.H0.covertToView());
            Y2(this.O0);
            if (V1()) {
                inflate = Y1(inflate);
                y1(0, true);
            }
            mp3.Q(getActivity());
            nr3.c().p(this.G0.a());
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }
}
