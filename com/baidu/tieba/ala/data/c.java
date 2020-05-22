package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public long KI;
    public String fsh;
    public int fsi;
    public int fsj;
    public String fsk;
    public int fsl;
    public int fsm;
    public String fsn;
    public String fso;
    public String fsp;
    public long fsq;
    public long fsr;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.fsh = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.fsi = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.fsk = jSONObject.optString("gift_url");
        this.fsj = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.fsl = jSONObject.optInt("process_num");
        this.fsm = jSONObject.optInt("finish_num");
        this.fsn = jSONObject.optString("toplist_1");
        this.fso = jSONObject.optString("toplist_2");
        this.fsp = jSONObject.optString("toplist_3");
        this.KI = jSONObject.optLong("expire_time");
        this.fsq = jSONObject.optLong("expire_seconds");
        this.fsr = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
