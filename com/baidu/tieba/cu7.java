package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
import com.baidu.tieba.payment.PayVcodeActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes3.dex */
public class cu7 extends p9<PayVcodeActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PayVcodeActivity a;
    public ViewGroup b;
    public View c;
    public ViewGroup d;
    public TextView e;
    public BaseWebView f;
    public TextView g;
    public ProgressBar h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu7(PayVcodeActivity payVcodeActivity) {
        super(payVcodeActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payVcodeActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((r9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = payVcodeActivity;
        payVcodeActivity.setContentView(R.layout.obfuscated_res_0x7f0d06b5);
        o(payVcodeActivity);
    }

    public View j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public TextView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.g : (TextView) invokeV.objValue;
    }

    public TextView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (TextView) invokeV.objValue;
    }

    public ViewGroup m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.d : (ViewGroup) invokeV.objValue;
    }

    public BaseWebView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (BaseWebView) invokeV.objValue;
    }

    public final void o(PayVcodeActivity payVcodeActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, payVcodeActivity) == null) {
            this.b = (ViewGroup) this.a.findViewById(R.id.obfuscated_res_0x7f0917cf);
            TextView textView = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0917c9);
            this.e = textView;
            SkinManager.setBackgroundResource(textView, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0101, 1);
            this.f = (BaseWebView) payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f0924ec);
            this.g = (TextView) payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f092661);
            this.c = payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f0917cd);
            this.d = (ViewGroup) payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f0917ce);
            this.h = (ProgressBar) payVcodeActivity.findViewById(R.id.obfuscated_res_0x7f0917d0);
            this.f.setHorizontalScrollBarEnabled(false);
            this.f.setHorizontalScrollbarOverlay(false);
            this.f.setScrollBarStyle(33554432);
            this.f.getSettings().setJavaScriptEnabled(true);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            ge5.a(this.a.getPageContext(), this.b);
            SkinManager.setBgColor(this.g, i);
            SkinManager.setBackgroundResource(this.e, R.drawable.s_navbar_button_bg);
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0101, 1);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.g.setVisibility(z ? 0 : 8);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.h.setVisibility(z ? 0 : 8);
        }
    }
}
