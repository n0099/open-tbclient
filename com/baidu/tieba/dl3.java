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
import com.baidu.tieba.cl3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dl3 extends ad3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements cl3.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ v12 c;
        public final /* synthetic */ dl3 d;

        public a(dl3 dl3Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, v12 v12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl3Var, unitedSchemeEntity, callbackHandler, v12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = dl3Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = v12Var;
        }

        @Override // com.baidu.tieba.cl3.c
        public void a(float f, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), Integer.valueOf(i)}) == null) {
                d82.i(MapController.COMPASS_LAYER_TAG, "handle compass change, angle:" + f + ",accuracy: " + i);
                this.d.k(this.a, this.b, this.c, f, i);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dl3(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/startCompass");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ac3Var};
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

    @Override // com.baidu.tieba.ad3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, db3Var)) == null) {
            if (db3Var == null) {
                d82.c(MapController.COMPASS_LAYER_TAG, "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (ad3.b) {
                    Log.d("SwanAppAction", "startCompass --- illegal swanApp");
                }
                return false;
            } else if (context == null) {
                d82.c(MapController.COMPASS_LAYER_TAG, "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                if (ad3.b) {
                    Log.d("SwanAppAction", "startCompass --- illegal context");
                }
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    if (ad3.b) {
                        Log.d("SwanAppAction", "startCompass --- params is empty");
                    }
                    d82.c(MapController.COMPASS_LAYER_TAG, "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (ad3.b) {
                        Log.d("SwanAppAction", "startCompass --- cb is empty");
                    }
                    d82.c(MapController.COMPASS_LAYER_TAG, "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                d82.i(MapController.COMPASS_LAYER_TAG, "init");
                v12 v12Var = new v12("compassChange", optParamsAsJo, optString);
                cl3 i = cl3.i();
                i.l(context);
                i.o(new a(this, unitedSchemeEntity, callbackHandler, v12Var));
                d82.i(MapController.COMPASS_LAYER_TAG, "start listen compass");
                i.p();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                v12Var.a(unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, v12 v12Var, float f, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{unitedSchemeEntity, callbackHandler, v12Var, Float.valueOf(f), Integer.valueOf(i)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, f);
                jSONObject.put("accuracy", cl3.h(i));
                if (ad3.b) {
                    Log.d("SwanAppAction", "compassAngle : " + jSONObject.toString());
                }
                v12Var.c(unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e) {
                d82.c(MapController.COMPASS_LAYER_TAG, "handle compass,json error，" + e.toString());
                v12Var.e(unitedSchemeEntity, callbackHandler, "Json error");
            }
        }
    }
}
