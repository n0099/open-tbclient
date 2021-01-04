package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.u;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private u hJO;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public u clK() {
        return this.hJO;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.hJO = new u();
            this.hJO.parserJson(jSONObject);
        }
    }
}
