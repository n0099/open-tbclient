package com.baidu.tieba.frs.gamesubpb.model;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.j0.q0.w1.d.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FrsSelectSubCommentReponseMessage extends JsonHttpResponsedMessage {
    public c mData;

    public FrsSelectSubCommentReponseMessage() {
        super(CmdConfigHttp.CMD_SELECT_SUB_COMMENT);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        if (hasError() || jSONObject == null) {
            return;
        }
        this.mData = new c(jSONObject.optJSONObject("data"));
    }

    public c getSelectSubCommentData() {
        return this.mData;
    }
}
