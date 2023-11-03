package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hz1 extends ez1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hz1(d73 d73Var) {
        super(d73Var, "/swanAPI/canvas/insert");
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
                super((d73) objArr2[0], (String) objArr2[1]);
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
            e12 k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = l(201);
                g32.c("SwanAppCanvas", "insert action parse model is null");
                return false;
            } else if (context == null) {
                g32.c("SwanAppCanvas", "context is null");
                unitedSchemeEntity.result = l(1001);
                return false;
            } else {
                String str = k.b;
                mw2 mw2Var = k.h;
                if (!TextUtils.isEmpty(str) && mw2Var != null && mw2Var.h()) {
                    y12 w = new g22(context, k).w();
                    boolean a = w.a();
                    if (!a) {
                        g32.c("SwanAppCanvas", "insert canvas fail: " + w.b);
                    }
                    j(unitedSchemeEntity, callbackHandler, a);
                    return a;
                }
                g32.c("SwanAppCanvas", "canvas id is empty or position is null");
                unitedSchemeEntity.result = l(202);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
