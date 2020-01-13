package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends com.baidu.live.ar.d {
    public int eWK;
    public int eWL;
    public String mFilterName = "delta";
    public int eWD = 80;
    public int eWE = 50;
    public int eWF = 80;
    public int eWG = 80;
    public int eWH = 80;
    public int eWI = 25;
    public int eWJ = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.eWD);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.eWF);
            jSONObject.put("red_level", this.eWE);
            jSONObject.put("big_eye", this.eWG);
            jSONObject.put("thin_face", this.eWH);
            jSONObject.put("chin", this.eWI);
            jSONObject.put("nose", this.eWJ);
            jSONObject.put("v_face", this.eWK);
            jSONObject.put("face_three_counts", this.eWL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d yB(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.eWD = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.eWF = jSONObject.optInt("blur_level");
                this.eWG = jSONObject.optInt("big_eye");
                this.eWH = jSONObject.optInt("thin_face");
                this.eWE = jSONObject.getInt("red_level");
                this.eWI = jSONObject.optInt("chin");
                this.eWJ = jSONObject.getInt("nose");
                this.eWK = jSONObject.optInt("v_face");
                this.eWL = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
