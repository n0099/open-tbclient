package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.bh;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private bh gfY;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.gfY = new bh();
            this.gfY.parserJson(jSONObject);
        }
    }

    public bh bLk() {
        return this.gfY;
    }
}
