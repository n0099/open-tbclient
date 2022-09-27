package com.baidu.tieba;

import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e52 extends ta2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a extends EventTargetImpl {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @V8JavascriptField
        public ua2 env;

        /* renamed from: com.baidu.tieba.e52$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0233a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0233a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    tg3.a(yo2.U().getActivity());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(va2 va2Var, String str) {
            super(va2Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {va2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((JSRuntime) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            ua2 ua2Var = new ua2();
            this.env = ua2Var;
            ua2Var.basePath = str;
        }

        @JavascriptInterface
        public void addMask() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l02.k("SwanAppV8DaemonEngine", "addMask");
                v02.b();
            }
        }

        @JavascriptInterface
        public String closeConnect(JsObject jsObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject)) == null) {
                if (e52.o) {
                    Log.d("SwanAppV8DaemonEngine", "closeConnect params = " + jsObject);
                }
                return x02.d(jsObject);
            }
            return (String) invokeL.objValue;
        }

        @JavascriptInterface
        public String connectDevTool(JsObject jsObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsObject)) == null) {
                if (e52.o) {
                    Log.d("SwanAppV8DaemonEngine", "connectDevTool params = " + jsObject);
                }
                return x02.e(jsObject);
            }
            return (String) invokeL.objValue;
        }

        @JavascriptInterface
        public boolean freeMaster() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                l02.k("SwanAppV8DaemonEngine", "freeMaster");
                synchronized (xa2.p) {
                    try {
                        try {
                            xa2.p.notify();
                        } catch (IllegalMonitorStateException e) {
                            e.printStackTrace();
                            return false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        @JavascriptInterface
        public String getDevToolsResponse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (e52.o) {
                    Log.d("SwanAppV8DaemonEngine", "getDevToolsResponse = " + xa2.q);
                }
                return xa2.q;
            }
            return (String) invokeV.objValue;
        }

        @JavascriptInterface
        public void reload() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                l02.k("SwanAppV8DaemonEngine", "reload");
                fh3.a0(new RunnableC0233a(this));
            }
        }

        @JavascriptInterface
        public void removeMask() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                l02.k("SwanAppV8DaemonEngine", "removeMask");
                v02.c();
            }
        }

        @JavascriptInterface
        public String sendMsgToDevTool(JsObject jsObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jsObject)) == null) {
                if (e52.o) {
                    Log.d("SwanAppV8DaemonEngine", "sendMsgToDevTool params = " + jsObject);
                }
                return x02.m(jsObject);
            }
            return (String) invokeL.objValue;
        }

        @JavascriptInterface
        public void setDevToolsResponse(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
                if (e52.o) {
                    Log.d("SwanAppV8DaemonEngine", "setDevToolsResponse = " + str);
                }
                xa2.q = str;
            }
        }

        @JavascriptInterface
        public void shutdown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
                l02.k("SwanAppV8DaemonEngine", "shutdown");
                w02.k().r();
                yo2.U().exit();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947685255, "Lcom/baidu/tieba/e52;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947685255, "Lcom/baidu/tieba/e52;");
                return;
            }
        }
        o = vj1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e52(@NonNull String str, @NonNull qb2 qb2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, qb2Var, v8ThreadDelegatePolicy);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, qb2Var, v8ThreadDelegatePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (qb2) objArr2[1], (V8ThreadDelegatePolicy) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ta2
    @NonNull
    public EventTarget A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a aVar = new a(this, this.b.getInitBasePath());
            aVar.env.config = rc3.b();
            return aVar;
        }
        return (EventTarget) invokeV.objValue;
    }

    @Override // com.baidu.tieba.va2, com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }
}
