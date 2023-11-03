package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a52 extends d83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a52(d73 d73Var) {
        super(d73Var, "/swanAPI/sConsole");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d73Var};
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

    @Override // com.baidu.tieba.d83
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, g63 g63Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, g63Var)) == null) {
            if (d83.b) {
                Log.d("ConsoleAction", "handle entity: " + unitedSchemeEntity.toString());
                return false;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.d83
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, g63 g63Var) {
        InterceptResult invokeLLLLL;
        boolean optBoolean;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, g63Var)) == null) {
            if (d83.b) {
                Log.d("ConsoleAction", "handleSubAction subAction: " + str);
            }
            if (!d32.a() && !g32.f() && !TextUtils.equals(str, "/swanAPI/sConsole/debugSwitch")) {
                return super.i(context, unitedSchemeEntity, callbackHandler, str, g63Var);
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            char c = 65535;
            switch (str.hashCode()) {
                case -1923550429:
                    if (str.equals("/swanAPI/sConsole/sanIncData2Console")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1792428120:
                    if (str.equals("/swanAPI/sConsole/sanFullData2Console")) {
                        c = 4;
                        break;
                    }
                    break;
                case -797920904:
                    if (str.equals("/swanAPI/sConsole/hide")) {
                        c = 2;
                        break;
                    }
                    break;
                case -797593805:
                    if (str.equals("/swanAPI/sConsole/show")) {
                        c = 1;
                        break;
                    }
                    break;
                case -161927599:
                    if (str.equals("/swanAPI/sConsole/postMessage")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1089933937:
                    if (str.equals("/swanAPI/sConsole/debugSwitch")) {
                        c = 0;
                        break;
                    }
                    break;
                case 2136057821:
                    if (str.equals("/swanAPI/sConsole/getSanDataFromActiveSlave")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (optParamsAsJo != null && (optBoolean = optParamsAsJo.optBoolean("enableDebug")) != d32.a()) {
                        d32.c(context, optBoolean);
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                        g32.i("ConsoleAction", " sConsole switch：" + optParamsAsJo.optBoolean("enableDebug"));
                    }
                    return true;
                case 1:
                    tr2.V().r().N(true);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    g32.i("ConsoleAction", "sConsole show");
                    return true;
                case 2:
                    tr2.V().r().N(false);
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    g32.i("ConsoleAction", "sConsole hide");
                    return true;
                case 3:
                    if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                        g32.i("ConsoleAction", "send san inc data");
                        b52.d(optParamsAsJo.toString());
                    } else {
                        g32.c("ConsoleAction", "san inc data is null");
                    }
                    return true;
                case 4:
                    if (optParamsAsJo != null && optParamsAsJo.length() > 0) {
                        g32.i("ConsoleAction", "send san full data");
                        b52.c(optParamsAsJo.toString());
                    } else {
                        g32.c("ConsoleAction", "san full data is null");
                    }
                    return true;
                case 5:
                    g32.i("ConsoleAction", "request san full data");
                    b52.b();
                    return true;
                case 6:
                    qn1 h = op2.h();
                    if (h != null) {
                        h.c(optParamsAsJo);
                    }
                    return true;
                default:
                    return super.i(context, unitedSchemeEntity, callbackHandler, str, g63Var);
            }
        }
        return invokeLLLLL.booleanValue;
    }
}
