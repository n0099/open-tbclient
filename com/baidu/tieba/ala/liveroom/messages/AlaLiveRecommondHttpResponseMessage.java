package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.g;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private g ekx;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public g aUC() {
        return this.ekx;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.ekx = new g();
            this.ekx.parserJson(jSONObject);
        }
    }
}
