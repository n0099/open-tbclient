package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class hp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public List<jp9> h;
    public Map<String, ip9> i;

    public void n(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, map) == null) {
        }
    }

    public void o(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947831544, "Lcom/baidu/tieba/hp9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947831544, "Lcom/baidu/tieba/hp9;");
                return;
            }
        }
        AppConfig.isDebug();
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.equals("1", this.b)) {
                this.b = "0";
            }
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (!TextUtils.equals("0", this.a)) {
                this.a = "1";
            }
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public Map<String, ip9> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.i;
        }
        return (Map) invokeV.objValue;
    }

    public float d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            float f = this.g;
            if (f <= 0.0f || Float.isNaN(f)) {
                this.g = 20.0f;
            }
            return this.g;
        }
        return invokeV.floatValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float f = this.d;
            if (f <= 0.0f || Float.isNaN(f)) {
                this.d = 1.0f;
            }
            return this.d;
        }
        return invokeV.floatValue;
    }

    public List<jp9> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.h;
        }
        return (List) invokeV.objValue;
    }

    public float g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float f = this.e;
            if (f <= 0.0f || Float.isNaN(f)) {
                this.e = 20.0f;
            }
            return this.e;
        }
        return invokeV.floatValue;
    }

    public float h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            float f = this.f;
            if (f <= 0.0f || Float.isNaN(f)) {
                this.f = 7.0f;
            }
            return this.f;
        }
        return invokeV.floatValue;
    }

    public float i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            float f = this.c;
            if (f <= 0.0f || Float.isNaN(f)) {
                this.c = 100.0f;
            }
            return this.c;
        }
        return invokeV.floatValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return TextUtils.equals("1", a());
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return TextUtils.equals("1", b());
        }
        return invokeV.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.a = "1";
            this.b = "0";
            this.c = 100.0f;
            this.d = 1.0f;
            this.e = 20.0f;
            this.f = 7.0f;
            this.g = 20.0f;
        }
    }

    public hp9() {
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
        this.h = new ArrayList();
        new ArrayList();
        new HashMap();
        this.i = new HashMap();
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.b = str;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.a = str;
        }
    }

    public void q(Map<String, ip9> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, map) == null) {
            this.i = map;
        }
    }

    public void r(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f) == null) {
            this.g = f;
        }
    }

    public void s(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048594, this, f) == null) {
            this.d = f;
        }
    }

    public void t(List<jp9> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, list) == null) {
            this.h = list;
        }
    }

    public void u(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f) == null) {
            this.e = f;
        }
    }

    public void v(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f) == null) {
            this.f = f;
        }
    }

    public void w(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f) == null) {
            this.c = f;
        }
    }
}
