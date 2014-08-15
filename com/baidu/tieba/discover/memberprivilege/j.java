package com.baidu.tieba.discover.memberprivilege;

import com.baidu.tbadk.core.atomData.PayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
class j {
    public long a;
    public long b;
    public long c;
    public String d;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optInt(PayActivityConfig.PROPS_ID);
            this.b = jSONObject.optLong("end_time");
            this.c = jSONObject.optLong("now_time");
            this.d = jSONObject.optString("pic_url");
        }
    }

    public boolean a() {
        return (this.a == 1 || this.a == 2) && this.b > this.c;
    }
}
