package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public long currentTime;
    public int flo;
    public long flp;
    public a flq;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.flo = jSONObject.optInt("is_lucky_moment");
            this.currentTime = jSONObject.optLong("current_time");
            this.flp = jSONObject.optLong("expired_time");
            this.flq = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public String flr;
        public String giftName;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.flr = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
