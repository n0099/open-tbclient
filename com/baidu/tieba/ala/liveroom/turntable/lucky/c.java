package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c {
    public long aJA;
    public long expiredTime;
    public int hQW;
    public a hQX;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hQW = jSONObject.optInt("is_lucky_moment");
            this.aJA = jSONObject.optLong("current_time");
            this.expiredTime = jSONObject.optLong("expired_time");
            this.hQX = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes10.dex */
    public class a {
        public String giftName;
        public String hQY;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.hQY = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
