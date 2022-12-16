package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.jx2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c13 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements ga2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ d13 b;
        public final /* synthetic */ Bundle c;

        public a(Context context, d13 d13Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, d13Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = d13Var;
            this.c = bundle;
        }

        @Override // com.baidu.tieba.ga2
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c13.a) {
                Log.d("SwanAppPreloadHelper", "SwanSailor：updateFail");
            }
        }

        @Override // com.baidu.tieba.ga2
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (c13.a) {
                    Log.d("SwanAppPreloadHelper", "SwanSailor updateSuccess");
                }
                c13.i(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements g32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ d13 b;
        public final /* synthetic */ Bundle c;

        public b(Context context, d13 d13Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, d13Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = d13Var;
            this.c = bundle;
        }

        @Override // com.baidu.tieba.g32
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            boolean unused = c13.c = true;
            c13.h(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements xi3<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ d13 b;
        public final /* synthetic */ Bundle c;

        public c(Context context, d13 d13Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, d13Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = d13Var;
            this.c = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                c13.g(this.a, this.b, this.c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947621860, "Lcom/baidu/tieba/c13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947621860, "Lcom/baidu/tieba/c13;");
                return;
            }
        }
        a = ok1.a;
        c = false;
    }

    public static void h(Context context, d13 d13Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, d13Var, bundle) == null) {
            SwanLauncher.j().l(new c(context, d13Var, bundle));
        }
    }

    public static void j(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, bundle) == null) {
            bundle.putBoolean("bundle_key_v8_ab", ln2.g0().x());
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("master", ya2.U().k0());
                jSONObject.put("slave", ya2.U().n0());
            } catch (JSONException e) {
                if (a) {
                    throw new RuntimeException(e);
                }
            }
            String jSONObject2 = jSONObject.toString();
            if (a) {
                Log.d("SwanAppPreloadHelper", "createPreloadStatus -- preloadStatus : " + jSONObject2);
            }
            if (TextUtils.isEmpty(jSONObject2)) {
                return "";
            }
            return jSONObject2;
        }
        return (String) invokeV.objValue;
    }

    public static void g(Context context, d13 d13Var, Bundle bundle) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, d13Var, bundle) == null) {
            if (ln2.g0() != null) {
                z = ln2.g0().t();
            } else {
                z = false;
            }
            boolean isMainProcess = ProcessUtils.isMainProcess();
            if (isMainProcess) {
                str = "main";
            } else {
                str = "aiapp";
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (z) {
                if (isMainProcess && TextUtils.isEmpty(b)) {
                    try {
                        b = new WebView(context).getSettings().getUserAgentString();
                    } catch (Exception e) {
                        b = "exception::" + e.toString();
                        if (a) {
                            e.printStackTrace();
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", currentTimeMillis);
                    jSONObject.put("process", d13Var.b.index);
                    jSONObject.put("ua", b);
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
                jx2.d dVar = new jx2.d("812");
                dVar.g("swan");
                dVar.i("launch");
                dVar.h(str);
                dVar.e(jSONObject);
                jx2.onEvent(dVar);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (z) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("time", currentTimeMillis2);
                    jSONObject2.put("process", d13Var.b.index);
                    jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
                } catch (JSONException e3) {
                    if (a) {
                        e3.printStackTrace();
                    }
                }
                jx2.d dVar2 = new jx2.d("812");
                dVar2.g("swan");
                dVar2.i("swan_updated");
                dVar2.h(str);
                dVar2.e(jSONObject2);
                jx2.onEvent(dVar2);
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (jd3.j()) {
                ld3.e();
            }
            bundle.putParcelable("bundle_key_swan_core", jd3.e(0));
            bundle.putParcelable("bundle_key_extension_core", ne2.c(0));
            bundle.putInt("bundle_key_preload_switch", ln2.g().a());
            bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
            bundle.putBoolean("bundle_key_v8_ab", ln2.g0().x());
            bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
            bundle.putString("bundle_key_preload_src", str);
            bundle.putInt("bundle_key_process", d13Var.b.index);
            bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
            d13Var.n0(context, bundle);
        }
    }

    public static void i(Context context, d13 d13Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, d13Var, bundle) == null) {
            if (ia2.a()) {
                h(context, d13Var, bundle);
            } else if (c) {
                h(context, d13Var, bundle);
            } else {
                uq1.a().b().a().b(new b(context, d13Var, bundle));
            }
        }
    }

    public static void k(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, context, bundle) == null) {
            Intent intent = new Intent(context, SwanAppMessengerService.class);
            intent.setAction(SwanAppMessengerService.ACTION_PRELOAD_NEXT);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            try {
                context.startService(intent);
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void l(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, context, bundle) == null) {
            m(context, f13.k().f(), bundle);
        }
    }

    public static void n(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, bundle) == null) {
            ao1 g0 = ln2.g0();
            if (!d03.Y()) {
                g0.getSwitch("swan_preload_keep_alive", true);
            }
            l(context, bundle);
        }
    }

    public static void m(Context context, d13 d13Var, Bundle bundle) {
        String string;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, context, d13Var, bundle) == null) {
            if (a) {
                f13 k = f13.k();
                k.u("b4 tryPreload client=" + d13Var);
            }
            if (ProcessUtils.isMainProcess() && d13Var != null && d13Var.b.isSwanAppProcess() && !d13Var.E()) {
                if (bundle == null) {
                    string = "";
                } else {
                    string = bundle.getString("bundle_key_preload_preload_scene");
                }
                if (TextUtils.isEmpty(string)) {
                    string = "0";
                }
                if (a) {
                    Log.d("SwanAppPreloadHelper", "SwanSailor：preloadScene:" + string);
                }
                if (ln2.w0().c()) {
                    i(context, d13Var, bundle);
                    return;
                }
                ia2 ia2Var = new ia2();
                if (TextUtils.equals(string, "0")) {
                    str = "by_host_launch";
                } else {
                    str = "by_preload";
                }
                ia2Var.a = str;
                ln2.w0().b(ia2Var, new a(context, d13Var, bundle));
            }
        }
    }
}
