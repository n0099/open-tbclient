package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.baidu.live.ar.d {
    public int faA;
    public int faB;
    public String mFilterName = "delta";
    public int fat = 80;
    public int fau = 50;
    public int fav = 80;
    public int faw = 80;
    public int fax = 80;
    public int fay = 25;
    public int faz = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.fat);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.fav);
            jSONObject.put("red_level", this.fau);
            jSONObject.put("big_eye", this.faw);
            jSONObject.put("thin_face", this.fax);
            jSONObject.put("chin", this.fay);
            jSONObject.put("nose", this.faz);
            jSONObject.put("v_face", this.faA);
            jSONObject.put("face_three_counts", this.faB);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d yV(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.fat = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.fav = jSONObject.optInt("blur_level");
                this.faw = jSONObject.optInt("big_eye");
                this.fax = jSONObject.optInt("thin_face");
                this.fau = jSONObject.getInt("red_level");
                this.fay = jSONObject.optInt("chin");
                this.faz = jSONObject.getInt("nose");
                this.faA = jSONObject.optInt("v_face");
                this.faB = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
