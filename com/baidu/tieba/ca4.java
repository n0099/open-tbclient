package com.baidu.tieba;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ca4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gg2 a;
    public aa4 b;

    public ca4(gg2 gg2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gg2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = gg2Var;
        this.b = new aa4();
    }

    @NonNull
    public ga4 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return ga4.b("parameter error: the key cannot be null.");
            }
            Object obj = null;
            String p = this.b.p(str, null);
            if (p != null) {
                obj = this.a.B(Base64.decode(p, 2), true);
            }
            if (obj == null) {
                obj = ga4.h();
            }
            return ga4.i(obj);
        }
        return (ga4) invokeL.objValue;
    }

    @NonNull
    public ga4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            sk3.h.update();
            return ga4.i(null);
        }
        return (ga4) invokeV.objValue;
    }

    @NonNull
    public fa4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            fa4 fa4Var = new fa4();
            fa4Var.keys = n;
            fa4Var.currentSize = this.b.m() / 1024;
            fa4Var.limitSize = this.b.s() / 1024;
            fa4Var.errMsg = da4.b("getStorageInfoSync");
            return fa4Var;
        }
        return (fa4) invokeV.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) && jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    @NonNull
    public ga4 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return ga4.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            sk3.h.update();
            return ga4.i(null);
        }
        return (ga4) invokeL.objValue;
    }

    @NonNull
    public ga4 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return ga4.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return ga4.i(null);
            } else {
                byte[] I = this.a.I(jsSerializeValue, true);
                d(jsSerializeValue);
                if (I == null) {
                    return ga4.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(I, 2);
                String p = this.b.p(str, null);
                int length2 = str.getBytes().length;
                int length3 = encodeToString.length() + length2;
                if (p == null) {
                    length = 0;
                } else {
                    length = p.length() + length2;
                }
                if (this.b.s() - this.b.m() < length3 - length) {
                    return ga4.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                sk3.h.update();
                if (t) {
                    return ga4.i(null);
                }
                return ga4.b("storage error: the storage is invalid.");
            }
        }
        return (ga4) invokeLL.objValue;
    }
}
