package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.Locale;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e72 extends a72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String G0;
    public JSONObject H0;
    public boolean I0;

    @Override // com.baidu.tieba.a72
    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a72
    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.a72, com.baidu.searchbox.widget.SlideInterceptor
    public boolean isSlidable(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, motionEvent)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.a72
    public void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ e72 b;

        public a(e72 e72Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e72Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e72Var;
            this.a = jSONObject;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ht2.U().u(new g33(this.b.G0, this.a.toString(), this.b.H0.optString("slaveId")).a());
                this.b.I0 = false;
            }
        }
    }

    public e72() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.I0 = true;
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.A0();
            t73.K().q().e0().v();
        }
    }

    @Override // com.baidu.tieba.a72, com.baidu.swan.support.v4.app.Fragment
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c0 = null;
            super.D0();
        }
    }

    @Override // com.baidu.tieba.a72, com.baidu.swan.support.v4.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onResume();
            K2(1);
        }
    }

    @Override // com.baidu.tieba.a72
    public void X1(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            Y1(view2);
            w2(-1);
            F2(-16777216);
            y2(N(R.string.obfuscated_res_0x7f0f1348));
            A2(true);
            M2(false);
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public void w0(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            super.w0(bundle);
            Bundle p = p();
            if (p == null) {
                return;
            }
            this.G0 = p.getString("plugin_fun_page_path");
            this.H0 = uk3.d(p.getString("plugin_pay_params"));
        }
    }

    public static e72 b3(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            e72 e72Var = new e72();
            if (!TextUtils.isEmpty(str2)) {
                Bundle bundle = new Bundle();
                bundle.putString("plugin_fun_page_path", str);
                bundle.putString("plugin_pay_params", str2);
                e72Var.l1(bundle);
            }
            return e72Var;
        }
        return (e72) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.a72
    public boolean I() {
        InterceptResult invokeV;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.I0 && (jSONObject = this.H0) != null) {
                f33 f33Var = new f33(jSONObject.optString("componentId"));
                f33Var.a = this.H0.optString("slaveId");
                f33Var.b();
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void a3(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2 != null && this.H0 != null) {
            TextView textView = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f9e);
            u73 b0 = u73.b0();
            if (b0 != null) {
                textView.setText(b0.Y().K());
            }
            JSONObject optJSONObject = this.H0.optJSONObject(WebChromeClient.KEY_ARG_ARRAY);
            if (optJSONObject == null) {
                return;
            }
            ((TextView) view2.findViewById(R.id.obfuscated_res_0x7f090f9f)).setText(String.format(Locale.CHINA, "%.2f", Double.valueOf((optJSONObject.optLong("fee") * 1.0d) / 100.0d)));
            TextView textView2 = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090fa1);
            vg4 g = s33.g(this.H0.optString("pluginProvider"));
            if (g != null) {
                textView2.setText(g.s);
            }
            ((Button) view2.findViewById(R.id.obfuscated_res_0x7f090fa0)).setOnClickListener(new a(this, optJSONObject));
        }
    }

    @Override // com.baidu.swan.support.v4.app.Fragment
    public View z0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, layoutInflater, viewGroup, bundle)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0885, viewGroup, false);
            X1(inflate);
            a3(inflate);
            if (W1()) {
                inflate = Z1(inflate);
            }
            return G1(inflate, this);
        }
        return (View) invokeLLL.objValue;
    }
}
