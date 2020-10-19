package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.q;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private q gWW;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public q caf() {
        return this.gWW;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gWW = new q();
            this.gWW.parserJson(jSONObject);
        }
    }
}
