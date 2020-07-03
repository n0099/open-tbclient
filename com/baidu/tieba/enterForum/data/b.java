package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public String awR;
    public int hbo;
    public int hbp;
    public String hbq;
    public String hbr;
    public String picUrl;

    public void di(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.awR = jSONObject.optString("url");
            this.hbo = jSONObject.optInt("server_time");
            this.hbp = jSONObject.optInt("adid");
            this.hbq = jSONObject.optString("big_pic");
            this.hbr = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.hbq);
    }
}
