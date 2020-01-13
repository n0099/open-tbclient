package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.g;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGetAudienceHttpResponseMessage extends JsonHttpResponsedMessage {
    private g esC;

    public AlaGetAudienceHttpResponseMessage() {
        super(1021129);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.esC = new g();
            this.esC.parserJson(optJSONObject);
        }
    }

    public g bbH() {
        return this.esC;
    }
}
