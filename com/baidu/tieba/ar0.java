package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ar0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final String b;
    public final int c;
    public final String d;
    public String e;
    public boolean f;
    public String g;
    @Nullable
    public final cr0 h;
    @NonNull
    public String i;
    @NonNull
    public final HashMap<String, String> j;

    public ar0(@NonNull JSONObject jSONObject, boolean z) {
        Object opt;
        Object opt2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new HashMap<>();
        this.f = TextUtils.equals(jSONObject.optString("video_stretch_switch"), "1");
        if (z) {
            this.a = jSONObject.optString(TiebaStatic.Params.VID);
            jSONObject.optString("video_id");
            this.b = jSONObject.optString("video_url");
            this.e = jSONObject.optString("title");
            this.c = jSONObject.optInt("duration");
            jSONObject.optInt("width");
            jSONObject.optInt("height");
            jSONObject.optDouble("whRatio", 0.0d);
            this.d = jSONObject.optString("poster_image");
            this.h = cr0.a(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
            try {
                jSONObject.putOpt("videoUrl", this.b);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next) && (opt2 = jSONObject.opt(next)) != null && !(opt2 instanceof JSONObject) && !(opt2 instanceof JSONArray)) {
                    this.j.put(next, jSONObject.optString(next));
                }
            }
        } else {
            this.a = jSONObject.optString(TiebaStatic.Params.VID);
            jSONObject.optString("videoId");
            this.b = jSONObject.optString("videoUrl");
            this.e = jSONObject.optString("title");
            this.c = jSONObject.optInt("duration");
            jSONObject.optInt("width");
            jSONObject.optInt("height");
            this.d = jSONObject.optString("posterImage");
            jSONObject.optDouble("whRatio", 0.0d);
            this.h = cr0.a(jSONObject.optJSONObject(AdWebVideoActivityConfig.KEY_TAIL_FRAME));
            try {
                jSONObject.putOpt("video_url", this.b);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            Iterator<String> keys2 = jSONObject.keys();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                if (!TextUtils.isEmpty(next2) && (opt = jSONObject.opt(next2)) != null && !(opt instanceof JSONObject) && !(opt instanceof JSONArray)) {
                    this.j.put(next2, jSONObject.optString(next2));
                }
            }
        }
        this.i = jSONObject.toString();
    }

    @Nullable
    public static ar0 b(JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, jSONObject, z)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return new ar0(jSONObject, z);
        }
        return (ar0) invokeLZ.objValue;
    }

    @Nullable
    public static ar0 c(HashMap hashMap) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hashMap)) == null) {
            if (hashMap == null || (obj = hashMap.get(WriteActivityConfig.VIDEO_INFO)) == null) {
                return null;
            }
            ar0 ar0Var = new ar0(y11.c(obj.toString()), true);
            if (hashMap.get("ext_info") != null) {
                ar0Var.g = hashMap.get("ext_info").toString();
            }
            ar0Var.a();
            return ar0Var;
        }
        return (ar0) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && !TextUtils.isEmpty(this.i)) {
            JSONObject c = y11.c(this.i);
            y11.f(c, "videoId", c.optString("video_id"));
            y11.f(c, PrefetchEvent.EVENT_KEY_PAGE_URL, c.optString("page_url"));
            y11.f(c, "videoUrl", c.optString("video_url"));
            y11.f(c, "posterImage", c.optString("poster_image"));
            this.i = c.toString();
        }
    }

    public void d(@NonNull AdBaseModel adBaseModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, adBaseModel) == null) {
            if (TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(adBaseModel.f.g)) {
                String str = adBaseModel.f.g;
                this.e = str;
                this.j.put("title", str);
            }
            if (TextUtils.isEmpty(this.g)) {
                this.g = adBaseModel.f.d;
            }
            e();
            cr0 cr0Var = this.h;
            if (cr0Var != null) {
                cr0Var.d(adBaseModel);
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && !TextUtils.isEmpty(this.i)) {
            JSONObject c = y11.c(this.i);
            if (!TextUtils.isEmpty(this.e) && TextUtils.isEmpty(c.optString("title"))) {
                y11.f(c, "title", this.e);
            }
            JSONObject optJSONObject = c.optJSONObject("ext_log");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            if (TextUtils.isEmpty(optJSONObject.optString("curVid"))) {
                y11.f(optJSONObject, "curVid", this.a);
            }
            if (!optJSONObject.has("mt")) {
                y11.d(optJSONObject, "mt", 2);
            }
            if (!optJSONObject.has("vType")) {
                y11.d(optJSONObject, "vType", 2);
            }
            if (!TextUtils.isEmpty(this.g) && TextUtils.isEmpty(optJSONObject.optString("ad_extra_param"))) {
                y11.f(optJSONObject, "ad_extra_param", this.g);
            }
            y11.f(c, "ext_log", optJSONObject);
            this.i = c.toString();
        }
    }
}
