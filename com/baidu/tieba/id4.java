package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.df4;
import com.baidu.tieba.ff4;
import com.baidu.tieba.if4;
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
/* loaded from: classes4.dex */
public class id4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<xc4> l = pb4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (xc4 xc4Var : l) {
                        if (xc4Var.b) {
                            j2 = xc4Var.c;
                        } else {
                            fd4 b = kh4.b(xc4Var.a, xc4Var.d, xc4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", xc4Var.a);
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
                    bc4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", pb4.b().j(0));
            jSONObject.put("game_ext_vercode", pb4.b().j(1));
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
            jSONObject.put("swan_vercode", pb4.b().w(0));
            jSONObject.put("game_vercode", pb4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(df4 df4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, df4Var)) == null) {
            if (df4Var != null && df4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (df4.a aVar : df4Var.f()) {
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

    public static JSONObject e(ff4 ff4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ff4Var)) == null) {
            if (ff4Var != null && ff4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (ff4.a aVar : ff4Var.f()) {
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
                        if (aVar instanceof if4.b) {
                            if4.b bVar = (if4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<if4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (if4.a aVar2 : j) {
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

    public static HashMap<String, String> k(jf4 jf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jf4Var)) == null) {
            if (jf4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", jf4Var.f());
            hashMap.put("category", String.valueOf(jf4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(jf4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(jf4Var.j()));
            hashMap.put("sub_id", jf4Var.k());
            if (!TextUtils.equals(jf4Var.b(), "-1")) {
                hashMap.put("from", jf4Var.b());
            }
            if (TextUtils.isEmpty(jf4Var.i())) {
                jf4Var.m(h(jf4Var.a()));
            }
            if (!TextUtils.isEmpty(jf4Var.i())) {
                hashMap.put("framework_ver", jf4Var.i());
            }
            if (TextUtils.isEmpty(jf4Var.h())) {
                jf4Var.l(g(jf4Var.a()));
            }
            if (!TextUtils.isEmpty(jf4Var.h())) {
                hashMap.put("extension_ver", jf4Var.h());
            }
            long w = pb4.b().w(jf4Var.a());
            long j = pb4.b().j(jf4Var.a());
            if (jf4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (jf4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(jf4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(kf4 kf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, kf4Var)) == null) {
            if (kf4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(kf4Var.b(), "-1")) {
                hashMap.put("from", kf4Var.b());
            }
            if (!TextUtils.equals(kf4Var.c(), "-1")) {
                hashMap.put("scene", kf4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = pb4.b().v(i);
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
            String J = pb4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(gf4 gf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, gf4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (gf4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", gf4Var.g());
            hashMap.put("category", String.valueOf(gf4Var.a()));
            if (gf4Var.m() == -1) {
                pMSAppInfo = bc4.i().u(gf4Var.g());
                if (pMSAppInfo != null && bc4.i().o(dd4.class, gf4Var.g()) != null) {
                    gf4Var.u(pMSAppInfo.versionCode);
                } else {
                    gf4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(gf4Var.m()));
            if (gf4Var.a() == 0 && gf4Var.m() != -1 && gf4Var.m() != 0) {
                hashMap.put("dep", a(gf4Var.g(), gf4Var.m(), false).toString());
            }
            if (gf4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = bc4.i().u(gf4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    gf4Var.o(pMSAppInfo.appSign);
                } else {
                    gf4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(gf4Var.f()));
            if (gf4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(gf4Var.i()));
            }
            String k = gf4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(gf4Var.a());
                gf4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = pb4.b().w(gf4Var.a());
            long j = pb4.b().j(gf4Var.a());
            if (gf4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = gf4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(gf4Var.a());
                gf4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(gf4Var.l())) {
                hashMap.put("path", gf4Var.l());
            }
            if (!TextUtils.equals(gf4Var.b(), "-1")) {
                hashMap.put("from", gf4Var.b());
            }
            if (!TextUtils.equals(gf4Var.c(), "-1")) {
                hashMap.put("scene", gf4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(gf4Var.n()));
            hashMap.put("host_env", String.valueOf(pb4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(hf4 hf4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, hf4Var)) == null) {
            if (hf4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", hf4Var.f());
            hashMap.put("category", String.valueOf(hf4Var.a()));
            if (TextUtils.isEmpty(hf4Var.h())) {
                hf4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", hf4Var.h());
            if (hf4Var.g() >= 0) {
                hashMap.put("plugin_vercode", hf4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
