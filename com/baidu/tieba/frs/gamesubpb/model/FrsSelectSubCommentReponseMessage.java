package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class FrsSelectSubCommentReponseMessage extends JsonHttpResponsedMessage {
    private c mData;

    public FrsSelectSubCommentReponseMessage() {
        super(1003379);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (!hasError() && jSONObject != null) {
            this.mData = new c(jSONObject.optJSONObject("data"));
        }
    }

    public c getSelectSubCommentData() {
        return this.mData;
    }
}
