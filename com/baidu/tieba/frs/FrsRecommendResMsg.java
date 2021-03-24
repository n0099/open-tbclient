package com.baidu.tieba.frs;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FrsRecommendResMsg extends JsonHttpResponsedMessage {
    public String mPushMsg;
    public int mPushStatus;

    public FrsRecommendResMsg(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        this.mPushStatus = optJSONObject.optInt("is_push_success");
        this.mPushMsg = optJSONObject.optString("msg");
    }

    public String getPushMsg() {
        return this.mPushMsg;
    }

    public int getPushStatus() {
        return this.mPushStatus;
    }
}
