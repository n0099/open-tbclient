package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d {
    public long MN;
    public String gUk;
    public int gUl;
    public int gUm;
    public String gUn;
    public int gUo;
    public int gUp;
    public String gUq;
    public String gUr;
    public String gUs;
    public long gUt;
    public long gUu;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.gUk = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.gUl = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.gUn = jSONObject.optString("gift_url");
        this.gUm = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.gUo = jSONObject.optInt("process_num");
        this.gUp = jSONObject.optInt("finish_num");
        this.gUq = jSONObject.optString("toplist_1");
        this.gUr = jSONObject.optString("toplist_2");
        this.gUs = jSONObject.optString("toplist_3");
        this.MN = jSONObject.optLong("expire_time");
        this.gUt = jSONObject.optLong("expire_seconds");
        this.gUu = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
