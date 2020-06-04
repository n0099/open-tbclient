package com.baidu.tieba.ala.liveroom.recommend.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaRecommendLiveResponseMessage extends JsonHttpResponsedMessage {
    public com.baidu.tieba.ala.liveroom.recommend.data.a gdS;
    public com.baidu.tieba.ala.liveroom.recommend.data.a gdT;

    public AlaRecommendLiveResponseMessage() {
        super(1021193);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("follow");
            if (optJSONObject2 != null) {
                this.gdS = new com.baidu.tieba.ala.liveroom.recommend.data.a();
                this.gdS.type = 0;
                this.gdS.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("recommend");
            if (optJSONObject3 != null) {
                this.gdT = new com.baidu.tieba.ala.liveroom.recommend.data.a();
                this.gdT.type = 1;
                this.gdT.parserJson(optJSONObject3);
            }
        }
    }
}
