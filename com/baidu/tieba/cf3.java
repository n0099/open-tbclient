package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.ecommerce.activity.AddressEditActivity;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cf3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ SwanInterfaceType e;

        public a(int i, String str, String str2, String str3, SwanInterfaceType swanInterfaceType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, str2, str3, swanInterfaceType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = swanInterfaceType;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                if (i != 2000 && i != 0) {
                    z = true;
                } else {
                    z = false;
                }
                String n = qe3.n(w73.K().k());
                JSONObject jSONObject = new JSONObject();
                xk3.f(jSONObject, BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, w73.K().getAppId());
                xk3.f(jSONObject, "hostName", er2.n().a());
                xk3.f(jSONObject, "network", yn4.e());
                xk3.f(jSONObject, "launchid", w73.K().q().W().V());
                if (z) {
                    xk3.f(jSONObject, "response", this.b);
                    xk3.f(jSONObject, HiAnalyticsConstant.HaKey.BI_KEY_RESULT, this.c);
                    xk3.f(jSONObject, "request_url", this.d);
                }
                cf3.d(n, this.e.getClassify(), this.e.getInterfaceName(), this.a, jSONObject, z);
            }
        }
    }

    public static void a(SwanInterfaceType swanInterfaceType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, swanInterfaceType) == null) {
            c(swanInterfaceType, 2000, null, null);
        }
    }

    public static void b(SwanInterfaceType swanInterfaceType, int i, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{swanInterfaceType, Integer.valueOf(i), str, str2, str3}) == null) {
            rk3.j(new a(i, str3, str2, str, swanInterfaceType), "onInterfaceStabilityStatistic");
        }
    }

    public static void c(SwanInterfaceType swanInterfaceType, int i, String str, Response response) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65538, null, swanInterfaceType, i, str, response) == null) {
            String str3 = null;
            if (response != null) {
                String valueOf = String.valueOf(response.code());
                str3 = response.request().url().toString();
                str2 = valueOf;
            } else {
                str2 = null;
            }
            b(swanInterfaceType, i, str3, str2, str);
        }
    }

    public static void d(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, str2, str3, Integer.valueOf(i), jSONObject, Boolean.valueOf(z)}) == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("from", str);
                jSONObject2.put("type", str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject2.put("page", str3);
                }
                jSONObject2.put("value", String.valueOf(i));
                if (jSONObject != null) {
                    jSONObject2.put("ext", jSONObject);
                }
                ee3.k("874", jSONObject2);
                if (z) {
                    ee3.i("2486", AddressEditActivity.CHINA_REGION_CODE, jSONObject2);
                }
            } catch (JSONException e) {
                if (x73.v) {
                    e.printStackTrace();
                }
            }
        }
    }
}
