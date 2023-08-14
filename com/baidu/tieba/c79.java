package com.baidu.tieba;

import android.os.Process;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.performanceLog.PerformanceLogger;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c79 implements b79 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public boolean D;
    public boolean E;
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public int h;
    public int i;
    public List<fu9> j;
    public Map<String, Long> k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public ArrayList<Integer> q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public boolean w;
    public String x;
    public List<v69> y;
    public int z;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c79 a;

        public a(c79 c79Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c79Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c79Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                int b = me5.b();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("baseInfo", this.a.s());
                    jSONObject.put("kpiInfo", this.a.u());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (b != 0 && (b != 4 || !this.a.s)) {
                    if (b == 2) {
                        jSONObject.put("debugInfo", this.a.t());
                    }
                    aka.h().k(jSONObject, !this.a.s);
                    if (this.a.y == null) {
                        this.a.y.clear();
                        return null;
                    }
                    return null;
                }
                JSONObject t = this.a.t();
                t.put("running", this.a.w());
                jSONObject.put("debugInfo", t);
                aka.h().k(jSONObject, !this.a.s);
                if (this.a.y == null) {
                }
            } else {
                return (Void) invokeL.objValue;
            }
        }
    }

    public c79(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.s = true;
        this.t = false;
        this.u = false;
        this.D = false;
        this.E = false;
        this.a = 0;
        this.b = UUID.randomUUID().toString();
        this.c = str;
        this.d = str2;
        this.g = str3;
        this.k = new HashMap();
        this.j = new ArrayList();
        this.l = 0L;
        this.m = 0L;
        this.n = 0L;
        this.q = new ArrayList<>();
        B();
    }

    @Override // com.baidu.tieba.b79
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.r = z;
            this.j.add(new eu9(1));
            this.a = 1;
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.w) {
            return;
        }
        x();
        int b = me5.b();
        if ((!me5.c() && this.s) || b == 3) {
            return;
        }
        this.w = true;
        new a(this).execute(new Void[0]);
    }

    @Override // com.baidu.tieba.b79
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = this.a;
            if (i != 4 && i != 3) {
                return;
            }
            if (this.m != 0) {
                this.n += System.currentTimeMillis() - this.m;
                this.m = 0L;
            }
            this.j.add(new eu9(203));
            this.a = 5;
        }
    }

    public final JSONObject s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            JSONObject c = VideoPlatformStatic.c();
            List<v69> list = this.y;
            if (list != null) {
                try {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        this.y.get(i).c(c);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return c;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("preparedTime", this.A);
                jSONObject.put("startTime", this.B);
                jSONObject.put("totalTime", this.C);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            B();
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONArray w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            JSONArray jSONArray = new JSONArray();
            List<fu9> list = this.j;
            if (list == null) {
                return jSONArray;
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                jSONArray.put(this.j.get(i).a());
            }
            return jSONArray;
        }
        return (JSONArray) invokeV.objValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.A = 0L;
            this.B = 0L;
            this.C = 0L;
        }
    }

    @Override // com.baidu.tieba.b79
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.l = System.currentTimeMillis();
            this.j.add(new eu9(3));
            this.a = 0;
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || this.a != 5) {
            return;
        }
        this.m = System.currentTimeMillis();
        this.j.add(new eu9(204));
        this.a = 4;
    }

    @Override // com.baidu.tieba.b79
    public void a(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.A = j;
            this.B = j2;
            this.C = j3;
        }
    }

    @Override // com.baidu.tieba.b79
    public void c(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.D = z;
            this.E = z2;
        }
    }

    @Override // com.baidu.tieba.b79
    public boolean d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            int i = this.a;
            if (i != 8 && i != 7 && i != 6 && i != -1 && i != 1) {
                this.e = VideoPlatformStatic.a(str);
                this.f = str2;
                y();
                this.j.add(new eu9(207));
                this.a = 7;
                A();
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.b79
    public void g(long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) {
            this.o++;
            this.p += j;
            this.q.add(Integer.valueOf(i));
        }
    }

    @Override // com.baidu.tieba.b79
    public void k(String str, String str2) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) && (i = this.a) != 8 && i != 7 && i != 6 && i != -1) {
            this.e = VideoPlatformStatic.a(str);
            this.f = str2;
            y();
            this.j.add(new eu9(205));
            this.a = 8;
            A();
        }
    }

    @Override // com.baidu.tieba.b79
    public String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, str2)) == null) {
            int i = this.a;
            if (i != 8 && i != 7 && i != 6 && i != -1) {
                this.e = VideoPlatformStatic.a(str);
                this.f = str2;
                y();
                this.k.put("stallDuration", Long.valueOf(this.p));
                this.j.add(new eu9(206));
                this.a = 6;
                A();
                return this.b;
            }
            return this.b;
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.b79
    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            int i2 = this.a;
            if (i2 == 5) {
                z();
            } else if (i2 != 3) {
            } else {
                this.h = i;
                this.m = System.currentTimeMillis();
                this.j.add(new eu9(200));
                this.a = 4;
            }
        }
    }

    @Override // com.baidu.tieba.b79
    public void i(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048586, this, i) == null) && (i2 = this.a) != 4 && i2 != 5 && i2 != 7 && i2 != 8) {
            this.h = i;
            this.s = true;
            this.t = true;
            this.k.put("loadingTime", 1L);
            this.l = 0L;
            this.j.add(new eu9(103));
            this.a = 3;
        }
    }

    @Override // com.baidu.tieba.b79
    public void l(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && (i2 = this.a) != 4 && i2 != 5 && i2 != 7 && i2 != 8) {
            this.h = i;
            this.s = true;
            long currentTimeMillis = System.currentTimeMillis() - this.l;
            if (currentTimeMillis > 86400000) {
                currentTimeMillis = 10000;
            }
            this.k.put("loadingTime", Long.valueOf(currentTimeMillis));
            this.l = 0L;
            this.j.add(new eu9(102));
            this.a = 3;
        }
    }

    public final JSONObject t() {
        InterceptResult invokeV;
        int i;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("uuid", this.b);
                if (!StringUtils.isNull(this.g)) {
                    jSONObject.put("parentUuid", this.g);
                }
                jSONObject.put("tid", this.c);
                jSONObject.put("videoUrl", this.d);
                jSONObject.put("source", this.e);
                jSONObject.put("playerType", VideoPlatformStatic.b(this.h));
                jSONObject.put("urlType", this.i);
                jSONObject.put("sub_error", this.z);
                jSONObject.put("current_pid", Process.myPid());
                if (this.t) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("directPrepare", i);
                jSONObject.put("testType", TbSingleton.getInstance().getVideoTestType());
                jSONObject.put("stallTypes", this.q);
                String str = "1";
                if (this.D) {
                    obj = "1";
                } else {
                    obj = "0";
                }
                jSONObject.put("pcdn_used", obj);
                if (!this.E) {
                    str = "0";
                }
                jSONObject.put("p2p_used", str);
                if (!StringUtils.isNull(this.x)) {
                    jSONObject.put("error_stack", this.x);
                }
                if (this.y != null) {
                    int size = this.y.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.y.get(i2).b(jSONObject);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final JSONObject u() {
        InterceptResult invokeV;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, Long> entry : this.k.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                if (!this.k.containsKey("loadingTime")) {
                    jSONObject.put("loadingTime", 0L);
                }
                if (!this.k.containsKey("playDuration")) {
                    jSONObject.put("playDuration", 0L);
                }
                if (!this.k.containsKey("stallCount")) {
                    jSONObject.put("stallCount", 0);
                }
                if (!this.k.containsKey("stallDuration")) {
                    jSONObject.put("stallDuration", 0L);
                }
                int i3 = 1;
                if (this.r) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("isCacheHit", i);
                if (this.s) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                jSONObject.put("playSuccess", i2);
                jSONObject.put("startPlayTimeInfo", v());
                if (!this.u) {
                    i3 = 0;
                }
                jSONObject.put("retryError", i3);
                jSONObject.put("error", this.v);
                if (this.y != null) {
                    int size = this.y.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        this.y.get(i4).a(jSONObject);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public final void x() {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || this.k == null) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "video_monitor");
        logItem.append("play_time", this.k.get("playDuration"));
        logItem.append("caton_time", this.k.get("stallDuration"));
        logItem.append("loading_time", Long.valueOf(this.C));
        Object[] objArr = new Object[2];
        objArr[0] = "pcdn";
        if (this.E) {
            i = 2;
        } else {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i | (this.D ? 1 : 0));
        logItem.append(objArr);
        logItem.append("hit_cache", Boolean.valueOf(this.r));
        logItem.append("direct_play", Integer.valueOf(this.t ? 1 : 0));
        logItem.append("page_code", this.f);
        logItem.append(FpsTracer.UBC_KEY_NET_TYPE, og.a(BdBaseApplication.getInst()));
        BdStatisticsManager.getInstance().performance("video", logItem);
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (this.m != 0) {
                this.n += System.currentTimeMillis() - this.m;
            }
            this.k.put("playDuration", Long.valueOf(this.n));
            this.k.put("stallCount", Long.valueOf(this.o));
            this.k.put("stallDuration", Long.valueOf(this.p));
            if (!this.k.containsKey("loadingTime")) {
                this.k.put("loadingTime", 0L);
            }
            this.l = 0L;
            this.m = 0L;
            this.n = 0L;
            this.o = 0L;
            this.p = 0L;
        }
    }
}
