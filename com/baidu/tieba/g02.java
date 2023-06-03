package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.dh3;
import com.baidu.tieba.hh3;
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
/* loaded from: classes5.dex */
public class g02 extends d02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.b02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements rq3<bh3<dh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yb3 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ g02 g;

        public a(g02 g02Var, yb3 yb3Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g02Var, yb3Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = g02Var;
            this.a = yb3Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(bh3<dh3.e> bh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bh3Var) == null) {
                if (wg3.h(bh3Var)) {
                    if (g02.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    g02.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    ri3.S("check_fail", 1, "api");
                }
                int b = bh3Var.b();
                String f = wg3.f(b);
                g02 g02Var = this.g;
                g02Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new y32(b, wg3.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements rq3<bh3<hh3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ yb3 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, yb3 yb3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, yb3Var, str2};
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
            this.g = yb3Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(bh3<hh3.d> bh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bh3Var) == null) {
                y82.k("LoginApi", "#handleLogin errCode=" + bh3Var.b() + " error=" + bh3Var.a());
                if (!bh3Var.c()) {
                    if (!this.a && this.b) {
                        ri3.S("fail", 1, this.c.optString("invokeFrom"));
                        y82.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = bh3Var.b();
                    y82.o("LoginApi", b + " " + this.d.toString());
                    String f = wg3.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    gv2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    g02.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    y82.k("LoginApi", str);
                    ri3.U(this.h, "fail", str);
                    return;
                }
                if (!this.a && this.b) {
                    ri3.S("success", 1, this.c.optString("invokeFrom"));
                    y82.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (g02.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    y82.k("LoginApi", "Success: login success from component-invoking.");
                    ri3.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                ri3.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(bh3Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    gv2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    g02.J(this.g, 43, 1001, "empty code");
                    ri3.U(this.h, "fail", "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    g02.E(optString, this.g, this.e, this.f, bh3Var, this.h);
                } else {
                    g02.F(this.g, this.e, this.f, bh3Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements rq3<kh3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ yb3 e;
        public final /* synthetic */ bh3 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, yb3 yb3Var, bh3 bh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, yb3Var, bh3Var};
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
            this.e = yb3Var;
            this.f = bh3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(kh3 kh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kh3Var) == null) {
                if (kh3Var == null || !kh3Var.D()) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                    y82.k("LoginApi", str);
                    ri3.U(this.d, "fail", str);
                    return;
                }
                g02.F(this.e, this.a, this.b, this.f, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
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
                y82.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947740032, "Lcom/baidu/tieba/g02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947740032, "Lcom/baidu/tieba/g02;");
                return;
            }
        }
        f = is1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g02(@NonNull zz1 zz1Var) {
        super(zz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zz1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(yb3 yb3Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{yb3Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = yb3Var.N().e(activity);
            if (!e) {
                ri3.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            yb3Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, yb3Var, str2), str2);
        }
    }

    public static void E(String str, yb3 yb3Var, CallbackHandler callbackHandler, String str2, bh3<hh3.d> bh3Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, yb3Var, callbackHandler, str2, bh3Var, str3}) == null) {
            SwanAppActivity w = yb3Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                y82.k("LoginApi", "Error: activity is null from plugin-invoking.");
                ri3.U(str3, "fail", "swan activity is null");
                return;
            }
            String f2 = w73.f(str);
            kh3.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, yb3Var, bh3Var));
        }
    }

    public static void F(yb3 yb3Var, CallbackHandler callbackHandler, String str, bh3<hh3.d> bh3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, yb3Var, callbackHandler, str, bh3Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", bh3Var.a.a);
                y82.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                ea3.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, bh3Var.b()).toString());
                ri3.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                gv2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(yb3Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                y82.k("LoginApi", str3);
                ri3.U(str2, "fail", str3);
            }
        }
    }

    public static boolean G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) {
            return "component".equals(jSONObject.optString("invokeFrom"));
        }
        return invokeL.booleanValue;
    }

    public static void J(yb3 yb3Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{yb3Var, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || yb3Var == null || (k = yb3Var.k()) != 0) {
            return;
        }
        rn3 rn3Var = new rn3();
        rn3Var.k(5L);
        rn3Var.i(i);
        zi3 zi3Var = new zi3();
        zi3Var.p(rn3Var);
        zi3Var.r(yb3Var.Y());
        zi3Var.q(ri3.n(k));
        zi3Var.m(yb3.g0());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i2);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            if (f) {
                e.printStackTrace();
            }
        }
        zi3Var.e(jSONObject);
        ri3.R(zi3Var);
    }

    public y32 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            ri3.T("getLoginCode", "create");
            CallbackHandler e = a().e();
            yb3 b0 = yb3.b0();
            if (b0 == null) {
                gv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new y32(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                ri3.T("getLoginCode", "fail");
                return new y32(10004, "user not logged in");
            } else {
                JSONObject r = b02.r(str);
                if (r == null) {
                    gv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    ri3.T("getLoginCode", "fail");
                    return new y32(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    gv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    ri3.T("getLoginCode", "fail");
                    return new y32(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    ri3.T("getLoginCode", "fail");
                    return new y32(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!xb3.K().q().N().e(context)) {
                    ri3.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, e, optString, false, "getLoginCode");
                return y32.f();
            }
        }
        return (y32) invokeL.objValue;
    }

    public y32 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            yb3 b0 = yb3.b0();
            if (b0 == null) {
                y82.c("LoginApi", "swan app is null");
                return new y32(202, "swan app is null");
            }
            JSONObject d2 = m53.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    m53.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    y82.c("LoginApi", "json put data fail");
                    return new y32(1001);
                }
            }
            return new y32(0, d2);
        }
        return (y32) invokeV.objValue;
    }

    public y32 I(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            yb3 b0 = yb3.b0();
            CallbackHandler e = a().e();
            if (b0 == null) {
                gv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                y82.k("LoginApi", "Error: swan app is null");
                return new y32(1001, "swan app is null");
            }
            JSONObject r = b02.r(str);
            if (r == null) {
                gv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new y32(201, "empty joParams");
            }
            if (r.optString("invokeFrom").equals("component")) {
                str2 = "loginButton";
            } else {
                str2 = "loginApi";
            }
            String str3 = str2;
            ri3.T(str3, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                gv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new y32(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !b0.N().e(getContext())) {
                e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                gv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new y32(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new y32(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!xb3.K().q().N().e(context)) {
                    ri3.T(str3, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, e, optString, true, str3);
                    return new y32(0);
                }
                if (!wg3.i(r)) {
                    D(b0, activity, r, e, optString, true, str3);
                } else {
                    xb3.K().q().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, e, optString, str3));
                }
                return y32.f();
            }
        }
        return (y32) invokeL.objValue;
    }
}
