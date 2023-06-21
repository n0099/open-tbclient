package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class h64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JsFunction a;
    public JsFunction b;
    public JsFunction c;

    public h64() {
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

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JsFunction jsFunction = this.b;
            if (jsFunction != null) {
                jsFunction.call();
            }
            JsFunction jsFunction2 = this.c;
            if (jsFunction2 != null) {
                jsFunction2.call();
            }
            f(this.a);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            JsFunction jsFunction = this.a;
            if (jsFunction != null) {
                jsFunction.call();
            }
            JsFunction jsFunction2 = this.c;
            if (jsFunction2 != null) {
                jsFunction2.call();
            }
            f(this.b);
        }
    }

    public static h64 e(g42 g42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, g42Var)) == null) {
            if (g42Var == null) {
                return null;
            }
            h64 h64Var = new h64();
            h64Var.a = g42Var.u("success");
            h64Var.b = g42Var.u("fail");
            h64Var.c = g42Var.u(TaskProcessData.keyComplete);
            return h64Var;
        }
        return (h64) invokeL.objValue;
    }

    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            JsFunction jsFunction = this.b;
            if (jsFunction != null) {
                jsFunction.call(obj);
            }
            JsFunction jsFunction2 = this.c;
            if (jsFunction2 != null) {
                jsFunction2.call(obj);
            }
            f(this.a);
        }
    }

    public void d(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            JsFunction jsFunction = this.a;
            if (jsFunction != null) {
                jsFunction.call(obj);
            }
            JsFunction jsFunction2 = this.c;
            if (jsFunction2 != null) {
                jsFunction2.call(obj);
            }
            f(this.b);
        }
    }

    public final void f(JsFunction jsFunction) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, jsFunction) == null) && jsFunction != null) {
            jsFunction.release();
        }
    }
}
