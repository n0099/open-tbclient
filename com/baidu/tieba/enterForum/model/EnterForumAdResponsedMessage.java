package com.baidu.tieba.enterForum.model;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.enterForum.data.c;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class EnterForumAdResponsedMessage extends JsonHttpResponsedMessage {
    private c adData;

    public EnterForumAdResponsedMessage() {
        super(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        this.adData = new c();
        this.adData.cY(jSONObject);
        if (!this.adData.isValid()) {
            this.adData = null;
        }
    }

    public c getAdData() {
        return this.adData;
    }
}
