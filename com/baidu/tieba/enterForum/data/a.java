package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String bDN;
    public int eWb;
    public int eWc;
    public String eWd;
    public String eWe;
    public String picUrl;

    public void bq(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.bDN = jSONObject.optString("url");
            this.eWb = jSONObject.optInt("server_time");
            this.eWc = jSONObject.optInt("adid");
            this.eWd = jSONObject.optString("big_pic");
            this.eWe = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.eWd);
    }
}
