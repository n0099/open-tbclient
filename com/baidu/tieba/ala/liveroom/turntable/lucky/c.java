package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public long VM;
    public int ffa;
    public long ffb;
    public a ffc;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ffa = jSONObject.optInt("is_lucky_moment");
            this.VM = jSONObject.optLong("current_time");
            this.ffb = jSONObject.optLong("expired_time");
            this.ffc = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public String ffd;
        public String giftName;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.ffd = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
