package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tieba.mg3;
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
/* loaded from: classes6.dex */
public class ia6 extends ed3 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String d = "com.baidu.tieba://";
    public transient /* synthetic */ FieldHolder $fh;
    public String c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947846827, "Lcom/baidu/tieba/ia6;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947846827, "Lcom/baidu/tieba/ia6;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements aq3<kg3<mg3.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ ia6 h;

        public a(ia6 ia6Var, CallbackHandler callbackHandler, Context context, String str, String str2, String str3, String str4, String str5) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia6Var, callbackHandler, context, str, str2, str3, str4, str5};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = ia6Var;
            this.a = callbackHandler;
            this.b = context;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = str4;
            this.g = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aq3
        /* renamed from: b */
        public void a(kg3<mg3.e> kg3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kg3Var) == null) {
                if (!fg3.h(kg3Var)) {
                    fg3.q(kg3Var, this.a, this.h.c);
                } else if (!this.h.l(this.b, this.c, this.d, this.e, this.f, this.g)) {
                    h82.c("PageTransitionAction", "page transition fail");
                    this.a.handleSchemeDispatchCallback(this.h.c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
                } else {
                    h82.i("PageTransitionAction", "page transition success");
                    this.a.handleSchemeDispatchCallback(this.h.c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BdUniDispatchSchemeController.OnSchemeParsedCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public b(Context context) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ia6(ec3 ec3Var) {
        super(ec3Var, "/swanAPI/pageTransition");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ec3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void o(String str) {
        hb3 M;
        c83 y;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || (M = hb3.M()) == null || (y = M.y()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_param_url", str);
        y.W(bundle, ha6.class);
    }

    public static String m(String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeLLLLL;
        String str6;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, str3, str4, str5)) == null) {
            if (TextUtils.isEmpty(str5)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                JSONObject jSONObject = new JSONObject(str5);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (TextUtils.isEmpty(next)) {
                        return null;
                    }
                    String obj = jSONObject.opt(next).toString();
                    sb.append(next + "=" + Uri.encode(obj) + "&");
                }
                if (!TextUtils.isEmpty(str4)) {
                    str4 = "/" + str4;
                }
                if (TextUtils.equals(str3, "NA")) {
                    str6 = "";
                } else {
                    str6 = "/" + str3;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = str6 + str4;
                }
                String str8 = d;
                if (TextUtils.isEmpty(str2)) {
                    if (!TextUtils.isEmpty(str)) {
                        str8 = str8 + str;
                    }
                } else {
                    String substring = str2.substring(1, str2.length());
                    if (TextUtils.isEmpty(str)) {
                        str7 = str8 + substring;
                    } else {
                        str7 = str8 + str + "/" + substring;
                    }
                    str8 = str7;
                }
                StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.length() - 1));
                String str9 = str8 + "?" + ((Object) sb2);
                if (ed3.b) {
                    Log.i("PageTransitionAction", "encodeParams: " + ((Object) sb2));
                }
                return str9;
            } catch (JSONException e) {
                if (ed3.b) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (String) invokeLLLLL.objValue;
    }

    public static boolean n(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && context != null) {
                if (!TextUtils.isEmpty(str) && str.contains("tbwebview")) {
                    Uri parse = Uri.parse(str);
                    if (BdUniDispatchSchemeController.isUniScheme(parse)) {
                        BdUniDispatchSchemeController.getInstance().parseWebViewScheme(str, parse, new b(context));
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

    @Override // com.baidu.tieba.ed3
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hb3 hb3Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hb3Var)) == null) {
            if (hb3Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "null swanApp");
                return false;
            }
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                return false;
            }
            JSONObject d2 = ho3.d(param);
            String optString = d2.optString("cb");
            this.c = optString;
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString2 = d2.optString("authority");
            String optString3 = d2.optString("path");
            String optString4 = d2.optString("module", "NA");
            String optString5 = d2.optString("action");
            JSONObject optJSONObject = d2.optJSONObject("scheme");
            try {
                optJSONObject.put("launchMode", Easing.STANDARD_NAME);
            } catch (JSONException e) {
                if (ed3.b) {
                    e.printStackTrace();
                }
            }
            hb3Var.e0().g((Activity) context, "mapp_i_baiduapp_page_trans", new a(this, callbackHandler, context, optString2, optString3, optString4, optString5, optJSONObject.toString()));
            h82.i("PageTransitionAction", "callback success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean l(Context context, String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, str, str2, str3, str4, str5})) == null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str5) && context != null) {
                String str6 = null;
                if (str3.hashCode() == -330473854) {
                    str3.equals("anything");
                }
                if ("icashwebview".equals(str4)) {
                    if (!StringUtils.isNull(str5)) {
                        try {
                            String optString = new JSONObject(str5).optString("url");
                            if (!StringUtils.isNull(optString)) {
                                o(optString);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    str6 = m(str, str2, str3, str4, str5);
                    z = n(context, str6);
                }
                if (ed3.b) {
                    Log.i("PageTransitionAction", "result = " + z + "\n拼接后的uri is: " + str6);
                }
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }
}
