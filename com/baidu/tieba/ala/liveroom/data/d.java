package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.baidu.live.ar.g {
    public int fTE;
    public int fTF;
    public String mFilterName = "delta";
    public int fTx = 80;
    public int fTy = 50;
    public int fTz = 80;
    public int fTA = 80;
    public int fTB = 80;
    public int fTC = 25;
    public int fTD = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.fTx);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.fTz);
            jSONObject.put("red_level", this.fTy);
            jSONObject.put("big_eye", this.fTA);
            jSONObject.put("thin_face", this.fTB);
            jSONObject.put("chin", this.fTC);
            jSONObject.put("nose", this.fTD);
            jSONObject.put("v_face", this.fTE);
            jSONObject.put("face_three_counts", this.fTF);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d Cp(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.fTx = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.fTz = jSONObject.optInt("blur_level");
                this.fTA = jSONObject.optInt("big_eye");
                this.fTB = jSONObject.optInt("thin_face");
                this.fTy = jSONObject.getInt("red_level");
                this.fTC = jSONObject.optInt("chin");
                this.fTD = jSONObject.getInt("nose");
                this.fTE = jSONObject.optInt("v_face");
                this.fTF = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
