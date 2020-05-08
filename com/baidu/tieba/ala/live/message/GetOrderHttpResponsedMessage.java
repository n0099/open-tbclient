package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.av;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private av fpu;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.fpu = new av();
            this.fpu.parserJson(jSONObject);
        }
    }

    public av bpL() {
        return this.fpu;
    }
}
