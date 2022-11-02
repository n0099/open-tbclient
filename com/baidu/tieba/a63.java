package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.j93;
import com.baidu.tieba.jo2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a63 extends b63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements xi3<e93> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ e43 e;
        public final /* synthetic */ a63 f;

        public a(a63 a63Var, JSONObject jSONObject, Context context, String str, CallbackHandler callbackHandler, e43 e43Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a63Var, jSONObject, context, str, callbackHandler, e43Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = a63Var;
            this.a = jSONObject;
            this.b = context;
            this.c = str;
            this.d = callbackHandler;
            this.e = e43Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(e93 e93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e93Var) == null) {
                if (xj3.f(this.a)) {
                    this.f.p(this.f.s(p73.e(), this.a.optString("path")), this.b, this.c, this.d, this.a, this.e);
                    return;
                }
                String r = this.f.r(e93Var, this.a);
                if (!yh3.G() && TextUtils.isEmpty(r)) {
                    r = ko3.e().g(this.e.O(), this.e.k(), this.a.optString("path"));
                }
                String str = r;
                if (b63.b) {
                    Log.d("ShareAction", "final share url is " + str);
                }
                this.f.p(str, this.b, this.c, this.d, this.a, this.e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements xi3<h93<j93.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ String e;
        public final /* synthetic */ a63 f;

        public b(a63 a63Var, Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a63Var, context, callbackHandler, str, jSONObject, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = a63Var;
            this.a = context;
            this.b = callbackHandler;
            this.c = str;
            this.d = jSONObject;
            this.e = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.xi3
        /* renamed from: b */
        public void a(h93<j93.e> h93Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h93Var) == null) {
                this.f.n(this.a, this.b, this.c, this.d, c93.h(h93Var), this.e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements jo2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ a63 c;

        public c(a63 a63Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a63Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a63Var;
            this.a = callbackHandler;
            this.b = str;
        }

        @Override // com.baidu.tieba.jo2.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.q(this.a, this.b, false);
        }

        @Override // com.baidu.tieba.jo2.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.c.q(this.a, this.b, true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a63(b53 b53Var) {
        super(b53Var, "/swanAPI/share");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b53Var};
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

    @Override // com.baidu.tieba.b63
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e43 e43Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, e43Var)) == null) {
            if (context != null && e43Var != null) {
                if (e43Var.n0()) {
                    if (b63.b) {
                        Log.d("ShareAction", "ShareAction does not supported when app is invisible.");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject a2 = b63.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    e12.c("Share", "params invalid");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                    return false;
                }
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    e12.c("Share", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                    return false;
                }
                try {
                    a2.put("iconUrl", a2.optString("imageUrl", ""));
                } catch (JSONException e) {
                    if (b63.b) {
                        Log.d("ShareAction", e.toString());
                    }
                }
                e43Var.e0().e("mapp_i_share_update_weburl", new a(this, a2, context, optString, callbackHandler, e43Var));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            e12.c("Share", "context or swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "system error");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            e43 b0 = e43.b0();
            if (b0 == null) {
                return null;
            }
            return mb3.M(str, b0.b);
        }
        return (String) invokeL.objValue;
    }

    public final void n(@NonNull Context context, CallbackHandler callbackHandler, String str, @NonNull JSONObject jSONObject, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, callbackHandler, str, jSONObject, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("shareUrl");
            JSONArray optJSONArray = jSONObject.optJSONArray("defaultPannel");
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("linkUrl", str2);
                }
                if (!TextUtils.isEmpty(optString) && (wh3.q(optString) || z)) {
                    jSONObject.put("customShareUrl", true);
                    jSONObject.put("linkUrl", optString);
                }
                if (optJSONArray != null && optJSONArray.length() > 0 && !z) {
                    jSONObject.put("pannel", optJSONArray);
                }
            } catch (JSONException e) {
                if (b63.b) {
                    Log.d("ShareAction", e.toString());
                }
            }
            t(context, callbackHandler, str, jSONObject);
        }
    }

    public final JSONObject o(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("imageUrl");
            if (optString.startsWith("bdfile")) {
                String m = m(optString);
                if (m == null) {
                    return jSONObject;
                }
                try {
                    jSONObject.putOpt("imageUrl", bi3.a(rp2.U().getActivity(), new File(m)).toString());
                } catch (JSONException e) {
                    if (b63.b) {
                        e.printStackTrace();
                    }
                }
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("command");
            if (optJSONObject == null) {
                return jSONObject;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("info");
            if (optJSONObject2 == null) {
                return jSONObject;
            }
            String optString2 = optJSONObject2.optString("img_show");
            if (optString2.startsWith("bdfile")) {
                String m2 = m(optString2);
                if (m2 == null) {
                    return jSONObject;
                }
                Uri a2 = bi3.a(rp2.U().getActivity(), new File(m2));
                if (a2 == null) {
                    return jSONObject;
                }
                try {
                    optJSONObject2.putOpt("img_show", a2.toString());
                    optJSONObject.putOpt("info", optJSONObject2);
                    jSONObject.putOpt("command", optJSONObject);
                } catch (JSONException e2) {
                    if (b63.b) {
                        e2.printStackTrace();
                    }
                }
            }
            String optString3 = optJSONObject2.optString("img_save");
            if (optString3.startsWith("bdfile")) {
                String m3 = m(optString3);
                if (m3 == null) {
                    return jSONObject;
                }
                Uri a3 = bi3.a(rp2.U().getActivity(), new File(m3));
                if (a3 == null) {
                    return jSONObject;
                }
                try {
                    optJSONObject2.putOpt("img_save", a3.toString());
                    optJSONObject.putOpt("info", optJSONObject2);
                    jSONObject.putOpt("command", optJSONObject);
                } catch (JSONException e3) {
                    if (b63.b) {
                        e3.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void p(String str, @NonNull Context context, @NonNull String str2, @NonNull CallbackHandler callbackHandler, @NonNull JSONObject jSONObject, @NonNull e43 e43Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, context, str2, callbackHandler, jSONObject, e43Var}) == null) {
            String optString = jSONObject.optString("shareUrl");
            JSONArray optJSONArray = jSONObject.optJSONArray("pannel");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("defaultPannel");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                if (optJSONArray2 != null) {
                    try {
                        if (optJSONArray2.length() > 0) {
                            jSONObject.put("pannel", optJSONArray2);
                        }
                    } catch (JSONException e) {
                        if (b63.b) {
                            Log.d("ShareAction", e.toString());
                        }
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("linkUrl", str);
                }
                if (TextUtils.isEmpty(optString)) {
                    t(context, callbackHandler, str2, jSONObject);
                    return;
                } else if (wh3.q(optString)) {
                    jSONObject.put("linkUrl", optString);
                    jSONObject.put("customShareUrl", true);
                    t(context, callbackHandler, str2, jSONObject);
                    return;
                }
            }
            if (xj3.f(jSONObject)) {
                n(context, callbackHandler, str2, jSONObject, true, str);
            } else {
                e43Var.e0().g(context, "mapp_i_share_update_linkurl", new b(this, context, callbackHandler, str2, jSONObject, str));
            }
        }
    }

    public final void q(CallbackHandler callbackHandler, String str, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048581, this, callbackHandler, str, z) == null) && callbackHandler != null && !TextUtils.isEmpty(str)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TiebaStatic.LogFields.RESULT, z);
            } catch (JSONException e) {
                if (b63.b) {
                    Log.d("ShareAction", e.toString());
                }
            }
            if (z) {
                i = 0;
            } else {
                i = 1001;
            }
            e12.i("Share", "result=" + z);
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i).toString());
        }
    }

    public String r(e93 e93Var, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, e93Var, jSONObject)) == null) {
            if (e93Var != null && !e93Var.d && e93Var.j == 1 && !TextUtils.isEmpty(e93Var.o.optString("web_url"))) {
                return s(e93Var.o.optString("web_url"), jSONObject.optString("path"));
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public String s(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (!TextUtils.isEmpty(str2)) {
                if (!str.endsWith("/")) {
                    str = str + "/";
                }
                if (str2.startsWith("/")) {
                    str2 = str2.substring(1);
                }
                str = str + str2;
            }
            return wh3.a(wh3.a(str, "_swebfr", "1"), "_swebFromHost", ln2.n().a());
        }
        return (String) invokeLL.objValue;
    }

    public final void t(@NonNull Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, callbackHandler, str, jSONObject) == null) {
            jSONObject.remove("defaultPannel");
            jSONObject.remove("shareUrl");
            e43 b0 = e43.b0();
            if (b0 != null) {
                String T = b0.W().T();
                String a2 = wf2.a();
                JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
                if (optJSONObject != null) {
                    eh3.f(optJSONObject, "source", T);
                    if (!TextUtils.isEmpty(a2)) {
                        eh3.f(optJSONObject, "nid", a2);
                    }
                } else {
                    JSONObject f = eh3.f(null, "source", T);
                    if (!TextUtils.isEmpty(a2)) {
                        eh3.f(f, "nid", a2);
                    }
                    eh3.f(jSONObject, "categoryInfo", f);
                }
            }
            ln2.f0().a(context, o(jSONObject), new c(this, callbackHandler, str));
        }
    }
}
