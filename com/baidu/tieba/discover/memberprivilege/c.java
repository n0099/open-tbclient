package com.baidu.tieba.discover.memberprivilege;

import com.baidu.tbadk.core.atomData.PayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
class c {
    public long aoI;
    public long aps;
    public long apt;
    public String apu;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aoI = jSONObject.optInt(PayActivityConfig.PROPS_ID);
            this.aps = jSONObject.optLong("end_time");
            this.apt = jSONObject.optLong("now_time");
            this.apu = jSONObject.optString("pic_url");
        }
    }

    public boolean isValid() {
        return (this.aoI == 1 || this.aoI == 2) && this.aps > this.apt;
    }
}
