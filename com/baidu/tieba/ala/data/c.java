package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public String eAd;
    public int eAe;
    public int eAf;
    public String eAg;
    public int eAh;
    public int eAi;
    public String eAj;
    public String eAk;
    public String eAl;
    public long eAm;
    public long eAn;
    public String mDesc;
    public String mGiftName;
    public int mStatus;
    public long rt;

    public void parserJson(JSONObject jSONObject) {
        this.eAd = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.eAe = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.eAg = jSONObject.optString("gift_url");
        this.eAf = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        this.eAh = jSONObject.optInt("process_num");
        this.eAi = jSONObject.optInt("finish_num");
        this.eAj = jSONObject.optString("toplist_1");
        this.eAk = jSONObject.optString("toplist_2");
        this.eAl = jSONObject.optString("toplist_3");
        this.rt = jSONObject.optLong("expire_time");
        this.eAm = jSONObject.optLong("expire_seconds");
        this.eAn = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
