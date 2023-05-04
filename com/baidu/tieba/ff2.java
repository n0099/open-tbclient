package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.CustomJsCodeCacheHandler;
import com.baidu.searchbox.v8engine.InspectorNativeChannel;
import com.baidu.searchbox.v8engine.InspectorNativeClient;
import com.baidu.searchbox.v8engine.JSExceptionType;
import com.baidu.searchbox.v8engine.JsCodeCacheCallback;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.searchbox.v8engine.filesystem.V8FileSystemDelegatePolicy;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.thread.V8ExecuteCallback;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.tieba.p62;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class ff2 implements hf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public V8Engine a;
    public cg2 b;
    public final String c;
    public EventTarget d;
    public EventTarget e;
    public Context f;
    public tf2 g;
    public uf2 h;
    public qf2 i;
    public List<JSEvent> j;
    public int k;
    public boolean l;
    public boolean m;

    @NonNull
    public abstract EventTarget A();

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public String getCurrentPageUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v62
    public boolean isWebView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class a extends CustomJsCodeCacheHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(ff2 ff2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.searchbox.v8engine.CustomJsCodeCacheHandler
        public String getJsCodeCacheFilePath(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                File file = new File(str);
                float b = p62.b.b() * 1024.0f;
                if (b > 0.0f && ((float) file.length()) < b) {
                    return null;
                }
                return str + "_cache";
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements V8Engine.V8StatusListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff2 a;

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        public b(ff2 ff2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ff2Var;
        }

        @Override // com.baidu.searchbox.v8engine.V8Engine.V8StatusListener
        public void onReady() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                hx1.f(this.a.a);
                this.a.z0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements V8ExecuteCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff2 a;

        public c(ff2 ff2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ff2Var;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ExecuteCallback
        public void onExecuted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (ff2.n) {
                    Log.d("SwanAppV8Engine", "finish onExecuted.");
                }
                this.a.w0();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSEvent a;
        public final /* synthetic */ ff2 b;

        public d(ff2 ff2Var, JSEvent jSEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff2Var, jSEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ff2Var;
            this.a = jSEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.b.u0()) {
                    if (ff2.n) {
                        Log.d("SwanAppV8Engine", "dispatchEvent add to pending list.");
                    }
                    this.b.j.add(this.a);
                    return;
                }
                this.b.d.dispatchEvent(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff2 a;

        public e(ff2 ff2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ff2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (JSEvent jSEvent : this.a.j) {
                    if (ff2.n) {
                        Log.d("SwanAppV8Engine", "doPendingDispatch event type: " + jSEvent.type);
                    }
                    this.a.dispatchEvent(jSEvent);
                }
                this.a.j.clear();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947762135, "Lcom/baidu/tieba/ff2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947762135, "Lcom/baidu/tieba/ff2;");
                return;
            }
        }
        n = ho1.a;
        qd3.c();
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            u(new rf2(this));
            G0(new sf2(this));
        }
    }

    @NonNull
    public EventTarget D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return new EventTargetImpl(this);
        }
        return (EventTarget) invokeV.objValue;
    }

    public void D0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a != null) {
            mp1 m = fr2.m();
            String str = null;
            if (m != null) {
                str = m.e();
            }
            this.a.setBdFileRealPath(str);
        }
    }

    public void H0() {
        V8Engine v8Engine;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (v8Engine = this.a) != null) {
            v8Engine.setMainPackageBasePath(kt2.U().z());
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (n) {
                Log.d("SwanAppV8Engine", "doPendingDispatch start.");
            }
            runOnJSThread(new e(this));
        }
    }

    @Override // com.baidu.tieba.hf2
    public uf2 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == null) {
                this.h = new uf2(this.a);
            }
            return this.h;
        }
        return (uf2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v62
    public String getContainerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.f;
        }
        return (Context) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hf2
    public String getInitBasePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.b.getInitBasePath();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v62
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return kt2.U().z();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v62
    public boolean isDestroyed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048604, this) != null) || this.l) {
            return;
        }
        if (n) {
            Log.d("SwanAppV8Engine", "finish called.");
        }
        this.l = true;
        x0();
        this.a.destroyEngine(new c(this));
    }

    public V8Engine l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.a;
        }
        return (V8Engine) invokeV.objValue;
    }

    public String m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.c + "] : ";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hf2
    public EventTarget n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.d;
        }
        return (EventTarget) invokeV.objValue;
    }

    public NetRequest n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.a.getNetRequest();
        }
        return (NetRequest) invokeV.objValue;
    }

    public JSONArray o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            V8Engine v8Engine = this.a;
            if (v8Engine == null) {
                return null;
            }
            return v8Engine.getPerformanceJson();
        }
        return (JSONArray) invokeV.objValue;
    }

    @Override // com.baidu.tieba.v62
    public void onJSLoaded() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            re2.U().w0(true);
        }
    }

    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            V8Engine v8Engine = this.a;
            if (v8Engine != null) {
                v8Engine.onPause();
            }
            p0().f(this);
            this.k = 4;
        }
    }

    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            V8Engine v8Engine = this.a;
            if (v8Engine != null) {
                v8Engine.onResume();
            }
            p0().h(this);
            this.k = 5;
        }
    }

    public final kf2 p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return kf2.i();
        }
        return (kf2) invokeV.objValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (this.k == 7) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.m;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.hf2
    public EventTarget v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.e;
        }
        return (EventTarget) invokeV.objValue;
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            p0().b(this);
            this.k = 1;
        }
    }

    @Override // com.baidu.tieba.hf2
    public qf2 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.i;
        }
        return (qf2) invokeV.objValue;
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            p0().c(this);
            this.k = 7;
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            p0().d(this);
            this.k = 6;
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            p0().e(this);
            this.k = 3;
            this.m = true;
            S();
        }
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048634, this) == null) {
            p0().g(this);
            this.k = 2;
            this.b.c(this);
        }
    }

    public ff2(@NonNull String str, @NonNull cg2 cg2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, cg2Var, v8ThreadDelegatePolicy};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 0;
        this.m = false;
        this.c = str;
        this.b = cg2Var;
        String initBasePath = getInitBasePath();
        if (TextUtils.isEmpty(initBasePath)) {
            return;
        }
        this.d = A();
        this.e = D();
        V8Engine v8Engine = new V8Engine(AppRuntime.getAppContext(), initBasePath, this.b.a(), v8ThreadDelegatePolicy, this.d, this.e);
        this.a = v8Engine;
        if (v8ThreadDelegatePolicy instanceof y92) {
            ((y92) v8ThreadDelegatePolicy).d(v8Engine);
        }
        this.a.setExternalV8BinFilesPath(qd3.a());
        this.a.setFileSystemDelegatePolicy(new yf2());
        if (cg2Var.b() != null) {
            this.a.setCodeCacheSetting(cg2Var.b());
        }
        this.g = new tf2(this.a);
        this.i = new qf2(this.a);
        this.j = new ArrayList();
        v0();
    }

    public void B0(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, codeCacheSetting) == null) {
            this.a.setCodeCacheSetting(codeCacheSetting);
        }
    }

    public void C0(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.f = context;
        }
    }

    public void E0(V8FileSystemDelegatePolicy v8FileSystemDelegatePolicy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, v8FileSystemDelegatePolicy) == null) {
            this.a.setFileSystemDelegatePolicy(v8FileSystemDelegatePolicy);
        }
    }

    public void F0(JsCodeCacheCallback jsCodeCacheCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsCodeCacheCallback) == null) {
            this.a.setJsCodeCacheCallback(jsCodeCacheCallback);
        }
    }

    public void G0(@NonNull V8Engine.JavaScriptExceptionDelegate javaScriptExceptionDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, javaScriptExceptionDelegate) == null) {
            this.a.setJavaScriptExceptionDelegate(javaScriptExceptionDelegate);
        }
    }

    @Override // com.baidu.tieba.hf2
    public boolean post(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, runnable)) == null) {
            runOnJSThread(runnable);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.hf2, com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048615, this, runnable) != null) || runnable == null) {
            return;
        }
        this.a.postOnJSThread(runnable);
    }

    public InspectorNativeClient r0(InspectorNativeChannel inspectorNativeChannel) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, inspectorNativeChannel)) == null) {
            return this.a.initInspector(inspectorNativeChannel);
        }
        return (InspectorNativeClient) invokeL.objValue;
    }

    @Override // com.baidu.tieba.hf2, com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048619, this, runnable) != null) || runnable == null) {
            return;
        }
        this.a.runOnJSThread(runnable);
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void runOnJSThreadDirectly(Runnable runnable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, runnable) != null) || runnable == null) {
            return;
        }
        this.a.runOnJSThreadDirectly(runnable);
    }

    @Override // com.baidu.tieba.hf2
    public void setPreferredFramesPerSecond(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048622, this, new Object[]{Short.valueOf(s)}) == null) {
            this.a.setPreferredFramesPerSecond(s);
        }
    }

    public void u(@NonNull V8Engine.V8EngineConsole v8EngineConsole) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, v8EngineConsole) == null) {
            this.a.addV8EngineConsole(v8EngineConsole);
        }
    }

    @Override // com.baidu.tieba.hf2
    public JsSerializeValue B(byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, bArr, z)) == null) {
            return this.a.deserialize(bArr, z);
        }
        return (JsSerializeValue) invokeLZ.objValue;
    }

    @Override // com.baidu.tieba.hf2
    public byte[] L(JsSerializeValue jsSerializeValue, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048588, this, jsSerializeValue, z)) == null) {
            return this.a.serialize(jsSerializeValue, z);
        }
        return (byte[]) invokeLZ.objValue;
    }

    @Override // com.baidu.tieba.hf2
    public void a0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            this.g.c(str, str2);
        }
    }

    @Override // com.baidu.tieba.v62
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, valueCallback) == null) {
            this.g.b(str, valueCallback);
        }
    }

    @Override // com.baidu.searchbox.v8engine.JSRuntime
    public void postOnJSThread(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLJ(1048616, this, runnable, j) != null) || runnable == null) {
            return;
        }
        this.a.postOnJSThread(runnable, j);
    }

    @Override // com.baidu.tieba.hf2
    public void throwJSException(JSExceptionType jSExceptionType, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, jSExceptionType, str) == null) {
            this.g.d(jSExceptionType, str);
        }
    }

    public void I0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (n) {
            Log.d("SwanAppV8Engine", "setUserAgent: " + str);
        }
        this.a.setUserAgent(str);
    }

    @Override // com.baidu.tieba.v62
    public void addJavascriptInterface(@NonNull Object obj, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, obj, str) == null) {
            if (n) {
                Log.d("SwanAppV8Engine", "addJavascriptInterface object: " + obj + " ,name: " + str);
            }
            this.g.a(obj, str);
        }
    }

    @Override // com.baidu.tieba.v62
    public void continueTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (kf2.class) {
                if (!isDestroyed()) {
                    x42.i("SwanAppV8Engine", "continueTimer: for=" + this);
                    onResume();
                }
            }
        }
    }

    @Override // com.baidu.tieba.v62
    public void suspendTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            synchronized (kf2.class) {
                if (!isDestroyed()) {
                    x42.i("SwanAppV8Engine", "suspendTimer: for=" + this);
                    onPause();
                }
            }
        }
    }

    @Override // com.baidu.tieba.hf2
    public boolean dispatchEvent(JSEvent jSEvent) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, jSEvent)) == null) {
            if (n) {
                StringBuilder sb = new StringBuilder();
                sb.append("dispatchEvent event: ");
                if (jSEvent != null) {
                    str = jSEvent.type;
                } else {
                    str = "";
                }
                sb.append(str);
                Log.d("SwanAppV8Engine", sb.toString());
            }
            if (this.d != null && JSEvent.isValid(jSEvent)) {
                runOnJSThread(new d(this, jSEvent));
                return true;
            } else if (n) {
                Log.e("SwanAppV8Engine", "dispatchEvent globalObject or event is invalid.");
                return false;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.unitedscheme.CallbackHandler
    public void handleSchemeDispatchCallback(String str, String str2) {
        String quote;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            if (t0()) {
                if (n) {
                    Log.e("SwanAppV8Engine", Log.getStackTraceString(new Exception("engine isFinishing.")));
                    return;
                }
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                quote = "";
            } else {
                quote = JSONObject.quote(str2);
            }
            evaluateJavascript(str + "(" + quote + ");", null);
            if (n) {
                Log.d("SwanAppV8Engine", "handleSchemeDispatchCallback callback " + str + " ,params: " + str2);
            }
        }
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            this.a.setMemSetMemoryEnable(true);
            A0();
            if (n) {
                Log.d("SwanAppV8Engine", "initEngine start.");
            }
            this.b.d(this);
            boolean a2 = p62.b.a();
            if (a2) {
                this.a.setCustomJsCodeCacheHandler(new a(this));
            }
            if (n) {
                Log.i("SwanAppV8Engine", "customCodeCache:" + a2 + ", limitSize=" + p62.b.b() + ", rank=" + p62.b.c());
            }
            this.a.startEngine();
            this.a.addStatusHandler(new b(this));
            if (n) {
                Log.d("SwanAppV8Engine", "initEngine end.");
            }
        }
    }
}
