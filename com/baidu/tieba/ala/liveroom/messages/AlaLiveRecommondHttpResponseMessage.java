package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.t;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private t hok;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public t cfd() {
        return this.hok;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.hok = new t();
            this.hok.parserJson(jSONObject);
        }
    }
}
