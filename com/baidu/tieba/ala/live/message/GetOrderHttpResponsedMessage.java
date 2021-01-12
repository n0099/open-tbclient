package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.bu;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private bu hfg;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.hfg = new bu();
            this.hfg.parserJson(jSONObject);
        }
    }

    public bu bWY() {
        return this.hfg;
    }
}
