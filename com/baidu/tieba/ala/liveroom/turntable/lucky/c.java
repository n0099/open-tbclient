package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    public long aJS;
    public int hDi;
    public long hDj;
    public a hDk;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hDi = jSONObject.optInt("is_lucky_moment");
            this.aJS = jSONObject.optLong("current_time");
            this.hDj = jSONObject.optLong("expired_time");
            this.hDk = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes4.dex */
    public class a {
        public String giftName;
        public String hDl;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.hDl = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
