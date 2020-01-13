package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.i;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private i fdC;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public i bns() {
        return this.fdC;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.fdC = new i();
            this.fdC.parserJson(jSONObject);
        }
    }
}
