package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class b {
    public String aEb;
    public int hAX;
    public int hAY;
    public String hAZ;
    public String hBa;
    public String picUrl;

    public void dF(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.aEb = jSONObject.optString("url");
            this.hAX = jSONObject.optInt("server_time");
            this.hAY = jSONObject.optInt("adid");
            this.hAZ = jSONObject.optString("big_pic");
            this.hBa = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.hAZ);
    }
}
