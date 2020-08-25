package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import com.baidu.live.ar.i;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends i {
    public int gxw;
    public int gxx;
    public String mFilterName = "delta";
    public int gxp = 80;
    public int gxq = 50;
    public int gxr = 80;
    public int gxs = 80;
    public int gxt = 80;
    public int gxu = 25;
    public int gxv = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.gxp);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.gxr);
            jSONObject.put("red_level", this.gxq);
            jSONObject.put("big_eye", this.gxs);
            jSONObject.put("thin_face", this.gxt);
            jSONObject.put("chin", this.gxu);
            jSONObject.put("nose", this.gxv);
            jSONObject.put("v_face", this.gxw);
            jSONObject.put("face_three_counts", this.gxx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d FW(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.gxp = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.gxr = jSONObject.optInt("blur_level");
                this.gxs = jSONObject.optInt("big_eye");
                this.gxt = jSONObject.optInt("thin_face");
                this.gxq = jSONObject.getInt("red_level");
                this.gxu = jSONObject.optInt("chin");
                this.gxv = jSONObject.getInt("nose");
                this.gxw = jSONObject.optInt("v_face");
                this.gxx = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
