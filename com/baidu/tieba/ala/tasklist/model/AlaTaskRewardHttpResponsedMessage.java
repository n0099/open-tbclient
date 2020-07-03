package com.baidu.tieba.ala.tasklist.model;

import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ac;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaTaskRewardHttpResponsedMessage extends JsonHttpResponsedMessage {
    public AlaLiveUserInfoData gGR;
    public ac gGS;

    public AlaTaskRewardHttpResponsedMessage() {
        super(1021066);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.gGR = new AlaLiveUserInfoData();
                this.gGR.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("task");
            if (optJSONObject3 != null) {
                this.gGS = new ac();
                this.gGS.parserJson(optJSONObject3);
            }
        }
    }
}
