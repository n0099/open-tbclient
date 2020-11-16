package com.baidu.tieba.ala.liveroom.performancewatchtask;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class WatchTaskInfoHttpResponseMessage extends JsonHttpResponsedMessage {
    public c hrf;

    public WatchTaskInfoHttpResponseMessage() {
        super(1021220);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.hrf = new c();
            if (optJSONObject != null) {
                this.hrf.parseJson(optJSONObject);
            }
        }
    }

    public c cge() {
        return this.hrf;
    }
}
