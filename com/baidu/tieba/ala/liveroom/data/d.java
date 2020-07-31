package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import com.baidu.live.ar.i;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends i {
    public int gls;
    public int glt;
    public String mFilterName = "delta";
    public int gll = 80;
    public int glm = 50;
    public int gln = 80;
    public int glo = 80;
    public int glp = 80;
    public int glq = 25;
    public int glr = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.gll);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.gln);
            jSONObject.put("red_level", this.glm);
            jSONObject.put("big_eye", this.glo);
            jSONObject.put("thin_face", this.glp);
            jSONObject.put("chin", this.glq);
            jSONObject.put("nose", this.glr);
            jSONObject.put("v_face", this.gls);
            jSONObject.put("face_three_counts", this.glt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d Dz(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.gll = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.gln = jSONObject.optInt("blur_level");
                this.glo = jSONObject.optInt("big_eye");
                this.glp = jSONObject.optInt("thin_face");
                this.glm = jSONObject.getInt("red_level");
                this.glq = jSONObject.optInt("chin");
                this.glr = jSONObject.getInt("nose");
                this.gls = jSONObject.optInt("v_face");
                this.glt = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
