package com.baidu.tieba;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.http.ContentType;
import com.fun.ad.sdk.internal.api.http.PostRequest;
import com.fun.ad.sdk.internal.api.http.RequestParams;
import com.fun.ad.sdk.internal.api.http.Response;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.n0;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class dra implements Reporter {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;
    public final Handler c;
    public final LinkedList<d> d;
    public boolean e;

    /* loaded from: classes4.dex */
    public interface d {
        d a(d dVar);

        boolean a();

        void b();

        long c();

        JSONArray d();

        boolean isEmpty();
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public f() {
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

        public /* synthetic */ f(a aVar) {
            this();
        }

        @Override // com.baidu.tieba.dra.d
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LogPrinter.v("RetryEvent reported failed with retryCount:%d", Integer.valueOf(this.a));
                int i = this.a;
                int i2 = i + 1;
                this.a = i2;
                if (i >= 2) {
                    e();
                    this.a = 0;
                    return 0L;
                }
                return i2 * 1000;
            }
            return invokeV.longValue;
        }

        public abstract void e();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947715542, "Lcom/baidu/tieba/dra;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947715542, "Lcom/baidu/tieba/dra;");
                return;
            }
        }
        f = !dra.class.desiredAssertionStatus();
    }

    public dra(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = new LinkedList<>();
        this.e = true;
        this.a = str;
        this.b = z;
        HandlerThread handlerThread = new HandlerThread("reporter2");
        handlerThread.start();
        a aVar = new a(this, handlerThread.getLooper());
        this.c = aVar;
        if (z) {
            aVar.obtainMessage(3, gma.j(), 0).sendToTarget();
        }
        com.fun.n0.b(new b(this));
    }

    public final boolean c(JSONArray jSONArray) {
        InterceptResult invokeL;
        Response response;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            try {
                response = new PostRequest(this.a, new RequestParams(jSONArray.toString(), ContentType.JSON), true).perform();
            } catch (IOException e2) {
                LogPrinter.e(e2);
                response = null;
            }
            return response != null && response.getResponseCode() == 200;
        }
        return invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, obj) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str2, obj);
            } catch (JSONException unused) {
            }
            logEvent(str, jSONObject);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, map) == null) {
            logEvent(str, new JSONObject(map));
        }
    }

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dra a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(dra draVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {draVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = draVar;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            int i2 = message.arg1;
                            int k = gma.k();
                            int g = gma.g();
                            int i3 = (i2 - k) - g;
                            LogPrinter.d("ReportCount: req:%d suc:%d fai:%d mis:%d", Integer.valueOf(i2), Integer.valueOf(k), Integer.valueOf(g), Integer.valueOf(i3));
                            if (i3 > 0) {
                                gma.f("key_rpt_mis_c", i3);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    LogPrinter.v("turn on report switch", new Object[0]);
                    this.a.e = true;
                }
                dra.a(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements n0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dra a;

        public b(dra draVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {draVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = draVar;
        }

        @Override // com.fun.n0.b
        public void a(@Nullable NetworkInfo networkInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkInfo) == null) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    this.a.c.removeMessages(1);
                    this.a.c.sendEmptyMessage(1);
                    return;
                }
                this.a.c.removeMessages(1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final JSONArray b;
        public final /* synthetic */ dra c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(dra draVar, e eVar) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {draVar, eVar};
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
            this.c = draVar;
            this.b = new JSONArray();
            a(eVar);
        }

        @Override // com.baidu.tieba.dra.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b.length() >= 10 : invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.dra.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                for (int i = 0; i < this.b.length(); i++) {
                    try {
                        HostAppInfo.fillHostAppInfo(this.b.optJSONObject(i));
                    } catch (JSONException unused) {
                    }
                }
                return this.b;
            }
            return (JSONArray) invokeV.objValue;
        }

        @Override // com.baidu.tieba.dra.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.b.length() <= 0 : invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.dra.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                if (a()) {
                    return this;
                }
                if (dVar instanceof e) {
                    e eVar = (e) dVar;
                    this.b.put(eVar.f());
                    eVar.f = true;
                    eVar.e = null;
                    return this;
                } else if (dVar instanceof c) {
                    c cVar = (c) dVar;
                    while (!a() && cVar.b.length() > 0) {
                        this.b.put(cVar.b.remove(0));
                    }
                    return this;
                } else {
                    throw new IllegalArgumentException("Unknown Event type:" + dVar);
                }
            }
            return (d) invokeL.objValue;
        }

        @Override // com.baidu.tieba.dra.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.v("ArrayEvent reported succeed with len:%d", Integer.valueOf(this.b.length()));
                if (this.c.b) {
                    gma.f("key_rpt_suc_c", gma.k() + this.b.length());
                }
            }
        }

        @Override // com.baidu.tieba.dra.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                int i = 0;
                while (this.b.length() > 0 && i < 1) {
                    this.b.remove(0);
                    i++;
                }
                if (this.c.b) {
                    gma.f("key_rpt_fai_c", gma.g() + i);
                }
                LogPrinter.v("cut %d datas from ArrayEvent", Integer.valueOf(i));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String b;
        public final JSONObject c;
        public long d;
        public JSONObject e;
        public boolean f;
        public final /* synthetic */ dra g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(dra draVar, String str, JSONObject jSONObject) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {draVar, str, jSONObject};
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
            this.g = draVar;
            this.b = str;
            this.c = jSONObject;
            this.d = System.currentTimeMillis();
            if (FunAdSdk.isLogEnabled()) {
                LogPrinter.v("report Event:" + this, new Object[0]);
            }
        }

        @Override // com.baidu.tieba.dra.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                if (dVar instanceof e) {
                    c cVar = new c(this.g, this);
                    cVar.a(dVar);
                    return cVar;
                } else if (dVar instanceof c) {
                    c cVar2 = (c) dVar;
                    cVar2.a(this);
                    return cVar2;
                } else {
                    throw new IllegalArgumentException("Unknown Event type:" + dVar);
                }
            }
            return (d) invokeL.objValue;
        }

        @Override // com.baidu.tieba.dra.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.dra.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                JSONObject f = f();
                if (f == null) {
                    return null;
                }
                try {
                    HostAppInfo.fillHostAppInfo(f);
                } catch (JSONException unused) {
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(f);
                return jSONArray;
            }
            return (JSONArray) invokeV.objValue;
        }

        public JSONObject f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f) {
                    return null;
                }
                if (this.e == null) {
                    this.e = HostAppInfo.buildBaseJson(this.b, this.c, this.d);
                }
                return this.e;
            }
            return (JSONObject) invokeV.objValue;
        }

        @Override // com.baidu.tieba.dra.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? f() == null : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "{key='" + this.b + "', content=" + this.c + '}';
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.dra.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.v("JSONEvent reported succeed", new Object[0]);
                if (f() != null && this.g.b) {
                    gma.f("key_rpt_suc_c", gma.k() + 1);
                }
            }
        }

        @Override // com.baidu.tieba.dra.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                LogPrinter.v("give up report JSONEvent", new Object[0]);
                this.f = true;
                this.e = null;
                if (this.g.b) {
                    gma.f("key_rpt_fai_c", gma.g() + 1);
                }
            }
        }
    }

    public static void a(dra draVar) {
        d pollFirst;
        JSONArray jSONArray;
        d peekFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, draVar) == null) {
            while (draVar.e) {
                synchronized (draVar.d) {
                    pollFirst = draVar.d.pollFirst();
                    if (pollFirst != null) {
                        while (!pollFirst.a() && !draVar.d.isEmpty() && (peekFirst = draVar.d.peekFirst()) != null) {
                            pollFirst = pollFirst.a(peekFirst);
                            if (peekFirst.isEmpty()) {
                                draVar.d.removeFirst();
                            } else if (!f && !pollFirst.a()) {
                                throw new AssertionError();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (draVar.c(pollFirst.d())) {
                    pollFirst.b();
                    if (draVar.b) {
                        int g = gma.g();
                        int i = gma.i();
                        if (g > 0 || i > 0) {
                            int k = gma.k();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("fai", g);
                                jSONObject.put("suc", k);
                                jSONObject.put("mis", i);
                            } catch (JSONException unused) {
                            }
                            JSONObject f2 = new e(draVar, "k_rpt", jSONObject).f();
                            if (f2 == null) {
                                jSONArray = null;
                            } else {
                                try {
                                    HostAppInfo.fillHostAppInfo(f2);
                                } catch (JSONException unused2) {
                                }
                                JSONArray jSONArray2 = new JSONArray();
                                jSONArray2.put(f2);
                                jSONArray = jSONArray2;
                            }
                            if (draVar.c(jSONArray)) {
                                gma.e(g, k, i);
                            }
                        }
                    }
                } else {
                    long c2 = pollFirst.c();
                    if (!pollFirst.isEmpty()) {
                        synchronized (draVar.d) {
                            draVar.d.addFirst(pollFirst);
                        }
                    }
                    if (c2 > 0) {
                        LogPrinter.v("turn off report switch, reScheduleReport delay:%dms", Long.valueOf(c2));
                        draVar.e = false;
                        if (!draVar.c.hasMessages(2)) {
                            draVar.c.sendEmptyMessageDelayed(2, c2);
                        }
                    }
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, JSONObject jSONObject) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, jSONObject) == null) {
            boolean z2 = false;
            if (pla.g(str, jSONObject)) {
                LogPrinter.d("filter key:%s content:%s", str, jSONObject);
                return;
            }
            e eVar = new e(this, str, jSONObject);
            if (this.b) {
                gma.n();
            }
            synchronized (this.d) {
                this.d.add(eVar);
            }
            NetworkInfo networkInfo = com.fun.n0.a;
            if (networkInfo != null && networkInfo.isConnected()) {
                z = true;
            } else {
                z = false;
            }
            if (z && !this.c.hasMessages(1)) {
                Handler handler = this.c;
                long j = 0;
                long j2 = gma.b.getLong("key_flt", 0L);
                if (j2 > 0 && System.currentTimeMillis() - j2 >= 86400000) {
                    z2 = true;
                }
                if (z2) {
                    j = 5000;
                }
                handler.sendEmptyMessageDelayed(1, j);
            }
        }
    }
}
