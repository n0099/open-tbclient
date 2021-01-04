package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class k {
    private String aXl;
    private long aZk;
    private String aZm;
    private String aZq;
    private int aZr;
    private String gUK;
    private int giftId;
    private String giftName;
    private String portrait;

    public k(JSONObject jSONObject) {
        this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.aXl = jSONObject.optString("gift_tag");
        this.aZq = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aZr = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aZk = jSONObject.optLong("pay_userid");
        this.aZm = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
        this.gUK = jSONObject.optString("ext_info");
    }

    public int getGiftId() {
        return this.giftId;
    }

    public String bXz() {
        return this.aZq;
    }

    public int getStatus() {
        return this.aZr;
    }

    public long bXA() {
        return this.aZk;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String bXB() {
        return this.gUK;
    }
}
