package com.baidu.tieba;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.anb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class hnb {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947830893, "Lcom/baidu/tieba/hnb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947830893, "Lcom/baidu/tieba/hnb;");
        }
    }

    /* loaded from: classes6.dex */
    public static class e extends qnb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        /* loaded from: classes6.dex */
        public class a implements anb.a<JSONObject> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.anb.a
            public final void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                }
            }

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.baidu.tieba.anb.a
            public final /* synthetic */ void a(JSONObject jSONObject) {
                rnb.a("status_updated");
            }
        }

        public e(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
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
        }

        @Override // com.baidu.tieba.qnb
        public final void a() {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || rnb.b("status_updated")) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("exids", this.a);
            anb.c(anb.d("http://absample.baidu.com/appabapp/appapi/updateStatus", hashMap), new a(this));
        }
    }

    /* loaded from: classes6.dex */
    public static class a implements anb.a<JSONArray> {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.anb.a
        public final /* synthetic */ void a(JSONArray jSONArray) {
            JSONArray jSONArray2 = jSONArray;
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray2.length(); i++) {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i);
                com.baidu.ubs.analytics.a.g gVar = new com.baidu.ubs.analytics.a.g();
                gVar.setGroup(optJSONObject.optString("group"));
                gVar.setId(optJSONObject.optString("id"));
                gVar.y(optJSONObject.optString("sid"));
                if (i > 0) {
                    stringBuffer.append("_");
                }
                stringBuffer.append(gVar.getId());
                arrayList.add(gVar);
            }
            nmb.i().c(arrayList);
            hnb.a(stringBuffer.toString());
        }

        @Override // com.baidu.tieba.anb.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                while (hnb.a < 2) {
                    synchronized (this) {
                        hnb.f();
                    }
                    hnb.c();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends qnb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(Context context) {
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
        }

        @Override // com.baidu.tieba.qnb
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hnb.k(this.a);
                if (nmb.i().j() != null && !nmb.i().j().equals("")) {
                    wnb.a("BaiDuAB sdk  init success");
                } else {
                    String h = hnb.h(nmb.i().g());
                    if (h == null || h.equals("")) {
                        wnb.b("SDK getToken Error do you have set correct  BAIDUAB_APPKEY in Manifest or network is available");
                        return;
                    }
                }
                hnb.d();
                hnb.c();
                pnb.b(new lnb(), gnb.e(), gnb.c());
                xnb.b();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements anb.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ Context b;

        public c(long j, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
            this.b = context;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.anb.a
        public final /* synthetic */ void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("token");
            if (optString != null && !optString.isEmpty()) {
                nmb.i().b(optString);
                rnb.f("token", optString);
                rnb.g("token_update_time", this.a);
                rnb.f("lastkey", hnb.i(this.b));
            }
        }

        @Override // com.baidu.tieba.anb.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                wnb.b("SDK getToken Error do you have set correct  BAIDUAB_APPKEY  in Manifest   or network is available");
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements anb.a<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
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

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.tieba.anb.a
        public final /* synthetic */ void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("cuid");
            if (TextUtils.isEmpty(optString)) {
                nmb.i().e("");
                return;
            }
            nmb.i().e(optString);
            rnb.f("cuid", optString);
        }

        @Override // com.baidu.tieba.anb.a
        public final void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) && str.equals("1")) {
                nmb.i().e("");
            }
        }
    }

    public static /* synthetic */ void a(String str) {
        pnb.a(new e(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(mmb mmbVar) {
        byte b2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, mmbVar) == null) {
            int g = mmbVar.g();
            if (g < 1000) {
                String e2 = jnb.e(mmbVar.a());
                int length = e2.length();
                int i2 = length << 1;
                byte[] bArr = new byte[i2];
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    char charAt = e2.charAt(i4);
                    int i5 = i3 + 1;
                    bArr[i3] = (byte) (charAt & 255);
                    i3 = i5 + 1;
                    bArr[i5] = (byte) (charAt >> '\b');
                }
                int i6 = (-1756908916) ^ i2;
                int i7 = i2 / 4;
                for (int i8 = 0; i8 < i7; i8++) {
                    int i9 = i8 * 4;
                    int i10 = ((bArr[i9 + 0] & 255) + ((bArr[i9 + 1] & 255) << 8) + ((bArr[i9 + 2] & 255) << 16) + ((bArr[i9 + 3] & 255) << 24)) * 1540483477;
                    i6 = (i6 * 1540483477) ^ (((i10 >>> 24) ^ i10) * 1540483477);
                }
                int i11 = i2 % 4;
                if (i11 == 3) {
                    int i12 = i2 & (-4);
                    i6 = (i6 ^ ((bArr[i12 + 2] & 255) << 16)) ^ ((bArr[i12 + 1] & 255) << 8);
                    b2 = bArr[i12];
                } else if (i11 == 2) {
                    int i13 = i2 & (-4);
                    i6 ^= (bArr[i13 + 1] & 255) << 8;
                    b2 = bArr[i13];
                } else {
                    if (i11 == 1) {
                        b2 = bArr[i2 & (-4)];
                    }
                    i = (i6 ^ (i6 >>> 13)) * 1540483477;
                    if (Math.abs((i ^ (i >>> 15)) % 1000) >= g) {
                        lmb.f(false);
                        return;
                    }
                }
                i6 = (i6 ^ (b2 & 255)) * 1540483477;
                i = (i6 ^ (i6 >>> 13)) * 1540483477;
                if (Math.abs((i ^ (i >>> 15)) % 1000) >= g) {
                }
            }
            nmb.i().a(mmbVar.a());
            lmb.f(true);
            wnb.g(mmbVar.b());
            onb.b(com.baidu.ubs.analytics.d.a.c() + "-进行一次 初始化   " + new Date().toLocaleString() + GlideException.IndentedAppendable.INDENT + j(mmbVar.a()));
            gnb.b(mmbVar.c());
            gnb.f(mmbVar.d());
            gnb.g(mmbVar.f());
            gnb.h(mmbVar.e());
            cnb.a(mmbVar.a());
            pnb.a(new b(mmbVar.a()));
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            if (TextUtils.isEmpty(nmb.i().k())) {
                d();
            }
            if (TextUtils.isEmpty(nmb.i().k())) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("package", nmb.i().g().getPackageName());
            hashMap.put("cuid", nmb.i().k());
            anb.c(anb.d("http://absample.baidu.com/appabapp/appapi/getgroup", hashMap), new a());
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            String e2 = rnb.e("cuid", "");
            if (!TextUtils.isEmpty(e2)) {
                onb.b("本地 取得  cuid~~");
                nmb.i().e(e2);
                return;
            }
            onb.b("网络请求  cuid~~");
            HashMap hashMap = new HashMap();
            hashMap.put("imei", jnb.g(nmb.i().g()));
            hashMap.put("mac", jnb.h(nmb.i().g()));
            anb.c(anb.d("http://absample.baidu.com/appabapp/appapi/getcuid", hashMap), new d());
        }
    }

    public static /* synthetic */ int f() {
        int i = a;
        a = i + 1;
        return i;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            String i = i(context);
            HashMap hashMap = new HashMap();
            hashMap.put("key", i);
            hashMap.put("package", context.getPackageName());
            anb.c(anb.d("http://absample.baidu.com/appabapp/appapi/gettoken", hashMap), new c(currentTimeMillis, context));
            return nmb.i().j();
        }
        return (String) invokeL.objValue;
    }

    public static String i(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            try {
                return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("BAIDUAB_APPKEY");
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String j(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager.getRunningAppProcesses() == null) {
                return DownloadStatisticConstants.UBC_VALUE_UNKNOW;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return DownloadStatisticConstants.UBC_VALUE_UNKNOW;
        }
        return (String) invokeL.objValue;
    }

    public static /* synthetic */ String k(Context context) {
        String e2 = rnb.e("lastkey", "");
        long c2 = rnb.c("token_update_time");
        if (e2.equals(i(context)) && c2 + 86400000 >= System.currentTimeMillis()) {
            String e3 = rnb.e("token", "");
            if (!e3.equals("")) {
                nmb.i().b(e3);
                return e3;
            }
        }
        return h(context);
    }
}
