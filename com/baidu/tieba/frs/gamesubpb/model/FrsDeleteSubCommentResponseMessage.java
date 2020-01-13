package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class FrsDeleteSubCommentResponseMessage extends JsonHttpResponsedMessage {
    private d mData;

    public FrsDeleteSubCommentResponseMessage() {
        super(1003381);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (!hasError() && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.optJSONObject("sub_comment") != null) {
            this.mData = new d(optJSONObject.optJSONObject("sub_comment"));
        }
    }

    public d getSubCommentData() {
        return this.mData;
    }
}
