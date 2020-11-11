package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k {
    private String aUo;
    private long aWj;
    private String aWl;
    private String aWp;
    private int aWq;
    private int giftId;
    private String giftName;
    private String portrait;

    public k(JSONObject jSONObject) {
        this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.aUo = jSONObject.optString("gift_tag");
        this.aWp = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aWq = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aWj = jSONObject.optLong("pay_userid");
        this.aWl = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
    }

    public int getGiftId() {
        return this.giftId;
    }

    public String bRR() {
        return this.aWp;
    }

    public int getStatus() {
        return this.aWq;
    }

    public long bRS() {
        return this.aWj;
    }

    public String getPortrait() {
        return this.portrait;
    }
}
