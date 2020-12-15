package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class b {
    public String aJj;
    public int itZ;
    public int iua;
    public String iub;
    public String iuc;
    public String picUrl;

    public void dS(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.aJj = jSONObject.optString("url");
            this.itZ = jSONObject.optInt("server_time");
            this.iua = jSONObject.optInt("adid");
            this.iub = jSONObject.optString("big_pic");
            this.iuc = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.iub);
    }
}
