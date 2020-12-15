package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.t;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private t hxQ;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public t ciY() {
        return this.hxQ;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.hxQ = new t();
            this.hxQ.parserJson(jSONObject);
        }
    }
}
