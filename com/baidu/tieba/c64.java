package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.CookieManager;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public class c64 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements ei3<l83> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sv1 a;
        public final /* synthetic */ String b;

        public a(sv1 sv1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sv1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sv1Var;
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ei3
        /* renamed from: b */
        public void a(l83 l83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l83Var) == null) {
                if (l83Var == null || l83Var.d || l83Var.j != 1) {
                    c64.c(this.a, "system deny");
                } else {
                    c64.e(this.a, this.b);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947626696, "Lcom/baidu/tieba/c64;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947626696, "Lcom/baidu/tieba/c64;");
                return;
            }
        }
        a = vj1.a;
    }

    public static void c(sv1 sv1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, sv1Var, str) == null) {
            ux3 ux3Var = new ux3();
            ux3Var.errMsg = str;
            x54.call(sv1Var, false, ux3Var);
        }
    }

    public static void d(JsObject jsObject) {
        sv1 F;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jsObject) == null) || (F = sv1.F(jsObject)) == null) {
            return;
        }
        l33 b0 = l33.b0();
        if (b0 == null) {
            c(F, "internal error");
            return;
        }
        String C = F.C("domain", "baidu.com");
        if (a) {
            Log.i("SwanGameUuapApi", "getUUAPInfo-domain: " + C);
        }
        b0.e0().e("mapp_uuap_info", new a(F, C));
    }

    public static void e(sv1 sv1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, sv1Var, str) == null) {
            d64 d64Var = new d64();
            String cookie = CookieManager.getInstance().getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                Map<String, String> f = f(cookie);
                d64Var.uuap_p_token = f.get("UUAP_P_TOKEN");
                d64Var.uuap_p_token_offline = f.get("UUAP_P_TOKEN_OFFLINE");
                d64Var.uuap_s_token = f.get("UUAP_S_TOKEN");
            }
            x54.call(sv1Var, true, d64Var);
        }
    }

    @NonNull
    public static Map<String, String> f(@NonNull String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            HashMap hashMap = new HashMap();
            for (String str2 : str.split(ParamableElem.DIVIDE_PARAM)) {
                if (str2 != null && str2.contains("=")) {
                    int indexOf = str2.indexOf("=");
                    hashMap.put(str2.substring(0, indexOf).trim().toUpperCase(Locale.US), str2.substring(indexOf + 1));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
