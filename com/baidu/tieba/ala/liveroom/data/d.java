package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.baidu.live.ar.d {
    public int faA;
    public int faz;
    public String mFilterName = "delta";
    public int fas = 80;
    public int fat = 50;
    public int fau = 80;
    public int fav = 80;
    public int faw = 80;
    public int fax = 25;
    public int fay = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.fas);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.fau);
            jSONObject.put("red_level", this.fat);
            jSONObject.put("big_eye", this.fav);
            jSONObject.put("thin_face", this.faw);
            jSONObject.put("chin", this.fax);
            jSONObject.put("nose", this.fay);
            jSONObject.put("v_face", this.faz);
            jSONObject.put("face_three_counts", this.faA);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d yV(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.fas = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.fau = jSONObject.optInt("blur_level");
                this.fav = jSONObject.optInt("big_eye");
                this.faw = jSONObject.optInt("thin_face");
                this.fat = jSONObject.getInt("red_level");
                this.fax = jSONObject.optInt("chin");
                this.fay = jSONObject.getInt("nose");
                this.faz = jSONObject.optInt("v_face");
                this.faA = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
