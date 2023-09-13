package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class e32 implements d32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, p43> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947683333, "Lcom/baidu/tieba/e32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947683333, "Lcom/baidu/tieba/e32;");
                return;
            }
        }
        b = rr1.a;
    }

    public e32() {
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
        this.a = new ConcurrentHashMap();
    }

    @Override // com.baidu.tieba.d32
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || this.a.containsKey(str)) {
            return;
        }
        if (b) {
            Log.d("Api-FirstRecorder", "markStart: " + str);
        }
        p43 p43Var = new p43();
        this.a.put(str, p43Var);
        p43Var.i(System.currentTimeMillis());
        p43Var.f(str);
    }

    @Override // com.baidu.tieba.d32
    @SuppressLint({"BDThrowableCheck"})
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            p43 p43Var = this.a.get(str);
            if (p43Var == null) {
                if (!b) {
                    return;
                }
                throw new RuntimeException(str + " markEnd before markStart");
            } else if (p43Var.d() > 0) {
            } else {
                p43Var.h(System.currentTimeMillis());
                if (b) {
                    Log.d("Api-FirstRecorder", str + " first called cost " + p43Var.c());
                }
                if (TextUtils.equals(str, "request")) {
                    if (b) {
                        Log.d("Api-FirstRecorder", "record first request api called " + p43Var.toString());
                    }
                    HybridUbcFlow p = m43.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("first_request_api_call_start");
                    ubcFlowEvent.h(p43Var.e());
                    p.F(ubcFlowEvent);
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("first_request_api_call_end");
                    ubcFlowEvent2.h(p43Var.d());
                    p.F(ubcFlowEvent2);
                }
            }
        }
    }
}
