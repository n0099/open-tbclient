package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public long MH;
    public String gSB;
    public int gSC;
    public int gSD;
    public String gSE;
    public int gSF;
    public int gSG;
    public String gSH;
    public String gSI;
    public String gSJ;
    public long gSK;
    public long gSL;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.gSB = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.gSC = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.gSE = jSONObject.optString("gift_url");
        this.gSD = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.gSF = jSONObject.optInt("process_num");
        this.gSG = jSONObject.optInt("finish_num");
        this.gSH = jSONObject.optString("toplist_1");
        this.gSI = jSONObject.optString("toplist_2");
        this.gSJ = jSONObject.optString("toplist_3");
        this.MH = jSONObject.optLong("expire_time");
        this.gSK = jSONObject.optLong("expire_seconds");
        this.gSL = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
