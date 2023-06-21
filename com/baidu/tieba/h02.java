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
import com.baidu.tieba.eh3;
import com.baidu.tieba.ih3;
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
public class h02 extends e02 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.c02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements sq3<ch3<eh3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zb3 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ h02 g;

        public a(h02 h02Var, zb3 zb3Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h02Var, zb3Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = h02Var;
            this.a = zb3Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(ch3<eh3.e> ch3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ch3Var) == null) {
                if (xg3.h(ch3Var)) {
                    if (h02.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    h02.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    si3.S("check_fail", 1, "api");
                }
                int b = ch3Var.b();
                String f = xg3.f(b);
                h02 h02Var = this.g;
                h02Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new z32(b, xg3.f(b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements sq3<ch3<ih3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ zb3 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, zb3 zb3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, zb3Var, str2};
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
            this.g = zb3Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(ch3<ih3.d> ch3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ch3Var) == null) {
                z82.k("LoginApi", "#handleLogin errCode=" + ch3Var.b() + " error=" + ch3Var.a());
                if (!ch3Var.c()) {
                    if (!this.a && this.b) {
                        si3.S("fail", 1, this.c.optString("invokeFrom"));
                        z82.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = ch3Var.b();
                    z82.o("LoginApi", b + " " + this.d.toString());
                    String f = xg3.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    hv2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    h02.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    z82.k("LoginApi", str);
                    si3.U(this.h, "fail", str);
                    return;
                }
                if (!this.a && this.b) {
                    si3.S("success", 1, this.c.optString("invokeFrom"));
                    z82.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (h02.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    z82.k("LoginApi", "Success: login success from component-invoking.");
                    si3.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                si3.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(ch3Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    hv2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    h02.J(this.g, 43, 1001, "empty code");
                    si3.U(this.h, "fail", "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    h02.E(optString, this.g, this.e, this.f, ch3Var, this.h);
                } else {
                    h02.F(this.g, this.e, this.f, ch3Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements sq3<lh3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ zb3 e;
        public final /* synthetic */ ch3 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, zb3 zb3Var, ch3 ch3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, zb3Var, ch3Var};
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
            this.e = zb3Var;
            this.f = ch3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(lh3 lh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lh3Var) == null) {
                if (lh3Var == null || !lh3Var.D()) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                    z82.k("LoginApi", str);
                    si3.U(this.d, "fail", str);
                    return;
                }
                h02.F(this.e, this.a, this.b, this.f, this.d);
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
                z82.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947769823, "Lcom/baidu/tieba/h02;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947769823, "Lcom/baidu/tieba/h02;");
                return;
            }
        }
        f = js1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h02(@NonNull a02 a02Var) {
        super(a02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a02Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(zb3 zb3Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{zb3Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = zb3Var.N().e(activity);
            if (!e) {
                si3.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            zb3Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, zb3Var, str2), str2);
        }
    }

    public static void E(String str, zb3 zb3Var, CallbackHandler callbackHandler, String str2, ch3<ih3.d> ch3Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, zb3Var, callbackHandler, str2, ch3Var, str3}) == null) {
            SwanAppActivity w = zb3Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                z82.k("LoginApi", "Error: activity is null from plugin-invoking.");
                si3.U(str3, "fail", "swan activity is null");
                return;
            }
            String f2 = x73.f(str);
            lh3.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, zb3Var, ch3Var));
        }
    }

    public static void F(zb3 zb3Var, CallbackHandler callbackHandler, String str, ch3<ih3.d> ch3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, zb3Var, callbackHandler, str, ch3Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", ch3Var.a.a);
                z82.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                fa3.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, ch3Var.b()).toString());
                si3.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                hv2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(zb3Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                z82.k("LoginApi", str3);
                si3.U(str2, "fail", str3);
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

    public static void J(zb3 zb3Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{zb3Var, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || zb3Var == null || (k = zb3Var.k()) != 0) {
            return;
        }
        sn3 sn3Var = new sn3();
        sn3Var.k(5L);
        sn3Var.i(i);
        aj3 aj3Var = new aj3();
        aj3Var.p(sn3Var);
        aj3Var.r(zb3Var.Y());
        aj3Var.q(si3.n(k));
        aj3Var.m(zb3.g0());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i2);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            if (f) {
                e.printStackTrace();
            }
        }
        aj3Var.e(jSONObject);
        si3.R(aj3Var);
    }

    public z32 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            si3.T("getLoginCode", "create");
            CallbackHandler e = a().e();
            zb3 b0 = zb3.b0();
            if (b0 == null) {
                hv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new z32(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                si3.T("getLoginCode", "fail");
                return new z32(10004, "user not logged in");
            } else {
                JSONObject r = c02.r(str);
                if (r == null) {
                    hv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    si3.T("getLoginCode", "fail");
                    return new z32(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    hv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    si3.T("getLoginCode", "fail");
                    return new z32(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    si3.T("getLoginCode", "fail");
                    return new z32(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!yb3.K().q().N().e(context)) {
                    si3.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, e, optString, false, "getLoginCode");
                return z32.f();
            }
        }
        return (z32) invokeL.objValue;
    }

    public z32 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            zb3 b0 = zb3.b0();
            if (b0 == null) {
                z82.c("LoginApi", "swan app is null");
                return new z32(202, "swan app is null");
            }
            JSONObject d2 = n53.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    n53.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    z82.c("LoginApi", "json put data fail");
                    return new z32(1001);
                }
            }
            return new z32(0, d2);
        }
        return (z32) invokeV.objValue;
    }

    public z32 I(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            zb3 b0 = zb3.b0();
            CallbackHandler e = a().e();
            if (b0 == null) {
                hv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                z82.k("LoginApi", "Error: swan app is null");
                return new z32(1001, "swan app is null");
            }
            JSONObject r = c02.r(str);
            if (r == null) {
                hv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new z32(201, "empty joParams");
            }
            if (r.optString("invokeFrom").equals("component")) {
                str2 = "loginButton";
            } else {
                str2 = "loginApi";
            }
            String str3 = str2;
            si3.T(str3, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                hv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new z32(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !b0.N().e(getContext())) {
                e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                hv2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new z32(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new z32(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!yb3.K().q().N().e(context)) {
                    si3.T(str3, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, e, optString, true, str3);
                    return new z32(0);
                }
                if (!xg3.i(r)) {
                    D(b0, activity, r, e, optString, true, str3);
                } else {
                    yb3.K().q().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, e, optString, str3));
                }
                return z32.f();
            }
        }
        return (z32) invokeL.objValue;
    }
}
