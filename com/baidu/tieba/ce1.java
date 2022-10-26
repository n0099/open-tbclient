package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.prologue.business.data.BaseVM;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.tieba.u21;
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
public class ce1 {
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
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, ce1 ce1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ce1Var) == null) {
                try {
                    ce1Var.a = jSONObject.optInt("advisible");
                    ce1Var.b = jSONObject.optString("id");
                    ce1Var.c = jSONObject.optString("ukey");
                    ce1Var.d = jSONObject.optString("extra");
                    ce1Var.e = jSONObject.optString(TtmlNode.TAG_LAYOUT);
                    ce1Var.f = jSONObject.optInt("type");
                    ce1Var.k = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                    ce1Var.o = jSONObject.optString("action");
                    ce1Var.p = jSONObject.optString("action_cmd");
                    ce1Var.l = jSONObject.optString("flag_name");
                    ce1Var.m = jSONObject.optInt("logo_type");
                    ce1Var.n = jSONObject.optInt(CriusAttrConstants.DISPLAY);
                    if (ce1Var.i()) {
                        b.a(jSONObject, ce1Var);
                    } else {
                        c.a(jSONObject, ce1Var);
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("show_urls");
                    if (optJSONArray != null) {
                        ce1Var.q = new String[optJSONArray.length()];
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            ce1Var.q[i] = optJSONArray.optString(i);
                        }
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("click_urls");
                    if (optJSONArray2 != null) {
                        ce1Var.r = new String[optJSONArray2.length()];
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            ce1Var.r[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    ce1Var.s = jSONObject.optLong("start");
                    ce1Var.t = jSONObject.optLong("end");
                    ce1Var.u = jSONObject.optInt("expose_interval");
                    ce1Var.v = jSONObject.optInt("expose_times");
                    ce1Var.w = jSONObject.optInt("preload_type");
                    ce1Var.z = jSONObject.optString("click_float_lottie_url");
                    ce1Var.A = jSONObject.optInt("float_bar_show", 1);
                    ce1Var.B = jSONObject.optInt("click_float_opt", 1);
                    ce1Var.C = jSONObject.optString("style_desc");
                    ce1Var.x = jSONObject.optInt("curRate");
                    ce1Var.E = jSONObject.optInt(TiebaStatic.Params.AD_TYPE);
                    ce1Var.F = jSONObject.optInt("ad_sort");
                    ce1Var.G = jSONObject.optInt("gesture_lottie_type");
                    ce1Var.H = jSONObject.optString("gesture_lottie_url");
                    ce1Var.I = jSONObject.optInt("gesture_lottie_sensitivity");
                    int optInt = jSONObject.optInt("is_topview", 0);
                    ce1Var.J = optInt;
                    if (optInt == 1 && jSONObject.optJSONObject("topview_data") != null) {
                        ce1Var.K = jSONObject.optJSONObject("topview_data");
                    }
                    if (jSONObject.optJSONObject("animation_data") != null) {
                        ce1Var.L = jSONObject.optJSONObject("animation_data");
                    }
                    ce1Var.M = jSONObject.optInt("shake_update_interval", 0);
                    ce1Var.N = jSONObject.optInt("shake_direction_count", 0);
                    ce1Var.O = jSONObject.optString("key");
                } catch (Exception unused) {
                }
            }
        }

        public static void c(JSONObject jSONObject, ce1 ce1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65538, null, jSONObject, ce1Var) == null) {
                try {
                    jSONObject.put("advisible", ce1Var.a);
                    jSONObject.put("id", ce1Var.b);
                    jSONObject.put("ukey", ce1Var.c);
                    jSONObject.put("extra", ce1Var.d);
                    jSONObject.put(TtmlNode.TAG_LAYOUT, ce1Var.e);
                    jSONObject.put("type", ce1Var.f);
                    jSONObject.put(BigdayActivityConfig.JUMP_URL, ce1Var.k);
                    jSONObject.put("action", ce1Var.o);
                    jSONObject.put("action_cmd", ce1Var.p);
                    jSONObject.put("flag_name", ce1Var.l);
                    jSONObject.put("logo_type", ce1Var.m);
                    jSONObject.put(CriusAttrConstants.DISPLAY, ce1Var.n);
                    jSONObject.put("start", ce1Var.s);
                    jSONObject.put("end", ce1Var.t);
                    jSONObject.put("expose_times", ce1Var.v);
                    jSONObject.put("expose_interval", ce1Var.u);
                    jSONObject.put("preload_type", ce1Var.w);
                    jSONObject.put("curRate", ce1Var.x);
                    jSONObject.put("click_float_lottie_url", ce1Var.z);
                    jSONObject.put("float_bar_show", ce1Var.A);
                    jSONObject.put("click_float_opt", ce1Var.B);
                    jSONObject.put("style_desc", ce1Var.C);
                    jSONObject.put(TiebaStatic.Params.AD_TYPE, ce1Var.E);
                    jSONObject.put("ad_sort", ce1Var.F);
                    jSONObject.put("gesture_lottie_type", ce1Var.G);
                    jSONObject.put("gesture_lottie_url", ce1Var.H);
                    jSONObject.put("gesture_lottie_sensitivity", ce1Var.I);
                    jSONObject.put("is_topview", ce1Var.J);
                    if (ce1Var.J == 1 && ce1Var.K != null) {
                        jSONObject.put("topview_data", ce1Var.K);
                    }
                    if (ce1Var.L != null) {
                        jSONObject.put("animation_data", ce1Var.L);
                    }
                    jSONObject.put("shake_update_interval", ce1Var.M);
                    jSONObject.put("shake_direction_count", ce1Var.N);
                    jSONObject.put("key", ce1Var.O);
                    if (ce1Var.q != null) {
                        if (u21.b.c()) {
                            jSONObject.put("show_urls", new JSONArray(ce1Var.q));
                        } else {
                            jSONObject.put("show_urls", new JSONArray((Collection) Arrays.asList(ce1Var.q)));
                        }
                    }
                    if (ce1Var.r != null) {
                        if (u21.b.c()) {
                            jSONObject.put("click_urls", new JSONArray(ce1Var.r));
                        } else {
                            jSONObject.put("click_urls", new JSONArray((Collection) Arrays.asList(ce1Var.r)));
                        }
                    }
                    if (ce1Var.i()) {
                        b.b(jSONObject, ce1Var);
                    } else {
                        c.b(jSONObject, ce1Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void b(JSONObject jSONObject, ce1 ce1Var) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ce1Var) == null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("adInfo");
                    if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                        return;
                    }
                    ce1Var.a = optJSONObject.optInt("advisible", 1);
                    ce1Var.b = optJSONObject.optString("id");
                    ce1Var.c = optJSONObject.optString("ukey");
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
                                    ce1Var.d = optString2;
                                    break;
                                }
                            }
                            i++;
                        }
                    }
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("material");
                    if (optJSONArray3 != null && (optJSONObject2 = optJSONArray3.optJSONObject(0)) != null) {
                        JSONArray optJSONArray4 = optJSONObject2.optJSONArray("info");
                        if (optJSONArray4 == null) {
                            String optString3 = optJSONObject2.optString("info");
                            if (!TextUtils.isEmpty(optString3)) {
                                optJSONArray4 = new JSONArray(optString3);
                            }
                        }
                        if (optJSONArray4 != null) {
                            JSONObject optJSONObject4 = optJSONArray4.optJSONObject(0);
                            ce1Var.e = optJSONObject4.optString(TtmlNode.TAG_LAYOUT);
                            JSONObject optJSONObject5 = optJSONObject4.optJSONObject("common");
                            if (optJSONObject5 != null) {
                                ce1Var.f = optJSONObject5.optInt("type");
                                ce1Var.k = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                                ce1Var.o = optJSONObject5.optString("action");
                                ce1Var.p = optJSONObject5.optString("action_cmd");
                                ce1Var.l = optJSONObject5.optString("flag_name");
                                ce1Var.m = optJSONObject5.optInt("logo_type");
                                ce1Var.n = optJSONObject5.optInt(CriusAttrConstants.DISPLAY);
                                JSONArray optJSONArray5 = optJSONObject5.optJSONArray("image_list");
                                ce1Var.z = optJSONObject5.optString("click_float_lottie_url");
                                ce1Var.E = optJSONObject5.optInt(TiebaStatic.Params.AD_TYPE);
                                ce1Var.F = optJSONObject5.optInt("ad_sort");
                                ce1Var.G = optJSONObject5.optInt("gesture_lottie_type");
                                ce1Var.H = optJSONObject5.optString("gesture_lottie_url");
                                ce1Var.I = optJSONObject5.optInt("gesture_lottie_sensitivity");
                                ce1Var.J = optJSONObject5.optInt("is_topview", 0);
                                if (ce1Var.i() && optJSONArray5 != null && optJSONArray5.length() > 0) {
                                    b.a(optJSONArray5.optJSONObject(0), ce1Var);
                                } else {
                                    c.a(optJSONObject5, ce1Var);
                                }
                                ce1Var.L = optJSONObject5.optJSONObject("animation_data");
                                ce1Var.M = optJSONObject5.optInt("shake_update_interval", 0);
                                ce1Var.N = optJSONObject5.optInt("shake_direction_count", 0);
                                ce1Var.O = optJSONObject5.optString("key");
                            }
                            JSONArray optJSONArray6 = optJSONObject4.optJSONArray("show_urls");
                            if (optJSONArray6 != null) {
                                ce1Var.q = new String[optJSONArray6.length()];
                                int length = optJSONArray6.length();
                                for (int i2 = 0; i2 < length; i2++) {
                                    ce1Var.q[i2] = optJSONArray6.optString(i2);
                                }
                            }
                            JSONArray optJSONArray7 = optJSONObject4.optJSONArray("click_urls");
                            if (optJSONArray7 != null) {
                                ce1Var.r = new String[optJSONArray7.length()];
                                int length2 = optJSONArray7.length();
                                for (int i3 = 0; i3 < length2; i3++) {
                                    ce1Var.r[i3] = optJSONArray7.optString(i3);
                                }
                            }
                            JSONObject optJSONObject6 = optJSONObject4.optJSONObject("policy");
                            if (optJSONObject6 != null) {
                                JSONObject jSONObject2 = optJSONObject6.getJSONObject("expire_time");
                                ce1Var.s = jSONObject2.optLong("start");
                                ce1Var.t = jSONObject2.optLong("end");
                                ce1Var.u = optJSONObject6.optInt("expose_interval");
                                ce1Var.v = optJSONObject6.optInt("expose_times");
                                ce1Var.w = optJSONObject6.optInt("preload_type");
                                ce1Var.A = optJSONObject6.optInt("float_bar_show", 1);
                                ce1Var.B = optJSONObject6.optInt("click_float_opt", 1);
                                ce1Var.C = optJSONObject6.optString("style_desc");
                            }
                            JSONObject optJSONObject7 = optJSONObject4.optJSONObject("topview_data");
                            if (ce1Var.J == 1 && optJSONObject7 != null) {
                                JSONObject optJSONObject8 = optJSONObject7.optJSONObject("content");
                                if (optJSONObject8 == null) {
                                    ce1Var.J = 0;
                                    return;
                                }
                                JSONObject jSONObject3 = new JSONObject();
                                yz0.f(jSONObject3, "click_float_lottie_url", ce1Var.z);
                                yz0.d(jSONObject3, "click_float_opt", ce1Var.B);
                                yz0.d(jSONObject3, "float_bar_show", ce1Var.A);
                                yz0.g(jSONObject3, SetImageWatermarkTypeReqMsg.SWITCH, true);
                                yz0.f(jSONObject3, "style_desc", ce1Var.C);
                                yz0.d(jSONObject3, "countdown", ce1Var.n);
                                yz0.f(jSONObject3, "source_path", ae1.s(ce1Var.g));
                                yz0.f(optJSONObject8, "topview", jSONObject3);
                                ce1Var.K = optJSONObject7;
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        public static void d(ce1 ce1Var, ce1 ce1Var2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65539, null, ce1Var, ce1Var2) == null) {
                ce1Var.a = ce1Var2.a;
                ce1Var.b = ce1Var2.b;
                ce1Var.c = ce1Var2.c;
                ce1Var.d = ce1Var2.d;
                ce1Var.e = ce1Var2.e;
                ce1Var.f = ce1Var2.f;
                ce1Var.g = ce1Var2.g;
                ce1Var.h = ce1Var2.h;
                ce1Var.i = ce1Var2.i;
                ce1Var.j = ce1Var2.j;
                ce1Var.k = ce1Var2.k;
                ce1Var.l = ce1Var2.l;
                ce1Var.m = ce1Var2.m;
                ce1Var.n = ce1Var2.n;
                ce1Var.o = ce1Var2.o;
                ce1Var.p = ce1Var2.p;
                ce1Var.q = ce1Var2.q;
                ce1Var.r = ce1Var2.r;
                ce1Var.s = ce1Var2.s;
                ce1Var.t = ce1Var2.t;
                ce1Var.u = ce1Var2.u;
                ce1Var.v = ce1Var2.v;
                ce1Var.x = ce1Var2.x;
                ce1Var.z = ce1Var2.z;
                ce1Var.A = ce1Var2.A;
                ce1Var.B = ce1Var2.B;
                ce1Var.C = ce1Var2.C;
                ce1Var.E = ce1Var2.E;
                ce1Var.F = ce1Var2.F;
                ce1Var.G = ce1Var2.G;
                ce1Var.H = ce1Var2.H;
                ce1Var.I = ce1Var2.I;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, ce1 ce1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ce1Var) == null) && jSONObject != null) {
                try {
                    ce1Var.g = jSONObject.optString("url");
                    ce1Var.h = jSONObject.optInt("width");
                    ce1Var.i = jSONObject.optInt("height");
                    ce1Var.j = jSONObject.optString("imageMd5");
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, ce1 ce1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ce1Var) == null) {
                try {
                    jSONObject.put("url", ce1Var.g);
                    jSONObject.put("imageMd5", ce1Var.j);
                    jSONObject.put("width", ce1Var.h);
                    jSONObject.put("height", ce1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a(JSONObject jSONObject, ce1 ce1Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(65536, null, jSONObject, ce1Var) == null) && jSONObject != null) {
                try {
                    ce1Var.g = jSONObject.optString("url");
                    ce1Var.h = jSONObject.optInt("width");
                    ce1Var.i = jSONObject.optInt("height");
                    ce1Var.j = jSONObject.optString(PackageTable.MD5);
                } catch (Exception unused) {
                }
            }
        }

        public static void b(JSONObject jSONObject, ce1 ce1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, jSONObject, ce1Var) == null) {
                try {
                    jSONObject.put("url", ce1Var.g);
                    jSONObject.put(PackageTable.MD5, ce1Var.j);
                    jSONObject.put("width", ce1Var.h);
                    jSONObject.put("height", ce1Var.i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ce1() {
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

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.equals(this.e, "splash_image")) {
                return "image";
            }
            if (TextUtils.equals(this.e, "splash_video")) {
                return "video";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.E == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.E;
            if (i == 0 || i == 1 || i == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return TextUtils.equals(this.e, "splash_image");
        }
        return invokeV.booleanValue;
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

    public static boolean a(ce1 ce1Var) {
        InterceptResult invokeL;
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ce1Var)) == null) {
            if (TextUtils.isEmpty(ce1Var.d)) {
                str = "7";
                z = false;
            } else {
                str = "";
                z = true;
            }
            if (z && TextUtils.isEmpty(ce1Var.g)) {
                str = "66";
                z = false;
            }
            if (z && System.currentTimeMillis() / 1000 > ce1Var.t) {
                str = "68";
                z = false;
            }
            if (z) {
                return true;
            }
            new BaseVM(ce1Var).g(str);
            return false;
        }
        return invokeL.booleanValue;
    }

    public static ce1 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            ce1 ce1Var = new ce1();
            try {
                a.a(jSONObject, ce1Var);
            } catch (Exception unused) {
            }
            return ce1Var;
        }
        return (ce1) invokeL.objValue;
    }

    public static ce1 c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, jSONObject)) == null) {
            try {
                ce1 ce1Var = new ce1();
                a.b(jSONObject, ce1Var);
                return ce1Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (ce1) invokeL.objValue;
    }

    public static List j(JSONArray jSONArray) {
        InterceptResult invokeL;
        ce1 c2;
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

    public static void l(ce1 ce1Var, ce1 ce1Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ce1Var, ce1Var2) == null) {
            a.d(ce1Var, ce1Var2);
        }
    }
}
