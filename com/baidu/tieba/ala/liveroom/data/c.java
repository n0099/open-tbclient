package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public String mFilterName = "delta";
    public int eeT = 40;
    public int eeU = 50;
    public int eeV = 5;
    public int eeW = 50;
    public int eeX = 50;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.eeT);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.eeV);
            jSONObject.put("red_level", this.eeU);
            jSONObject.put("big_eye", this.eeW);
            jSONObject.put("thin_face", this.eeX);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public c tI(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.eeT = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.eeV = jSONObject.optInt("blur_level");
                this.eeW = jSONObject.optInt("big_eye");
                this.eeX = jSONObject.optInt("thin_face");
                this.eeU = jSONObject.getInt("red_level");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
