package com.baidu.tieba.frs.forumRule.message;

import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ResponseHttpRorumRuleDraftMessage extends JsonHttpResponsedMessage {
    public ForumRuleBaseData ruleBaseData;

    public ResponseHttpRorumRuleDraftMessage() {
        super(CmdConfigHttp.CMD_FORUM_RULES_DRAFT);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject == null) {
            return;
        }
        int parseInt = Integer.parseInt(jSONObject.optString("error_code"));
        if (parseInt == 0) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                ForumRuleBaseData forumRuleBaseData = new ForumRuleBaseData();
                this.ruleBaseData = forumRuleBaseData;
                forumRuleBaseData.parserData(optJSONObject);
                return;
            }
            return;
        }
        setError(parseInt);
        setErrorString(jSONObject.optString("error_msg"));
    }

    public ForumRuleBaseData getData() {
        return this.ruleBaseData;
    }
}
