package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class k {
    private String aSV;
    private long aUR;
    private String aUT;
    private String aUX;
    private int aUY;
    private int giftId;
    private String giftName;
    private String portrait;

    public k(JSONObject jSONObject) {
        this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.aSV = jSONObject.optString("gift_tag");
        this.aUX = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aUY = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aUR = jSONObject.optLong("pay_userid");
        this.aUT = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
    }

    public int getGiftId() {
        return this.giftId;
    }

    public String bPr() {
        return this.aUX;
    }

    public int getStatus() {
        return this.aUY;
    }

    public long bPs() {
        return this.aUR;
    }

    public String getPortrait() {
        return this.portrait;
    }
}
