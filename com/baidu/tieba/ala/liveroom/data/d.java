package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.baidu.live.ar.g {
    public int fFA;
    public int fFz;
    public String mFilterName = "delta";
    public int fFs = 80;
    public int fFt = 50;
    public int fFu = 80;
    public int fFv = 80;
    public int fFw = 80;
    public int fFx = 25;
    public int fFy = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.fFs);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.fFu);
            jSONObject.put("red_level", this.fFt);
            jSONObject.put("big_eye", this.fFv);
            jSONObject.put("thin_face", this.fFw);
            jSONObject.put("chin", this.fFx);
            jSONObject.put("nose", this.fFy);
            jSONObject.put("v_face", this.fFz);
            jSONObject.put("face_three_counts", this.fFA);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d AH(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.fFs = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.fFu = jSONObject.optInt("blur_level");
                this.fFv = jSONObject.optInt("big_eye");
                this.fFw = jSONObject.optInt("thin_face");
                this.fFt = jSONObject.getInt("red_level");
                this.fFx = jSONObject.optInt("chin");
                this.fFy = jSONObject.getInt("nose");
                this.fFz = jSONObject.optInt("v_face");
                this.fFA = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
