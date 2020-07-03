package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public long Li;
    public String fDD;
    public int fDE;
    public int fDF;
    public String fDG;
    public int fDH;
    public int fDI;
    public String fDJ;
    public String fDK;
    public String fDL;
    public long fDM;
    public long fDN;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.fDD = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.fDE = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.fDG = jSONObject.optString("gift_url");
        this.fDF = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.fDH = jSONObject.optInt("process_num");
        this.fDI = jSONObject.optInt("finish_num");
        this.fDJ = jSONObject.optString("toplist_1");
        this.fDK = jSONObject.optString("toplist_2");
        this.fDL = jSONObject.optString("toplist_3");
        this.Li = jSONObject.optLong("expire_time");
        this.fDM = jSONObject.optLong("expire_seconds");
        this.fDN = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
