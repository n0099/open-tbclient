package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public String aHq;
    public int iHp;
    public int iHq;
    public String iHr;
    public String iHs;
    public String picUrl;

    public void eh(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.aHq = jSONObject.optString("url");
            this.iHp = jSONObject.optInt("server_time");
            this.iHq = jSONObject.optInt("adid");
            this.iHr = jSONObject.optString("big_pic");
            this.iHs = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.iHr);
    }
}
