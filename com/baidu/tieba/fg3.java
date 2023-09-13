package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.yy.gameassist.GameAssistConstKt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tieba.la3;
import com.baidu.tieba.mg3;
import com.baidu.tieba.ph3;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fg3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Map<String, d> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Context e = fg3.e();
                Toast.makeText(e, "aiapps-oauth :: " + this.a, 0).show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hg3 a;

        public b(hg3 hg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hg3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hg3Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                if (i != -2) {
                    if (i == -1) {
                        fg3.k("onPosBtn", Boolean.FALSE);
                        ai3.q("click", this.a.b, true);
                        fg3.d(this.a.b, true);
                    }
                } else {
                    fg3.k("onNegBtn", Boolean.FALSE);
                    ai3.q("click", this.a.b, false);
                    fg3.d(this.a.b, false);
                }
                pu2.n().a("na_authorize_end");
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hg3 a;

        public c(hg3 hg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hg3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hg3Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                fg3.k(GameAssistConstKt.TYPE_CALLBACK_CANCEL, Boolean.FALSE);
                ai3.q("click", this.a.b, false);
                fg3.d(this.a.b, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Set<cg3> a;

        public d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new HashSet();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947763127, "Lcom/baidu/tieba/fg3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947763127, "Lcom/baidu/tieba/fg3;");
                return;
            }
        }
        a = rr1.a;
        b = new HashMap();
    }

    public static Context e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return AppRuntime.getAppContext();
        }
        return (Context) invokeV.objValue;
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            b.clear();
        }
    }

    public static void k(String str, Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, bool) == null) {
            h82.k("aiapps-oauth", str);
            if (a && bool.booleanValue()) {
                bp3.a0(new a(str));
            }
        }
    }

    public static synchronized void t(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            synchronized (fg3.class) {
                s(10004, str, str2);
            }
        }
    }

    public static RequestBody b(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (TextUtils.isEmpty(key)) {
                    key = "";
                }
                if (TextUtils.isEmpty(value)) {
                    value = "";
                }
                if (a) {
                    k("query :: " + key + " = " + value, Boolean.FALSE);
                }
                builder.add(key, value);
            }
            return builder.build();
        }
        return (RequestBody) invokeL.objValue;
    }

    public static JSONObject c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            String C = ou2.o().C();
            if (jSONObject != null && !TextUtils.isEmpty(C)) {
                return jSONObject.optJSONObject(C);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static boolean h(kg3<mg3.e> kg3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, kg3Var)) == null) {
            if (kg3Var != null && kg3Var.c() && kg3Var.a.b) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean i(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            return TextUtils.equals(jSONObject.optString("invokeFrom"), "api");
        }
        return invokeL.booleanValue;
    }

    public static boolean j(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return false;
            }
            return TextUtils.equals(jSONObject.optString("invokeFrom"), "component");
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static void l(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, runnable) == null) {
            bp3.a0(runnable);
        }
    }

    public static void d(String str, boolean z) {
        d remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, str, z) == null) {
            synchronized (b) {
                remove = b.remove(str);
            }
            if (remove != null && !remove.a.isEmpty()) {
                for (cg3 cg3Var : remove.a) {
                    if (cg3Var != null) {
                        cg3Var.onResult(z);
                    }
                }
            }
        }
    }

    public static String f(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            switch (i) {
                case 10001:
                    str = "internal error";
                    break;
                case 10002:
                    str = SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR;
                    break;
                case 10003:
                    str = "user deny";
                    break;
                case 10004:
                    str = "user not logged in";
                    break;
                case 10005:
                    str = "system deny";
                    break;
                case 10006:
                    str = "no data";
                    break;
                default:
                    str = "Permission denied";
                    break;
            }
            if (a) {
                Log.w("OAuthUtils", i + " " + str);
            }
            return str;
        }
        return (String) invokeI.objValue;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public static String g() {
        InterceptResult invokeV;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                PackageInfo packageInfo = e().getPackageManager().getPackageInfo(e().getPackageName(), 64);
                if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                    return "";
                }
                return nr4.d(signatureArr[0].toByteArray(), false);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static synchronized void m(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, jSONObject) == null) {
            synchronized (fg3.class) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null && optJSONObject.has("code")) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("code", 1);
                        jSONObject.put("data", jSONObject2);
                    } catch (JSONException e) {
                        if (a) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void n(tg3 tg3Var, CallbackHandler callbackHandler, String str) {
        an3 an3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65550, null, tg3Var, callbackHandler, str) == null) && tg3Var != null && (an3Var = tg3Var.j) != null) {
            int i = -1;
            try {
                i = (int) an3Var.a();
            } catch (ClassCastException e) {
                if (a) {
                    Log.e("OAuthUtils", e.toString());
                }
            }
            if (i < 0) {
                return;
            }
            o(i, callbackHandler, str);
        }
    }

    public static void o(int i, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeILL(65551, null, i, callbackHandler, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        String f = f(i);
        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, f).toString());
        h82.o("OAuthUtils", "authorize failed : " + f);
    }

    public static void p(kg3<mg3.e> kg3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, kg3Var, callbackHandler, unitedSchemeEntity) == null) {
            if (kg3Var != null && kg3Var.a() != null) {
                int b2 = kg3Var.b();
                String f = f(b2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b2, f));
                h82.o("OAuthUtils", "authorize failed : " + f);
                return;
            }
            h82.c("OAuthUtils", "authorize failed : result is invalid");
        }
    }

    public static void q(kg3<mg3.e> kg3Var, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, kg3Var, callbackHandler, str) == null) {
            if (kg3Var != null && kg3Var.a() != null) {
                o(kg3Var.b(), callbackHandler, str);
            } else {
                h82.c("OAuthUtils", "authorize failed : result is invalid");
            }
        }
    }

    public static void s(int i, @NonNull String str, @NonNull String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65555, null, i, str, str2) == null) {
            try {
                String g0 = hb3.g0();
                if (TextUtils.isEmpty(g0)) {
                    g0 = "NotSwanAppProcess";
                }
                String str4 = str + "===";
                if (str2.length() > 1024) {
                    str3 = (str4 + str2.substring(0, 1024)) + "...";
                } else {
                    str3 = str4 + str2;
                }
                ph3.b bVar = new ph3.b(i);
                bVar.h(g0);
                bVar.i(str3);
                bVar.m();
                h82.k("OAuthUtils", "error reported: " + i + " ,content: " + str3);
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void u(Context context, hb3 hb3Var, hg3 hg3Var, JSONObject jSONObject, cg3 cg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65557, null, context, hb3Var, hg3Var, jSONObject, cg3Var) == null) {
            if (hg3Var != null && !TextUtils.isEmpty(hg3Var.b)) {
                synchronized (b) {
                    d dVar = b.get(hg3Var.b);
                    if (dVar != null) {
                        dVar.a.add(cg3Var);
                        return;
                    }
                    d dVar2 = new d(hg3Var.b);
                    dVar2.a.add(cg3Var);
                    b.put(hg3Var.b, dVar2);
                    b bVar = new b(hg3Var);
                    c cVar = new c(hg3Var);
                    ai3.q("show", hg3Var.b, false);
                    pu2.n().a("na_authorize_start");
                    v(context, hb3Var, hg3Var, jSONObject, bVar, cVar);
                    return;
                }
            }
            cg3Var.onResult(false);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void v(Context context, hb3 hb3Var, hg3 hg3Var, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{context, hb3Var, hg3Var, jSONObject, onClickListener, onCancelListener}) == null) {
            la3.a a2 = ou2.i0().a(context, hb3Var, hg3Var, jSONObject, onClickListener);
            if (a2 == null) {
                if (!a) {
                    return;
                }
                throw new RuntimeException("auth dialog builder is null");
            }
            la3 c2 = a2.c();
            c2.a(false);
            c2.setOnCancelListener(onCancelListener);
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f1003ba);
            }
            if (hb3Var == null) {
                w = null;
            } else {
                w = hb3Var.w();
            }
            if (w != null && !w.isFinishing()) {
                c2.show();
            }
        }
    }
}
