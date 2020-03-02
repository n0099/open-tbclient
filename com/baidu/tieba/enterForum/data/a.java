package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public String cLR;
    public int fTP;
    public int fTQ;
    public String fTR;
    public String fTS;
    public String picUrl;

    public void cG(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.cLR = jSONObject.optString("url");
            this.fTP = jSONObject.optInt("server_time");
            this.fTQ = jSONObject.optInt("adid");
            this.fTR = jSONObject.optString("big_pic");
            this.fTS = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.fTR);
    }
}
