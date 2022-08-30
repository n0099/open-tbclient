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
import com.baidu.tieba.am9;
import com.baidu.tieba.og9;
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
import com.qq.e.comm.constants.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class hg9 {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<String, Double> a;
    public static final Handler b;
    public static FunAdSdk.SdkInitializeCallback c;
    public static final Handler d;
    public static final ll9 e;
    public static final am9 f;
    public static boolean g;
    public static volatile boolean h;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 200) {
                hg9.e(false);
            }
        }
    }

    /* loaded from: classes4.dex */
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

        public final void a(gg9 gg9Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gg9Var) == null) {
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
                        str2 = rg9.a(stringWriter2, str);
                        LogPrinter.v("Config from assets decrypted over.", new Object[0]);
                    }
                } catch (Exception e) {
                    LogPrinter.e(e, "The initialized config from assets cannot be loaded.", new Object[0]);
                }
                if (gg9Var.b(str2)) {
                    return;
                }
                LogPrinter.e("Config from assets parsed failed.", new Object[0]);
                if (FunAdSdk.isLogEnabled()) {
                    throw new RuntimeException("Config from assets parsed failed");
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                boolean z = true;
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
                                i2 = jSONObject.getInt(Constants.KEYS.RET);
                                LogPrinter.d("Download online ad config response ret: " + i2, new Object[0]);
                            } catch (JSONException e2) {
                                LogPrinter.e(e2);
                                a = ml9.a();
                                i = -1;
                            }
                            if (i2 != 200) {
                                z = false;
                                ug9.b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                                if (z) {
                                    hg9.b.sendEmptyMessage(200);
                                }
                                hg9.c();
                                return;
                            }
                            String string = jSONObject.getJSONObject("data").getString("content");
                            try {
                            } catch (Exception e3) {
                                LogPrinter.e(e3);
                                a = ml9.a();
                                i = -2;
                            }
                            if (new gg9().b(rg9.a(string, FunAdSdk.getFunAdConfig().appId))) {
                                ug9.b.edit().putInt("key_cp_v", 5).putString("key_serv_las_d", string).apply();
                                hg9.a.clear();
                                ug9.b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                                if (z) {
                                }
                                hg9.c();
                                return;
                            }
                            a = ml9.a();
                            i = -3;
                            a.logEvent("k_ppcfg", "st", Integer.valueOf(i));
                            z = false;
                            ug9.b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                            if (z) {
                            }
                            hg9.c();
                            return;
                        }
                        LogPrinter.e("Pull ad config failed.", new Object[0]);
                        z = false;
                        ug9.b.edit().putLong("key_lst_config_sync_time", System.currentTimeMillis()).apply();
                        if (z) {
                        }
                        hg9.c();
                        return;
                    case 101:
                        a(new gg9());
                        break;
                    case 102:
                        String str = null;
                        try {
                            str = rg9.a(ug9.b.getString("key_serv_las_d", null), FunAdSdk.getFunAdConfig().appId);
                        } catch (Exception e4) {
                            LogPrinter.e(e4, "Parsing err from latest cipher occurs, abandon the err data", new Object[0]);
                        }
                        boolean z2 = str == null;
                        gg9 gg9Var = new gg9();
                        if (z2 || gg9Var.b(str)) {
                            z = z2;
                        } else {
                            LogPrinter.e("Config parsed failed from latest cipher data,use cipher data from assets instead", new Object[0]);
                        }
                        if (z) {
                            a(gg9Var);
                            ug9.b.edit().remove("key_cp_v").remove("key_serv_las_d").apply();
                            break;
                        } else {
                            ug9.b.edit().putInt("key_cp_v", 5).apply();
                            break;
                        }
                    default:
                        return;
                }
                hg9.b.obtainMessage(200).sendToTarget();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947822895, "Lcom/baidu/tieba/hg9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947822895, "Lcom/baidu/tieba/hg9;");
                return;
            }
        }
        a = new HashMap();
        b = new a(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("fun_ad_sdk_config");
        handlerThread.start();
        d = new b(handlerThread.getLooper());
        e = new ll9();
        f = new am9();
    }

    public static int a(String str, Ssp.Pid pid) {
        InterceptResult invokeLL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, pid)) == null) {
            og9 og9Var = e.b;
            synchronized (og9Var.a) {
                Deque<og9.c> deque = og9Var.a.get(str);
                i = 0;
                if (deque != null) {
                    Iterator<og9.c> descendingIterator = deque.descendingIterator();
                    while (true) {
                        if (!descendingIterator.hasNext()) {
                            break;
                        }
                        og9.c next = descendingIterator.next();
                        if (next.a().contains(pid)) {
                            i = next.b();
                            break;
                        }
                    }
                }
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public static qg9 b(String str) {
        InterceptResult invokeL;
        qg9 qg9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            ll9 ll9Var = e;
            synchronized (ll9Var) {
                if (ll9Var.a == null) {
                    LogPrinter.d("Cannot get slotId without AdConfig updated.", new Object[0]);
                    qg9Var = null;
                } else {
                    qg9Var = ll9Var.c.get(str);
                }
            }
            return qg9Var;
        }
        return (qg9) invokeL.objValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, null) == null) && FunAdSdk.getFunAdConfig().isUseCloudAdConfiguration) {
            SharedPreferences sharedPreferences = ug9.b;
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
            Handler handler = d;
            handler.removeMessages(100);
            handler.sendEmptyMessageDelayed(100, max);
        }
    }

    public static void d(bg9 bg9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bg9Var) == null) {
            h = true;
            am9 am9Var = f;
            synchronized (am9Var.b) {
                am9Var.e = bg9Var;
                am9Var.d = 1;
                while (!am9Var.c.isEmpty()) {
                    am9.a pollFirst = am9Var.c.pollFirst();
                    if (!am9.f && pollFirst == null) {
                        throw new AssertionError();
                    }
                    am9Var.loadAd(pollFirst.a, pollFirst.b, pollFirst.c);
                }
            }
            FunAdSdk.SdkInitializeCallback sdkInitializeCallback = c;
            if (sdkInitializeCallback != null) {
                sdkInitializeCallback.onComplete();
            }
            c = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0110 A[Catch: all -> 0x0265, TRY_LEAVE, TryCatch #0 {, blocks: (B:38:0x00a3, B:40:0x00a7, B:42:0x00ad, B:43:0x00b5, B:62:0x0110, B:46:0x00c6, B:47:0x00d3, B:49:0x00d9, B:50:0x00e3, B:52:0x00e9, B:54:0x00f9, B:56:0x0103, B:65:0x011a, B:69:0x0122, B:73:0x0134, B:72:0x0132, B:68:0x0120), top: B:143:0x00a3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void e(boolean z) {
        boolean z2;
        char c2;
        String str;
        boolean z3;
        boolean z4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            char c3 = 0;
            LogPrinter.v("tryInitialize", new Object[0]);
            if (!(5 == ug9.b.getInt("key_cp_v", 5))) {
                d.obtainMessage(102).sendToTarget();
                return;
            }
            c();
            FunAdConfig funAdConfig = FunAdSdk.getFunAdConfig();
            xf9 b2 = ug9.b();
            dg9.a = ug9.l();
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(b2 != null);
            objArr[1] = Boolean.valueOf(z);
            LogPrinter.v("adConfig load immediately over, valid:%b parseAssets:%b", objArr);
            if (b2 == null) {
                if (z) {
                    d.obtainMessage(101).sendToTarget();
                    return;
                }
                LogPrinter.d("tryInitialize failed without valid adConfig.", new Object[0]);
                am9 am9Var = f;
                synchronized (am9Var.b) {
                    am9Var.d = -1;
                    while (!am9Var.c.isEmpty()) {
                        am9.a pollFirst = am9Var.c.pollFirst();
                        if (!am9.f && pollFirst == null) {
                            throw new AssertionError();
                        }
                        pollFirst.c.onError(pollFirst.b.getSid());
                    }
                }
                return;
            }
            ll9 ll9Var = e;
            synchronized (ll9Var) {
                xf9 xf9Var = ll9Var.a;
                if (xf9Var != null) {
                    if (xf9Var.equals(b2)) {
                        LogPrinter.d("New AdConfig equals old one, give up updating it", new Object[0]);
                    } else {
                        xf9 xf9Var2 = ll9Var.a;
                        if (xf9Var2.a.size() == b2.a.size()) {
                            HashSet hashSet = new HashSet(b2.a);
                            for (Ssp ssp : xf9Var2.a) {
                                Iterator it = hashSet.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        z4 = false;
                                        continue;
                                        break;
                                    }
                                    Ssp ssp2 = (Ssp) it.next();
                                    if (ssp.type.equals(ssp2.type) && ssp.sspId.equals(ssp2.sspId)) {
                                        it.remove();
                                        z4 = true;
                                        continue;
                                        break;
                                    }
                                }
                                if (!z4) {
                                }
                            }
                            z3 = true;
                            if (!z3) {
                                LogPrinter.d("New AdConfig.ssps don't correspond to old ones, give up updating it", new Object[0]);
                            }
                        }
                        z3 = false;
                        if (!z3) {
                        }
                    }
                    z2 = false;
                }
                xf9 xf9Var3 = ll9Var.a;
                ll9Var.a(xf9Var3 == null ? null : xf9Var3.b, b2.b, new vg9(ll9Var));
                xf9 xf9Var4 = ll9Var.a;
                ll9Var.a(xf9Var4 == null ? null : xf9Var4.c, b2.c, new kl9(ll9Var));
                ll9Var.a = b2;
                z2 = true;
            }
            if (!z2) {
                LogPrinter.d("Do not need to reset FunAdFactory.", new Object[0]);
                return;
            }
            HostAppInfo.updateCfgv(ug9.b.getLong("key_config_v", 0L));
            if (g) {
                return;
            }
            g = true;
            pf9 pf9Var = pf9.a;
            if (Looper.myLooper() != Looper.getMainLooper()) {
                throw new RuntimeException("Wrong thread");
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis();
            for (Ssp ssp3 : b2.a) {
                if (!TextUtils.isEmpty(ssp3.sspId)) {
                    if (funAdConfig.forbiddenPlatforms.contains(ssp3.type)) {
                        Object[] objArr2 = new Object[1];
                        objArr2[c3] = ssp3.type;
                        LogPrinter.d("Ssp:%s is not initialized for type is forbidden", objArr2);
                    } else {
                        long currentTimeMillis2 = System.currentTimeMillis();
                        String str2 = ssp3.type;
                        str2.hashCode();
                        int hashCode = str2.hashCode();
                        if (hashCode == 3160) {
                            if (str2.equals(FunAdSdk.PLATFORM_BZ)) {
                                c2 = 0;
                                if (c2 == 0) {
                                }
                                if (str == null) {
                                }
                                c3 = 0;
                            }
                            c2 = 65535;
                            if (c2 == 0) {
                            }
                            if (str == null) {
                            }
                            c3 = 0;
                        } else if (hashCode == 3175) {
                            if (str2.equals(FunAdSdk.PLATFORM_CJ)) {
                                c2 = 1;
                                if (c2 == 0) {
                                }
                                if (str == null) {
                                }
                                c3 = 0;
                            }
                            c2 = 65535;
                            if (c2 == 0) {
                            }
                            if (str == null) {
                            }
                            c3 = 0;
                        } else if (hashCode != 3178) {
                            if (hashCode == 98810 && str2.equals(FunAdSdk.PLATFORM_CSJ)) {
                                c2 = 3;
                                str = c2 == 0 ? c2 != 1 ? c2 != 2 ? c2 != 3 ? null : "com.fun.ad.sdk.channel.CsjModule" : "com.fun.ad.sdk.channel.CMModule" : "com.fun.ad.sdk.channel.CjModule" : "com.fun.ad.sdk.channel.BzModule";
                                if (str == null) {
                                    LogPrinter.d("sdk for %s init start", ssp3.type);
                                    dg9.f(ssp3.type, str, funAdConfig, hashMap, ssp3.sspId);
                                    LogPrinter.d("sdk for %s init end, used time :%s", ssp3.type, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                                } else {
                                    arrayList.add(ssp3);
                                }
                                c3 = 0;
                            }
                            c2 = 65535;
                            if (c2 == 0) {
                            }
                            if (str == null) {
                            }
                            c3 = 0;
                        } else {
                            if (str2.equals(FunAdSdk.PLATFORM_CM)) {
                                c2 = 2;
                                if (c2 == 0) {
                                }
                                if (str == null) {
                                }
                                c3 = 0;
                            }
                            c2 = 65535;
                            if (c2 == 0) {
                            }
                            if (str == null) {
                            }
                            c3 = 0;
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                dg9.e(currentTimeMillis, pf9Var, funAdConfig, hashMap);
            } else {
                new Thread(new cg9(arrayList, funAdConfig, hashMap, currentTimeMillis, pf9Var)).start();
            }
        }
    }
}
