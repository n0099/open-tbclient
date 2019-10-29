package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public String mFilterName = "delta";
    public int efK = 40;
    public int efL = 50;
    public int efM = 5;
    public int efN = 50;
    public int efO = 50;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.efK);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.efM);
            jSONObject.put("red_level", this.efL);
            jSONObject.put("big_eye", this.efN);
            jSONObject.put("thin_face", this.efO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public c tI(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.efK = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.efM = jSONObject.optInt("blur_level");
                this.efN = jSONObject.optInt("big_eye");
                this.efO = jSONObject.optInt("thin_face");
                this.efL = jSONObject.getInt("red_level");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
