package com.baidu.tieba;

import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpCommonRequestBuilder;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tieba.pr1;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpMethod;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class at1 extends ss1 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set f;
    public static final Set g;
    public static final Set h;
    public static final Set i;
    public static final List j;
    public static final String[] k;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface f {
        void a(JSONObject jSONObject);
    }

    @Override // com.baidu.tieba.pr1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? "RequestApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements pr1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at1 a;

        public a(at1 at1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = at1Var;
        }

        @Override // com.baidu.tieba.pr1.a
        public mv1 a(m33 m33Var, JSONObject jSONObject, String str) {
            InterceptResult invokeLLL;
            qa4 g;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, m33Var, jSONObject, str)) == null) {
                String optString = jSONObject.optString("cancelTag");
                if (TextUtils.isEmpty(optString)) {
                    return new mv1(202, "illegal cancelTag");
                }
                at1 at1Var = this.a;
                at1Var.q("#cancelRequest cancelTag=" + optString, false);
                if (at1.j.remove(optString)) {
                    g = qa4.l();
                } else {
                    g = qa4.g();
                }
                SwanAppNetworkUtils.a(g.getOkHttpClient(), optString);
                return mv1.f();
            }
            return (mv1) invokeLLL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m33 a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ at1 e;

        public b(at1 at1Var, m33 m33Var, JSONObject jSONObject, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at1Var, m33Var, jSONObject, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = at1Var;
            this.a = m33Var;
            this.b = jSONObject;
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.e.N(this.a, this.b, this.c, this.d);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ HttpUrl b;
        public final /* synthetic */ String c;
        public final /* synthetic */ int d;
        public final /* synthetic */ long e;
        public final /* synthetic */ e f;

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        public c(at1 at1Var, String str, HttpUrl httpUrl, String str2, int i, long j, e eVar, HttpRequest httpRequest) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at1Var, str, httpUrl, str2, Integer.valueOf(i), Long.valueOf(j), eVar, httpRequest};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = httpUrl;
            this.c = str2;
            this.d = i;
            this.e = j;
            this.f = eVar;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                fa3.C(this.c, this.d, null, this.e, System.currentTimeMillis(), this.a);
                if (exc instanceof IOException) {
                    this.f.onFailure(null, (IOException) exc);
                } else {
                    this.f.onFailure(null, new IOException("request fail"));
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i, NetworkStatRecord networkStatRecord) throws Exception {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, response, i, networkStatRecord)) == null) {
                w82.k().C(this.a, this.b, networkStatRecord);
                fa3.C(this.c, this.d, networkStatRecord, this.e, System.currentTimeMillis(), this.a);
                this.f.onResponse(null, response);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ at1 b;

        public d(at1 at1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = at1Var;
            this.a = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.b.d(this.a, new mv1(1001, str));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public m33 a;
        public JSONObject b;
        public String c;
        public String d;
        public f e;
        public String f;
        public long g;
        public final /* synthetic */ at1 h;

        public e(at1 at1Var, m33 m33Var, JSONObject jSONObject, String str, String str2, f fVar, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {at1Var, m33Var, jSONObject, str, str2, fVar, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = at1Var;
            this.a = m33Var;
            this.b = jSONObject;
            this.c = str;
            this.d = str2;
            this.e = fVar;
            this.f = str3;
            this.g = System.currentTimeMillis();
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            qa4 g;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                int G = this.a.Y().G();
                String l = fa3.l();
                String e = gh3.n().e();
                if (at1.j.remove(this.d)) {
                    g = qa4.l();
                } else {
                    g = qa4.g();
                }
                SwanAppNetworkUtils.a(g.getOkHttpClient(), this.d);
                this.h.d(this.f, new mv1(1001, iOException.getMessage()));
                fa3.Q(0, this.c, G, iOException.getMessage(), l, e, this.g, System.currentTimeMillis(), this.d);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!fa3.o(this.c)) {
                    ic3.l().x(this.c, response.headers("Set-cookie"));
                }
                String J = at1.J(this.b);
                String L = at1.L(this.b);
                int G = this.a.Y().G();
                long currentTimeMillis = System.currentTimeMillis();
                String l = fa3.l();
                String e = gh3.n().e();
                try {
                    long K = at1.K(response);
                    if (K <= Config.FULL_TRACE_LOG_LIMIT) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("statusCode", response.code());
                        jSONObject.put("header", bt1.g(response.headers()));
                        at1.R(jSONObject, response.body(), J, L);
                        if (this.e != null) {
                            this.e.a(jSONObject);
                        }
                        this.h.d(this.f, new mv1(0, jSONObject, true));
                    } else {
                        this.h.d(this.f, new mv1(201, "response json length over limits"));
                        at1.S(this.a, this.c, K, currentTimeMillis);
                    }
                } catch (IOException | JSONException e2) {
                    this.h.d(this.f, new mv1(201, e2.getMessage()));
                }
                fa3.Q(response.code(), this.c, G, response.message(), l, e, this.g, System.currentTimeMillis(), this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947626603, "Lcom/baidu/tieba/at1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947626603, "Lcom/baidu/tieba/at1;");
                return;
            }
        }
        f = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
        g = Sets.newHashSet("json", EMABTest.TYPE_STRING);
        h = Sets.newHashSet("text", "arraybuffer");
        i = Sets.newHashSet("REFERER");
        j = Collections.synchronizedList(new ArrayList());
        k = new String[]{"https://hmma.baidu.com/mini.gif", "https://eclick.baidu.com/", "https://miniapp-ad.cdn.bcebos.com/", "https://mobads.baidu.com/", "https://als.baidu.com/", "https://wn.pos.baidu.com/"};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at1(nr1 nr1Var) {
        super(nr1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {nr1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((nr1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static mv1 Y(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65554, null, i2)) == null) {
            String str = "illegal request";
            int i3 = 202;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 == 4) {
                                str = "HTTP method is invalid";
                            }
                        } else {
                            str = "request:fail parameter error: arrayBuffer of data exceed size limit.";
                        }
                    } else {
                        str = "request url header must be https or wss";
                    }
                }
            } else {
                i3 = 0;
                str = "";
            }
            if (TextUtils.isEmpty(str)) {
                return new mv1(i3);
            }
            return new mv1(i3, str);
        }
        return (mv1) invokeI.objValue;
    }

    public static void A(HttpRequestBuilder httpRequestBuilder, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, httpRequestBuilder, str, str2) != null) || fa3.o(str)) {
            return;
        }
        String f2 = ic3.l().f(str, str2);
        if (!TextUtils.isEmpty(f2)) {
            httpRequestBuilder.setHeader("Cookie", f2);
        }
    }

    public static HttpUrl B(HttpUrl httpUrl, Object obj, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, httpUrl, obj, str)) == null) {
            HttpUrl.Builder newBuilder = httpUrl.newBuilder();
            if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
                try {
                    obj = new JSONObject((String) obj);
                } catch (JSONException unused) {
                }
            }
            if (!(obj instanceof JSONObject)) {
                return httpUrl;
            }
            boolean z = false;
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    String optString = jSONObject.optString(next);
                    if (TextUtils.isEmpty(optString)) {
                        optString = "";
                    }
                    newBuilder.addQueryParameter(next, optString);
                    z = true;
                }
            }
            if (z) {
                return newBuilder.build();
            }
            return httpUrl;
        }
        return (HttpUrl) invokeLLL.objValue;
    }

    public static RequestBody G(Object obj, Map map, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, obj, map, str)) == null) {
            String str2 = (String) map.get(Headers.CONTENT_TYPE);
            String str3 = "";
            if (TextUtils.isEmpty(str2)) {
                if (obj instanceof byte[]) {
                    return F(tu2.a, (byte[]) obj);
                }
                MediaType mediaType = tu2.a;
                if (obj != null) {
                    str3 = obj.toString();
                }
                return RequestBody.create(mediaType, str3);
            }
            MediaType parse = MediaType.parse(str2);
            if (tu2.a.equals(parse)) {
                if (obj instanceof byte[]) {
                    return F(tu2.a, (byte[]) obj);
                }
                MediaType mediaType2 = tu2.a;
                if (obj != null) {
                    str3 = obj.toString();
                }
                return RequestBody.create(mediaType2, str3);
            }
            return H(obj, parse, str);
        }
        return (RequestBody) invokeLLL.objValue;
    }

    public static RequestBody H(Object obj, MediaType mediaType, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, obj, mediaType, str)) == null) {
            FormBody.Builder builder = new FormBody.Builder();
            if (obj instanceof byte[]) {
                return F(mediaType, (byte[]) obj);
            }
            if (TextUtils.equals("JSONToString", str) && (obj instanceof String)) {
                try {
                    obj = new JSONObject((String) obj);
                } catch (JSONException unused) {
                }
            }
            if (obj != null && obj.toString().length() != 0) {
                if (obj instanceof String) {
                    return RequestBody.create(mediaType, (String) obj);
                }
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj;
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            builder.add(next, jSONObject.optString(next));
                        }
                    }
                }
                return ru2.a(builder.build(), mediaType);
            }
            return builder.build();
        }
        return (RequestBody) invokeLLL.objValue;
    }

    public final mv1 U(m33 m33Var, JSONObject jSONObject, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, m33Var, jSONObject, str)) == null) {
            String optString = jSONObject.optString("url");
            if (TextUtils.isEmpty(optString)) {
                p("#request illegal url", new Exception("stack"), true);
                return new mv1(1001, "illegal url");
            }
            q("#request url=" + optString, false);
            String a2 = bt1.a(m33Var.b);
            JSONObject c2 = bt1.c(a2);
            yu1.d().c(new hv1(this, m33Var, jSONObject, a2, str));
            return new mv1(0, c2);
        }
        return (mv1) invokeLLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair C(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        qa4 g2;
        int i2;
        HttpUrl httpUrl;
        boolean z;
        HttpUrl httpUrl2;
        RequestBody G;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject, str)) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                HttpUrl f2 = bt1.f(jSONObject.optString("url"));
                if (f2 == null) {
                    return new Pair(null, 0);
                }
                String httpUrl3 = f2.toString();
                if (kx2.a() == 1) {
                    String[] strArr = k;
                    int length = strArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            if (httpUrl3.startsWith(strArr[i3])) {
                                z2 = true;
                                break;
                            }
                            i3++;
                        } else {
                            z2 = false;
                            break;
                        }
                    }
                    if (z2) {
                        j.add(str);
                    }
                    if (z2) {
                        g2 = qa4.l();
                    } else {
                        g2 = qa4.g();
                    }
                } else {
                    g2 = qa4.g();
                }
                String optString = jSONObject.optString("__plugin__");
                boolean optBoolean = jSONObject.optBoolean("ping", false);
                if (!optBoolean) {
                    i2 = d43.c("request", httpUrl3, optString);
                    if (i2 != 0) {
                        return new Pair(null, Integer.valueOf(i2));
                    }
                } else {
                    i2 = 0;
                }
                String optString2 = jSONObject.optString("method");
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = "GET";
                }
                String upperCase = optString2.toUpperCase();
                if (!f.contains(upperCase)) {
                    return new Pair(null, 4);
                }
                HashMap hashMap = new HashMap();
                pa4 pa4Var = new pa4();
                pa4Var.b = upperCase;
                HttpRequestBuilder b2 = ra4.b(pa4Var, g2);
                W(httpUrl3, b2, jSONObject.optJSONObject("header"), hashMap);
                b2.setHeader("Referer", bt1.d());
                if (!TextUtils.isEmpty(optString)) {
                    b2.setHeader("X-SWAN-HOSTSIGN", jz2.b(kz2.h(optString)));
                }
                String optString3 = jSONObject.optString("__requestDataType__");
                Object Q = Q(jSONObject, optString3);
                if (Q instanceof byte[]) {
                    httpUrl = f2;
                    if (((byte[]) Q).length > Config.FULL_TRACE_LOG_LIMIT) {
                        return new Pair(null, 3);
                    }
                } else {
                    httpUrl = f2;
                }
                if (Q != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && !HttpMethod.permitsRequestBody(upperCase)) {
                    httpUrl2 = B(httpUrl, Q, optString3);
                } else {
                    httpUrl2 = httpUrl;
                    if (z || HttpMethod.requiresRequestBody(upperCase)) {
                        G = G(Q, hashMap, optString3);
                        if (!HttpMethod.requiresRequestBody(upperCase) && G == null) {
                            return new Pair(null, Integer.valueOf(i2));
                        }
                        if (b2 instanceof HttpCommonRequestBuilder) {
                            ((HttpCommonRequestBuilder) b2).requestBody(G);
                        }
                        pa4Var.a = httpUrl2.toString();
                        pa4Var.f = X();
                        pa4Var.g = false;
                        pa4Var.h = true;
                        pa4Var.i = str;
                        pa4Var.k = 3;
                        g2.u(b2, pa4Var);
                        HttpRequest build = b2.build();
                        if (!optBoolean) {
                            build = ev2.e(build, "request", optString);
                        }
                        w82.k().r(str, httpUrl2);
                        return new Pair(build, Integer.valueOf(i2));
                    }
                }
                G = null;
                if (!HttpMethod.requiresRequestBody(upperCase)) {
                }
                if (b2 instanceof HttpCommonRequestBuilder) {
                }
                pa4Var.a = httpUrl2.toString();
                pa4Var.f = X();
                pa4Var.g = false;
                pa4Var.h = true;
                pa4Var.i = str;
                pa4Var.k = 3;
                g2.u(b2, pa4Var);
                HttpRequest build2 = b2.build();
                if (!optBoolean) {
                }
                w82.k().r(str, httpUrl2);
                return new Pair(build2, Integer.valueOf(i2));
            }
            return new Pair(null, 0);
        }
        return (Pair) invokeLL.objValue;
    }

    public static RequestBody F(MediaType mediaType, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, mediaType, bArr)) == null) {
            return RequestBody.create(mediaType, bArr);
        }
        return (RequestBody) invokeLL.objValue;
    }

    public static String J(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jSONObject)) == null) {
            String optString = jSONObject.optString("dataType");
            if (TextUtils.isEmpty(optString)) {
                return "json";
            }
            if (!g.contains(optString)) {
                return EMABTest.TYPE_STRING;
            }
            return optString;
        }
        return (String) invokeL.objValue;
    }

    public static long K(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, response)) == null) {
            if (response.body() != null) {
                return response.body().contentLength();
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public static String L(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) {
            String optString = jSONObject.optString("responseType");
            if (!h.contains(optString)) {
                return "text";
            }
            return optString;
        }
        return (String) invokeL.objValue;
    }

    public static boolean O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.trim().startsWith(PreferencesUtil.LEFT_MOUNT);
        }
        return invokeL.booleanValue;
    }

    public mv1 D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#cancelRequest", false);
            return l(str, false, new a(this));
        }
        return (mv1) invokeL.objValue;
    }

    public static boolean P(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if ((!str.trim().startsWith("{") || !str.trim().endsWith("}")) && (!str.trim().startsWith(PreferencesUtil.LEFT_MOUNT) || !str.trim().endsWith(PreferencesUtil.RIGHT_MOUNT))) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static Object Q(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, jSONObject, str)) == null) {
            Object opt = jSONObject.opt("data");
            if (TextUtils.equals(str, "base64")) {
                if (opt instanceof String) {
                    return Base64.decode((String) opt, 2);
                }
                return opt;
            } else if (opt instanceof JsArrayBuffer) {
                return ((JsArrayBuffer) opt).buffer();
            } else {
                return opt;
            }
        }
        return invokeLL.objValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v7, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r6v9, types: [org.json.JSONArray] */
    public static void R(JSONObject jSONObject, ResponseBody responseBody, String str, String str2) throws IOException, JSONException {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65550, null, jSONObject, responseBody, str, str2) != null) || responseBody == null) {
            return;
        }
        char c2 = 65535;
        int hashCode = str2.hashCode();
        if (hashCode != 3556653) {
            if (hashCode == 1154818009 && str2.equals("arraybuffer")) {
                c2 = 0;
            }
        } else if (str2.equals("text")) {
            c2 = 1;
        }
        if (c2 != 0) {
            str3 = responseBody.string();
        } else {
            byte[] bytes = responseBody.bytes();
            if (bytes == null) {
                str3 = null;
            } else {
                str3 = new String(Base64.encode(bytes, 2));
            }
            str = EMABTest.TYPE_STRING;
        }
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if (TextUtils.equals(str, "json")) {
            try {
                if (P(str3)) {
                    if (O(str3)) {
                        str4 = new JSONArray(str3);
                    } else {
                        str4 = new JSONObject(str3);
                    }
                    str3 = str4;
                }
            } catch (JSONException unused) {
            }
        }
        jSONObject.put("data", str3);
    }

    public static void W(String str, HttpRequestBuilder httpRequestBuilder, JSONObject jSONObject, Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65552, null, str, httpRequestBuilder, jSONObject, map) == null) {
            if (jSONObject != null && jSONObject.length() >= 1) {
                Iterator<String> keys = jSONObject.keys();
                String str2 = "";
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next) && !i.contains(next.toUpperCase())) {
                        String f2 = gh3.f(jSONObject.optString(next));
                        if (TextUtils.isEmpty(f2)) {
                            f2 = "";
                        }
                        if (map != null) {
                            map.put(next.toLowerCase(), f2);
                        }
                        if ("Cookie".equalsIgnoreCase(next)) {
                            str2 = f2;
                        }
                        httpRequestBuilder.addHeader(next, f2);
                    }
                }
                A(httpRequestBuilder, str, str2);
                return;
            }
            A(httpRequestBuilder, str, "");
        }
    }

    public static void S(m33 m33Var, String str, long j2, long j3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{m33Var, str, Long.valueOf(j2), Long.valueOf(j3)}) == null) && m33Var != null && !TextUtils.isEmpty(str) && j2 >= 0) {
            ff3 ff3Var = new ff3();
            ff3Var.k(5L);
            ff3Var.i(39L);
            na3 na3Var = new na3();
            na3Var.p(ff3Var);
            na3Var.r(m33Var.W());
            na3Var.q(fa3.n(l33.K().k()));
            na3Var.m(l33.K().getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exceptionUrl", str);
                jSONObject.put("exceptionAppID", m33Var.O());
                jSONObject.put("exceptionLength", j2);
                jSONObject.put("exceptionRequestTime", j3);
                jSONObject.put("exceptionResponseTime", System.currentTimeMillis());
                na3Var.e(jSONObject);
            } catch (JSONException unused) {
            }
            fa3.R(na3Var);
        }
    }

    public static boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            m33 M = m33.M();
            if (M != null && M.e0().f("mapp_set_user_agent")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean E(m33 m33Var, JSONObject jSONObject, String str, String str2, f fVar, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{m33Var, jSONObject, str, str2, fVar, str3})) == null) {
            return tm2.e().i(m33Var, jSONObject, str, str2, new e(this, m33Var, jSONObject, str, str2, fVar, str3), new d(this, str3));
        }
        return invokeCommon.booleanValue;
    }

    public void I(m33 m33Var, JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, m33Var, jSONObject, str, str2) == null) {
            if (nx2.i()) {
                N(m33Var, jSONObject, str, str2);
            } else {
                ExecutorUtilsExt.postOnElastic(new b(this, m33Var, jSONObject, str, str2), "doRequest", 0);
            }
        }
    }

    public final void M(m33 m33Var, JSONObject jSONObject, HttpRequest httpRequest, String str, f fVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{m33Var, jSONObject, httpRequest, str, fVar, str2}) == null) {
            HttpUrl url = httpRequest.getOkRequest().url();
            String httpUrl = url.toString();
            if (E(m33Var, jSONObject, httpUrl, str, fVar, str2)) {
                return;
            }
            httpRequest.executeStat(new c(this, str, url, httpUrl, m33Var.Y().G(), System.currentTimeMillis(), new e(this, m33Var, jSONObject, httpUrl, str, fVar, str2), httpRequest));
        }
    }

    public final void N(m33 m33Var, JSONObject jSONObject, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, m33Var, jSONObject, str, str2) == null) {
            Pair C = C(jSONObject, str);
            HttpRequest httpRequest = (HttpRequest) C.first;
            if (httpRequest == null) {
                d(str2, Y(((Integer) C.second).intValue()));
            } else {
                M(m33Var, jSONObject, httpRequest, str, null, str2);
            }
        }
    }

    public mv1 T(JsObject jsObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jsObject)) == null) {
            Pair t = pr1.t(jsObject);
            if (!((lv1) t.first).isSuccess()) {
                p("#request parseParams fail", null, false);
                return (mv1) t.first;
            }
            JSONObject jSONObject = (JSONObject) t.second;
            if (jSONObject == null) {
                p("#request params parsed as JSONObject is null", null, true);
                return (mv1) lv1.a;
            }
            m33 M = m33.M();
            if (M == null) {
                p("#request swan app is null", null, false);
                return new mv1(1001, "swan app is null");
            }
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("#request cb is empty", null, true);
                return new mv1(1001, "cb is empty");
            }
            return U(M, jSONObject, optString);
        }
        return (mv1) invokeL.objValue;
    }

    public mv1 V(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, jSONObject)) == null) {
            m33 b0 = m33.b0();
            if (b0 == null) {
                p("#request swan app is null", null, false);
                return new mv1(1001, "swan app is null");
            }
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                p("#request cb is empty", null, true);
                return new mv1(202, "cb is empty");
            }
            return U(b0, jSONObject, optString);
        }
        return (mv1) invokeL.objValue;
    }
}
