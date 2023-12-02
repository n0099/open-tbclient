package com.baidu.tieba;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.alliance.login.SwanAppAllianceLoginHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.CookieManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class cu1 extends h83 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-878412787, "Lcom/baidu/tieba/cu1$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-878412787, "Lcom/baidu/tieba/cu1$a;");
                    return;
                }
            }
            a = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                y52.f3();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cu1(h73 h73Var) {
        super(h73Var, "/swanAPI/setTplBdussSync");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {h73Var};
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

    @Override // com.baidu.tieba.h83
    public boolean d(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler, k63 k63Var) {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, entity, callbackHandler, k63Var)) == null) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(entity);
            SwanAppAllianceLoginHelper.d.l(true);
            if (optParamsAsJo == null) {
                xm1 d = SwanAppAllianceLoginHelper.d.d();
                if (d != null) {
                    d.onResult(-1);
                }
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                SwanAppAllianceLoginHelper.d.a(yt1.d(), yt1.a());
                return false;
            }
            int optInt = optParamsAsJo.optInt("errno");
            JSONObject optJSONObject = optParamsAsJo.optJSONObject("data");
            ek3.a0(a.a);
            if (optInt != 0) {
                xm1 d2 = SwanAppAllianceLoginHelper.d.d();
                if (d2 != null) {
                    d2.onResult(-1);
                }
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "error number is " + optInt);
                SwanAppAllianceLoginHelper.d.a(yt1.d(), yt1.a());
                return false;
            } else if (optJSONObject != null) {
                Map<String, String> c = sm4.c(CookieManager.getInstance().getCookie(".baidu.com"));
                Intrinsics.checkNotNullExpressionValue(c, "SwanAppUrlUtils.parseCookie(cookieString)");
                String str = c.get("OPENBDUSS");
                if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    zt1.b.c(optInt, optJSONObject);
                    tt1.b(context, str);
                    SwanAppAllianceLoginHelper.d.j(true);
                    xm1 d3 = SwanAppAllianceLoginHelper.d.d();
                    if (d3 != null) {
                        d3.onResult(0);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, entity, 0);
                    SwanAppAllianceLoginHelper.d.a(yt1.f(), yt1.c());
                    return true;
                }
                xm1 d4 = SwanAppAllianceLoginHelper.d.d();
                if (d4 != null) {
                    d4.onResult(-1);
                }
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "bduss is null");
                SwanAppAllianceLoginHelper.d.a(yt1.d(), yt1.a());
                return false;
            } else {
                entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "json data is null");
                SwanAppAllianceLoginHelper.d.a(yt1.d(), yt1.a());
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
