package com.baidu.tieba.enterForum.data;

import android.text.TextUtils;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class b {
    public String aGz;
    public int ije;
    public int ijf;
    public String ijg;
    public String ijh;
    public String picUrl;

    public void dQ(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.picUrl = jSONObject.optString(UgcUBCUtils.UGC_TYPE_PIC_BTN);
            this.aGz = jSONObject.optString("url");
            this.ije = jSONObject.optInt("server_time");
            this.ijf = jSONObject.optInt("adid");
            this.ijg = jSONObject.optString("big_pic");
            this.ijh = jSONObject.optString("small_pic");
        }
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.ijg);
    }
}
