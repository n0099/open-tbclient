package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.ui.TaskUIData;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.hkb;
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
public class ikb {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public static volatile ikb o;
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
    public HashMap<String, hkb> m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947857801, "Lcom/baidu/tieba/ikb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947857801, "Lcom/baidu/tieba/ikb;");
                return;
            }
        }
        n = AppConfig.isDebug();
    }

    public ikb() {
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

    public static ikb f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (o == null) {
                synchronized (ikb.class) {
                    if (o == null) {
                        o = new ikb();
                    }
                }
            }
            return o;
        }
        return (ikb) invokeV.objValue;
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
            if (i > 0 && i <= jkb.k) {
                this.f = i;
            } else {
                this.f = jkb.k;
            }
        }
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        hkb hkbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.c;
            }
            HashMap<String, hkb> hashMap = this.m;
            if (hashMap != null && (hkbVar = hashMap.get(str)) != null) {
                return hkbVar.e();
            }
            return this.c;
        }
        return invokeL.booleanValue;
    }

    public long b(String str) {
        InterceptResult invokeL;
        hkb hkbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.i;
            }
            HashMap<String, hkb> hashMap = this.m;
            if (hashMap != null && (hkbVar = hashMap.get(str)) != null) {
                return hkbVar.a();
            }
            return this.i;
        }
        return invokeL.longValue;
    }

    public int c(String str) {
        InterceptResult invokeL;
        hkb hkbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.l;
            }
            HashMap<String, hkb> hashMap = this.m;
            if (hashMap != null && (hkbVar = hashMap.get(str)) != null) {
                return hkbVar.b();
            }
            return this.l;
        }
        return invokeL.intValue;
    }

    public long d(String str) {
        InterceptResult invokeL;
        hkb hkbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.h;
            }
            HashMap<String, hkb> hashMap = this.m;
            if (hashMap != null && (hkbVar = hashMap.get(str)) != null) {
                return hkbVar.d();
            }
            return this.h;
        }
        return invokeL.longValue;
    }

    public int e(String str) {
        InterceptResult invokeL;
        hkb hkbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return this.g;
            }
            HashMap<String, hkb> hashMap = this.m;
            if (hashMap != null && (hkbVar = hashMap.get(str)) != null) {
                return hkbVar.c();
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
                this.i = jkb.g;
            } else {
                this.i = j;
            }
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            if (i > 0 && i <= jkb.i) {
                this.k = i;
            } else {
                this.k = jkb.i;
            }
        }
    }

    public void w(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            if (j > 0 && j <= jkb.h) {
                this.j = j;
            } else {
                this.j = jkb.h;
            }
        }
    }

    public void x(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j) == null) {
            if (j > 0 && j <= 20971520) {
                this.h = j;
            } else {
                this.h = 20971520L;
            }
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            if (i > 0 && i <= jkb.j) {
                this.g = i;
            } else {
                this.g = jkb.j;
            }
        }
    }

    public void z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            if (j <= 0) {
                this.e = jkb.e;
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
            if (jSONObject.optInt("switch") != jkb.p) {
                t(jkb.a);
            } else {
                t(jkb.b);
            }
            if (jSONObject.optInt(DownloadStatisticConstants.UBC_VALUE_CLEAR) != jkb.q) {
                r(jkb.c);
            } else {
                r(jkb.d);
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
                        hkb g = new hkb.b(next).g();
                        if (optJSONObject2.optInt("switch") != jkb.p) {
                            g.f(jkb.a);
                        } else {
                            g.f(jkb.b);
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
                        ((xkb) ServiceManager.getService(xkb.a)).f();
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
        hkb hkbVar;
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
                        if (!TextUtils.isEmpty(str) && (hkbVar = this.m.get(str)) != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            if (hkbVar.e()) {
                                i = jkb.o;
                            } else {
                                i = jkb.p;
                            }
                            jSONObject3.put("en", i);
                            jSONObject3.put("et", hkbVar.a());
                            jSONObject3.put("stmc", hkbVar.c());
                            jSONObject3.put("stms", hkbVar.d());
                            jSONObject3.put("an", hkbVar.b());
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
            return alb.g(jSONObject.toString(), this.a);
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
            this.c = jkb.a;
            this.d = jkb.c;
            this.e = jkb.e;
            this.f = jkb.f;
            this.i = jkb.g;
            this.k = jkb.i;
            this.j = jkb.h;
            this.g = jkb.j;
            this.h = jkb.l;
            this.l = jkb.m;
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            String f = alb.f(this.a);
            if (n) {
                Log.d("VoyagerConfig", "read from local: " + f);
            }
            if (TextUtils.isEmpty(f)) {
                s();
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(f);
                this.c = jSONObject.optBoolean("en", jkb.a);
                this.d = jSONObject.optBoolean("c", jkb.c);
                this.e = jSONObject.optLong(TaskUIData.key, jkb.e);
                this.f = jSONObject.optInt("utc", jkb.f);
                this.i = jSONObject.optLong("et", jkb.g);
                this.k = jSONObject.optInt("mfc", jkb.i);
                this.j = jSONObject.optLong("mfs", jkb.h);
                this.l = jSONObject.optInt("an", jkb.m);
                this.g = jSONObject.optInt("stmc", jkb.j);
                this.h = jSONObject.optLong("stms", jkb.l);
                JSONObject optJSONObject = jSONObject.optJSONObject("set");
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject(next);
                        if (optJSONObject2 != null && optJSONObject2.length() != 0) {
                            hkb g = new hkb.b(next).g();
                            if (optJSONObject2.optInt("en") != jkb.p) {
                                g.f(jkb.a);
                            } else {
                                g.f(jkb.b);
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
                            if (optJSONObject2.optInt("an") != jkb.n) {
                                g.h(jkb.m);
                            } else {
                                g.h(jkb.n);
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
