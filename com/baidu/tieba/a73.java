package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.tieba.jj3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a73 extends m73 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ik3<pa3> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ String f;
        public final /* synthetic */ a73 g;

        public a(a73 a73Var, CallbackHandler callbackHandler, String str, String str2, Context context, JSONObject jSONObject, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a73Var, callbackHandler, str, str2, context, jSONObject, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = a73Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
            this.d = context;
            this.e = jSONObject;
            this.f = str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ik3
        /* renamed from: b */
        public void a(pa3 pa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pa3Var) == null) {
                if (pa3Var != null && !pa3Var.d) {
                    if (this.g.m(pa3Var, this.c)) {
                        this.g.l(this.d, this.e, this.a, this.b, this.f);
                        return;
                    } else {
                        this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1003, "打开APP失败，打开App条件未满足").toString());
                        return;
                    }
                }
                if (m73.b) {
                    Log.i("OpenAppAction", "no configuration of authority");
                }
                na3.o(10005, this.a, this.b);
                ic3.r(10005, pa3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements jj3.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public b(a73 a73Var, CallbackHandler callbackHandler, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a73Var, callbackHandler, str, str2, str3};
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
        }

        @Override // com.baidu.tieba.jj3.g
        public void a(boolean z) {
            int i;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                if (z) {
                    i = 0;
                } else {
                    i = 1001;
                }
                if (z) {
                    str = "打开APP成功";
                } else {
                    str = "打开APP失败，本地没有安装";
                }
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(i, str).toString());
                c.a("open", this.c, "confirm", this.d);
            }
        }

        @Override // com.baidu.tieba.jj3.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(1004, "取消打开APP").toString());
                c.a("open", this.c, "cancel", this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(String str, String str2, String str3, String str4) {
            String str5;
            String str6;
            String str7;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(65536, null, str, str2, str3, str4) == null) {
                rc3 rc3Var = new rc3();
                p53 c0 = p53.c0();
                String str8 = "";
                if (c0 == null) {
                    str5 = "";
                    str6 = str5;
                    str7 = str6;
                } else {
                    str8 = ic3.n(c0.k());
                    str6 = c0.getAppId();
                    str7 = c0.a0();
                    str5 = c0.X().U();
                }
                String a = wo2.n().a();
                rc3Var.a = str8;
                rc3Var.b = str;
                rc3Var.e = str2;
                rc3Var.f = str6;
                rc3Var.c = str5;
                rc3Var.a("appName", str7);
                rc3Var.a("hostName", a);
                rc3Var.a("hostVersion", jj3.D());
                rc3Var.a(PushConstants.CLICK_TYPE, str3);
                try {
                    str4 = URLDecoder.decode(str4, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
                rc3Var.a("scheme", str4);
                wb3.i("2572", "90", rc3Var.f());
                if (m73.b) {
                    Log.d("OpenAppAction", String.format("ubcId=%s && ceresId=%s , content:%s ", "2572", "90", rc3Var.f()));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a73(m63 m63Var) {
        super(m63Var, "/swanAPI/openApp");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {m63Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.m73
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, p53 p53Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, p53Var)) == null) {
            if (!wo2.a().d()) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else if (p53Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "runtime exception");
                return false;
            } else {
                JSONObject a2 = m73.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "invalid params");
                    return false;
                }
                String optString = a2.optString("cb");
                if (m73.b) {
                    Log.i("OpenAppAction", "params is " + a2.toString());
                }
                String optString2 = a2.optString("open", "");
                String optString3 = a2.optString("invokeFrom", "");
                c.a(DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, optString3, null, optString2);
                if (optString2.startsWith(BaiduIdentityManager.VALUE_OSNAME)) {
                    if (!wo2.a().c()) {
                        h53.f(context, R.string.obfuscated_res_0x7f0f14d0).G();
                        return false;
                    }
                    l(context, a2, callbackHandler, optString, optString3);
                } else {
                    p53Var.f0().e("scope_open_app", new a(this, callbackHandler, optString, optString2, context, a2, optString3));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(Context context, JSONObject jSONObject, CallbackHandler callbackHandler, String str, String str2) {
        boolean z;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, callbackHandler, str, str2) == null) {
            String optString = jSONObject.optString("open");
            int i = 0;
            if (!TextUtils.isEmpty(optString)) {
                optString = Uri.decode(optString);
                wo2.P().a(optString, jSONObject.optJSONObject("extraParams"));
                if (m73.b) {
                    Log.i("OpenAppAction", "openUrl:" + optString);
                }
                z = o(context, optString, callbackHandler, str, str2);
            } else {
                z = false;
            }
            boolean optBoolean = jSONObject.optBoolean("isNeedDownload", true);
            if (m73.b) {
                Log.i("OpenAppAction", "open app result=" + z + "\nisNeedDownload=" + optBoolean);
            }
            if (!optBoolean) {
                if (!z) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1002, "打开APP失败，本地没有安装").toString());
                }
            } else if (!z) {
                boolean e = jj3.e(context, jSONObject.optString("download"));
                if (!e) {
                    i = 1001;
                }
                if (e) {
                    str3 = "下载APP成功";
                } else {
                    str3 = "下载APP失败";
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(i, str3).toString());
                c.a("download", str2, null, optString);
            }
        }
    }

    public final boolean m(pa3 pa3Var, String str) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pa3Var, str)) == null) {
            if (pa3Var != null && !TextUtils.isEmpty(str)) {
                String U = o53.K().q().X().U();
                if (TextUtils.isEmpty(U)) {
                    U = "NA";
                }
                JSONObject jSONObject = pa3Var.o;
                if (jSONObject != null && jSONObject.keys() != null) {
                    if (m73.b) {
                        Log.i("OpenAppAction", "source: " + U + " openUrl:" + str + " 配置数据:" + jSONObject);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("scene");
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("package_name");
                    if (optJSONArray == null) {
                        length = 0;
                    } else {
                        length = optJSONArray.length();
                    }
                    if (length > 0) {
                        boolean z = false;
                        for (int i = 0; i < length; i++) {
                            if (U.equals(optJSONArray.optString(i))) {
                                z = true;
                            }
                        }
                        if (!z || !n(str, optJSONArray2)) {
                            return false;
                        }
                        return true;
                    }
                    return n(str, optJSONArray2);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean n(String str, JSONArray jSONArray) {
        InterceptResult invokeLL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, jSONArray)) == null) {
            if (jSONArray == null) {
                length = 0;
            } else {
                length = jSONArray.length();
            }
            if (length > 0 && !TextUtils.isEmpty(str)) {
                for (int i = 0; i < length; i++) {
                    String optString = jSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        String decode = Uri.decode(optString);
                        int indexOf = decode.indexOf(":");
                        if (indexOf > 0) {
                            decode = decode.substring(0, indexOf);
                        }
                        if (str.startsWith(decode)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final boolean o(Context context, String str, CallbackHandler callbackHandler, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048580, this, context, str, callbackHandler, str2, str3)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                return jj3.Z(context, str, new b(this, callbackHandler, str2, str3, str));
            }
            return false;
        }
        return invokeLLLLL.booleanValue;
    }
}
