package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.i;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private i faO;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public i bmt() {
        return this.faO;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.faO = new i();
            this.faO.parserJson(jSONObject);
        }
    }
}
