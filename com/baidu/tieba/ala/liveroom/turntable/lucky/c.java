package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c {
    public long aKr;
    public long expiredTime;
    public int hPl;
    public a hPm;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hPl = jSONObject.optInt("is_lucky_moment");
            this.aKr = jSONObject.optLong("current_time");
            this.expiredTime = jSONObject.optLong("expired_time");
            this.hPm = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes11.dex */
    public class a {
        public String giftName;
        public String hPn;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.hPn = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
