package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.swan.apps.jsbridge.SwanAppGlobalJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppNativeSwanJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppPreloadJsBridge;
import com.baidu.swan.apps.jsbridge.SwanAppUtilsJavaScriptInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ew2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dw2 a;
    public dw2 b;
    public SwanAppUtilsJavaScriptInterface c;
    public tz1 d;

    public ew2() {
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

    public void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, activity) == null) {
            dw2 dw2Var = this.a;
            if (dw2Var != null) {
                dw2Var.setActivityRef(activity);
            }
            dw2 dw2Var2 = this.b;
            if (dw2Var2 != null) {
                dw2Var2.setActivityRef(activity);
            }
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = this.c;
            if (swanAppUtilsJavaScriptInterface != null) {
                swanAppUtilsJavaScriptInterface.setActivity(activity);
            }
            tz1 tz1Var = this.d;
            if (tz1Var != null) {
                tz1Var.i(activity);
            }
        }
    }

    public final void d(ta2 ta2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ta2Var) == null) {
            ta2Var.addJavascriptInterface(new SwanAppNativeSwanJsBridge(ta2Var), SwanAppNativeSwanJsBridge.JAVASCRIPT_INTERFACE_NAME);
        }
    }

    public final void b(ta2 ta2Var, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher, @NonNull tz1 tz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ta2Var, context, callbackHandler, unitedSchemeMainDispatcher, tz1Var) == null) {
            SwanAppGlobalJsBridge swanAppGlobalJsBridge = new SwanAppGlobalJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, ta2Var);
            this.a = swanAppGlobalJsBridge;
            ta2Var.addJavascriptInterface(swanAppGlobalJsBridge, SwanAppGlobalJsBridge.JAVASCRIPT_INTERFACE_NAME);
            SwanAppJsBridge swanAppJsBridge = new SwanAppJsBridge(context, unitedSchemeMainDispatcher, callbackHandler, ta2Var);
            this.b = swanAppJsBridge;
            ta2Var.addJavascriptInterface(swanAppJsBridge, SwanAppJsBridge.JAVASCRIPT_INTERFACE_NAME);
            ta2Var.addJavascriptInterface(new SwanAppPreloadJsBridge(ta2Var), SwanAppPreloadJsBridge.JAVASCRIPT_INTERFACE_NAME);
            tz1Var.b(ta2Var);
        }
    }

    public final void c(@NonNull ta2 ta2Var, Context context, @NonNull tz1 tz1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, ta2Var, context, tz1Var) == null) {
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, ta2Var);
            this.c = swanAppUtilsJavaScriptInterface;
            swanAppUtilsJavaScriptInterface.setSource("swan_");
            ta2Var.addJavascriptInterface(this.c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
            tz1Var.a(ta2Var);
        }
    }

    public void e(ta2 ta2Var, Context context, CallbackHandler callbackHandler, UnitedSchemeMainDispatcher unitedSchemeMainDispatcher) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048580, this, ta2Var, context, callbackHandler, unitedSchemeMainDispatcher) == null) && ta2Var != null && context != null && callbackHandler != null && unitedSchemeMainDispatcher != null) {
            tz1 tz1Var = new tz1(context, callbackHandler, ta2Var);
            this.d = tz1Var;
            b(ta2Var, context, callbackHandler, unitedSchemeMainDispatcher, tz1Var);
            if (ta2Var instanceof fj2) {
                c(ta2Var, context, this.d);
            } else {
                d(ta2Var);
            }
        }
    }

    public void f(Context context, ta2 ta2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, ta2Var) == null) {
            SwanAppUtilsJavaScriptInterface swanAppUtilsJavaScriptInterface = new SwanAppUtilsJavaScriptInterface(context, ta2Var);
            this.c = swanAppUtilsJavaScriptInterface;
            swanAppUtilsJavaScriptInterface.setSource("swan_");
            ta2Var.addJavascriptInterface(this.c, SwanAppUtilsJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
            this.c.setForceShareLight(true);
        }
    }
}
