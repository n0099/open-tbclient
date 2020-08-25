package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public long currentTime;
    public int gJT;
    public long gJU;
    public a gJV;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gJT = jSONObject.optInt("is_lucky_moment");
            this.currentTime = jSONObject.optLong("current_time");
            this.gJU = jSONObject.optLong("expired_time");
            this.gJV = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes7.dex */
    public class a {
        public String gJW;
        public String giftName;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.gJW = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
