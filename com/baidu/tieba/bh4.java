package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.bj4;
import com.baidu.tieba.wi4;
import com.baidu.tieba.yi4;
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
public class bh4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<qg4> l = if4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (qg4 qg4Var : l) {
                        if (qg4Var.b) {
                            j2 = qg4Var.c;
                        } else {
                            yg4 b = dl4.b(qg4Var.a, qg4Var.d, qg4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", qg4Var.a);
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
                    uf4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", if4.b().j(0));
            jSONObject.put("game_ext_vercode", if4.b().j(1));
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
            jSONObject.put("swan_vercode", if4.b().w(0));
            jSONObject.put("game_vercode", if4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(wi4 wi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, wi4Var)) == null) {
            if (wi4Var != null && wi4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (wi4.a aVar : wi4Var.f()) {
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

    public static JSONObject e(yi4 yi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, yi4Var)) == null) {
            if (yi4Var != null && yi4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (yi4.a aVar : yi4Var.f()) {
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
                        if (aVar instanceof bj4.b) {
                            bj4.b bVar = (bj4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<bj4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (bj4.a aVar2 : j) {
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

    public static HashMap<String, String> k(cj4 cj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cj4Var)) == null) {
            if (cj4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", cj4Var.f());
            hashMap.put("category", String.valueOf(cj4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(cj4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(cj4Var.j()));
            hashMap.put("sub_id", cj4Var.k());
            if (!TextUtils.equals(cj4Var.b(), "-1")) {
                hashMap.put("from", cj4Var.b());
            }
            if (TextUtils.isEmpty(cj4Var.i())) {
                cj4Var.m(h(cj4Var.a()));
            }
            if (!TextUtils.isEmpty(cj4Var.i())) {
                hashMap.put("framework_ver", cj4Var.i());
            }
            if (TextUtils.isEmpty(cj4Var.h())) {
                cj4Var.l(g(cj4Var.a()));
            }
            if (!TextUtils.isEmpty(cj4Var.h())) {
                hashMap.put("extension_ver", cj4Var.h());
            }
            long w = if4.b().w(cj4Var.a());
            long j = if4.b().j(cj4Var.a());
            if (cj4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (cj4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(cj4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(dj4 dj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, dj4Var)) == null) {
            if (dj4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(dj4Var.b(), "-1")) {
                hashMap.put("from", dj4Var.b());
            }
            if (!TextUtils.equals(dj4Var.c(), "-1")) {
                hashMap.put("scene", dj4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = if4.b().v(i);
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
            String J = if4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(zi4 zi4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, zi4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (zi4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", zi4Var.g());
            hashMap.put("category", String.valueOf(zi4Var.a()));
            if (zi4Var.m() == -1) {
                pMSAppInfo = uf4.i().u(zi4Var.g());
                if (pMSAppInfo != null && uf4.i().o(wg4.class, zi4Var.g()) != null) {
                    zi4Var.u(pMSAppInfo.versionCode);
                } else {
                    zi4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(zi4Var.m()));
            if (zi4Var.a() == 0 && zi4Var.m() != -1 && zi4Var.m() != 0) {
                hashMap.put("dep", a(zi4Var.g(), zi4Var.m(), false).toString());
            }
            if (zi4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = uf4.i().u(zi4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    zi4Var.o(pMSAppInfo.appSign);
                } else {
                    zi4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(zi4Var.f()));
            if (zi4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(zi4Var.i()));
            }
            String k = zi4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(zi4Var.a());
                zi4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = if4.b().w(zi4Var.a());
            long j = if4.b().j(zi4Var.a());
            if (zi4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = zi4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(zi4Var.a());
                zi4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(zi4Var.l())) {
                hashMap.put("path", zi4Var.l());
            }
            if (!TextUtils.equals(zi4Var.b(), "-1")) {
                hashMap.put("from", zi4Var.b());
            }
            if (!TextUtils.equals(zi4Var.c(), "-1")) {
                hashMap.put("scene", zi4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(zi4Var.n()));
            hashMap.put("host_env", String.valueOf(if4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(aj4 aj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, aj4Var)) == null) {
            if (aj4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", aj4Var.f());
            hashMap.put("category", String.valueOf(aj4Var.a()));
            if (TextUtils.isEmpty(aj4Var.h())) {
                aj4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", aj4Var.h());
            if (aj4Var.g() >= 0) {
                hashMap.put("plugin_vercode", aj4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
