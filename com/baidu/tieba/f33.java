package com.baidu.tieba;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.exp.ADConfigError;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f33 extends g33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static LruCache<String, ArrayMap<String, hg3>> b;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.g33
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "accredit" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public static class a implements e33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aq3 a;

        /* renamed from: com.baidu.tieba.f33$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0277a implements e33 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0277a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.e33
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (f33.a) {
                        Log.d("SwanAppUpdateManager", "has scope set");
                    }
                    this.a.a.a(f33.g(true));
                }
            }
        }

        public a(aq3 aq3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aq3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aq3Var;
        }

        @Override // com.baidu.tieba.e33
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Map<String, hg3> g = f33.g(true);
                if (g.size() > 0) {
                    this.a.a(g);
                    if (f33.a) {
                        Log.d("SwanAppUpdateManager", "callback scope set");
                        return;
                    }
                    return;
                }
                h82.k("SwanAppUpdateManager", "has not scope set，required request from server");
                d33.g().update(new C0277a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements e33 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ aq3 b;
        public final /* synthetic */ String c;

        public b(String str, aq3 aq3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, aq3Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = aq3Var;
            this.c = str2;
        }

        @Override // com.baidu.tieba.e33
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k33.f().d(this.a);
                this.b.a(f33.g(true).get(this.c));
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947713155, "Lcom/baidu/tieba/f33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947713155, "Lcom/baidu/tieba/f33;");
                return;
            }
        }
        a = rr1.a;
        b = new LruCache<>(6);
    }

    public f33() {
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

    public static ArrayMap<String, hg3> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            hb3 b0 = hb3.b0();
            if (b0 != null && !TextUtils.isEmpty(b0.b)) {
                return b.get(b0.b);
            }
            return null;
        }
        return (ArrayMap) invokeV.objValue;
    }

    public static void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            h82.k("SwanAppUpdateManager", "resetCache");
            b.evictAll();
        }
    }

    @Override // com.baidu.tieba.g33
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            h82.k("SwanAppUpdateManager", "onFail");
        }
    }

    @Override // com.baidu.tieba.g33
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h82.k("SwanAppUpdateManager", "onFiltered");
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            h82.k("SwanAppUpdateManager", "cleanAccreditListData");
            hb3 M = hb3.M();
            if (M == null) {
                h82.k("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            h82.k("SwanAppUpdateManager", "prefName: " + M.e0().p() + ", cleanAccredit");
            d33.g().w(new f33());
            M.e0().B("node_data_accredit_list", "");
            o();
            d33.g().update();
        }
    }

    @NonNull
    public static Map<String, hg3> g(boolean z) {
        InterceptResult invokeZ;
        long j;
        int size;
        ArrayMap<String, hg3> l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z)) == null) {
            if (z && (l = l()) != null) {
                return l;
            }
            if (a) {
                j = System.nanoTime();
            } else {
                j = 0;
            }
            ArrayMap arrayMap = new ArrayMap();
            hb3 M = hb3.M();
            if (M == null) {
                h82.k("SwanAppUpdateManager", "#getAccreditListData swanApp=null");
                return arrayMap;
            }
            String appId = M.getAppId();
            String q = M.e0().q("node_data_accredit_list", "");
            String q2 = M.e0().q("cur_request_id", "");
            h82.k("SwanAppUpdateManager", "#getAccreditListData prefName=" + M.e0().p() + " requestId=" + q2 + " accreditList=" + q);
            if (TextUtils.isEmpty(q)) {
                return arrayMap;
            }
            try {
                ArrayMap<String, hg3> m = m(new JSONObject(q), appId);
                if (a) {
                    long nanoTime = System.nanoTime();
                    StringBuilder sb = new StringBuilder();
                    sb.append("#getAccreditListData cost=");
                    sb.append((nanoTime - j) / 1000000.0d);
                    sb.append(" size=");
                    LruCache<String, ArrayMap<String, hg3>> lruCache = b;
                    if (lruCache == null) {
                        size = 0;
                    } else {
                        size = lruCache.size();
                    }
                    sb.append(size);
                    Log.d("SwanAppUpdateManager", sb.toString());
                }
                h82.k("SwanAppUpdateManager", "getAccreditListData - from json");
                return m;
            } catch (JSONException e) {
                h82.l("SwanAppUpdateManager", "#getAccreditListData - parse accreditList fail", e);
                return arrayMap;
            }
        }
        return (Map) invokeZ.objValue;
    }

    public static void h(@NonNull aq3<Map<String, hg3>> aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, aq3Var) == null) {
            if (a) {
                Log.d("SwanAppUpdateManager", "API get scope set");
            }
            d33.g().z(new a(aq3Var));
        }
    }

    @Nullable
    public static hg3 k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            return g(true).get(str);
        }
        return (hg3) invokeL.objValue;
    }

    public static void i(String str, @NonNull aq3<hg3> aq3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65542, null, str, aq3Var) == null) {
            j(str, aq3Var, k33.f().b(str));
        }
    }

    public static void j(String str, @NonNull aq3<hg3> aq3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, aq3Var, str2) == null) {
            hg3 hg3Var = g(true).get(str);
            if (hg3Var != null) {
                k33.f().d(str2);
                aq3Var.a(hg3Var);
                if (a) {
                    Log.d("SwanAppUpdateManager", "callback scope node");
                    return;
                }
                return;
            }
            h82.k("SwanAppUpdateManager", "has not scope node，required request from server");
            d33.g().update(new b(str2, aq3Var, str));
        }
    }

    public static ArrayMap<String, hg3> m(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, jSONObject, str)) == null) {
            ArrayMap<String, hg3> arrayMap = new ArrayMap<>();
            if (jSONObject == null) {
                return arrayMap;
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("list");
            if (optJSONObject2 == null) {
                h82.k("SwanAppUpdateManager", "getAccreditListData - joAccreditList is null");
                return arrayMap;
            }
            Iterator<String> keys = optJSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (optJSONObject = optJSONObject2.optJSONObject(next)) != null) {
                    arrayMap.put(next, hg3.f(next, optJSONObject));
                }
            }
            n(arrayMap, str);
            return arrayMap;
        }
        return (ArrayMap) invokeLL.objValue;
    }

    public static void n(ArrayMap<String, hg3> arrayMap, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65547, null, arrayMap, str) != null) || arrayMap == null || arrayMap.size() <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        h82.k("SwanAppUpdateManager", "putScopeInfo to cache: appId=" + str + ",getAppId=" + gb3.K().getAppId());
        b.put(str, arrayMap);
    }

    @Override // com.baidu.tieba.g33
    public void d(String str, JSONObject jSONObject, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, str, jSONObject, str2) == null) {
            h82.k("SwanAppUpdateManager", "onUpdate ");
            if (jSONObject == null) {
                h82.k("SwanAppUpdateManager", ADConfigError.REASON_NULL_DATA);
                return;
            }
            hb3 M = hb3.M();
            if (M == null) {
                h82.k("SwanAppUpdateManager", "swanApp is null");
                return;
            }
            String jSONObject2 = jSONObject.toString();
            h82.k("SwanAppUpdateManager", "request appId: " + str + ",prefName: " + M.e0().p() + ", putAccredit = " + jSONObject2);
            M.e0().B("node_data_accredit_list", jSONObject2);
            qf3 e0 = M.e0();
            e0.B("cur_request_id", "update:" + str2 + "_" + str + "_" + System.currentTimeMillis());
            o();
        }
    }
}
