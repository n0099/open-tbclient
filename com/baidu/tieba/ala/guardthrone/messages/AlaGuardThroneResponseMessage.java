package com.baidu.tieba.ala.guardthrone.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.guardthrone.b.a;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaGuardThroneResponseMessage extends JsonHttpResponsedMessage {
    private a geT;

    public AlaGuardThroneResponseMessage() {
        super(1021164);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.geT = new a();
            this.geT.parserJson(optJSONObject);
        }
    }

    public a bKU() {
        return this.geT;
    }
}
