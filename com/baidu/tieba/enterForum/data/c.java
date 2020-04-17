package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public String aqV;
    public int gzA;
    public int gzB;
    public String gzC;
    public String gzD;
    public String picUrl;

    public void cR(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.aqV = jSONObject.optString("url");
            this.gzA = jSONObject.optInt("server_time");
            this.gzB = jSONObject.optInt("adid");
            this.gzC = jSONObject.optString("big_pic");
            this.gzD = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.gzC);
    }
}
