package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.u;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private u hFi;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public u chT() {
        return this.hFi;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.hFi = new u();
            this.hFi.parserJson(jSONObject);
        }
    }
}
