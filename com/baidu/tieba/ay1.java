package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ay1 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hb3 a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ay1 e;

        public a(ay1 ay1Var, hb3 hb3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ay1Var, hb3Var, unitedSchemeEntity, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ay1Var;
            this.a = hb3Var;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
            this.d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.C(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay1(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/adRequest");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ec3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.r23
    public boolean A(@NonNull hb3 hb3Var, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, hb3Var, unitedSchemeEntity, callbackHandler, str)) == null) {
            bo3.j(new a(this, hb3Var, unitedSchemeEntity, callbackHandler, str), "execRequest");
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void C(@NonNull hb3 hb3Var, @NonNull UnitedSchemeEntity unitedSchemeEntity, @NonNull CallbackHandler callbackHandler, @NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hb3Var, unitedSchemeEntity, callbackHandler, str) == null) {
            JSONObject a2 = ed3.a(unitedSchemeEntity, "params");
            String optString = a2.optString("cb");
            try {
                String optString2 = a2.optString("url");
                D(a2, optString2, zo3.q(optString2));
                unitedSchemeEntity.putParams("params", a2.toString());
                if (!super.A(hb3Var, unitedSchemeEntity, callbackHandler, str)) {
                    h82.c("AdRequest", "request fail");
                    callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            } catch (JSONException unused) {
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            }
        }
    }

    public final void D(JSONObject jSONObject, String str, boolean z) throws JSONException {
        HttpUrl parse;
        JSONObject optJSONObject;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str, z) != null) || jSONObject == null || TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null || (optJSONObject = jSONObject.optJSONObject("extParams")) == null) {
            return;
        }
        if (!z) {
            str2 = "";
        } else {
            str2 = o();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("header");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            j(optJSONObject2, str2);
            jSONObject.put("header", optJSONObject2);
        }
        if (ed3.b) {
            Log.d("AdRequestAction", "appendUrlQueryAndHeader: isBaiduDomain=" + z + ", cookie=" + str2);
        }
        HttpUrl.Builder newBuilder = parse.newBuilder();
        Iterator<String> keys = optJSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = optJSONObject.optString(next);
            if (TextUtils.equals(optString, "cuid")) {
                str3 = ou2.h0().i(ou2.c());
            } else if (!TextUtils.equals(optString, "baiduid") || !z) {
                str3 = "";
            } else {
                str3 = zo3.l(str2, "BAIDUID");
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            h82.i("AdRequest", "key=" + next + ", value=" + str3);
            newBuilder.addQueryParameter(next, str3);
        }
        jSONObject.put("url", newBuilder.build().toString());
    }
}
