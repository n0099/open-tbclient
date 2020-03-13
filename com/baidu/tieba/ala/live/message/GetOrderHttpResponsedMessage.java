package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.as;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private as eKA;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.eKA = new as();
            this.eKA.parserJson(jSONObject);
        }
    }

    public as bgr() {
        return this.eKA;
    }
}
