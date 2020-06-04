package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.n;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private n gab;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public n bEJ() {
        return this.gab;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.gab = new n();
            this.gab.parserJson(jSONObject);
        }
    }
}
