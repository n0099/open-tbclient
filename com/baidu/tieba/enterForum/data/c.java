package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c {
    public String auL;
    public int gOq;
    public int gOr;
    public String gOs;
    public String gOt;
    public String picUrl;

    public void cY(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.auL = jSONObject.optString("url");
            this.gOq = jSONObject.optInt("server_time");
            this.gOr = jSONObject.optInt("adid");
            this.gOs = jSONObject.optString("big_pic");
            this.gOt = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.gOs);
    }
}
