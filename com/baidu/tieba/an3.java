package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.tieba.oa4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
/* loaded from: classes3.dex */
public class an3<T> extends bn3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String d;
    public String e;
    public ResponseCallback<T> f;
    public int g;
    public oa4.a h;

    /* loaded from: classes3.dex */
    public class a extends ResponseCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public T a;
        public final /* synthetic */ an3 b;

        public a(an3 an3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {an3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = an3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                if (hm3.a) {
                    Log.d("BDTLS", "BdtlsPostRequest onSuccess=" + str);
                }
                if (TextUtils.equals(str, "recovery")) {
                    if (!nm3.l().m().b()) {
                        this.b.f.onFail(new Exception("Exceeded the limit of continuous downgrade"));
                        return;
                    }
                    nm3.l().m().a();
                    this.b.i(true);
                    this.b.p();
                    return;
                }
                nm3.l().m().k();
                an3 an3Var = this.b;
                if (!an3Var.a) {
                    if (an3Var.f != null) {
                        this.b.f.onSuccess(this.a, i);
                        this.b.g = 0;
                    }
                } else if (an3Var.b == 1) {
                    mm3.a(MimeTypes.BASE_TYPE_APPLICATION);
                    if (this.b.f != null) {
                        this.b.f.onSuccess(this.a, i);
                    }
                    this.b.g = 0;
                } else if (an3.m(an3Var) >= 3) {
                    ResponseCallback responseCallback = this.b.f;
                    responseCallback.onFail(new IOException("request fail : " + this.a));
                    this.b.g = 0;
                } else {
                    an3 an3Var2 = this.b;
                    an3Var2.q(an3Var2.d, this.b.e, this.b.f);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                if (hm3.a) {
                    Log.d("BDTLS", "BdtlsPostRequest onFail=" + exc.getMessage());
                }
                if (this.b.f != null) {
                    this.b.f.onFail(exc);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                Headers headers = response.headers();
                String str = headers.get("Bdtls");
                if (headers != null && TextUtils.equals(str, "recovery")) {
                    nm3.l().m().s(0);
                    return "recovery";
                }
                an3 an3Var = this.b;
                if (!an3Var.a) {
                    if (an3Var.f != null) {
                        this.a = (T) this.b.f.parseResponse(response, i);
                        return "";
                    }
                    return "";
                }
                ResponseBody body = response.body();
                String g = this.b.g(body.bytes());
                if (hm3.a) {
                    Log.d("BDTLS", "BdtlsPostRequest parseResponse=" + g);
                }
                if (this.b.b == 1) {
                    Buffer buffer = new Buffer();
                    buffer.writeString(g, Charset.forName(IMAudioTransRequest.CHARSET));
                    Response build = response.newBuilder().body(ResponseBody.create(body.contentType(), buffer.size(), buffer)).build();
                    if (this.b.f != null) {
                        this.a = (T) this.b.f.parseResponse(build, i);
                    }
                }
                return g;
            }
            return (String) invokeLI.objValue;
        }
    }

    public an3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public static /* synthetic */ int m(an3 an3Var) {
        int i = an3Var.g;
        an3Var.g = i + 1;
        return i;
    }

    @Override // com.baidu.tieba.bn3
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.bn3
    public void e(IOException iOException) {
        ResponseCallback<T> responseCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iOException) == null) || (responseCallback = this.f) == null) {
            return;
        }
        responseCallback.onFail(iOException);
    }

    @Override // com.baidu.tieba.bn3
    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            if (hm3.a) {
                Log.d("BDTLS", "onRequestError=" + i);
            }
            ResponseCallback<T> responseCallback = this.f;
            if (responseCallback != null) {
                responseCallback.onFail(new Exception("request error  code : " + i));
            }
        }
    }

    @Override // com.baidu.tieba.bn3
    public void h(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) {
            String str = this.d;
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            if (this.a) {
                hashMap.put("Bdtls", "Bdtls");
            }
            if (hm3.a) {
                Log.d("BDTLS", "BdtlsPostRequest url=" + str);
            }
            n83 a2 = sm2.q().a();
            PostByteRequest.PostByteRequestBuilder postByteRequest = pa4.g().postByteRequest();
            oa4.a aVar = this.h;
            if (aVar != null) {
                postByteRequest.connectionTimeout(aVar.a).readTimeout(this.h.b).writeTimeout(this.h.c);
            }
            postByteRequest.mediaType("application/json").url(str).cookieManager(a2).headers(hashMap).content(bArr).build().executeAsync(new a(this));
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            q(this.d, this.e, this.f);
        }
    }

    public void q(String str, String str2, ResponseCallback<T> responseCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048581, this, str, str2, responseCallback) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        this.d = str;
        this.e = str2;
        this.f = responseCallback;
        if (hm3.a) {
            Log.d("BDTLS", "requestPost url=" + str);
            Log.d("BDTLS", "requestPost body=" + str2);
        }
        a(this.e);
    }
}
