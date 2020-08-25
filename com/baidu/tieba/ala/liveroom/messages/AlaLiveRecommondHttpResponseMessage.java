package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.n;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private n gEU;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public n bUZ() {
        return this.gEU;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gEU = new n();
            this.gEU.parserJson(jSONObject);
        }
    }
}
