package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.gl3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hl3 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements gl3.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ z12 c;
        public final /* synthetic */ hl3 d;

        public a(hl3 hl3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, z12 z12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl3Var, unitedSchemeEntity, callbackHandler, z12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = hl3Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = z12Var;
        }

        @Override // com.baidu.tieba.gl3.c
        public void a(float f, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) == null) {
                h82.i(MapController.COMPASS_LAYER_TAG, "handle compass change, angle:" + f + ",accuracy: " + i);
                this.d.k(this.a, this.b, this.c, f, i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hl3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/startCompass");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (hb3Var == null) {
                h82.c(MapController.COMPASS_LAYER_TAG, "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (ed3.b) {
                    Log.d("SwanAppAction", "startCompass --- illegal swanApp");
                }
                return false;
            } else if (context == null) {
                h82.c(MapController.COMPASS_LAYER_TAG, "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                if (ed3.b) {
                    Log.d("SwanAppAction", "startCompass --- illegal context");
                }
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    if (ed3.b) {
                        Log.d("SwanAppAction", "startCompass --- params is empty");
                    }
                    h82.c(MapController.COMPASS_LAYER_TAG, "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (ed3.b) {
                        Log.d("SwanAppAction", "startCompass --- cb is empty");
                    }
                    h82.c(MapController.COMPASS_LAYER_TAG, "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                h82.i(MapController.COMPASS_LAYER_TAG, "init");
                z12 z12Var = new z12("compassChange", optParamsAsJo, optString);
                gl3 i = gl3.i();
                i.l(context);
                i.o(new a(this, unitedSchemeEntity, callbackHandler, z12Var));
                h82.i(MapController.COMPASS_LAYER_TAG, "start listen compass");
                i.p();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                z12Var.a(unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, z12 z12Var, float f, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{unitedSchemeEntity, callbackHandler, z12Var, Float.valueOf(f), Integer.valueOf(i)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, f);
                jSONObject.put("accuracy", gl3.h(i));
                if (ed3.b) {
                    Log.d("SwanAppAction", "compassAngle : " + jSONObject.toString());
                }
                z12Var.c(unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e) {
                h82.c(MapController.COMPASS_LAYER_TAG, "handle compass,json error，" + e.toString());
                z12Var.e(unitedSchemeEntity, callbackHandler, "Json error");
            }
        }
    }
}
