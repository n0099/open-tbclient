package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.eb2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
/* loaded from: classes6.dex */
public class hf3 extends sd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hf3(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/navigateBack");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc3Var};
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

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        int optInt;
        v13 v13Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            if (sd3.b) {
                Log.d("NavigateBackAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String uuid = UUID.randomUUID().toString();
            b53.b(uuid);
            String str2 = unitedSchemeEntity.getParams().get("params");
            if (!TextUtils.isEmpty(str2)) {
                try {
                    optInt = new JSONObject(str2).optInt("delta", 1);
                } catch (JSONException e) {
                    if (sd3.b) {
                        e.printStackTrace();
                    }
                    v82.c("navigateBack", "params parse fail");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
            } else {
                optInt = 1;
            }
            eb2 U = ix2.T().U();
            if (U == null) {
                v82.c("navigateBack", "fragmentManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int k = U.k();
            if (sd3.b) {
                Log.d("NavigateBackAction", "back delta: " + optInt);
            }
            if (k == 1) {
                v82.c("NavigateBackAction", "navigateBack api can only work when slave's count greater than 1");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "navigateBack api can only work when slave's count greater than 1");
                return false;
            }
            if (optInt >= k) {
                optInt = k - 1;
            }
            if (sd3.b) {
                Log.d("NavigateBackAction", "real back delta: " + optInt);
            }
            bb2 j = U.j((k - optInt) - 1);
            v13 v13Var2 = null;
            if (j instanceof db2) {
                v13Var = ((db2) j).o3();
                v13Var.e = "1";
                v13Var.f = uuid;
            } else {
                v13Var = null;
            }
            ji3.g(v13Var);
            b53.c(1, uuid);
            fo3.a(U, context);
            eb2.b i = U.i("navigateBack");
            i.n(eb2.i, eb2.h);
            i.h(optInt);
            i.a();
            db2 o = U.o();
            if (o != null) {
                v13Var2 = o.o3();
            }
            a53.q("route", uuid).F(new UbcFlowEvent("na_push_page_end"));
            b53.a(uuid, v13Var2);
            if (!(U.m() instanceof db2)) {
                v82.c("navigateBack", "top fragment error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                ji3.i(v13Var);
                return false;
            }
            db2 db2Var = (db2) U.m();
            if (db2Var != null) {
                str = db2Var.v3();
            } else {
                str = "";
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(ef3.c(str), 0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
