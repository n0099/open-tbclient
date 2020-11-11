package com.baidu.tieba.enterForum.model;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes22.dex */
public class EnterForumAdResponsedMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.enterForum.data.b adData;

    public EnterForumAdResponsedMessage() {
        super(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        this.adData = new com.baidu.tieba.enterForum.data.b();
        this.adData.dW(jSONObject);
        if (!this.adData.isValid()) {
            this.adData = null;
        }
    }

    public com.baidu.tieba.enterForum.data.b getAdData() {
        return this.adData;
    }
}
