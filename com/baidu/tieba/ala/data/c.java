package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public String ezA;
    public String ezB;
    public long ezC;
    public long ezD;
    public String ezt;
    public int ezu;
    public int ezv;
    public String ezw;
    public int ezx;
    public int ezy;
    public String ezz;
    public String mDesc;
    public String mGiftName;
    public int mStatus;
    public long rt;

    public void parserJson(JSONObject jSONObject) {
        this.ezt = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.ezu = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.ezw = jSONObject.optString("gift_url");
        this.ezv = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        this.ezx = jSONObject.optInt("process_num");
        this.ezy = jSONObject.optInt("finish_num");
        this.ezz = jSONObject.optString("toplist_1");
        this.ezA = jSONObject.optString("toplist_2");
        this.ezB = jSONObject.optString("toplist_3");
        this.rt = jSONObject.optLong("expire_time");
        this.ezC = jSONObject.optLong("expire_seconds");
        this.ezD = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
