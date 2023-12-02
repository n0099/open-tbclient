package com.baidu.tieba;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.support.v4.app.FragmentActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class fu1 extends y52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.y52, com.baidu.tieba.q52
    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a extends v72 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fu1 c;

        public a(fu1 fu1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fu1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fu1Var;
        }

        @Override // com.baidu.tieba.v72, com.baidu.tieba.y72
        public boolean a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                return super.a(str);
            }
            return invokeL.booleanValue;
        }
    }

    public fu1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.y52, com.baidu.tieba.q52
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ss1 ss1Var = this.H0;
            if (ss1Var != null && ss1Var.canGoBack()) {
                this.H0.goBack();
                return true;
            }
            gu1.a().b(1);
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.y52
    public y72 g3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new a(this);
        }
        return (y72) invokeV.objValue;
    }

    @Override // com.baidu.tieba.y52
    public us1 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return ed2.V().g0().g(z());
        }
        return (us1) invokeV.objValue;
    }

    public final int n3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (j2()) {
                return 18;
            }
            return 12;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [com.baidu.tieba.ss1] */
    @Override // com.baidu.tieba.y52, com.baidu.swan.support.v4.app.Fragment
    public View A0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d00e7, viewGroup, false);
            a2(inflate);
            us1 j = j();
            this.G0 = j;
            j.V(g3());
            this.H0 = this.G0.getWebView();
            this.G0.loadUrl(this.I0);
            FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0901e2);
            this.G0.i(frameLayout, this.H0.covertToView());
            d3(frameLayout);
            if (Z1()) {
                return c2(inflate);
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tieba.y52, com.baidu.tieba.q52
    public void a2(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.a2(view2);
            this.f0.setRightZoneVisibility(true);
        }
    }

    @Override // com.baidu.tieba.y52
    public void h3() {
        FragmentActivity n;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (n = n()) != null && this.g0 == null) {
            this.g0 = new rc4(n, this.f0, n3(), rp2.K(), new tl3());
            new aw2(this.g0, this).z();
        }
    }
}
