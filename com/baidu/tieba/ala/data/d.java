package com.baidu.tieba.ala.data;

import android.text.TextUtils;
import com.baidu.live.tbadk.log.LogConfig;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {
    public long Ms;
    public String guf;
    public int gug;
    public int guh;
    public String gui;
    public int guj;
    public int guk;
    public String gul;
    public String gum;
    public String gun;
    public long guo;
    public long gup;
    public String mDesc;
    public String mGiftName;
    public int mStatus;

    public void parserJson(JSONObject jSONObject) {
        this.guf = jSONObject.optString("wish_id");
        this.mGiftName = jSONObject.optString("gift_name");
        this.gug = jSONObject.optInt(LogConfig.LOG_GIFT_ID);
        this.gui = jSONObject.optString("gift_url");
        this.guh = jSONObject.optInt("gift_type");
        this.mDesc = jSONObject.optString("desc");
        if (TextUtils.equals("null", this.mDesc)) {
            this.mDesc = "";
        }
        this.guj = jSONObject.optInt("process_num");
        this.guk = jSONObject.optInt("finish_num");
        this.gul = jSONObject.optString("toplist_1");
        this.gum = jSONObject.optString("toplist_2");
        this.gun = jSONObject.optString("toplist_3");
        this.Ms = jSONObject.optLong("expire_time");
        this.guo = jSONObject.optLong("expire_seconds");
        this.gup = jSONObject.optLong("expire_hour");
        this.mStatus = jSONObject.optInt("status");
    }
}
