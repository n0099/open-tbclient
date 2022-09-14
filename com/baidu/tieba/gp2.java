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
public class gp2 extends v43 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gp2(v33 v33Var) {
        super(v33Var, "/swanAPI/map");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v33Var};
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

    @Override // com.baidu.tieba.v43
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, y23 y23Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, y23Var)) == null) {
            if (v43.b) {
                Log.d("MapAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.v43
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, y23 y23Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, y23Var)) == null) {
            if (v43.b) {
                Log.d("MapAction", "handleSubAction subAction: " + str);
            }
            yz1.i("map", "handleSubAction " + str);
            hp2 a = hp2.a(unitedSchemeEntity, callbackHandler);
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
                    kp2 j = j(unitedSchemeEntity, kp2.class);
                    if (k(j, a)) {
                        return false;
                    }
                    return fm2.J().g(context, j, a, y23Var);
                case 1:
                    kp2 j2 = j(unitedSchemeEntity, kp2.class);
                    if (k(j2, a)) {
                        return false;
                    }
                    return fm2.J().update(context, j2, a, y23Var);
                case 2:
                    kp2 j3 = j(unitedSchemeEntity, kp2.class);
                    if (k(j3, a)) {
                        return false;
                    }
                    return fm2.J().l(context, j3, a, y23Var);
                case 3:
                    np2 np2Var = (np2) j(unitedSchemeEntity, np2.class);
                    if (k(np2Var, a)) {
                        return false;
                    }
                    return fm2.J().j(context, np2Var, a, y23Var);
                case 4:
                    mp2 mp2Var = (mp2) j(unitedSchemeEntity, mp2.class);
                    if (k(mp2Var, a)) {
                        return false;
                    }
                    return fm2.J().h(context, mp2Var, a, y23Var);
                case 5:
                    kp2 j4 = j(unitedSchemeEntity, kp2.class);
                    if (k(j4, a)) {
                        return false;
                    }
                    return fm2.J().m(context, j4, a, y23Var);
                case 6:
                    jp2 jp2Var = (jp2) j(unitedSchemeEntity, jp2.class);
                    if (k(jp2Var, a)) {
                        return false;
                    }
                    return fm2.J().b(context, jp2Var, a, y23Var);
                case 7:
                    kp2 j5 = j(unitedSchemeEntity, kp2.class);
                    if (k(j5, a)) {
                        return false;
                    }
                    return fm2.J().c(context, j5, a, y23Var);
                case '\b':
                    kp2 j6 = j(unitedSchemeEntity, kp2.class);
                    if (k(j6, a)) {
                        return false;
                    }
                    return fm2.J().n(context, j6, a, y23Var);
                case '\t':
                    kp2 j7 = j(unitedSchemeEntity, kp2.class);
                    if (k(j7, a)) {
                        return false;
                    }
                    return fm2.J().k(context, j7, a, y23Var);
                case '\n':
                    ip2 ip2Var = (ip2) j(unitedSchemeEntity, ip2.class);
                    if (k(ip2Var, a)) {
                        return false;
                    }
                    return fm2.J().e(context, ip2Var, a, y23Var);
                case 11:
                    op2 op2Var = (op2) j(unitedSchemeEntity, op2.class);
                    if (k(op2Var, a)) {
                        return false;
                    }
                    return fm2.J().a(context, op2Var, a, y23Var);
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, y23Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }

    public <T extends kp2> T j(UnitedSchemeEntity unitedSchemeEntity, Class<T> cls) {
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
                    yz1.c("map", "params string is empty");
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
                    yz1.c("map", "params json parse error");
                    return t;
                }
            }
            yz1.c("map", "entity get Params is empty");
            return null;
        }
        return (T) invokeLL.objValue;
    }

    public final boolean k(kp2 kp2Var, hp2 hp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, kp2Var, hp2Var)) == null) {
            if (kp2Var == null) {
                yz1.c("map", "parse error, model is null");
                hp2Var.d(202);
                return true;
            }
            if (x23.K().q().y0()) {
                kp2Var.c = qi3.c().h();
            }
            if (TextUtils.isEmpty(kp2Var.c)) {
                String B = sg3.B();
                if (!TextUtils.isEmpty(B)) {
                    kp2Var.c = B;
                }
                yz1.o("map", "webView id is empty, use current webView");
            }
            if (sg3.m(kp2Var.c) == null) {
                hp2Var.d(202);
                yz1.c("map", "can not find weiView by id " + kp2Var.c);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
