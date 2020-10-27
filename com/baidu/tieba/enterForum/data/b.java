package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class b {
    public String aHs;
    public int icp;
    public int icq;
    public String icr;
    public String ics;
    public String picUrl;

    public void dQ(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.aHs = jSONObject.optString("url");
            this.icp = jSONObject.optInt("server_time");
            this.icq = jSONObject.optInt("adid");
            this.icr = jSONObject.optString("big_pic");
            this.ics = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.icr);
    }
}
