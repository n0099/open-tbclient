package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.l02;
import com.baidu.tieba.m02;
import com.baidu.tieba.mg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class fe3 extends ed3 implements m02.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CallbackHandler c;

    /* loaded from: classes5.dex */
    public class a implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ l02.c b;
        public final /* synthetic */ hb3 c;
        public final /* synthetic */ fe3 d;

        public a(fe3 fe3Var, CallbackHandler callbackHandler, l02.c cVar, hb3 hb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fe3Var, callbackHandler, cVar, hb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fe3Var;
            this.a = callbackHandler;
            this.b = cVar;
            this.c = hb3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                this.d.k(kg3Var, this.a, this.b, this.c.n0());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fe3(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/getLocation");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
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

    @Override // com.baidu.tieba.m02.c
    public void b(l02.c cVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048576, this, cVar, i) != null) || this.c == null) {
            return;
        }
        h82.c("GetLocationAction", "request location error code : " + i);
        this.c.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(i).toString());
    }

    @Override // com.baidu.tieba.m02.c
    public void g(l02.c cVar, ge3 ge3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, ge3Var) == null) {
            if (ed3.b) {
                Log.d("GetLocationAction", "convert info : " + ge3Var.a());
            }
            CallbackHandler callbackHandler = this.c;
            if (callbackHandler == null) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(ge3Var.a(), 0).toString());
        }
    }

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (ed3.b) {
                Log.d("GetLocationAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = callbackHandler;
            if (hb3Var == null) {
                h82.c("location", "swan app is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            l02.c b = l02.c.b(unitedSchemeEntity.getParam("params"));
            if (b != null && b.a()) {
                if (TextUtils.isEmpty(b.c)) {
                    h82.c("location", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                hb3Var.e0().g(context, "mapp_location", new a(this, callbackHandler, b, hb3Var));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            h82.c("location", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.m02.c
    public void f(l02.c cVar, String str) {
        CallbackHandler callbackHandler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, str) != null) || (callbackHandler = this.c) == null) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(10005, "system deny").toString());
    }

    public final void k(kg3<mg3.e> kg3Var, CallbackHandler callbackHandler, l02.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{kg3Var, callbackHandler, cVar, Boolean.valueOf(z)}) == null) {
            h82.i("GetLocationAction", "authorized result is " + kg3Var);
            if (fg3.h(kg3Var)) {
                m02.d().e(cVar, this, z);
                return;
            }
            int b = kg3Var.b();
            callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(b, fg3.f(b)).toString());
        }
    }
}
