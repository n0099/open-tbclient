package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaGetVerifyStrategyResponseHttpMessage extends JsonHttpResponsedMessage {
    public int eks;
    public String ekt;
    public int eku;
    public String ekv;
    public int ekw;
    public int verifyType;

    public AlaGetVerifyStrategyResponseHttpMessage() {
        super(1003303);
        this.eks = 1;
        this.eku = 1;
        this.ekw = 0;
        this.verifyType = 0;
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
                    this.eks = optJSONObject3.optInt("switch");
                    this.ekt = optJSONObject3.optString("text");
                }
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("user_verify");
                if (optJSONObject4 != null) {
                    this.eku = optJSONObject4.optInt("switch");
                    this.ekw = optJSONObject4.optInt("in_testlist");
                    this.ekv = optJSONObject4.optString("text");
                    this.verifyType = optJSONObject4.optInt("type");
                }
            }
        }
    }
}
