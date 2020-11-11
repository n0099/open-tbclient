package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.t;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private t hoD;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public t cfK() {
        return this.hoD;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.hoD = new t();
            this.hoD.parserJson(jSONObject);
        }
    }
}
