package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public long Nn;
    public int gIA;
    public int gIB;
    public String gIC;
    public String gID;
    public String gIE;
    public long gIF;
    public long gIG;
    public String gIw;
    public int gIx;
    public int gIy;
    public String gIz;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.gIw = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.gIx = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.gIz = jSONObject.optString("gift_url");
        this.gIy = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.gIA = jSONObject.optInt("process_num");
        this.gIB = jSONObject.optInt("finish_num");
        this.gIC = jSONObject.optString("toplist_1");
        this.gID = jSONObject.optString("toplist_2");
        this.gIE = jSONObject.optString("toplist_3");
        this.Nn = jSONObject.optLong("expire_time");
        this.gIF = jSONObject.optLong("expire_seconds");
        this.gIG = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
