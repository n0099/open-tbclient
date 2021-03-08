package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class k {
    private String aXd;
    private long aZc;
    private String aZe;
    private String aZi;
    private int aZj;
    private String gUL;
    private int giftId;
    private String giftName;
    private String portrait;

    public k(JSONObject jSONObject) {
        this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.aXd = jSONObject.optString("gift_tag");
        this.aZi = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aZj = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aZc = jSONObject.optLong("pay_userid");
        this.aZe = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
        this.gUL = jSONObject.optString("ext_info");
    }

    public int getGiftId() {
        return this.giftId;
    }

    public String bUA() {
        return this.aZi;
    }

    public int getStatus() {
        return this.aZj;
    }

    public long bUB() {
        return this.aZc;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String bUC() {
        return this.gUL;
    }
}
