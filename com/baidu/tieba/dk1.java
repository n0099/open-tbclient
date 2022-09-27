package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.q83;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dk1 extends i53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements ei3<o83<q83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l33 a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ UnitedSchemeEntity g;
        public final /* synthetic */ dk1 h;

        public a(dk1 dk1Var, l33 l33Var, Context context, boolean z, String str, CallbackHandler callbackHandler, String str2, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk1Var, l33Var, context, Boolean.valueOf(z), str, callbackHandler, str2, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = dk1Var;
            this.a = l33Var;
            this.b = context;
            this.c = z;
            this.d = str;
            this.e = callbackHandler;
            this.f = str2;
            this.g = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(o83<q83.e> o83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o83Var) == null) {
                boolean e = this.a.N().e(this.b);
                if (!j83.h(o83Var)) {
                    if (!e && !this.c) {
                        ea3.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 5, this.d);
                    }
                    j83.q(o83Var, this.e, this.f);
                    return;
                }
                l02.i("chooseInvoiceTitle", OAuthResult.RESULT_MSG_SUCCESS);
                Context context = this.b;
                Context w = context instanceof Activity ? (Activity) context : this.a.w();
                if (w == null) {
                    UnitedSchemeUtility.safeCallback(this.e, this.g, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString(), this.f);
                    return;
                }
                if (e && !this.c) {
                    ea3.S("success", 5, this.d);
                }
                this.h.k(w, this.e, this.g, this.a, this.f, this.d);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ek1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ String c;

        public b(dk1 dk1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk1Var, callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = str;
        }

        @Override // com.baidu.tieba.ek1
        public void a(int i) {
            String jSONObject;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 1) {
                    l02.i("chooseInvoiceTitle", "choose invoice cancel");
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1002, "choose invoice cancel").toString();
                } else {
                    l02.i("chooseInvoiceTitle", "choose invoice failed");
                    jSONObject = UnitedSchemeUtility.wrapCallbackParams(1003, "choose invoice failed").toString();
                }
                UnitedSchemeUtility.safeCallback(this.a, this.b, jSONObject, this.c);
            }
        }

        @Override // com.baidu.tieba.ek1
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                l02.i("chooseInvoiceTitle", "choose success");
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.c);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dk1(i43 i43Var) {
        super(i43Var, "/swanAPI/chooseInvoiceTitle");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i43Var};
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
    }

    @Override // com.baidu.tieba.i53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, l33Var)) == null) {
            l02.i("chooseInvoiceTitle", "发票调起");
            if (l33Var == null) {
                l02.c("chooseInvoiceTitle", "empty swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            } else if (l33Var.n0()) {
                if (i53.b) {
                    Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    l02.c("chooseInvoiceTitle", "empty joParams");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    l02.c("chooseInvoiceTitle", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                String optString2 = optParamsAsJo.optString("invokeFrom");
                boolean e = l33Var.N().e(context);
                if (!e) {
                    ea3.S("show", 5, optString2);
                }
                l33Var.e0().h(context, "mapp_choose_invoice", j83.j(optParamsAsJo), new a(this, l33Var, context, e, optString2, callbackHandler, optString, unitedSchemeEntity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, l33 l33Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, callbackHandler, unitedSchemeEntity, l33Var, str, str2}) == null) {
            sm2.k0().a(context, l33Var.b, l33Var.O(), new b(this, callbackHandler, unitedSchemeEntity, str));
        }
    }
}
