package com.baidu.tieba.frs.forumRule.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ResponseHttpRorumRuleCommitMessage extends JsonHttpResponsedMessage {
    public ResponseHttpRorumRuleCommitMessage() {
        super(CmdConfigHttp.CMD_FORUM_RULES_COMMIT);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        setError(Integer.parseInt(jSONObject.optString("error_code")));
        setErrorString(jSONObject.optString("error_msg"));
    }
}
