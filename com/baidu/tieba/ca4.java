package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.cc4;
import com.baidu.tieba.xb4;
import com.baidu.tieba.zb4;
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
/* loaded from: classes3.dex */
public class ca4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<r94> l = j84.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (r94 r94Var : l) {
                        if (r94Var.b) {
                            j2 = r94Var.c;
                        } else {
                            z94 b = ee4.b(r94Var.a, r94Var.d, r94Var.e, arrayList);
                            j2 = b == null ? 0L : b.i;
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", r94Var.a);
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
                    v84.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", j84.b().j(0));
            jSONObject.put("game_ext_vercode", j84.b().j(1));
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
            jSONObject.put("swan_vercode", j84.b().w(0));
            jSONObject.put("game_vercode", j84.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(xb4 xb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, xb4Var)) == null) {
            if (xb4Var != null && xb4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (xb4.a aVar : xb4Var.f()) {
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

    public static JSONObject e(zb4 zb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, zb4Var)) == null) {
            if (zb4Var != null && zb4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (zb4.a aVar : zb4Var.f()) {
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
                        if (aVar instanceof cc4.b) {
                            cc4.b bVar = (cc4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<cc4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (cc4.a aVar2 : j) {
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

    public static HashMap<String, String> f(ec4 ec4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, ec4Var)) == null) {
            if (ec4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(ec4Var.b(), "-1")) {
                hashMap.put("from", ec4Var.b());
            }
            if (!TextUtils.equals(ec4Var.c(), "-1")) {
                hashMap.put("scene", ec4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = j84.b().v(i);
            return TextUtils.isEmpty(v) ? "0" : v;
        }
        return (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            String J = j84.b().J(i);
            return TextUtils.isEmpty(J) ? "0" : J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(ac4 ac4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, ac4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (ac4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ac4Var.g());
            hashMap.put("category", String.valueOf(ac4Var.a()));
            if (ac4Var.m() == -1) {
                pMSAppInfo = v84.i().u(ac4Var.g());
                if (pMSAppInfo != null && v84.i().o(x94.class, ac4Var.g()) != null) {
                    ac4Var.u(pMSAppInfo.versionCode);
                } else {
                    ac4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(ac4Var.m()));
            if (ac4Var.a() == 0 && ac4Var.m() != -1 && ac4Var.m() != 0) {
                hashMap.put("dep", a(ac4Var.g(), ac4Var.m(), false).toString());
            }
            if (ac4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = v84.i().u(ac4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    ac4Var.o(pMSAppInfo.appSign);
                } else {
                    ac4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(ac4Var.f()));
            if (ac4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(ac4Var.i()));
            }
            String k = ac4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(ac4Var.a());
                ac4Var.s(k);
            }
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = j84.b().w(ac4Var.a());
            long j = j84.b().j(ac4Var.a());
            if (ac4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = ac4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(ac4Var.a());
                ac4Var.r(j2);
            }
            hashMap.put("extension_ver", TextUtils.isEmpty(j2) ? "0" : j2);
            if (!TextUtils.isEmpty(ac4Var.l())) {
                hashMap.put("path", ac4Var.l());
            }
            if (!TextUtils.equals(ac4Var.b(), "-1")) {
                hashMap.put("from", ac4Var.b());
            }
            if (!TextUtils.equals(ac4Var.c(), "-1")) {
                hashMap.put("scene", ac4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(ac4Var.n()));
            hashMap.put("host_env", String.valueOf(j84.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(bc4 bc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bc4Var)) == null) {
            if (bc4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", bc4Var.f());
            hashMap.put("category", String.valueOf(bc4Var.a()));
            if (TextUtils.isEmpty(bc4Var.h())) {
                bc4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", bc4Var.h());
            if (bc4Var.g() >= 0) {
                hashMap.put("plugin_vercode", bc4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> k(dc4 dc4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, dc4Var)) == null) {
            if (dc4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", dc4Var.f());
            hashMap.put("category", String.valueOf(dc4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(dc4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(dc4Var.j()));
            hashMap.put("sub_id", dc4Var.k());
            if (!TextUtils.equals(dc4Var.b(), "-1")) {
                hashMap.put("from", dc4Var.b());
            }
            if (TextUtils.isEmpty(dc4Var.i())) {
                dc4Var.m(h(dc4Var.a()));
            }
            if (!TextUtils.isEmpty(dc4Var.i())) {
                hashMap.put("framework_ver", dc4Var.i());
            }
            if (TextUtils.isEmpty(dc4Var.h())) {
                dc4Var.l(g(dc4Var.a()));
            }
            if (!TextUtils.isEmpty(dc4Var.h())) {
                hashMap.put("extension_ver", dc4Var.h());
            }
            long w = j84.b().w(dc4Var.a());
            long j = j84.b().j(dc4Var.a());
            if (dc4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (dc4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(dc4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
