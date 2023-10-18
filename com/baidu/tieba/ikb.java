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
import com.fun.j0;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ikb implements Reporter {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ boolean f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final boolean b;
    public final Handler c;
    public final LinkedList<d> d;
    public boolean e;

    /* loaded from: classes6.dex */
    public interface d {
        int a();

        d a(d dVar);

        boolean b();

        void c();

        JSONArray d();

        boolean isEmpty();
    }

    /* loaded from: classes6.dex */
    public static abstract class f implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
    }

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
        f = !ikb.class.desiredAssertionStatus();
    }

    public ikb(String str, boolean z) {
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
            aVar.obtainMessage(3, zjb.k(), 0).sendToTarget();
        }
        com.fun.j0.b(new b(this));
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

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ikb a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ikb ikbVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ikbVar, looper};
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
            this.a = ikbVar;
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
                            int l = zjb.l();
                            int h = zjb.h();
                            int i3 = (i2 - l) - h;
                            LogPrinter.d("ReportCount: req:%d suc:%d fai:%d mis:%d", Integer.valueOf(i2), Integer.valueOf(l), Integer.valueOf(h), Integer.valueOf(i3));
                            if (i3 > 0) {
                                zjb.g("key_rpt_mis_c", i3);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    LogPrinter.v("turn on report switch", new Object[0]);
                    this.a.e = true;
                }
                ikb.a(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements j0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ikb a;

        public b(ikb ikbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ikbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ikbVar;
        }

        @Override // com.fun.j0.b
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

    /* loaded from: classes6.dex */
    public class c extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final JSONArray a;
        public final /* synthetic */ ikb b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ikb ikbVar, e eVar) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ikbVar, eVar};
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
            this.b = ikbVar;
            this.a = new JSONArray();
            a(eVar);
        }

        @Override // com.baidu.tieba.ikb.d
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a.length() : invokeV.intValue;
        }

        @Override // com.baidu.tieba.ikb.d
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.length() >= 10 : invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ikb.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                for (int i = 0; i < this.a.length(); i++) {
                    try {
                        HostAppInfo.fillHostAppInfo(this.a.optJSONObject(i));
                    } catch (JSONException unused) {
                    }
                }
                return this.a;
            }
            return (JSONArray) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ikb.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a.length() <= 0 : invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ikb.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar)) == null) {
                if (b()) {
                    return this;
                }
                if (dVar instanceof e) {
                    e eVar = (e) dVar;
                    this.a.put(eVar.e());
                    eVar.e = true;
                    eVar.d = null;
                    return this;
                } else if (dVar instanceof c) {
                    c cVar = (c) dVar;
                    while (!b() && cVar.a.length() > 0) {
                        this.a.put(cVar.a.remove(0));
                    }
                    return this;
                } else {
                    throw new IllegalArgumentException("Unknown Event type:" + dVar);
                }
            }
            return (d) invokeL.objValue;
        }

        @Override // com.baidu.tieba.ikb.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.v("ArrayEvent reported succeed with len:%d", Integer.valueOf(this.a.length()));
                if (this.b.b) {
                    zjb.g("key_rpt_suc_c", zjb.l() + this.a.length());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final String a;
        public final JSONObject b;
        public long c;
        public JSONObject d;
        public boolean e;
        public final /* synthetic */ ikb f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ikb ikbVar, String str, JSONObject jSONObject) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ikbVar, str, jSONObject};
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
            this.f = ikbVar;
            this.a = str;
            this.b = jSONObject;
            this.c = System.currentTimeMillis();
            if (FunAdSdk.isLogEnabled()) {
                LogPrinter.v("report Event:" + this, new Object[0]);
            }
        }

        @Override // com.baidu.tieba.ikb.d
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.ikb.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar)) == null) {
                if (dVar instanceof e) {
                    c cVar = new c(this.f, this);
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

        @Override // com.baidu.tieba.ikb.d
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.ikb.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                JSONObject e = e();
                if (e == null) {
                    return null;
                }
                try {
                    HostAppInfo.fillHostAppInfo(e);
                } catch (JSONException unused) {
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(e);
                return jSONArray;
            }
            return (JSONArray) invokeV.objValue;
        }

        public JSONObject e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.e) {
                    return null;
                }
                if (this.d == null) {
                    this.d = HostAppInfo.buildBaseJson(this.a, this.b, this.c);
                }
                return this.d;
            }
            return (JSONObject) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ikb.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? e() == null : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return "{key='" + this.a + "', content=" + this.b + '}';
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ikb.d
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                LogPrinter.v("JSONEvent reported succeed", new Object[0]);
                if (e() != null && this.f.b) {
                    zjb.g("key_rpt_suc_c", zjb.l() + 1);
                }
            }
        }
    }

    public static void a(ikb ikbVar) {
        d pollFirst;
        JSONArray jSONArray;
        d peekFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ikbVar) == null) {
            while (ikbVar.e) {
                synchronized (ikbVar.d) {
                    pollFirst = ikbVar.d.pollFirst();
                    if (pollFirst != null) {
                        while (!pollFirst.b() && !ikbVar.d.isEmpty() && (peekFirst = ikbVar.d.peekFirst()) != null) {
                            pollFirst = pollFirst.a(peekFirst);
                            if (peekFirst.isEmpty()) {
                                ikbVar.d.removeFirst();
                            } else if (!f && !pollFirst.b()) {
                                throw new AssertionError();
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (ikbVar.c(pollFirst.d())) {
                    pollFirst.c();
                    if (ikbVar.b) {
                        int h = zjb.h();
                        int j = zjb.j();
                        if (h > 0 || j > 0) {
                            int l = zjb.l();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("fai", h);
                                jSONObject.put("suc", l);
                                jSONObject.put("mis", j);
                            } catch (JSONException unused) {
                            }
                            JSONObject e2 = new e(ikbVar, "k_rpt", jSONObject).e();
                            if (e2 == null) {
                                jSONArray = null;
                            } else {
                                try {
                                    HostAppInfo.fillHostAppInfo(e2);
                                } catch (JSONException unused2) {
                                }
                                JSONArray jSONArray2 = new JSONArray();
                                jSONArray2.put(e2);
                                jSONArray = jSONArray2;
                            }
                            if (ikbVar.c(jSONArray)) {
                                zjb.f(h, l, j);
                            }
                        }
                    }
                } else {
                    synchronized (ikbVar.d) {
                        if (ikbVar.d.size() >= 1000) {
                            if (ikbVar.b) {
                                zjb.e(pollFirst.a());
                            }
                        } else {
                            ikbVar.d.addFirst(pollFirst);
                            LogPrinter.v("turn off report switch, reScheduleReport delay:%dms", 1500L);
                            ikbVar.e = false;
                            if (!ikbVar.c.hasMessages(2)) {
                                ikbVar.c.sendEmptyMessageDelayed(2, 1500L);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, jSONObject) == null) {
            boolean z = false;
            if (njb.i(str, jSONObject)) {
                LogPrinter.d("filter key:%s content:%s", str, jSONObject);
                return;
            }
            e eVar = new e(this, str, jSONObject);
            if (this.b) {
                zjb.o();
            }
            synchronized (this.d) {
                if (this.d.size() >= 1000) {
                    d removeFirst = this.d.removeFirst();
                    if (this.b && removeFirst != null) {
                        zjb.e(removeFirst.a());
                    }
                }
                this.d.add(eVar);
            }
            if (!this.c.hasMessages(1)) {
                Handler handler = this.c;
                long j = 0;
                long j2 = zjb.b.getLong("key_flt", 0L);
                if (j2 > 0 && System.currentTimeMillis() - j2 >= 86400000) {
                    z = true;
                }
                if (z) {
                    j = 5000;
                }
                handler.sendEmptyMessageDelayed(1, j);
            }
        }
    }
}
