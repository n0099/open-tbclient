package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.c22;
import com.baidu.tieba.hl3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class il3 extends sd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements hl3.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ n22 c;
        public final /* synthetic */ il3 d;

        public a(il3 il3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, n22 n22Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {il3Var, unitedSchemeEntity, callbackHandler, n22Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = il3Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = n22Var;
        }

        @Override // com.baidu.tieba.hl3.a
        public void a(double[] dArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dArr) == null) {
                if (dArr != null && dArr.length == 3) {
                    v82.i("accelerometer", "handle accelerometer change, x : " + dArr[0] + " y: " + dArr[1] + " z: " + dArr[2]);
                    this.d.k(this.a, this.b, this.c, dArr);
                    return;
                }
                v82.c("accelerometer", "illegal accelerometers");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public il3(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/startAccelerometer");
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
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            if (vb3Var == null) {
                v82.c("accelerometer", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (sd3.b) {
                    Log.d("SwanAppAction", "startAccelerometer --- illegal swanApp");
                }
                return false;
            } else if (context == null) {
                v82.c("accelerometer", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                if (sd3.b) {
                    Log.d("SwanAppAction", "startAccelerometer --- illegal context");
                }
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    if (sd3.b) {
                        Log.d("SwanAppAction", "startAccelerometer --- params is empty");
                    }
                    v82.c("accelerometer", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (sd3.b) {
                        Log.d("SwanAppAction", "startAccelerometer --- cb is empty");
                    }
                    v82.c("accelerometer", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                v82.i("accelerometer", " init ");
                n22 n22Var = new n22("accelerometerChange", optParamsAsJo, optString);
                hl3 a2 = hl3.a();
                a2.b(context, c22.b.a(optParamsAsJo.optString("interval")));
                a2.e(new a(this, unitedSchemeEntity, callbackHandler, n22Var));
                a2.f();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                n22Var.a(unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, n22 n22Var, double[] dArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler, n22Var, dArr) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", dArr[0]);
                jSONObject.put("y", dArr[1]);
                jSONObject.put("z", dArr[2]);
                n22Var.c(unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e) {
                v82.c("accelerometer", "handle compass,json error，" + e.toString());
                n22Var.e(unitedSchemeEntity, callbackHandler, "Json error");
            }
        }
    }
}
