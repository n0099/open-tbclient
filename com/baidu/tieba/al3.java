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
/* loaded from: classes5.dex */
public class al3 extends o63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.o63
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/animView" : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al3(m63 m63Var) {
        super(m63Var, "/swanAPI/animView");
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
                super((m63) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Nullable
    public final k12 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                p22.c("SwanAppAction", "params is null");
                return null;
            }
            k12 k12Var = new k12();
            try {
                k12Var.a(k);
            } catch (JSONException e) {
                e.printStackTrace();
                p22.d("SwanAppAction", "model parse exception:", e);
            }
            return k12Var;
        }
        return (k12) invokeL.objValue;
    }

    @Override // com.baidu.tieba.o63
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, p53 p53Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, p53Var)) == null) {
            k12 q = q(unitedSchemeEntity);
            if (q == null) {
                vc3.b("animView", 1001, "model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                p22.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.j()) {
                vc3.b("animView", 1001, "parse insert params, but invalid", 201, "parse insert params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                p22.c("AbsSwanAppWidget", "parse insert params, but invalid");
                return false;
            } else {
                String r = r(q.t, p53Var);
                if (TextUtils.isEmpty(r)) {
                    vc3.b("animView", 1001, "AnimConfData is invalid", 201, "parse insert params, anim data is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is null");
                    return false;
                }
                if (cr2.V().O()) {
                    try {
                        new JSONObject(r);
                    } catch (Throwable th) {
                        vc3.b("animView", 1001, "parse insert params, anim data is not json", 201, "parse insert params, anim data is not json");
                        if (m73.b) {
                            th.printStackTrace();
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "parse insert params, anim data is not json");
                        return false;
                    }
                }
                h12 w = new j12(context, q, r).w();
                boolean a = w.a();
                p22.i("AbsSwanAppWidget", "insert anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    vc3.b("animView", 2009, "insert anim view, but failure: " + w.b, 1001, "insert anim view, but failure: " + w.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, w.b);
                    p22.c("AbsSwanAppWidget", "insert anim view, but failure: " + w.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.o63
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, p53 p53Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, p53Var)) == null) {
            k12 q = q(unitedSchemeEntity);
            if (q == null) {
                vc3.b("animView", 1001, "update, model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                p22.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                vc3.b("animView", 1001, "parse update params, but invalid", 201, "parse update params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                p22.c("AbsSwanAppWidget", "parse update params, but invalid");
                return false;
            } else {
                j12 j12Var = (j12) c22.a(q);
                if (j12Var == null) {
                    vc3.b("animView", 2001, "get component is null", 1001, "get component is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    p22.c("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                h12 G = j12Var.G(q);
                boolean a = G.a();
                p22.b("AbsSwanAppWidget", "update anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    vc3.b("animView", 2001, "update anim view, but failure: " + G.b, 1001, "update anim view, but failure: " + G.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, G.b);
                    p22.c("AbsSwanAppWidget", "update anim view, but failure: " + G.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.o63
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, p53 p53Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, p53Var)) == null) {
            k12 q = q(unitedSchemeEntity);
            if (q == null) {
                vc3.b("animView", 1001, "model is null", 201, "model is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                p22.c("AbsSwanAppWidget", "model is null");
                return false;
            } else if (!q.isValid()) {
                vc3.b("animView", 1001, "parse remove params, but invalid", 201, "parse remove params, but invalid");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                p22.c("AbsSwanAppWidget", "parse remove params, but invalid");
                return false;
            } else {
                j12 j12Var = (j12) c22.a(q);
                if (j12Var == null) {
                    vc3.b("animView", 2001, "get component is null", 1001, "get component is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    p22.c("AbsSwanAppWidget", "get component is null");
                    return false;
                }
                h12 C = j12Var.C();
                boolean a = C.a();
                p22.i("AbsSwanAppWidget", "remove anim view success = " + a);
                if (a) {
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                } else {
                    vc3.b("animView", 2001, "remove anim view, but failure: " + C.b, 1001, "remove anim view, but failure: " + C.b);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, C.b);
                    p22.c("AbsSwanAppWidget", "remove anim view, but failure: " + C.b);
                }
                return a;
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public final String r(String str, p53 p53Var) {
        InterceptResult invokeLL;
        String L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, p53Var)) == null) {
            if (!TextUtils.isEmpty(str) && p53Var != null) {
                try {
                    if ("bdfile".equalsIgnoreCase(URI.create(str).getScheme())) {
                        L = xc3.M(str, p53Var.b);
                    } else {
                        L = xc3.L(str, p53Var, p53Var.l0());
                    }
                    if (TextUtils.isEmpty(L)) {
                        return null;
                    }
                    File file = new File(L);
                    if (!sl4.y(file)) {
                        return null;
                    }
                    return sl4.E(file);
                } catch (Exception e) {
                    if (m73.b) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }
}
