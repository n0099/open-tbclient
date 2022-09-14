package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f54 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JsFunction a;
    public JsFunction b;
    public JsFunction c;

    public f54() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static f54 d(fv1 fv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, fv1Var)) == null) {
            if (fv1Var == null) {
                return null;
            }
            f54 f54Var = new f54();
            JsFunction u = fv1Var.u("onCheckForUpdate");
            f54Var.a = u;
            if (u != null) {
                u.setReleaseMode(false);
            }
            JsFunction u2 = fv1Var.u("onUpdateReady");
            f54Var.b = u2;
            if (u2 != null) {
                u2.setReleaseMode(false);
            }
            JsFunction u3 = fv1Var.u("onUpdateFailed");
            f54Var.c = u3;
            if (u3 != null) {
                u3.setReleaseMode(false);
            }
            return f54Var;
        }
        return (f54) invokeL.objValue;
    }

    public void a(g54 g54Var) {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, g54Var) == null) || (jsFunction = this.a) == null) {
            return;
        }
        jsFunction.call(g54Var);
    }

    public void b() {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (jsFunction = this.c) == null) {
            return;
        }
        jsFunction.call();
    }

    public void c() {
        JsFunction jsFunction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (jsFunction = this.b) == null) {
            return;
        }
        jsFunction.call();
    }
}
