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
import com.baidu.tieba.yc3;
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
/* loaded from: classes3.dex */
public class bw1 extends yv1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.wv1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "LoginApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public class a implements mm3<wc3<yc3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t73 a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ bw1 g;

        public a(bw1 bw1Var, t73 t73Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bw1Var, t73Var, activity, jSONObject, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = bw1Var;
            this.a = t73Var;
            this.b = activity;
            this.c = jSONObject;
            this.d = callbackHandler;
            this.e = str;
            this.f = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(wc3<yc3.e> wc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wc3Var) == null) {
                if (rc3.h(wc3Var)) {
                    if (bw1.f) {
                        Log.i("LoginApi", "onCallback: has permissionscope_login_api");
                    }
                    bw1.D(this.a, this.b, this.c, this.d, this.e, true, this.f);
                    return;
                }
                if (!this.a.N().e(this.b)) {
                    me3.S("check_fail", 1, "api");
                }
                int b = wc3Var.b();
                String f = rc3.f(b);
                bw1 bw1Var = this.g;
                bw1Var.p("#login errCode=" + b + " errMsg=" + f, null, false);
                this.g.d(this.e, new tz1(b, rc3.f(b)));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements mm3<wc3<cd3.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ d d;
        public final /* synthetic */ CallbackHandler e;
        public final /* synthetic */ String f;
        public final /* synthetic */ t73 g;
        public final /* synthetic */ String h;

        public b(boolean z, boolean z2, JSONObject jSONObject, d dVar, CallbackHandler callbackHandler, String str, t73 t73Var, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), jSONObject, dVar, callbackHandler, str, t73Var, str2};
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
            this.g = t73Var;
            this.h = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(wc3<cd3.d> wc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wc3Var) == null) {
                t42.k("LoginApi", "#handleLogin errCode=" + wc3Var.b() + " error=" + wc3Var.a());
                if (!wc3Var.c()) {
                    if (!this.a && this.b) {
                        me3.S(com.baidu.pass.biometrics.face.liveness.b.a.g0, 1, this.c.optString("invokeFrom"));
                        t42.k("LoginApi", "Error: login failed from api-invoking.");
                    }
                    int b = wc3Var.b();
                    t42.o("LoginApi", b + " " + this.d.toString());
                    String f = rc3.f(b);
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    br2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(b, f).toString());
                    bw1.J(this.g, 43, b, f);
                    String str = "#handleLogin [login failed] errCode=" + b + " errMsg=" + f;
                    t42.k("LoginApi", str);
                    me3.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                if (!this.a && this.b) {
                    me3.S("success", 1, this.c.optString("invokeFrom"));
                    t42.k("LoginApi", "Success: login success from api-invoking.");
                }
                if (bw1.G(this.c)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                    t42.k("LoginApi", "Success: login success from component-invoking.");
                    me3.U(this.h, "success", "Success: login success from component-invoking.");
                    return;
                }
                me3.T(this.h, "getLoginCodeStart");
                if (TextUtils.isEmpty(wc3Var.a.a)) {
                    this.e.handleSchemeDispatchCallback(this.f, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    br2.j().f(this.e, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                    bw1.J(this.g, 43, 1001, "empty code");
                    me3.U(this.h, com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty code");
                    return;
                }
                String optString = this.c.optString("__plugin__");
                if (!TextUtils.isEmpty(optString)) {
                    bw1.E(optString, this.g, this.e, this.f, wc3Var, this.h);
                } else {
                    bw1.F(this.g, this.e, this.f, wc3Var, this.h);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements mm3<fd3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ t73 e;
        public final /* synthetic */ wc3 f;

        public c(CallbackHandler callbackHandler, String str, String str2, String str3, t73 t73Var, wc3 wc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str, str2, str3, t73Var, wc3Var};
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
            this.e = t73Var;
            this.f = wc3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm3
        /* renamed from: b */
        public void a(fd3 fd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fd3Var) == null) {
                if (fd3Var == null || !fd3Var.D()) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(403, "permission denied").toString());
                    String str = "Error: scope snsapi_userinfopermission denied plugin appkey : " + this.c + " from plugin-invoking.";
                    t42.k("LoginApi", str);
                    me3.U(this.d, com.baidu.pass.biometrics.face.liveness.b.a.g0, str);
                    return;
                }
                bw1.F(this.e, this.a, this.b, this.f, this.d);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                t42.o("LoginApi", "timeout is a minus：" + toString());
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947659277, "Lcom/baidu/tieba/bw1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947659277, "Lcom/baidu/tieba/bw1;");
                return;
            }
        }
        f = do1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bw1(@NonNull uv1 uv1Var) {
        super(uv1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uv1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((uv1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void D(t73 t73Var, Activity activity, JSONObject jSONObject, CallbackHandler callbackHandler, String str, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{t73Var, activity, jSONObject, callbackHandler, str, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("invokeFrom");
            boolean e = t73Var.N().e(activity);
            if (!e) {
                me3.S("show", 1, optString);
            }
            d dVar = new d(jSONObject);
            t73Var.e0().r(activity, dVar, null, new b(e, z, jSONObject, dVar, callbackHandler, str, t73Var, str2), str2);
        }
    }

    public static void E(String str, t73 t73Var, CallbackHandler callbackHandler, String str2, wc3<cd3.d> wc3Var, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{str, t73Var, callbackHandler, str2, wc3Var, str3}) == null) {
            SwanAppActivity w = t73Var.w();
            if (w == null) {
                callbackHandler.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(1001, "swan activity is null").toString());
                t42.k("LoginApi", "Error: activity is null from plugin-invoking.");
                me3.U(str3, com.baidu.pass.biometrics.face.liveness.b.a.g0, "swan activity is null");
                return;
            }
            String f2 = r33.f(str);
            fd3.B(w, "snsapi_userinfo", f2, false, str3, new c(callbackHandler, str2, f2, str3, t73Var, wc3Var));
        }
    }

    public static void F(t73 t73Var, CallbackHandler callbackHandler, String str, wc3<cd3.d> wc3Var, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65542, null, t73Var, callbackHandler, str, wc3Var, str2) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", wc3Var.a.a);
                t42.k("LoginApi", "Success: call back msg = " + jSONObject.toString());
                z53.c.e();
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, wc3Var.b()).toString());
                me3.T(str2, "success");
            } catch (JSONException e) {
                if (f) {
                    e.printStackTrace();
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                br2.j().f(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                J(t73Var, 43, 1001, e.getMessage());
                String str3 = "Error: exception = " + e.getMessage() + " stack trace = " + Arrays.toString(e.getStackTrace());
                t42.k("LoginApi", str3);
                me3.U(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, str3);
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

    public static void J(t73 t73Var, int i, int i2, String str) {
        int k;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65544, null, new Object[]{t73Var, Integer.valueOf(i), Integer.valueOf(i2), str}) != null) || t73Var == null || (k = t73Var.k()) != 0) {
            return;
        }
        mj3 mj3Var = new mj3();
        mj3Var.k(5L);
        mj3Var.i(i);
        ue3 ue3Var = new ue3();
        ue3Var.p(mj3Var);
        ue3Var.r(t73Var.Y());
        ue3Var.q(me3.n(k));
        ue3Var.m(t73.g0());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errorCode", i2);
            jSONObject.put("errorMessage", str);
        } catch (JSONException e) {
            if (f) {
                e.printStackTrace();
            }
        }
        ue3Var.e(jSONObject);
        me3.R(ue3Var);
    }

    public tz1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            q("#getLoginCode", false);
            if (f) {
                Log.d("LoginApi", "#getLoginCode params=" + str);
            }
            me3.T("getLoginCode", "create");
            CallbackHandler g = a().g();
            t73 b0 = t73.b0();
            if (b0 == null) {
                br2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                return new tz1(1001, "swan app is null");
            } else if (!b0.N().e(getContext())) {
                me3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                return new tz1(10004, "user not logged in");
            } else {
                JSONObject r = wv1.r(str);
                if (r == null) {
                    br2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    J(b0, 1, 201, "empty joParams");
                    me3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new tz1(201, "empty joParams");
                }
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    br2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                    J(b0, 1, 201, "cb is empty");
                    me3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new tz1(201, "cb is empty");
                }
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    me3.T("getLoginCode", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                    return new tz1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!s73.K().q().N().e(context)) {
                    me3.T("getLoginCode", "passLogin");
                }
                D(b0, activity, r, g, optString, false, "getLoginCode");
                return tz1.f();
            }
        }
        return (tz1) invokeL.objValue;
    }

    public tz1 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#isLoginSync", false);
            t73 b0 = t73.b0();
            if (b0 == null) {
                t42.c("LoginApi", "swan app is null");
                return new tz1(202, "swan app is null");
            }
            JSONObject d2 = h13.c().d("isLoginSync");
            if (d2 == null) {
                try {
                    d2 = new JSONObject();
                    d2.put("isLogin", b0.N().e(getContext()));
                    h13.c().h("isLoginSync", d2);
                } catch (JSONException unused) {
                    t42.c("LoginApi", "json put data fail");
                    return new tz1(1001);
                }
            }
            return new tz1(0, d2);
        }
        return (tz1) invokeV.objValue;
    }

    public tz1 I(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#login params=" + str, false);
            t73 b0 = t73.b0();
            CallbackHandler g = a().g();
            if (b0 == null) {
                br2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                t42.k("LoginApi", "Error: swan app is null");
                return new tz1(1001, "swan app is null");
            }
            JSONObject r = wv1.r(str);
            if (r == null) {
                br2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                J(b0, 1, 201, "empty joParams");
                p("Error: empty joParams", null, true);
                return new tz1(201, "empty joParams");
            }
            if (r.optString("invokeFrom").equals(NativeConstants.COMPONENT)) {
                str2 = "loginButton";
            } else {
                str2 = "loginApi";
            }
            String str3 = str2;
            me3.T(str3, "create");
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                br2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                J(b0, 1, 201, "cb is empty");
                p("Error: cb is empty", null, true);
                return new tz1(201, "cb is empty");
            } else if (!r.optBoolean(TTDownloadField.TT_FORCE, true) && !b0.N().e(getContext())) {
                g.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                br2.j().f(g, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                J(b0, 43, 10004, "user not logged in");
                q("Success: force login is false, will not force execute login.", false);
                return new tz1(0);
            } else {
                Context context = getContext();
                if (!(context instanceof Activity) && (context = b0.w()) == null) {
                    p("Error: context is not an activity", null, false);
                    return new tz1(1001, "the context is not an activity");
                }
                Activity activity = (Activity) context;
                if (!s73.K().q().N().e(context)) {
                    me3.T(str3, "passLogin");
                }
                String optString2 = r.optString("__plugin__");
                if (!TextUtils.isEmpty(optString2)) {
                    p("handleLogin by plugin: " + optString2, null, false);
                    D(b0, activity, r, g, optString, true, str3);
                    return new tz1(0);
                }
                if (!rc3.i(r)) {
                    D(b0, activity, r, g, optString, true, str3);
                } else {
                    s73.K().q().e0().g(getContext(), "scope_login_api", new a(this, b0, activity, r, g, optString, str3));
                }
                return tz1.f();
            }
        }
        return (tz1) invokeL.objValue;
    }
}
