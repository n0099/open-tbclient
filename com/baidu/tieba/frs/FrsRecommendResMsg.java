package com.baidu.tieba.frs;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class FrsRecommendResMsg extends JsonHttpResponsedMessage {
    private String mPushMsg;
    private int mPushStatus;

    public FrsRecommendResMsg(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.mPushStatus = optJSONObject.optInt("is_push_success");
            this.mPushMsg = optJSONObject.optString("msg");
        }
    }

    public int getPushStatus() {
        return this.mPushStatus;
    }

    public String getPushMsg() {
        return this.mPushMsg;
    }
}
