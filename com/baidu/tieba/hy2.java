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
/* loaded from: classes6.dex */
public class hy2 extends wd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hy2(wc3 wc3Var) {
        super(wc3Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {wc3Var};
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

    @Override // com.baidu.tieba.wd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, zb3 zb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, zb3Var)) == null) {
            if (wd3.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.wd3
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, zb3 zb3Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, zb3Var)) == null) {
            if (wd3.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            z82.i("map", "handleSubAction " + str);
            iy2 a = iy2.a(unitedSchemeEntity, callbackHandler);
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
                    ly2 j = j(unitedSchemeEntity, ly2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return gv2.J().g(context, j, a, zb3Var);
                case 1:
                    ly2 j2 = j(unitedSchemeEntity, ly2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return gv2.J().update(context, j2, a, zb3Var);
                case 2:
                    ly2 j3 = j(unitedSchemeEntity, ly2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return gv2.J().l(context, j3, a, zb3Var);
                case 3:
                    oy2 oy2Var = (oy2) j(unitedSchemeEntity, oy2.class);
                    if (k(oy2Var, a)) {
                        return false;
                    }
                    return gv2.J().j(context, oy2Var, a, zb3Var);
                case 4:
                    ny2 ny2Var = (ny2) j(unitedSchemeEntity, ny2.class);
                    if (k(ny2Var, a)) {
                        return false;
                    }
                    return gv2.J().h(context, ny2Var, a, zb3Var);
                case 5:
                    ly2 j4 = j(unitedSchemeEntity, ly2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return gv2.J().m(context, j4, a, zb3Var);
                case 6:
                    ky2 ky2Var = (ky2) j(unitedSchemeEntity, ky2.class);
                    if (k(ky2Var, a)) {
                        return false;
                    }
                    return gv2.J().b(context, ky2Var, a, zb3Var);
                case 7:
                    ly2 j5 = j(unitedSchemeEntity, ly2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return gv2.J().c(context, j5, a, zb3Var);
                case '\b':
                    ly2 j6 = j(unitedSchemeEntity, ly2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return gv2.J().n(context, j6, a, zb3Var);
                case '\t':
                    ly2 j7 = j(unitedSchemeEntity, ly2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return gv2.J().k(context, j7, a, zb3Var);
                case '\n':
                    jy2 jy2Var = (jy2) j(unitedSchemeEntity, jy2.class);
                    if (k(jy2Var, a)) {
                        return false;
                    }
                    return gv2.J().e(context, jy2Var, a, zb3Var);
                case 11:
                    py2 py2Var = (py2) j(unitedSchemeEntity, py2.class);
                    if (k(py2Var, a)) {
                        return false;
                    }
                    return gv2.J().a(context, py2Var, a, zb3Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, zb3Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends ly2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    z82.c("map", "params string is empty");
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
                    z82.c("map", "params json parse error");
                    return t;
                }
            }
            z82.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(ly2 ly2Var, iy2 iy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, ly2Var, iy2Var)) == null) {
            if (ly2Var == null) {
                z82.c("map", "parse error, model is null");
                iy2Var.d(202);
                return true;
            }
            if (yb3.K().q().y0()) {
                ly2Var.c = rr3.c().h();
            }
            if (TextUtils.isEmpty(ly2Var.c)) {
                String B = tp3.B();
                if (!TextUtils.isEmpty(B)) {
                    ly2Var.c = B;
                }
                z82.o("map", "webView id is empty, use current webView");
            }
            if (tp3.m(ly2Var.c) == null) {
                iy2Var.d(202);
                z82.c("map", "can not find weiView by id " + ly2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
