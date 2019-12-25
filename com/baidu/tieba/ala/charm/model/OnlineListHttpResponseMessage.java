package com.baidu.tieba.ala.charm.model;

import com.baidu.live.data.g;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OnlineListHttpResponseMessage extends JsonHttpResponsedMessage {
    private g erq;

    public OnlineListHttpResponseMessage() {
        super(1021008);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.optJSONArray("initmacy_rank") != null) {
            this.erq = new g();
            this.erq.parserJson(optJSONObject);
        }
    }

    public g bbm() {
        return this.erq;
    }
}
