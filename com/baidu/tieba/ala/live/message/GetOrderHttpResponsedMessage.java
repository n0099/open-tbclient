package com.baidu.tieba.ala.live.message;

import com.baidu.live.data.bz;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GetOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private bz hjw;

    public GetOrderHttpResponsedMessage() {
        super(1003029);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.hjw = new bz();
            this.hjw.parserJson(jSONObject);
        }
    }

    public bz bXY() {
        return this.hjw;
    }
}
