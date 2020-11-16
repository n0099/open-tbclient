package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k {
    private String aSD;
    private String aUA;
    private String aUE;
    private int aUF;
    private long aUy;
    private int giftId;
    private String giftName;
    private String portrait;

    public k(JSONObject jSONObject) {
        this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.aSD = jSONObject.optString("gift_tag");
        this.aUE = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aUF = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aUy = jSONObject.optLong("pay_userid");
        this.aUA = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
    }

    public int getGiftId() {
        return this.giftId;
    }

    public String bRk() {
        return this.aUE;
    }

    public int getStatus() {
        return this.aUF;
    }

    public long bRl() {
        return this.aUy;
    }

    public String getPortrait() {
        return this.portrait;
    }
}
