package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ce4;
import com.baidu.tieba.xd4;
import com.baidu.tieba.zd4;
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
public class cc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<rb4> l = ja4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (rb4 rb4Var : l) {
                        if (rb4Var.b) {
                            j2 = rb4Var.c;
                        } else {
                            zb4 b = eg4.b(rb4Var.a, rb4Var.d, rb4Var.e, arrayList);
                            j2 = b == null ? 0L : b.i;
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", rb4Var.a);
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
                    va4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", ja4.b().j(0));
            jSONObject.put("game_ext_vercode", ja4.b().j(1));
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
            jSONObject.put("swan_vercode", ja4.b().w(0));
            jSONObject.put("game_vercode", ja4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(xd4 xd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, xd4Var)) == null) {
            if (xd4Var != null && xd4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (xd4.a aVar : xd4Var.f()) {
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

    public static JSONObject e(zd4 zd4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, zd4Var)) == null) {
            if (zd4Var != null && zd4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (zd4.a aVar : zd4Var.f()) {
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
                        if (aVar instanceof ce4.b) {
                            ce4.b bVar = (ce4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<ce4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (ce4.a aVar2 : j) {
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

    public static HashMap<String, String> f(ee4 ee4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, ee4Var)) == null) {
            if (ee4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(ee4Var.b(), "-1")) {
                hashMap.put("from", ee4Var.b());
            }
            if (!TextUtils.equals(ee4Var.c(), "-1")) {
                hashMap.put("scene", ee4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = ja4.b().v(i);
            return TextUtils.isEmpty(v) ? "0" : v;
        }
        return (String) invokeI.objValue;
    }

    public static String h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            String J = ja4.b().J(i);
            return TextUtils.isEmpty(J) ? "0" : J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(ae4 ae4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, ae4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (ae4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", ae4Var.g());
            hashMap.put("category", String.valueOf(ae4Var.a()));
            if (ae4Var.m() == -1) {
                pMSAppInfo = va4.i().u(ae4Var.g());
                if (pMSAppInfo != null && va4.i().o(xb4.class, ae4Var.g()) != null) {
                    ae4Var.u(pMSAppInfo.versionCode);
                } else {
                    ae4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(ae4Var.m()));
            if (ae4Var.a() == 0 && ae4Var.m() != -1 && ae4Var.m() != 0) {
                hashMap.put("dep", a(ae4Var.g(), ae4Var.m(), false).toString());
            }
            if (ae4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = va4.i().u(ae4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    ae4Var.o(pMSAppInfo.appSign);
                } else {
                    ae4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(ae4Var.f()));
            if (ae4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(ae4Var.i()));
            }
            String k = ae4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(ae4Var.a());
                ae4Var.s(k);
            }
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = ja4.b().w(ae4Var.a());
            long j = ja4.b().j(ae4Var.a());
            if (ae4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = ae4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(ae4Var.a());
                ae4Var.r(j2);
            }
            hashMap.put("extension_ver", TextUtils.isEmpty(j2) ? "0" : j2);
            if (!TextUtils.isEmpty(ae4Var.l())) {
                hashMap.put("path", ae4Var.l());
            }
            if (!TextUtils.equals(ae4Var.b(), "-1")) {
                hashMap.put("from", ae4Var.b());
            }
            if (!TextUtils.equals(ae4Var.c(), "-1")) {
                hashMap.put("scene", ae4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(ae4Var.n()));
            hashMap.put("host_env", String.valueOf(ja4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(be4 be4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, be4Var)) == null) {
            if (be4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", be4Var.f());
            hashMap.put("category", String.valueOf(be4Var.a()));
            if (TextUtils.isEmpty(be4Var.h())) {
                be4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", be4Var.h());
            if (be4Var.g() >= 0) {
                hashMap.put("plugin_vercode", be4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> k(de4 de4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, de4Var)) == null) {
            if (de4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", de4Var.f());
            hashMap.put("category", String.valueOf(de4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(de4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(de4Var.j()));
            hashMap.put("sub_id", de4Var.k());
            if (!TextUtils.equals(de4Var.b(), "-1")) {
                hashMap.put("from", de4Var.b());
            }
            if (TextUtils.isEmpty(de4Var.i())) {
                de4Var.m(h(de4Var.a()));
            }
            if (!TextUtils.isEmpty(de4Var.i())) {
                hashMap.put("framework_ver", de4Var.i());
            }
            if (TextUtils.isEmpty(de4Var.h())) {
                de4Var.l(g(de4Var.a()));
            }
            if (!TextUtils.isEmpty(de4Var.h())) {
                hashMap.put("extension_ver", de4Var.h());
            }
            long w = ja4.b().w(de4Var.a());
            long j = ja4.b().j(de4Var.a());
            if (de4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (de4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(de4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
