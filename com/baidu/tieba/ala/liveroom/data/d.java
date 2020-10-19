package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import com.baidu.live.ar.i;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends i {
    public int gPe;
    public int gPf;
    public String mFilterName = "delta";
    public int gOX = 80;
    public int gOY = 50;
    public int gOZ = 80;
    public int gPa = 80;
    public int gPb = 80;
    public int gPc = 25;
    public int gPd = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.gOX);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.gOZ);
            jSONObject.put("red_level", this.gOY);
            jSONObject.put("big_eye", this.gPa);
            jSONObject.put("thin_face", this.gPb);
            jSONObject.put("chin", this.gPc);
            jSONObject.put("nose", this.gPd);
            jSONObject.put("v_face", this.gPe);
            jSONObject.put("face_three_counts", this.gPf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d Hh(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.gOX = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.gOZ = jSONObject.optInt("blur_level");
                this.gPa = jSONObject.optInt("big_eye");
                this.gPb = jSONObject.optInt("thin_face");
                this.gOY = jSONObject.getInt("red_level");
                this.gPc = jSONObject.optInt("chin");
                this.gPd = jSONObject.getInt("nose");
                this.gPe = jSONObject.optInt("v_face");
                this.gPf = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
