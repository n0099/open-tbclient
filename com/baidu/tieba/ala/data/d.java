package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public long Ms;
    public String gzA;
    public int gzB;
    public int gzC;
    public String gzD;
    public int gzE;
    public int gzF;
    public String gzG;
    public String gzH;
    public String gzI;
    public long gzJ;
    public long gzK;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.gzA = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.gzB = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.gzD = jSONObject.optString("gift_url");
        this.gzC = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.gzE = jSONObject.optInt("process_num");
        this.gzF = jSONObject.optInt("finish_num");
        this.gzG = jSONObject.optString("toplist_1");
        this.gzH = jSONObject.optString("toplist_2");
        this.gzI = jSONObject.optString("toplist_3");
        this.Ms = jSONObject.optLong("expire_time");
        this.gzJ = jSONObject.optLong("expire_seconds");
        this.gzK = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
