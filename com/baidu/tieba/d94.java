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
public class d94 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hf2 a;
    public b94 b;

    public d94(hf2 hf2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hf2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = hf2Var;
        this.b = new b94();
    }

    @NonNull
    public h94 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return h94.b("parameter error: the key cannot be null.");
            }
            Object obj = null;
            String p = this.b.p(str, null);
            if (p != null) {
                obj = this.a.B(Base64.decode(p, 2), true);
            }
            if (obj == null) {
                obj = h94.h();
            }
            return h94.i(obj);
        }
        return (h94) invokeL.objValue;
    }

    @NonNull
    public h94 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            tj3.h.update();
            return h94.i(null);
        }
        return (h94) invokeV.objValue;
    }

    @NonNull
    public g94 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            g94 g94Var = new g94();
            g94Var.keys = n;
            g94Var.currentSize = this.b.m() / 1024;
            g94Var.limitSize = this.b.s() / 1024;
            g94Var.errMsg = e94.b("getStorageInfoSync");
            return g94Var;
        }
        return (g94) invokeV.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) && jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    @NonNull
    public h94 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return h94.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            tj3.h.update();
            return h94.i(null);
        }
        return (h94) invokeL.objValue;
    }

    @NonNull
    public h94 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return h94.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return h94.i(null);
            } else {
                byte[] L = this.a.L(jsSerializeValue, true);
                d(jsSerializeValue);
                if (L == null) {
                    return h94.b("parameter error: the data parse failed.");
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
                    return h94.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                tj3.h.update();
                if (t) {
                    return h94.i(null);
                }
                return h94.b("storage error: the storage is invalid.");
            }
        }
        return (h94) invokeLL.objValue;
    }
}
