package com.baidu.tieba.discover.memberpay;

import com.baidu.tbadk.core.atomData.PayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    long aoM;
    long aoN;
    String aod;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aoM = jSONObject.optLong(PayActivityConfig.PROPS_ID);
            this.aoN = jSONObject.optLong("end_time");
            this.aod = jSONObject.optString("pic_url");
        }
    }
}
