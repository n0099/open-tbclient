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
/* loaded from: classes5.dex */
public class cd4 extends fd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd4(jj2 jj2Var) {
        super(jj2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jj2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((jj2) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void g(JsObject jsObject, String str, String str2, jd4 jd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, jsObject, str, str2, jd4Var) == null) {
            g42 n = n(jsObject);
            i64 i64Var = new i64();
            boolean g = jd4Var.g();
            i64Var.errMsg = jd4Var.c(str, str2);
            le4.call(n, g, i64Var);
            if (!g) {
                tc4.i(str2, i64Var.errMsg);
            }
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

    public void l(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jsObject) == null) {
            g42 n = n(jsObject);
            id4 b = b();
            b.errMsg = gd4.b("getStorageInfo");
            le4.call(n, true, b);
        }
    }

    @NonNull
    public final g42 n(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jsObject)) == null) {
            g42 F = g42.F(jsObject);
            if (F == null) {
                return new g42();
            }
            return F;
        }
        return (g42) invokeL.objValue;
    }

    public void o(JsObject jsObject) {
        String m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) != null) || (m = m(jsObject, "removeStorage")) == null) {
            return;
        }
        g(jsObject, "removeStorage", m, e(m));
    }

    public void p(JsObject jsObject) {
        String m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, jsObject) != null) || (m = m(jsObject, "setStorage")) == null) {
            return;
        }
        g(jsObject, "setStorage", m, f(m, i(jsObject)));
    }

    public final jd4 j(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jsObject)) == null) {
            for (int i = 0; i < jsObject.length(); i++) {
                if ("key".equals(jsObject.getPropertyName(i))) {
                    int propertyType = jsObject.getPropertyType(i);
                    if (propertyType == 7) {
                        return jd4.i(jsObject.toString(i));
                    }
                    return jd4.b(String.format("parameter error: the key must be string instead of %s.", jd4.f(propertyType)));
                }
            }
            return jd4.b("parameter error: the parameter key is necessary.");
        }
        return (jd4) invokeL.objValue;
    }

    public void k(JsObject jsObject) {
        String m;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, jsObject) != null) || (m = m(jsObject, "getStorage")) == null) {
            return;
        }
        jd4 c = c(m);
        if (c.g()) {
            hd4 hd4Var = new hd4();
            hd4Var.errMsg = gd4.b("getStorage");
            Object d = c.d();
            hd4Var.data = d;
            if (d instanceof JsSerializeValue) {
                ((JsSerializeValue) d).setAutoRelease(false);
            }
            le4.call(n(jsObject), true, hd4Var);
            return;
        }
        g(jsObject, "getStorage", m, c);
    }

    public final String m(JsObject jsObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, jsObject, str)) == null) {
            jd4 j = j(jsObject);
            if (!j.g()) {
                g(jsObject, str, "", j);
                return null;
            }
            return (String) j.d();
        }
        return (String) invokeLL.objValue;
    }
}
