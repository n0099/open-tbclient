package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.sb4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fe4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static PMSAppInfo a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            PMSAppInfo pMSAppInfo = new PMSAppInfo();
            pMSAppInfo.appKey = jSONObject.optString(GameGuideConfigInfo.KEY_APP_KEY);
            pMSAppInfo.appName = jSONObject.optString("app_name");
            pMSAppInfo.description = jSONObject.optString("app_desc");
            pMSAppInfo.appStatus = jSONObject.optInt("app_status");
            pMSAppInfo.statusDetail = jSONObject.optString("status_detail");
            pMSAppInfo.statusDesc = jSONObject.optString("status_desc");
            pMSAppInfo.resumeDate = jSONObject.optString("resume_date");
            pMSAppInfo.subjectInfo = jSONObject.optString("subject_info");
            pMSAppInfo.maxAge = jSONObject.optLong("max_age");
            pMSAppInfo.appCategory = jSONObject.optInt("sub_category");
            pMSAppInfo.iconUrl = jSONObject.optString("icon_url");
            pMSAppInfo.serviceCategory = jSONObject.optString("service_category");
            pMSAppInfo.webViewDomains = jSONObject.optString("webview_domains");
            pMSAppInfo.domainConfig = jSONObject.optString("domain_config");
            pMSAppInfo.webAction = jSONObject.optString("web_action");
            pMSAppInfo.domains = jSONObject.optString("domains");
            pMSAppInfo.serverExt = jSONObject.optString("ext");
            pMSAppInfo.appSign = jSONObject.optLong("app_sign");
            pMSAppInfo.payProtected = jSONObject.optInt("pay_protected", PMSConstants.PayProtected.NO_PAY_PROTECTED.type);
            pMSAppInfo.customerService = jSONObject.optInt("customer_service", PMSConstants.CustomerService.NO_CUSTOMER_SERVICE.type);
            pMSAppInfo.globalNotice = jSONObject.optInt("global_notice", PMSConstants.CloudSwitch.NO_DISPLAY.value);
            pMSAppInfo.globalPrivate = jSONObject.optInt("global_private", PMSConstants.CloudSwitch.NO_DISPLAY.value);
            pMSAppInfo.paNumber = jSONObject.optString("pa_number");
            String optString = p(pMSAppInfo.serverExt).optString("quick_app_key");
            if (!TextUtils.isEmpty(optString)) {
                pMSAppInfo.quickAppKey = optString;
            }
            JSONObject optJSONObject = p(pMSAppInfo.serverExt).optJSONObject(SwanAppBearInfo.BEAR_INFO);
            if (optJSONObject != null) {
                pMSAppInfo.bearInfo = optJSONObject.toString();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("plugins");
            if (optJSONArray != null) {
                pMSAppInfo.pluginInfo = optJSONArray.toString();
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject(Constants.PHONE_BRAND);
            if (optJSONObject2 != null) {
                pMSAppInfo.brandsInfo = optJSONObject2.toString();
            }
            j84.b().k(jSONObject.optJSONArray("ban_page"), jSONObject.optString("ban_tips"), pMSAppInfo.appKey);
            j84.b().s(pMSAppInfo, jSONObject.optJSONObject("scope_list"), jSONObject.optInt("service_degrade", 0) != 0);
            pMSAppInfo.webUrl = jSONObject.optString("web_url");
            pMSAppInfo.rank = jSONObject.optInt("rank");
            pMSAppInfo.webPermit = jSONObject.optInt("web_permit");
            pMSAppInfo.csProtocolVersion = PMSConstants.a.a();
            pMSAppInfo.userActionApis = jSONObject.optString("user_action_apis");
            return pMSAppInfo;
        }
        return (PMSAppInfo) invokeL.objValue;
    }

    public static boolean b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? jSONObject != null && 1 == jSONObject.optInt("reset_env", 0) : invokeL.booleanValue;
    }

    public static t94 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return (t94) j(jSONObject, new t94());
        }
        return (t94) invokeL.objValue;
    }

    public static v94 d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return (v94) j(jSONObject, new v94());
        }
        return (v94) invokeL.objValue;
    }

    public static rb4 e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            rb4 rb4Var = new rb4();
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            List<z94> l = l(optJSONArray);
            rb4Var.c = l;
            if (l != null && l.contains(null)) {
                k(rb4Var, optJSONArray);
            } else {
                rb4Var.a = 0;
            }
            return rb4Var;
        }
        return (rb4) invokeL.objValue;
    }

    public static sb4 f(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            sb4 sb4Var = new sb4();
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    sb4.a aVar = new sb4.a();
                    aVar.a = optJSONObject.optInt("errno");
                    aVar.b = optJSONObject.optString("bundle_id");
                    aVar.c = optJSONObject.optInt("category");
                    aVar.d = m(optJSONObject.optJSONObject("main"));
                    aVar.e = n(optJSONObject.optJSONArray("sub"));
                    aVar.f = l(optJSONObject.optJSONArray("dep"));
                    aVar.g = a(optJSONObject.optJSONObject("app_info"));
                    j84.b().p(aVar.b, optJSONObject, aVar.d, aVar.e);
                    arrayList.add(aVar);
                }
            }
            sb4Var.a = arrayList;
            return sb4Var;
        }
        return (sb4) invokeL.objValue;
    }

    public static tb4 g(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            tb4 tb4Var = new tb4();
            JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
            if (optJSONObject != null) {
                tb4Var.a = m(optJSONObject.optJSONObject("main"));
                tb4Var.b = n(optJSONObject.optJSONArray("sub"));
                tb4Var.c = l(optJSONObject.optJSONArray("dep"));
                j84.b().p(str, optJSONObject, tb4Var.a, tb4Var.b);
            }
            tb4Var.d = d(jSONObject.optJSONObject("framework"));
            tb4Var.f = c(jSONObject.optJSONObject(ETAG.KEY_EXTENSION));
            tb4Var.e = a(jSONObject.optJSONObject("app_info"));
            return tb4Var;
        }
        return (tb4) invokeLL.objValue;
    }

    public static ub4 h(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            ub4 ub4Var = new ub4();
            ub4Var.a = o(jSONObject);
            return ub4Var;
        }
        return (ub4) invokeL.objValue;
    }

    public static vb4 i(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            vb4 vb4Var = new vb4();
            JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
            if (optJSONObject != null) {
                vb4Var.a = n(optJSONObject.optJSONArray("sub"));
                j84.b().p(str, optJSONObject, null, vb4Var.a);
            }
            return vb4Var;
        }
        return (vb4) invokeLL.objValue;
    }

    public static <T extends w94> T j(JSONObject jSONObject, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, jSONObject, t)) == null) {
            if (jSONObject == null || t == null) {
                return null;
            }
            t.g = jSONObject.optString("bundle_id");
            t.h = jSONObject.optInt("category");
            t.j = jSONObject.optString("version_name");
            t.i = jSONObject.optLong("version_code");
            t.k = jSONObject.optLong("size");
            t.l = jSONObject.optString(PackageTable.MD5);
            t.m = jSONObject.optString("sign");
            t.n = jSONObject.optString("download_url");
            return t;
        }
        return (T) invokeLL.objValue;
    }

    public static void k(rb4 rb4Var, JSONArray jSONArray) {
        int optInt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65546, null, rb4Var, jSONArray) == null) || jSONArray == null) {
            return;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null && (optInt = optJSONObject.optInt("errno", 0)) != 0) {
                String optString = optJSONObject.optString("bundle_id");
                rb4Var.a = optInt;
                rb4Var.b = String.format("%s : Not Exist.", optString);
                return;
            }
        }
    }

    public static List<z94> l(JSONArray jSONArray) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONArray)) == null) {
            if (jSONArray != null && (length = jSONArray.length()) > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("main");
                        JSONObject optJSONObject3 = optJSONObject.optJSONObject("app_info");
                        z94 o = o(optJSONObject2);
                        if (o != null && optJSONObject3 != null) {
                            o.r = optJSONObject3.optString(GameGuideConfigInfo.KEY_APP_KEY);
                            o.s = optJSONObject3.optString("app_name");
                            o.q = optJSONObject3.optString("domains");
                        }
                        arrayList.add(o);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static x94 m(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            x94 x94Var = (x94) j(jSONObject, new x94());
            x94Var.o = jSONObject.optInt("pkg_type");
            x94Var.p = jSONObject.optString("ext");
            return x94Var;
        }
        return (x94) invokeL.objValue;
    }

    public static List<y94> n(JSONArray jSONArray) {
        InterceptResult invokeL;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, jSONArray)) == null) {
            if (jSONArray != null && (length = jSONArray.length()) > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    y94 y94Var = (y94) j(optJSONObject, new y94());
                    y94Var.q = optJSONObject.optInt("pkg_type");
                    y94Var.p = optJSONObject.optString("sub_path");
                    y94Var.r = optJSONObject.optBoolean("independent");
                    y94Var.s = optJSONObject.optString("ext");
                    arrayList.add(y94Var);
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public static z94 o(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            z94 z94Var = new z94();
            j(jSONObject, z94Var);
            long optLong = jSONObject.optLong("max_age");
            if (optLong < 0) {
                optLong = 0;
            }
            z94Var.o = optLong;
            return z94Var;
        }
        return (z94) invokeL.objValue;
    }

    public static JSONObject p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return new JSONObject();
            }
            try {
                return new JSONObject(str);
            } catch (JSONException unused) {
                return new JSONObject();
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static wb4 q(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            wb4 wb4Var = new wb4();
            wb4Var.a = jSONObject.optLong("max_age");
            long optLong = jSONObject.optLong("lastsynctime");
            if (optLong > 0) {
                ed4.c = optLong;
            }
            wb4Var.b = jSONObject;
            return wb4Var;
        }
        return (wb4) invokeL.objValue;
    }
}
