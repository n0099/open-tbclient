package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public long Ms;
    public String gAa;
    public String gAb;
    public long gAc;
    public long gAd;
    public String gzT;
    public int gzU;
    public int gzV;
    public String gzW;
    public int gzX;
    public int gzY;
    public String gzZ;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.gzT = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.gzU = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.gzW = jSONObject.optString("gift_url");
        this.gzV = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.gzX = jSONObject.optInt("process_num");
        this.gzY = jSONObject.optInt("finish_num");
        this.gzZ = jSONObject.optString("toplist_1");
        this.gAa = jSONObject.optString("toplist_2");
        this.gAb = jSONObject.optString("toplist_3");
        this.Ms = jSONObject.optLong("expire_time");
        this.gAc = jSONObject.optLong("expire_seconds");
        this.gAd = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
