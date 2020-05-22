package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.n;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private n fZQ;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public n bEH() {
        return this.fZQ;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.fZQ = new n();
            this.fZQ.parserJson(jSONObject);
        }
    }
}
