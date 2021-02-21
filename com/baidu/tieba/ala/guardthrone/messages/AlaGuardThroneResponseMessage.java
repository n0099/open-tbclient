package com.baidu.tieba.ala.guardthrone.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.guardthrone.b.a;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaGuardThroneResponseMessage extends JsonHttpResponsedMessage {
    private a hdi;

    public AlaGuardThroneResponseMessage() {
        super(1021164);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hdi = new a();
            this.hdi.parserJson(optJSONObject);
        }
    }

    public a bWv() {
        return this.hdi;
    }
}
