package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.setting.oauth.OAuthException;
import com.baidu.tieba.zc3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ec3 extends r93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements nm3<xc3<zc3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ec3 d;

        public a(ec3 ec3Var, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ec3Var, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ec3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(xc3<zc3.e> xc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, xc3Var) != null) {
                return;
            }
            this.d.k(this.a, this.b, this.c, xc3Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947729492, "Lcom/baidu/tieba/ec3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947729492, "Lcom/baidu/tieba/ec3;");
                return;
            }
        }
        boolean z = eo1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ec3(r83 r83Var) {
        super(r83Var, "/swanAPI/authorize");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r83Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.r93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u73 u73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u73Var)) == null) {
            if (u73Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                cr2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null").toString());
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams");
                cr2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty joParams").toString());
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb");
                cr2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty cb").toString());
                return false;
            }
            String c = uc3.c(optParamsAsJo.optString("scope"));
            if (TextUtils.isEmpty(c)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope");
                cr2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty scope").toString());
                return false;
            }
            u73Var.e0().c(context, c, false, new a(this, callbackHandler, c, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a9, code lost:
        r8 = 10001;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(CallbackHandler callbackHandler, String str, String str2, xc3<zc3.e> xc3Var) {
        String str3;
        int i;
        String message;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, str, str2, xc3Var) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("scope", uc3.d(str));
                if (xc3Var != null && xc3Var.a != null) {
                    if (!xc3Var.c()) {
                        OAuthException a2 = xc3Var.a();
                        if (a2 == null) {
                            message = "";
                        } else {
                            message = a2.getMessage();
                        }
                        jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, message);
                        callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(xc3Var.b()).toString());
                        cr2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, xc3Var.b()).toString());
                        return;
                    }
                    jSONObject.put("code", xc3Var.a.a);
                    if (xc3Var.a.b) {
                        str3 = "authorize:ok";
                    } else {
                        str3 = "user deny";
                    }
                    jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, str3);
                    if (xc3Var.a.b) {
                        i = 0;
                    } else {
                        i = 10003;
                    }
                    callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i).toString());
                    if (!xc3Var.a.b) {
                        cr2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, xc3Var.b()).toString());
                        return;
                    }
                    return;
                }
                int b = xc3Var.b();
                sc3.k("empty auth result", Boolean.TRUE);
                jSONObject.put(StatConstants.KEY_EXT_ERR_MSG, sc3.f(b));
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b).toString());
                sc3.t("AuthorizeAction", "null == result || null == result.mData");
                cr2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b).toString());
            } catch (JSONException unused) {
                sc3.k("json exception", Boolean.TRUE);
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(10001, "internal error").toString());
                cr2.j().d(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 10001, "internal error").toString());
            }
        }
    }
}
