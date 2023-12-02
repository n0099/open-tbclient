package com.baidu.tieba;

import android.net.http.Headers;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsArrayBuffer;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpMethod;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.json.JSONException;
/* loaded from: classes5.dex */
public class b54 extends q44 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> h;
    public static final Set<String> i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ r44 d;
        public final /* synthetic */ b54 e;

        public a(b54 b54Var, String str, long j, String str2, r44 r44Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b54Var, str, Long.valueOf(j), str2, r44Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = b54Var;
            this.a = str;
            this.b = j;
            this.c = str2;
            this.d = r44Var;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                this.d.cancelTag(this.e.c);
                this.e.V(this.a, 0, iOException.getMessage(), this.b);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                if (!response.isSuccessful()) {
                    this.e.V(this.a, response.code(), response.message(), this.b);
                    return;
                }
                try {
                    JSEvent jSEvent = new JSEvent("headersReceived");
                    jSEvent.data = new d54(this.e.H(response.headers()));
                    this.e.dispatchEvent(jSEvent);
                } catch (JSONException e) {
                    if (q44.e) {
                        e.printStackTrace();
                    }
                }
                String str = this.c;
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 3556653) {
                    if (hashCode == 1154818009 && str.equals("arraybuffer")) {
                        c = 0;
                    }
                } else if (str.equals("text")) {
                    c = 1;
                }
                if (c != 0) {
                    this.e.W(this.a, response);
                } else {
                    this.e.U(this.a, response);
                }
                int code = response.code();
                String message = response.message();
                if (q44.e) {
                    Log.d("RequestTask", "onResponse: id:" + this.e.c + ",respCode: " + code + ", url=" + this.a + ", msg=" + message);
                }
                dd3.O(code, this.a, 1, message, this.b, System.currentTimeMillis());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947595944, "Lcom/baidu/tieba/b54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947595944, "Lcom/baidu/tieba/b54;");
                return;
            }
        }
        h = Sets.newHashSet("text", "arraybuffer");
        i = Sets.newHashSet(HttpOptions.METHOD_NAME, "GET", "HEAD", "POST", HttpPut.METHOD_NAME, HttpDelete.METHOD_NAME, HttpTrace.METHOD_NAME, "CONNECT");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b54(ud2 ud2Var, sy1 sy1Var) {
        super(ud2Var, sy1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ud2Var, sy1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ud2) objArr2[0], (sy1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 1;
    }

    public void start() {
        Request Q;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || this.b == null || (Q = Q()) == null) {
            return;
        }
        S(Q);
    }

    @Override // com.baidu.tieba.q44
    public void B(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i2, str2) == null) {
            super.B(str, i2, str2);
            e74.h(str, i2, str2, SwanAppNetworkUtils.i(null));
        }
    }

    @NonNull
    public static String T(@NonNull sy1 sy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, sy1Var)) == null) {
            String lowerCase = sy1Var.C("responseType").toLowerCase(Locale.US);
            if (!h.contains(lowerCase)) {
                return "text";
            }
            return lowerCase;
        }
        return (String) invokeL.objValue;
    }

    public final Request Q() {
        InterceptResult invokeV;
        RequestBody R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String y = y();
            if (TextUtils.isEmpty(y)) {
                if (q44.e) {
                    Log.d("RequestTask", "buildRequest url =" + y);
                }
                return null;
            }
            String C = this.b.C("method");
            if (TextUtils.isEmpty(C)) {
                C = "GET";
            }
            String upperCase = C.toUpperCase(Locale.US);
            if (!i.contains(upperCase)) {
                B(y, -1, "request:method is invalid");
                return null;
            }
            HashMap hashMap = new HashMap();
            Request.Builder builder = new Request.Builder();
            boolean z = true;
            F(builder, this.b.x("header"), hashMap, true);
            if (q44.e) {
                Log.d("RequestTask", "lowerCaseHeaderMap =" + hashMap);
            }
            Object D = this.b.D("data", null);
            if (D == null) {
                D = this.b.u("data", null);
            }
            if (D == null) {
                z = false;
            }
            if (z && !HttpMethod.permitsRequestBody(upperCase)) {
                return builder.url(y).method(upperCase, null).tag(this.c).build();
            }
            if (!z && !HttpMethod.requiresRequestBody(upperCase)) {
                R = null;
            } else {
                R = R(D, hashMap);
            }
            if (HttpMethod.requiresRequestBody(upperCase) && R == null) {
                return null;
            }
            return builder.url(y).method(upperCase, R).tag(this.c).build();
        }
        return (Request) invokeV.objValue;
    }

    @Nullable
    public final RequestBody R(Object obj, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, map)) == null) {
            String str = map.get(Headers.CONTENT_TYPE);
            MediaType mediaType = rx2.a;
            if (!TextUtils.isEmpty(str)) {
                mediaType = MediaType.parse(str);
            }
            if (obj instanceof JsArrayBuffer) {
                byte[] buffer = ((JsArrayBuffer) obj).buffer();
                if (buffer == null) {
                    return RequestBody.create(mediaType, "");
                }
                return RequestBody.create(mediaType, buffer);
            } else if (obj instanceof String) {
                if (q44.e) {
                    Log.d("RequestTask", "createBody = " + obj);
                }
                return RequestBody.create(mediaType, (String) obj);
            } else {
                return RequestBody.create(mediaType, "");
            }
        }
        return (RequestBody) invokeLL.objValue;
    }

    public final void W(String str, Response response) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, str, response) != null) || response == null) {
            return;
        }
        ResponseBody body = response.body();
        try {
            c54 c54Var = new c54();
            c54Var.statusCode = response.code();
            c54Var.header = H(response.headers());
            if (body != null) {
                c54Var.data = body.string();
                if (q44.e) {
                    Log.d("RequestTask", "onStringResponse = " + c54Var.data);
                }
            }
            C(c54Var);
        } catch (IOException | JSONException e) {
            if (q44.e) {
                Log.d("RequestTask", Log.getStackTraceString(e));
            }
            B(str, -1, e.getMessage());
        }
    }

    public void S(Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, request) == null) {
            String T2 = T(this.b);
            String httpUrl = request.url().toString();
            if (k63.M() == null) {
                B("", -1, "request:swanApp is null");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            dd3.B(httpUrl, 1, null);
            r44 r44Var = (r44) k63.M().j0();
            r44Var.b(request, new a(this, httpUrl, currentTimeMillis, T2, r44Var));
        }
    }

    public final void U(String str, Response response) {
        byte[] bytes;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, str, response) != null) || response == null) {
            return;
        }
        try {
            z44 z44Var = new z44();
            z44Var.statusCode = response.code();
            z44Var.header = H(response.headers());
            ResponseBody body = response.body();
            if (body != null && (bytes = body.bytes()) != null) {
                z44Var.data = new JsArrayBuffer(bytes, bytes.length);
            }
            C(z44Var);
        } catch (IOException | JSONException e) {
            if (q44.e) {
                Log.d("RequestTask", Log.getStackTraceString(e));
            }
            B(str, -1, e.getMessage());
        }
    }

    public final void V(String str, int i2, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i2), str2, Long.valueOf(j)}) == null) {
            if (q44.e) {
                Log.d("RequestTask", "onFailure: " + str2);
            }
            if ("Canceled".equalsIgnoreCase(str2)) {
                str2 = "request:fail abort";
            }
            String str3 = str2;
            B(str, i2, str3);
            if (SwanAppNetworkUtils.i(null)) {
                dd3.O(i2, str, 1, str3, j, System.currentTimeMillis());
            }
        }
    }
}
