package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c24 extends f24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c24(k82 k82Var) {
        super(k82Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k82Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k82) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void g(JsObject jsObject, String str, String str2, j24 j24Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, jsObject, str, str2, j24Var) == null) {
            ht1 n = n(jsObject);
            iv3 iv3Var = new iv3();
            boolean g = j24Var.g();
            iv3Var.errMsg = j24Var.c(str, str2);
            l34.call(n, g, iv3Var);
            if (g) {
                return;
            }
            t14.i(str2, iv3Var.errMsg);
        }
    }

    public void h(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            g(jsObject, "clearStorage", "", a());
        }
    }

    public final JsSerializeValue i(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject)) == null) {
            for (int i = 0; i < jsObject.length(); i++) {
                if ("data".equals(jsObject.getPropertyName(i))) {
                    return jsObject.toSerializeValue(i);
                }
            }
            return null;
        }
        return (JsSerializeValue) invokeL.objValue;
    }

    public final j24 j(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jsObject)) == null) {
            for (int i = 0; i < jsObject.length(); i++) {
                if ("key".equals(jsObject.getPropertyName(i))) {
                    int propertyType = jsObject.getPropertyType(i);
                    return propertyType == 7 ? j24.i(jsObject.toString(i)) : j24.b(String.format("parameter error: the key must be string instead of %s.", j24.f(propertyType)));
                }
            }
            return j24.b("parameter error: the parameter key is necessary.");
        }
        return (j24) invokeL.objValue;
    }

    public void k(JsObject jsObject) {
        String m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, jsObject) == null) || (m = m(jsObject, "getStorage")) == null) {
            return;
        }
        j24 c = c(m);
        if (c.g()) {
            h24 h24Var = new h24();
            h24Var.errMsg = g24.b("getStorage");
            Object d = c.d();
            h24Var.data = d;
            if (d instanceof JsSerializeValue) {
                ((JsSerializeValue) d).setAutoRelease(false);
            }
            l34.call(n(jsObject), true, h24Var);
            return;
        }
        g(jsObject, "getStorage", m, c);
    }

    public void l(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) {
            ht1 n = n(jsObject);
            i24 b = b();
            b.errMsg = g24.b("getStorageInfo");
            l34.call(n, true, b);
        }
    }

    public final String m(JsObject jsObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, jsObject, str)) == null) {
            j24 j = j(jsObject);
            if (!j.g()) {
                g(jsObject, str, "", j);
                return null;
            }
            return (String) j.d();
        }
        return (String) invokeLL.objValue;
    }

    @NonNull
    public final ht1 n(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jsObject)) == null) {
            ht1 F = ht1.F(jsObject);
            return F == null ? new ht1() : F;
        }
        return (ht1) invokeL.objValue;
    }

    public void o(JsObject jsObject) {
        String m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) || (m = m(jsObject, "removeStorage")) == null) {
            return;
        }
        g(jsObject, "removeStorage", m, e(m));
    }

    public void p(JsObject jsObject) {
        String m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, jsObject) == null) || (m = m(jsObject, "setStorage")) == null) {
            return;
        }
        g(jsObject, "setStorage", m, f(m, i(jsObject)));
    }
}
