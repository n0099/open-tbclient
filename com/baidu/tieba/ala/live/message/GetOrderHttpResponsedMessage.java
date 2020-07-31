package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.bf;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private bf fTV;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.fTV = new bf();
            this.fTV.parserJson(jSONObject);
        }
    }

    public bf bBP() {
        return this.fTV;
    }
}
