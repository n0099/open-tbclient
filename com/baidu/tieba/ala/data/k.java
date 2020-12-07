package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k {
    private String aVF;
    private long aXF;
    private String aXH;
    private String aXL;
    private int aXM;
    private int giftId;
    private String giftName;
    private String portrait;

    public k(JSONObject jSONObject) {
        this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.aVF = jSONObject.optString("gift_tag");
        this.aXL = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aXM = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aXF = jSONObject.optLong("pay_userid");
        this.aXH = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
    }

    public int getGiftId() {
        return this.giftId;
    }

    public String bUU() {
        return this.aXL;
    }

    public int getStatus() {
        return this.aXM;
    }

    public long bUV() {
        return this.aXF;
    }

    public String getPortrait() {
        return this.portrait;
    }
}
