package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.n;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private n grZ;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public n bKW() {
        return this.grZ;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.grZ = new n();
            this.grZ.parserJson(jSONObject);
        }
    }
}
