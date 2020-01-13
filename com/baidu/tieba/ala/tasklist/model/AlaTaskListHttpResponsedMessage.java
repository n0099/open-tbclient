package com.baidu.tieba.ala.tasklist.model;

import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.u;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaTaskListHttpResponsedMessage extends JsonHttpResponsedMessage {
    public AlaLiveUserInfoData fwW;
    public u fwX;

    public AlaTaskListHttpResponsedMessage() {
        super(1021065);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("user_info");
            if (optJSONObject2 != null) {
                this.fwW = new AlaLiveUserInfoData();
                this.fwW.parserJson(optJSONObject2);
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("task");
            if (optJSONObject3 != null) {
                this.fwX = new u();
                this.fwX.parserJson(optJSONObject3);
            }
        }
    }
}
