package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public String aEU;
    public int iBF;
    public int iBG;
    public String iBH;
    public String iBI;
    public String picUrl;

    public void eg(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.aEU = jSONObject.optString("url");
            this.iBF = jSONObject.optInt("server_time");
            this.iBG = jSONObject.optInt("adid");
            this.iBH = jSONObject.optString("big_pic");
            this.iBI = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.iBH);
    }
}
