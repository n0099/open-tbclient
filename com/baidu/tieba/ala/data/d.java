package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public long Li;
    public String fIY;
    public int fIZ;
    public int fJa;
    public String fJb;
    public int fJc;
    public int fJd;
    public String fJe;
    public String fJf;
    public String fJg;
    public long fJh;
    public long fJi;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.fIY = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.fIZ = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.fJb = jSONObject.optString("gift_url");
        this.fJa = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.fJc = jSONObject.optInt("process_num");
        this.fJd = jSONObject.optInt("finish_num");
        this.fJe = jSONObject.optString("toplist_1");
        this.fJf = jSONObject.optString("toplist_2");
        this.fJg = jSONObject.optString("toplist_3");
        this.Li = jSONObject.optLong("expire_time");
        this.fJh = jSONObject.optLong("expire_seconds");
        this.fJi = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
