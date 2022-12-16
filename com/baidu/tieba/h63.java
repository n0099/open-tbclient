package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h63 extends i63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements xf2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e43 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ h63 e;

        public a(h63 h63Var, e43 e43Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h63Var, e43Var, callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = h63Var;
            this.a = e43Var;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
            this.d = str;
        }

        @Override // com.baidu.tieba.xf2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.e.d) {
                    w33 f = w33.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f139f);
                    f.l(2);
                    f.G();
                }
                this.e.n(this.c, this.b, this.d);
            }
        }

        @Override // com.baidu.tieba.xf2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (this.e.d && !z) {
                    w33 f = w33.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f015f);
                    f.l(2);
                    f.G();
                }
                this.e.n(this.c, this.b, this.d);
            }
        }

        @Override // com.baidu.tieba.xf2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e) {
                    if (ok1.a) {
                        e.printStackTrace();
                    }
                }
                if (this.e.d) {
                    i63.m("1", "btn", "success");
                    cb2.t();
                    if (ut2.k(this.a.w())) {
                        ut2.p("addmyswan", yh3.n().e());
                    } else {
                        Context applicationContext = this.a.getApplicationContext();
                        w33 g = w33.g(applicationContext, ln2.l0().f(applicationContext));
                        g.l(2);
                        g.q(2);
                        g.G();
                    }
                }
                UnitedSchemeUtility.safeCallback(this.b, this.c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h63(b53 b53Var) {
        super(b53Var, "/swanAPI/addFavor");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b53Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((b53) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.i63
    public boolean j(e43 e43Var, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        String optString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, e43Var, unitedSchemeEntity)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(param);
                if (this.d) {
                    optString = e43Var.O();
                } else {
                    optString = jSONObject.optString("appid");
                }
                this.c = optString;
                return !TextUtils.isEmpty(optString);
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.i63
    public void k(e43 e43Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e43Var, unitedSchemeEntity, callbackHandler, str) == null) {
            PMSAppInfo u = bc4.i().u(this.c);
            if (u != null && !TextUtils.isEmpty(u.appId)) {
                if (this.d) {
                    i63.m("1", "btn", "invoke");
                } else {
                    i63.m("1", "api", "invoke");
                }
                SwanFavorDataManager.h().b(this.c, new a(this, e43Var, callbackHandler, unitedSchemeEntity, str));
                return;
            }
            n(unitedSchemeEntity, callbackHandler, str);
        }
    }

    @Override // com.baidu.tieba.i63
    public void l(e43 e43Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        to1 l0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, e43Var, unitedSchemeEntity, callbackHandler, str) == null) && this.d && (l0 = ln2.l0()) != null) {
            l0.g(e43Var);
        }
    }
}
