package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public String ezA;
    public String ezB;
    public String ezC;
    public long ezD;
    public long ezE;
    public String ezu;
    public int ezv;
    public int ezw;
    public String ezx;
    public int ezy;
    public int ezz;
    public String mDesc;
    public String mGiftName;
    public int mStatus;
    public long rt;

    public void parserJson(JSONObject jSONObject) {
        this.ezu = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.ezv = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.ezx = jSONObject.optString("gift_url");
        this.ezw = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        this.ezy = jSONObject.optInt("process_num");
        this.ezz = jSONObject.optInt("finish_num");
        this.ezA = jSONObject.optString("toplist_1");
        this.ezB = jSONObject.optString("toplist_2");
        this.ezC = jSONObject.optString("toplist_3");
        this.rt = jSONObject.optLong("expire_time");
        this.ezD = jSONObject.optLong("expire_seconds");
        this.ezE = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
