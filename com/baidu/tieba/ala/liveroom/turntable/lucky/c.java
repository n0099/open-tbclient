package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public long currentTime;
    public long fQA;
    public a fQB;
    public int fQz;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fQz = jSONObject.optInt("is_lucky_moment");
            this.currentTime = jSONObject.optLong("current_time");
            this.fQA = jSONObject.optLong("expired_time");
            this.fQB = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public String fQC;
        public String giftName;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.fQC = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
