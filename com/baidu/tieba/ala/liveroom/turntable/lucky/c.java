package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public long currentTime;
    public int gfp;
    public long gfq;
    public a gfr;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gfp = jSONObject.optInt("is_lucky_moment");
            this.currentTime = jSONObject.optLong("current_time");
            this.gfq = jSONObject.optLong("expired_time");
            this.gfr = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public String gfs;
        public String giftName;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.gfs = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
