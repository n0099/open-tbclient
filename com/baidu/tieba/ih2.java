package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class ih2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947853430, "Lcom/baidu/tieba/ih2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947853430, "Lcom/baidu/tieba/ih2;");
                return;
            }
        }
        b = wj1.a;
    }

    public ih2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
    }

    public void a(gh2 gh2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, gh2Var) == null) {
            if (b) {
                Log.v("CommandDispatcher", gh2Var.b() + " command added to supported command list");
            }
            this.a.put(gh2Var.b(), gh2Var);
        }
    }

    public void b(ZeusPlugin.Command command, jh2 jh2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, command, jh2Var) == null) {
            if (command != null && !TextUtils.isEmpty(command.what)) {
                if (jh2Var == null) {
                    if (b) {
                        Log.e("CommandDispatcher", "inlineWidget is null, haven't dispatched");
                        return;
                    }
                    return;
                }
                gh2 gh2Var = (gh2) this.a.get(command.what);
                if (gh2Var == null) {
                    if (b) {
                        Log.e("CommandDispatcher", command.what + " command is not supported, haven't dispatched");
                        return;
                    }
                    return;
                }
                if (b) {
                    Log.d("CommandDispatcher", command.what + " command dispatched");
                }
                gh2Var.a(command, jh2Var);
            } else if (b) {
                Log.e("CommandDispatcher", "command or command.what is null, haven't dispatched");
            }
        }
    }

    public void c(ZeusPlugin.Command command) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, command) == null) {
            if (command != null && !TextUtils.isEmpty(command.what)) {
                gh2 gh2Var = (gh2) this.a.get(command.what);
                if (gh2Var == null) {
                    if (b) {
                        Log.e("CommandDispatcher", command.what + " command is not supported, haven't mocked");
                        return;
                    }
                    return;
                }
                if (b) {
                    Log.d("CommandDispatcher", command.what + " cached command return value processed");
                }
                gh2Var.c(command);
            } else if (b) {
                Log.e("CommandDispatcher", "command or command.what is null, haven't mocked");
            }
        }
    }
}
