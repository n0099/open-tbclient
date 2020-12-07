package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.t;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private t hxO;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public t ciX() {
        return this.hxO;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.hxO = new t();
            this.hxO.parserJson(jSONObject);
        }
    }
}
