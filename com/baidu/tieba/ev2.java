package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ev2 extends ta3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ev2(t93 t93Var) {
        super(t93Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t93Var};
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

    @Override // com.baidu.tieba.ta3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, w83 w83Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, w83Var)) == null) {
            if (ta3.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.ta3
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, w83 w83Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, w83Var)) == null) {
            if (ta3.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            w52.i("map", "handleSubAction " + str);
            fv2 a = fv2.a(unitedSchemeEntity, callbackHandler);
            char c = 65535;
            switch (str.hashCode()) {
                case -2079680864:
                    if (str.equals("/swanAPI/map/translateMarker")) {
                        c = 3;
                        break;
                    }
                    break;
                case -2068557416:
                    if (str.equals("/swanAPI/map/getCenterLocation")) {
                        c = '\t';
                        break;
                    }
                    break;
                case -398143716:
                    if (str.equals("/swanAPI/map/getScale")) {
                        c = 7;
                        break;
                    }
                    break;
                case 51993511:
                    if (str.equals("/swanAPI/map/openLocation")) {
                        c = 4;
                        break;
                    }
                    break;
                case 379323012:
                    if (str.equals("/swanAPI/map/create")) {
                        c = 0;
                        break;
                    }
                    break;
                case 515840866:
                    if (str.equals("/swanAPI/map/getRegion")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 797006348:
                    if (str.equals("/swanAPI/map/remove")) {
                        c = 2;
                        break;
                    }
                    break;
                case 892770897:
                    if (str.equals("/swanAPI/map/update")) {
                        c = 1;
                        break;
                    }
                    break;
                case 1007473955:
                    if (str.equals("/swanAPI/map/includePoints")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1142165295:
                    if (str.equals("/swanAPI/map/openWalkNavigation")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1256916873:
                    if (str.equals("/swanAPI/map/moveToLocation")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1475857524:
                    if (str.equals("/swanAPI/map/chooseLocation")) {
                        c = '\n';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    iv2 j = j(unitedSchemeEntity, iv2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return ds2.J().g(context, j, a, w83Var);
                case 1:
                    iv2 j2 = j(unitedSchemeEntity, iv2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return ds2.J().update(context, j2, a, w83Var);
                case 2:
                    iv2 j3 = j(unitedSchemeEntity, iv2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return ds2.J().l(context, j3, a, w83Var);
                case 3:
                    lv2 lv2Var = (lv2) j(unitedSchemeEntity, lv2.class);
                    if (k(lv2Var, a)) {
                        return false;
                    }
                    return ds2.J().j(context, lv2Var, a, w83Var);
                case 4:
                    kv2 kv2Var = (kv2) j(unitedSchemeEntity, kv2.class);
                    if (k(kv2Var, a)) {
                        return false;
                    }
                    return ds2.J().h(context, kv2Var, a, w83Var);
                case 5:
                    iv2 j4 = j(unitedSchemeEntity, iv2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return ds2.J().m(context, j4, a, w83Var);
                case 6:
                    hv2 hv2Var = (hv2) j(unitedSchemeEntity, hv2.class);
                    if (k(hv2Var, a)) {
                        return false;
                    }
                    return ds2.J().b(context, hv2Var, a, w83Var);
                case 7:
                    iv2 j5 = j(unitedSchemeEntity, iv2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return ds2.J().c(context, j5, a, w83Var);
                case '\b':
                    iv2 j6 = j(unitedSchemeEntity, iv2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return ds2.J().n(context, j6, a, w83Var);
                case '\t':
                    iv2 j7 = j(unitedSchemeEntity, iv2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return ds2.J().k(context, j7, a, w83Var);
                case '\n':
                    gv2 gv2Var = (gv2) j(unitedSchemeEntity, gv2.class);
                    if (k(gv2Var, a)) {
                        return false;
                    }
                    return ds2.J().e(context, gv2Var, a, w83Var);
                case 11:
                    mv2 mv2Var = (mv2) j(unitedSchemeEntity, mv2.class);
                    if (k(mv2Var, a)) {
                        return false;
                    }
                    return ds2.J().a(context, mv2Var, a, w83Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, w83Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends iv2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        T newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity, cls)) == null) {
            T t = null;
            if (unitedSchemeEntity == null) {
                return null;
            }
            HashMap<String, String> params = unitedSchemeEntity.getParams();
            if (params != null && !params.isEmpty()) {
                String str = params.get("params");
                if (str == null) {
                    w52.c("map", "params string is empty");
                    return null;
                }
                try {
                    jSONObject = new JSONObject(str);
                    newInstance = cls.newInstance();
                } catch (Exception e) {
                    e = e;
                }
                try {
                    newInstance.a(jSONObject);
                    return newInstance;
                } catch (Exception e2) {
                    e = e2;
                    t = newInstance;
                    e.printStackTrace();
                    w52.c("map", "params json parse error");
                    return t;
                }
            }
            w52.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(iv2 iv2Var, fv2 fv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, iv2Var, fv2Var)) == null) {
            if (iv2Var == null) {
                w52.c("map", "parse error, model is null");
                fv2Var.d(202);
                return true;
            }
            if (v83.K().q().y0()) {
                iv2Var.c = oo3.c().h();
            }
            if (TextUtils.isEmpty(iv2Var.c)) {
                String B = qm3.B();
                if (!TextUtils.isEmpty(B)) {
                    iv2Var.c = B;
                }
                w52.o("map", "webView id is empty, use current webView");
            }
            if (qm3.m(iv2Var.c) == null) {
                fv2Var.d(202);
                w52.c("map", "can not find weiView by id " + iv2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
