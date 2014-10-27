package com.baidu.tieba.discover.memberpay;

import com.baidu.tbadk.core.atomData.PayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    long aoA;
    long aoB;
    long aoC;
    String aoy;
    long aoz;
    String mTitle;
    String zL;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aoy = jSONObject.optString("productId");
            this.mTitle = jSONObject.optString("title");
            this.zL = jSONObject.optString("desc");
            this.aoz = jSONObject.optLong(PayActivityConfig.PROPS_ID);
            this.aoA = jSONObject.optLong("money");
            this.aoC = jSONObject.optLong("months");
            this.aoB = jSONObject.optLong("default");
        }
    }
}
