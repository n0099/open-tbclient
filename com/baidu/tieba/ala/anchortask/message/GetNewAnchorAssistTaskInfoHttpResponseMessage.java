package com.baidu.tieba.ala.anchortask.message;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetNewAnchorAssistTaskInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    public com.baidu.tieba.ala.anchortask.b.a gIx;

    public GetNewAnchorAssistTaskInfoHttpResponseMessage() {
        super(1021230);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gIx = new com.baidu.tieba.ala.anchortask.b.a();
            this.gIx.parseJson(optJSONObject);
        }
    }
}
