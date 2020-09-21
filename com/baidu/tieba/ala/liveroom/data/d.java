package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import com.baidu.live.ar.i;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends i {
    public int gAL;
    public int gAM;
    public String mFilterName = "delta";
    public int gAE = 80;
    public int gAF = 50;
    public int gAG = 80;
    public int gAH = 80;
    public int gAI = 80;
    public int gAJ = 25;
    public int gAK = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.gAE);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.gAG);
            jSONObject.put("red_level", this.gAF);
            jSONObject.put("big_eye", this.gAH);
            jSONObject.put("thin_face", this.gAI);
            jSONObject.put("chin", this.gAJ);
            jSONObject.put("nose", this.gAK);
            jSONObject.put("v_face", this.gAL);
            jSONObject.put("face_three_counts", this.gAM);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d Gv(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.gAE = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.gAG = jSONObject.optInt("blur_level");
                this.gAH = jSONObject.optInt("big_eye");
                this.gAI = jSONObject.optInt("thin_face");
                this.gAF = jSONObject.getInt("red_level");
                this.gAJ = jSONObject.optInt("chin");
                this.gAK = jSONObject.getInt("nose");
                this.gAL = jSONObject.optInt("v_face");
                this.gAM = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
