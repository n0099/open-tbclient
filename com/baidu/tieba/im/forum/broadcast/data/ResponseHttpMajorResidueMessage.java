package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class ResponseHttpMajorResidueMessage extends JsonHttpResponsedMessage {
    ForumBroadcastMajorResidueData majorHistoryData;

    public ResponseHttpMajorResidueMessage() {
        super(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE);
    }

    public ForumBroadcastMajorResidueData getData() {
        return this.majorHistoryData;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (jSONObject != null && jSONObject.optInt("error_code", -1) == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.majorHistoryData = new ForumBroadcastMajorResidueData();
            this.majorHistoryData.Ek(optJSONObject.optInt("used_cnt"));
            this.majorHistoryData.El(optJSONObject.optInt("has_cnt"));
            this.majorHistoryData.Em(optJSONObject.optInt("predict_push_usercnt"));
        }
    }
}
