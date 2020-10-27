package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetVerifyStrategyResponseHttpMessage extends JsonHttpResponsedMessage {
    public int hiC;
    public String hiD;
    public int hiE;
    public String hiF;
    public int hiG;
    public int hiH;
    public String hiI;
    public int hiJ;
    public String hiK;
    public String hiL;
    public int verifyType;

    public AlaGetVerifyStrategyResponseHttpMessage() {
        super(1003303);
        this.hiC = 0;
        this.hiE = 2;
        this.hiG = 0;
        this.verifyType = 0;
        this.hiH = 0;
        this.hiJ = 0;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        String[] split;
        if (jSONObject != null) {
            super.decodeLogicInBackGround(i, jSONObject);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(UbcStatConstant.ContentType.UBC_TYPE_STRATEGY);
                if (optJSONObject2 != null) {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject(LogConfig.VALUE_LIVE_HK_RECORD_START);
                    if (optJSONObject3 != null) {
                        this.hiC = optJSONObject3.optInt("switch");
                        this.hiD = optJSONObject3.optString("text");
                        String optString = optJSONObject3.optString("toast_content");
                        this.hiL = optString;
                        if (!StringUtils.isNull(optString) && (split = optString.split("\\\\n")) != null) {
                            if (split.length == 2) {
                                this.hiK = split[0];
                                this.hiL = split[1];
                            } else if (split.length == 1) {
                                this.hiL = split[0];
                            }
                        }
                    }
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("certify");
                    if (optJSONObject4 != null) {
                        this.hiH = optJSONObject4.optInt("switch");
                        this.hiI = optJSONObject4.optString("text");
                    }
                    JSONObject optJSONObject5 = optJSONObject2.optJSONObject("user_verify");
                    if (optJSONObject5 != null) {
                        this.hiE = optJSONObject5.optInt("switch");
                        this.hiG = optJSONObject5.optInt("in_testlist");
                        this.hiF = optJSONObject5.optString("text");
                        this.verifyType = optJSONObject5.optInt("type");
                    }
                }
                JSONObject optJSONObject6 = optJSONObject.optJSONObject("open_live_check");
                if (optJSONObject6 != null) {
                    this.hiJ = optJSONObject6.optInt("nickname_check");
                }
            }
        }
    }
}
