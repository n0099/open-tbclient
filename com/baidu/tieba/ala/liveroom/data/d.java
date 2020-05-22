package com.baidu.tieba.ala.liveroom.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.baidu.live.ar.g {
    public int fTt;
    public int fTu;
    public String mFilterName = "delta";
    public int fTm = 80;
    public int fTn = 50;
    public int fTo = 80;
    public int fTp = 80;
    public int fTq = 80;
    public int fTr = 25;
    public int fTs = 21;

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("white_percent", this.fTm);
            jSONObject.put("filter_name", this.mFilterName);
            jSONObject.put("blur_level", this.fTo);
            jSONObject.put("red_level", this.fTn);
            jSONObject.put("big_eye", this.fTp);
            jSONObject.put("thin_face", this.fTq);
            jSONObject.put("chin", this.fTr);
            jSONObject.put("nose", this.fTs);
            jSONObject.put("v_face", this.fTt);
            jSONObject.put("face_three_counts", this.fTu);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public d Cp(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.fTm = jSONObject.optInt("white_percent");
                this.mFilterName = jSONObject.optString("filter_name");
                this.fTo = jSONObject.optInt("blur_level");
                this.fTp = jSONObject.optInt("big_eye");
                this.fTq = jSONObject.optInt("thin_face");
                this.fTn = jSONObject.getInt("red_level");
                this.fTr = jSONObject.optInt("chin");
                this.fTs = jSONObject.getInt("nose");
                this.fTt = jSONObject.optInt("v_face");
                this.fTu = jSONObject.getInt("face_three_counts");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
