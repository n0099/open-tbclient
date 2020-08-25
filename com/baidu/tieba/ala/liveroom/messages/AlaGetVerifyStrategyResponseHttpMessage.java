package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaGetVerifyStrategyResponseHttpMessage extends JsonHttpResponsedMessage {
    public int gEK;
    public String gEL;
    public int gEM;
    public String gEN;
    public int gEO;
    public int gEP;
    public String gEQ;
    public int gER;
    public String gES;
    public String gET;
    public int verifyType;

    public AlaGetVerifyStrategyResponseHttpMessage() {
        super(1003303);
        this.gEK = 0;
        this.gEM = 2;
        this.gEO = 0;
        this.verifyType = 0;
        this.gEP = 0;
        this.gER = 0;
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
                        this.gEK = optJSONObject3.optInt("switch");
                        this.gEL = optJSONObject3.optString("text");
                        String optString = optJSONObject3.optString("toast_content");
                        this.gET = optString;
                        if (!StringUtils.isNull(optString) && (split = optString.split("\\\\n")) != null && split.length == 2) {
                            this.gES = split[0];
                            this.gET = split[1];
                        }
                    }
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("certify");
                    if (optJSONObject4 != null) {
                        this.gEP = optJSONObject4.optInt("switch");
                        this.gEQ = optJSONObject4.optString("text");
                    }
                    JSONObject optJSONObject5 = optJSONObject2.optJSONObject("user_verify");
                    if (optJSONObject5 != null) {
                        this.gEM = optJSONObject5.optInt("switch");
                        this.gEO = optJSONObject5.optInt("in_testlist");
                        this.gEN = optJSONObject5.optString("text");
                        this.verifyType = optJSONObject5.optInt("type");
                    }
                }
                JSONObject optJSONObject6 = optJSONObject.optJSONObject("open_live_check");
                if (optJSONObject6 != null) {
                    this.gER = optJSONObject6.optInt("nickname_check");
                }
            }
        }
    }
}
