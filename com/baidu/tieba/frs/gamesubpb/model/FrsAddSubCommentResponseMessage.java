package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.i0.p0.w1.d.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FrsAddSubCommentResponseMessage extends JsonHttpResponsedMessage {
    public d mData;

    public FrsAddSubCommentResponseMessage() {
        super(CmdConfigHttp.CMD_ADD_SUB_COMMENT);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (hasError() || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null || optJSONObject.optJSONArray("sub_comment") == null || optJSONObject.optJSONArray("sub_comment").length() <= 0) {
            return;
        }
        this.mData = new d(optJSONObject.optJSONArray("sub_comment").optJSONObject(0));
    }

    public d getSubCommentData() {
        return this.mData;
    }
}
