package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public long currentTime;
    public int fij;
    public long fik;
    public a fil;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.fij = jSONObject.optInt("is_lucky_moment");
            this.currentTime = jSONObject.optLong("current_time");
            this.fik = jSONObject.optLong("expired_time");
            this.fil = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public String fim;
        public String giftName;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.fim = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
