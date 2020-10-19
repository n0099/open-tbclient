package com.baidu.tieba.ala.liveroom.challenge.message;

import com.baidu.live.challenge.d;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetTargetInfoResponseMessage extends JsonHttpResponsedMessage {
    private d gIG;

    public AlaGetTargetInfoResponseMessage() {
        super(1021116);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && (optJSONObject2 = optJSONObject.optJSONObject("user_info")) != null) {
            this.gIG = new d();
            this.gIG.parseJson(optJSONObject2);
        }
    }

    public d bUr() {
        return this.gIG;
    }
}
