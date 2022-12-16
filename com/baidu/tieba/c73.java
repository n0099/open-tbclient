package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.it1;
import com.baidu.tieba.j93;
import com.baidu.tieba.jt1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class c73 extends b63 implements jt1.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CallbackHandler c;

    /* loaded from: classes3.dex */
    public class a implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ it1.c b;
        public final /* synthetic */ e43 c;
        public final /* synthetic */ c73 d;

        public a(c73 c73Var, CallbackHandler callbackHandler, it1.c cVar, e43 e43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c73Var, callbackHandler, cVar, e43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = c73Var;
            this.a = callbackHandler;
            this.b = cVar;
            this.c = e43Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                this.d.k(h93Var, this.a, this.b, this.c.n0());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c73(b53 b53Var) {
        super(b53Var, "/swanAPI/getLocation");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b53Var};
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

    @Override // com.baidu.tieba.jt1.c
    public void b(it1.c cVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048576, this, cVar, i) != null) || this.c == null) {
            return;
        }
        e12.c("GetLocationAction", "request location error code : " + i);
        this.c.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(i).toString());
    }

    @Override // com.baidu.tieba.jt1.c
    public void g(it1.c cVar, d73 d73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, d73Var) == null) {
            if (b63.b) {
                Log.d("GetLocationAction", "convert info : " + d73Var.a());
            }
            CallbackHandler callbackHandler = this.c;
            if (callbackHandler == null) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(d73Var.a(), 0).toString());
        }
    }

    @Override // com.baidu.tieba.b63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, e43Var)) == null) {
            if (b63.b) {
                Log.d("GetLocationAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = callbackHandler;
            if (e43Var == null) {
                e12.c("location", "swan app is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            it1.c b = it1.c.b(unitedSchemeEntity.getParam("params"));
            if (b != null && b.a()) {
                if (TextUtils.isEmpty(b.c)) {
                    e12.c("location", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                e43Var.e0().g(context, "mapp_location", new a(this, callbackHandler, b, e43Var));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            e12.c("location", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.baidu.tieba.jt1.c
    public void f(it1.c cVar, String str) {
        CallbackHandler callbackHandler;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, str) != null) || (callbackHandler = this.c) == null) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(10005, "system deny").toString());
    }

    public final void k(h93<j93.e> h93Var, CallbackHandler callbackHandler, it1.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{h93Var, callbackHandler, cVar, Boolean.valueOf(z)}) == null) {
            e12.i("GetLocationAction", "authorized result is " + h93Var);
            if (c93.h(h93Var)) {
                jt1.d().e(cVar, this, z);
                return;
            }
            int b = h93Var.b();
            callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(b, c93.f(b)).toString());
        }
    }
}
