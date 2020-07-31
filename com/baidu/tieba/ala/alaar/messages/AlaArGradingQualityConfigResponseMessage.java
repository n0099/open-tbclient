package com.baidu.tieba.ala.alaar.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaArGradingQualityConfigResponseMessage extends JsonHttpResponsedMessage {
    private JSONObject fma;

    public AlaArGradingQualityConfigResponseMessage() {
        super(1021204);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && !hasError() && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.length() != 0) {
            JSONObject cZ = com.baidu.tieba.ala.alaar.a.b.bvq().cZ(optJSONObject);
            this.fma = cZ;
            com.baidu.tieba.ala.alaar.a.b.bvq().d(cZ, true);
        }
    }
}
