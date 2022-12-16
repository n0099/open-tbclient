package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.browser.core.async.BdRunnable;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import java.io.IOException;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fs5 {
    public static /* synthetic */ Interceptable $ic;
    public static final String b;
    public static final String c;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* loaded from: classes4.dex */
    public interface b {
        void a(JSONObject jSONObject);
    }

    /* loaded from: classes4.dex */
    public class a extends BdRunnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map c;
        public final /* synthetic */ String d;
        public final /* synthetic */ fs5 e;

        /* renamed from: com.baidu.tieba.fs5$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0283a extends BdRunnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ JSONObject c;
            public final /* synthetic */ a d;

            public C0283a(a aVar, JSONObject jSONObject) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, jSONObject};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = aVar;
                this.c = jSONObject;
            }

            @Override // com.baidu.browser.core.async.BdRunnable
            public void b() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.d.e.a.a(this.c);
                }
            }
        }

        public a(fs5 fs5Var, Map map, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs5Var, map, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = fs5Var;
            this.c = map;
            this.d = str;
        }

        @Override // com.baidu.browser.core.async.BdRunnable
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                MediaType parse = MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE);
                JSONObject jSONObject = new JSONObject();
                try {
                    this.e.d(this.c);
                    this.e.f(this.c, jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody create = RequestBody.create(parse, String.valueOf(jSONObject));
                Response response = null;
                try {
                    response = okHttpClient.newCall(new Request.Builder().url(this.d).post(create).build()).execute();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    jw.f().h(new C0283a(this, new JSONObject(response.body().string())));
                } catch (IOException e3) {
                    e3.printStackTrace();
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        String str;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947774721, "Lcom/baidu/tieba/fs5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947774721, "Lcom/baidu/tieba/fs5;");
                return;
            }
        }
        if (vq4.e()) {
            str = "http://";
        } else {
            str = "https://";
        }
        b = str;
        c = b + "afdconf.baidu.com/afd/download";
    }

    public fs5(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = bVar;
    }

    public void g(Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, map, str) == null) {
            jw.f().g(new a(this, map, str));
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (BdNetTypeUtil.isWifiNet()) {
                return UtilHelper.getWifiMac(TbadkCoreApplication.getInst().getApp());
            }
            return UtilHelper.getGprsIpAddress();
        }
        return (String) invokeV.objValue;
    }

    public final Map<String, String> d(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, map)) == null) {
            map.put("_client_version", TbConfig.getVersion());
            map.put("uid", TbadkCoreApplication.getCurrentAccount());
            map.put("cuid", TbadkCoreApplication.getInst().getCuidGalaxy2());
            map.put("ua", al5.b());
            String e = pj0.c().e(false);
            if (!TextUtils.isEmpty(e)) {
                map.put("model", e);
            }
            String h = pj0.c().h(false);
            if (!TextUtils.isEmpty(h)) {
                map.put("_os_version", h);
            }
            String b2 = pj0.c().b(false);
            if (!TextUtils.isEmpty(b2)) {
                map.put("imei", b2);
            }
            String a2 = pj0.c().a(false);
            if (!TextUtils.isEmpty(a2)) {
                map.put(HttpRequest.ANDROID_ID, a2);
            }
            map.put(HttpRequest.CLIENT_TYPE, "2");
            map.put("nt", String.valueOf(BdNetTypeUtil.netType()));
            map.put("ip", e());
            map.put("ssl", "1");
            return map;
        }
        return (Map) invokeL.objValue;
    }

    public final JSONObject f(Map<String, String> map, JSONObject jSONObject) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map, jSONObject)) == null) {
            if (em7.f(map)) {
                return jSONObject;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.putOpt(entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
