package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.k;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaGetAudienceHttpResponseMessage extends JsonHttpResponsedMessage {
    private k fRf;

    public AlaGetAudienceHttpResponseMessage() {
        super(1021129);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fRf = new k();
            this.fRf.parserJson(optJSONObject);
        }
    }

    public k bIv() {
        return this.fRf;
    }
}
