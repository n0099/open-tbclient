package com.baidu.tieba.ala.guardthrone.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.guardthrone.b.a;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGuardThroneResponseMessage extends JsonHttpResponsedMessage {
    private a eEf;

    public AlaGuardThroneResponseMessage() {
        super(1021160);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eEf = new a();
            this.eEf.parserJson(optJSONObject);
        }
    }

    public a bdu() {
        return this.eEf;
    }
}
