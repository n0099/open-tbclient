package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskProcessData;
import com.baidu.searchbox.v8engine.JsFunction;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class f24 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JsFunction a;
    public JsFunction b;
    public JsFunction c;

    public f24() {
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

    public static f24 e(e02 e02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, e02Var)) == null) {
            if (e02Var == null) {
                return null;
            }
            f24 f24Var = new f24();
            f24Var.a = e02Var.u("success");
            f24Var.b = e02Var.u(com.baidu.pass.biometrics.face.liveness.b.a.g0);
            f24Var.c = e02Var.u(TaskProcessData.keyComplete);
            return f24Var;
        }
        return (f24) invokeL.objValue;
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
