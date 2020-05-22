package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.ba;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private ba fDi;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.fDi = new ba();
            this.fDi.parserJson(jSONObject);
        }
    }

    public ba bvD() {
        return this.fDi;
    }
}
