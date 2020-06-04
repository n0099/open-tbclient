package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaGetVerifyStrategyResponseHttpMessage extends JsonHttpResponsedMessage {
    public int fZT;
    public String fZU;
    public int fZV;
    public String fZW;
    public int fZX;
    public int fZY;
    public String fZZ;
    public int gaa;
    public int verifyType;

    public AlaGetVerifyStrategyResponseHttpMessage() {
        super(1003303);
        this.fZT = 0;
        this.fZV = 2;
        this.fZX = 0;
        this.verifyType = 0;
        this.fZY = 0;
        this.gaa = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(UbcStatConstant.ContentType.UBC_TYPE_STRATEGY);
                if (optJSONObject2 != null) {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject(LogConfig.VALUE_LIVE_HK_RECORD_START);
                    if (optJSONObject3 != null) {
                        this.fZT = optJSONObject3.optInt("switch");
                        this.fZU = optJSONObject3.optString("text");
                    }
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("certify");
                    if (optJSONObject4 != null) {
                        this.fZY = optJSONObject4.optInt("switch");
                        this.fZZ = optJSONObject4.optString("text");
                    }
                    JSONObject optJSONObject5 = optJSONObject2.optJSONObject("user_verify");
                    if (optJSONObject5 != null) {
                        this.fZV = optJSONObject5.optInt("switch");
                        this.fZX = optJSONObject5.optInt("in_testlist");
                        this.fZW = optJSONObject5.optString("text");
                        this.verifyType = optJSONObject5.optInt("type");
                    }
                }
                JSONObject optJSONObject6 = optJSONObject.optJSONObject("open_live_check");
                if (optJSONObject6 != null) {
                    this.gaa = optJSONObject6.optInt("nickname_check");
                }
            }
        }
    }
}
