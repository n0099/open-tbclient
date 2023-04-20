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
/* loaded from: classes3.dex */
public class b94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ff2 a;
    public z84 b;

    public b94(ff2 ff2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ff2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ff2Var;
        this.b = new z84();
    }

    @NonNull
    public f94 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return f94.b("parameter error: the key cannot be null.");
            }
            Object obj = null;
            String p = this.b.p(str, null);
            if (p != null) {
                obj = this.a.B(Base64.decode(p, 2), true);
            }
            if (obj == null) {
                obj = f94.h();
            }
            return f94.i(obj);
        }
        return (f94) invokeL.objValue;
    }

    @NonNull
    public f94 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            rj3.h.update();
            return f94.i(null);
        }
        return (f94) invokeV.objValue;
    }

    @NonNull
    public e94 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            e94 e94Var = new e94();
            e94Var.keys = n;
            e94Var.currentSize = this.b.m() / 1024;
            e94Var.limitSize = this.b.s() / 1024;
            e94Var.errMsg = c94.b("getStorageInfoSync");
            return e94Var;
        }
        return (e94) invokeV.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) && jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    @NonNull
    public f94 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return f94.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            rj3.h.update();
            return f94.i(null);
        }
        return (f94) invokeL.objValue;
    }

    @NonNull
    public f94 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return f94.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return f94.i(null);
            } else {
                byte[] L = this.a.L(jsSerializeValue, true);
                d(jsSerializeValue);
                if (L == null) {
                    return f94.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(L, 2);
                String p = this.b.p(str, null);
                int length2 = str.getBytes().length;
                int length3 = encodeToString.length() + length2;
                if (p == null) {
                    length = 0;
                } else {
                    length = p.length() + length2;
                }
                if (this.b.s() - this.b.m() < length3 - length) {
                    return f94.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                rj3.h.update();
                if (t) {
                    return f94.i(null);
                }
                return f94.b("storage error: the storage is invalid.");
            }
        }
        return (f94) invokeLL.objValue;
    }
}
