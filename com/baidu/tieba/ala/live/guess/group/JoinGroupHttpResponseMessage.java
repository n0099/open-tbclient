package com.baidu.tieba.ala.live.guess.group;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class JoinGroupHttpResponseMessage extends JsonHttpResponsedMessage {
    public String msg;
    public int status;
    public String url;

    public JoinGroupHttpResponseMessage() {
        super(1021238);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.status = optJSONObject.optInt("status");
            this.msg = optJSONObject.optString("msg");
            this.url = optJSONObject.optString("h5_url");
        }
    }
}
