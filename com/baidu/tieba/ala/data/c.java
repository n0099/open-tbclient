package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    public String etX;
    public int etY;
    public int etZ;
    public String eua;
    public int eub;
    public int euc;
    public String eud;
    public String eue;
    public String euf;
    public long eug;
    public long euh;
    public String mDesc;
    public String mGiftName;
    public int mStatus;
    public long rs;

    public void parserJson(JSONObject jSONObject) {
        this.etX = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.etY = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.eua = jSONObject.optString("gift_url");
        this.etZ = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        this.eub = jSONObject.optInt("process_num");
        this.euc = jSONObject.optInt("finish_num");
        this.eud = jSONObject.optString("toplist_1");
        this.eue = jSONObject.optString("toplist_2");
        this.euf = jSONObject.optString("toplist_3");
        this.rs = jSONObject.optLong("expire_time");
        this.eug = jSONObject.optLong("expire_seconds");
        this.euh = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
