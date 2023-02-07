package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.ak4;
import com.baidu.tieba.vj4;
import com.baidu.tieba.xj4;
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
public class ai4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONArray a(String str, long j, boolean z) {
        InterceptResult invokeCommon;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            List<ph4> l = hg4.b().l(str, j);
            JSONArray jSONArray = new JSONArray();
            if (l != null && !l.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                try {
                    for (ph4 ph4Var : l) {
                        if (ph4Var.b) {
                            j2 = ph4Var.c;
                        } else {
                            xh4 b = cm4.b(ph4Var.a, ph4Var.d, ph4Var.e, arrayList);
                            if (b == null) {
                                j2 = 0;
                            } else {
                                j2 = b.i;
                            }
                        }
                        if (j2 != 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bundle_id", ph4Var.a);
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
                    tg4.i().g(arrayList);
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
            jSONObject.put("swan_ext_vercode", hg4.b().j(0));
            jSONObject.put("game_ext_vercode", hg4.b().j(1));
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
            jSONObject.put("swan_vercode", hg4.b().w(0));
            jSONObject.put("game_vercode", hg4.b().w(1));
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject d(vj4 vj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, vj4Var)) == null) {
            if (vj4Var != null && vj4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (vj4.a aVar : vj4Var.f()) {
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

    public static JSONObject e(xj4 xj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, xj4Var)) == null) {
            if (xj4Var != null && xj4Var.f() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("framework", c());
                    jSONObject.put(ETAG.KEY_EXTENSION, b());
                    JSONArray jSONArray = new JSONArray();
                    for (xj4.a aVar : xj4Var.f()) {
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
                        if (aVar instanceof ak4.b) {
                            ak4.b bVar = (ak4.b) aVar;
                            String[] i = bVar.i();
                            if (i != null && i.length > 0) {
                                jSONObject2.put("path", new JSONArray((Collection) Arrays.asList(i)));
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            List<ak4.a> j = bVar.j();
                            if (j != null && !j.isEmpty()) {
                                JSONArray jSONArray2 = new JSONArray();
                                for (ak4.a aVar2 : j) {
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

    public static HashMap<String, String> k(bk4 bk4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bk4Var)) == null) {
            if (bk4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", bk4Var.f());
            hashMap.put("category", String.valueOf(bk4Var.a()));
            hashMap.put("pkg_ver", String.valueOf(bk4Var.j()));
            hashMap.put("expect_pkg_ver", String.valueOf(bk4Var.j()));
            hashMap.put("sub_id", bk4Var.k());
            if (!TextUtils.equals(bk4Var.b(), "-1")) {
                hashMap.put("from", bk4Var.b());
            }
            if (TextUtils.isEmpty(bk4Var.i())) {
                bk4Var.m(h(bk4Var.a()));
            }
            if (!TextUtils.isEmpty(bk4Var.i())) {
                hashMap.put("framework_ver", bk4Var.i());
            }
            if (TextUtils.isEmpty(bk4Var.h())) {
                bk4Var.l(g(bk4Var.a()));
            }
            if (!TextUtils.isEmpty(bk4Var.h())) {
                hashMap.put("extension_ver", bk4Var.h());
            }
            long w = hg4.b().w(bk4Var.a());
            long j = hg4.b().j(bk4Var.a());
            if (bk4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            if (bk4Var.g() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(bk4Var.g()));
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> f(ck4 ck4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, ck4Var)) == null) {
            if (ck4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            if (!TextUtils.equals(ck4Var.b(), "-1")) {
                hashMap.put("from", ck4Var.b());
            }
            if (!TextUtils.equals(ck4Var.c(), "-1")) {
                hashMap.put("scene", ck4Var.c());
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static String g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            String v = hg4.b().v(i);
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
            String J = hg4.b().J(i);
            if (TextUtils.isEmpty(J)) {
                return "0";
            }
            return J;
        }
        return (String) invokeI.objValue;
    }

    public static HashMap<String, String> i(yj4 yj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, yj4Var)) == null) {
            PMSAppInfo pMSAppInfo = null;
            if (yj4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", yj4Var.g());
            hashMap.put("category", String.valueOf(yj4Var.a()));
            if (yj4Var.m() == -1) {
                pMSAppInfo = tg4.i().u(yj4Var.g());
                if (pMSAppInfo != null && tg4.i().o(vh4.class, yj4Var.g()) != null) {
                    yj4Var.u(pMSAppInfo.versionCode);
                } else {
                    yj4Var.u(0L);
                }
            }
            hashMap.put("pkg_ver", String.valueOf(yj4Var.m()));
            if (yj4Var.a() == 0 && yj4Var.m() != -1 && yj4Var.m() != 0) {
                hashMap.put("dep", a(yj4Var.g(), yj4Var.m(), false).toString());
            }
            if (yj4Var.f() == -1) {
                if (pMSAppInfo == null) {
                    pMSAppInfo = tg4.i().u(yj4Var.g());
                }
                if (pMSAppInfo != null && pMSAppInfo.csProtocolVersion >= PMSConstants.a.a()) {
                    yj4Var.o(pMSAppInfo.appSign);
                } else {
                    yj4Var.o(0L);
                }
            }
            hashMap.put("app_sign", String.valueOf(yj4Var.f()));
            if (yj4Var.i() != -1) {
                hashMap.put("expect_pkg_ver", String.valueOf(yj4Var.i()));
            }
            String k = yj4Var.k();
            if (TextUtils.isEmpty(k)) {
                k = h(yj4Var.a());
                yj4Var.s(k);
            }
            String str = "0";
            if (TextUtils.isEmpty(k)) {
                k = "0";
            }
            hashMap.put("framework_ver", k);
            long w = hg4.b().w(yj4Var.a());
            long j = hg4.b().j(yj4Var.a());
            if (yj4Var.a() == 1) {
                hashMap.put("game_vercode", w + "");
                hashMap.put("game_ext_vercode", j + "");
            } else {
                hashMap.put("swan_vercode", w + "");
                hashMap.put("swan_ext_vercode", j + "");
            }
            String j2 = yj4Var.j();
            if (TextUtils.isEmpty(j2)) {
                j2 = g(yj4Var.a());
                yj4Var.r(j2);
            }
            if (!TextUtils.isEmpty(j2)) {
                str = j2;
            }
            hashMap.put("extension_ver", str);
            if (!TextUtils.isEmpty(yj4Var.l())) {
                hashMap.put("path", yj4Var.l());
            }
            if (!TextUtils.equals(yj4Var.b(), "-1")) {
                hashMap.put("from", yj4Var.b());
            }
            if (!TextUtils.equals(yj4Var.c(), "-1")) {
                hashMap.put("scene", yj4Var.c());
            }
            hashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(yj4Var.n()));
            hashMap.put("host_env", String.valueOf(hg4.b().B()));
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }

    public static HashMap<String, String> j(zj4 zj4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, zj4Var)) == null) {
            if (zj4Var == null) {
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("bundle_id", zj4Var.f());
            hashMap.put("category", String.valueOf(zj4Var.a()));
            if (TextUtils.isEmpty(zj4Var.h())) {
                zj4Var.i(String.valueOf(-1));
            }
            hashMap.put("plugin_ver", zj4Var.h());
            if (zj4Var.g() >= 0) {
                hashMap.put("plugin_vercode", zj4Var.g() + "");
            }
            return hashMap;
        }
        return (HashMap) invokeL.objValue;
    }
}
