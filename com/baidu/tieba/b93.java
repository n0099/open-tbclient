package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.y42;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes5.dex */
public class b93 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b93(m63 m63Var) {
        super(m63Var, "/swanAPI/navigateBack");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m63Var};
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

    @Override // com.baidu.tieba.m73
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        int optInt;
        pv2 pv2Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            if (m73.b) {
                Log.d("NavigateBackAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            vy2.b(uuid);
            String str2 = unitedSchemeEntity.getParams().get("params");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    optInt = new JSONObject(str2).optInt("delta", 1);
                } catch (JSONException e) {
                    if (m73.b) {
                        e.printStackTrace();
                    }
                    p22.c("navigateBack", "params parse fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
            } else {
                optInt = 1;
            }
            y42 W = cr2.V().W();
            if (W == null) {
                p22.c("navigateBack", "fragmentManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int k = W.k();
            if (m73.b) {
                Log.d("NavigateBackAction", "back delta: " + optInt);
            }
            if (k == 1) {
                p22.c("NavigateBackAction", "navigateBack api can only work when slave's count greater than 1");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "navigateBack api can only work when slave's count greater than 1");
                return false;
            }
            if (optInt >= k) {
                optInt = k - 1;
            }
            if (m73.b) {
                Log.d("NavigateBackAction", "real back delta: " + optInt);
            }
            v42 j = W.j((k - optInt) - 1);
            pv2 pv2Var2 = null;
            if (j instanceof x42) {
                pv2Var = ((x42) j).t3();
                pv2Var.e = "1";
                pv2Var.f = uuid;
            } else {
                pv2Var = null;
            }
            dc3.g(pv2Var);
            vy2.c(1, uuid);
            zh3.a(W, context);
            y42.b i = W.i("navigateBack");
            i.n(y42.i, y42.h);
            i.h(optInt);
            i.a();
            x42 o = W.o();
            if (o != null) {
                pv2Var2 = o.t3();
            }
            uy2.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
            vy2.a(uuid, pv2Var2);
            if (!(W.m() instanceof x42)) {
                p22.c("navigateBack", "top fragment error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                dc3.i(pv2Var);
                return false;
            }
            x42 x42Var = (x42) W.m();
            if (x42Var != null) {
                str = x42Var.A3();
            } else {
                str = "";
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(y83.c(str), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
