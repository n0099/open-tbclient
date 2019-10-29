package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.ah;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private ah dQK;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.dQK = new ah();
            this.dQK.parserJson(jSONObject);
        }
    }

    public ah aMn() {
        return this.dQK;
    }
}
