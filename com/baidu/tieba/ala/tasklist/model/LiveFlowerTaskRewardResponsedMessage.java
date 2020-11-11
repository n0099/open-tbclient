package com.baidu.tieba.ala.tasklist.model;

import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.an;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class LiveFlowerTaskRewardResponsedMessage extends JsonHttpResponsedMessage {
    public AlaLiveUserInfoData hKh;
    public an hKi;

    public LiveFlowerTaskRewardResponsedMessage() {
        super(1021066);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.hKh = new AlaLiveUserInfoData();
                this.hKh.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("task");
            if (optJSONObject3 != null) {
                this.hKi = new an();
                this.hKi.parserJson(optJSONObject3);
            }
        }
    }
}
