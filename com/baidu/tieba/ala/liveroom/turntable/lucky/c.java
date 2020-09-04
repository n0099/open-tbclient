package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c {
    public long currentTime;
    public int gJX;
    public long gJY;
    public a gJZ;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gJX = jSONObject.optInt("is_lucky_moment");
            this.currentTime = jSONObject.optLong("current_time");
            this.gJY = jSONObject.optLong("expired_time");
            this.gJZ = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes7.dex */
    public class a {
        public String gKa;
        public String giftName;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.gKa = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
