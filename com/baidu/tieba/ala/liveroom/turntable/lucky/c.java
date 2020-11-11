package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public long currentTime;
    public int htY;
    public long htZ;
    public a hua;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.htY = jSONObject.optInt("is_lucky_moment");
            this.currentTime = jSONObject.optLong("current_time");
            this.htZ = jSONObject.optLong("expired_time");
            this.hua = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public String giftName;
        public String hub;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.hub = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
