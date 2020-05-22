package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.k;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetAudienceHttpResponseMessage extends JsonHttpResponsedMessage {
    private k fph;

    public AlaGetAudienceHttpResponseMessage() {
        super(1021129);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fph = new k();
            this.fph.parserJson(optJSONObject);
        }
    }

    public k bth() {
        return this.fph;
    }
}
