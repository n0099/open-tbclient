package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.baidu.live.ar.d {
    public int fbl;
    public int fbm;
    public String mFilterName = "delta";
    public int fbe = 80;
    public int fbf = 50;
    public int fbg = 80;
    public int fbh = 80;
    public int fbi = 80;
    public int fbj = 25;
    public int fbk = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.fbe);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.fbg);
            jSONObject.put("red_level", this.fbf);
            jSONObject.put("big_eye", this.fbh);
            jSONObject.put("thin_face", this.fbi);
            jSONObject.put("chin", this.fbj);
            jSONObject.put("nose", this.fbk);
            jSONObject.put("v_face", this.fbl);
            jSONObject.put("face_three_counts", this.fbm);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d yX(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.fbe = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.fbg = jSONObject.optInt("blur_level");
                this.fbh = jSONObject.optInt("big_eye");
                this.fbi = jSONObject.optInt("thin_face");
                this.fbf = jSONObject.getInt("red_level");
                this.fbj = jSONObject.optInt("chin");
                this.fbk = jSONObject.getInt("nose");
                this.fbl = jSONObject.optInt("v_face");
                this.fbm = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
