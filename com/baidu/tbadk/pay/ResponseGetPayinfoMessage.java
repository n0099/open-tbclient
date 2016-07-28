package com.baidu.tbadk.pay;

import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseGetPayinfoMessage extends JsonHttpResponsedMessage {
    private PayInfoResultData mPayInfoResultData;

    public ResponseGetPayinfoMessage(int i) {
        super(i);
    }

    public PayInfoResultData getPayInfoResultData() {
        return this.mPayInfoResultData;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.mPayInfoResultData = (PayInfoResultData) i.objectWithJsonStr(jSONObject.toString(), PayInfoResultData.class);
        }
    }
}
