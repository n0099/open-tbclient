package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String bEl;
    public int eXH;
    public int eXI;
    public String eXJ;
    public String eXK;
    public String picUrl;

    public void bq(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.bEl = jSONObject.optString("url");
            this.eXH = jSONObject.optInt("server_time");
            this.eXI = jSONObject.optInt("adid");
            this.eXJ = jSONObject.optString("big_pic");
            this.eXK = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.eXJ);
    }
}
