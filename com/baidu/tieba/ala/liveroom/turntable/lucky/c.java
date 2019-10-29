package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public long Pp;
    public int epx;
    public long epy;
    public a epz;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.epx = jSONObject.optInt("is_lucky_moment");
            this.Pp = jSONObject.optLong("current_time");
            this.epy = jSONObject.optLong("expired_time");
            this.epz = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes6.dex */
    public class a {
        public String epA;
        public String giftName;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.epA = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
