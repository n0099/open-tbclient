package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.tieba.f83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public class b64 extends HttpManager {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b64 a;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b64() {
        super(br2.c());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static b64 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (b64.class) {
                    if (a == null) {
                        a = new b64();
                    }
                }
            }
            return a;
        }
        return (b64) invokeV.objValue;
    }

    public static b64 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            b64 b64Var = new b64();
            b64Var.setHttpDnsEnable(a().getHttpDnsEnable());
            return b64Var;
        }
        return (b64) invokeV.objValue;
    }

    public void call(Request request, List<Interceptor> list, Callback callback) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048576, this, request, list, callback) != null) || request == null) {
            return;
        }
        OkHttpClient.Builder newBuilder = getOkHttpClient().newBuilder();
        if (list != null && !list.isEmpty()) {
            for (Interceptor interceptor : list) {
                if (interceptor != null) {
                    newBuilder.addInterceptor(interceptor);
                }
            }
        }
        newBuilder.build().newCall(request).enqueue(callback);
    }

    public void call(Request request, Callback callback) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, callback) == null) && request != null) {
            getOkHttpClient().newCall(request).enqueue(callback);
        }
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        InterceptResult invokeV;
        f83.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (u73.M() == null) {
                return super.initClient();
            }
            o74 o74Var = (o74) u73.M().T();
            OkHttpClient.Builder newBuilder = super.initClient().newBuilder();
            int i = 60000;
            if (o74Var != null && (aVar = o74Var.a) != null) {
                i = aVar.a;
                newBuilder.connectTimeout(aVar.b, TimeUnit.MILLISECONDS);
                newBuilder.addNetworkInterceptor(new nz2());
            }
            long j = i;
            newBuilder.readTimeout(j, TimeUnit.MILLISECONDS);
            newBuilder.writeTimeout(j, TimeUnit.MILLISECONDS);
            OkHttpClient build = newBuilder.build();
            build.dispatcher().setMaxRequests(10);
            return build;
        }
        return (OkHttpClient) invokeV.objValue;
    }
}
