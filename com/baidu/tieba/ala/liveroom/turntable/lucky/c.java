package com.baidu.tieba.ala.liveroom.turntable.lucky;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    public long OO;
    public int eoG;
    public long eoH;
    public a eoI;

    public c(JSONObject jSONObject) {
        parseJson(jSONObject);
    }

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.eoG = jSONObject.optInt("is_lucky_moment");
            this.OO = jSONObject.optLong("current_time");
            this.eoH = jSONObject.optLong("expired_time");
            this.eoI = new a(jSONObject.optJSONObject("lucky_gift_info"));
        }
    }

    /* loaded from: classes6.dex */
    public class a {
        public String eoJ;
        public String giftName;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.giftName = jSONObject.optString("gift_name");
                this.eoJ = jSONObject.optString("pro_up_ratio");
            }
        }
    }
}
