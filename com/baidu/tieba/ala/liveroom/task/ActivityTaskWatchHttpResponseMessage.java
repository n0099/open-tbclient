package com.baidu.tieba.ala.liveroom.task;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ActivityTaskWatchHttpResponseMessage extends JsonHttpResponsedMessage {
    private a geB;

    public ActivityTaskWatchHttpResponseMessage() {
        super(1021127);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.geB = new a();
            this.geB.parseJson(optJSONObject);
        }
    }

    public a bGm() {
        return this.geB;
    }
}
