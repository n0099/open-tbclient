package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaArGradingQualityConfigResponseMessage extends JsonHttpResponsedMessage {
    private JSONObject fxA;

    public AlaArGradingQualityConfigResponseMessage() {
        super(1021204);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && !hasError() && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.length() != 0) {
            JSONObject dg = com.baidu.tieba.ala.alaar.a.b.bEm().dg(optJSONObject);
            this.fxA = dg;
            com.baidu.tieba.ala.alaar.a.b.bEm().d(dg, true);
        }
    }
}
