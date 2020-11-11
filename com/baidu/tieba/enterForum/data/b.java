package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class b {
    public String aIk;
    public int iiq;
    public int iir;
    public String iis;
    public String iit;
    public String picUrl;

    public void dW(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.aIk = jSONObject.optString("url");
            this.iiq = jSONObject.optInt("server_time");
            this.iir = jSONObject.optInt("adid");
            this.iis = jSONObject.optString("big_pic");
            this.iit = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.iis);
    }
}
