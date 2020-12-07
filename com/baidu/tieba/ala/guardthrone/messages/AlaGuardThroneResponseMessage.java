package com.baidu.tieba.ala.guardthrone.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.guardthrone.b.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGuardThroneResponseMessage extends JsonHttpResponsedMessage {
    private a gTb;

    public AlaGuardThroneResponseMessage() {
        super(1021164);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gTb = new a();
            this.gTb.parserJson(optJSONObject);
        }
    }

    public a bWV() {
        return this.gTb;
    }
}
