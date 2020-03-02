package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.j;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private j fgN;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public j bpe() {
        return this.fgN;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.fgN = new j();
            this.fgN.parserJson(jSONObject);
        }
    }
}
