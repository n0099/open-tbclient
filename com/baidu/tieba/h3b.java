package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.g3b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h3b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public static volatile h3b o;
    public transient /* synthetic */ FieldHolder $fh;
    public File a;
    public File b;
    public boolean c;
    public boolean d;
    public long e;
    public int f;
    public int g;
    public long h;
    public long i;
    public long j;
    public int k;
    public int l;
    public HashMap<String, g3b> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947774194, "Lcom/baidu/tieba/h3b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947774194, "Lcom/baidu/tieba/h3b;");
                return;
            }
        }
        n = AppConfig.isDebug();
    }

    public h3b() {
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
        n();
    }

    public static h3b f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (o == null) {
                synchronized (h3b.class) {
                    if (o == null) {
                        o = new h3b();
                    }
                }
            }
            return o;
        }
        return (h3b) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.k;
        }
        return invokeV.intValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.j;
        }
        return invokeV.longValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.h;
        }
        return invokeV.longValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (i > 0 && i <= i3b.k) {
                this.f = i;
            } else {
                this.f = i3b.k;
            }
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        g3b g3bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.c;
            }
            HashMap<String, g3b> hashMap = this.m;
            if (hashMap != null && (g3bVar = hashMap.get(str)) != null) {
                return g3bVar.e();
            }
            return this.c;
        }
        return invokeL.booleanValue;
    }

    public long b(String str) {
        InterceptResult invokeL;
        g3b g3bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.i;
            }
            HashMap<String, g3b> hashMap = this.m;
            if (hashMap != null && (g3bVar = hashMap.get(str)) != null) {
                return g3bVar.a();
            }
            return this.i;
        }
        return invokeL.longValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        g3b g3bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.l;
            }
            HashMap<String, g3b> hashMap = this.m;
            if (hashMap != null && (g3bVar = hashMap.get(str)) != null) {
                return g3bVar.b();
            }
            return this.l;
        }
        return invokeL.intValue;
    }

    public long d(String str) {
        InterceptResult invokeL;
        g3b g3bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.h;
            }
            HashMap<String, g3b> hashMap = this.m;
            if (hashMap != null && (g3bVar = hashMap.get(str)) != null) {
                return g3bVar.d();
            }
            return this.h;
        }
        return invokeL.longValue;
    }

    public int e(String str) {
        InterceptResult invokeL;
        g3b g3bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.g;
            }
            HashMap<String, g3b> hashMap = this.m;
            if (hashMap != null && (g3bVar = hashMap.get(str)) != null) {
                return g3bVar.c();
            }
            return this.g;
        }
        return invokeL.intValue;
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.d = z;
        }
    }

    public void t(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.c = z;
        }
    }

    public void u(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            if (j <= 0) {
                this.i = i3b.g;
            } else {
                this.i = j;
            }
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            if (i > 0 && i <= i3b.i) {
                this.k = i;
            } else {
                this.k = i3b.i;
            }
        }
    }

    public void w(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            if (j > 0 && j <= i3b.h) {
                this.j = j;
            } else {
                this.j = i3b.h;
            }
        }
    }

    public void x(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j) == null) {
            if (j > 0 && j <= DownloadManager.MIN_LEFT_SIZE) {
                this.h = j;
            } else {
                this.h = DownloadManager.MIN_LEFT_SIZE;
            }
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            if (i > 0 && i <= i3b.j) {
                this.g = i;
            } else {
                this.g = i3b.j;
            }
        }
    }

    public void z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            if (j <= 0) {
                this.e = i3b.e;
            } else {
                this.e = j;
            }
        }
    }

    public final boolean B(JSONObject jSONObject) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            if (jSONObject == null || jSONObject.length() == 0) {
                return false;
            }
            if (jSONObject.optInt("switch") != i3b.p) {
                t(i3b.a);
            } else {
                t(i3b.b);
            }
            if (jSONObject.optInt(DownloadStatisticConstants.UBC_VALUE_CLEAR) != i3b.q) {
                r(i3b.c);
            } else {
                r(i3b.d);
            }
            long j2 = 1000;
            z(jSONObject.optInt("upload_interval") * 60 * 1000);
            A(jSONObject.optInt("max_count_per_round"));
            u(jSONObject.optInt("expired_time") * 24 * 60 * 60 * 1000);
            v(jSONObject.optInt("total_max_count"));
            w(jSONObject.optInt("total_max_size") * 1024 * 1024);
            y(jSONObject.optInt("single_max_count"));
            x(jSONObject.optInt("single_max_size") * 1024 * 1024);
            JSONObject optJSONObject = jSONObject.optJSONObject("set");
            if (optJSONObject != null && optJSONObject.length() > 0) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                    if (optJSONObject2 != null && optJSONObject2.length() != 0) {
                        g3b g = new g3b.b(next).g();
                        if (optJSONObject2.optInt("switch") != i3b.p) {
                            g.f(i3b.a);
                        } else {
                            g.f(i3b.b);
                        }
                        int optInt = optJSONObject2.optInt("expired_time", 0);
                        if (optInt > 0) {
                            g.g(optInt * 24 * 60 * 60 * j2);
                        }
                        int optInt2 = optJSONObject2.optInt("single_max_count", 0);
                        if (optInt2 > 0) {
                            g.i(optInt2);
                        }
                        int optInt3 = optJSONObject2.optInt("single_max_size", 0);
                        if (optInt3 > 0) {
                            j = 1024;
                            g.j(optInt3 * 1024 * 1024);
                        } else {
                            j = 1024;
                        }
                        if (optJSONObject2.has("only_wifi")) {
                            g.h(optJSONObject2.optInt("only_wifi"));
                        }
                        if (!g.e() || g.a() != this.i || g.c() != this.g || g.d() != this.h || g.b() != this.l) {
                            if (this.m == null) {
                                this.m = new HashMap<>();
                            }
                            this.m.put(next, g);
                        }
                        j2 = 1000;
                    }
                }
                return true;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean C(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            if (jSONObject != null && jSONObject.length() != 0) {
                if (n) {
                    Log.d("VoyagerConfig", "update Config: " + jSONObject.toString());
                }
                if (B(jSONObject)) {
                    boolean D = D();
                    if (D && !this.c && this.d) {
                        ((w3b) ServiceManager.getService(w3b.a)).f();
                    }
                    return D;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean D() {
        InterceptResult invokeV;
        g3b g3bVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("en", this.c);
                jSONObject.put("c", this.d);
                jSONObject.put(TaskUIData.key, this.e);
                jSONObject.put("utc", this.f);
                jSONObject.put("et", this.i);
                jSONObject.put("mfc", this.k);
                jSONObject.put("mfs", this.j);
                jSONObject.put("an", this.l);
                jSONObject.put("stmc", this.g);
                jSONObject.put("stms", this.h);
                if (this.m != null && this.m.size() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str : this.m.keySet()) {
                        if (!TextUtils.isEmpty(str) && (g3bVar = this.m.get(str)) != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            if (g3bVar.e()) {
                                i = i3b.o;
                            } else {
                                i = i3b.p;
                            }
                            jSONObject3.put("en", i);
                            jSONObject3.put("et", g3bVar.a());
                            jSONObject3.put("stmc", g3bVar.c());
                            jSONObject3.put("stms", g3bVar.d());
                            jSONObject3.put("an", g3bVar.b());
                            jSONObject2.put(str, jSONObject3);
                        }
                    }
                    if (jSONObject2.length() > 0) {
                        jSONObject.put("set", jSONObject2);
                    }
                }
            } catch (JSONException e) {
                if (n) {
                    e.printStackTrace();
                }
            }
            if (!this.a.exists()) {
                try {
                    this.a.createNewFile();
                } catch (IOException e2) {
                    if (n) {
                        e2.printStackTrace();
                    }
                }
            }
            return z3b.g(jSONObject.toString(), this.a);
        }
        return invokeV.booleanValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            File file = new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, "/config/");
            this.b = file;
            if (!file.exists()) {
                this.b.mkdirs();
            }
            File file2 = new File(this.b, "voyager_config.txt");
            this.a = file2;
            if (file2.exists()) {
                q();
            } else {
                s();
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.c = i3b.a;
            this.d = i3b.c;
            this.e = i3b.e;
            this.f = i3b.f;
            this.i = i3b.g;
            this.k = i3b.i;
            this.j = i3b.h;
            this.g = i3b.j;
            this.h = i3b.l;
            this.l = i3b.m;
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            String f = z3b.f(this.a);
            if (n) {
                Log.d("VoyagerConfig", "read from local: " + f);
            }
            if (TextUtils.isEmpty(f)) {
                s();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(f);
                this.c = jSONObject.optBoolean("en", i3b.a);
                this.d = jSONObject.optBoolean("c", i3b.c);
                this.e = jSONObject.optLong(TaskUIData.key, i3b.e);
                this.f = jSONObject.optInt("utc", i3b.f);
                this.i = jSONObject.optLong("et", i3b.g);
                this.k = jSONObject.optInt("mfc", i3b.i);
                this.j = jSONObject.optLong("mfs", i3b.h);
                this.l = jSONObject.optInt("an", i3b.m);
                this.g = jSONObject.optInt("stmc", i3b.j);
                this.h = jSONObject.optLong("stms", i3b.l);
                JSONObject optJSONObject = jSONObject.optJSONObject("set");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                        if (optJSONObject2 != null && optJSONObject2.length() != 0) {
                            g3b g = new g3b.b(next).g();
                            if (optJSONObject2.optInt("en") != i3b.p) {
                                g.f(i3b.a);
                            } else {
                                g.f(i3b.b);
                            }
                            long optInt = optJSONObject2.optInt("et", 0);
                            if (optInt > 0) {
                                g.g(optInt);
                            } else {
                                g.g(this.i);
                            }
                            int optInt2 = optJSONObject2.optInt("stmc", 0);
                            if (optInt2 > 0) {
                                g.i(optInt2);
                            } else {
                                g.i(this.g);
                            }
                            long optLong = optJSONObject2.optLong("stms", 0L);
                            if (optLong > 0) {
                                g.j(optLong);
                            } else {
                                g.j(this.h);
                            }
                            if (optJSONObject2.optInt("an") != i3b.n) {
                                g.h(i3b.m);
                            } else {
                                g.h(i3b.n);
                            }
                            if (!g.e() || g.a() != this.i || g.c() != this.g || g.d() != this.h || g.b() != this.l) {
                                if (this.m == null) {
                                    this.m = new HashMap<>();
                                }
                                this.m.put(next, g);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (n) {
                    e.printStackTrace();
                }
            }
        }
    }
}
