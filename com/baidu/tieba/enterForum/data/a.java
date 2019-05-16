package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String bCP;
    public int eQS;
    public int eQT;
    public String picUrl;

    public void bq(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.bCP = jSONObject.optString("url");
            this.eQS = jSONObject.optInt("server_time");
            this.eQT = jSONObject.optInt("adid");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.picUrl);
    }
}
