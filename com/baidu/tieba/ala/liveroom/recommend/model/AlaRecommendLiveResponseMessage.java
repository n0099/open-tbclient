package com.baidu.tieba.ala.liveroom.recommend.model;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaRecommendLiveResponseMessage extends JsonHttpResponsedMessage {
    public com.baidu.tieba.ala.liveroom.recommend.data.a gdH;
    public com.baidu.tieba.ala.liveroom.recommend.data.a gdI;

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
                this.gdH = new com.baidu.tieba.ala.liveroom.recommend.data.a();
                this.gdH.type = 0;
                this.gdH.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("recommend");
            if (optJSONObject3 != null) {
                this.gdI = new com.baidu.tieba.ala.liveroom.recommend.data.a();
                this.gdI.type = 1;
                this.gdI.parserJson(optJSONObject3);
            }
        }
    }
}
