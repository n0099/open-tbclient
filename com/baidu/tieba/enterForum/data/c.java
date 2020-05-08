package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public String arb;
    public int gzG;
    public int gzH;
    public String gzI;
    public String gzJ;
    public String picUrl;

    public void cR(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.arb = jSONObject.optString("url");
            this.gzG = jSONObject.optInt("server_time");
            this.gzH = jSONObject.optInt("adid");
            this.gzI = jSONObject.optString("big_pic");
            this.gzJ = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.gzI);
    }
}
