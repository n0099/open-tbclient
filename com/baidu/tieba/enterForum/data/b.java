package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public String aIQ;
    public int iJm;
    public int iJn;
    public String iJo;
    public String iJp;
    public String picUrl;

    public void ej(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.aIQ = jSONObject.optString("url");
            this.iJm = jSONObject.optInt("server_time");
            this.iJn = jSONObject.optInt("adid");
            this.iJo = jSONObject.optString("big_pic");
            this.iJp = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.iJo);
    }
}
