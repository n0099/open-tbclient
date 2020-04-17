package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public long Kt;
    public String feA;
    public int feB;
    public int feC;
    public String feD;
    public String feE;
    public String feF;
    public long feG;
    public long feH;
    public String fex;
    public int fey;
    public int fez;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.fex = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.fey = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.feA = jSONObject.optString("gift_url");
        this.fez = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.feB = jSONObject.optInt("process_num");
        this.feC = jSONObject.optInt("finish_num");
        this.feD = jSONObject.optString("toplist_1");
        this.feE = jSONObject.optString("toplist_2");
        this.feF = jSONObject.optString("toplist_3");
        this.Kt = jSONObject.optLong("expire_time");
        this.feG = jSONObject.optLong("expire_seconds");
        this.feH = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
