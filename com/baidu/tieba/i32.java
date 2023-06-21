package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.PermissionRequest;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class i32 extends y22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.c02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "SystemInfoApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes6.dex */
    public class a implements vp3<z32> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i32 a;

        public a(i32 i32Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i32Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.baidu.tieba.vp3
        public z32 call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject d = n53.c().d("getSystemInfo");
                if (d == null) {
                    i32 i32Var = this.a;
                    d = i32Var.G(i32Var.getContext());
                    n53.c().h("getSystemInfo", d);
                    n53.c().h("getSystemInfoSync", d);
                }
                if (d == null) {
                    return new z32(202, "empty joData");
                }
                return new z32(0, d);
            }
            return (z32) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ vp3 b;
        public final /* synthetic */ i32 c;

        public b(i32 i32Var, String str, vp3 vp3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i32Var, str, vp3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i32Var;
            this.a = str;
            this.b = vp3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.d(this.a, (z32) this.b.call());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i32(@NonNull a02 a02Var) {
        super(a02Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a02Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a02) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static String F(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (context instanceof SwanAppActivity) {
                i = ((SwanAppActivity) context).S();
            } else {
                i = 0;
            }
            if (i == 1) {
                return el3.i(hv2.i().m(), i);
            }
            return el3.i(ti2.U().d0(), i);
        }
        return (String) invokeL.objValue;
    }

    public static void B(@NonNull JSONObject jSONObject) throws JSONException {
        zb3 M;
        ye3 h;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, jSONObject) == null) && (M = zb3.M()) != null && M.e0().f("mapp_location")) {
            zv2 I = gv2.I();
            if (I == null) {
                h = null;
            } else {
                h = I.h();
            }
            if (h == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("city", h.k);
            jSONObject2.put("cityCode", h.l);
            jSONObject2.put("country", h.i);
            jSONObject2.put("district", h.n);
            jSONObject2.put("province", h.m);
            jSONObject2.put("street", h.o);
            jSONObject2.put("streetNumber", h.p);
            jSONObject2.put("coord_gcj02", D(h, "gcj02"));
            jSONObject2.put("coord_wgs84", D(h, "wgs84"));
            jSONObject.put("cacheLocation", jSONObject2);
        }
    }

    public static JSONObject D(@NonNull ye3 ye3Var, @NonNull String str) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, ye3Var, str)) == null) {
            JSONObject jSONObject = new JSONObject();
            double[] g = gv2.I().g(ye3Var, str);
            if (g != null && g.length >= 2) {
                jSONObject.put("longitude", g[0]);
                jSONObject.put("latitude", g[1]);
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final void A(@NonNull JSONObject jSONObject) throws JSONException {
        zb3 M;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) && (M = zb3.M()) != null && M.e0().f("mapp_set_user_agent")) {
            jSONObject.put(TTDownloadField.TT_USERAGENT, ri4.b().getUserAgent());
        }
    }

    public final void C(@NonNull Context context, @NonNull JSONObject jSONObject, @NonNull Pair<Integer, Integer> pair) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, pair) == null) {
            int O = qp3.O(ip3.e(context));
            int O2 = qp3.O(((Integer) pair.first).intValue());
            int O3 = qp3.O(((Integer) pair.second).intValue());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("left", 0);
            jSONObject2.put("right", O2);
            jSONObject2.put("top", O);
            jSONObject2.put("width", O2);
            jSONObject2.put("bottom", O3);
            jSONObject2.put("height", O3 - O);
            jSONObject.put("safeArea", jSONObject2);
        }
    }

    public z32 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            q("#getCommonSysInfoSync", false);
            JSONObject d = n53.c().d("getCommonSysInfoSync");
            if (d == null) {
                try {
                    d = new JSONObject();
                    d.put("imei", tp3.r());
                    n53.c().h("getCommonSysInfoSync", d);
                } catch (JSONException unused) {
                    return new z32(1001, "exec fail");
                }
            }
            return new z32(0, d);
        }
        return (z32) invokeV.objValue;
    }

    public z32 J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            q("#getSystemInfoSync", false);
            JSONObject d = n53.c().d("getSystemInfoSync");
            if (d == null) {
                d = G(getContext());
                n53.c().h("getSystemInfoSync", d);
                n53.c().h("getSystemInfo", d);
            }
            if (d == null) {
                return new z32(202, "empty joData");
            }
            return new z32(0, d);
        }
        return (z32) invokeV.objValue;
    }

    public final JSONObject G(Context context) {
        InterceptResult invokeL;
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            if (gv2.g0().o()) {
                a2 = j32.b(context);
            } else {
                a2 = j32.a(context);
            }
            if (a2 == null) {
                return null;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW)).getDefaultDisplay().getMetrics(displayMetrics);
            Pair<Integer, Integer> r = mx2.T().r();
            Pair<Integer, Integer> x = mx2.T().x();
            try {
                a2.put("SDKVersion", F(context));
                a2.put("windowWidth", (int) (((Integer) r.first).intValue() / displayMetrics.density));
                a2.put("windowHeight", (int) (((Integer) r.second).intValue() / displayMetrics.density));
                a2.put("screenWidth", qp3.O(((Integer) x.first).intValue()));
                a2.put("screenHeight", qp3.O(((Integer) x.second).intValue()));
                a2.put("privacyMode", gv2.y0().c());
                B(a2);
                z(context, a2);
                C(context, a2, x);
                A(a2);
            } catch (JSONException e) {
                p("json put data fail", e, false);
            }
            return a2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public z32 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            q("#getSystemInfo", false);
            return I(null);
        }
        return (z32) invokeV.objValue;
    }

    public z32 I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#getSystemInfoAsync", false);
            a aVar = new a(this);
            if (!TextUtils.isEmpty(str)) {
                try {
                    String optString = new JSONObject(str).optString("cb");
                    if (!TextUtils.isEmpty(optString)) {
                        to3.k(new b(this, optString, aVar), "SystemInfoApi");
                        return z32.f();
                    }
                } catch (JSONException e) {
                    p("json put data fail", e, false);
                }
            }
            return aVar.call();
        }
        return (z32) invokeL.objValue;
    }

    public final void z(@NonNull Context context, @NonNull JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, jSONObject) == null) {
            jSONObject.put("cameraAuthorized", dp3.j(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE));
            jSONObject.put("locationAuthorized", dp3.j(context, com.kuaishou.weapon.p0.h.g));
            jSONObject.put("microphoneAuthorized", dp3.j(context, PermissionRequest.RESOURCE_AUDIO_CAPTURE));
            jSONObject.put("notificationAuthorized", tp3.N(context));
            jSONObject.put("locationEnabled", tp3.L(context));
            jSONObject.put("wifiEnabled", tp3.V(context));
        }
    }
}
