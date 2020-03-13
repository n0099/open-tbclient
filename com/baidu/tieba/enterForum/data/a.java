package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a {
    public String cLS;
    public int fUc;
    public int fUd;
    public String fUe;
    public String fUf;
    public String picUrl;

    public void cG(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.cLS = jSONObject.optString("url");
            this.fUc = jSONObject.optInt("server_time");
            this.fUd = jSONObject.optInt("adid");
            this.fUe = jSONObject.optString("big_pic");
            this.fUf = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.fUe);
    }
}
