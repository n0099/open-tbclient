package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.hh3;
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class ge3 extends zd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public boolean d;

    public abstract boolean j(cc3 cc3Var, UnitedSchemeEntity unitedSchemeEntity);

    public abstract void k(cc3 cc3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str);

    public void l(cc3 cc3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, cc3Var, unitedSchemeEntity, callbackHandler, str) == null) {
        }
    }

    public boolean o(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, unitedSchemeEntity)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    /* loaded from: classes5.dex */
    public class a implements vq3<fh3<hh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ cc3 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ ge3 e;

        public a(ge3 ge3Var, CallbackHandler callbackHandler, String str, cc3 cc3Var, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ge3Var, callbackHandler, str, cc3Var, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ge3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = cc3Var;
            this.d = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.vq3
        /* renamed from: b */
        public void a(fh3<hh3.e> fh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fh3Var) == null) {
                if (!ah3.h(fh3Var)) {
                    ah3.q(fh3Var, this.a, this.b);
                    this.e.l(this.c, this.d, this.a, this.b);
                    return;
                }
                this.e.k(this.c, this.d, this.a, this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ge3(zc3 zc3Var, String str) {
        super(zc3Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zc3Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = false;
    }

    public static void m(String str, String str2, String str3) {
        cc3 b0;
        String str4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65537, null, str, str2, str3) != null) || (b0 = cc3.b0()) == null) {
            return;
        }
        ej3 ej3Var = new ej3();
        zw2.a W = b0.W();
        ej3Var.a = vi3.n(W.G());
        ej3Var.e = str3;
        ej3Var.b = DI.BD.FAVOR;
        ej3Var.f = b0.O();
        SwanCoreVersion j0 = W.j0();
        String Z = b0.Z();
        if (j0 != null) {
            str4 = j0.swanCoreVersionName;
        } else {
            str4 = "";
        }
        ej3Var.a("appName", Z);
        ej3Var.a("isFavor", str);
        ej3Var.a("favorBy", str2);
        ej3Var.a("swan", str4);
        ji3.i("2571", "89", ej3Var.f());
    }

    @Override // com.baidu.tieba.zd3
    public final boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, cc3 cc3Var) {
        InterceptResult invokeLLLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, cc3Var)) == null) {
            if (cc3Var == null) {
                c92.c("favorite", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (zd3.b) {
                    Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
                }
                return false;
            }
            JSONObject d = cp3.d(unitedSchemeEntity.getParam("params"));
            String optString = d.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                c92.c("favorite", "none cb");
                if (zd3.b) {
                    Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            this.d = d.optBoolean("isFavorButton", false);
            if (!j(cc3Var, unitedSchemeEntity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, IActiveUploadListener.PARAM_ERR_MSG);
                return false;
            }
            String optString2 = d.optString("slaveId");
            String S = px2.T().S();
            if (TextUtils.equals(optString2, px2.T().C()) && (TextUtils.equals(S, "pages/swan-news-showcase/index") || TextUtils.equals(S, "pages/swan-operate-news/index"))) {
                k(cc3Var, unitedSchemeEntity, callbackHandler, optString);
            } else if (!o(unitedSchemeEntity)) {
                lg3 e0 = cc3Var.e0();
                if (this.d) {
                    str = "scope_favorite_button";
                } else {
                    str = "mapp_favorite";
                }
                e0.g(context, str, new a(this, callbackHandler, optString, cc3Var, unitedSchemeEntity));
            } else {
                k(cc3Var, unitedSchemeEntity, callbackHandler, optString);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public void n(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "0");
            } catch (JSONException e) {
                if (ms1.a) {
                    e.printStackTrace();
                }
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        }
    }
}
