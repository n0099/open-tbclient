package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class b {
    public String aDg;
    public int htM;
    public int htN;
    public String htO;
    public String htP;
    public String picUrl;

    public void dy(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.aDg = jSONObject.optString("url");
            this.htM = jSONObject.optInt("server_time");
            this.htN = jSONObject.optInt("adid");
            this.htO = jSONObject.optString("big_pic");
            this.htP = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.htO);
    }
}
