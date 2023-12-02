package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dj2 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;
    public k63 d;
    public CallbackHandler e;

    /* loaded from: classes5.dex */
    public class a implements SubscribeHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;

        public a(dj2 dj2Var, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj2Var, unitedSchemeEntity};
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
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i, @NonNull String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, jSONObject) == null) {
                this.a.result = UnitedSchemeUtility.wrapCallbackParams(i, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SubscribeHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ dj2 b;

        public b(dj2 dj2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dj2Var;
            this.a = str;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i, @NonNull String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, jSONObject) == null) {
                if (jSONObject == null) {
                    this.b.e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(i, str).toString());
                } else {
                    this.b.e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i).toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ej2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ dj2 b;

        public c(dj2 dj2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dj2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dj2Var;
            this.a = str;
        }

        @Override // com.baidu.tieba.o43
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b.e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        }

        @Override // com.baidu.tieba.o43
        public void onSuccess(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                this.b.e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                if (!q43.c.c()) {
                    if (rp2.h0().e(this.b.c)) {
                        q43.c.e();
                    } else {
                        q43.c.f();
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj2(h73 h73Var) {
        super(h73Var, "/swanAPI/getFormId");
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
            if (unitedSchemeEntity == null) {
                if (h83.b) {
                    Log.w("GetFormIdAction", "entity is null");
                }
                return false;
            } else if (k63Var != null && (context instanceof Activity) && callbackHandler != null) {
                this.c = context;
                this.d = k63Var;
                this.e = callbackHandler;
                JSONObject a2 = h83.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.length() != 0) {
                    String optString = a2.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        if (h83.b) {
                            Log.w("GetFormIdAction", "cb is empty");
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                        return false;
                    }
                    String P = k63Var.P();
                    if (TextUtils.isEmpty(P)) {
                        if (h83.b) {
                            Log.w("GetFormIdAction", "appKey is empty");
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "appKey is empty");
                        return false;
                    }
                    if (TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE.equals(a2.optString("reportType"))) {
                        SubscribeHelper subscribeHelper = new SubscribeHelper();
                        if (!subscribeHelper.n(this.c, this.d, P, a2, SubscribeHelper.invokeSubscribeFrom.GET_FORM_ID_BUTTON, new a(this, unitedSchemeEntity))) {
                            return false;
                        }
                        subscribeHelper.o(P, new b(this, optString));
                    } else {
                        l(P, optString);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            } else {
                if (h83.b) {
                    Log.d("GetFormIdAction", "runtime parameter error");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (!SubscribeHelper.l()) {
                this.e.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(kj3.f(null, "data", kj3.f(null, "formid", "")), 0).toString());
                return;
            }
            rp2.W().c(str, new c(this, str2));
        }
    }
}
