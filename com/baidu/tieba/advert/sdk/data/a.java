package com.baidu.tieba.advert.sdk.data;

import com.baidu.adp.lib.util.BdLog;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    protected int resultCode;
    protected String resultMsg;

    public a() {
    }

    public a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("code")) {
                this.resultCode = jSONObject.getInt("code");
            }
            if (jSONObject.has("msg")) {
                this.resultMsg = jSONObject.getString("msg");
            }
        } catch (JSONException e) {
            BdLog.e(e.getMessage());
        }
    }
}
