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
import com.baidu.tieba.pz2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class i33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public static boolean c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements mc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ j33 b;
        public final /* synthetic */ Bundle c;

        public a(Context context, j33 j33Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, j33Var, bundle};
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
            this.b = j33Var;
            this.c = bundle;
        }

        @Override // com.baidu.tieba.mc2
        public void onFail() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && i33.a) {
                Log.d("SwanAppPreloadHelper", "SwanSailor：updateFail");
            }
        }

        @Override // com.baidu.tieba.mc2
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (i33.a) {
                    Log.d("SwanAppPreloadHelper", "SwanSailor updateSuccess");
                }
                i33.i(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements m52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ j33 b;
        public final /* synthetic */ Bundle c;

        public b(Context context, j33 j33Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, j33Var, bundle};
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
            this.b = j33Var;
            this.c = bundle;
        }

        @Override // com.baidu.tieba.m52
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            boolean unused = i33.c = true;
            i33.h(this.a, this.b, this.c);
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements dl3<Exception> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ j33 b;
        public final /* synthetic */ Bundle c;

        public c(Context context, j33 j33Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, j33Var, bundle};
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
            this.b = j33Var;
            this.c = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dl3
        /* renamed from: b */
        public void a(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                i33.g(this.a, this.b, this.c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947802528, "Lcom/baidu/tieba/i33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947802528, "Lcom/baidu/tieba/i33;");
                return;
            }
        }
        a = vm1.a;
        c = false;
    }

    public static void h(Context context, j33 j33Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, j33Var, bundle) == null) {
            SwanLauncher.j().l(new c(context, j33Var, bundle));
        }
    }

    public static void j(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, bundle) == null) {
            bundle.putBoolean("bundle_key_v8_ab", rp2.g0().x());
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("master", ed2.V().l0());
                jSONObject.put("slave", ed2.V().o0());
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

    public static void g(Context context, j33 j33Var, Bundle bundle) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, context, j33Var, bundle) == null) {
            if (rp2.g0() != null) {
                z = rp2.g0().t();
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
                    jSONObject.put("process", j33Var.b.index);
                    jSONObject.put("ua", b);
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
                pz2.d dVar = new pz2.d("812");
                dVar.g("swan");
                dVar.i("launch");
                dVar.h(str);
                dVar.e(jSONObject);
                pz2.onEvent(dVar);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (z) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("time", currentTimeMillis2);
                    jSONObject2.put("process", j33Var.b.index);
                    jSONObject2.put("cost", currentTimeMillis2 - currentTimeMillis);
                } catch (JSONException e3) {
                    if (a) {
                        e3.printStackTrace();
                    }
                }
                pz2.d dVar2 = new pz2.d("812");
                dVar2.g("swan");
                dVar2.i("swan_updated");
                dVar2.h(str);
                dVar2.e(jSONObject2);
                pz2.onEvent(dVar2);
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (pf3.j()) {
                rf3.e();
            }
            bundle.putParcelable("bundle_key_swan_core", pf3.e(0));
            bundle.putParcelable("bundle_key_extension_core", tg2.c(0));
            bundle.putInt("bundle_key_preload_switch", rp2.g().a());
            bundle.putLong("bundle_key_preload_launch_time", currentTimeMillis);
            bundle.putBoolean("bundle_key_v8_ab", rp2.g0().x());
            bundle.putLong("bundle_key_preload_swan_updated_time", currentTimeMillis2);
            bundle.putString("bundle_key_preload_src", str);
            bundle.putInt("bundle_key_process", j33Var.b.index);
            bundle.setClassLoader(SwanCoreVersion.class.getClassLoader());
            j33Var.n0(context, bundle);
        }
    }

    public static void i(Context context, j33 j33Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, j33Var, bundle) == null) {
            if (oc2.a()) {
                h(context, j33Var, bundle);
            } else if (c) {
                h(context, j33Var, bundle);
            } else {
                bt1.a().b().a().b(new b(context, j33Var, bundle));
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
            m(context, l33.k().f(), bundle);
        }
    }

    public static void n(Context context, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, bundle) == null) {
            hq1 g0 = rp2.g0();
            if (!j23.Y()) {
                g0.getSwitch("swan_preload_keep_alive", true);
            }
            l(context, bundle);
        }
    }

    public static void m(Context context, j33 j33Var, Bundle bundle) {
        String string;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65549, null, context, j33Var, bundle) == null) {
            if (a) {
                l33 k = l33.k();
                k.u("b4 tryPreload client=" + j33Var);
            }
            if (ProcessUtils.isMainProcess() && j33Var != null && j33Var.b.isSwanAppProcess() && !j33Var.E()) {
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
                if (rp2.w0().c()) {
                    i(context, j33Var, bundle);
                    return;
                }
                oc2 oc2Var = new oc2();
                if (TextUtils.equals(string, "0")) {
                    str = "by_host_launch";
                } else {
                    str = "by_preload";
                }
                oc2Var.a = str;
                rp2.w0().b(oc2Var, new a(context, j33Var, bundle));
            }
        }
    }
}
