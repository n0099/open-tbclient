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
public class e44 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ia2 a;
    public c44 b;

    public e44(ia2 ia2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ia2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = ia2Var;
        this.b = new c44();
    }

    @NonNull
    public i44 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            ue3.h.update();
            return i44.i(null);
        }
        return (i44) invokeV.objValue;
    }

    @NonNull
    public h44 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            h44 h44Var = new h44();
            h44Var.keys = n;
            h44Var.currentSize = this.b.m() / 1024;
            h44Var.limitSize = this.b.s() / 1024;
            h44Var.errMsg = f44.b("getStorageInfoSync");
            return h44Var;
        }
        return (h44) invokeV.objValue;
    }

    @NonNull
    public i44 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return i44.b("parameter error: the key cannot be null.");
            }
            String p = this.b.p(str, null);
            Object B = p != null ? this.a.B(Base64.decode(p, 2), true) : null;
            if (B == null) {
                B = i44.h();
            }
            return i44.i(B);
        }
        return (i44) invokeL.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) || jsSerializeValue == null) {
            return;
        }
        jsSerializeValue.release();
    }

    @NonNull
    public i44 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return i44.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            ue3.h.update();
            return i44.i(null);
        }
        return (i44) invokeL.objValue;
    }

    @NonNull
    public i44 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return i44.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return i44.i(null);
            } else {
                byte[] J = this.a.J(jsSerializeValue, true);
                d(jsSerializeValue);
                if (J == null) {
                    return i44.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(J, 2);
                String p = this.b.p(str, null);
                int length = str.getBytes().length;
                if (this.b.s() - this.b.m() < (encodeToString.length() + length) - (p == null ? 0 : p.length() + length)) {
                    return i44.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                ue3.h.update();
                return t ? i44.i(null) : i44.b("storage error: the storage is invalid.");
            }
        }
        return (i44) invokeLL.objValue;
    }
}
