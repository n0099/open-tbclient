package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {
    public String aJH;
    public int iGm;
    public int iGn;
    public String iGo;
    public String iGp;
    public String picUrl;

    public void eg(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.aJH = jSONObject.optString("url");
            this.iGm = jSONObject.optInt("server_time");
            this.iGn = jSONObject.optInt("adid");
            this.iGo = jSONObject.optString("big_pic");
            this.iGp = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.iGo);
    }
}
