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
/* loaded from: classes5.dex */
public class a52 extends s42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a52(sc3 sc3Var) {
        super(sc3Var, "/swanAPI/canvas/update");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sc3Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((sc3) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.sd3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, vb3Var)) == null) {
            s62 k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = l(201);
                v82.c("SwanAppCanvas", "update action parse model is null");
                return false;
            }
            String str = k.b;
            b23 b23Var = k.h;
            if (!TextUtils.isEmpty(str) && b23Var != null && b23Var.h()) {
                v72 v72Var = (v72) i82.a(k);
                if (v72Var == null) {
                    v82.c("SwanAppCanvas", "update canvas fail: fina a null component");
                    unitedSchemeEntity.result = l(1001);
                    return false;
                }
                m72 update = v72Var.update((v72) k);
                boolean a = update.a();
                if (!a) {
                    v82.c("SwanAppCanvas", "update canvas fail: " + update.b);
                }
                j(unitedSchemeEntity, callbackHandler, a);
                return a;
            }
            v82.c("SwanAppCanvas", "some params invalid");
            unitedSchemeEntity.result = l(202);
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
