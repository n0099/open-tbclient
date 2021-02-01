package com.baidu.tieba.ala.liveroom.performancewatchtask;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class WatchFinishHttpResponseMessage extends JsonHttpResponsedMessage {
    public c hMD;

    public WatchFinishHttpResponseMessage() {
        super(1021221);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.hMD = new c();
            if (optJSONObject != null) {
                this.hMD.parseJson(optJSONObject);
            }
        }
    }

    public c cjW() {
        return this.hMD;
    }
}
