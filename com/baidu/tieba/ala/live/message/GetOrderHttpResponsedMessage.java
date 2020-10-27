package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.bq;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private bq gJq;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.gJq = new bq();
            this.gJq.parserJson(jSONObject);
        }
    }

    public bq bSI() {
        return this.gJq;
    }
}
