package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaGetVerifyStrategyResponseHttpMessage extends JsonHttpResponsedMessage {
    public int fdA;
    public String fdB;
    public int fdv;
    public String fdw;
    public int fdx;
    public String fdy;
    public int fdz;
    public int verifyType;

    public AlaGetVerifyStrategyResponseHttpMessage() {
        super(1003303);
        this.fdv = 0;
        this.fdx = 2;
        this.fdz = 0;
        this.verifyType = 0;
        this.fdA = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject("strategy")) != null) {
                JSONObject optJSONObject3 = optJSONObject.optJSONObject(LogConfig.VALUE_LIVE_HK_RECORD_START);
                if (optJSONObject3 != null) {
                    this.fdv = optJSONObject3.optInt("switch");
                    this.fdw = optJSONObject3.optString("text");
                }
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("certify");
                if (optJSONObject4 != null) {
                    this.fdA = optJSONObject4.optInt("switch");
                    this.fdB = optJSONObject4.optString("text");
                }
                JSONObject optJSONObject5 = optJSONObject.optJSONObject("user_verify");
                if (optJSONObject5 != null) {
                    this.fdx = optJSONObject5.optInt("switch");
                    this.fdz = optJSONObject5.optInt("in_testlist");
                    this.fdy = optJSONObject5.optString("text");
                    this.verifyType = optJSONObject5.optInt("type");
                }
            }
        }
    }
}
