package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.poly.util.HttpSigner;
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
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bd1 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static List<yc1> i;
    public static Object j;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                bd1.d();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends sb1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub1 a;
        public final /* synthetic */ tb1 b;

        @Override // com.baidu.tieba.sb1
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
            }
        }

        public b(ub1 ub1Var, tb1 tb1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub1Var, tb1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub1Var;
            this.b = tb1Var;
        }

        @Override // com.baidu.tieba.sb1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                bd1.l(this.a.b(), this.b.b());
                ad1.g().h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends sb1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ JSONArray b;

        public c(JSONObject jSONObject, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject;
            this.b = jSONArray;
        }

        @Override // com.baidu.tieba.sb1
        public void a(Throwable th, int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, th, i, str) == null) {
                this.b.put(this.a);
                kd1.g("localObject" + this.a);
            }
        }

        @Override // com.baidu.tieba.sb1
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
                kd1.g("localObject success" + this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947641018, "Lcom/baidu/tieba/bd1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947641018, "Lcom/baidu/tieba/bd1;");
                return;
            }
        }
        j = new Object();
    }

    public static void c() {
        List<yc1> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && (list = i) != null) {
            list.clear();
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            cd1.a(new a());
        }
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            a = null;
            b = null;
            e = null;
            f = null;
            g = null;
            h = null;
        }
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (bd1.class) {
                List<yc1> list = i;
                if (list != null && !list.isEmpty()) {
                    tb1 g2 = g();
                    synchronized (j) {
                        JSONArray jSONArray = new JSONArray();
                        for (yc1 yc1Var : i) {
                            JSONObject d2 = yc1Var.d();
                            if (d2 != null) {
                                jSONArray.put(d2);
                            }
                        }
                        g2.d("data", jSONArray.toString());
                        g2.d("s", HttpSigner.a(g2, "key", zb1.a()));
                        c();
                    }
                    ub1 h2 = h();
                    if (md1.d()) {
                        n();
                        new zc1().a(h2, g2, new b(h2, g2));
                    } else {
                        l(h2.b(), g2.b());
                        ad1.g().h();
                    }
                }
            }
        }
    }

    public static tb1 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            tb1 tb1Var = new tb1();
            tb1Var.d(com.kuaishou.weapon.p0.t.v, "cashier");
            tb1Var.d("os", "android");
            tb1Var.d("v", "2.8.7.9");
            if (!TextUtils.isEmpty(g)) {
                tb1Var.d("n", g);
            }
            String b2 = bc1.b();
            if (!TextUtils.isEmpty(b2)) {
                tb1Var.d("nv", b2);
            }
            if (!TextUtils.isEmpty(h)) {
                tb1Var.d("ss", h);
            }
            if (!TextUtils.isEmpty(b)) {
                tb1Var.d("d", b);
            }
            if (!TextUtils.isEmpty(e)) {
                tb1Var.d("dt", e);
            }
            if (!TextUtils.isEmpty(f)) {
                tb1Var.d(com.kuaishou.weapon.p0.t.q, f);
            }
            if (!TextUtils.isEmpty(c)) {
                tb1Var.d("ak", c);
            }
            if (!TextUtils.isEmpty(d)) {
                tb1Var.d(Config.DEVICE_ID_SEC, d);
            }
            return tb1Var;
        }
        return (tb1) invokeV.objValue;
    }

    public static void e(yc1 yc1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, yc1Var) == null) {
            if (i == null) {
                i = new ArrayList();
            }
            if (yc1Var != null) {
                synchronized (j) {
                    i.add(yc1Var);
                }
            }
        }
    }

    public static ub1 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            ub1 ub1Var = new ub1();
            if (!TextUtils.isEmpty(a)) {
                ub1Var.d("Cookie", "BDUSS=" + a);
            }
            return ub1Var;
        }
        return (ub1) invokeV.objValue;
    }

    public static JSONArray i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            File file = new File(od1.a().getFilesDir(), "poly_cashier_statistics.json");
            if (!file.exists()) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(id1.b(file));
                try {
                    file.delete();
                } catch (Exception unused) {
                }
                return jSONArray;
            } catch (Exception unused2) {
                return null;
            }
        }
        return (JSONArray) invokeV.objValue;
    }

    public static void j(int i2, String str, String str2) {
        yc1 yc1Var;
        yc1 yc1Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65546, null, i2, str, str2) == null) {
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        yc1Var = null;
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("exceptionType", str2);
                            jSONObject.put("msg", str);
                        } catch (JSONException unused) {
                        }
                        yc1Var2 = new yc1("3");
                        yc1Var2.c(jSONObject);
                    }
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("selects", wc1.a);
                        wc1.a = 0;
                        jSONObject2.put("hbit", wc1.b);
                        wc1.b = "0";
                    } catch (JSONException unused2) {
                    }
                    yc1Var2 = new yc1("4");
                    yc1Var2.c(jSONObject2);
                }
                yc1Var = yc1Var2;
            } else {
                yc1Var = new yc1("2");
            }
            if (yc1Var != null) {
                e(yc1Var);
            }
        }
    }

    public static void l(Map map, Map map2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, map, map2) == null) {
            try {
                JSONArray i2 = i();
                if (i2 != null) {
                    if (i2.length() >= 20) {
                        i2.remove(0);
                    }
                } else {
                    i2 = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                JSONObject b2 = ld1.b(map);
                JSONObject b3 = ld1.b(map2);
                jSONObject.put("header", b2);
                jSONObject.put("body", b3);
                i2.put(jSONObject);
                m(i2);
            } catch (Exception unused) {
            }
        }
    }

    public static void m(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, jSONArray) == null) && jSONArray != null && jSONArray.length() != 0) {
            kd1.g("localArray" + jSONArray.length() + jSONArray.toString());
            id1.d(jSONArray.toString(), new File(od1.a().getFilesDir(), "poly_cashier_statistics.json"));
        }
    }

    public static boolean n() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            JSONArray i2 = i();
            if (i2 == null || i2.length() == 0) {
                return true;
            }
            try {
                jSONArray = new JSONArray();
                for (int i3 = 0; i3 < i2.length(); i3++) {
                    JSONObject jSONObject = i2.getJSONObject(i3);
                    ub1 ub1Var = new ub1();
                    ub1Var.e(ld1.d(jSONObject.optJSONObject("header")));
                    tb1 tb1Var = new tb1();
                    tb1Var.e(ld1.d(jSONObject.optJSONObject("body")));
                    new zc1().a(ub1Var, tb1Var, new c(jSONObject, jSONArray));
                }
            } catch (Exception unused) {
            }
            if (jSONArray.length() == 0) {
                return true;
            }
            m(jSONArray);
            return false;
        }
        return invokeV.booleanValue;
    }
}
