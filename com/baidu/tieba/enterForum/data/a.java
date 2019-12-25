package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    public String cHB;
    public int fOj;
    public int fOk;
    public String fOl;
    public String fOm;
    public String picUrl;

    public void cG(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.cHB = jSONObject.optString("url");
            this.fOj = jSONObject.optInt("server_time");
            this.fOk = jSONObject.optInt("adid");
            this.fOl = jSONObject.optString("big_pic");
            this.fOm = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.fOl);
    }
}
