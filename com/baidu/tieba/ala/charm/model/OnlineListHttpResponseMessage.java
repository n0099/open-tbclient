package com.baidu.tieba.ala.charm.model;

import com.baidu.live.data.e;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class OnlineListHttpResponseMessage extends JsonHttpResponsedMessage {
    private e dFn;

    public OnlineListHttpResponseMessage() {
        super(1021008);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (getError() == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.optJSONArray("initmacy_rank") != null) {
            this.dFn = new e();
            this.dFn.parserJson(optJSONObject);
        }
    }

    public e aKw() {
        return this.dFn;
    }
}
