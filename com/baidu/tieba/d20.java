package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.scheduler.ElasticTaskScheduler;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class d20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public List<b9> c;
    public v8 d;
    public g9 e;
    public f9 f;
    public ElasticTaskScheduler g;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d20 a;

        public a(d20 d20Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d20Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d20Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    this.a.e = new g9();
                }
                this.a.e.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d20 a;

        public b(d20 d20Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d20Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d20Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.e == null) {
                    this.a.e = new g9();
                }
                this.a.e.f();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ int b;

        public c(d20 d20Var, List list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d20Var, list, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (c9 c9Var : this.a) {
                        jSONObject.put(c9Var.a(), c9Var.b());
                    }
                    c20.n(jSONObject, this.b);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d20 a;

        public d(d20 d20Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d20Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d20Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d == null) {
                    d20 d20Var = this.a;
                    d20Var.d = new v8(d20Var.a);
                }
                this.a.d.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HashMap a;

        public e(d20 d20Var, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d20Var, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hashMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (hashMap = this.a) != null && hashMap.size() > 0 && this.a.values().size() > 0) {
                c20.g(new ArrayList(this.a.values()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d20 a;

        public f(d20 d20Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d20Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d20Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            t8 t8Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.d == null) {
                    d20 d20Var = this.a;
                    d20Var.d = new v8(d20Var.a);
                }
                if (this.a.e == null) {
                    this.a.e = new g9();
                }
                ArrayList arrayList = new ArrayList();
                String d = c20.d();
                HashMap<String, t8> hashMap = new HashMap<>();
                if (!TextUtils.isEmpty(d)) {
                    hashMap = this.a.d.d(d);
                }
                HashMap hashMap2 = new HashMap();
                String e = c20.e();
                if (!TextUtils.isEmpty(e)) {
                    hashMap2.putAll(this.a.e.b(e));
                }
                HashMap hashMap3 = new HashMap();
                String c = c20.c();
                if (!TextUtils.isEmpty(c)) {
                    hashMap3.putAll(this.a.e.d(c));
                }
                HashMap hashMap4 = new HashMap();
                hashMap4.putAll(hashMap);
                hashMap4.putAll(hashMap2);
                hashMap4.putAll(hashMap3);
                for (String str : hashMap4.keySet()) {
                    if (((t8) hashMap4.get(str)) != null) {
                        String str2 = t8Var.c() + "_" + t8Var.b();
                        if (!TextUtils.isEmpty(str2) && !arrayList.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                }
                String b = c20.b();
                if (TextUtils.isEmpty(b)) {
                    return;
                }
                HashMap o = this.a.o(b);
                ArrayList arrayList2 = new ArrayList();
                for (String str3 : o.keySet()) {
                    if (!TextUtils.isEmpty(str3) && !arrayList.contains(str3)) {
                        arrayList2.add((t8) o.get(str3));
                    }
                }
                if (arrayList2.size() > 0) {
                    c20.a(arrayList2);
                }
                if (AppConfig.isDebug()) {
                    Log.d("EasyABDataProducer", "checkInvalidSidFileData sidList " + arrayList.size());
                    Log.d("EasyABDataProducer", "checkInvalidSidFileData expInfoHashMap sidList " + o.size());
                }
            }
        }
    }

    public d20(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
        this.b = e9.b().a();
        this.g = ElasticTaskScheduler.getInstance();
    }

    public final void u(HashMap<String, t8> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, hashMap) == null) {
            this.g.postConcurrentTask(new e(this, hashMap), "transferData", 3);
        }
    }

    public final void w(List<c9> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, list, i) == null) {
            this.g.postConcurrentTask(new c(this, list, i), "transferData", 3);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && s8.d(this.a).f()) {
            this.g.postConcurrentTask(new f(this), "checkInvalidSidFileData", 3);
        }
    }

    public v8 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.d == null) {
                this.d = new v8(this.a);
            }
            return this.d;
        }
        return (v8) invokeV.objValue;
    }

    public HashMap<String, t8> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            String b2 = c20.b();
            if (!TextUtils.isEmpty(b2)) {
                return o(b2);
            }
            return p();
        }
        return (HashMap) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ElasticTaskScheduler.getInstance().postConcurrentTask(new b(this), "transferData", 3);
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.g.postConcurrentTask(new d(this), "transferData", 3);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            ElasticTaskScheduler.getInstance().postConcurrentTask(new a(this), "transferData", 3);
        }
    }

    public final HashMap<String, t8> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String c2 = c20.c();
            if (this.e == null) {
                this.e = new g9();
            }
            if (!TextUtils.isEmpty(c2)) {
                return this.e.d(c2);
            }
            return this.e.c();
        }
        return (HashMap) invokeV.objValue;
    }

    public final HashMap<String, t8> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String d2 = c20.d();
            if (this.d == null) {
                this.d = new v8(this.a);
            }
            if (!TextUtils.isEmpty(d2)) {
                return this.d.d(d2);
            }
            v8 v8Var = this.d;
            return v8Var.d(v8Var.c().getConfig());
        }
        return (HashMap) invokeV.objValue;
    }

    public final HashMap<String, t8> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String e2 = c20.e();
            if (this.e == null) {
                this.e = new g9();
            }
            if (!TextUtils.isEmpty(e2)) {
                return this.e.b(e2);
            }
            return this.e.a();
        }
        return (HashMap) invokeV.objValue;
    }

    @Deprecated
    public int l(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            try {
                JSONArray jSONArray = new JSONObject(this.d.c().getConfig()).getJSONArray("exps");
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2).getJSONObject("components_values");
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (TextUtils.equals(str, next)) {
                            return jSONObject.optInt(next, i);
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public HashMap<String, t8> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.c == null) {
                if (this.f == null) {
                    this.f = new f9();
                }
                this.c = this.f.a(this.a);
            }
            HashMap<String, t8> hashMap = new HashMap<>();
            List<b9> list = this.c;
            if (list != null && list.size() > 0) {
                for (b9 b9Var : this.c) {
                    hashMap.put(b9Var.b(), t8.a(b9Var.b()));
                }
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public List<c9> n(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (this.c == null) {
                if (this.f == null) {
                    this.f = new f9();
                }
                this.c = this.f.a(this.a);
            }
            ArrayList arrayList = new ArrayList();
            List<b9> list = this.c;
            if (list != null && list.size() > 0) {
                for (b9 b9Var : this.c) {
                    if (m20.a(b9Var.c(), this.b) == i) {
                        arrayList.add(new c9(b9Var.c(), b9Var.d()));
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public final HashMap<String, t8> o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            HashMap<String, t8> hashMap = new HashMap<>();
            try {
                JSONObject jSONObject = new JSONObject(str);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String[] split = next.split("_");
                    int d2 = l20.d(split[0]);
                    int d3 = l20.d(split[1]);
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    if (jSONObject2.has("expired_time") && jSONObject2.has("is_upload")) {
                        boolean z = jSONObject2.getBoolean("is_upload");
                        long j = jSONObject2.getLong("expired_time");
                        if (z && currentTimeMillis <= j) {
                            hashMap.put(next, new t8(d2, d3, j, z));
                        }
                    } else {
                        hashMap.put(next, new t8(d2, d3));
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public List<c9> r(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (this.d == null) {
                this.d = new v8(this.a);
            }
            List<c9> e2 = this.d.e(i);
            if (this.e == null) {
                this.e = new g9();
            }
            List<c9> e3 = this.e.e(i);
            List<c9> arrayList = new ArrayList<>();
            arrayList.addAll(e2);
            arrayList.addAll(e3);
            if (AppConfig.isDebug()) {
                Log.d("EasyABDataProducer", "loadSwitchInfoFromV1AndV2 v1SwitchInfoList " + e2.size() + " v2SwitchInfoList " + e3.size() + "sampleInfoList " + arrayList.size());
            }
            if (arrayList.size() > 0) {
                w(arrayList, i);
            }
            return arrayList;
        }
        return (List) invokeI.objValue;
    }

    public List<c9> s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            String e2 = f20.e(i);
            if (!TextUtils.isEmpty(e2)) {
                try {
                    ArrayList arrayList = new ArrayList();
                    JSONObject jSONObject = new JSONObject(e2);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        arrayList.add(new c9(next, jSONObject.get(next)));
                    }
                    if (AppConfig.isDebug()) {
                        Log.d("EasyABDataProducer", "loadV3SampleSwitchInfo switchInfoList size " + arrayList.size());
                    }
                    return arrayList;
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            return r(i);
        }
        return (List) invokeI.objValue;
    }

    public final HashMap<String, t8> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            HashMap<String, t8> hashMap = new HashMap<>();
            HashMap<String, t8> i = i();
            HashMap<String, t8> j = j();
            HashMap<String, t8> h = h();
            hashMap.putAll(i);
            hashMap.putAll(j);
            hashMap.putAll(h);
            if (AppConfig.isDebug()) {
                Log.d("ExperimentManager", "loadExpInfoFromV1AndV2 expV1SidInfo>> " + i.size());
                Log.d("ExperimentManager", "loadExpInfoFromV1AndV2 expV2SidInfo>> " + j.size());
                Log.d("ExperimentManager", "loadExpInfoFromV1AndV2 expSapSidInfo>> " + h.size());
            }
            y();
            x();
            v();
            u(hashMap);
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public void t(JSONObject jSONObject, JSONObject jSONObject2, List<t8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048589, this, jSONObject, jSONObject2, list) == null) {
            c20.k(jSONObject, jSONObject2, list);
        }
    }
}
