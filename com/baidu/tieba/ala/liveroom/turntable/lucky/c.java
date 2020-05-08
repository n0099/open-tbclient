package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public long currentTime;
    public int fQE;
    public long fQF;
    public a fQG;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fQE = jSONObject.optInt("is_lucky_moment");
            this.currentTime = jSONObject.optLong("current_time");
            this.fQF = jSONObject.optLong("expired_time");
            this.fQG = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public String fQH;
        public String giftName;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.fQH = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
