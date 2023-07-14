package com.baidu.tieba;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.glb;
import com.baidu.tieba.ifb;
import com.baidu.tieba.mfb;
import com.baidu.tieba.xeb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.http.GetRequest;
import com.fun.ad.sdk.internal.api.http.RequestParams;
import com.fun.ad.sdk.internal.api.http.Response;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bfb {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Double> a;
    public static volatile llb b;
    public static final Handler c;
    public static FunAdSdk.SdkInitializeCallback d;
    public static final Handler e;
    public static final mfb f;
    public static final glb g;
    public static boolean h;
    public static volatile boolean i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947644459, "Lcom/baidu/tieba/bfb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947644459, "Lcom/baidu/tieba/bfb;");
                return;
            }
        }
        a = new HashMap();
        c = new a(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("fun_ad_sdk_config");
        handlerThread.start();
        e = new b(handlerThread.getLooper());
        f = new mfb();
        g = new glb();
    }

    /* loaded from: classes5.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
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
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i == 200) {
                    bfb.f(false);
                } else if (i == 201) {
                    bfb.g();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper};
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
        }

        public final void a(afb afbVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, afbVar) == null) {
                String str = FunAdSdk.getFunAdConfig().appId;
                String str2 = null;
                try {
                    LogPrinter.v("Start load config from assets.", new Object[0]);
                    AssetManager assets = FunAdSdk.getAppContext().getAssets();
                    InputStream open = assets.open(str + ".json");
                    StringWriter stringWriter = new StringWriter();
                    InputStreamReader inputStreamReader = new InputStreamReader(open);
                    char[] cArr = new char[4096];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (-1 == read) {
                            break;
                        }
                        stringWriter.write(cArr, 0, read);
                    }
                    String stringWriter2 = stringWriter.toString();
                    LogPrinter.v("Config from assets load over.", new Object[0]);
                    open.close();
                    if (!TextUtils.isEmpty(stringWriter2)) {
                        str2 = ffb.a(stringWriter2, str);
                        LogPrinter.v("Config from assets decrypted over.", new Object[0]);
                    }
                } catch (Exception e) {
                    LogPrinter.e(e, "The initialized config from assets cannot be loaded.", new Object[0]);
                }
                if (!afbVar.b(str2)) {
                    LogPrinter.e("Config from assets parsed failed.", new Object[0]);
                    if (FunAdSdk.isLogEnabled()) {
                        throw new RuntimeException("Config from assets parsed failed");
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:68:0x016a  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(@NonNull Message message) {
            Response perform;
            Reporter a;
            int i;
            JSONObject jSONObject;
            int i2;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                boolean z2 = true;
                switch (message.what) {
                    case 100:
                        HashMap hashMap = new HashMap();
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            HostAppInfo.fillReqParams(jSONObject2);
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                hashMap.put(next, jSONObject2.get(next));
                            }
                        } catch (JSONException unused) {
                        }
                        try {
                            perform = new GetRequest("https://cd.xdplt.com/v2/z", new RequestParams(hashMap)).perform();
                        } catch (IOException e) {
                            LogPrinter.e(e);
                        }
                        if (perform != null && perform.getResponseCode() == 200) {
                            try {
                                jSONObject = new JSONObject(perform.getContent());
                                i2 = jSONObject.getInt("ret");
                                LogPrinter.d("Download online ad config response ret: " + i2, new Object[0]);
                            } catch (JSONException e2) {
                                LogPrinter.e(e2);
                                a = nfb.a();
                                i = -1;
                            }
                            if (i2 == 200) {
                                String string = jSONObject.getJSONObject("data").getString("content");
                                try {
                                } catch (Exception e3) {
                                    LogPrinter.e(e3);
                                    a = nfb.a();
                                    i = -2;
                                }
                                if (new afb().b(ffb.a(string, FunAdSdk.getFunAdConfig().appId))) {
                                    jfb.b.edit().putInt("key_cp_v", 6).putString("key_serv_las_d", string).apply();
                                    bfb.a.clear();
                                    jfb.b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                                    if (z2) {
                                    }
                                    bfb.c();
                                    return;
                                }
                                a = nfb.a();
                                i = -3;
                                a.logEvent("k_ppcfg", "st", Integer.valueOf(i));
                                z2 = false;
                                jfb.b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                                if (z2) {
                                }
                                bfb.c();
                                return;
                            }
                            z2 = false;
                            jfb.b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                            if (z2) {
                                bfb.c.sendEmptyMessage(201);
                            }
                            bfb.c();
                            return;
                        }
                        LogPrinter.e("Pull ad config failed.", new Object[0]);
                        z2 = false;
                        jfb.b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                        if (z2) {
                        }
                        bfb.c();
                        return;
                    case 101:
                        a(new afb());
                        break;
                    case 102:
                        String str = null;
                        try {
                            str = ffb.a(jfb.b.getString("key_serv_las_d", null), FunAdSdk.getFunAdConfig().appId);
                        } catch (Exception e4) {
                            LogPrinter.e(e4, "Parsing err from latest cipher occurs, abandon the err data", new Object[0]);
                        }
                        if (str == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        afb afbVar = new afb();
                        if (!z && !afbVar.b(str)) {
                            LogPrinter.e("Config parsed failed from latest cipher data,use cipher data from assets instead", new Object[0]);
                        } else {
                            z2 = z;
                        }
                        if (z2) {
                            a(afbVar);
                            jfb.b.edit().remove("key_cp_v").remove("key_serv_las_d").apply();
                            break;
                        } else {
                            jfb.b.edit().putInt("key_cp_v", 6).apply();
                            break;
                        }
                    default:
                        return;
                }
                bfb.c.obtainMessage(200).sendToTarget();
            }
        }
    }

    public static int a(String str, Ssp.Pid pid) {
        InterceptResult invokeLL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, pid)) == null) {
            ifb ifbVar = f.b;
            synchronized (ifbVar.a) {
                Deque<ifb.c> deque = ifbVar.a.get(str);
                i2 = 0;
                if (deque != null) {
                    Iterator<ifb.c> descendingIterator = deque.descendingIterator();
                    while (true) {
                        if (!descendingIterator.hasNext()) {
                            break;
                        }
                        ifb.c next = descendingIterator.next();
                        if (next.a().contains(pid)) {
                            i2 = next.b();
                            break;
                        }
                    }
                }
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public static kfb b(String str) {
        InterceptResult invokeL;
        kfb kfbVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            mfb mfbVar = f;
            synchronized (mfbVar) {
                if (mfbVar.a == null) {
                    LogPrinter.d("Cannot get slotId without AdConfig updated.", new Object[0]);
                    kfbVar = null;
                } else {
                    kfbVar = mfbVar.c.get(str);
                }
            }
            return kfbVar;
        }
        return (kfb) invokeL.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && FunAdSdk.getFunAdConfig().isUseCloudAdConfiguration) {
            SharedPreferences sharedPreferences = jfb.b;
            long j = 0;
            long j2 = sharedPreferences.getLong("key_lst_config_sync_time", 0L);
            if (j2 > 0) {
                long currentTimeMillis = System.currentTimeMillis() - j2;
                if (currentTimeMillis >= 0) {
                    long j3 = sharedPreferences.getInt("key_config_interval", 15) * 60 * 1000;
                    if (currentTimeMillis < j3) {
                        j = j3 - currentTimeMillis;
                    }
                }
            }
            long max = Math.max(10000L, j);
            LogPrinter.v("Remove last pull config request, and schedule it %ds later.", Long.valueOf(max / 1000));
            Handler handler = e;
            handler.removeMessages(100);
            handler.sendEmptyMessageDelayed(100, max);
        }
    }

    public static void d(FunAdConfig funAdConfig, Set set, Set set2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, funAdConfig, set, set2) != null) || b == null) {
            return;
        }
        llb llbVar = b;
        synchronized (llbVar.b) {
            if (set2 != null) {
                Iterator it = set2.iterator();
                while (it.hasNext()) {
                    llbVar.a.remove(((Ssp) it.next()).type);
                }
            }
        }
        xeb.f(funAdConfig, set, new xeb.a() { // from class: com.baidu.tieba.ceb
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.xeb.a
            public final void a(Map map) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, map) == null) {
                    bfb.e(map);
                }
            }
        });
    }

    public static void e(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, map) == null) {
            llb llbVar = b;
            synchronized (llbVar.b) {
                if (map != null) {
                    llbVar.a.putAll(map);
                }
            }
        }
    }

    public static void f(boolean z) {
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            LogPrinter.v("tryInitialize", new Object[0]);
            SharedPreferences sharedPreferences = jfb.b;
            if (6 == sharedPreferences.getInt("key_cp_v", 6)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                e.obtainMessage(102).sendToTarget();
                return;
            }
            c();
            FunAdConfig funAdConfig = FunAdSdk.getFunAdConfig();
            teb b2 = jfb.b();
            xeb.a = jfb.m();
            Object[] objArr = new Object[2];
            if (b2 != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            objArr[0] = Boolean.valueOf(z3);
            objArr[1] = Boolean.valueOf(z);
            LogPrinter.v("adConfig load immediately over, valid:%b parseAssets:%b", objArr);
            if (b2 == null) {
                if (z) {
                    e.obtainMessage(101).sendToTarget();
                    return;
                }
                LogPrinter.d("tryInitialize failed without valid adConfig.", new Object[0]);
                glb glbVar = g;
                synchronized (glbVar.b) {
                    glbVar.d = -1;
                    while (!glbVar.c.isEmpty()) {
                        glb.a pollFirst = glbVar.c.pollFirst();
                        if (!glb.f && pollFirst == null) {
                            throw new AssertionError();
                        }
                        pollFirst.c.onError(pollFirst.b.getSid());
                    }
                }
                return;
            }
            f.a(b2);
            HostAppInfo.updateCfgv(sharedPreferences.getLong("key_config_v", 0L));
            if (!h) {
                h = true;
                xeb.f(funAdConfig, b2.a, new xeb.a() { // from class: com.baidu.tieba.qeb
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.xeb.a
                    public final void a(Map map) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, map) == null) {
                            bfb.h(map);
                        }
                    }
                });
            }
        }
    }

    public static void g() {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            LogPrinter.v("tryInitialize cloud", new Object[0]);
            final FunAdConfig funAdConfig = FunAdSdk.getFunAdConfig();
            teb b2 = jfb.b();
            xeb.a = jfb.m();
            Object[] objArr = new Object[1];
            if (b2 != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            LogPrinter.v("adConfig load immediately over, valid:%b.", objArr);
            if (b2 == null) {
                LogPrinter.e("tryInitializeCloud failed without valid adConfig.", new Object[0]);
                return;
            }
            mfb mfbVar = f;
            synchronized (mfbVar) {
                teb tebVar = mfbVar.a;
                if (tebVar != null && tebVar.equals(b2)) {
                    LogPrinter.d("New AdConfig equals old one, give up updating it", new Object[0]);
                } else {
                    HashSet hashSet = new HashSet(b2.a);
                    for (Ssp ssp : mfbVar.a.a) {
                        Iterator it = hashSet.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Ssp ssp2 = (Ssp) it.next();
                                if (ssp.type.equals(ssp2.type)) {
                                    if (!ssp.sspId.equals(ssp2.sspId)) {
                                        LogPrinter.e("In new config sspId of type : %s not match the old one", ssp.type);
                                    } else {
                                        it.remove();
                                    }
                                }
                            }
                        }
                    }
                    z2 = true;
                }
                z2 = false;
                break;
            }
            if (!z2) {
                return;
            }
            mfb mfbVar2 = f;
            mfb.c cVar = new mfb.c() { // from class: com.baidu.tieba.ydb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.mfb.c
                public final void a(Set set, Set set2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, set, set2) == null) {
                        bfb.d(FunAdConfig.this, set, set2);
                    }
                }
            };
            synchronized (mfbVar2) {
                HashSet hashSet2 = new HashSet(mfbVar2.a.a);
                HashSet hashSet3 = new HashSet(b2.a);
                for (Ssp ssp3 : mfbVar2.a.a) {
                    Iterator<Ssp> it2 = b2.a.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Ssp next = it2.next();
                            if (ssp3.type.equals(next.type)) {
                                hashSet2.remove(ssp3);
                                hashSet3.remove(next);
                                break;
                            }
                        }
                    }
                }
                LogPrinter.d("the added ssp type size: %s, reduce type size: %s.", Integer.valueOf(hashSet3.size()), Integer.valueOf(hashSet2.size()));
                cVar.a(hashSet3, hashSet2);
            }
            f.a(b2);
            HostAppInfo.updateCfgv(jfb.b.getLong("key_config_v", 0L));
        }
    }

    public static void h(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, map) == null) {
            if (b == null) {
                b = new llb(map);
                glb glbVar = g;
                llb llbVar = b;
                synchronized (glbVar.b) {
                    glbVar.e = llbVar;
                    glbVar.d = 1;
                    while (!glbVar.c.isEmpty()) {
                        glb.a pollFirst = glbVar.c.pollFirst();
                        if (!glb.f && pollFirst == null) {
                            throw new AssertionError();
                        }
                        glbVar.loadAd(pollFirst.a, pollFirst.b, pollFirst.c);
                    }
                }
            }
            i = true;
            FunAdSdk.SdkInitializeCallback sdkInitializeCallback = d;
            if (sdkInitializeCallback != null) {
                sdkInitializeCallback.onComplete();
            }
            d = null;
        }
    }
}
