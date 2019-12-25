package com.baidu.tieba.enterForum.model;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class EnterForumAdResponsedMessage extends JsonHttpResponsedMessage {
    private com.baidu.tieba.enterForum.data.a adData;

    public EnterForumAdResponsedMessage() {
        super(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        this.adData = new com.baidu.tieba.enterForum.data.a();
        this.adData.cG(jSONObject);
        if (!this.adData.isValid()) {
            this.adData = null;
        }
    }

    public com.baidu.tieba.enterForum.data.a getAdData() {
        return this.adData;
    }
}
