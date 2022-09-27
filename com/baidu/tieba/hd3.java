package com.baidu.tieba;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.ed3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class hd3 extends gd3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hd3(i43 i43Var) {
        super(i43Var, "/swanAPI/getBatteryInfoSync");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {i43Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((i43) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.i53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l33 l33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, l33Var)) == null) {
            if (j(context, l33Var, unitedSchemeEntity)) {
                ed3.a a = ed3.a(context);
                if (a == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "sticky broadcast receive error");
                    return false;
                }
                if (i53.b) {
                    Log.d("battery", "/swanAPI/getBatteryInfoSync = level: " + a.a + " ; plugged: " + a.b);
                }
                JSONObject k = k(a);
                if (k == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Json error");
                    if (i53.b) {
                        Log.d("SwanAppAction", "getBatteryInfoSync --- json error");
                    }
                    return false;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(k, 0);
                return true;
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
