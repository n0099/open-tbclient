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
import com.baidu.tieba.cd3;
import com.baidu.tieba.gd3;
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
public class fw1 extends cw1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.aw1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a implements qm3<ad3<cd3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ x73 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ fw1 g;

        public a(fw1 fw1Var, x73 x73Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fw1Var, x73Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = fw1Var;
            this.a = x73Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(ad3<cd3.e> ad3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ad3Var) == null) {
                if (vc3.h(ad3Var)) {
                    if (fw1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    fw1.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    qe3.S("check_fail", 1, "api");
                }
                int b = ad3Var.b();
                String f = vc3.f(b);
                fw1 fw1Var = this.g;
                fw1Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new xz1(b, vc3.f(b)));
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements qm3<ad3<gd3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ x73 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, x73 x73Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, x73Var, str2};
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
            this.g = x73Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(ad3<gd3.d> ad3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ad3Var) == null) {
                x42.k("LoginApi", "#handleLogin errCode=" + ad3Var.b() + " error=" + ad3Var.a());
                if (!ad3Var.c()) {
                    if (!this.a && this.b) {
                        qe3.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.c.optString("invokeFrom"));
                        x42.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = ad3Var.b();
                    x42.o("LoginApi", b + " " + this.d.toString());
                    String f = vc3.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    fr2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    fw1.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    x42.k("LoginApi", str);
                    qe3.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.a && this.b) {
                    qe3.S("success", 1, this.c.optString("invokeFrom"));
                    x42.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (fw1.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    x42.k("LoginApi", "Success: login success from component-invoking.");
                    qe3.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                qe3.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(ad3Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    fr2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    fw1.J(this.g, 43, 1001, "empty code");
                    qe3.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    fw1.E(optString, this.g, this.e, this.f, ad3Var, this.h);
                } else {
                    fw1.F(this.g, this.e, this.f, ad3Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements qm3<jd3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ x73 e;
        public final /* synthetic */ ad3 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, x73 x73Var, ad3 ad3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, x73Var, ad3Var};
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
            this.e = x73Var;
            this.f = ad3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qm3
        /* renamed from: b */
        public void a(jd3 jd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jd3Var) == null) {
                if (jd3Var == null || !jd3Var.D()) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                    x42.k("LoginApi", str);
                    qe3.U(this.d, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                fw1.F(this.e, this.a, this.b, this.f, this.d);
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
                x42.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947778441, "Lcom/baidu/tieba/fw1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947778441, "Lcom/baidu/tieba/fw1;");
                return;
            }
        }
        f = ho1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fw1(@NonNull yv1 yv1Var) {
        super(yv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {yv1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((yv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(x73 x73Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{x73Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = x73Var.N().e(activity);
            if (!e) {
                qe3.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            x73Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, x73Var, str2), str2);
        }
    }

    public static void E(String str, x73 x73Var, CallbackHandler callbackHandler, String str2, ad3<gd3.d> ad3Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, x73Var, callbackHandler, str2, ad3Var, str3}) == null) {
            SwanAppActivity w = x73Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                x42.k("LoginApi", "Error: activity is null from plugin-invoking.");
                qe3.U(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "swan activity is null");
                return;
            }
            String f2 = v33.f(str);
            jd3.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, x73Var, ad3Var));
        }
    }

    public static void F(x73 x73Var, CallbackHandler callbackHandler, String str, ad3<gd3.d> ad3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, x73Var, callbackHandler, str, ad3Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", ad3Var.a.a);
                x42.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                d63.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, ad3Var.b()).toString());
                qe3.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                fr2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(x73Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                x42.k("LoginApi", str3);
                qe3.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
            }
        }
    }

    public static boolean G(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) {
            return NativeConstants.COMPONENT.equals(jSONObject.optString("invokeFrom"));
        }
        return invokeL.booleanValue;
    }

    public static void J(x73 x73Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{x73Var, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || x73Var == null || (k = x73Var.k()) != 0) {
            return;
        }
        qj3 qj3Var = new qj3();
        qj3Var.k(5L);
        qj3Var.i(i);
        ye3 ye3Var = new ye3();
        ye3Var.p(qj3Var);
        ye3Var.r(x73Var.Y());
        ye3Var.q(qe3.n(k));
        ye3Var.m(x73.g0());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i2);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            if (f) {
                e.printStackTrace();
            }
        }
        ye3Var.e(jSONObject);
        qe3.R(ye3Var);
    }

    public xz1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            qe3.T("getLoginCode", "create");
            CallbackHandler f2 = a().f();
            x73 b0 = x73.b0();
            if (b0 == null) {
                fr2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new xz1(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                qe3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new xz1(10004, "user not logged in");
            } else {
                JSONObject r = aw1.r(str);
                if (r == null) {
                    fr2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    qe3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new xz1(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    fr2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    qe3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new xz1(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    qe3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new xz1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!w73.K().q().N().e(context)) {
                    qe3.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, f2, optString, false, "getLoginCode");
                return xz1.f();
            }
        }
        return (xz1) invokeL.objValue;
    }

    public xz1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            x73 b0 = x73.b0();
            if (b0 == null) {
                x42.c("LoginApi", "swan app is null");
                return new xz1(202, "swan app is null");
            }
            JSONObject d2 = l13.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    l13.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    x42.c("LoginApi", "json put data fail");
                    return new xz1(1001);
                }
            }
            return new xz1(0, d2);
        }
        return (xz1) invokeV.objValue;
    }

    public xz1 I(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            x73 b0 = x73.b0();
            CallbackHandler f2 = a().f();
            if (b0 == null) {
                fr2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                x42.k("LoginApi", "Error: swan app is null");
                return new xz1(1001, "swan app is null");
            }
            JSONObject r = aw1.r(str);
            if (r == null) {
                fr2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new xz1(201, "empty joParams");
            }
            if (r.optString("invokeFrom").equals(NativeConstants.COMPONENT)) {
                str2 = "loginButton";
            } else {
                str2 = "loginApi";
            }
            String str3 = str2;
            qe3.T(str3, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                fr2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new xz1(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !b0.N().e(getContext())) {
                f2.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                fr2.j().f(f2, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new xz1(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new xz1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!w73.K().q().N().e(context)) {
                    qe3.T(str3, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, f2, optString, true, str3);
                    return new xz1(0);
                }
                if (!vc3.i(r)) {
                    D(b0, activity, r, f2, optString, true, str3);
                } else {
                    w73.K().q().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, f2, optString, str3));
                }
                return xz1.f();
            }
        }
        return (xz1) invokeL.objValue;
    }
}
