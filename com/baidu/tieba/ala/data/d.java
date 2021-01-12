package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d {
    public long MJ;
    public String gPE;
    public int gPF;
    public int gPG;
    public String gPH;
    public int gPI;
    public int gPJ;
    public String gPK;
    public String gPL;
    public String gPM;
    public long gPN;
    public long gPO;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.gPE = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.gPF = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.gPH = jSONObject.optString("gift_url");
        this.gPG = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.gPI = jSONObject.optInt("process_num");
        this.gPJ = jSONObject.optInt("finish_num");
        this.gPK = jSONObject.optString("toplist_1");
        this.gPL = jSONObject.optString("toplist_2");
        this.gPM = jSONObject.optString("toplist_3");
        this.MJ = jSONObject.optLong("expire_time");
        this.gPN = jSONObject.optLong("expire_seconds");
        this.gPO = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
