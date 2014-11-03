package com.baidu.tieba.discover.memberpay;

import com.baidu.tbadk.core.atomData.PayActivityConfig;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {
    String aoH;
    long aoI;
    long aoJ;
    long aoK;
    long aoL;
    String mTitle;
    String zL;

    public void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.aoH = jSONObject.optString("productId");
            this.mTitle = jSONObject.optString("title");
            this.zL = jSONObject.optString("desc");
            this.aoI = jSONObject.optLong(PayActivityConfig.PROPS_ID);
            this.aoJ = jSONObject.optLong("money");
            this.aoL = jSONObject.optLong("months");
            this.aoK = jSONObject.optLong("default");
        }
    }
}
