package com.baidu.tieba.homepage.channel.message;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.a.n0.b1.b.a.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class HomePageChannelTabHttpResponsedMessage extends JsonHttpResponsedMessage {
    public a channelTabRespData;

    public HomePageChannelTabHttpResponsedMessage() {
        super(CmdConfigHttp.CMD_HOME_CHANNEL_TAB_LIST);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        if (jSONObject != null && jSONObject.optInt("error_code", -1) == 0) {
            a aVar = new a();
            this.channelTabRespData = aVar;
            aVar.f(jSONObject);
        }
    }
}
