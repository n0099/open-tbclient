package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.j0.q0.w1.d.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FrsDeleteSubCommentResponseMessage extends JsonHttpResponsedMessage {
    public d mData;

    public FrsDeleteSubCommentResponseMessage() {
        super(CmdConfigHttp.CMD_DELETE_SUB_COMMENT);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i2, jSONObject);
        if (hasError() || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null || optJSONObject.optJSONObject("sub_comment") == null) {
            return;
        }
        this.mData = new d(optJSONObject.optJSONObject("sub_comment"));
    }

    public d getSubCommentData() {
        return this.mData;
    }
}
