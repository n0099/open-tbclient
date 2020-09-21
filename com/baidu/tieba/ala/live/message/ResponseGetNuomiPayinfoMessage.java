package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.pay.PayInfoResultData;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ResponseGetNuomiPayinfoMessage extends JsonHttpResponsedMessage {
    private PayInfoResultData mPayInfoResultData;

    public ResponseGetNuomiPayinfoMessage() {
        super(1003412);
    }

    public PayInfoResultData getPayInfoResultData() {
        return this.mPayInfoResultData;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.mPayInfoResultData = new PayInfoResultData();
            this.mPayInfoResultData.parserNuomiJson(jSONObject);
        }
    }
}
