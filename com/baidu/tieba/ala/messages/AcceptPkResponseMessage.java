package com.baidu.tieba.ala.messages;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AcceptPkResponseMessage extends JsonHttpResponsedMessage {
    long pkID;

    public AcceptPkResponseMessage(int i) {
        super(i);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.pkID = optJSONObject.optLong("pk_id");
        }
    }

    public long clU() {
        return this.pkID;
    }
}
