package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.y;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private y hJI;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public y ciT() {
        return this.hJI;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.hJI = new y();
            this.hJI.parserJson(jSONObject);
        }
    }
}
