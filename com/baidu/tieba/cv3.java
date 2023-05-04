package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.tieba.zj3;
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
/* loaded from: classes4.dex */
public class cv3 implements zj3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zj3.a a;
        public final /* synthetic */ String b;

        public a(cv3 cv3Var, zj3.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cv3Var, aVar, str};
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
            zj3.a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, exc) == null) && (aVar = this.a) != null) {
                aVar.c(null, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            zj3.a aVar;
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
                    cv3.f(response, System.currentTimeMillis());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947688169, "Lcom/baidu/tieba/cv3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947688169, "Lcom/baidu/tieba/cv3;");
                return;
            }
        }
        a = ho1.a;
    }

    public cv3() {
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
            return do4.d((str + System.currentTimeMillis() + str2).getBytes(), false);
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
                return RequestBody.create(ez2.a, jSONObject.toString());
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
                    lg3.a().putLong("server_time_delta", j2);
                    if (a) {
                        Log.i("getServerTimeDelta", "deltaTime sDate:" + parse + "  sTime:" + time + "   diff:" + j2);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tieba.zj3
    public boolean a(String str, rx2 rx2Var) {
        InterceptResult invokeLL;
        PutObjectResponse putObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, rx2Var)) == null) {
            if (!TextUtils.isEmpty(str) && rx2Var != null && !TextUtils.isEmpty(rx2Var.a) && !TextUtils.isEmpty(rx2Var.b) && !TextUtils.isEmpty(rx2Var.c) && !TextUtils.isEmpty(rx2Var.f)) {
                try {
                    BosClientConfiguration bosClientConfiguration = new BosClientConfiguration();
                    bosClientConfiguration.setCredentials(new DefaultBceSessionCredentials(rx2Var.a, rx2Var.b, rx2Var.c));
                    bosClientConfiguration.setEndpoint("bj.bcebos.com");
                    bosClientConfiguration.setProtocol(Protocol.HTTPS);
                    BosClient bosClient = new BosClient(bosClientConfiguration);
                    File file = new File(str);
                    if (file.exists() && (putObject = bosClient.putObject(new PutObjectRequest(rx2Var.d, rx2Var.f, file))) != null) {
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

    @Override // com.baidu.tieba.zj3
    public void b(Context context, String str, zj3.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, str, aVar) == null) && context != null && !TextUtils.isEmpty(str)) {
            String v = t42.v(er2.o().e());
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            for (Map.Entry<String, String> entry : s42.b().d.entrySet()) {
                v = pl3.a(v, entry.getKey(), entry.getValue());
            }
            String c = c(d(context), str.substring(str.lastIndexOf(".")));
            RequestBody e = e(c);
            if (e == null) {
                return;
            }
            af4 af4Var = new af4(v, e, new a(this, aVar, c));
            if (bf4.g().c()) {
                af4Var.f = true;
            }
            af4Var.g = false;
            af4Var.c = hashMap;
            bf4.g().e(af4Var);
        }
    }
}
