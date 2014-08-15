package com.baidu.tieba.discover.memberpay;

import com.baidu.tbadk.core.atomData.PayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    long a;
    long b;
    String c;

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.a = jSONObject.optLong(PayActivityConfig.PROPS_ID);
            this.b = jSONObject.optLong("end_time");
            this.c = jSONObject.optString("pic_url");
        }
    }
}
