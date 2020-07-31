package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class FrsAddSubCommentResponseMessage extends JsonHttpResponsedMessage {
    private d mData;

    public FrsAddSubCommentResponseMessage() {
        super(1003380);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (!hasError() && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.optJSONArray("sub_comment") != null && optJSONObject.optJSONArray("sub_comment").length() > 0) {
            this.mData = new d(optJSONObject.optJSONArray("sub_comment").optJSONObject(0));
        }
    }

    public d getSubCommentData() {
        return this.mData;
    }
}
