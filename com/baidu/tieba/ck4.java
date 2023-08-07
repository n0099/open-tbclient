package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.cm4;
import com.baidu.tieba.xl4;
import com.baidu.tieba.zl4;
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
public class ck4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<rj4> l = ji4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (rj4 rj4Var : l) {
                        if (rj4Var.b) {
                            j2 = rj4Var.c;
                        } else {
                            zj4 b = eo4.b(rj4Var.a, rj4Var.d, rj4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", rj4Var.a);
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
                    vi4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", ji4.b().j(0));
            jSONObject.put("game_ext_vercode", ji4.b().j(1));
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
            jSONObject.put("swan_vercode", ji4.b().w(0));
            jSONObject.put("game_vercode", ji4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(xl4 xl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, xl4Var)) == null) {
            if (xl4Var != null && xl4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (xl4.a aVar : xl4Var.f()) {
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

    public static JSONObject e(zl4 zl4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, zl4Var)) == null) {
            if (zl4Var != null && zl4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (zl4.a aVar : zl4Var.f()) {
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
                        if (aVar instanceof cm4.b) {
                            cm4.b bVar = (cm4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<cm4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (cm4.a aVar2 : j) {
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

    public static HashMap<String, String> k(dm4 dm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, dm4Var)) == null) {
            if (dm4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", dm4Var.f());
            hashMap.put("category", String.valueOf(dm4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(dm4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(dm4Var.j()));
            hashMap.put("sub_id", dm4Var.k());
            if (!TextUtils.equals(dm4Var.b(), "-1")) {
                hashMap.put("from", dm4Var.b());
            }
            if (TextUtils.isEmpty(dm4Var.i())) {
                dm4Var.m(h(dm4Var.a()));
            }
            if (!TextUtils.isEmpty(dm4Var.i())) {
                hashMap.put("framework_ver", dm4Var.i());
            }
            if (TextUtils.isEmpty(dm4Var.h())) {
                dm4Var.l(g(dm4Var.a()));
            }
            if (!TextUtils.isEmpty(dm4Var.h())) {
                hashMap.put("extension_ver", dm4Var.h());
            }
            long w = ji4.b().w(dm4Var.a());
            long j = ji4.b().j(dm4Var.a());
            if (dm4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (dm4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(dm4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(em4 em4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, em4Var)) == null) {
            if (em4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(em4Var.b(), "-1")) {
                hashMap.put("from", em4Var.b());
            }
            if (!TextUtils.equals(em4Var.c(), "-1")) {
                hashMap.put("scene", em4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = ji4.b().v(i);
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
            String J = ji4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(am4 am4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, am4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (am4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", am4Var.g());
            hashMap.put("category", String.valueOf(am4Var.a()));
            if (am4Var.m() == -1) {
                pMSAppInfo = vi4.i().u(am4Var.g());
                if (pMSAppInfo != null && vi4.i().o(xj4.class, am4Var.g()) != null) {
                    am4Var.u(pMSAppInfo.versionCode);
                } else {
                    am4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(am4Var.m()));
            if (am4Var.a() == 0 && am4Var.m() != -1 && am4Var.m() != 0) {
                hashMap.put("dep", a(am4Var.g(), am4Var.m(), false).toString());
            }
            if (am4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = vi4.i().u(am4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    am4Var.o(pMSAppInfo.appSign);
                } else {
                    am4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(am4Var.f()));
            if (am4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(am4Var.i()));
            }
            String k = am4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(am4Var.a());
                am4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = ji4.b().w(am4Var.a());
            long j = ji4.b().j(am4Var.a());
            if (am4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = am4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(am4Var.a());
                am4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(am4Var.l())) {
                hashMap.put("path", am4Var.l());
            }
            if (!TextUtils.equals(am4Var.b(), "-1")) {
                hashMap.put("from", am4Var.b());
            }
            if (!TextUtils.equals(am4Var.c(), "-1")) {
                hashMap.put("scene", am4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(am4Var.n()));
            hashMap.put("host_env", String.valueOf(ji4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(bm4 bm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bm4Var)) == null) {
            if (bm4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", bm4Var.f());
            hashMap.put("category", String.valueOf(bm4Var.a()));
            if (TextUtils.isEmpty(bm4Var.h())) {
                bm4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", bm4Var.h());
            if (bm4Var.g() >= 0) {
                hashMap.put("plugin_vercode", bm4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
