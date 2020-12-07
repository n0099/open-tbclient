package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGetVerifyStrategyResponseHttpMessage extends JsonHttpResponsedMessage {
    public int hxE;
    public String hxF;
    public int hxG;
    public String hxH;
    public int hxI;
    public int hxJ;
    public String hxK;
    public int hxL;
    public String hxM;
    public String hxN;
    public int verifyType;

    public AlaGetVerifyStrategyResponseHttpMessage() {
        super(1003303);
        this.hxE = 0;
        this.hxG = 2;
        this.hxI = 0;
        this.verifyType = 0;
        this.hxJ = 0;
        this.hxL = 0;
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
                        this.hxE = optJSONObject3.optInt("switch");
                        this.hxF = optJSONObject3.optString("text");
                        String optString = optJSONObject3.optString("toast_content");
                        this.hxN = optString;
                        if (!StringUtils.isNull(optString) && (split = optString.split("\\\\n")) != null) {
                            if (split.length == 2) {
                                this.hxM = split[0];
                                this.hxN = split[1];
                            } else if (split.length == 1) {
                                this.hxN = split[0];
                            }
                        }
                    }
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("certify");
                    if (optJSONObject4 != null) {
                        this.hxJ = optJSONObject4.optInt("switch");
                        this.hxK = optJSONObject4.optString("text");
                    }
                    JSONObject optJSONObject5 = optJSONObject2.optJSONObject("user_verify");
                    if (optJSONObject5 != null) {
                        this.hxG = optJSONObject5.optInt("switch");
                        this.hxI = optJSONObject5.optInt("in_testlist");
                        this.hxH = optJSONObject5.optString("text");
                        this.verifyType = optJSONObject5.optInt("type");
                    }
                }
                JSONObject optJSONObject6 = optJSONObject.optJSONObject("open_live_check");
                if (optJSONObject6 != null) {
                    this.hxL = optJSONObject6.optInt("nickname_check");
                }
            }
        }
    }
}
