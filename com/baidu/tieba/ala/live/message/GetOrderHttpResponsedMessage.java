package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.br;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private br gOJ;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.gOJ = new br();
            this.gOJ.parserJson(jSONObject);
        }
    }

    public br bUA() {
        return this.gOJ;
    }
}
