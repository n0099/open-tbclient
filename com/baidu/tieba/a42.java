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
public abstract class a42 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile a42 b;
    public static qc3 c;
    public static Timer d;
    public static boolean e;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void h(String str);

    /* loaded from: classes5.dex */
    public class a extends TimerTask {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a42 a;

        public a(a42 a42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a42Var;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (a42.a) {
                    Log.d("RemoteDebugStatistic", "timer: send remote debug ubc flow");
                }
                this.a.e();
                this.a.n();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends a42 {
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

        @Override // com.baidu.tieba.a42
        public void h(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, str) != null) || TextUtils.isEmpty(str)) {
                return;
            }
            if (a42.a) {
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
                        qc3 qc3Var = a42.c;
                        if (qc3Var != null) {
                            rc3.d(qc3Var, str, f());
                            return;
                        }
                        return;
                    }
                    e();
                    n();
                    return;
                }
                qc3 qc3Var2 = a42.c;
                if (qc3Var2 != null) {
                    rc3.b(qc3Var2);
                }
                n();
                return;
            }
            p(true);
            rc3.d(a42.c, str, f());
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends a42 {
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

        @Override // com.baidu.tieba.a42
        public void h(String str) {
            SwanAppActivity w;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !TextUtils.isEmpty(str) && !b42.c()) {
                if (a42.a) {
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
                        qc3 qc3Var = a42.c;
                        if (qc3Var != null) {
                            rc3.d(qc3Var, str, f());
                            return;
                        }
                        return;
                    }
                    qc3 qc3Var2 = a42.c;
                    if (qc3Var2 != null) {
                        rc3.d(qc3Var2, str, f());
                        e();
                        n();
                        return;
                    }
                    return;
                }
                if (k63.c0() != null && (w = k63.c0().w()) != null && !w.isFinishing()) {
                    z = false;
                }
                p(z);
                if (z) {
                    qc3 qc3Var3 = a42.c;
                    rc3.d(qc3Var3, str + "-destroy", f());
                    boolean unused = a42.e = false;
                } else if (a42.e) {
                    qc3 qc3Var4 = a42.c;
                    rc3.d(qc3Var4, str + "-preload", f());
                    boolean unused2 = a42.e = false;
                } else {
                    rc3.d(a42.c, str, f());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947565130, "Lcom/baidu/tieba/a42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947565130, "Lcom/baidu/tieba/a42;");
                return;
            }
        }
        a = vm1.a;
    }

    public a42() {
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
            nd3 nd3Var = new nd3();
            nd3Var.a = "swan";
            nd3Var.b = "launch";
            nd3Var.c = "remote-debug";
            nd3Var.e = "appready";
            dd3.onEvent(nd3Var);
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            nd3 nd3Var = new nd3();
            nd3Var.a = "swan";
            nd3Var.b = "launch";
            nd3Var.c = "remote-debug";
            nd3Var.e = "loadmaster";
            dd3.onEvent(nd3Var);
        }
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            nd3 nd3Var = new nd3();
            nd3Var.a = "swan";
            nd3Var.b = "launch";
            nd3Var.c = "remote-debug";
            nd3Var.e = "downloadstart";
            dd3.onEvent(nd3Var);
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

    public /* synthetic */ a42(a aVar) {
        this();
    }

    public static a42 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (b == null) {
                synchronized (xr2.class) {
                    if (b == null) {
                        if (uf1.g()) {
                            b = new b(null);
                        } else {
                            b = new c(null);
                        }
                    }
                }
            }
            return b;
        }
        return (a42) invokeV.objValue;
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

    public static void m(ir2 ir2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, ir2Var) == null) {
            nd3 nd3Var = new nd3();
            nd3Var.j(ir2Var);
            nd3Var.a = dd3.n(ir2Var.H());
            nd3Var.b = "launch";
            nd3Var.c = "remote-debug";
            nd3Var.e = "downloadsuccess";
            dd3.onEvent(nd3Var);
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048581, this, z) != null) || c != null) {
            return;
        }
        qc3 c2 = dd3.c("1153");
        c = c2;
        if (!z) {
            rc3.d(c2, "downloadstart", f());
            rc3.d(c, "downloadsuccess", f());
        }
        Timer timer = new Timer();
        d = timer;
        timer.schedule(new a(this), 40000L);
    }

    public static void j(ir2 ir2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, ir2Var) == null) {
            ir2Var.t0().putString("aiapp_extra_need_download", "1");
            ir2Var.t0().putString("aiapp_extra_pkg_downloading", "0");
            ir2Var.t0().putLong("launch_flag_for_statistic", System.currentTimeMillis());
            nd3 nd3Var = new nd3();
            nd3Var.a = dd3.n(ir2Var.H());
            nd3Var.j(ir2Var);
            nd3Var.b = "launch";
            nd3Var.o = "1";
            nd3Var.c = "remote-debug";
            JSONObject k = dd3.k(ir2Var.X());
            nd3Var.d(ir2Var.t0().getString("ubc"));
            nd3Var.b(k);
            dd3.onEvent(nd3Var);
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
            k63 c0 = k63.c0();
            if (c0 == null) {
                P = "";
            } else {
                P = c0.P();
            }
            jSONObject2.putOpt("appid", P);
            jSONObject2.putOpt("from", "remote-debug");
            cd3.a(jSONObject2);
            jSONObject.putOpt("from", "swan");
            jSONObject.putOpt("ext", jSONObject2);
        } catch (JSONException unused) {
            if (a) {
                Log.d("RemoteDebugStatistic", "page ready statistic value is invalid ");
            }
        }
        rc3.f(c, jSONObject.toString());
        rc3.c(c);
    }
}
