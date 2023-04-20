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
public class du2 extends s93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public du2(s83 s83Var) {
        super(s83Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {s83Var};
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

    @Override // com.baidu.tieba.s93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, v73 v73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, v73Var)) == null) {
            if (s93.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.s93
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, v73 v73Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, v73Var)) == null) {
            if (s93.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            v42.i("map", "handleSubAction " + str);
            eu2 a = eu2.a(unitedSchemeEntity, callbackHandler);
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
                    hu2 j = j(unitedSchemeEntity, hu2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return cr2.J().g(context, j, a, v73Var);
                case 1:
                    hu2 j2 = j(unitedSchemeEntity, hu2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return cr2.J().update(context, j2, a, v73Var);
                case 2:
                    hu2 j3 = j(unitedSchemeEntity, hu2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return cr2.J().l(context, j3, a, v73Var);
                case 3:
                    ku2 ku2Var = (ku2) j(unitedSchemeEntity, ku2.class);
                    if (k(ku2Var, a)) {
                        return false;
                    }
                    return cr2.J().j(context, ku2Var, a, v73Var);
                case 4:
                    ju2 ju2Var = (ju2) j(unitedSchemeEntity, ju2.class);
                    if (k(ju2Var, a)) {
                        return false;
                    }
                    return cr2.J().h(context, ju2Var, a, v73Var);
                case 5:
                    hu2 j4 = j(unitedSchemeEntity, hu2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return cr2.J().m(context, j4, a, v73Var);
                case 6:
                    gu2 gu2Var = (gu2) j(unitedSchemeEntity, gu2.class);
                    if (k(gu2Var, a)) {
                        return false;
                    }
                    return cr2.J().b(context, gu2Var, a, v73Var);
                case 7:
                    hu2 j5 = j(unitedSchemeEntity, hu2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return cr2.J().c(context, j5, a, v73Var);
                case '\b':
                    hu2 j6 = j(unitedSchemeEntity, hu2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return cr2.J().n(context, j6, a, v73Var);
                case '\t':
                    hu2 j7 = j(unitedSchemeEntity, hu2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return cr2.J().k(context, j7, a, v73Var);
                case '\n':
                    fu2 fu2Var = (fu2) j(unitedSchemeEntity, fu2.class);
                    if (k(fu2Var, a)) {
                        return false;
                    }
                    return cr2.J().e(context, fu2Var, a, v73Var);
                case 11:
                    lu2 lu2Var = (lu2) j(unitedSchemeEntity, lu2.class);
                    if (k(lu2Var, a)) {
                        return false;
                    }
                    return cr2.J().a(context, lu2Var, a, v73Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, v73Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends hu2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    v42.c("map", "params string is empty");
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
                    v42.c("map", "params json parse error");
                    return t;
                }
            }
            v42.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(hu2 hu2Var, eu2 eu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, hu2Var, eu2Var)) == null) {
            if (hu2Var == null) {
                v42.c("map", "parse error, model is null");
                eu2Var.d(202);
                return true;
            }
            if (u73.K().q().y0()) {
                hu2Var.c = nn3.c().h();
            }
            if (TextUtils.isEmpty(hu2Var.c)) {
                String B = pl3.B();
                if (!TextUtils.isEmpty(B)) {
                    hu2Var.c = B;
                }
                v42.o("map", "webView id is empty, use current webView");
            }
            if (pl3.m(hu2Var.c) == null) {
                eu2Var.d(202);
                v42.c("map", "can not find weiView by id " + hu2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
