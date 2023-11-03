package com.baidu.tieba;

import com.baidu.searchbox.live.interfaces.defaultimpl.utils.MultiRatePlayUrlHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dw0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(iw0 mpdModel, JSONArray clarityUrlList) {
        ArrayList<ew0> a;
        int i;
        boolean z;
        ew0 ew0Var;
        ArrayList<Object> d;
        boolean e;
        ArrayList<ew0> a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, mpdModel, clarityUrlList) == null) {
            Intrinsics.checkNotNullParameter(mpdModel, "mpdModel");
            Intrinsics.checkNotNullParameter(clarityUrlList, "clarityUrlList");
            jw0 b = mpdModel.b();
            if (b != null && (a = b.a()) != null) {
                jw0 b2 = mpdModel.b();
                if (b2 != null && (a2 = b2.a()) != null) {
                    i = a2.size();
                } else {
                    i = 0;
                }
                if (i > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    a = null;
                }
                if (a != null && (ew0Var = a.get(0)) != null && (d = ew0Var.d()) != null) {
                    int size = d.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        JSONObject jSONObject = new JSONObject();
                        Object obj = d.get(i2);
                        if (!(obj instanceof kw0)) {
                            obj = null;
                        }
                        kw0 kw0Var = (kw0) obj;
                        if (kw0Var != null) {
                            jSONObject.put("key", kw0Var.g());
                            jSONObject.put(MultiRatePlayUrlHelper.RANK, kw0Var.j());
                            jSONObject.put("title", kw0Var.k());
                            jSONObject.put("url", kw0Var.l());
                            jSONObject.put("width", kw0Var.m());
                            jSONObject.put("height", kw0Var.f());
                            jSONObject.put("download_url", kw0Var.d());
                            jSONObject.put("airPlay_url", fx0.a(new String[]{kw0Var.a(), kw0Var.d(), kw0Var.l()}));
                            jSONObject.put("videoBps", kw0Var.b());
                            jSONObject.put("vodMoovSize", kw0Var.h());
                            jSONObject.put("video_clarity_score", kw0Var.c());
                            jSONObject.put("prefetch_size", kw0Var.i());
                            Boolean b3 = ew0Var.b();
                            if (b3 != null) {
                                e = b3.booleanValue();
                            } else {
                                e = kw0Var.e();
                            }
                            jSONObject.put("gopAlign", e);
                            clarityUrlList.put(jSONObject);
                        }
                    }
                }
            }
        }
    }

    public static final void b(iw0 mpdModel, JSONObject mpdJson) {
        JSONArray optJSONArray;
        JSONArray jSONArray;
        int i;
        JSONArray optJSONArray2;
        Boolean bool;
        JSONArray jSONArray2;
        int i2;
        JSONArray jSONArray3;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, mpdModel, mpdJson) == null) {
            Intrinsics.checkNotNullParameter(mpdModel, "mpdModel");
            Intrinsics.checkNotNullParameter(mpdJson, "mpdJson");
            JSONObject optJSONObject = mpdJson.optJSONObject("video");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("adaptation_set")) != null) {
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                int i4 = 0;
                while (i4 < length) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                    if (optJSONObject2 != null && (optJSONArray2 = optJSONObject2.optJSONArray("representation_list")) != null) {
                        ArrayList arrayList2 = new ArrayList();
                        int length2 = optJSONArray2.length();
                        int i5 = 0;
                        while (i5 < length2) {
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i5);
                            if (optJSONObject3 != null) {
                                jSONArray2 = optJSONArray;
                                jSONArray3 = optJSONArray2;
                                i3 = length2;
                                i2 = length;
                                arrayList2.add(new kw0(optJSONObject3.optString("key"), optJSONObject3.optInt(MultiRatePlayUrlHelper.RANK), optJSONObject3.optString("title"), optJSONObject3.optString("url"), optJSONObject3.optString("download_url"), optJSONObject3.optString("airPlay_url"), optJSONObject3.optInt(MultiRatePlayUrlHelper.BPS), optJSONObject3.optInt("width"), optJSONObject3.optInt("height"), optJSONObject3.optDouble("size"), optJSONObject3.optInt("moov_size"), optJSONObject3.optDouble("clarity_score", -1.0d), optJSONObject3.optInt("prefetch_size", 0), optJSONObject3.optBoolean("frm_align")));
                            } else {
                                jSONArray2 = optJSONArray;
                                i2 = length;
                                jSONArray3 = optJSONArray2;
                                i3 = length2;
                            }
                            i5++;
                            optJSONArray2 = jSONArray3;
                            optJSONArray = jSONArray2;
                            length2 = i3;
                            length = i2;
                        }
                        jSONArray = optJSONArray;
                        i = length;
                        String optString = optJSONObject2.optString("type");
                        if (optJSONObject2.has("frm_align")) {
                            bool = Boolean.valueOf(optJSONObject2.optBoolean("frm_align"));
                        } else {
                            bool = null;
                        }
                        arrayList.add(new ew0(arrayList2, optString, bool, optJSONObject2.optString("pre"), optJSONObject2.optString("suf"), optJSONObject2.optString("codecs")));
                    } else {
                        jSONArray = optJSONArray;
                        i = length;
                    }
                    i4++;
                    optJSONArray = jSONArray;
                    length = i;
                }
                mpdModel.f(new jw0(arrayList, null, null, null, null, 30, null));
            }
        }
    }
}
