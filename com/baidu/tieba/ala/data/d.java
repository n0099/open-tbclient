package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public long Mb;
    public String fXI;
    public int fXJ;
    public int fXK;
    public String fXL;
    public int fXM;
    public int fXN;
    public String fXO;
    public String fXP;
    public String fXQ;
    public long fXR;
    public long fXS;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.fXI = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.fXJ = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.fXL = jSONObject.optString("gift_url");
        this.fXK = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.fXM = jSONObject.optInt("process_num");
        this.fXN = jSONObject.optInt("finish_num");
        this.fXO = jSONObject.optString("toplist_1");
        this.fXP = jSONObject.optString("toplist_2");
        this.fXQ = jSONObject.optString("toplist_3");
        this.Mb = jSONObject.optLong("expire_time");
        this.fXR = jSONObject.optLong("expire_seconds");
        this.fXS = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
