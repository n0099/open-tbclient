package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.swan.game.ad.entity.AdResponseInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidubce.AbstractBceClient;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h04 implements yz3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Context b;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            }
        }

        public a(h04 h04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public String parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                if (response != null && response.body() != null) {
                    response.body().close();
                    return "";
                }
                return "";
            }
            return (String) invokeLI.objValue;
        }
    }

    public h04(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = context;
    }

    @Override // com.baidu.tieba.yz3
    public void a(String str, JSONObject jSONObject, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, jSONObject, responseCallback) == null) {
            boolean startsWith = str.startsWith("https://");
            this.a = startsWith;
            if (startsWith) {
                ((PostBodyRequest.PostBodyRequestBuilder) li4.g().postRequest().url(str)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(responseCallback);
            } else {
                ((PostBodyRequest.PostBodyRequestBuilder) li4.g().postRequest().url(str)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(responseCallback);
            }
        }
    }

    @Override // com.baidu.tieba.yz3
    public void b(String str, JSONObject jSONObject, ResponseCallback<qz3> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jSONObject, responseCallback) == null) {
            ((PostBodyRequest.PostBodyRequestBuilder) li4.g().postRequest().url(str)).requestBody(RequestBody.create(MediaType.parse(AbstractBceClient.DEFAULT_CONTENT_TYPE), jSONObject.toString())).build().executeAsync(responseCallback);
        }
    }

    @Override // com.baidu.tieba.yz3
    public void c(String str, ResponseCallback<zy3> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, responseCallback) == null) {
            boolean startsWith = str.startsWith("https://");
            this.a = startsWith;
            if (startsWith) {
                li4.g().getRequest().url(str).build().executeAsync(responseCallback);
            } else {
                li4.g().getRequest().url(str).build().executeAsync(responseCallback);
            }
        }
    }

    @Override // com.baidu.tieba.yz3
    public void f(String str, ResponseCallback<AdResponseInfo> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, responseCallback) == null) {
            boolean startsWith = str.startsWith("https://");
            this.a = startsWith;
            if (startsWith) {
                li4.g().getRequest().url(str).build().executeAsync(responseCallback);
            } else {
                li4.g().getRequest().url(str).build().executeAsync(responseCallback);
            }
        }
    }

    @Override // com.baidu.tieba.yz3
    public void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        ki4 ki4Var = new ki4();
        ki4Var.b = "POST";
        ki4Var.a = "https://pimlog.baidu.com/mapp/advlog";
        ki4Var.d = RequestBody.create(MediaType.get(AbstractBceClient.DEFAULT_CONTENT_TYPE), str);
        li4.g().e(ki4Var);
    }

    @Override // com.baidu.tieba.yz3
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            a aVar = new a(this);
            boolean startsWith = str.startsWith("https://");
            this.a = startsWith;
            if (startsWith) {
                li4.g().getRequest().url(str).build().executeAsync(aVar);
            } else {
                li4.g().getRequest().url(str).build().executeAsync(aVar);
            }
        }
    }
}
