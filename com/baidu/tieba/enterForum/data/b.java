package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class b {
    public String aHf;
    public int hPS;
    public int hPT;
    public String hPU;
    public String hPV;
    public String picUrl;

    public void dK(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.aHf = jSONObject.optString("url");
            this.hPS = jSONObject.optInt("server_time");
            this.hPT = jSONObject.optInt("adid");
            this.hPU = jSONObject.optString("big_pic");
            this.hPV = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.hPU);
    }
}
