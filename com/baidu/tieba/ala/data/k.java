package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class k {
    private String aVD;
    private long aXC;
    private String aXE;
    private String aXI;
    private int aXJ;
    private String gTc;
    private int giftId;
    private String giftName;
    private String portrait;

    public k(JSONObject jSONObject) {
        this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.aVD = jSONObject.optString("gift_tag");
        this.aXI = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aXJ = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aXC = jSONObject.optLong("pay_userid");
        this.aXE = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
        this.gTc = jSONObject.optString("ext_info");
    }

    public int getGiftId() {
        return this.giftId;
    }

    public String bUu() {
        return this.aXI;
    }

    public int getStatus() {
        return this.aXJ;
    }

    public long bUv() {
        return this.aXC;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String bUw() {
        return this.gTc;
    }
}
