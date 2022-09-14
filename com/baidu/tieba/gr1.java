package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.d83;
import com.baidu.tieba.h83;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gr1 extends dr1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements rh3<b83<d83.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ y23 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ gr1 g;

        public a(gr1 gr1Var, y23 y23Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gr1Var, y23Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = gr1Var;
            this.a = y23Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(b83<d83.e> b83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b83Var) == null) {
                if (w73.h(b83Var)) {
                    if (gr1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    gr1.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    r93.S("check_fail", 1, "api");
                }
                int b = b83Var.b();
                String f = w73.f(b);
                gr1 gr1Var = this.g;
                gr1Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new yu1(b, w73.f(b)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements rh3<b83<h83.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ y23 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, y23 y23Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, y23Var, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = z2;
            this.c = jSONObject;
            this.d = dVar;
            this.e = callbackHandler;
            this.f = str;
            this.g = y23Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(b83<h83.d> b83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b83Var) == null) {
                yz1.k("LoginApi", "#handleLogin errCode=" + b83Var.b() + " error=" + b83Var.a());
                if (!b83Var.c()) {
                    if (!this.a && this.b) {
                        r93.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.c.optString("invokeFrom"));
                        yz1.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = b83Var.b();
                    yz1.o("LoginApi", b + " " + this.d.toString());
                    String f = w73.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    gm2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    gr1.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    yz1.k("LoginApi", str);
                    r93.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.a && this.b) {
                    r93.S("success", 1, this.c.optString("invokeFrom"));
                    yz1.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (gr1.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    yz1.k("LoginApi", "Success: login success from component-invoking.");
                    r93.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                r93.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(b83Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    gm2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    gr1.J(this.g, 43, 1001, "empty code");
                    r93.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    gr1.E(optString, this.g, this.e, this.f, b83Var, this.h);
                } else {
                    gr1.F(this.g, this.e, this.f, b83Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements rh3<k83> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ y23 e;
        public final /* synthetic */ b83 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, y23 y23Var, b83 b83Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, y23Var, b83Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = y23Var;
            this.f = b83Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(k83 k83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k83Var) == null) {
                if (k83Var != null && k83Var.D()) {
                    gr1.F(this.e, this.a, this.b, this.f, this.d);
                    return;
                }
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                yz1.k("LoginApi", str);
                r93.U(this.d, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final boolean a;
        public final long b;

        public d(@NonNull JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONObject.has("timeout");
            long optLong = jSONObject.optLong("timeout", 0L);
            this.b = optLong;
            if (optLong < 0) {
                yz1.o("LoginApi", "timeout is a minus：" + toString());
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "LoginTimeoutConfig{enableTimeout=" + this.a + ", timeoutMills=" + this.b + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947803427, "Lcom/baidu/tieba/gr1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947803427, "Lcom/baidu/tieba/gr1;");
                return;
            }
        }
        f = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gr1(@NonNull zq1 zq1Var) {
        super(zq1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zq1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zq1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(y23 y23Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{y23Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = y23Var.N().e(activity);
            if (!e) {
                r93.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            y23Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, y23Var, str2), str2);
        }
    }

    public static void E(String str, y23 y23Var, CallbackHandler callbackHandler, String str2, b83<h83.d> b83Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, y23Var, callbackHandler, str2, b83Var, str3}) == null) {
            SwanAppActivity w = y23Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                yz1.k("LoginApi", "Error: activity is null from plugin-invoking.");
                r93.U(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "swan activity is null");
                return;
            }
            String f2 = wy2.f(str);
            k83.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, y23Var, b83Var));
        }
    }

    public static void F(y23 y23Var, CallbackHandler callbackHandler, String str, b83<h83.d> b83Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, y23Var, callbackHandler, str, b83Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", b83Var.a.a);
                yz1.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                e13.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, b83Var.b()).toString());
                r93.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                gm2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(y23Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                yz1.k("LoginApi", str3);
                r93.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
            }
        }
    }

    public static boolean G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) ? NativeConstants.COMPONENT.equals(jSONObject.optString("invokeFrom")) : invokeL.booleanValue;
    }

    public static void J(y23 y23Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{y23Var, Integer.valueOf(i), Integer.valueOf(i2), str}) == null) && y23Var != null && (k = y23Var.k()) == 0) {
            re3 re3Var = new re3();
            re3Var.k(5L);
            re3Var.i(i);
            z93 z93Var = new z93();
            z93Var.p(re3Var);
            z93Var.r(y23Var.Y());
            z93Var.q(r93.n(k));
            z93Var.m(y23.g0());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("errorCode", i2);
                jSONObject.put("errorMessage", str);
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
            }
            z93Var.e(jSONObject);
            r93.R(z93Var);
        }
    }

    public yu1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            r93.T("getLoginCode", "create");
            CallbackHandler g = a().g();
            y23 b0 = y23.b0();
            if (b0 == null) {
                gm2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new yu1(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                r93.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new yu1(10004, "user not logged in");
            } else {
                JSONObject r = br1.r(str);
                if (r == null) {
                    gm2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    r93.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new yu1(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    gm2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    r93.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new yu1(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    r93.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new yu1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!x23.K().q().N().e(context)) {
                    r93.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, g, optString, false, "getLoginCode");
                return yu1.f();
            }
        }
        return (yu1) invokeL.objValue;
    }

    public yu1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            y23 b0 = y23.b0();
            if (b0 == null) {
                yz1.c("LoginApi", "swan app is null");
                return new yu1(202, "swan app is null");
            }
            JSONObject d2 = mw2.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    mw2.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    yz1.c("LoginApi", "json put data fail");
                    return new yu1(1001);
                }
            }
            return new yu1(0, d2);
        }
        return (yu1) invokeV.objValue;
    }

    public yu1 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            y23 b0 = y23.b0();
            CallbackHandler g = a().g();
            if (b0 == null) {
                gm2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                yz1.k("LoginApi", "Error: swan app is null");
                return new yu1(1001, "swan app is null");
            }
            JSONObject r = br1.r(str);
            if (r == null) {
                gm2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new yu1(201, "empty joParams");
            }
            String str2 = r.optString("invokeFrom").equals(NativeConstants.COMPONENT) ? "loginButton" : "loginApi";
            r93.T(str2, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                gm2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new yu1(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !b0.N().e(getContext())) {
                g.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                gm2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new yu1(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new yu1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!x23.K().q().N().e(context)) {
                    r93.T(str2, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, g, optString, true, str2);
                    return new yu1(0);
                }
                if (!w73.i(r)) {
                    D(b0, activity, r, g, optString, true, str2);
                } else {
                    x23.K().q().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, g, optString, str2));
                }
                return yu1.f();
            }
        }
        return (yu1) invokeL.objValue;
    }

    @Override // com.baidu.tieba.br1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }
}
