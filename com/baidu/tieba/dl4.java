package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.an4;
import com.baidu.tieba.dn4;
import com.baidu.tieba.ym4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<sk4> l = kj4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (sk4 sk4Var : l) {
                        if (sk4Var.b) {
                            j2 = sk4Var.c;
                        } else {
                            al4 b = fp4.b(sk4Var.a, sk4Var.d, sk4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", sk4Var.a);
                            jSONObject.put("pkg_ver", j2);
                            if (z) {
                                jSONObject.put("category", 6);
                            }
                            jSONArray.put(jSONObject);
                        }
                    }
                } catch (JSONException unused) {
                }
                if (!arrayList.isEmpty()) {
                    wj4.i().g(arrayList);
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeCommon.objValue;
    }

    @NonNull
    public static JSONObject b() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("swan_ext_ver", g(0));
            jSONObject.put("game_ext_ver", g(1));
            jSONObject.put("swan_ext_vercode", kj4.b().j(0));
            jSONObject.put("game_ext_vercode", kj4.b().j(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public static JSONObject c() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("swan_core_ver", h(0));
            jSONObject.put("swan_game_ver", h(1));
            jSONObject.put("swan_vercode", kj4.b().w(0));
            jSONObject.put("game_vercode", kj4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(ym4 ym4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ym4Var)) == null) {
            if (ym4Var != null && ym4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (ym4.a aVar : ym4Var.f()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("bundle_id", aVar.a());
                        jSONObject2.put("category", aVar.b());
                        jSONObject2.put("pkg_ver", aVar.e());
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("min_version", aVar.d());
                        jSONObject3.put("max_version", aVar.c());
                        jSONObject2.put("version_range", jSONObject3);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("list", jSONArray);
                    return jSONObject;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject e(an4 an4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, an4Var)) == null) {
            if (an4Var != null && an4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (an4.a aVar : an4Var.f()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("bundle_id", aVar.b());
                        if (aVar.c() != -1) {
                            jSONObject2.put("category", aVar.c());
                        }
                        jSONObject2.put("pkg_ver", aVar.d());
                        jSONObject2.put("app_sign", aVar.a());
                        if (aVar.c() == 0 && aVar.d() != -1 && aVar.d() != 0) {
                            jSONObject2.put("dep", a(aVar.b(), aVar.d(), true));
                        }
                        if (aVar instanceof dn4.b) {
                            dn4.b bVar = (dn4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<dn4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (dn4.a aVar2 : j) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("id", aVar2.a());
                                    jSONObject4.put("type", aVar2.getType());
                                    jSONArray2.put(jSONObject4);
                                }
                                jSONObject3.put("list", jSONArray2);
                                jSONObject3.put("ver", j.get(0).b());
                            }
                            jSONObject2.put("sub_info", jSONObject3);
                        }
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("list", jSONArray);
                    return jSONObject;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static HashMap<String, String> k(en4 en4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, en4Var)) == null) {
            if (en4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", en4Var.f());
            hashMap.put("category", String.valueOf(en4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(en4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(en4Var.j()));
            hashMap.put("sub_id", en4Var.k());
            if (!TextUtils.equals(en4Var.b(), "-1")) {
                hashMap.put("from", en4Var.b());
            }
            if (TextUtils.isEmpty(en4Var.i())) {
                en4Var.m(h(en4Var.a()));
            }
            if (!TextUtils.isEmpty(en4Var.i())) {
                hashMap.put("framework_ver", en4Var.i());
            }
            if (TextUtils.isEmpty(en4Var.h())) {
                en4Var.l(g(en4Var.a()));
            }
            if (!TextUtils.isEmpty(en4Var.h())) {
                hashMap.put("extension_ver", en4Var.h());
            }
            long w = kj4.b().w(en4Var.a());
            long j = kj4.b().j(en4Var.a());
            if (en4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (en4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(en4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(fn4 fn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, fn4Var)) == null) {
            if (fn4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(fn4Var.b(), "-1")) {
                hashMap.put("from", fn4Var.b());
            }
            if (!TextUtils.equals(fn4Var.c(), "-1")) {
                hashMap.put("scene", fn4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = kj4.b().v(i);
            if (TextUtils.isEmpty(v)) {
                return "0";
            }
            return v;
        }
        return (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            String J = kj4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(bn4 bn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bn4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (bn4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", bn4Var.g());
            hashMap.put("category", String.valueOf(bn4Var.a()));
            if (bn4Var.m() == -1) {
                pMSAppInfo = wj4.i().u(bn4Var.g());
                if (pMSAppInfo != null && wj4.i().o(yk4.class, bn4Var.g()) != null) {
                    bn4Var.u(pMSAppInfo.versionCode);
                } else {
                    bn4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(bn4Var.m()));
            if (bn4Var.a() == 0 && bn4Var.m() != -1 && bn4Var.m() != 0) {
                hashMap.put("dep", a(bn4Var.g(), bn4Var.m(), false).toString());
            }
            if (bn4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = wj4.i().u(bn4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    bn4Var.o(pMSAppInfo.appSign);
                } else {
                    bn4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(bn4Var.f()));
            if (bn4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(bn4Var.i()));
            }
            String k = bn4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(bn4Var.a());
                bn4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = kj4.b().w(bn4Var.a());
            long j = kj4.b().j(bn4Var.a());
            if (bn4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = bn4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(bn4Var.a());
                bn4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(bn4Var.l())) {
                hashMap.put("path", bn4Var.l());
            }
            if (!TextUtils.equals(bn4Var.b(), "-1")) {
                hashMap.put("from", bn4Var.b());
            }
            if (!TextUtils.equals(bn4Var.c(), "-1")) {
                hashMap.put("scene", bn4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(bn4Var.n()));
            hashMap.put("host_env", String.valueOf(kj4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(cn4 cn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cn4Var)) == null) {
            if (cn4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", cn4Var.f());
            hashMap.put("category", String.valueOf(cn4Var.a()));
            if (TextUtils.isEmpty(cn4Var.h())) {
                cn4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", cn4Var.h());
            if (cn4Var.g() >= 0) {
                hashMap.put("plugin_vercode", cn4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
