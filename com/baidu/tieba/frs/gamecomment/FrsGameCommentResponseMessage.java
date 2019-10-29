package com.baidu.tieba.frs.gamecomment;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FrsGameCommentResponseMessage extends JsonHttpResponsedMessage {
    public FrsGameCommentResponseMessage(int i) {
        super(1001712);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
        }
    }
}
