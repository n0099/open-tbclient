package com.baidu.tieba.frs.forumRule.message;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class ResponseHttpRorumRuleDraftMessage extends JsonHttpResponsedMessage {
    ForumRuleBaseData ruleBaseData;

    public ResponseHttpRorumRuleDraftMessage() {
        super(CmdConfigHttp.CMD_FORUM_RULES_DRAFT);
    }

    public ForumRuleBaseData getData() {
        return this.ruleBaseData;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            int parseInt = Integer.parseInt(jSONObject.optString("error_code"));
            if (parseInt == 0) {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    this.ruleBaseData = new ForumRuleBaseData();
                    this.ruleBaseData.parserData(optJSONObject);
                    return;
                }
                return;
            }
            setError(parseInt);
            setErrorString(jSONObject.optString(AlaRecorderLog.KEY_ERROR_MSG));
        }
    }
}
