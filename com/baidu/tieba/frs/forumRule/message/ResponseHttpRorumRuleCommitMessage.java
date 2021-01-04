package com.baidu.tieba.frs.forumRule.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ResponseHttpRorumRuleCommitMessage extends JsonHttpResponsedMessage {
    public ResponseHttpRorumRuleCommitMessage() {
        super(CmdConfigHttp.CMD_FORUM_RULES_COMMIT);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            setError(Integer.parseInt(jSONObject.optString("error_code")));
            setErrorString(jSONObject.optString("error_msg"));
        }
    }
}
