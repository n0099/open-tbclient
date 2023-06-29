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
/* loaded from: classes6.dex */
public class id4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mj2 a;
    public gd4 b;

    public id4(mj2 mj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mj2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mj2Var;
        this.b = new gd4();
    }

    @NonNull
    public md4 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return md4.b("parameter error: the key cannot be null.");
            }
            Object obj = null;
            String p = this.b.p(str, null);
            if (p != null) {
                obj = this.a.A(Base64.decode(p, 2), true);
            }
            if (obj == null) {
                obj = md4.h();
            }
            return md4.i(obj);
        }
        return (md4) invokeL.objValue;
    }

    @NonNull
    public md4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            yn3.h.update();
            return md4.i(null);
        }
        return (md4) invokeV.objValue;
    }

    @NonNull
    public ld4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            ld4 ld4Var = new ld4();
            ld4Var.keys = n;
            ld4Var.currentSize = this.b.m() / 1024;
            ld4Var.limitSize = this.b.s() / 1024;
            ld4Var.errMsg = jd4.b("getStorageInfoSync");
            return ld4Var;
        }
        return (ld4) invokeV.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) && jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }

    @NonNull
    public md4 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return md4.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            yn3.h.update();
            return md4.i(null);
        }
        return (md4) invokeL.objValue;
    }

    @NonNull
    public md4 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return md4.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return md4.i(null);
            } else {
                byte[] K = this.a.K(jsSerializeValue, true);
                d(jsSerializeValue);
                if (K == null) {
                    return md4.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(K, 2);
                String p = this.b.p(str, null);
                int length2 = str.getBytes().length;
                int length3 = encodeToString.length() + length2;
                if (p == null) {
                    length = 0;
                } else {
                    length = p.length() + length2;
                }
                if (this.b.s() - this.b.m() < length3 - length) {
                    return md4.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                yn3.h.update();
                if (t) {
                    return md4.i(null);
                }
                return md4.b("storage error: the storage is invalid.");
            }
        }
        return (md4) invokeLL.objValue;
    }
}
