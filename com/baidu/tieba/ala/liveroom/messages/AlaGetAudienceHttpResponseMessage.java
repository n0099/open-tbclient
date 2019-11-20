package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.e;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaGetAudienceHttpResponseMessage extends JsonHttpResponsedMessage {
    private e dFn;

    public AlaGetAudienceHttpResponseMessage() {
        super(1021129);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.dFn = new e();
            this.dFn.parserJson(optJSONObject);
        }
    }

    public e aKw() {
        return this.dFn;
    }
}
