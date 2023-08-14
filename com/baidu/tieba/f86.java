package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.motion.utils.Easing;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes5.dex */
public final class f86 implements qu1 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static String b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements BdUniDispatchSchemeController.OnSchemeParsedCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.OnSchemeParsedCallback
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) && hashMap != null && (hashMap.get(BdUniDispatchSchemeController.PARAM_URL) instanceof String)) {
                Bundle bundle = new Bundle();
                bundle.putBoolean(WebViewActivityConfig.FROM_SCHEMA, true);
                BrowserHelper.startWebActivity(this.a, null, (String) hashMap.get(BdUniDispatchSchemeController.PARAM_URL), true, bundle);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947718053, "Lcom/baidu/tieba/f86;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947718053, "Lcom/baidu/tieba/f86;");
                return;
            }
        }
        a = ir1.a;
        b = NewUrlSchemaHelper.SCHEME;
    }

    public f86() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String b(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        String str5;
        String str6;
        Object opt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65538, null, str, str2, str3, str4, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (TextUtils.isEmpty(next) || (opt = jSONObject.opt(next)) == null) {
                    return null;
                }
                String obj = opt.toString();
                sb.append(next + "=" + Uri.encode(obj) + "&");
            }
            if (!TextUtils.isEmpty(str4)) {
                str4 = "/" + str4;
            }
            if (TextUtils.equals(str3, "NA")) {
                str5 = "";
            } else {
                str5 = "/" + str3;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = str5 + str4;
            }
            String str7 = b;
            if (TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    str7 = str7 + str;
                }
            } else {
                String substring = str2.substring(1, str2.length());
                if (TextUtils.isEmpty(str)) {
                    str6 = str7 + substring;
                } else {
                    str6 = str7 + str + "/" + substring;
                }
                str7 = str6;
            }
            StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.length() - 1));
            String str8 = str7 + "?" + ((Object) sb2);
            if (a) {
                Log.i("DefaultInnerSkip", "encodeParams: " + ((Object) sb2));
            }
            return str8;
        }
        return (String) invokeLLLLL.objValue;
    }

    public static boolean d(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                if (!TextUtils.isEmpty(str) && str.contains("tbwebview")) {
                    Uri parse = Uri.parse(str);
                    if (BdUniDispatchSchemeController.isUniScheme(parse)) {
                        BdUniDispatchSchemeController.getInstance().parseWebViewScheme(str, parse, new a(context));
                    } else {
                        BrowserHelper.startWebActivity(context, parse);
                    }
                    return true;
                }
                if (!TextUtils.isEmpty(str) && str.contains("com.baidu.tieba")) {
                    Uri parse2 = Uri.parse(str);
                    if ("miniapp".equals(parse2.getAuthority()) && "/goods".equals(parse2.getPath())) {
                        MutiProcessManager.publishEvent(new GoodsEvent(parse2.getQueryParameter("goodsList")));
                        return true;
                    }
                }
                return UtilHelper.dealOneScheme(context, str);
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.baidu.tieba.qu1
    public rm3 a(Context context, String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{context, str, str2, str3, str4, str5})) == null) {
            if (context == null) {
                rm3 rm3Var = new rm3();
                rm3Var.f("Context exception");
                return rm3Var;
            } else if (TextUtils.isEmpty(str5)) {
                return c(str5);
            } else {
                if (TextUtils.isEmpty(str3)) {
                    str3 = "NA";
                }
                if ("icashwebview".equals(str4) && !StringUtils.isNull(str5)) {
                    try {
                        String optString = new JSONObject(str5).optString("url");
                        if (!StringUtils.isNull(optString)) {
                            e(optString);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    rm3 rm3Var2 = new rm3();
                    rm3Var2.f("invoke failed");
                    return rm3Var2;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    jSONObject.put("launchMode", Easing.STANDARD_NAME);
                    String b2 = b(str, str2, str3, str4, jSONObject);
                    boolean d = d(context, b2);
                    if (a) {
                        Log.i("DefaultInnerSkip", "result = " + d + "\n拼接后的uri is: " + b2);
                    }
                    if (d) {
                        return null;
                    }
                    rm3 rm3Var3 = new rm3();
                    rm3Var3.f("invoke failed");
                    return rm3Var3;
                } catch (JSONException e2) {
                    if (a) {
                        Log.i("DefaultInnerSkip", Log.getStackTraceString(e2));
                    }
                    return c(str5);
                }
            }
        }
        return (rm3) invokeCommon.objValue;
    }

    public final rm3 c(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            rm3 rm3Var = new rm3();
            rm3Var.k(5L);
            rm3Var.i(1L);
            StringBuilder sb = new StringBuilder();
            sb.append("Error in parameter parsing: from PageTransitionAction:\n called by");
            if (TextUtils.isEmpty(str)) {
                str2 = " empty";
            } else {
                str2 = "";
            }
            sb.append(str2);
            sb.append(" parameter:");
            sb.append(str);
            sb.append("\n appId:");
            sb.append(xa3.K().getAppId());
            sb.append("\n curPage:");
            sb.append(lw2.T().S());
            sb.append("\n");
            rm3Var.f(sb.toString());
            return rm3Var;
        }
        return (rm3) invokeL.objValue;
    }

    public final void e(String str) {
        ya3 M;
        t73 y;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || (M = ya3.M()) == null || (y = M.y()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_param_url", str);
        y.W(bundle, h86.class);
    }
}
