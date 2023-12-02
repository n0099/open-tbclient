package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.v22;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bi3 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements v22.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ bi3 b;

        public a(bi3 bi3Var, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bi3Var, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bi3Var;
            this.a = callbackHandler;
        }

        @Override // com.baidu.tieba.v22.i
        public void a(String str, String str2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, jSONObject) == null) {
                this.b.k(str, str2, this.a, 0, jSONObject);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bi3(h73 h73Var) {
        super(h73Var, "/swanAPI/openTextarea");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var};
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

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, k63Var)) == null) {
            if (h83.b) {
                Log.d("OpenTextAreaAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            k32.i("OpenTextAreaAction", "OpenTextAreaAction paramsJson: " + optParamsAsJo);
            w22 w22Var = new w22();
            try {
                w22Var.a(optParamsAsJo);
            } catch (JSONException e) {
                e.printStackTrace();
                k32.d("OpenTextAreaAction", "model parse exception:", e);
            }
            SwanAppActivity activity = xr2.V().getActivity();
            if (activity == null) {
                k32.c("OpenTextAreaAction", "activity is null when add textarea");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "activity is null when add textarea");
                return false;
            }
            t52 W = xr2.V().W();
            if (W == null) {
                k32.c("OpenTextAreaAction", "fragmentManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragmentManager is null");
                return false;
            }
            s52 o = W.o();
            if (o == null) {
                k32.c("OpenTextAreaAction", "fragment is null when add input");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment is null when add input");
                return false;
            }
            c22 w = new v22(context, w22Var, activity, o, new a(this, callbackHandler)).w();
            if (!w.a()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, w.b);
                return false;
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler, int i, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, callbackHandler, Integer.valueOf(i), jSONObject}) == null) {
            k32.i("OpenTextAreaAction", "sendAsyncCallback, arg0: " + i + ", arg1: " + jSONObject);
            if (TextUtils.isEmpty(str2)) {
                d32.a("OpenTextAreaAction", "sendAsyncCallback with a empty callback");
            } else {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            }
        }
    }
}
