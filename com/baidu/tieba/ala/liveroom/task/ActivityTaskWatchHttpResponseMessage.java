package com.baidu.tieba.ala.liveroom.task;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ActivityTaskWatchHttpResponseMessage extends JsonHttpResponsedMessage {
    private a htk;

    public ActivityTaskWatchHttpResponseMessage() {
        super(1021127);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.htk = new a();
            this.htk.parseJson(optJSONObject);
        }
    }

    public a cho() {
        return this.htk;
    }
}
