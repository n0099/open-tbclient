package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.q;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetAudienceHttpResponseMessage extends JsonHttpResponsedMessage {
    private q gwE;

    public AlaGetAudienceHttpResponseMessage() {
        super(1021129);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gwE = new q();
            this.gwE.parserJson(optJSONObject);
        }
    }

    public q bRq() {
        return this.gwE;
    }
}
