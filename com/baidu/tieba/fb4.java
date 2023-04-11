package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes4.dex */
public class fb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
            }
        }

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
    }

    public static Map<String, String> a(@NonNull u73 u73Var, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, u73Var, i, str)) == null) {
            TreeMap treeMap = new TreeMap();
            treeMap.put(GameGuideConfigInfo.KEY_APP_KEY, u73Var.O());
            treeMap.put("to_app_key", str);
            treeMap.put("source", String.valueOf(i));
            treeMap.put("timestamp", c());
            StringBuilder sb = new StringBuilder();
            for (String str2 : treeMap.keySet()) {
                sb.append(str2);
                sb.append("=");
                sb.append((String) treeMap.get(str2));
                sb.append("&");
            }
            sb.append("dsb9Ao44");
            treeMap.put("sign", ao4.d(sb.toString().getBytes(), false));
            return treeMap;
        }
        return (Map) invokeLIL.objValue;
    }

    public static void b(int i, @NonNull ResponseCallback responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65537, null, i, responseCallback) == null) {
            u73 M = u73.M();
            if (M == null) {
                responseCallback.onFail(new Exception("framework error: swan app is null."));
                return;
            }
            M.i0().getRequest().cookieManager(br2.q().a()).url(l44.b().p()).addUrlParam(GameGuideConfigInfo.KEY_APP_KEY, M.O()).addUrlParam(Constants.EXTRA_CONFIG_LIMIT, String.valueOf(5)).addUrlParam("source", String.valueOf(i)).requestFrom(16).requestFrom(1607).build().executeAsync(responseCallback);
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return String.valueOf(System.currentTimeMillis() / 1000);
        }
        return (String) invokeV.objValue;
    }

    public static void d(int i, String str) {
        u73 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(65539, null, i, str) != null) || (M = u73.M()) == null) {
            return;
        }
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) M.i0().postFormRequest().cookieManager(br2.q().a())).url(l44.b().g())).addParams(a(M, i, str)).requestFrom(16)).requestFrom(1607)).build().executeAsync(new a());
    }
}
