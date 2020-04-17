package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.k;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private k fLL;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public k byF() {
        return this.fLL;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.fLL = new k();
            this.fLL.parserJson(jSONObject);
        }
    }
}
