package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.ah;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private ah dPT;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.dPT = new ah();
            this.dPT.parserJson(jSONObject);
        }
    }

    public ah aMl() {
        return this.dPT;
    }
}
