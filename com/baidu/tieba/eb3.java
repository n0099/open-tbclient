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
import com.baidu.tieba.k53;
import com.baidu.tieba.lb3;
import com.baidu.tieba.oc3;
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
public final class eb3 {
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
                Context e = eb3.e();
                Toast.makeText(e, "aiapps-oauth :: " + this.a, 0).show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb3 a;

        public b(gb3 gb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gb3Var;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i) == null) {
                if (i != -2) {
                    if (i == -1) {
                        eb3.k("onPosBtn", Boolean.FALSE);
                        zc3.q("click", this.a.b, true);
                        eb3.d(this.a.b, true);
                    }
                } else {
                    eb3.k("onNegBtn", Boolean.FALSE);
                    zc3.q("click", this.a.b, false);
                    eb3.d(this.a.b, false);
                }
                op2.n().a("na_authorize_end");
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb3 a;

        public c(gb3 gb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gb3Var;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                eb3.k(GameAssistConstKt.TYPE_CALLBACK_CANCEL, Boolean.FALSE);
                zc3.q("click", this.a.b, false);
                eb3.d(this.a.b, false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Set<bb3> a;

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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947728531, "Lcom/baidu/tieba/eb3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947728531, "Lcom/baidu/tieba/eb3;");
                return;
            }
        }
        a = rm1.a;
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
            g32.k("aiapps-oauth", str);
            if (a && bool.booleanValue()) {
                ak3.a0(new a(str));
            }
        }
    }

    public static synchronized void t(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            synchronized (eb3.class) {
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
            String C = np2.o().C();
            if (jSONObject != null && !TextUtils.isEmpty(C)) {
                return jSONObject.optJSONObject(C);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static boolean h(jb3<lb3.e> jb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, jb3Var)) == null) {
            if (jb3Var != null && jb3Var.c() && jb3Var.a.b) {
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
            ak3.a0(runnable);
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
                for (bb3 bb3Var : remove.a) {
                    if (bb3Var != null) {
                        bb3Var.onResult(z);
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
                return lm4.d(signatureArr[0].toByteArray(), false);
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
            synchronized (eb3.class) {
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

    public static void n(sb3 sb3Var, CallbackHandler callbackHandler, String str) {
        zh3 zh3Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65550, null, sb3Var, callbackHandler, str) == null) && sb3Var != null && (zh3Var = sb3Var.j) != null) {
            int i = -1;
            try {
                i = (int) zh3Var.a();
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
        g32.o("OAuthUtils", "authorize failed : " + f);
    }

    public static void p(jb3<lb3.e> jb3Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, jb3Var, callbackHandler, unitedSchemeEntity) == null) {
            if (jb3Var != null && jb3Var.a() != null) {
                int b2 = jb3Var.b();
                String f = f(b2);
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b2, f));
                g32.o("OAuthUtils", "authorize failed : " + f);
                return;
            }
            g32.c("OAuthUtils", "authorize failed : result is invalid");
        }
    }

    public static void q(jb3<lb3.e> jb3Var, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, jb3Var, callbackHandler, str) == null) {
            if (jb3Var != null && jb3Var.a() != null) {
                o(jb3Var.b(), callbackHandler, str);
            } else {
                g32.c("OAuthUtils", "authorize failed : result is invalid");
            }
        }
    }

    public static void s(int i, @NonNull String str, @NonNull String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65555, null, i, str, str2) == null) {
            try {
                String h0 = g63.h0();
                if (TextUtils.isEmpty(h0)) {
                    h0 = "NotSwanAppProcess";
                }
                String str4 = str + "===";
                if (str2.length() > 1024) {
                    str3 = (str4 + str2.substring(0, 1024)) + "...";
                } else {
                    str3 = str4 + str2;
                }
                oc3.b bVar = new oc3.b(i);
                bVar.h(h0);
                bVar.i(str3);
                bVar.m();
                g32.k("OAuthUtils", "error reported: " + i + " ,content: " + str3);
            } catch (Exception e) {
                if (a) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void u(Context context, g63 g63Var, gb3 gb3Var, JSONObject jSONObject, bb3 bb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65557, null, context, g63Var, gb3Var, jSONObject, bb3Var) == null) {
            if (gb3Var != null && !TextUtils.isEmpty(gb3Var.b)) {
                synchronized (b) {
                    d dVar = b.get(gb3Var.b);
                    if (dVar != null) {
                        dVar.a.add(bb3Var);
                        return;
                    }
                    d dVar2 = new d(gb3Var.b);
                    dVar2.a.add(bb3Var);
                    b.put(gb3Var.b, dVar2);
                    b bVar = new b(gb3Var);
                    c cVar = new c(gb3Var);
                    zc3.q("show", gb3Var.b, false);
                    op2.n().a("na_authorize_start");
                    v(context, g63Var, gb3Var, jSONObject, bVar, cVar);
                    return;
                }
            }
            bb3Var.onResult(false);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void v(Context context, g63 g63Var, gb3 gb3Var, JSONObject jSONObject, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        SwanAppActivity w;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{context, g63Var, gb3Var, jSONObject, onClickListener, onCancelListener}) == null) {
            k53.a a2 = np2.i0().a(context, g63Var, gb3Var, jSONObject, onClickListener);
            if (a2 == null) {
                if (!a) {
                    return;
                }
                throw new RuntimeException("auth dialog builder is null");
            }
            k53 c2 = a2.c();
            c2.a(false);
            c2.setOnCancelListener(onCancelListener);
            Window window = c2.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.setLayout(-1, -2);
                window.setWindowAnimations(R.style.obfuscated_res_0x7f1003b3);
            }
            if (g63Var == null) {
                w = null;
            } else {
                w = g63Var.w();
            }
            if (w != null && !w.isFinishing()) {
                c2.show();
            }
        }
    }
}
