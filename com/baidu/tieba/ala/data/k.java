package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class k {
    private String aSy;
    private String aUD;
    private int aUE;
    private long aUx;
    private String aUz;
    private String gQe;
    private int giftId;
    private String giftName;
    private String portrait;

    public k(JSONObject jSONObject) {
        this.giftId = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.aSy = jSONObject.optString("gift_tag");
        this.aUD = jSONObject.optString("thumbnail_url");
        this.giftName = jSONObject.optString("gift_name");
        this.aUE = jSONObject.optInt(LogConfig.VALUE_IM_GIFT);
        this.aUx = jSONObject.optLong("pay_userid");
        this.aUz = jSONObject.optString("pay_username");
        this.portrait = jSONObject.optString("bd_portrait");
        this.gQe = jSONObject.optString("ext_info");
    }

    public int getGiftId() {
        return this.giftId;
    }

    public String bTI() {
        return this.aUD;
    }

    public int getStatus() {
        return this.aUE;
    }

    public long bTJ() {
        return this.aUx;
    }

    public String getPortrait() {
        return this.portrait;
    }

    public String bTK() {
        return this.gQe;
    }
}
