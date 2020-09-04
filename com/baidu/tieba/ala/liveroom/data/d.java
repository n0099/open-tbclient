package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import com.baidu.live.ar.i;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends i {
    public int gxA;
    public int gxB;
    public String mFilterName = "delta";
    public int gxt = 80;
    public int gxu = 50;
    public int gxv = 80;
    public int gxw = 80;
    public int gxx = 80;
    public int gxy = 25;
    public int gxz = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.gxt);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.gxv);
            jSONObject.put("red_level", this.gxu);
            jSONObject.put("big_eye", this.gxw);
            jSONObject.put("thin_face", this.gxx);
            jSONObject.put("chin", this.gxy);
            jSONObject.put("nose", this.gxz);
            jSONObject.put("v_face", this.gxA);
            jSONObject.put("face_three_counts", this.gxB);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d FX(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.gxt = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.gxv = jSONObject.optInt("blur_level");
                this.gxw = jSONObject.optInt("big_eye");
                this.gxx = jSONObject.optInt("thin_face");
                this.gxu = jSONObject.getInt("red_level");
                this.gxy = jSONObject.optInt("chin");
                this.gxz = jSONObject.getInt("nose");
                this.gxA = jSONObject.optInt("v_face");
                this.gxB = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
