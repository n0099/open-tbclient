package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public long currentTime;
    public int gfA;
    public long gfB;
    public a gfC;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.gfA = jSONObject.optInt("is_lucky_moment");
            this.currentTime = jSONObject.optLong("current_time");
            this.gfB = jSONObject.optLong("expired_time");
            this.gfC = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes3.dex */
    public class a {
        public String gfD;
        public String giftName;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.gfD = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
