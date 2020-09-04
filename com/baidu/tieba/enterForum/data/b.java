package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class b {
    public String aDi;
    public int htS;
    public int htT;
    public String htU;
    public String htV;
    public String picUrl;

    public void dy(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.aDi = jSONObject.optString("url");
            this.htS = jSONObject.optInt("server_time");
            this.htT = jSONObject.optInt("adid");
            this.htU = jSONObject.optString("big_pic");
            this.htV = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.htU);
    }
}
