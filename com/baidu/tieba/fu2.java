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
public class fu2 extends u93 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fu2(u83 u83Var) {
        super(u83Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {u83Var};
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

    @Override // com.baidu.tieba.u93
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, x73 x73Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, x73Var)) == null) {
            if (u93.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.u93
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, x73 x73Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, x73Var)) == null) {
            if (u93.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            x42.i("map", "handleSubAction " + str);
            gu2 a = gu2.a(unitedSchemeEntity, callbackHandler);
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
                    ju2 j = j(unitedSchemeEntity, ju2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return er2.J().g(context, j, a, x73Var);
                case 1:
                    ju2 j2 = j(unitedSchemeEntity, ju2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return er2.J().update(context, j2, a, x73Var);
                case 2:
                    ju2 j3 = j(unitedSchemeEntity, ju2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return er2.J().l(context, j3, a, x73Var);
                case 3:
                    mu2 mu2Var = (mu2) j(unitedSchemeEntity, mu2.class);
                    if (k(mu2Var, a)) {
                        return false;
                    }
                    return er2.J().j(context, mu2Var, a, x73Var);
                case 4:
                    lu2 lu2Var = (lu2) j(unitedSchemeEntity, lu2.class);
                    if (k(lu2Var, a)) {
                        return false;
                    }
                    return er2.J().h(context, lu2Var, a, x73Var);
                case 5:
                    ju2 j4 = j(unitedSchemeEntity, ju2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return er2.J().m(context, j4, a, x73Var);
                case 6:
                    iu2 iu2Var = (iu2) j(unitedSchemeEntity, iu2.class);
                    if (k(iu2Var, a)) {
                        return false;
                    }
                    return er2.J().b(context, iu2Var, a, x73Var);
                case 7:
                    ju2 j5 = j(unitedSchemeEntity, ju2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return er2.J().c(context, j5, a, x73Var);
                case '\b':
                    ju2 j6 = j(unitedSchemeEntity, ju2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return er2.J().n(context, j6, a, x73Var);
                case '\t':
                    ju2 j7 = j(unitedSchemeEntity, ju2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return er2.J().k(context, j7, a, x73Var);
                case '\n':
                    hu2 hu2Var = (hu2) j(unitedSchemeEntity, hu2.class);
                    if (k(hu2Var, a)) {
                        return false;
                    }
                    return er2.J().e(context, hu2Var, a, x73Var);
                case 11:
                    nu2 nu2Var = (nu2) j(unitedSchemeEntity, nu2.class);
                    if (k(nu2Var, a)) {
                        return false;
                    }
                    return er2.J().a(context, nu2Var, a, x73Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, x73Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends ju2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    x42.c("map", "params string is empty");
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
                    x42.c("map", "params json parse error");
                    return t;
                }
            }
            x42.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(ju2 ju2Var, gu2 gu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, ju2Var, gu2Var)) == null) {
            if (ju2Var == null) {
                x42.c("map", "parse error, model is null");
                gu2Var.d(202);
                return true;
            }
            if (w73.K().q().y0()) {
                ju2Var.c = pn3.c().h();
            }
            if (TextUtils.isEmpty(ju2Var.c)) {
                String B = rl3.B();
                if (!TextUtils.isEmpty(B)) {
                    ju2Var.c = B;
                }
                x42.o("map", "webView id is empty, use current webView");
            }
            if (rl3.m(ju2Var.c) == null) {
                gu2Var.d(202);
                x42.c("map", "can not find weiView by id " + ju2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
