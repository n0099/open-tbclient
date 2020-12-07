package com.baidu.tieba.frs.broadcast;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class ForumManagerRightsResMsg extends JsonHttpResponsedMessage {
    public int broadcastTotalCount;
    public int broadcastUsedCount;

    public ForumManagerRightsResMsg(int i) {
        super(i);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (jSONObject != null && jSONObject.optInt("error_code", -1) == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.broadcastUsedCount = optJSONObject.optInt("used_cnt");
            this.broadcastTotalCount = optJSONObject.optInt("has_cnt");
        }
    }
}
