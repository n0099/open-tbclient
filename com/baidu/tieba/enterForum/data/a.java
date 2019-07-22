package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String bDN;
    public int eVT;
    public int eVU;
    public String picUrl;

    public void bq(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.bDN = jSONObject.optString("url");
            this.eVT = jSONObject.optInt("server_time");
            this.eVU = jSONObject.optInt("adid");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.picUrl);
    }
}
