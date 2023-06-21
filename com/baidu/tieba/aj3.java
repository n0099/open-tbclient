package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
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
public class aj3 extends cj3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean x;
    public static int y;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean v;
    public JSONObject w;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947617055, "Lcom/baidu/tieba/aj3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947617055, "Lcom/baidu/tieba/aj3;");
                return;
            }
        }
        x = js1.a;
        y = 35;
    }

    public aj3() {
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
        this.v = false;
        this.c = "NA";
    }

    @Override // com.baidu.tieba.cj3, com.baidu.tieba.bj3
    public JSONObject f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.h == null) {
                this.h = new JSONObject();
            }
            try {
                if (this.w != null) {
                    if (this.v) {
                        String z = tp3.z(y);
                        if (!TextUtils.isEmpty(z)) {
                            this.w.put("stacktrace", z);
                        }
                    }
                    if (this.w.length() != 0) {
                        this.h.put("info", this.w);
                    }
                }
                ExtensionCore T2 = ti2.U().T();
                if (T2 != null) {
                    this.h.put("extension_ver", T2.extensionCoreVersionName);
                }
            } catch (JSONException e) {
                if (x) {
                    e.printStackTrace();
                }
            }
            return super.f();
        }
        return (JSONObject) invokeV.objValue;
    }

    public aj3 l(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            if (str != null && str2 != null) {
                if (this.w == null) {
                    this.w = new JSONObject();
                }
                try {
                    this.w.put(str, str2);
                } catch (JSONException e) {
                    if (x) {
                        e.printStackTrace();
                    }
                }
            }
            return this;
        }
        return (aj3) invokeLL.objValue;
    }

    public aj3 m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.f = str;
            return this;
        }
        return (aj3) invokeL.objValue;
    }

    public aj3 n(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.v = z;
            return this;
        }
        return (aj3) invokeZ.objValue;
    }

    public aj3 o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            this.b = String.valueOf(i);
            return this;
        }
        return (aj3) invokeI.objValue;
    }

    public aj3 p(@NonNull sn3 sn3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sn3Var)) == null) {
            this.b = String.valueOf(sn3Var.a());
            String sb = sn3Var.g().toString();
            if (!TextUtils.isEmpty(sb)) {
                l("detail", sb);
            }
            return this;
        }
        return (aj3) invokeL.objValue;
    }

    public aj3 q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            this.a = str;
            return this;
        }
        return (aj3) invokeL.objValue;
    }

    public aj3 s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            this.g = str;
            return this;
        }
        return (aj3) invokeL.objValue;
    }

    public aj3 t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (aj3) invokeL.objValue;
    }

    public aj3 r(zw2 zw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, zw2Var)) == null) {
            if (zw2Var == null) {
                return this;
            }
            if (!TextUtils.isEmpty(zw2Var.T())) {
                this.c = zw2Var.T();
            }
            if (!TextUtils.isEmpty(zw2Var.H())) {
                this.f = zw2Var.H();
            }
            if (!TextUtils.isEmpty(zw2Var.W())) {
                this.p = zw2Var.W();
            }
            if (!TextUtils.isEmpty(zw2Var.e0())) {
                this.s = zw2Var.e0();
            }
            return this;
        }
        return (aj3) invokeL.objValue;
    }
}
