package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public long Nn;
    public int gIA;
    public String gIB;
    public int gIC;
    public int gID;
    public String gIE;
    public String gIF;
    public String gIG;
    public long gIH;
    public long gII;
    public String gIy;
    public int gIz;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.gIy = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.gIz = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.gIB = jSONObject.optString("gift_url");
        this.gIA = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.gIC = jSONObject.optInt("process_num");
        this.gID = jSONObject.optInt("finish_num");
        this.gIE = jSONObject.optString("toplist_1");
        this.gIF = jSONObject.optString("toplist_2");
        this.gIG = jSONObject.optString("toplist_3");
        this.Nn = jSONObject.optLong("expire_time");
        this.gIH = jSONObject.optLong("expire_seconds");
        this.gII = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
