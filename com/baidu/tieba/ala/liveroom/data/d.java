package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.baidu.live.ar.i {
    public int ggk;
    public int ggl;
    public String mFilterName = "delta";
    public int ggd = 80;
    public int gge = 50;
    public int ggf = 80;
    public int ggg = 80;
    public int ggh = 80;
    public int ggi = 25;
    public int ggj = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.ggd);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.ggf);
            jSONObject.put("red_level", this.gge);
            jSONObject.put("big_eye", this.ggg);
            jSONObject.put("thin_face", this.ggh);
            jSONObject.put("chin", this.ggi);
            jSONObject.put("nose", this.ggj);
            jSONObject.put("v_face", this.ggk);
            jSONObject.put("face_three_counts", this.ggl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d CN(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.ggd = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.ggf = jSONObject.optInt("blur_level");
                this.ggg = jSONObject.optInt("big_eye");
                this.ggh = jSONObject.optInt("thin_face");
                this.gge = jSONObject.getInt("red_level");
                this.ggi = jSONObject.optInt("chin");
                this.ggj = jSONObject.getInt("nose");
                this.ggk = jSONObject.optInt("v_face");
                this.ggl = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
