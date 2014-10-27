package com.baidu.tieba.discover.memberpay;

import com.baidu.tbadk.core.atomData.PayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    String anU;
    long aoD;
    long aoE;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aoD = jSONObject.optLong(PayActivityConfig.PROPS_ID);
            this.aoE = jSONObject.optLong("end_time");
            this.anU = jSONObject.optString("pic_url");
        }
    }
}
