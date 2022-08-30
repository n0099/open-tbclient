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
public class f24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k82 a;
    public d24 b;

    public f24(k82 k82Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k82Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = k82Var;
        this.b = new d24();
    }

    @NonNull
    public j24 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.b.j();
            wc3.h.update();
            return j24.i(null);
        }
        return (j24) invokeV.objValue;
    }

    @NonNull
    public i24 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String[] n = this.b.n();
            i24 i24Var = new i24();
            i24Var.keys = n;
            i24Var.currentSize = this.b.m() / 1024;
            i24Var.limitSize = this.b.s() / 1024;
            i24Var.errMsg = g24.b("getStorageInfoSync");
            return i24Var;
        }
        return (i24) invokeV.objValue;
    }

    @NonNull
    public j24 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (str == null) {
                return j24.b("parameter error: the key cannot be null.");
            }
            String p = this.b.p(str, null);
            Object A = p != null ? this.a.A(Base64.decode(p, 2), true) : null;
            if (A == null) {
                A = j24.h();
            }
            return j24.i(A);
        }
        return (j24) invokeL.objValue;
    }

    public final void d(JsSerializeValue jsSerializeValue) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jsSerializeValue) == null) || jsSerializeValue == null) {
            return;
        }
        jsSerializeValue.release();
    }

    @NonNull
    public j24 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return j24.b("parameter error: the key cannot be null.");
            }
            this.b.u(str);
            wc3.h.update();
            return j24.i(null);
        }
        return (j24) invokeL.objValue;
    }

    @NonNull
    public j24 f(String str, JsSerializeValue jsSerializeValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, jsSerializeValue)) == null) {
            if (str == null) {
                d(jsSerializeValue);
                return j24.b("parameter error: the key cannot be null.");
            } else if (jsSerializeValue == null) {
                return j24.i(null);
            } else {
                byte[] I = this.a.I(jsSerializeValue, true);
                d(jsSerializeValue);
                if (I == null) {
                    return j24.b("parameter error: the data parse failed.");
                }
                String encodeToString = Base64.encodeToString(I, 2);
                String p = this.b.p(str, null);
                int length = str.getBytes().length;
                if (this.b.s() - this.b.m() < (encodeToString.length() + length) - (p == null ? 0 : p.length() + length)) {
                    return j24.b("storage error: the storage space insufficient.");
                }
                boolean t = this.b.t(str, encodeToString);
                wc3.h.update();
                return t ? j24.i(null) : j24.b("storage error: the storage is invalid.");
            }
        }
        return (j24) invokeLL.objValue;
    }
}
