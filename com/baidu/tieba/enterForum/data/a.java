package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public String bWc;
    public int fat;
    public int fau;
    public String fav;
    public String faw;
    public String picUrl;

    public void bP(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString("pic");
            this.bWc = jSONObject.optString("url");
            this.fat = jSONObject.optInt("server_time");
            this.fau = jSONObject.optInt("adid");
            this.fav = jSONObject.optString("big_pic");
            this.faw = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.fav);
    }
}
