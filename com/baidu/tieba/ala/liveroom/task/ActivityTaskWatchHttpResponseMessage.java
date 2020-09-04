package com.baidu.tieba.ala.liveroom.task;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ActivityTaskWatchHttpResponseMessage extends JsonHttpResponsedMessage {
    private a gJi;

    public ActivityTaskWatchHttpResponseMessage() {
        super(1021127);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            this.gJi = new a();
            this.gJi.parseJson(optJSONObject);
        }
    }

    public a bWA() {
        return this.gJi;
    }
}
