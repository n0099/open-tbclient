package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.aq;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private aq eGs;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.eGs = new aq();
            this.eGs.parserJson(jSONObject);
        }
    }

    public aq bee() {
        return this.eGs;
    }
}
