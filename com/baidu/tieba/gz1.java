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
import com.baidu.tieba.dg3;
import com.baidu.tieba.hg3;
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
/* loaded from: classes6.dex */
public class gz1 extends dz1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.bz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements rp3<bg3<dg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ya3 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ gz1 g;

        public a(gz1 gz1Var, ya3 ya3Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gz1Var, ya3Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = gz1Var;
            this.a = ya3Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(bg3<dg3.e> bg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bg3Var) == null) {
                if (wf3.h(bg3Var)) {
                    if (gz1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    gz1.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    rh3.S("check_fail", 1, "api");
                }
                int b = bg3Var.b();
                String f = wf3.f(b);
                gz1 gz1Var = this.g;
                gz1Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new y22(b, wf3.f(b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements rp3<bg3<hg3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ya3 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, ya3 ya3Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, ya3Var, str2};
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
            this.g = ya3Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(bg3<hg3.d> bg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bg3Var) == null) {
                y72.k("LoginApi", "#handleLogin errCode=" + bg3Var.b() + " error=" + bg3Var.a());
                if (!bg3Var.c()) {
                    if (!this.a && this.b) {
                        rh3.S("fail", 1, this.c.optString("invokeFrom"));
                        y72.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = bg3Var.b();
                    y72.o("LoginApi", b + " " + this.d.toString());
                    String f = wf3.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    gu2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    gz1.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    y72.k("LoginApi", str);
                    rh3.U(this.h, "fail", str);
                    return;
                }
                if (!this.a && this.b) {
                    rh3.S("success", 1, this.c.optString("invokeFrom"));
                    y72.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (gz1.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    y72.k("LoginApi", "Success: login success from component-invoking.");
                    rh3.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                rh3.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(bg3Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    gu2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    gz1.J(this.g, 43, 1001, "empty code");
                    rh3.U(this.h, "fail", "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    gz1.E(optString, this.g, this.e, this.f, bg3Var, this.h);
                } else {
                    gz1.F(this.g, this.e, this.f, bg3Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements rp3<kg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ ya3 e;
        public final /* synthetic */ bg3 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, ya3 ya3Var, bg3 bg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, ya3Var, bg3Var};
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
            this.e = ya3Var;
            this.f = bg3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rp3
        /* renamed from: b */
        public void a(kg3 kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (kg3Var == null || !kg3Var.D()) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                    y72.k("LoginApi", str);
                    rh3.U(this.d, "fail", str);
                    return;
                }
                gz1.F(this.e, this.a, this.b, this.f, this.d);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                y72.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947811115, "Lcom/baidu/tieba/gz1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947811115, "Lcom/baidu/tieba/gz1;");
                return;
            }
        }
        f = ir1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gz1(@NonNull zy1 zy1Var) {
        super(zy1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zy1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zy1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(ya3 ya3Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{ya3Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = ya3Var.N().e(activity);
            if (!e) {
                rh3.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            ya3Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, ya3Var, str2), str2);
        }
    }

    public static void E(String str, ya3 ya3Var, CallbackHandler callbackHandler, String str2, bg3<hg3.d> bg3Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, ya3Var, callbackHandler, str2, bg3Var, str3}) == null) {
            SwanAppActivity w = ya3Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                y72.k("LoginApi", "Error: activity is null from plugin-invoking.");
                rh3.U(str3, "fail", "swan activity is null");
                return;
            }
            String f2 = w63.f(str);
            kg3.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, ya3Var, bg3Var));
        }
    }

    public static void F(ya3 ya3Var, CallbackHandler callbackHandler, String str, bg3<hg3.d> bg3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, ya3Var, callbackHandler, str, bg3Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", bg3Var.a.a);
                y72.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                e93.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, bg3Var.b()).toString());
                rh3.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                gu2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(ya3Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                y72.k("LoginApi", str3);
                rh3.U(str2, "fail", str3);
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

    public static void J(ya3 ya3Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{ya3Var, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || ya3Var == null || (k = ya3Var.k()) != 0) {
            return;
        }
        rm3 rm3Var = new rm3();
        rm3Var.k(5L);
        rm3Var.i(i);
        zh3 zh3Var = new zh3();
        zh3Var.p(rm3Var);
        zh3Var.r(ya3Var.Y());
        zh3Var.q(rh3.n(k));
        zh3Var.m(ya3.g0());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i2);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            if (f) {
                e.printStackTrace();
            }
        }
        zh3Var.e(jSONObject);
        rh3.R(zh3Var);
    }

    public y22 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            rh3.T("getLoginCode", "create");
            CallbackHandler e = a().e();
            ya3 b0 = ya3.b0();
            if (b0 == null) {
                gu2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new y22(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                rh3.T("getLoginCode", "fail");
                return new y22(10004, "user not logged in");
            } else {
                JSONObject r = bz1.r(str);
                if (r == null) {
                    gu2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    rh3.T("getLoginCode", "fail");
                    return new y22(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    gu2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    rh3.T("getLoginCode", "fail");
                    return new y22(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    rh3.T("getLoginCode", "fail");
                    return new y22(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!xa3.K().q().N().e(context)) {
                    rh3.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, e, optString, false, "getLoginCode");
                return y22.f();
            }
        }
        return (y22) invokeL.objValue;
    }

    public y22 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            ya3 b0 = ya3.b0();
            if (b0 == null) {
                y72.c("LoginApi", "swan app is null");
                return new y22(202, "swan app is null");
            }
            JSONObject d2 = m43.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    m43.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    y72.c("LoginApi", "json put data fail");
                    return new y22(1001);
                }
            }
            return new y22(0, d2);
        }
        return (y22) invokeV.objValue;
    }

    public y22 I(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            ya3 b0 = ya3.b0();
            CallbackHandler e = a().e();
            if (b0 == null) {
                gu2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                y72.k("LoginApi", "Error: swan app is null");
                return new y22(1001, "swan app is null");
            }
            JSONObject r = bz1.r(str);
            if (r == null) {
                gu2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new y22(201, "empty joParams");
            }
            if (r.optString("invokeFrom").equals("component")) {
                str2 = "loginButton";
            } else {
                str2 = "loginApi";
            }
            String str3 = str2;
            rh3.T(str3, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                gu2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new y22(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !b0.N().e(getContext())) {
                e.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                gu2.j().f(e, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new y22(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new y22(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!xa3.K().q().N().e(context)) {
                    rh3.T(str3, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, e, optString, true, str3);
                    return new y22(0);
                }
                if (!wf3.i(r)) {
                    D(b0, activity, r, e, optString, true, str3);
                } else {
                    xa3.K().q().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, e, optString, str3));
                }
                return y22.f();
            }
        }
        return (y22) invokeL.objValue;
    }
}
