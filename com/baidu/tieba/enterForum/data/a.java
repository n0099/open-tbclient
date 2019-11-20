package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String bVl;
    public int eZC;
    public int eZD;
    public String eZE;
    public String eZF;
    public String picUrl;

    public void bQ(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.bVl = jSONObject.optString("url");
            this.eZC = jSONObject.optInt("server_time");
            this.eZD = jSONObject.optInt("adid");
            this.eZE = jSONObject.optString("big_pic");
            this.eZF = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.eZE);
    }
}
