package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class b {
    public String aye;
    public int hgT;
    public int hgU;
    public String hgV;
    public String hgW;
    public String picUrl;

    public void dp(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.aye = jSONObject.optString("url");
            this.hgT = jSONObject.optInt("server_time");
            this.hgU = jSONObject.optInt("adid");
            this.hgV = jSONObject.optString("big_pic");
            this.hgW = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.hgV);
    }
}
