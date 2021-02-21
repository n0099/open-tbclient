package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public String aHq;
    public int iHD;
    public int iHE;
    public String iHF;
    public String iHG;
    public String picUrl;

    public void eh(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.aHq = jSONObject.optString("url");
            this.iHD = jSONObject.optInt("server_time");
            this.iHE = jSONObject.optInt("adid");
            this.iHF = jSONObject.optString("big_pic");
            this.iHG = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.iHF);
    }
}
