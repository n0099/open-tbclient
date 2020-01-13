package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public String evi;
    public int evj;
    public int evk;
    public String evl;
    public int evm;
    public int evn;
    public String evo;
    public String evp;
    public String evq;
    public long evr;
    public long evs;
    public String mDesc;
    public String mGiftName;
    public int mStatus;
    public long rs;

    public void parserJson(JSONObject jSONObject) {
        this.evi = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.evj = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.evl = jSONObject.optString("gift_url");
        this.evk = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        this.evm = jSONObject.optInt("process_num");
        this.evn = jSONObject.optInt("finish_num");
        this.evo = jSONObject.optString("toplist_1");
        this.evp = jSONObject.optString("toplist_2");
        this.evq = jSONObject.optString("toplist_3");
        this.rs = jSONObject.optLong("expire_time");
        this.evr = jSONObject.optLong("expire_seconds");
        this.evs = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
