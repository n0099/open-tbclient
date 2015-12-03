package com.baidu.tieba.homepage.listview.card.discover;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class OpenUserResponsedMessage extends JsonHttpResponsedMessage {
    private OpenUserInfo userInfo;

    public OpenUserResponsedMessage(int i) {
        super(i);
    }

    public OpenUserInfo getUserInfo() {
        return this.userInfo;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        if (i == 1003012 && jSONObject != null) {
            this.userInfo = new OpenUserInfo();
            this.userInfo.parseJson(jSONObject.toString());
        }
    }
}
