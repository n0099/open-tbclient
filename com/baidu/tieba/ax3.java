package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class ax3 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String k = "ug_";
    public static String l = "ug_business";
    public static String m = "ctkey";
    public static String n = "CTK";
    public static String o = "sid_eid";
    public static String p = "exps";
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public Context b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public yw3 i;
    public String j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947630509, "Lcom/baidu/tieba/ax3;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947630509, "Lcom/baidu/tieba/ax3;");
        }
    }

    public abstract HashMap<String, String> a();

    public abstract String e();

    public ax3(Context context, yw3 yw3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, yw3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = "https://mobads.baidu.com/cpro/ui/mads.php";
        this.f = "1";
        this.g = "2";
        this.h = "8.800201";
        this.b = context;
        this.i = yw3Var;
        if (yw3Var != null) {
            this.c = yw3Var.b();
            this.d = this.i.e();
            this.e = this.i.g();
        }
        if (!qx3.o()) {
            this.j = qx3.b();
        }
    }

    public final HashMap<String, String> b() {
        InterceptResult invokeV;
        String str;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            try {
                hashMap.put("lw", String.valueOf(Math.round(qx3.i(this.b) / qx3.d(this.b))));
                hashMap.put(MultiRatePlayUrlHelper.ABBR_FLV_HEVC_LIST, String.valueOf(Math.round(qx3.h(this.b) / qx3.d(this.b))));
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(NetworkUtils.c(false));
                hashMap.put("net", sb.toString());
                hashMap.put("n", this.f);
                hashMap.put(PushConstants.URI_PACKAGE_NAME, this.e);
                hashMap.put("appid", this.d);
                hashMap.put(TbConfig.SW_APID, "" + qx3.i(this.b));
                hashMap.put("sh", "" + qx3.h(this.b));
                hashMap.put("sn", "" + f());
                hashMap.put("os", "android");
                hashMap.put("pa", pw3.b().c());
                hashMap.put("apid", "" + this.c);
                hashMap.put("chid", "0");
                String m2 = pw3.b().m();
                if (m2.equals("0")) {
                    m2 = "";
                }
                hashMap.put("imei", m2);
                hashMap.put("cuid", pw3.b().e());
                hashMap.put("osv", qx3.f());
                hashMap.put("tp", qx3.e());
                hashMap.put("app_ver", qx3.l());
                String c = qx3.c(d(), "BAIDUID");
                if (TextUtils.isEmpty(c) || c.split(":").length <= 0) {
                    str = "";
                } else {
                    str = c.split(":")[0];
                }
                hashMap.put("baiduid", str);
                hashMap.put("p_ver", this.h);
                hashMap.put("rpt", this.g);
                hashMap.put("tab", "2");
                hashMap.put("req_id", "");
                hashMap.put("scene", pw3.b().getScene());
                String e = e();
                hashMap.put(p, e);
                hashMap.put(TiebaStatic.Params.EQID, pw3.b().g());
                JSONObject n2 = pw3.b().n();
                if (n2 != null) {
                    if (n2.has(l) && (jSONObject = n2.getJSONObject(l)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (n.equals(next)) {
                                    hashMap.put(m, optString);
                                    this.j = optString;
                                } else {
                                    hashMap.put(k + next, optString);
                                }
                            }
                        }
                    }
                    if (n2.has(o) && (optJSONArray = n2.optJSONArray(o)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        if (!TextUtils.isEmpty(e)) {
                            sb2.append(e + ",");
                        }
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String optString2 = optJSONArray.optString(i);
                            if (!TextUtils.isEmpty(optString2)) {
                                sb2.append(optString2);
                                if (i >= 0 && i < optJSONArray.length() - 1) {
                                    sb2.append(",");
                                }
                            }
                        }
                        if (sb2.length() > 0) {
                            hashMap.put(p, sb2.toString());
                        }
                    }
                }
                if (!hashMap.containsKey(n) && !TextUtils.isEmpty(this.j)) {
                    hashMap.put(n, this.j);
                }
                hashMap.put("con_name", pw3.b().a());
            } catch (Exception unused) {
            }
            return hashMap;
        }
        return (HashMap) invokeV.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return pw3.b().f(".baidu.com");
        }
        return (String) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                String m2 = pw3.b().m();
                String e = NetworkUtils.e(this.b);
                if (TextUtils.isEmpty(m2)) {
                    return e;
                }
                return m2;
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            HashMap<String, String> b = b();
            b.putAll(a());
            return nx3.a(this.a, b);
        }
        return (String) invokeV.objValue;
    }
}
