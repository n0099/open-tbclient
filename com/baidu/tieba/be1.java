package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.tieba.t21;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class be1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public String C;
    public int D;
    public int E;
    public int F;
    public int G;
    public String H;
    public int I;
    public int J;
    public JSONObject K;
    public JSONObject L;
    public int M;
    public int N;
    public String O;
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public int h;
    public int i;
    public String j;
    public String k;
    public String l;
    public int m;
    public int n;
    public String o;
    public String p;
    public String[] q;
    public String[] r;
    public long s;
    public long t;
    public int u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public String z;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, be1 be1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, be1Var) == null) {
                try {
                    be1Var.a = jSONObject.optInt("advisible");
                    be1Var.b = jSONObject.optString("id");
                    be1Var.c = jSONObject.optString("ukey");
                    be1Var.d = jSONObject.optString("extra");
                    be1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    be1Var.f = jSONObject.optInt("type");
                    be1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    be1Var.o = jSONObject.optString("action");
                    be1Var.p = jSONObject.optString("action_cmd");
                    be1Var.l = jSONObject.optString("flag_name");
                    be1Var.m = jSONObject.optInt("logo_type");
                    be1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (be1Var.i()) {
                        b.a(jSONObject, be1Var);
                    } else {
                        c.a(jSONObject, be1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        be1Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            be1Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        be1Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            be1Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    be1Var.s = jSONObject.optLong("start");
                    be1Var.t = jSONObject.optLong("end");
                    be1Var.u = jSONObject.optInt("expose_interval");
                    be1Var.v = jSONObject.optInt("expose_times");
                    be1Var.w = jSONObject.optInt("preload_type");
                    be1Var.z = jSONObject.optString("click_float_lottie_url");
                    be1Var.A = jSONObject.optInt("float_bar_show", 1);
                    be1Var.B = jSONObject.optInt("click_float_opt", 1);
                    be1Var.C = jSONObject.optString("style_desc");
                    be1Var.x = jSONObject.optInt("curRate");
                    be1Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    be1Var.F = jSONObject.optInt("ad_sort");
                    be1Var.G = jSONObject.optInt("gesture_lottie_type");
                    be1Var.H = jSONObject.optString("gesture_lottie_url");
                    be1Var.I = jSONObject.optInt("gesture_lottie_sensitivity");
                    int optInt = jSONObject.optInt("is_topview", 0);
                    be1Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        be1Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        be1Var.L = jSONObject.optJSONObject("animation_data");
                    }
                    be1Var.M = jSONObject.optInt("shake_update_interval", 0);
                    be1Var.N = jSONObject.optInt("shake_direction_count", 0);
                    be1Var.O = jSONObject.optString("key");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, be1 be1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, be1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    be1Var.a = optJSONObject.optInt("advisible", 1);
                    be1Var.b = optJSONObject.optString("id");
                    be1Var.c = optJSONObject.optString("ukey");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("extra");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        int i = 0;
                        while (true) {
                            if (i >= optJSONArray2.length()) {
                                break;
                            }
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i);
                            if (optJSONObject3 != null) {
                                String optString = optJSONObject3.optString("k");
                                String optString2 = optJSONObject3.optString("v");
                                if (!TextUtils.isEmpty(optString2) && TextUtils.equals("extraParam", optString)) {
                                    be1Var.d = optString2;
                                    break;
                                }
                            }
                            i++;
                        }
                    }
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("material");
                    if (optJSONArray3 == null || (optJSONObject2 = optJSONArray3.optJSONObject(0)) == null) {
                        return;
                    }
                    JSONArray optJSONArray4 = optJSONObject2.optJSONArray("info");
                    if (optJSONArray4 == null) {
                        String optString3 = optJSONObject2.optString("info");
                        if (!TextUtils.isEmpty(optString3)) {
                            optJSONArray4 = new JSONArray(optString3);
                        }
                    }
                    if (optJSONArray4 != null) {
                        JSONObject optJSONObject4 = optJSONArray4.optJSONObject(0);
                        be1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                        if (optJSONObject5 != null) {
                            be1Var.f = optJSONObject5.optInt("type");
                            be1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                            be1Var.o = optJSONObject5.optString("action");
                            be1Var.p = optJSONObject5.optString("action_cmd");
                            be1Var.l = optJSONObject5.optString("flag_name");
                            be1Var.m = optJSONObject5.optInt("logo_type");
                            be1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                            JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                            be1Var.z = optJSONObject5.optString("click_float_lottie_url");
                            be1Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                            be1Var.F = optJSONObject5.optInt("ad_sort");
                            be1Var.G = optJSONObject5.optInt("gesture_lottie_type");
                            be1Var.H = optJSONObject5.optString("gesture_lottie_url");
                            be1Var.I = optJSONObject5.optInt("gesture_lottie_sensitivity");
                            be1Var.J = optJSONObject5.optInt("is_topview", 0);
                            if (be1Var.i() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                b.a(optJSONArray5.optJSONObject(0), be1Var);
                            } else {
                                c.a(optJSONObject5, be1Var);
                            }
                            be1Var.L = optJSONObject5.optJSONObject("animation_data");
                            be1Var.M = optJSONObject5.optInt("shake_update_interval", 0);
                            be1Var.N = optJSONObject5.optInt("shake_direction_count", 0);
                            be1Var.O = optJSONObject5.optString("key");
                        }
                        JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                        if (optJSONArray6 != null) {
                            be1Var.q = new String[optJSONArray6.length()];
                            int length = optJSONArray6.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                be1Var.q[i2] = optJSONArray6.optString(i2);
                            }
                        }
                        JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                        if (optJSONArray7 != null) {
                            be1Var.r = new String[optJSONArray7.length()];
                            int length2 = optJSONArray7.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                be1Var.r[i3] = optJSONArray7.optString(i3);
                            }
                        }
                        JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                        if (optJSONObject6 != null) {
                            JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                            be1Var.s = jSONObject2.optLong("start");
                            be1Var.t = jSONObject2.optLong("end");
                            be1Var.u = optJSONObject6.optInt("expose_interval");
                            be1Var.v = optJSONObject6.optInt("expose_times");
                            be1Var.w = optJSONObject6.optInt("preload_type");
                            be1Var.A = optJSONObject6.optInt("float_bar_show", 1);
                            be1Var.B = optJSONObject6.optInt("click_float_opt", 1);
                            be1Var.C = optJSONObject6.optString("style_desc");
                        }
                        JSONObject optJSONObject7 = optJSONObject4.optJSONObject("topview_data");
                        if (be1Var.J != 1 || optJSONObject7 == null) {
                            return;
                        }
                        JSONObject optJSONObject8 = optJSONObject7.optJSONObject("content");
                        if (optJSONObject8 == null) {
                            be1Var.J = 0;
                            return;
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        xz0.f(jSONObject3, "click_float_lottie_url", be1Var.z);
                        xz0.d(jSONObject3, "click_float_opt", be1Var.B);
                        xz0.d(jSONObject3, "float_bar_show", be1Var.A);
                        xz0.g(jSONObject3, SetImageWatermarkTypeReqMsg.SWITCH, true);
                        xz0.f(jSONObject3, "style_desc", be1Var.C);
                        xz0.d(jSONObject3, "countdown", be1Var.n);
                        xz0.f(jSONObject3, "source_path", zd1.s(be1Var.g));
                        xz0.f(optJSONObject8, "topview", jSONObject3);
                        be1Var.K = optJSONObject7;
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, be1 be1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, be1Var) == null) {
                try {
                    jSONObject.put("advisible", be1Var.a);
                    jSONObject.put("id", be1Var.b);
                    jSONObject.put("ukey", be1Var.c);
                    jSONObject.put("extra", be1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, be1Var.e);
                    jSONObject.put("type", be1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, be1Var.k);
                    jSONObject.put("action", be1Var.o);
                    jSONObject.put("action_cmd", be1Var.p);
                    jSONObject.put("flag_name", be1Var.l);
                    jSONObject.put("logo_type", be1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, be1Var.n);
                    jSONObject.put("start", be1Var.s);
                    jSONObject.put("end", be1Var.t);
                    jSONObject.put("expose_times", be1Var.v);
                    jSONObject.put("expose_interval", be1Var.u);
                    jSONObject.put("preload_type", be1Var.w);
                    jSONObject.put("curRate", be1Var.x);
                    jSONObject.put("click_float_lottie_url", be1Var.z);
                    jSONObject.put("float_bar_show", be1Var.A);
                    jSONObject.put("click_float_opt", be1Var.B);
                    jSONObject.put("style_desc", be1Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, be1Var.E);
                    jSONObject.put("ad_sort", be1Var.F);
                    jSONObject.put("gesture_lottie_type", be1Var.G);
                    jSONObject.put("gesture_lottie_url", be1Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", be1Var.I);
                    jSONObject.put("is_topview", be1Var.J);
                    if (be1Var.J == 1 && be1Var.K != null) {
                        jSONObject.put("topview_data", be1Var.K);
                    }
                    if (be1Var.L != null) {
                        jSONObject.put("animation_data", be1Var.L);
                    }
                    jSONObject.put("shake_update_interval", be1Var.M);
                    jSONObject.put("shake_direction_count", be1Var.N);
                    jSONObject.put("key", be1Var.O);
                    if (be1Var.q != null) {
                        if (t21.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(be1Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(be1Var.q)));
                        }
                    }
                    if (be1Var.r != null) {
                        if (t21.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(be1Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(be1Var.r)));
                        }
                    }
                    if (be1Var.i()) {
                        b.b(jSONObject, be1Var);
                    } else {
                        c.b(jSONObject, be1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void d(be1 be1Var, be1 be1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, be1Var, be1Var2) == null) {
                be1Var.a = be1Var2.a;
                be1Var.b = be1Var2.b;
                be1Var.c = be1Var2.c;
                be1Var.d = be1Var2.d;
                be1Var.e = be1Var2.e;
                be1Var.f = be1Var2.f;
                be1Var.g = be1Var2.g;
                be1Var.h = be1Var2.h;
                be1Var.i = be1Var2.i;
                be1Var.j = be1Var2.j;
                be1Var.k = be1Var2.k;
                be1Var.l = be1Var2.l;
                be1Var.m = be1Var2.m;
                be1Var.n = be1Var2.n;
                be1Var.o = be1Var2.o;
                be1Var.p = be1Var2.p;
                be1Var.q = be1Var2.q;
                be1Var.r = be1Var2.r;
                be1Var.s = be1Var2.s;
                be1Var.t = be1Var2.t;
                be1Var.u = be1Var2.u;
                be1Var.v = be1Var2.v;
                be1Var.x = be1Var2.x;
                be1Var.z = be1Var2.z;
                be1Var.A = be1Var2.A;
                be1Var.B = be1Var2.B;
                be1Var.C = be1Var2.C;
                be1Var.E = be1Var2.E;
                be1Var.F = be1Var2.F;
                be1Var.G = be1Var2.G;
                be1Var.H = be1Var2.H;
                be1Var.I = be1Var2.I;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, be1 be1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, be1Var) == null) || jSONObject == null) {
                return;
            }
            try {
                be1Var.g = jSONObject.optString("url");
                be1Var.h = jSONObject.optInt("width");
                be1Var.i = jSONObject.optInt("height");
                be1Var.j = jSONObject.optString("imageMd5");
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, be1 be1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, be1Var) == null) {
                try {
                    jSONObject.put("url", be1Var.g);
                    jSONObject.put("imageMd5", be1Var.j);
                    jSONObject.put("width", be1Var.h);
                    jSONObject.put("height", be1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, be1 be1Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(65536, null, jSONObject, be1Var) == null) || jSONObject == null) {
                return;
            }
            try {
                be1Var.g = jSONObject.optString("url");
                be1Var.h = jSONObject.optInt("width");
                be1Var.i = jSONObject.optInt("height");
                be1Var.j = jSONObject.optString(PackageTable.MD5);
            } catch (Exception unused) {
            }
        }

        public static void b(JSONObject jSONObject, be1 be1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, be1Var) == null) {
                try {
                    jSONObject.put("url", be1Var.g);
                    jSONObject.put(PackageTable.MD5, be1Var.j);
                    jSONObject.put("width", be1Var.h);
                    jSONObject.put("height", be1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public be1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.x = 0;
        this.y = false;
    }

    public static boolean a(be1 be1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, be1Var)) == null) {
            if (TextUtils.isEmpty(be1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            if (z && TextUtils.isEmpty(be1Var.g)) {
                str = "66";
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > be1Var.t) {
                str = "68";
                z = false;
            }
            if (z) {
                return true;
            }
            new BaseVM(be1Var).g(str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static be1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            be1 be1Var = new be1();
            try {
                a.a(jSONObject, be1Var);
            } catch (Exception unused) {
            }
            return be1Var;
        }
        return (be1) invokeL.objValue;
    }

    public static be1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                be1 be1Var = new be1();
                a.b(jSONObject, be1Var);
                return be1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (be1) invokeL.objValue;
    }

    public static List<be1> j(JSONArray jSONArray) {
        InterceptResult invokeL;
        be1 c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    c2 = c((JSONObject) jSONArray.get(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (c2 == null) {
                    break;
                }
                if (c2.a != 0 && a(c2)) {
                    arrayList.add(c2);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static void l(be1 be1Var, be1 be1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, be1Var, be1Var2) == null) {
            a.d(be1Var, be1Var2);
        }
    }

    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (!TextUtils.isEmpty(this.C)) {
                try {
                    return new JSONObject(this.C);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return new JSONObject();
                }
            }
            return new JSONObject();
        }
        return (JSONObject) invokeV.objValue;
    }

    @NonNull
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TextUtils.equals(this.e, "splash_image") ? "image" : TextUtils.equals(this.e, "splash_video") ? "video" : "" : (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.E == 3 : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f == 1 : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.E;
            return i == 0 || i == 1 || i == 2;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? TextUtils.equals(this.e, "splash_image") : invokeV.booleanValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            a.c(jSONObject, this);
            return jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }
}
