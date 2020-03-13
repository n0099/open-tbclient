package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.baidu.live.ar.d {
    public int faN;
    public int faO;
    public String mFilterName = "delta";
    public int faG = 80;
    public int faH = 50;
    public int faI = 80;
    public int faJ = 80;
    public int faK = 80;
    public int faL = 25;
    public int faM = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.faG);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.faI);
            jSONObject.put("red_level", this.faH);
            jSONObject.put("big_eye", this.faJ);
            jSONObject.put("thin_face", this.faK);
            jSONObject.put("chin", this.faL);
            jSONObject.put("nose", this.faM);
            jSONObject.put("v_face", this.faN);
            jSONObject.put("face_three_counts", this.faO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d yW(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.faG = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.faI = jSONObject.optInt("blur_level");
                this.faJ = jSONObject.optInt("big_eye");
                this.faK = jSONObject.optInt("thin_face");
                this.faH = jSONObject.getInt("red_level");
                this.faL = jSONObject.optInt("chin");
                this.faM = jSONObject.getInt("nose");
                this.faN = jSONObject.optInt("v_face");
                this.faO = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
