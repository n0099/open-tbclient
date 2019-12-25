package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public String mFilterName = "delta";
    public int eUN = 40;
    public int eUO = 50;
    public int eUP = 5;
    public int eUQ = 50;
    public int eUR = 50;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.eUN);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.eUP);
            jSONObject.put("red_level", this.eUO);
            jSONObject.put("big_eye", this.eUQ);
            jSONObject.put("thin_face", this.eUR);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public c yx(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.eUN = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.eUP = jSONObject.optInt("blur_level");
                this.eUQ = jSONObject.optInt("big_eye");
                this.eUR = jSONObject.optInt("thin_face");
                this.eUO = jSONObject.getInt("red_level");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
