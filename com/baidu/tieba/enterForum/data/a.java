package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String bCP;
    public int eQT;
    public int eQU;
    public String picUrl;

    public void bq(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.bCP = jSONObject.optString("url");
            this.eQT = jSONObject.optInt("server_time");
            this.eQU = jSONObject.optInt("adid");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.picUrl);
    }
}
