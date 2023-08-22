package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.cm4;
import com.baidu.tieba.em4;
import com.baidu.tieba.hm4;
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
/* loaded from: classes6.dex */
public class hk4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<wj4> l = oi4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (wj4 wj4Var : l) {
                        if (wj4Var.b) {
                            j2 = wj4Var.c;
                        } else {
                            ek4 b = jo4.b(wj4Var.a, wj4Var.d, wj4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", wj4Var.a);
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
                    aj4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", oi4.b().j(0));
            jSONObject.put("game_ext_vercode", oi4.b().j(1));
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
            jSONObject.put("swan_vercode", oi4.b().w(0));
            jSONObject.put("game_vercode", oi4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(cm4 cm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cm4Var)) == null) {
            if (cm4Var != null && cm4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (cm4.a aVar : cm4Var.f()) {
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

    public static JSONObject e(em4 em4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, em4Var)) == null) {
            if (em4Var != null && em4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (em4.a aVar : em4Var.f()) {
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
                        if (aVar instanceof hm4.b) {
                            hm4.b bVar = (hm4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<hm4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (hm4.a aVar2 : j) {
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

    public static HashMap<String, String> k(im4 im4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, im4Var)) == null) {
            if (im4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", im4Var.f());
            hashMap.put("category", String.valueOf(im4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(im4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(im4Var.j()));
            hashMap.put("sub_id", im4Var.k());
            if (!TextUtils.equals(im4Var.b(), "-1")) {
                hashMap.put("from", im4Var.b());
            }
            if (TextUtils.isEmpty(im4Var.i())) {
                im4Var.m(h(im4Var.a()));
            }
            if (!TextUtils.isEmpty(im4Var.i())) {
                hashMap.put("framework_ver", im4Var.i());
            }
            if (TextUtils.isEmpty(im4Var.h())) {
                im4Var.l(g(im4Var.a()));
            }
            if (!TextUtils.isEmpty(im4Var.h())) {
                hashMap.put("extension_ver", im4Var.h());
            }
            long w = oi4.b().w(im4Var.a());
            long j = oi4.b().j(im4Var.a());
            if (im4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (im4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(im4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(jm4 jm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, jm4Var)) == null) {
            if (jm4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(jm4Var.b(), "-1")) {
                hashMap.put("from", jm4Var.b());
            }
            if (!TextUtils.equals(jm4Var.c(), "-1")) {
                hashMap.put("scene", jm4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = oi4.b().v(i);
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
            String J = oi4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(fm4 fm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, fm4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (fm4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", fm4Var.g());
            hashMap.put("category", String.valueOf(fm4Var.a()));
            if (fm4Var.m() == -1) {
                pMSAppInfo = aj4.i().u(fm4Var.g());
                if (pMSAppInfo != null && aj4.i().o(ck4.class, fm4Var.g()) != null) {
                    fm4Var.u(pMSAppInfo.versionCode);
                } else {
                    fm4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(fm4Var.m()));
            if (fm4Var.a() == 0 && fm4Var.m() != -1 && fm4Var.m() != 0) {
                hashMap.put("dep", a(fm4Var.g(), fm4Var.m(), false).toString());
            }
            if (fm4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = aj4.i().u(fm4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    fm4Var.o(pMSAppInfo.appSign);
                } else {
                    fm4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(fm4Var.f()));
            if (fm4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(fm4Var.i()));
            }
            String k = fm4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(fm4Var.a());
                fm4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = oi4.b().w(fm4Var.a());
            long j = oi4.b().j(fm4Var.a());
            if (fm4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = fm4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(fm4Var.a());
                fm4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(fm4Var.l())) {
                hashMap.put("path", fm4Var.l());
            }
            if (!TextUtils.equals(fm4Var.b(), "-1")) {
                hashMap.put("from", fm4Var.b());
            }
            if (!TextUtils.equals(fm4Var.c(), "-1")) {
                hashMap.put("scene", fm4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(fm4Var.n()));
            hashMap.put("host_env", String.valueOf(oi4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(gm4 gm4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, gm4Var)) == null) {
            if (gm4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", gm4Var.f());
            hashMap.put("category", String.valueOf(gm4Var.a()));
            if (TextUtils.isEmpty(gm4Var.h())) {
                gm4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", gm4Var.h());
            if (gm4Var.g() >= 0) {
                hashMap.put("plugin_vercode", gm4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
