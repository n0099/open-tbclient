package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.rtc.RTCConst;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class gy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public static volatile gy2 e;
    public transient /* synthetic */ FieldHolder $fh;
    public List<jy2> a;
    public AtomicInteger b;
    public CopyOnWriteArrayList<hy2> c;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ List b;
        public final /* synthetic */ ArrayMap c;
        public final /* synthetic */ String d;
        public final /* synthetic */ gy2 e;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public a(gy2 gy2Var, String str, List list, ArrayMap arrayMap, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy2Var, str, list, arrayMap, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = gy2Var;
            this.a = str;
            this.b = list;
            this.c = arrayMap;
            this.d = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.e.d(this.b);
                k32.l("SwanAppUpdateManager", "update request failure: ", exc);
                dd3.z(this.d, -1, exc.toString());
                pd3.b(SwanInterfaceType.UPDATE, 2101, this.d, null, exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) {
                String appId = j63.K().getAppId();
                if (TextUtils.equals(this.a, appId)) {
                    this.e.s(this.a, response, this.b, this.c);
                    k32.k("SwanAppUpdateManager", "response code = " + response.code());
                    if (!response.isSuccessful()) {
                        dd3.z(this.d, response.code(), response.message());
                    }
                    return response;
                }
                k32.k("SwanAppUpdateManager", "invalid response requestAppId:" + this.a + ";currentAppId:" + appId);
                this.e.d(this.b);
                gy2.x(this.a);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hy2 a;

        public b(gy2 gy2Var, hy2 hy2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy2Var, hy2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hy2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947810185, "Lcom/baidu/tieba/gy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947810185, "Lcom/baidu/tieba/gy2;");
                return;
            }
        }
        d = vm1.a;
    }

    public gy2() {
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
        k();
    }

    public static gy2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                synchronized (gy2.class) {
                    if (e == null) {
                        e = new gy2();
                    }
                }
            }
            return e;
        }
        return (gy2) invokeV.objValue;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            B(null);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            l();
            this.b = new AtomicInteger(0);
            this.c = new CopyOnWriteArrayList<>();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            arrayList.add(new iy2());
            this.a.add(new ky2());
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && j63.K().E()) {
            j63.K().q().f0().A(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, System.currentTimeMillis());
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "release: ");
            }
            if (e == null) {
                return;
            }
            this.c.clear();
            e = null;
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            if (j63.K().E()) {
                j63.K().q().f0().D(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
            }
            y();
        }
    }

    public static void x(String str) {
        k63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65541, null, str) != null) || (c0 = k63.c0()) == null) {
            return;
        }
        di3 di3Var = new di3();
        di3Var.k(5L);
        di3Var.i(53L);
        ld3 ld3Var = new ld3();
        ld3Var.p(di3Var);
        ld3Var.r(c0.X());
        ld3Var.q(dd3.n(c0.k()));
        ld3Var.m(c0.getAppId());
        ld3Var.a("requestAppId", str);
        dd3.R(ld3Var);
    }

    public void w(jy2 jy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, jy2Var) == null) {
            if (jy2Var == null) {
                if (d) {
                    Log.w("SwanAppUpdateManager", "resetNodeVersion: node is null");
                    return;
                }
                return;
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "resetNodeVersion: " + jy2Var.a());
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(jy2Var);
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            arrayMap.put(jy2Var.a(), "");
            C(arrayList, arrayMap);
        }
    }

    public void B(@Nullable hy2 hy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hy2Var) == null) {
            if (hy2Var != null) {
                this.c.add(hy2Var);
            }
            f(this.a);
        }
    }

    public final void d(@NonNull List<jy2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "doRequestFail: ");
            }
            n(list);
            o(false);
        }
    }

    public final void n(@NonNull List<jy2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            for (jy2 jy2Var : list) {
                jy2Var.b();
            }
        }
    }

    public final void C(@NonNull List<jy2> list, @NonNull ArrayMap<String, String> arrayMap) {
        k63 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, list, arrayMap) != null) || list.size() == 0 || (M = k63.M()) == null) {
            return;
        }
        String q = M.f0().q("update_nodes_version", "");
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(q)) {
            try {
                jSONObject = new JSONObject(q);
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
        }
        for (jy2 jy2Var : list) {
            String str = arrayMap.get(jy2Var.a());
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            try {
                if (d) {
                    Log.d("SwanAppUpdateManager", "updateNodeVersions: update node => " + jy2Var.a() + " , version => " + str);
                }
                jSONObject.put(jy2Var.a(), str);
            } catch (JSONException e3) {
                if (d) {
                    e3.printStackTrace();
                }
            }
        }
        M.f0().B("update_nodes_version", jSONObject.toString());
    }

    @Nullable
    public final JSONObject c(@NonNull List<jy2> list, @NonNull ArrayMap<String, String> arrayMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, list, arrayMap)) == null) {
            if (list.size() == 0) {
                return null;
            }
            String P = j63.K().q().P();
            if (TextUtils.isEmpty(P)) {
                return null;
            }
            String U = k63.M().Z().U();
            if (TextUtils.isEmpty(U)) {
                U = "NA";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ma_id", P);
                jSONObject.put("source", U);
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            for (jy2 jy2Var : list) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    String str = "";
                    if (arrayMap.containsKey(jy2Var.a())) {
                        str = arrayMap.get(jy2Var.a());
                    }
                    if (d) {
                        Log.d("SwanAppUpdateManager", "buildRequestParams: node => " + jy2Var.a() + " , version => " + str);
                    }
                    jSONObject2.put("version", str);
                    jSONObject.put(jy2Var.a(), jSONObject2);
                } catch (JSONException e3) {
                    if (d) {
                        e3.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final void e(String str, @NonNull JSONObject jSONObject, @NonNull List<jy2> list, @NonNull ArrayMap<String, String> arrayMap, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048581, this, str, jSONObject, list, arrayMap, str2) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "doRequestSuccess: start");
            }
            t();
            boolean z = false;
            for (jy2 jy2Var : list) {
                JSONObject optJSONObject = jSONObject.optJSONObject(jy2Var.a());
                if (optJSONObject == null) {
                    jy2Var.b();
                } else if (!TextUtils.equals(optJSONObject.optString("errno"), "0")) {
                    jy2Var.b();
                } else {
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("data");
                    if (optJSONObject2 == null) {
                        jy2Var.c();
                    } else {
                        if (d) {
                            Log.d("SwanAppUpdateManager", "doRequestSuccess: node => " + jy2Var.a() + " update");
                        }
                        jy2Var.d(str, optJSONObject2, str2);
                        String optString = optJSONObject.optString("version", "");
                        if (!TextUtils.isEmpty(optString)) {
                            if (d) {
                                Log.d("SwanAppUpdateManager", "doRequestSuccess: " + jy2Var.a() + " update , version " + optString);
                            }
                            arrayMap.put(jy2Var.a(), optString);
                            z = true;
                        }
                    }
                }
            }
            if (z) {
                C(list, arrayMap);
            }
            o(true);
        }
    }

    public final void f(@NonNull List<jy2> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (list.size() == 0) {
                k32.k("SwanAppUpdateManager", "doUpdate: finish => nodes are empty");
                p();
                return;
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "doUpdate: start => nodes size " + list.size());
            }
            if (this.b.incrementAndGet() > 1) {
                k32.k("SwanAppUpdateManager", "doUpdate: pending => wait previous request");
                return;
            }
            ArrayMap<String, String> i = i(this.a);
            JSONObject c = c(list, i);
            if (c == null) {
                k32.k("SwanAppUpdateManager", "doUpdate: finish => build params is null");
                p();
                return;
            }
            if (d) {
                Log.w("SwanAppUpdateManager", "doUpdate: start to request update data");
            }
            FormBody build = new FormBody.Builder().add("data", c.toString()).build();
            String b2 = rp2.o().b();
            k32.k("SwanAppUpdateManager", "appId =" + j63.K().getAppId() + ", update url = " + b2 + ",body=" + c);
            j(j63.K().getAppId(), b2, build, list, i);
        }
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (j63.K().E()) {
                return j63.K().q().f0().n(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
            }
            return System.currentTimeMillis();
        }
        return invokeV.longValue;
    }

    public final boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            long h = h();
            if (h <= 0) {
                return true;
            }
            if (System.currentTimeMillis() - h > ui4.b(j63.K().getAppId())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "onUpdateFinish: real finish update");
            }
            this.b.set(0);
            Iterator<hy2> it = this.c.iterator();
            while (it.hasNext()) {
                ib3.l(new b(this, it.next()));
            }
            this.c.clear();
        }
    }

    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            boolean m = j63.K().q().f0().m("swan_service_update_degraded", false);
            k32.i("SwanAppUpdateManager", "tryUpdate, isServiceDegraded = " + m);
            if (!m) {
                z(null);
            }
        }
    }

    @NonNull
    public final ArrayMap<String, String> i(@NonNull List<jy2> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
            ArrayMap<String, String> arrayMap = new ArrayMap<>();
            if (list.size() == 0) {
                return arrayMap;
            }
            for (jy2 jy2Var : list) {
                arrayMap.put(jy2Var.a(), "");
            }
            k63 M = k63.M();
            if (M == null) {
                return arrayMap;
            }
            String q = M.f0().q("update_nodes_version", "");
            if (TextUtils.isEmpty(q)) {
                return arrayMap;
            }
            try {
                JSONObject jSONObject = new JSONObject(q);
                for (jy2 jy2Var2 : list) {
                    arrayMap.put(jy2Var2.a(), jSONObject.optString(jy2Var2.a(), ""));
                }
            } catch (JSONException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            return arrayMap;
        }
        return (ArrayMap) invokeL.objValue;
    }

    public final void j(String str, String str2, RequestBody requestBody, List<jy2> list, ArrayMap<String, String> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, str, str2, requestBody, list, arrayMap) == null) {
            nd4 nd4Var = new nd4(str2, requestBody, new a(this, str, list, arrayMap, str2));
            nd4Var.f = true;
            nd4Var.g = true;
            nd4Var.h = false;
            nd4Var.k = 20;
            od4.g().e(nd4Var);
            pd3.a(SwanInterfaceType.UPDATE);
        }
    }

    public final void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "onRequestFinish: request finish");
            }
            if (this.b.decrementAndGet() > 0) {
                if (d) {
                    Log.d("SwanAppUpdateManager", "onRequestFinish: do pending request");
                }
                this.b.set(0);
                if (!z) {
                    A();
                    return;
                } else {
                    p();
                    return;
                }
            }
            p();
        }
    }

    public final HashMap<String, JSONObject> r(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, jSONObject)) == null) {
            HashMap<String, JSONObject> hashMap = new HashMap<>();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = jSONObject.optJSONObject(next)) != null) {
                    hashMap.put(next, optJSONObject);
                }
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public void z(@Nullable hy2 hy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, hy2Var) == null) {
            if (m()) {
                if (d) {
                    Log.d("SwanAppUpdateManager", "tryUpdate: start => cache data invalid");
                }
                B(hy2Var);
                return;
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "tryUpdate: finish => cache data valid");
            }
            if (hy2Var != null) {
                hy2Var.a();
            }
        }
    }

    public void q(@NonNull se3 se3Var, @NonNull JSONObject jSONObject) {
        int length;
        JSONObject jSONObject2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, se3Var, jSONObject) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (d) {
                Log.d("SwanAppUpdateManager", "parse increment accredit node start");
            }
            String string = se3Var.getString("node_data_accredit_list", "");
            k32.k("SwanAppUpdateManager", "prefName: " + se3Var.g() + ",cacheData is Empty = " + TextUtils.isEmpty(string) + ":accreditNodeObj=" + jSONObject);
            if (TextUtils.isEmpty(string)) {
                JSONObject jSONObject3 = new JSONObject();
                kj3.f(jSONObject3, "list", jSONObject);
                String jSONObject4 = jSONObject3.toString();
                se3Var.putString("node_data_accredit_list", jSONObject4);
                se3Var.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
                if (d) {
                    Log.d("SwanAppUpdateManager", "local has no cache data, write directly. pending data = " + jSONObject4);
                }
            } else {
                HashMap<String, JSONObject> r = r(jSONObject);
                if (r != null && r.size() != 0) {
                    JSONObject d2 = kj3.d(string);
                    JSONObject optJSONObject = d2.optJSONObject("list");
                    if (optJSONObject == null) {
                        kj3.f(d2, "list", jSONObject);
                        se3Var.putString("node_data_accredit_list", d2.toString());
                        se3Var.putString("cur_request_id", "pkgInfo:" + System.currentTimeMillis());
                        k32.k("SwanAppUpdateManager", "local has cache data, but list node is empty");
                        return;
                    }
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next) && (jSONObject2 = r.get(next)) != null) {
                            kj3.f(optJSONObject, next, jSONObject2);
                        }
                    }
                    kj3.f(d2, "list", optJSONObject);
                    se3Var.putString("node_data_accredit_list", d2.toString());
                    String string2 = se3Var.getString("cur_request_id", "");
                    if (!TextUtils.isEmpty(string2) && (length = string2.length()) > 100) {
                        string2 = string2.substring(length - 100);
                    }
                    se3Var.putString("cur_request_id", string2 + ";merge:" + System.currentTimeMillis());
                    k32.k("SwanAppUpdateManager", "prefName: " + se3Var.g() + ",mergeAccredit = " + d2);
                } else {
                    k32.k("SwanAppUpdateManager", "local has cache data, but pending data is empty");
                    return;
                }
            }
            if (d) {
                Log.d("SwanAppUpdateManager", "parse increment accredit node end, cost = " + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public final void s(String str, Response response, @NonNull List<jy2> list, @NonNull ArrayMap<String, String> arrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048594, this, str, response, list, arrayMap) == null) {
            if (d) {
                Log.d("SwanAppUpdateManager", "onResponse: update request return");
            }
            String str2 = null;
            if (!response.isSuccessful()) {
                d(list);
                pd3.c(SwanInterfaceType.UPDATE, RTCConst.RTC_STATE_STREAM_SLOW_LINK_LEVEL4, null, response);
                return;
            }
            ResponseBody body = response.body();
            if (body == null) {
                d(list);
                pd3.c(SwanInterfaceType.UPDATE, 2103, null, response);
                return;
            }
            try {
                str2 = body.string();
            } catch (IOException e2) {
                if (d) {
                    e2.printStackTrace();
                }
            }
            k32.k("SwanAppUpdateManager", "response body = " + str2);
            if (TextUtils.isEmpty(str2)) {
                d(list);
                pd3.c(SwanInterfaceType.UPDATE, 2103, str2, response);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    d(list);
                    pd3.c(SwanInterfaceType.UPDATE, jSONObject.optInt("errno", 2103), str2, response);
                    return;
                }
                String optString = jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, "");
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                k32.k("SwanAppUpdateManager", "request_id = " + optString);
                if (optJSONObject == null) {
                    d(list);
                } else {
                    e(str, optJSONObject, list, arrayMap, optString);
                }
            } catch (JSONException e3) {
                if (d) {
                    e3.printStackTrace();
                }
                d(list);
                pd3.c(SwanInterfaceType.UPDATE, 2103, str2, response);
            }
        }
    }
}
