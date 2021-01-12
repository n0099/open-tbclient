package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.r;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetAudienceHttpResponseMessage extends JsonHttpResponsedMessage {
    private r gMb;

    public AlaGetAudienceHttpResponseMessage() {
        super(1021129);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gMb = new r();
            this.gMb.parserJson(optJSONObject);
        }
    }

    public r bTh() {
        return this.gMb;
    }
}
