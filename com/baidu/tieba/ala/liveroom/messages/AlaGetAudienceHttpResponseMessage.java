package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.v;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGetAudienceHttpResponseMessage extends JsonHttpResponsedMessage {
    private v gOV;

    public AlaGetAudienceHttpResponseMessage() {
        super(1021129);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gOV = new v();
            this.gOV.parserJson(optJSONObject);
        }
    }

    public v bTR() {
        return this.gOV;
    }
}
