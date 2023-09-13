package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.mg3;
import com.baidu.tieba.qa2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class by1 extends ed3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ qa2 d;
        public final /* synthetic */ by1 e;

        public a(by1 by1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, qa2 qa2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {by1Var, callbackHandler, unitedSchemeEntity, str, qa2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = by1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = str;
            this.d = qa2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (!fg3.h(kg3Var)) {
                    fg3.p(kg3Var, this.a, this.b);
                } else {
                    this.e.k(this.c, this.d, this.a, this.b);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public by1(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/openAdLandingPage");
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

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (ed3.b) {
                Log.d("OpenAdLandingPageAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String o = qe3.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                h82.i("AdLanding", "adLanding: url is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            qa2 U = uw2.T().U();
            if (U == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (TextUtils.equals(qe3.n(unitedSchemeEntity, "params", "invokeFrom"), "boxjs")) {
                k(o, U, callbackHandler, unitedSchemeEntity);
                return true;
            } else {
                hb3Var.e0().g(context, "mapp_i_open_adlanding", new a(this, callbackHandler, unitedSchemeEntity, o, U));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void j(h13 h13Var, qa2 qa2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h13Var, qa2Var) == null) {
            h82.i("AdLanding", "openAdLanding: page url=" + h13Var.c);
            qa2.b i = qa2Var.i("adLanding");
            i.n(qa2.g, qa2.i);
            i.k("adLanding", h13Var).b();
        }
    }

    public void k(String str, qa2 qa2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, qa2Var, callbackHandler, unitedSchemeEntity) == null) {
            j(h13.d(str, str), qa2Var);
            h82.i("AdLanding", "open adLanding page success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        }
    }
}
