package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.k;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private k fLQ;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public k byD() {
        return this.fLQ;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.fLQ = new k();
            this.fLQ.parserJson(jSONObject);
        }
    }
}
