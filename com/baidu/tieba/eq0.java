package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.request.BodyStyle;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class eq0 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] g;
    public static final eq0 h;
    public transient /* synthetic */ FieldHolder $fh;
    public BodyStyle a;
    public String b;
    public String c;
    public byte[] d;
    public File e;
    public Map<String, String> f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947742853, "Lcom/baidu/tieba/eq0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947742853, "Lcom/baidu/tieba/eq0;");
                return;
            }
        }
        byte[] bArr = new byte[0];
        g = bArr;
        h = d(null, bArr);
        b(null, "");
        c(null, new HashMap());
    }

    public eq0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static eq0 b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            eq0 eq0Var = new eq0();
            eq0Var.k(BodyStyle.STRING);
            eq0Var.i(str);
            eq0Var.h(str2);
            return eq0Var;
        }
        return (eq0) invokeLL.objValue;
    }

    public static eq0 c(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, map)) == null) {
            eq0 eq0Var = new eq0();
            eq0Var.k(BodyStyle.FORM);
            eq0Var.i(str);
            eq0Var.j(map);
            return eq0Var;
        }
        return (eq0) invokeLL.objValue;
    }

    public static eq0 d(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, bArr)) == null) {
            eq0 eq0Var = new eq0();
            eq0Var.k(BodyStyle.BYTE);
            eq0Var.i(str);
            eq0Var.g(bArr);
            return eq0Var;
        }
        return (eq0) invokeLL.objValue;
    }

    public static eq0 e(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, map)) == null) ? c("application/x-www-form-urlencoded", map) : (eq0) invokeL.objValue;
    }

    public static eq0 f(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) ? d("application/octet-stream", bArr) : (eq0) invokeL.objValue;
    }

    public eq0 a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            if (this.f == null) {
                this.f = new HashMap();
            }
            this.f.put(str, str2);
            return this;
        }
        return (eq0) invokeLL.objValue;
    }

    public eq0 g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            this.d = bArr;
            return this;
        }
        return (eq0) invokeL.objValue;
    }

    public eq0 h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            this.c = str;
            return this;
        }
        return (eq0) invokeL.objValue;
    }

    public eq0 i(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.b = str;
            return this;
        }
        return (eq0) invokeL.objValue;
    }

    public eq0 j(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, map)) == null) {
            this.f = map;
            return this;
        }
        return (eq0) invokeL.objValue;
    }

    public eq0 k(BodyStyle bodyStyle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bodyStyle)) == null) {
            this.a = bodyStyle;
            return this;
        }
        return (eq0) invokeL.objValue;
    }
}
