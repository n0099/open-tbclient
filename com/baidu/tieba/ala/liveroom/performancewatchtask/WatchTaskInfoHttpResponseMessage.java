package com.baidu.tieba.ala.liveroom.performancewatchtask;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WatchTaskInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    public c hry;

    public WatchTaskInfoHttpResponseMessage() {
        super(1021220);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.hry = new c();
            if (optJSONObject != null) {
                this.hry.parseJson(optJSONObject);
            }
        }
    }

    public c cgL() {
        return this.hry;
    }
}
