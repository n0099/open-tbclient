package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public long Kw;
    public String feC;
    public int feD;
    public int feE;
    public String feF;
    public int feG;
    public int feH;
    public String feI;
    public String feJ;
    public String feK;
    public long feL;
    public long feM;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.feC = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.feD = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.feF = jSONObject.optString("gift_url");
        this.feE = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.feG = jSONObject.optInt("process_num");
        this.feH = jSONObject.optInt("finish_num");
        this.feI = jSONObject.optString("toplist_1");
        this.feJ = jSONObject.optString("toplist_2");
        this.feK = jSONObject.optString("toplist_3");
        this.Kw = jSONObject.optLong("expire_time");
        this.feL = jSONObject.optLong("expire_seconds");
        this.feM = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
