package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public String cMd;
    public int fUL;
    public int fUM;
    public String fUN;
    public String fUO;
    public String picUrl;

    public void cG(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.cMd = jSONObject.optString("url");
            this.fUL = jSONObject.optInt("server_time");
            this.fUM = jSONObject.optInt("adid");
            this.fUN = jSONObject.optString("big_pic");
            this.fUO = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.fUN);
    }
}
