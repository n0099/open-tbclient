package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public String auL;
    public int gOB;
    public int gOC;
    public String gOD;
    public String gOE;
    public String picUrl;

    public void cY(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.auL = jSONObject.optString("url");
            this.gOB = jSONObject.optInt("server_time");
            this.gOC = jSONObject.optInt("adid");
            this.gOD = jSONObject.optString("big_pic");
            this.gOE = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.gOD);
    }
}
