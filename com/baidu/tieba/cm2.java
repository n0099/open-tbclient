package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.ig3;
import com.baidu.tieba.xh2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cm2 extends ad3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ JSONObject c;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, unitedSchemeEntity, jSONObject};
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
            this.c = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (!bg3.h(gg3Var)) {
                    bg3.p(gg3Var, this.a, this.b);
                    return;
                }
                if (this.c.has("emitLive")) {
                    c73.Q(rl2.b(this.c.optInt("emitLive")));
                }
                if (this.c.has("emitHttps")) {
                    c73.N(rl2.b(this.c.optInt("emitHttps")));
                }
                if (this.c.has("emitDomain")) {
                    c73.T(!rl2.b(this.c.optInt("emitDomain")));
                    c73.W(!rl2.b(this.c.optInt("emitDomain")));
                }
                if (this.c.has("emitWss")) {
                    c73.P(rl2.b(this.c.optInt("emitWss")));
                }
                if (this.c.has("emitLaunchMode")) {
                    c73.U(rl2.b(this.c.optInt("emitLaunchMode")));
                }
                if (this.c.has("debugEnvData")) {
                    c73.K(this.c.optString("debugEnvData"));
                }
                if (this.c.has("emitReplaceJsNative")) {
                    c73.O(rl2.b(this.c.optInt("emitReplaceJsNative")));
                }
                if (this.c.has("emitReplaceV8Core")) {
                    xh2.v.e(xh2.v.b(this.c.optInt("emitReplaceV8Core")));
                }
                if (this.c.has("emitHostEnv")) {
                    c73.S(this.c.optInt("emitHostEnv"));
                }
                if (this.c.has("openStabilityCollector")) {
                    wl2.b(rl2.b(this.c.optInt("openStabilityCollector")));
                }
                if (this.c.has("openPerformanceTesting")) {
                    vl2.b(rl2.b(this.c.optInt("openPerformanceTesting")));
                }
                UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(0));
                c73.Z();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cm2(ac3 ac3Var) {
        super(ac3Var, "/swanAPI/debug/setDebugConfig");
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

    public static boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, unitedSchemeEntity, callbackHandler, db3Var, jSONObject)) == null) {
            db3Var.e0().g(context, "mapp_cts_debug", new a(callbackHandler, unitedSchemeEntity, jSONObject));
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, unitedSchemeEntity, callbackHandler, jSONObject, jSONObject2)) == null) {
            if (!ad3.b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!TextUtils.equals(jSONObject.optString("category"), "swanGame")) {
                d82.c("setDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (jSONObject2.has("emitHttps")) {
                    c73.N(rl2.b(jSONObject2.optInt("emitHttps")));
                }
                if (jSONObject2.has("emitWss")) {
                    c73.P(rl2.b(jSONObject2.optInt("emitWss")));
                }
                if (jSONObject2.has("debugEnvData")) {
                    c73.K(jSONObject2.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                c73.Z();
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ad3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, db3 db3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, db3Var)) == null) {
            JSONObject a2 = ad3.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d82.c("setDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject("config");
            if (optJSONObject == null) {
                d82.c("setDebugConfig", "config is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int k = cb3.K().k();
            if (k != 0) {
                if (k != 1) {
                    d82.c("setDebugConfig", "frame type error");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                return k(unitedSchemeEntity, callbackHandler, a2, optJSONObject);
            }
            return j(context, unitedSchemeEntity, callbackHandler, db3Var, optJSONObject);
        }
        return invokeLLLL.booleanValue;
    }
}
