package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    public String cHN;
    public int fRs;
    public int fRt;
    public String fRu;
    public String fRv;
    public String picUrl;

    public void cG(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.cHN = jSONObject.optString("url");
            this.fRs = jSONObject.optInt("server_time");
            this.fRt = jSONObject.optInt("adid");
            this.fRu = jSONObject.optString("big_pic");
            this.fRv = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.fRu);
    }
}
