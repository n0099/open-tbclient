package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.bs;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private bs gXW;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.gXW = new bs();
            this.gXW.parserJson(jSONObject);
        }
    }

    public bs bYj() {
        return this.gXW;
    }
}
