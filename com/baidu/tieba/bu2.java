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
/* loaded from: classes3.dex */
public class bu2 extends q93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu2(q83 q83Var) {
        super(q83Var, "/swanAPI/map");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.q93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, t73 t73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, t73Var)) == null) {
            if (q93.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.q93
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, t73 t73Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, t73Var)) == null) {
            if (q93.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            t42.i("map", "handleSubAction " + str);
            cu2 a = cu2.a(unitedSchemeEntity, callbackHandler);
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
                    fu2 j = j(unitedSchemeEntity, fu2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return ar2.J().g(context, j, a, t73Var);
                case 1:
                    fu2 j2 = j(unitedSchemeEntity, fu2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return ar2.J().update(context, j2, a, t73Var);
                case 2:
                    fu2 j3 = j(unitedSchemeEntity, fu2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return ar2.J().l(context, j3, a, t73Var);
                case 3:
                    iu2 iu2Var = (iu2) j(unitedSchemeEntity, iu2.class);
                    if (k(iu2Var, a)) {
                        return false;
                    }
                    return ar2.J().j(context, iu2Var, a, t73Var);
                case 4:
                    hu2 hu2Var = (hu2) j(unitedSchemeEntity, hu2.class);
                    if (k(hu2Var, a)) {
                        return false;
                    }
                    return ar2.J().h(context, hu2Var, a, t73Var);
                case 5:
                    fu2 j4 = j(unitedSchemeEntity, fu2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return ar2.J().m(context, j4, a, t73Var);
                case 6:
                    eu2 eu2Var = (eu2) j(unitedSchemeEntity, eu2.class);
                    if (k(eu2Var, a)) {
                        return false;
                    }
                    return ar2.J().b(context, eu2Var, a, t73Var);
                case 7:
                    fu2 j5 = j(unitedSchemeEntity, fu2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return ar2.J().c(context, j5, a, t73Var);
                case '\b':
                    fu2 j6 = j(unitedSchemeEntity, fu2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return ar2.J().n(context, j6, a, t73Var);
                case '\t':
                    fu2 j7 = j(unitedSchemeEntity, fu2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return ar2.J().k(context, j7, a, t73Var);
                case '\n':
                    du2 du2Var = (du2) j(unitedSchemeEntity, du2.class);
                    if (k(du2Var, a)) {
                        return false;
                    }
                    return ar2.J().e(context, du2Var, a, t73Var);
                case 11:
                    ju2 ju2Var = (ju2) j(unitedSchemeEntity, ju2.class);
                    if (k(ju2Var, a)) {
                        return false;
                    }
                    return ar2.J().a(context, ju2Var, a, t73Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, t73Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends fu2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    t42.c("map", "params string is empty");
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
                    t42.c("map", "params json parse error");
                    return t;
                }
            }
            t42.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(fu2 fu2Var, cu2 cu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, fu2Var, cu2Var)) == null) {
            if (fu2Var == null) {
                t42.c("map", "parse error, model is null");
                cu2Var.d(202);
                return true;
            }
            if (s73.K().q().y0()) {
                fu2Var.c = ln3.c().h();
            }
            if (TextUtils.isEmpty(fu2Var.c)) {
                String B = nl3.B();
                if (!TextUtils.isEmpty(B)) {
                    fu2Var.c = B;
                }
                t42.o("map", "webView id is empty, use current webView");
            }
            if (nl3.m(fu2Var.c) == null) {
                cu2Var.d(202);
                t42.c("map", "can not find weiView by id " + fu2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
