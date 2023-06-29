package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.bn4;
import com.baidu.tieba.dn4;
import com.baidu.tieba.gn4;
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
public class gl4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<vk4> l = nj4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (vk4 vk4Var : l) {
                        if (vk4Var.b) {
                            j2 = vk4Var.c;
                        } else {
                            dl4 b = ip4.b(vk4Var.a, vk4Var.d, vk4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", vk4Var.a);
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
                    zj4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", nj4.b().j(0));
            jSONObject.put("game_ext_vercode", nj4.b().j(1));
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
            jSONObject.put("swan_vercode", nj4.b().w(0));
            jSONObject.put("game_vercode", nj4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(bn4 bn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bn4Var)) == null) {
            if (bn4Var != null && bn4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (bn4.a aVar : bn4Var.f()) {
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

    public static JSONObject e(dn4 dn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, dn4Var)) == null) {
            if (dn4Var != null && dn4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (dn4.a aVar : dn4Var.f()) {
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
                        if (aVar instanceof gn4.b) {
                            gn4.b bVar = (gn4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<gn4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (gn4.a aVar2 : j) {
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

    public static HashMap<String, String> k(hn4 hn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, hn4Var)) == null) {
            if (hn4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", hn4Var.f());
            hashMap.put("category", String.valueOf(hn4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(hn4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(hn4Var.j()));
            hashMap.put("sub_id", hn4Var.k());
            if (!TextUtils.equals(hn4Var.b(), "-1")) {
                hashMap.put("from", hn4Var.b());
            }
            if (TextUtils.isEmpty(hn4Var.i())) {
                hn4Var.m(h(hn4Var.a()));
            }
            if (!TextUtils.isEmpty(hn4Var.i())) {
                hashMap.put("framework_ver", hn4Var.i());
            }
            if (TextUtils.isEmpty(hn4Var.h())) {
                hn4Var.l(g(hn4Var.a()));
            }
            if (!TextUtils.isEmpty(hn4Var.h())) {
                hashMap.put("extension_ver", hn4Var.h());
            }
            long w = nj4.b().w(hn4Var.a());
            long j = nj4.b().j(hn4Var.a());
            if (hn4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (hn4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(hn4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(in4 in4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, in4Var)) == null) {
            if (in4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(in4Var.b(), "-1")) {
                hashMap.put("from", in4Var.b());
            }
            if (!TextUtils.equals(in4Var.c(), "-1")) {
                hashMap.put("scene", in4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = nj4.b().v(i);
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
            String J = nj4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(en4 en4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, en4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (en4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", en4Var.g());
            hashMap.put("category", String.valueOf(en4Var.a()));
            if (en4Var.m() == -1) {
                pMSAppInfo = zj4.i().u(en4Var.g());
                if (pMSAppInfo != null && zj4.i().o(bl4.class, en4Var.g()) != null) {
                    en4Var.u(pMSAppInfo.versionCode);
                } else {
                    en4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(en4Var.m()));
            if (en4Var.a() == 0 && en4Var.m() != -1 && en4Var.m() != 0) {
                hashMap.put("dep", a(en4Var.g(), en4Var.m(), false).toString());
            }
            if (en4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = zj4.i().u(en4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    en4Var.o(pMSAppInfo.appSign);
                } else {
                    en4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(en4Var.f()));
            if (en4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(en4Var.i()));
            }
            String k = en4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(en4Var.a());
                en4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = nj4.b().w(en4Var.a());
            long j = nj4.b().j(en4Var.a());
            if (en4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = en4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(en4Var.a());
                en4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(en4Var.l())) {
                hashMap.put("path", en4Var.l());
            }
            if (!TextUtils.equals(en4Var.b(), "-1")) {
                hashMap.put("from", en4Var.b());
            }
            if (!TextUtils.equals(en4Var.c(), "-1")) {
                hashMap.put("scene", en4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(en4Var.n()));
            hashMap.put("host_env", String.valueOf(nj4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(fn4 fn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, fn4Var)) == null) {
            if (fn4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", fn4Var.f());
            hashMap.put("category", String.valueOf(fn4Var.a()));
            if (TextUtils.isEmpty(fn4Var.h())) {
                fn4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", fn4Var.h());
            if (fn4Var.g() >= 0) {
                hashMap.put("plugin_vercode", fn4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
