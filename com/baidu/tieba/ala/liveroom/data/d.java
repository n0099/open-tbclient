package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import com.baidu.live.ar.j;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends j {
    public int haS;
    public int haT;
    public String mFilterName = "delta";
    public int haL = 80;
    public int haM = 50;
    public int haN = 80;
    public int haO = 80;
    public int haP = 80;
    public int haQ = 25;
    public int haR = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.haL);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.haN);
            jSONObject.put("red_level", this.haM);
            jSONObject.put("big_eye", this.haO);
            jSONObject.put("thin_face", this.haP);
            jSONObject.put("chin", this.haQ);
            jSONObject.put("nose", this.haR);
            jSONObject.put("v_face", this.haS);
            jSONObject.put("face_three_counts", this.haT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d HG(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.haL = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.haN = jSONObject.optInt("blur_level");
                this.haO = jSONObject.optInt("big_eye");
                this.haP = jSONObject.optInt("thin_face");
                this.haM = jSONObject.getInt("red_level");
                this.haQ = jSONObject.optInt("chin");
                this.haR = jSONObject.getInt("nose");
                this.haS = jSONObject.optInt("v_face");
                this.haT = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
