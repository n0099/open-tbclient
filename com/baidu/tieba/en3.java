package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.URI;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class en3 extends s83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.s83
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/animView" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public en3(q83 q83Var) {
        super(q83Var, "/swanAPI/animView");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q83Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((q83) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public final o32 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                t42.c("SwanAppAction", "params is null");
                return null;
            }
            o32 o32Var = new o32();
            try {
                o32Var.a(k);
            } catch (JSONException e) {
                e.printStackTrace();
                t42.d("SwanAppAction", "model parse exception:", e);
            }
            return o32Var;
        }
        return (o32) invokeL.objValue;
    }

    @Override // com.baidu.tieba.s83
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, t73 t73Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, t73Var)) == null) {
            o32 q = q(unitedSchemeEntity);
            if (q == null) {
                ze3.b("animView", 1001, "model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                t42.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.j()) {
                ze3.b("animView", 1001, "parse insert params, but invalid", 201, "parse insert params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                t42.c("AbsSwanAppWidget", "parse insert params, but invalid");
                return false;
            } else {
                String r = r(q.t, t73Var);
                if (TextUtils.isEmpty(r)) {
                    ze3.b("animView", 1001, "AnimConfData is invalid", 201, "parse insert params, anim data is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is null");
                    return false;
                }
                if (gt2.U().N()) {
                    try {
                        new JSONObject(r);
                    } catch (Throwable th) {
                        ze3.b("animView", 1001, "parse insert params, anim data is not json", 201, "parse insert params, anim data is not json");
                        if (q93.b) {
                            th.printStackTrace();
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is not json");
                        return false;
                    }
                }
                k32 insert = new n32(context, q, r).insert();
                boolean a = insert.a();
                t42.i("AbsSwanAppWidget", "insert anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    ze3.b("animView", 2009, "insert anim view, but failure: " + insert.b, 1001, "insert anim view, but failure: " + insert.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, insert.b);
                    t42.c("AbsSwanAppWidget", "insert anim view, but failure: " + insert.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.s83
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, t73 t73Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, t73Var)) == null) {
            o32 q = q(unitedSchemeEntity);
            if (q == null) {
                ze3.b("animView", 1001, "update, model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                t42.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                ze3.b("animView", 1001, "parse update params, but invalid", 201, "parse update params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                t42.c("AbsSwanAppWidget", "parse update params, but invalid");
                return false;
            } else {
                n32 n32Var = (n32) g42.a(q);
                if (n32Var == null) {
                    ze3.b("animView", 2001, "get component is null", 1001, "get component is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    t42.c("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                k32 update = n32Var.update((n32) q);
                boolean a = update.a();
                t42.b("AbsSwanAppWidget", "update anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    ze3.b("animView", 2001, "update anim view, but failure: " + update.b, 1001, "update anim view, but failure: " + update.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, update.b);
                    t42.c("AbsSwanAppWidget", "update anim view, but failure: " + update.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.s83
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, t73 t73Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, t73Var)) == null) {
            o32 q = q(unitedSchemeEntity);
            if (q == null) {
                ze3.b("animView", 1001, "model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                t42.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                ze3.b("animView", 1001, "parse remove params, but invalid", 201, "parse remove params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                t42.c("AbsSwanAppWidget", "parse remove params, but invalid");
                return false;
            } else {
                n32 n32Var = (n32) g42.a(q);
                if (n32Var == null) {
                    ze3.b("animView", 2001, "get component is null", 1001, "get component is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    t42.c("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                k32 B = n32Var.B();
                boolean a = B.a();
                t42.i("AbsSwanAppWidget", "remove anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    ze3.b("animView", 2001, "remove anim view, but failure: " + B.b, 1001, "remove anim view, but failure: " + B.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, B.b);
                    t42.c("AbsSwanAppWidget", "remove anim view, but failure: " + B.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final String r(String str, t73 t73Var) {
        InterceptResult invokeLL;
        String L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, t73Var)) == null) {
            if (!TextUtils.isEmpty(str) && t73Var != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        L = bf3.M(str, t73Var.b);
                    } else {
                        L = bf3.L(str, t73Var, t73Var.k0());
                    }
                    if (TextUtils.isEmpty(L)) {
                        return null;
                    }
                    File file = new File(L);
                    if (!xn4.y(file)) {
                        return null;
                    }
                    return xn4.E(file);
                } catch (Exception e) {
                    if (q93.b) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
