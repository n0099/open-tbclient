package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d {
    public long LO;
    public String fUA;
    public String fUB;
    public long fUC;
    public long fUD;
    public String fUt;
    public int fUu;
    public int fUv;
    public String fUw;
    public int fUx;
    public int fUy;
    public String fUz;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.fUt = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.fUu = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.fUw = jSONObject.optString("gift_url");
        this.fUv = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.fUx = jSONObject.optInt("process_num");
        this.fUy = jSONObject.optInt("finish_num");
        this.fUz = jSONObject.optString("toplist_1");
        this.fUA = jSONObject.optString("toplist_2");
        this.fUB = jSONObject.optString("toplist_3");
        this.LO = jSONObject.optLong("expire_time");
        this.fUC = jSONObject.optLong("expire_seconds");
        this.fUD = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
