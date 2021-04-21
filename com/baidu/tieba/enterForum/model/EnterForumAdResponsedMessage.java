package com.baidu.tieba.enterForum.model;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.j0.i0.d.b;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class EnterForumAdResponsedMessage extends JsonHttpResponsedMessage {
    public b adData;

    public EnterForumAdResponsedMessage() {
        super(CmdConfigHttp.CMD_ENTER_FORUM_AD_REQUEST);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        b bVar = new b();
        this.adData = bVar;
        bVar.b(jSONObject);
        if (this.adData.a()) {
            return;
        }
        this.adData = null;
    }

    public b getAdData() {
        return this.adData;
    }
}
