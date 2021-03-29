package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseHttpMajorResidueMessage extends JsonHttpResponsedMessage {
    public ForumBroadcastMajorResidueData majorHistoryData;

    public ResponseHttpMajorResidueMessage() {
        super(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_RESIDUE);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (jSONObject == null || jSONObject.optInt("error_code", -1) != 0 || (optJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        ForumBroadcastMajorResidueData forumBroadcastMajorResidueData = new ForumBroadcastMajorResidueData();
        this.majorHistoryData = forumBroadcastMajorResidueData;
        forumBroadcastMajorResidueData.w(optJSONObject.optInt("used_cnt"));
        this.majorHistoryData.u(optJSONObject.optInt("has_cnt"));
        this.majorHistoryData.v(optJSONObject.optInt("predict_push_usercnt"));
    }

    public ForumBroadcastMajorResidueData getData() {
        return this.majorHistoryData;
    }
}
