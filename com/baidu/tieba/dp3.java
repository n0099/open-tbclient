package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dp3 extends ap3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947712194, "Lcom/baidu/tieba/dp3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947712194, "Lcom/baidu/tieba/dp3;");
                return;
            }
        }
        b = qp1.a;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (b) {
                Log.i("WebStatsStrategy", "onUserCancel: report");
            }
            a();
            l();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && !this.a.d("na_start")) {
            this.a.g("na_start");
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.a.e()) {
            this.a.k();
            lr2.e();
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a.i();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dp3(String str) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public boolean b(String str) {
        URI uri;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                uri = new URI(str);
            } catch (URISyntaxException e) {
                if (b) {
                    e.printStackTrace();
                }
                uri = null;
            }
            if (uri != null && !TextUtils.isEmpty(uri.getPath()) && !TextUtils.equals("/", uri.getPath())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (b) {
                Log.i("WebStatsStrategy", "onFcpSubmit: " + str);
            }
            if (!this.a.d("na_fcp")) {
                this.a.g("na_fcp");
            }
        }
    }

    public void h(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && !b(str) && !this.a.d("na_load_url_end")) {
            this.a.g("na_load_url_end");
            this.a.f("load_end_url", str);
            boolean d = this.a.d("fe_fmp");
            cp3 cp3Var = this.a;
            if (d) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            cp3Var.f("fmpArrived", str2);
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if (b) {
                Log.i("WebStatsStrategy", "onLoadUrlStart: " + str);
            }
            if (!this.a.d("na_load_url")) {
                this.a.g("na_load_url");
                this.a.f("load_url", str);
            }
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && !b(str) && !this.a.d("na_first_image_paint")) {
            this.a.g("na_first_image_paint");
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !b(str) && !this.a.d("na_first_text_paint")) {
            this.a.g("na_first_text_paint");
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (b) {
                Log.i("WebStatsStrategy", "onFmpSubmit: " + str);
            }
            if (!this.a.d("na_up_screen")) {
                this.a.g("na_up_screen");
            }
            if (this.a.d("fe_fmp")) {
                a();
                l();
            }
        }
    }

    public void g(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, jSONArray) == null) && jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    this.a.h(jSONObject.optString("actionId"), jSONObject.optLong("timestamp"));
                } catch (JSONException e) {
                    if (b) {
                        e.printStackTrace();
                    }
                }
            }
            this.a.g("fe_fmp");
            if (this.a.d("na_up_screen")) {
                a();
                l();
            }
        }
    }
}
