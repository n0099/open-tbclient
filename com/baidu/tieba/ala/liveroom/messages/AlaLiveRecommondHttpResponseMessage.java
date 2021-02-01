package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.data.y;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaLiveRecommondHttpResponseMessage extends JsonHttpResponsedMessage {
    private y hJu;

    public AlaLiveRecommondHttpResponseMessage() {
        super(1021021);
    }

    public y ciM() {
        return this.hJu;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            this.hJu = new y();
            this.hJu.parserJson(jSONObject);
        }
    }
}
