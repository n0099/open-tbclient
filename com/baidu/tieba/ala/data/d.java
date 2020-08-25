package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    public long LO;
    public String fUp;
    public int fUq;
    public int fUr;
    public String fUs;
    public int fUt;
    public int fUu;
    public String fUv;
    public String fUw;
    public String fUx;
    public long fUy;
    public long fUz;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.fUp = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.fUq = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.fUs = jSONObject.optString("gift_url");
        this.fUr = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.fUt = jSONObject.optInt("process_num");
        this.fUu = jSONObject.optInt("finish_num");
        this.fUv = jSONObject.optString("toplist_1");
        this.fUw = jSONObject.optString("toplist_2");
        this.fUx = jSONObject.optString("toplist_3");
        this.LO = jSONObject.optLong("expire_time");
        this.fUy = jSONObject.optLong("expire_seconds");
        this.fUz = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
