package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.am;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private am eFi;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.eFi = new am();
            this.eFi.parserJson(jSONObject);
        }
    }

    public am bdJ() {
        return this.eFi;
    }
}
