package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public long Mr;
    public String gkb;
    public int gkc;
    public int gkd;
    public String gke;
    public int gkf;
    public int gkg;
    public String gkh;
    public String gki;
    public String gkj;
    public long gkk;
    public long gkl;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.gkb = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.gkc = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.gke = jSONObject.optString("gift_url");
        this.gkd = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.gkf = jSONObject.optInt("process_num");
        this.gkg = jSONObject.optInt("finish_num");
        this.gkh = jSONObject.optString("toplist_1");
        this.gki = jSONObject.optString("toplist_2");
        this.gkj = jSONObject.optString("toplist_3");
        this.Mr = jSONObject.optLong("expire_time");
        this.gkk = jSONObject.optLong("expire_seconds");
        this.gkl = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
