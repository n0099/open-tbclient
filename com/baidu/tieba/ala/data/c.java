package com.baidu.tieba.ala.data;

import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public String ezH;
    public int ezI;
    public int ezJ;
    public String ezK;
    public int ezL;
    public int ezM;
    public String ezN;
    public String ezO;
    public String ezP;
    public long ezQ;
    public long ezR;
    public String mDesc;
    public String mGiftName;
    public int mStatus;
    public long rt;

    public void parserJson(JSONObject jSONObject) {
        this.ezH = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.ezI = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.ezK = jSONObject.optString("gift_url");
        this.ezJ = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        this.ezL = jSONObject.optInt("process_num");
        this.ezM = jSONObject.optInt("finish_num");
        this.ezN = jSONObject.optString("toplist_1");
        this.ezO = jSONObject.optString("toplist_2");
        this.ezP = jSONObject.optString("toplist_3");
        this.rt = jSONObject.optLong("expire_time");
        this.ezQ = jSONObject.optLong("expire_seconds");
        this.ezR = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
