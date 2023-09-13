package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c33 {
    public static /* synthetic */ Interceptable $ic;
    public static final String h;
    public static final MediaType i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Map<String, String> b;
    public Map<String, String> c;
    public boolean d;
    public JSONObject e;
    public b f;
    public ResponseCallback<JSONObject> g;

    /* loaded from: classes5.dex */
    public interface b {
        void onFail(String str);

        void onSuccess(JSONObject jSONObject);
    }

    /* loaded from: classes5.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c33 a;

        public a(c33 c33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c33Var;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                if (this.a.f == null) {
                    h82.i("IsBlockDomainRequest", "IsBlockDomainRequestCallback is empty and isblockdomain request failed : \n" + Log.getStackTraceString(exc));
                    return;
                }
                this.a.f.onFail(exc.getMessage());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (this.a.f == null) {
                    h82.i("IsBlockDomainRequest", "isblockdomain request success, but IsBlockDomainRequestCallback is empty.");
                } else if (jSONObject == null) {
                    this.a.f.onFail("response is empty");
                } else if (jSONObject.optInt("errno", -1) != 0) {
                    String optString = jSONObject.optString("tipmsg", "");
                    b bVar = this.a.f;
                    if (TextUtils.isEmpty(optString)) {
                        optString = "errno is non-zero";
                    }
                    bVar.onFail(optString);
                } else {
                    this.a.f.onSuccess(jSONObject.optJSONObject("data"));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                if (response != null && response.body() != null) {
                    return ho3.d(response.body().string());
                }
                return null;
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947623782, "Lcom/baidu/tieba/c33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947623782, "Lcom/baidu/tieba/c33;");
                return;
            }
        }
        boolean z = rr1.a;
        h = String.format("%s/ma/isblockdomain", b82.b());
        i = o23.a;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            String i2 = pk4.i(h);
            this.a = i2;
            this.a = d82.b(i2);
            String O = gb3.K().q().O();
            String str = this.a;
            if (TextUtils.isEmpty(O)) {
                O = "";
            }
            this.a = d82.a(str, "src_app", O);
        }
    }

    public c33() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = h;
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = false;
        this.e = new JSONObject();
        this.g = new a(this);
        e();
        f();
    }

    public void d(@NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f = bVar;
            c(this.g);
        }
    }

    public void g(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.e.put("url", str);
            this.d = true;
        } catch (JSONException unused) {
            h82.i("IsBlockDomainRequest", "set url need to check failed");
        }
    }

    public void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, str, str2) != null) || TextUtils.isEmpty(str) || str2 == null) {
            return;
        }
        this.b.put(str, str2);
    }

    public void c(@NonNull ResponseCallback<JSONObject> responseCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, responseCallback) == null) {
            if (!this.d) {
                responseCallback.onFail(new InvalidParameterException("error: invalid url"));
                return;
            }
            this.a = zo3.b(this.a, this.c);
            ki4 ki4Var = new ki4(this.a, RequestBody.create(i, this.e.toString()), responseCallback);
            ki4Var.c = this.b;
            ki4Var.g = true;
            h82.b("IsBlockDomainRequest", "start isblockdomain request : " + this.e);
            li4.g().e(ki4Var);
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            b("Referer", oo3.b());
        }
    }
}
