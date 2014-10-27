package com.baidu.tieba.discover.memberprivilege;

import com.baidu.tbadk.core.atomData.PayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
class c {
    public long aoz;
    public long api;
    public long apj;
    public String apk;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aoz = jSONObject.optInt(PayActivityConfig.PROPS_ID);
            this.api = jSONObject.optLong("end_time");
            this.apj = jSONObject.optLong("now_time");
            this.apk = jSONObject.optString("pic_url");
        }
    }

    public boolean isValid() {
        return (this.aoz == 1 || this.aoz == 2) && this.api > this.apj;
    }
}
