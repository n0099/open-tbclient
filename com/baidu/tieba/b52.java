package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.tieba.y42;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b52 extends v42 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RelativeLayout G0;
    public RelativeLayout H0;

    @Override // com.baidu.tieba.v42
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.v42
    public void q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public b52() {
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

    public static b52 c3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return new b52();
        }
        return (b52) invokeV.objValue;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    @Nullable
    public View B0(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0925, viewGroup, false);
            b2(inflate);
            b3(inflate);
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
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            c2(view2);
            A2(-1);
            J2(-16777216);
            C2(S(R.string.obfuscated_res_0x7f0f14ec));
            E2(true);
            Q2(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f091775) {
                wo2.t0().a();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f090308) {
                d3();
            }
        }
    }

    public final void b3(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091775);
            this.G0 = relativeLayout;
            relativeLayout.setOnClickListener(this);
            if (wo2.y0().d() || !jj3.G()) {
                this.G0.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090308);
            this.H0 = relativeLayout2;
            relativeLayout2.setOnClickListener(this);
        }
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (v42.F0) {
                Log.d("SwanAppBaseFragment", "startSettingFragment");
            }
            y42 S1 = S1();
            if (S1 == null) {
                h53.f(s(), R.string.obfuscated_res_0x7f0f01d5).G();
                return;
            }
            y42.b i = S1.i("navigateTo");
            i.n(y42.g, y42.i);
            i.k("authority", null).a();
            fv2.o(ShareLoginStat.GetShareListStat.KEY_PERMISSION);
        }
    }
}
