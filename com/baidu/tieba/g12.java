package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ew2;
import com.baidu.tieba.jz1;
import com.baidu.tieba.kz1;
import com.baidu.tieba.mg3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g12 extends e12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.kz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "SettingApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a extends jz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ g12 e;

        /* renamed from: com.baidu.tieba.g12$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0302a implements aq3<kg3<JSONObject>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ jz1.b a;

            public C0302a(a aVar, jz1.b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.aq3
            /* renamed from: b */
            public void a(kg3<JSONObject> kg3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                    if (kg3Var.c() && kg3Var.a != null) {
                        this.a.a(new h32(0, kg3Var.a));
                        hb3 q = gb3.K().q();
                        q.e0().B(h.a(q), kg3Var.a.toString());
                        h82.i("SettingApi", "getSwanId success");
                        return;
                    }
                    this.a.a(new h32(10001, "getSwanId failed: internal_error"));
                    h82.c("SettingApi", "getSwanId failed: internal_error");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g12 g12Var, String str, JSONObject jSONObject) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g12Var, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = g12Var;
            this.d = jSONObject;
        }

        @Override // com.baidu.tieba.jz1
        @NonNull
        public h32 d(@NonNull JSONObject jSONObject, @NonNull jz1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                if (f53.e() && this.e.C(this.d)) {
                    bVar.a(new h32(0, this.d));
                    return new h32(0);
                }
                h82.i("SettingApi", "getSwanId start");
                if (!SwanAppNetworkUtils.i(this.e.getContext())) {
                    h82.c("SettingApi", "network_error");
                    return new h32(10002, "network_error");
                }
                pg3 e = gb3.K().x().a().b().e(this.e.getContext());
                e.o(new C0302a(this, bVar));
                e.call();
                return new h32(0);
            }
            return (h32) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.jz1
        @NonNull
        public h32 e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
                return new h32(0, this.d);
            }
            return (h32) invokeL.objValue;
        }

        @Override // com.baidu.tieba.jz1
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (!f53.e()) {
                    return false;
                }
                return this.e.C(this.d);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements kz1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g12 a;

        public b(g12 g12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g12Var;
        }

        @Override // com.baidu.tieba.kz1.a
        public h32 a(hb3 hb3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, hb3Var, jSONObject, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                g12.L(this.a.a().f(), str);
                return h32.f();
            }
            return (h32) invokeLLL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements aq3<Map<String, hg3>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;

        public c(CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, str};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(Map<String, hg3> map) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
                if (map == null) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, hg3> entry : map.entrySet()) {
                        String d = hg3.d(entry.getKey());
                        hg3 value = entry.getValue();
                        if (!TextUtils.isEmpty(d) && value != null && value.b() && !value.d && TextUtils.equals("2", value.e)) {
                            if (wo3.f("3.320.0")) {
                                if (value.a()) {
                                    str = "1";
                                } else {
                                    str = "0";
                                }
                                jSONObject.put(d, str);
                            } else {
                                jSONObject.put(d, value.a());
                            }
                        }
                    }
                    if (wo3.f("3.320.0")) {
                        this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                        return;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("authSetting", jSONObject);
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
                } catch (JSONException unused) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements aq3<tg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ g12 c;

        public d(g12 g12Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g12Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = g12Var;
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(tg3 tg3Var) {
            h32 h32Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tg3Var) == null) {
                h82.b("OpenData", "onOpenDataCallback:: ", tg3Var);
                if (tg3Var.E()) {
                    h32Var = new h32(0, tg3Var.g);
                    ai3.T(this.a, "success");
                } else {
                    int a = (int) tg3Var.j.a();
                    String f = fg3.f(a);
                    h32 h32Var2 = new h32(a, f);
                    pu2.j().c(this.c.a().f(), h32Var2.a());
                    ai3.U(this.a, "fail", f);
                    h32Var = h32Var2;
                }
                this.c.d(this.b, h32Var);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ g12 e;

        public e(g12 g12Var, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g12Var, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = g12Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (fg3.h(kg3Var)) {
                    this.e.E(this.a, this.b, this.c, this.d);
                    return;
                }
                h82.k("SettingApi", "onCallback: no permission scope_userinfo_api");
                this.e.d(this.b, new h32(402));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements tr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ g12 f;

        public f(g12 g12Var, String str, String str2, String str3, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g12Var, str, str2, str3, activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = g12Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = activity;
            this.e = str4;
        }

        @Override // com.baidu.tieba.tr1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    ai3.S("fail", 3, this.a);
                    ai3.U(this.b, "fail", "login failed");
                    this.f.d(this.c, new h32(10004, "user not logged in"));
                    return;
                }
                ai3.S("success", 3, this.a);
                this.f.K(false, this.c, this.d, this.e, "snsapi_userinfo", this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements tr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;
        public final /* synthetic */ g12 g;

        public g(g12 g12Var, String str, String str2, String str3, boolean z, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g12Var, str, str2, str3, Boolean.valueOf(z), activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = g12Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = activity;
            this.f = str4;
        }

        @Override // com.baidu.tieba.tr1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    ai3.S("fail", 3, this.a);
                    ai3.U(this.b, "fail", "result code = " + i);
                    this.g.d(this.c, new h32(10004, "user not logged in"));
                    return;
                }
                ai3.S("success", 3, this.a);
                this.g.K(this.d, this.c, this.e, this.f, "snsapi_userinfo", this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(hb3 hb3Var) {
            InterceptResult invokeL;
            String O;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, hb3Var)) == null) {
                if (hb3Var == null) {
                    O = gb3.K().q().O();
                } else {
                    O = hb3Var.O();
                }
                return "aiapp_" + O + "getSwanId";
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g12(@NonNull iz1 iz1Var) {
        super(iz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((iz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final boolean C(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
                return false;
            }
            String optString = optJSONObject.optString("swanid");
            if (TextUtils.isEmpty(optString) || TextUtils.equals(StringUtil.NULL_STRING, optString)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public h32 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#getSwanId", false);
            hb3 q = gb3.K().q();
            return m(str, new a(this, "getSwanId", ho3.d(q.e0().q(h.a(q), null))));
        }
        return (h32) invokeL.objValue;
    }

    public static JSONObject D(hb3 hb3Var, Context context) throws JSONException {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, hb3Var, context)) == null) {
            ew2.a W = hb3Var.W();
            String T2 = W.T();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", W.H());
            jSONObject.put("appname", W.K());
            if (!TextUtils.isEmpty(W.Q())) {
                jSONObject.put(GameAssistConstKt.KEY_ICONURL, W.Q());
            }
            if (!TextUtils.isEmpty(W.W())) {
                jSONObject.put("appLaunchScheme", W.W());
            } else {
                jSONObject.put("appLaunchScheme", "");
            }
            PMSAppInfo f0 = W.f0();
            if (f0 != null) {
                String str2 = f0.description;
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("appDesc", str2);
                }
                String str3 = f0.paNumber;
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("pa", str3);
                }
                jSONObject.put("isOpenCustomerService", bp3.Q());
            }
            String i = ou2.h0().i(context);
            jSONObject.put("cuid", i);
            jSONObject.put("mtjCuid", i);
            jSONObject.put("clkid", W.L());
            jSONObject.put("scene", T2);
            jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, W.H());
            jSONObject.put("appKey", W.I());
            jSONObject.put("pkgType", W.getType());
            jSONObject.put("bundleId", W.H());
            Bundle P = W.P();
            if (P != null) {
                String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(PrefetchEvent.EVENT_DATA_EXTRA_DATA, new JSONObject(string));
                }
                String string2 = P.getString("srcAppId");
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject.put("srcAppId", string2);
                }
                String string3 = P.getString("srcAppPage");
                if (!TextUtils.isEmpty(string3)) {
                    jSONObject.put("srcAppPage", string3);
                }
                String string4 = P.getString("srcAppKey");
                if (!TextUtils.isEmpty(string4)) {
                    jSONObject.put("srcAppKey", string4);
                }
                jSONObject.put("srcPkgType", P.getInt("srcPkgType"));
                if (TextUtils.isEmpty(T2)) {
                    T2 = "NA";
                }
                String string5 = P.getString("ubc");
                if (!TextUtils.isEmpty(string5)) {
                    jSONObject.put("rootSource", kr4.a(new JSONObject(string5), "pre_source", T2));
                }
                SwanAppActivity activity = uw2.T().getActivity();
                String str4 = "sys";
                if (activity == null) {
                    str = "sys";
                } else {
                    str = activity.W();
                }
                if (!TextUtils.isEmpty(str)) {
                    str4 = str;
                }
                jSONObject.put("showBy", str4);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void L(CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, callbackHandler, str) == null) {
            f33.h(new c(callbackHandler, str));
        }
    }

    public h32 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#getSetting", false);
            return l(str, true, new b(this));
        }
        return (h32) invokeL.objValue;
    }

    public final void E(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            hb3 q = gb3.K().q();
            SwanAppActivity w = q.w();
            ur1 N = q.N();
            if (N.e(w)) {
                K(false, str2, w, str, "snsapi_userinfo", str4);
                return;
            }
            ai3.T(str4, "getUserInfoLogin");
            N.f(w, null, new f(this, str3, str4, str2, w, str));
        }
    }

    public h32 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#getAppInfoSync", false);
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                h82.b("SettingApi", "illegal swanApp");
                return new h32(1001, "illegal swanApp");
            }
            JSONObject d2 = v43.c().d("getAppInfoSync");
            if (d2 == null) {
                try {
                    d2 = D(b0, getContext());
                    v43.c().h("getAppInfoSync", d2);
                } catch (JSONException e2) {
                    h82.c("SettingApi", Log.getStackTraceString(e2));
                    return new h32(1001);
                }
            }
            return new h32(0, d2);
        }
        return (h32) invokeV.objValue;
    }

    public h32 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#getSlaveIdSync", false);
            String containerId = a().e().getContainerId();
            if (TextUtils.isEmpty(containerId)) {
                return new h32(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slaveId", containerId);
                return new h32(0, jSONObject);
            } catch (JSONException unused) {
                return new h32(1001);
            }
        }
        return (h32) invokeV.objValue;
    }

    public h32 J(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#getUserInfo", false);
            ss1 j = pu2.j();
            hb3 q = gb3.K().q();
            CallbackHandler f2 = a().f();
            if (q == null) {
                j.c(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return new h32(1001, "empty swanApp");
            } else if (TextUtils.isEmpty(q.O())) {
                j.c(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
                return new h32(1001, "empty clientId");
            } else {
                JSONObject r = kz1.r(str);
                if (r == null) {
                    j.c(f2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    return new h32(201, "empty joParams");
                }
                String f3 = f73.f(r.optString("__plugin__", null));
                boolean z = !TextUtils.isEmpty(f3);
                boolean j2 = fg3.j(r);
                if (!j2 && !z) {
                    str2 = "getUserInfoApi";
                } else {
                    str2 = "getUserInfoButton";
                }
                String str3 = str2;
                ai3.T(str3, "create");
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    j.c(f2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    ai3.U(str3, "fail", "empty cb");
                    return new h32(201, "empty cb");
                }
                SwanAppActivity w = q.w();
                if (w == null) {
                    j.c(f2, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                    ai3.U(str3, "fail", "the context is not an activity");
                    return new h32(1001, "the context is not an activity");
                }
                String optString2 = r.optString("invokeFrom");
                if (!q.N().e(w)) {
                    ai3.S("show", 3, optString2);
                }
                if (!j2 && !z) {
                    M(f3, optString, optString2, str3);
                } else {
                    N(f3, j2, optString, optString2, str3);
                }
                return new h32(0);
            }
        }
        return (h32) invokeL.objValue;
    }

    public final void K(boolean z, String str, Activity activity, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, activity, str2, str3, str4}) == null) {
            ai3.T(str4, "requestOpenData");
            ai3.T(str4, "checkScope");
            tg3.B(activity, str3, str2, z, str4, new d(this, str4, str));
        }
    }

    public final void M(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4) == null) {
            ai3.T(str4, "checkScope");
            gb3.K().q().e0().g(getContext(), "scope_userinfo_api", new e(this, str, str2, str3, str4));
        }
    }

    public final void N(String str, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
            hb3 q = gb3.K().q();
            SwanAppActivity w = q.w();
            ur1 N = q.N();
            if (N.e(w)) {
                K(z, str2, w, str, "snsapi_userinfo", str4);
                return;
            }
            ai3.T(str4, "getUserInfoLogin");
            N.f(w, null, new g(this, str3, str4, str2, z, w, str));
        }
    }
}
