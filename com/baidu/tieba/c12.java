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
import com.baidu.tieba.aw2;
import com.baidu.tieba.fz1;
import com.baidu.tieba.gz1;
import com.baidu.tieba.ig3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c12 extends a12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.gz1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? "SettingApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a extends fz1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ c12 e;

        /* renamed from: com.baidu.tieba.c12$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0257a implements wp3<gg3<JSONObject>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ fz1.b a;

            public C0257a(a aVar, fz1.b bVar) {
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
            @Override // com.baidu.tieba.wp3
            /* renamed from: b */
            public void a(gg3<JSONObject> gg3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                    if (gg3Var.c() && gg3Var.a != null) {
                        this.a.a(new d32(0, gg3Var.a));
                        db3 q = cb3.K().q();
                        q.e0().B(h.a(q), gg3Var.a.toString());
                        d82.i("SettingApi", "getSwanId success");
                        return;
                    }
                    this.a.a(new d32(10001, "getSwanId failed: internal_error"));
                    d82.c("SettingApi", "getSwanId failed: internal_error");
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c12 c12Var, String str, JSONObject jSONObject) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c12Var, str, jSONObject};
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
            this.e = c12Var;
            this.d = jSONObject;
        }

        @Override // com.baidu.tieba.fz1
        @NonNull
        public d32 d(@NonNull JSONObject jSONObject, @NonNull fz1.b bVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
                if (b53.e() && this.e.C(this.d)) {
                    bVar.a(new d32(0, this.d));
                    return new d32(0);
                }
                d82.i("SettingApi", "getSwanId start");
                if (!SwanAppNetworkUtils.i(this.e.getContext())) {
                    d82.c("SettingApi", "network_error");
                    return new d32(10002, "network_error");
                }
                lg3 e = cb3.K().x().a().b().e(this.e.getContext());
                e.o(new C0257a(this, bVar));
                e.call();
                return new d32(0);
            }
            return (d32) invokeLL.objValue;
        }

        @Override // com.baidu.tieba.fz1
        @NonNull
        public d32 e(@NonNull JSONObject jSONObject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
                return new d32(0, this.d);
            }
            return (d32) invokeL.objValue;
        }

        @Override // com.baidu.tieba.fz1
        public boolean i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (!b53.e()) {
                    return false;
                }
                return this.e.C(this.d);
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements gz1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c12 a;

        public b(c12 c12Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c12Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c12Var;
        }

        @Override // com.baidu.tieba.gz1.a
        public d32 a(db3 db3Var, JSONObject jSONObject, @Nullable String str) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, db3Var, jSONObject, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                c12.L(this.a.a().e(), str);
                return d32.f();
            }
            return (d32) invokeLLL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements wp3<Map<String, dg3>> {
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
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(Map<String, dg3> map) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, map) == null) {
                if (map == null) {
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry<String, dg3> entry : map.entrySet()) {
                        String d = dg3.d(entry.getKey());
                        dg3 value = entry.getValue();
                        if (!TextUtils.isEmpty(d) && value != null && value.b() && !value.d && TextUtils.equals("2", value.e)) {
                            if (so3.f("3.320.0")) {
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
                    if (so3.f("3.320.0")) {
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

    /* loaded from: classes5.dex */
    public class d implements wp3<pg3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ c12 c;

        public d(c12 c12Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c12Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = c12Var;
            this.a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(pg3 pg3Var) {
            d32 d32Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pg3Var) == null) {
                d82.b("OpenData", "onOpenDataCallback:: ", pg3Var);
                if (pg3Var.E()) {
                    d32Var = new d32(0, pg3Var.g);
                    wh3.T(this.a, "success");
                } else {
                    int a = (int) pg3Var.j.a();
                    String f = bg3.f(a);
                    d32 d32Var2 = new d32(a, f);
                    lu2.j().c(this.c.a().e(), d32Var2.a());
                    wh3.U(this.a, "fail", f);
                    d32Var = d32Var2;
                }
                this.c.d(this.b, d32Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements wp3<gg3<ig3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ c12 e;

        public e(c12 c12Var, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c12Var, str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = c12Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.wp3
        /* renamed from: b */
        public void a(gg3<ig3.e> gg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg3Var) == null) {
                if (bg3.h(gg3Var)) {
                    this.e.E(this.a, this.b, this.c, this.d);
                    return;
                }
                d82.k("SettingApi", "onCallback: no permission scope_userinfo_api");
                this.e.d(this.b, new d32(402));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements pr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Activity d;
        public final /* synthetic */ String e;
        public final /* synthetic */ c12 f;

        public f(c12 c12Var, String str, String str2, String str3, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c12Var, str, str2, str3, activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = c12Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = activity;
            this.e = str4;
        }

        @Override // com.baidu.tieba.pr1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    wh3.S("fail", 3, this.a);
                    wh3.U(this.b, "fail", "login failed");
                    this.f.d(this.c, new d32(10004, "user not logged in"));
                    return;
                }
                wh3.S("success", 3, this.a);
                this.f.K(false, this.c, this.d, this.e, "snsapi_userinfo", this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements pr1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Activity e;
        public final /* synthetic */ String f;
        public final /* synthetic */ c12 g;

        public g(c12 c12Var, String str, String str2, String str3, boolean z, Activity activity, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c12Var, str, str2, str3, Boolean.valueOf(z), activity, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = c12Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = activity;
            this.f = str4;
        }

        @Override // com.baidu.tieba.pr1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    wh3.S("fail", 3, this.a);
                    wh3.U(this.b, "fail", "result code = " + i);
                    this.g.d(this.c, new d32(10004, "user not logged in"));
                    return;
                }
                wh3.S("success", 3, this.a);
                this.g.K(this.d, this.c, this.e, this.f, "snsapi_userinfo", this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static String a(db3 db3Var) {
            InterceptResult invokeL;
            String O;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, db3Var)) == null) {
                if (db3Var == null) {
                    O = cb3.K().q().O();
                } else {
                    O = db3Var.O();
                }
                return "aiapp_" + O + "getSwanId";
            }
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c12(@NonNull ez1 ez1Var) {
        super(ez1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ez1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ez1) newInitContext.callArgs[0]);
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

    public d32 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#getSwanId", false);
            db3 q = cb3.K().q();
            return m(str, new a(this, "getSwanId", do3.d(q.e0().q(h.a(q), null))));
        }
        return (d32) invokeL.objValue;
    }

    public static JSONObject D(db3 db3Var, Context context) throws JSONException {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, db3Var, context)) == null) {
            aw2.a W = db3Var.W();
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
                jSONObject.put("isOpenCustomerService", xo3.Q());
            }
            String i = ku2.h0().i(context);
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
                    jSONObject.put("rootSource", gr4.a(new JSONObject(string5), "pre_source", T2));
                }
                SwanAppActivity activity = qw2.T().getActivity();
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
            b33.h(new c(callbackHandler, str));
        }
    }

    public d32 G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#getSetting", false);
            return l(str, true, new b(this));
        }
        return (d32) invokeL.objValue;
    }

    public final void E(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, str4) == null) {
            db3 q = cb3.K().q();
            SwanAppActivity w = q.w();
            qr1 N = q.N();
            if (N.e(w)) {
                K(false, str2, w, str, "snsapi_userinfo", str4);
                return;
            }
            wh3.T(str4, "getUserInfoLogin");
            N.f(w, null, new f(this, str3, str4, str2, w, str));
        }
    }

    public d32 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#getAppInfoSync", false);
            db3 b0 = db3.b0();
            if (b0 == null) {
                d82.b("SettingApi", "illegal swanApp");
                return new d32(1001, "illegal swanApp");
            }
            JSONObject d2 = r43.c().d("getAppInfoSync");
            if (d2 == null) {
                try {
                    d2 = D(b0, getContext());
                    r43.c().h("getAppInfoSync", d2);
                } catch (JSONException e2) {
                    d82.c("SettingApi", Log.getStackTraceString(e2));
                    return new d32(1001);
                }
            }
            return new d32(0, d2);
        }
        return (d32) invokeV.objValue;
    }

    public d32 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#getSlaveIdSync", false);
            String containerId = a().d().getContainerId();
            if (TextUtils.isEmpty(containerId)) {
                return new d32(1001);
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("slaveId", containerId);
                return new d32(0, jSONObject);
            } catch (JSONException unused) {
                return new d32(1001);
            }
        }
        return (d32) invokeV.objValue;
    }

    public d32 J(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            q("#getUserInfo", false);
            os1 j = lu2.j();
            db3 q = cb3.K().q();
            CallbackHandler e2 = a().e();
            if (q == null) {
                j.c(e2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return new d32(1001, "empty swanApp");
            } else if (TextUtils.isEmpty(q.O())) {
                j.c(e2, UnitedSchemeUtility.wrapCallbackParams(1001, "empty clientId").toString());
                return new d32(1001, "empty clientId");
            } else {
                JSONObject r = gz1.r(str);
                if (r == null) {
                    j.c(e2, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                    return new d32(201, "empty joParams");
                }
                String f2 = b73.f(r.optString("__plugin__", null));
                boolean z = !TextUtils.isEmpty(f2);
                boolean j2 = bg3.j(r);
                if (!j2 && !z) {
                    str2 = "getUserInfoApi";
                } else {
                    str2 = "getUserInfoButton";
                }
                String str3 = str2;
                wh3.T(str3, "create");
                String optString = r.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    j.c(e2, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                    wh3.U(str3, "fail", "empty cb");
                    return new d32(201, "empty cb");
                }
                SwanAppActivity w = q.w();
                if (w == null) {
                    j.c(e2, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString());
                    wh3.U(str3, "fail", "the context is not an activity");
                    return new d32(1001, "the context is not an activity");
                }
                String optString2 = r.optString("invokeFrom");
                if (!q.N().e(w)) {
                    wh3.S("show", 3, optString2);
                }
                if (!j2 && !z) {
                    M(f2, optString, optString2, str3);
                } else {
                    N(f2, j2, optString, optString2, str3);
                }
                return new d32(0);
            }
        }
        return (d32) invokeL.objValue;
    }

    public final void K(boolean z, String str, Activity activity, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), str, activity, str2, str3, str4}) == null) {
            wh3.T(str4, "requestOpenData");
            wh3.T(str4, "checkScope");
            pg3.B(activity, str3, str2, z, str4, new d(this, str4, str));
        }
    }

    public final void M(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3, str4) == null) {
            wh3.T(str4, "checkScope");
            cb3.K().q().e0().g(getContext(), "scope_userinfo_api", new e(this, str, str2, str3, str4));
        }
    }

    public final void N(String str, boolean z, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Boolean.valueOf(z), str2, str3, str4}) == null) {
            db3 q = cb3.K().q();
            SwanAppActivity w = q.w();
            qr1 N = q.N();
            if (N.e(w)) {
                K(z, str2, w, str, "snsapi_userinfo", str4);
                return;
            }
            wh3.T(str4, "getUserInfoLogin");
            N.f(w, null, new g(this, str3, str4, str2, z, w, str));
        }
    }
}
