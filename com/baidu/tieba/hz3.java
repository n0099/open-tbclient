package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.eo3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.Protocol;
import com.baidubce.auth.DefaultBceSessionCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.baidubce.services.bos.model.PutObjectRequest;
import com.baidubce.services.bos.model.PutObjectResponse;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.HttpDate;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes6.dex */
public class hz3 implements eo3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eo3.a a;
        public final /* synthetic */ String b;

        public a(hz3 hz3Var, eo3.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hz3Var, aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            eo3.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, exc) == null) && (aVar = this.a) != null) {
                aVar.c(null, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            eo3.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) && (aVar = this.a) != null) {
                aVar.c(jSONObject, this.b);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                if (response != null && response.body() != null) {
                    String string = response.body().string();
                    hz3.f(response, System.currentTimeMillis());
                    return new JSONObject(string);
                }
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947840968, "Lcom/baidu/tieba/hz3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947840968, "Lcom/baidu/tieba/hz3;");
                return;
            }
        }
        a = ms1.a;
    }

    public hz3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            return is4.d((str + System.currentTimeMillis() + str2).getBytes(), false);
        }
        return (String) invokeLL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return context.getExternalCacheDir() + File.separator + "favor_screenshot" + File.separator;
        }
        return (String) invokeL.objValue;
    }

    public static RequestBody e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("oname_list", jSONArray);
                return RequestBody.create(j33.a, jSONObject.toString());
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (RequestBody) invokeL.objValue;
    }

    public static void f(Response response, long j) {
        Date parse;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(65541, null, response, j) == null) {
            String header = response.header("Date");
            if (!TextUtils.isEmpty(header) && (parse = HttpDate.parse(header)) != null) {
                long time = parse.getTime();
                if (time >= 1) {
                    long j2 = j - time;
                    qk3.a().putLong("server_time_delta", j2);
                    if (a) {
                        Log.i("getServerTimeDelta", "deltaTime sDate:" + parse + "  sTime:" + time + "   diff:" + j2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.eo3
    public boolean a(String str, w13 w13Var) {
        InterceptResult invokeLL;
        PutObjectResponse putObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, w13Var)) == null) {
            if (!TextUtils.isEmpty(str) && w13Var != null && !TextUtils.isEmpty(w13Var.a) && !TextUtils.isEmpty(w13Var.b) && !TextUtils.isEmpty(w13Var.c) && !TextUtils.isEmpty(w13Var.f)) {
                try {
                    BosClientConfiguration bosClientConfiguration = new BosClientConfiguration();
                    bosClientConfiguration.setCredentials(new DefaultBceSessionCredentials(w13Var.a, w13Var.b, w13Var.c));
                    bosClientConfiguration.setEndpoint("bj.bcebos.com");
                    bosClientConfiguration.setProtocol(Protocol.HTTPS);
                    BosClient bosClient = new BosClient(bosClientConfiguration);
                    File file = new File(str);
                    if (file.exists() && (putObject = bosClient.putObject(new PutObjectRequest(w13Var.d, w13Var.f, file))) != null) {
                        if (!TextUtils.isEmpty(putObject.getETag())) {
                            return true;
                        }
                    }
                } catch (Exception e) {
                    if (a) {
                        e.printStackTrace();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.eo3
    public void b(Context context, String str, eo3.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, aVar) == null) && context != null && !TextUtils.isEmpty(str)) {
            String v = y82.v(jv2.o().e());
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            for (Map.Entry<String, String> entry : x82.b().d.entrySet()) {
                v = up3.a(v, entry.getKey(), entry.getValue());
            }
            String c = c(d(context), str.substring(str.lastIndexOf(".")));
            RequestBody e = e(c);
            if (e == null) {
                return;
            }
            fj4 fj4Var = new fj4(v, e, new a(this, aVar, c));
            if (gj4.g().c()) {
                fj4Var.f = true;
            }
            fj4Var.g = false;
            fj4Var.c = hashMap;
            gj4.g().e(fj4Var);
        }
    }
}
