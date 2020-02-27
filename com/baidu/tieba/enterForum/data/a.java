package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public String cLQ;
    public int fTN;
    public int fTO;
    public String fTP;
    public String fTQ;
    public String picUrl;

    public void cG(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.cLQ = jSONObject.optString("url");
            this.fTN = jSONObject.optInt("server_time");
            this.fTO = jSONObject.optInt("adid");
            this.fTP = jSONObject.optString("big_pic");
            this.fTQ = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.fTP);
    }
}
