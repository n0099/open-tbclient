package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public long MH;
    public String gSn;
    public int gSo;
    public int gSp;
    public String gSq;
    public int gSr;
    public int gSs;
    public String gSt;
    public String gSu;
    public String gSv;
    public long gSw;
    public long gSx;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.gSn = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.gSo = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.gSq = jSONObject.optString("gift_url");
        this.gSp = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.gSr = jSONObject.optInt("process_num");
        this.gSs = jSONObject.optInt("finish_num");
        this.gSt = jSONObject.optString("toplist_1");
        this.gSu = jSONObject.optString("toplist_2");
        this.gSv = jSONObject.optString("toplist_3");
        this.MH = jSONObject.optLong("expire_time");
        this.gSw = jSONObject.optLong("expire_seconds");
        this.gSx = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
