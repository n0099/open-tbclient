package com.baidu.tieba;

import android.content.Context;
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
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i4 h;
    public transient /* synthetic */ FieldHolder $fh;
    public qx a;
    public Context b;
    public volatile int c;
    public AtomicReference<HashMap<String, q4>>[] d;
    public Object e;
    public AtomicReference<HashMap<String, h4>> f;
    public Object g;

    @Deprecated
    public void i(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ i4 c;

        public a(i4 i4Var, List list, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i4Var, list, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i4Var;
            this.a = list;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HashMap[] hashMapArr = new HashMap[this.c.c];
                for (q4 q4Var : this.a) {
                    int a = zx.a(q4Var.a(), this.c.c);
                    if (hashMapArr[a] == null) {
                        hashMapArr[a] = new HashMap();
                    }
                    hashMapArr[a].put(q4Var.a(), q4Var);
                }
                for (int i = 0; i < this.c.c; i++) {
                    if (hashMapArr[i] != null) {
                        ArrayList arrayList = new ArrayList(hashMapArr[i].values());
                        if (this.c.d[i].get() == null) {
                            this.c.B(i);
                        }
                        this.c.C(arrayList, i, this.b);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List a;
        public final /* synthetic */ i4 b;

        public b(i4 i4Var, List list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i4Var, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i4Var;
            this.a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.f.get() == null) {
                    this.b.A();
                }
                HashMap hashMap = new HashMap((Map) this.b.f.get());
                for (h4 h4Var : this.a) {
                    hashMap.put(h4Var.c() + "_" + h4Var.b(), h4Var);
                }
                this.b.f.set(hashMap);
                if (AppConfig.isDebug()) {
                    Log.d("ExperimentManager", "updateAddExpInfo mExpInfoRef updated size>> " + ((HashMap) this.b.f.get()).size());
                }
            }
        }
    }

    public i4(Context context) {
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
        this.b = context.getApplicationContext();
        this.c = s4.b().a();
        this.a = new qx(this.b);
        y();
    }

    public boolean z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            if (this.f.get() != null && this.f.get().size() > 0) {
                for (h4 h4Var : this.f.get().values()) {
                    if (h4Var.c() == i) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static i4 n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (h == null) {
                synchronized (i4.class) {
                    if (h == null) {
                        h = new i4(context);
                    }
                }
            }
            return h;
        }
        return (i4) invokeL.objValue;
    }

    public final int E(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode < 0) {
                hashCode = -hashCode;
            }
            return hashCode % this.c;
        }
        return invokeL.intValue;
    }

    public void F(List<h4> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, list) == null) && list != null && list.size() > 0) {
            ElasticTaskScheduler.getInstance().postSerialTask(new b(this, list), "updateAddExpInfo", 3);
        }
    }

    public Object u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            q4 t = t(str);
            if (t != null) {
                return t.b();
            }
            return null;
        }
        return invokeL.objValue;
    }

    public boolean w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            if (u(str) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void G(List<q4> list, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048582, this, list, z) == null) && list != null && list.size() > 0) {
            ElasticTaskScheduler.getInstance().postSerialTask(new a(this, list, z), "updateNewSwitchInfo", 3);
        }
    }

    public boolean j(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) {
            return yx.a(u(str), z);
        }
        return invokeLZ.booleanValue;
    }

    public double k(String str, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, Double.valueOf(d)})) == null) {
            return yx.b(u(str), d);
        }
        return invokeCommon.doubleValue;
    }

    public int o(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048590, this, str, i)) == null) {
            return yx.c(u(str), i);
        }
        return invokeLI.intValue;
    }

    public long p(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048591, this, str, j)) == null) {
            return yx.e(u(str), j);
        }
        return invokeLJ.longValue;
    }

    public String s(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, str, str2)) == null) {
            return yx.f(u(str), str2);
        }
        return (String) invokeLL.objValue;
    }

    @Deprecated
    public int v(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, str, i)) == null) {
            return this.a.l(str, i);
        }
        return invokeLI.intValue;
    }

    public void x(JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048599, this, jSONObject, z) == null) {
            if (jSONObject != null) {
                this.a.k().g(jSONObject);
                return;
            }
            throw new NullPointerException("config string is empty!");
        }
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f.get() == null) {
                synchronized (this.g) {
                    if (this.f.get() == null) {
                        HashMap<String, h4> hashMap = new HashMap<>();
                        HashMap<String, h4> m = this.a.m();
                        if (m != null && m.size() > 0) {
                            hashMap.putAll(m);
                        }
                        HashMap<String, h4> q = this.a.q();
                        if (q != null && q.size() > 0) {
                            hashMap.putAll(q);
                        }
                        if (AppConfig.isDebug()) {
                            Log.d("ExperimentManager", "loadExpInfo mergeExpInfoMap size>> " + hashMap.size());
                        }
                        this.f.set(hashMap);
                    }
                }
            }
            this.a.g();
        }
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (this.f.get() != null && this.f.get().size() > 0) {
                for (h4 h4Var : this.f.get().values()) {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(String.valueOf(h4Var.c()));
                    jSONArray2.put(String.valueOf(h4Var.b()));
                    jSONArray.put(jSONArray2);
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void B(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && this.d[i].get() == null) {
            synchronized (this.e) {
                if (this.d[i].get() == null) {
                    List<q4> arrayList = new ArrayList<>();
                    List<q4> n = this.a.n(i);
                    if (n != null && n.size() > 0) {
                        arrayList.addAll(n);
                    }
                    List<q4> s = this.a.s(i);
                    if (s != null && s.size() > 0) {
                        arrayList.addAll(s);
                    }
                    if (AppConfig.isDebug()) {
                        Log.d("ExperimentManager", "loadSwitchInfo mergeSwitchList size " + arrayList.size());
                    }
                    C(arrayList, i, true);
                }
            }
        }
    }

    public void g(p4 p4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, p4Var) == null) && p4Var != null && p4Var.a()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            try {
                jSONObject.put(p4Var.c(), p4Var.e());
                jSONObject2.put(p4Var.c(), p4Var.d());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            h4 a2 = h4.a(p4Var.b());
            if (a2 != null) {
                arrayList.add(a2);
                arrayList3.add(a2);
            }
            arrayList2.add(new q4(p4Var.c(), p4Var.d()));
            G(arrayList2, true);
            F(arrayList3);
            D(jSONObject, jSONObject2, arrayList);
        }
    }

    public final void C(List<q4> list, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{list, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            HashMap<String, q4> hashMap = new HashMap<>();
            if (list != null && list.size() > 0) {
                if (this.d[i].get() != null) {
                    hashMap.putAll(this.d[i].get());
                }
                for (q4 q4Var : list) {
                    if (hashMap.get(q4Var.a()) == null || z) {
                        hashMap.put(q4Var.a(), q4Var);
                    }
                }
            }
            this.d[i].set(hashMap);
        }
    }

    public void D(JSONObject jSONObject, JSONObject jSONObject2, List<h4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, jSONObject, jSONObject2, list) == null) {
            this.a.t(jSONObject, jSONObject2, list);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (int i = 0; i < this.c; i++) {
                B(i);
            }
            A();
        }
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.a.k().b();
        }
        return (String) invokeV.objValue;
    }

    public ArrayList<h4> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArrayList<h4> arrayList = new ArrayList<>();
            if (this.f.get() != null && this.f.get().size() > 0) {
                arrayList.addAll(this.f.get().values());
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.d = new AtomicReference[this.c];
            for (int i = 0; i < this.c; i++) {
                this.d[i] = new AtomicReference<>();
            }
            this.f = new AtomicReference<>();
            this.e = new Object();
            this.g = new Object();
        }
    }

    public JSONObject q() {
        InterceptResult invokeV;
        Object b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < this.c; i++) {
                try {
                    HashMap<String, q4> hashMap = this.d[i].get();
                    if (hashMap != null) {
                        for (String str : hashMap.keySet()) {
                            q4 q4Var = hashMap.get(str);
                            if (q4Var != null && (b2 = q4Var.b()) != null) {
                                jSONObject.put(str, b2);
                            }
                        }
                    }
                } catch (JSONException e) {
                    k4.b("ExperimentManager", " getRawFlags JSONException", e);
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public q4 t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, str)) == null) {
            int E = E(str);
            if (this.d[E].get() == null) {
                B(E);
            }
            return this.d[E].get().get(str);
        }
        return (q4) invokeL.objValue;
    }
}
