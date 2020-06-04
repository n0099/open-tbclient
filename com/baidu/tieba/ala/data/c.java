package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public long KI;
    public String fsA;
    public long fsB;
    public long fsC;
    public String fss;
    public int fst;
    public int fsu;
    public String fsv;
    public int fsw;
    public int fsx;
    public String fsy;
    public String fsz;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.fss = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.fst = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.fsv = jSONObject.optString("gift_url");
        this.fsu = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.fsw = jSONObject.optInt("process_num");
        this.fsx = jSONObject.optInt("finish_num");
        this.fsy = jSONObject.optString("toplist_1");
        this.fsz = jSONObject.optString("toplist_2");
        this.fsA = jSONObject.optString("toplist_3");
        this.KI = jSONObject.optLong("expire_time");
        this.fsB = jSONObject.optLong("expire_seconds");
        this.fsC = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
