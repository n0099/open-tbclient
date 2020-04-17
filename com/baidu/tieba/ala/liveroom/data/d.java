package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.baidu.live.ar.g {
    public int fFu;
    public int fFv;
    public String mFilterName = "delta";
    public int fFn = 80;
    public int fFo = 50;
    public int fFp = 80;
    public int fFq = 80;
    public int fFr = 80;
    public int fFs = 25;
    public int fFt = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.fFn);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.fFp);
            jSONObject.put("red_level", this.fFo);
            jSONObject.put("big_eye", this.fFq);
            jSONObject.put("thin_face", this.fFr);
            jSONObject.put("chin", this.fFs);
            jSONObject.put("nose", this.fFt);
            jSONObject.put("v_face", this.fFu);
            jSONObject.put("face_three_counts", this.fFv);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d AE(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.fFn = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.fFp = jSONObject.optInt("blur_level");
                this.fFq = jSONObject.optInt("big_eye");
                this.fFr = jSONObject.optInt("thin_face");
                this.fFo = jSONObject.getInt("red_level");
                this.fFs = jSONObject.optInt("chin");
                this.fFt = jSONObject.getInt("nose");
                this.fFu = jSONObject.optInt("v_face");
                this.fFv = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
