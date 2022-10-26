package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.rn2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class i53 extends j53 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public class a implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ String c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ m33 e;
        public final /* synthetic */ i53 f;

        public a(i53 i53Var, JSONObject jSONObject, Context context, String str, CallbackHandler callbackHandler, m33 m33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i53Var, jSONObject, context, str, callbackHandler, m33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = i53Var;
            this.a = jSONObject;
            this.b = context;
            this.c = str;
            this.d = callbackHandler;
            this.e = m33Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(m83 m83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, m83Var) == null) {
                if (fj3.f(this.a)) {
                    this.f.p(this.f.s(x63.e(), this.a.optString("path")), this.b, this.c, this.d, this.a, this.e);
                    return;
                }
                String r = this.f.r(m83Var, this.a);
                if (!gh3.G() && TextUtils.isEmpty(r)) {
                    r = sn3.e().g(this.e.O(), this.e.k(), this.a.optString("path"));
                }
                String str = r;
                if (j53.b) {
                    Log.d("ShareAction", "final share url is " + str);
                }
                this.f.p(str, this.b, this.c, this.d, this.a, this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements fi3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;
        public final /* synthetic */ JSONObject d;
        public final /* synthetic */ String e;
        public final /* synthetic */ i53 f;

        public b(i53 i53Var, Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i53Var, context, callbackHandler, str, jSONObject, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = i53Var;
            this.a = context;
            this.b = callbackHandler;
            this.c = str;
            this.d = jSONObject;
            this.e = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.fi3
        /* renamed from: b */
        public void a(p83 p83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p83Var) == null) {
                this.f.n(this.a, this.b, this.c, this.d, k83.h(p83Var), this.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements rn2.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ i53 c;

        public c(i53 i53Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i53Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i53Var;
            this.a = callbackHandler;
            this.b = str;
        }

        @Override // com.baidu.tieba.rn2.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.q(this.a, this.b, false);
        }

        @Override // com.baidu.tieba.rn2.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.c.q(this.a, this.b, true);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i53(j43 j43Var) {
        super(j43Var, "/swanAPI/share");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j43Var};
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

    @Override // com.baidu.tieba.j53
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, m33 m33Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, m33Var)) == null) {
            if (context != null && m33Var != null) {
                if (m33Var.n0()) {
                    if (j53.b) {
                        Log.d("ShareAction", "ShareAction does not supported when app is invisible.");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                    return false;
                }
                JSONObject a2 = j53.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    m02.c("Share", "params invalid");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                    return false;
                }
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    m02.c("Share", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "params invalid");
                    return false;
                }
                try {
                    a2.put("iconUrl", a2.optString("imageUrl", ""));
                } catch (JSONException e) {
                    if (j53.b) {
                        Log.d("ShareAction", e.toString());
                    }
                }
                m33Var.e0().e("mapp_i_share_update_weburl", new a(this, a2, context, optString, callbackHandler, m33Var));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            m02.c("Share", "context or swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "system error");
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public String m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            m33 b0 = m33.b0();
            if (b0 == null) {
                return null;
            }
            return ua3.M(str, b0.b);
        }
        return (String) invokeL.objValue;
    }

    public final void n(Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, callbackHandler, str, jSONObject, Boolean.valueOf(z), str2}) == null) {
            String optString = jSONObject.optString("shareUrl");
            JSONArray optJSONArray = jSONObject.optJSONArray("defaultPannel");
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("linkUrl", str2);
                }
                if (!TextUtils.isEmpty(optString) && (eh3.q(optString) || z)) {
                    jSONObject.put("customShareUrl", true);
                    jSONObject.put("linkUrl", optString);
                }
                if (optJSONArray != null && optJSONArray.length() > 0 && !z) {
                    jSONObject.put("pannel", optJSONArray);
                }
            } catch (JSONException e) {
                if (j53.b) {
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
                    jSONObject.putOpt("imageUrl", jh3.a(zo2.U().getActivity(), new File(m)).toString());
                } catch (JSONException e) {
                    if (j53.b) {
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
                Uri a2 = jh3.a(zo2.U().getActivity(), new File(m2));
                if (a2 == null) {
                    return jSONObject;
                }
                try {
                    optJSONObject2.putOpt("img_show", a2.toString());
                    optJSONObject.putOpt("info", optJSONObject2);
                    jSONObject.putOpt("command", optJSONObject);
                } catch (JSONException e2) {
                    if (j53.b) {
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
                Uri a3 = jh3.a(zo2.U().getActivity(), new File(m3));
                if (a3 == null) {
                    return jSONObject;
                }
                try {
                    optJSONObject2.putOpt("img_save", a3.toString());
                    optJSONObject.putOpt("info", optJSONObject2);
                    jSONObject.putOpt("command", optJSONObject);
                } catch (JSONException e3) {
                    if (j53.b) {
                        e3.printStackTrace();
                    }
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public final void p(String str, Context context, String str2, CallbackHandler callbackHandler, JSONObject jSONObject, m33 m33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, context, str2, callbackHandler, jSONObject, m33Var}) == null) {
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
                        if (j53.b) {
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
                } else if (eh3.q(optString)) {
                    jSONObject.put("linkUrl", optString);
                    jSONObject.put("customShareUrl", true);
                    t(context, callbackHandler, str2, jSONObject);
                    return;
                }
            }
            if (fj3.f(jSONObject)) {
                n(context, callbackHandler, str2, jSONObject, true, str);
            } else {
                m33Var.e0().g(context, "mapp_i_share_update_linkurl", new b(this, context, callbackHandler, str2, jSONObject, str));
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
                if (j53.b) {
                    Log.d("ShareAction", e.toString());
                }
            }
            if (z) {
                i = 0;
            } else {
                i = 1001;
            }
            m02.i("Share", "result=" + z);
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i).toString());
        }
    }

    public String r(m83 m83Var, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, m83Var, jSONObject)) == null) {
            if (m83Var != null && !m83Var.d && m83Var.j == 1 && !TextUtils.isEmpty(m83Var.o.optString("web_url"))) {
                return s(m83Var.o.optString("web_url"), jSONObject.optString("path"));
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
            return eh3.a(eh3.a(str, "_swebfr", "1"), "_swebFromHost", tm2.n().a());
        }
        return (String) invokeLL.objValue;
    }

    public final void t(Context context, CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, callbackHandler, str, jSONObject) == null) {
            jSONObject.remove("defaultPannel");
            jSONObject.remove("shareUrl");
            m33 b0 = m33.b0();
            if (b0 != null) {
                String T = b0.W().T();
                String a2 = ef2.a();
                JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
                if (optJSONObject != null) {
                    mg3.f(optJSONObject, "source", T);
                    if (!TextUtils.isEmpty(a2)) {
                        mg3.f(optJSONObject, "nid", a2);
                    }
                } else {
                    JSONObject f = mg3.f(null, "source", T);
                    if (!TextUtils.isEmpty(a2)) {
                        mg3.f(f, "nid", a2);
                    }
                    mg3.f(jSONObject, "categoryInfo", f);
                }
            }
            tm2.f0().a(context, o(jSONObject), new c(this, callbackHandler, str));
        }
    }
}
