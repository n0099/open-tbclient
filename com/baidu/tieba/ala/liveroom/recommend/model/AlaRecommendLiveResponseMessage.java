package com.baidu.tieba.ala.liveroom.recommend.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaRecommendLiveResponseMessage extends JsonHttpResponsedMessage {
    public com.baidu.tieba.ala.liveroom.recommend.data.b gwi;
    public com.baidu.tieba.ala.liveroom.recommend.data.b gwj;

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
                this.gwi = new com.baidu.tieba.ala.liveroom.recommend.data.b();
                this.gwi.type = 0;
                this.gwi.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("recommend");
            if (optJSONObject3 != null) {
                this.gwj = new com.baidu.tieba.ala.liveroom.recommend.data.b();
                this.gwj.type = 1;
                this.gwj.parserJson(optJSONObject3);
            }
        }
    }
}
