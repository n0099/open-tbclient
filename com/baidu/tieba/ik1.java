package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ik1 extends i53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gk1 c;

    /* loaded from: classes4.dex */
    public class a implements fk1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final UnitedSchemeEntity a;
        public final CallbackHandler b;

        public a(ik1 ik1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik1Var, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
        }

        @Override // com.baidu.tieba.fk1
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                UnitedSchemeUtility.callCallback(this.b, this.a, i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements hk1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CallbackHandler a;
        public final String b;

        public b(ik1 ik1Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ik1Var, callbackHandler, str};
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
            this.b = str;
        }

        @Override // com.baidu.tieba.hk1
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (TextUtils.isEmpty(this.b)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", jSONObject.toString());
                    yo2.U().u(new md2("rewardedVideoAdClose", hashMap));
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("event", "close");
                    jSONObject2.put(TiebaStatic.LogFields.RESULT, jSONObject);
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.baidu.tieba.hk1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (TextUtils.isEmpty(this.b)) {
                    yo2.U().u(new md2("rewardedVideoAdLoad", new HashMap()));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("event", "load");
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.baidu.tieba.hk1
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                if (TextUtils.isEmpty(this.b)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", jSONObject.toString());
                    yo2.U().u(new md2("rewardedVideoAdError", hashMap));
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("event", "error");
                    jSONObject2.put(TiebaStatic.LogFields.RESULT, jSONObject);
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ik1(i43 i43Var) {
        super(i43Var, "/swanAPI/rewardedVideoAd");
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
        this.c = null;
    }

    @Override // com.baidu.tieba.i53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, l33Var)) == null) {
            if (i53.b) {
                Log.d("SwanAppAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            JSONObject a2 = i53.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = a2.optString("cb");
            String optString2 = a2.optString("action");
            b bVar = new b(this, callbackHandler, optString);
            a aVar = new a(this, unitedSchemeEntity, callbackHandler);
            if (this.c == null) {
                this.c = new kk1(a2, bVar, aVar);
            }
            if (TextUtils.equals(optString2, "show")) {
                this.c.a(a2, aVar);
                return true;
            } else if (TextUtils.equals(optString2, "load")) {
                this.c.b(a2, aVar, bVar);
                return true;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
