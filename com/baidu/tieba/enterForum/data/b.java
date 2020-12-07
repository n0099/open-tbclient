package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class b {
    public String aJj;
    public int itX;
    public int itY;
    public String itZ;
    public String iua;
    public String picUrl;

    public void dS(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.aJj = jSONObject.optString("url");
            this.itX = jSONObject.optInt("server_time");
            this.itY = jSONObject.optInt("adid");
            this.itZ = jSONObject.optString("big_pic");
            this.iua = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.itZ);
    }
}
