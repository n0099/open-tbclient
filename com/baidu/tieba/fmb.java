package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.common.security.DeviceInfoIPCServiceManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.jni.TtsLogLoad;
import com.baidubce.AbstractBceClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class fmb {
    public static /* synthetic */ Interceptable $ic;
    public static OkHttpClient a;
    public static volatile String b;
    public static volatile String c;
    public static List<String> d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Call a;

        public a(Call call) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {call};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = call;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947770350, "Lcom/baidu/tieba/fmb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947770350, "Lcom/baidu/tieba/fmb;");
                return;
            }
        }
        d = new ArrayList();
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < d.size(); i++) {
                jSONArray.put(d.get(i));
            }
            return jSONArray.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (!TextUtils.isEmpty(c)) {
                return c;
            }
            if (context != null) {
                try {
                    c = context.getPackageName();
                } catch (Throwable unused) {
                }
            }
            return c;
        }
        return (String) invokeL.objValue;
    }

    public static void f(List<xlb> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, list) == null) {
            d.clear();
            for (int i = 0; i < list.size(); i++) {
                d.add(list.get(i).a);
            }
        }
    }

    public static void c(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            try {
                JSONObject h = h(context, str);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "test_tool_data");
                jSONObject.put(HttpConstants.OS_VERSION, amb.b(context).get(4).h());
                if (str.equals("test_tool_slot_info")) {
                    jSONObject.put("adslot_id_list", a());
                }
                e(context, h, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void d(Context context, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str, str2, str3, str4) == null) {
            try {
                JSONObject h = h(context, str);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "test_tool_data");
                jSONObject.put(HttpConstants.OS_VERSION, amb.b(context).get(4).h());
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("adslot_id", str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("aid", str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    jSONObject.put("cid", str4);
                }
                e(context, h, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void e(Context context, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, context, jSONObject, jSONObject2) == null) {
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put("event_extra", jSONObject2.toString());
            jSONArray.put(jSONObject);
            jSONObject3.put("stats_list", jSONArray);
            i(context, zlb.e(jSONObject3).toString());
        }
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            if (TextUtils.isEmpty(b) && context != null) {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(b(context), 0);
                    String.valueOf(packageInfo.versionCode);
                    b = packageInfo.versionName;
                } catch (Throwable unused) {
                }
            }
            return b;
        }
        return (String) invokeL.objValue;
    }

    public static JSONObject h(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            List<ulb> b2 = amb.b(context);
            try {
                jSONObject.put("ad_sdk_version", b2.get(0).h());
                jSONObject.put("appid", b2.get(2).h());
                jSONObject.put("type", str);
                jSONObject.put("app_version", g(context));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("package_name", b2.get(1).h());
                jSONObject2.put(TtsLogLoad.KEY_OS, 1);
                jSONObject2.put("oaid", b2.get(7).h());
                jSONObject2.put("model", Build.MODEL);
                jSONObject2.put("imei", b2.get(6).h());
                jSONObject2.put("vendor", Build.MANUFACTURER);
                jSONObject2.put("applog_did", dmb.d(context));
                jSONObject.put(DeviceInfoIPCServiceManager.IPC_SERVICE_NAME, jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void i(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, str) == null) {
            if (a == null) {
                a = new OkHttpClient.Builder().build();
            }
            OkHttpClient okHttpClient = a;
            Request.Builder builder = new Request.Builder();
            new Thread(new a(okHttpClient.newCall(builder.url("https://" + dmb.c(context) + "/api/ad/union/sdk/stats/batch/").post(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), str)).build()))).start();
        }
    }
}
