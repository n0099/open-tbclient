package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.y;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private y hLr;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public y ciZ() {
        return this.hLr;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.hLr = new y();
            this.hLr.parserJson(jSONObject);
        }
    }
}
