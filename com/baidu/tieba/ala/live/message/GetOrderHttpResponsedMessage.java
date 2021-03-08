package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.bz;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private bz hlt;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.hlt = new bz();
            this.hlt.parserJson(jSONObject);
        }
    }

    public bz bYl() {
        return this.hlt;
    }
}
