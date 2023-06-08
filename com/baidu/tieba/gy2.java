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
/* loaded from: classes5.dex */
public class gy2 extends vd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gy2(vc3 vc3Var) {
        super(vc3Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vc3Var};
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

    @Override // com.baidu.tieba.vd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, yb3 yb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, yb3Var)) == null) {
            if (vd3.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.vd3
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, yb3 yb3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, yb3Var)) == null) {
            if (vd3.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            y82.i("map", "handleSubAction " + str);
            hy2 a = hy2.a(unitedSchemeEntity, callbackHandler);
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
                    ky2 j = j(unitedSchemeEntity, ky2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return fv2.J().g(context, j, a, yb3Var);
                case 1:
                    ky2 j2 = j(unitedSchemeEntity, ky2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return fv2.J().update(context, j2, a, yb3Var);
                case 2:
                    ky2 j3 = j(unitedSchemeEntity, ky2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return fv2.J().l(context, j3, a, yb3Var);
                case 3:
                    ny2 ny2Var = (ny2) j(unitedSchemeEntity, ny2.class);
                    if (k(ny2Var, a)) {
                        return false;
                    }
                    return fv2.J().j(context, ny2Var, a, yb3Var);
                case 4:
                    my2 my2Var = (my2) j(unitedSchemeEntity, my2.class);
                    if (k(my2Var, a)) {
                        return false;
                    }
                    return fv2.J().h(context, my2Var, a, yb3Var);
                case 5:
                    ky2 j4 = j(unitedSchemeEntity, ky2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return fv2.J().m(context, j4, a, yb3Var);
                case 6:
                    jy2 jy2Var = (jy2) j(unitedSchemeEntity, jy2.class);
                    if (k(jy2Var, a)) {
                        return false;
                    }
                    return fv2.J().b(context, jy2Var, a, yb3Var);
                case 7:
                    ky2 j5 = j(unitedSchemeEntity, ky2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return fv2.J().c(context, j5, a, yb3Var);
                case '\b':
                    ky2 j6 = j(unitedSchemeEntity, ky2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return fv2.J().n(context, j6, a, yb3Var);
                case '\t':
                    ky2 j7 = j(unitedSchemeEntity, ky2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return fv2.J().k(context, j7, a, yb3Var);
                case '\n':
                    iy2 iy2Var = (iy2) j(unitedSchemeEntity, iy2.class);
                    if (k(iy2Var, a)) {
                        return false;
                    }
                    return fv2.J().e(context, iy2Var, a, yb3Var);
                case 11:
                    oy2 oy2Var = (oy2) j(unitedSchemeEntity, oy2.class);
                    if (k(oy2Var, a)) {
                        return false;
                    }
                    return fv2.J().a(context, oy2Var, a, yb3Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, yb3Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends ky2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    y82.c("map", "params string is empty");
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
                    y82.c("map", "params json parse error");
                    return t;
                }
            }
            y82.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(ky2 ky2Var, hy2 hy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, ky2Var, hy2Var)) == null) {
            if (ky2Var == null) {
                y82.c("map", "parse error, model is null");
                hy2Var.d(202);
                return true;
            }
            if (xb3.K().q().y0()) {
                ky2Var.c = qr3.c().h();
            }
            if (TextUtils.isEmpty(ky2Var.c)) {
                String B = sp3.B();
                if (!TextUtils.isEmpty(B)) {
                    ky2Var.c = B;
                }
                y82.o("map", "webView id is empty, use current webView");
            }
            if (sp3.m(ky2Var.c) == null) {
                hy2Var.d(202);
                y82.c("map", "can not find weiView by id " + ky2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
