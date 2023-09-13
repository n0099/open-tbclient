package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d80 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public static volatile d80 d;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;
    public final Handler b;

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b a;
        public final /* synthetic */ d80 b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.c = System.currentTimeMillis();
                    c cVar = this.a;
                    cVar.b.e(cVar.a);
                }
            }
        }

        public c(d80 d80Var, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d80Var, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d80Var;
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a.f) {
                    if (d80.c) {
                        Log.d("KeyeventStatManager", "SessionKeyevent do not have keyevent. do not upload!");
                        return;
                    }
                    return;
                }
                ExecutorUtilsExt.postOnElastic(new a(this), "uploadKeyevent", 2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Comparator<b80> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(d80 d80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b80 b80Var, b80 b80Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, b80Var, b80Var2)) == null) {
                return (int) (b80Var.c - b80Var2.c);
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public long b;
        public long c;
        public String d;
        public List<b80> e;
        public boolean f;
        public long g;

        public b() {
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

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947658285, "Lcom/baidu/tieba/d80;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947658285, "Lcom/baidu/tieba/d80;");
                return;
            }
        }
        c = AppConfig.isDebug();
        d = null;
    }

    public d80() {
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
        this.b = new Handler(Looper.getMainLooper());
    }

    public static d80 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (d == null) {
                synchronized (a80.class) {
                    if (d == null) {
                        d = new d80();
                    }
                }
            }
            return d;
        }
        return (d80) invokeV.objValue;
    }

    public void d(b80 b80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, b80Var) == null) {
            if (c) {
                Log.d("KeyeventStatManager", "reportKeyEvent event:" + b80Var);
            }
            if (this.a == null) {
                b bVar = new b(null);
                this.a = bVar;
                bVar.a = h80.a().getSessionId();
                this.a.d = h80.a().getProcessName();
                b bVar2 = this.a;
                bVar2.b = b80Var.c;
                bVar2.e = new ArrayList(10);
            }
            if (b80Var.f) {
                this.a.f = true;
            }
            this.a.e.add(b80Var);
            if (this.a.e.size() >= c80.c()) {
                if (b80Var.e) {
                    this.b.postDelayed(new c(this, this.a), c80.b());
                } else if (this.a.g <= System.currentTimeMillis()) {
                    new c(this, this.a).run();
                } else {
                    this.b.postDelayed(new c(this, this.a), System.currentTimeMillis() - this.a.g);
                }
                this.a = null;
                if (c) {
                    Log.d("KeyeventStatManager", "reportKeyEvent hit max event:" + c80.c());
                }
            } else if (b80Var.e) {
                this.a.g = System.currentTimeMillis() + c80.b();
            }
        }
    }

    public final void e(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            if (uBCManager == null) {
                Log.e("KeyeventStatManager", "ubc manager is null!");
            } else if (bVar != null && bVar.e.size() != 0) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("session_id", bVar.a);
                    jSONObject.put("start_time", String.valueOf(bVar.b));
                    jSONObject.put("end_time", String.valueOf(bVar.c));
                    jSONObject.put("process", bVar.d);
                    jSONObject.put("app_launch_time", String.valueOf(h80.a().a()));
                    JSONArray jSONArray = new JSONArray();
                    Collections.sort(bVar.e, new a(this));
                    for (b80 b80Var : bVar.e) {
                        jSONArray.put(b80Var.a());
                    }
                    jSONObject.put("events", jSONArray);
                    uBCManager.onEvent("5824", jSONObject);
                    if (c) {
                        Log.d("KeyeventStatManager", jSONObject.toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("KeyeventStatManager", "SessionKeyevent is null");
            }
        }
    }
}
