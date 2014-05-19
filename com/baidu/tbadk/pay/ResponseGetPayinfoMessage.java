package com.baidu.tbadk.pay;

import com.baidu.gson.Gson;
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
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.mPayInfoResultData = (PayInfoResultData) new Gson().fromJson(jSONObject.toString(), (Class<Object>) PayInfoResultData.class);
        }
    }
}
