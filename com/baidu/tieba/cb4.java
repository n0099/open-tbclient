package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.searchbox.v8engine.FontParser;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.binding.model.JSTypeMismatchException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cb4 extends bb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fj2 b;

    /* loaded from: classes5.dex */
    public class a extends ResponseCallback<hb4> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jb4 a;
        public final /* synthetic */ c42 b;
        public final /* synthetic */ cb4 c;

        /* renamed from: com.baidu.tieba.cb4$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0257a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ hb4 a;
            public final /* synthetic */ a b;

            public RunnableC0257a(a aVar, hb4 hb4Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, hb4Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = hb4Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    he4.call(this.b.b, true, this.a);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
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
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.a;
                    he4.call(aVar.b, false, aVar.a);
                }
            }
        }

        public a(cb4 cb4Var, jb4 jb4Var, c42 c42Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cb4Var, jb4Var, c42Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cb4Var;
            this.a = jb4Var;
            this.b = c42Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(hb4 hb4Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, hb4Var, i) == null) {
                if (bb4.a) {
                    Log.d("CheckAdvisedToRestApi", "on success");
                }
                this.c.b.post(new RunnableC0257a(this, hb4Var));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: b */
        public hb4 parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, response, i)) == null) {
                ResponseBody body = response.body();
                if (body == null) {
                    return null;
                }
                String string = body.string();
                if (bb4.a) {
                    Log.d("CheckAdvisedToRestApi", "parse response: " + string);
                }
                JSONObject jSONObject = new JSONObject(string);
                String optString = jSONObject.optString("errno");
                if (!TextUtils.equals(optString, "0")) {
                    if (bb4.a) {
                        Log.d("CheckAdvisedToRestApi", "errno = " + optString);
                    }
                    jb4 jb4Var = this.a;
                    jb4Var.errNo = optString;
                    jb4Var.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", jSONObject.optString("errmsg"));
                    return null;
                }
                String optString2 = jSONObject.optJSONObject("data").optString("result");
                hb4 hb4Var = new hb4();
                hb4Var.result = !TextUtils.equals(optString2, "0");
                hb4Var.errNo = "0";
                hb4Var.errMsg = he4.b("checkIsUserAdvisedToRest", DnsModel.MSG_OK);
                return hb4Var;
            }
            return (hb4) invokeLI.objValue;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, exc) == null) {
                if (bb4.a) {
                    Log.e("CheckAdvisedToRestApi", "on fail");
                }
                if (TextUtils.isEmpty(this.a.errMsg)) {
                    jb4 jb4Var = this.a;
                    jb4Var.errNo = YYOption.UrlProtocol.USER;
                    jb4Var.errMsg = String.format("%s: fail Error: %s", "checkIsUserAdvisedToRest", exc.getMessage());
                }
                this.c.b.post(new b(this));
            }
        }
    }

    public cb4(@NonNull fj2 fj2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fj2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = fj2Var;
    }

    @JavascriptInterface
    public void checkIsUserAdvisedToRest(JsObject jsObject) {
        c42 F;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jsObject) == null) && (F = c42.F(jsObject)) != null && this.b != null) {
            jb4 jb4Var = new jb4();
            try {
                int d = F.d("todayPlayedTime");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ma_id", vb3.g0());
                    jSONObject.put("todayPlayedTime", String.valueOf(d));
                } catch (JSONException e) {
                    if (bb4.a) {
                        e.printStackTrace();
                    }
                }
                a(m84.b().f(), jSONObject.toString(), new a(this, jb4Var, F));
            } catch (JSTypeMismatchException e2) {
                if (bb4.a) {
                    e2.printStackTrace();
                }
                jb4Var.errNo = FontParser.sFontWeightDefault;
                jb4Var.errMsg = he4.a("checkIsUserAdvisedToRest", e2);
                he4.call(F, false, jb4Var);
            }
        }
    }
}
