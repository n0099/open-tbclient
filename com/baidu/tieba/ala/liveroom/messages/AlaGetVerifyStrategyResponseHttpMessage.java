package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetVerifyStrategyResponseHttpMessage extends JsonHttpResponsedMessage {
    public int hoA;
    public String hoB;
    public String hoC;
    public int hot;
    public String hou;
    public int hov;
    public String how;
    public int hox;
    public int hoy;
    public String hoz;
    public int verifyType;

    public AlaGetVerifyStrategyResponseHttpMessage() {
        super(1003303);
        this.hot = 0;
        this.hov = 2;
        this.hox = 0;
        this.verifyType = 0;
        this.hoy = 0;
        this.hoA = 0;
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
                        this.hot = optJSONObject3.optInt("switch");
                        this.hou = optJSONObject3.optString("text");
                        String optString = optJSONObject3.optString("toast_content");
                        this.hoC = optString;
                        if (!StringUtils.isNull(optString) && (split = optString.split("\\\\n")) != null) {
                            if (split.length == 2) {
                                this.hoB = split[0];
                                this.hoC = split[1];
                            } else if (split.length == 1) {
                                this.hoC = split[0];
                            }
                        }
                    }
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("certify");
                    if (optJSONObject4 != null) {
                        this.hoy = optJSONObject4.optInt("switch");
                        this.hoz = optJSONObject4.optString("text");
                    }
                    JSONObject optJSONObject5 = optJSONObject2.optJSONObject("user_verify");
                    if (optJSONObject5 != null) {
                        this.hov = optJSONObject5.optInt("switch");
                        this.hox = optJSONObject5.optInt("in_testlist");
                        this.how = optJSONObject5.optString("text");
                        this.verifyType = optJSONObject5.optInt("type");
                    }
                }
                JSONObject optJSONObject6 = optJSONObject.optJSONObject("open_live_check");
                if (optJSONObject6 != null) {
                    this.hoA = optJSONObject6.optInt("nickname_check");
                }
            }
        }
    }
}
