package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.q;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private q gIw;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public q bWK() {
        return this.gIw;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gIw = new q();
            this.gIw.parserJson(jSONObject);
        }
    }
}
