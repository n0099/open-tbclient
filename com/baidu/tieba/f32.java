package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class f32 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile f32 b;
    public static vb3 c;
    public static Timer d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void h(String str);

    /* loaded from: classes5.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f32 a;

        public a(f32 f32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f32Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (f32.a) {
                    Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                }
                this.a.e();
                this.a.n();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends f32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // com.baidu.tieba.f32
        public void h(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (f32.a) {
                Log.d("RemoteDebugStatistic", "remote-debug statistic event name is : " + str);
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 50335962) {
                if (hashCode != 1109597094) {
                    if (hashCode == 1158237819 && str.equals("downloadsuccess")) {
                        c = 1;
                    }
                } else if (str.equals("downloadfail")) {
                    c = 2;
                }
            } else if (str.equals("downloadstart")) {
                c = 0;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        vb3 vb3Var = f32.c;
                        if (vb3Var != null) {
                            wb3.d(vb3Var, str, f());
                            return;
                        }
                        return;
                    }
                    e();
                    n();
                    return;
                }
                vb3 vb3Var2 = f32.c;
                if (vb3Var2 != null) {
                    wb3.b(vb3Var2);
                }
                n();
                return;
            }
            p(true);
            wb3.d(f32.c, str, f());
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends f32 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c() {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.baidu.tieba.f32
        public void h(String str) {
            SwanAppActivity w;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !TextUtils.isEmpty(str) && !g32.c()) {
                if (f32.a) {
                    Log.d("RemoteDebugStatistic", "remote-debug statistic event name is : " + str);
                }
                char c = 65535;
                int hashCode = str.hashCode();
                boolean z = true;
                if (hashCode != 511060680) {
                    if (hashCode == 900970612 && str.equals("pageready")) {
                        c = 1;
                    }
                } else if (str.equals("loadmaster")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c != 1) {
                        vb3 vb3Var = f32.c;
                        if (vb3Var != null) {
                            wb3.d(vb3Var, str, f());
                            return;
                        }
                        return;
                    }
                    vb3 vb3Var2 = f32.c;
                    if (vb3Var2 != null) {
                        wb3.d(vb3Var2, str, f());
                        e();
                        n();
                        return;
                    }
                    return;
                }
                if (p53.c0() != null && (w = p53.c0().w()) != null && !w.isFinishing()) {
                    z = false;
                }
                p(z);
                if (z) {
                    vb3 vb3Var3 = f32.c;
                    wb3.d(vb3Var3, str + "-destroy", f());
                    boolean unused = f32.e = false;
                } else if (f32.e) {
                    vb3 vb3Var4 = f32.c;
                    wb3.d(vb3Var4, str + "-preload", f());
                    boolean unused2 = f32.e = false;
                } else {
                    wb3.d(f32.c, str, f());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947713124, "Lcom/baidu/tieba/f32;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947713124, "Lcom/baidu/tieba/f32;");
                return;
            }
        }
        a = am1.a;
    }

    public f32() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            sc3 sc3Var = new sc3();
            sc3Var.a = "swan";
            sc3Var.b = "launch";
            sc3Var.c = "remote-debug";
            sc3Var.e = "appready";
            ic3.onEvent(sc3Var);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            sc3 sc3Var = new sc3();
            sc3Var.a = "swan";
            sc3Var.b = "launch";
            sc3Var.c = "remote-debug";
            sc3Var.e = "loadmaster";
            ic3.onEvent(sc3Var);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            sc3 sc3Var = new sc3();
            sc3Var.a = "swan";
            sc3Var.b = "launch";
            sc3Var.c = "remote-debug";
            sc3Var.e = "downloadstart";
            ic3.onEvent(sc3Var);
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Timer timer = d;
            if (timer != null) {
                timer.cancel();
                d = null;
            }
            b = null;
            c = null;
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            e = true;
        }
    }

    public /* synthetic */ f32(a aVar) {
        this();
    }

    public static f32 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (b == null) {
                synchronized (cr2.class) {
                    if (b == null) {
                        if (ze1.g()) {
                            b = new b(null);
                        } else {
                            b = new c(null);
                        }
                    }
                }
            }
            return b;
        }
        return (f32) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
            } catch (JSONException e2) {
                if (a) {
                    Log.d("RemoteDebugStatistic", "add event content fail", e2);
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public static void i(JSONArray jSONArray) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, jSONArray) == null) && jSONArray != null && jSONArray.length() > 0) {
            JSONObject optJSONObject = jSONArray.optJSONObject(0);
            if (optJSONObject != null) {
                str = optJSONObject.optString("actionId");
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str) && b != null) {
                b.h(str);
            }
        }
    }

    public static void m(nq2 nq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, nq2Var) == null) {
            sc3 sc3Var = new sc3();
            sc3Var.j(nq2Var);
            sc3Var.a = ic3.n(nq2Var.H());
            sc3Var.b = "launch";
            sc3Var.c = "remote-debug";
            sc3Var.e = "downloadsuccess";
            ic3.onEvent(sc3Var);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || c != null) {
            return;
        }
        vb3 c2 = ic3.c("1153");
        c = c2;
        if (!z) {
            wb3.d(c2, "downloadstart", f());
            wb3.d(c, "downloadsuccess", f());
        }
        Timer timer = new Timer();
        d = timer;
        timer.schedule(new a(this), 40000L);
    }

    public static void j(nq2 nq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, nq2Var) == null) {
            nq2Var.t0().putString("aiapp_extra_need_download", "1");
            nq2Var.t0().putString("aiapp_extra_pkg_downloading", "0");
            nq2Var.t0().putLong("launch_flag_for_statistic", System.currentTimeMillis());
            sc3 sc3Var = new sc3();
            sc3Var.a = ic3.n(nq2Var.H());
            sc3Var.j(nq2Var);
            sc3Var.b = "launch";
            sc3Var.o = "1";
            sc3Var.c = "remote-debug";
            JSONObject k = ic3.k(nq2Var.X());
            sc3Var.d(nq2Var.t0().getString("ubc"));
            sc3Var.b(k);
            ic3.onEvent(sc3Var);
        }
    }

    public void e() {
        String P;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || c == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            p53 c0 = p53.c0();
            if (c0 == null) {
                P = "";
            } else {
                P = c0.P();
            }
            jSONObject2.putOpt("appid", P);
            jSONObject2.putOpt("from", "remote-debug");
            hc3.a(jSONObject2);
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            if (a) {
                Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
            }
        }
        wb3.f(c, jSONObject.toString());
        wb3.c(c);
    }
}
