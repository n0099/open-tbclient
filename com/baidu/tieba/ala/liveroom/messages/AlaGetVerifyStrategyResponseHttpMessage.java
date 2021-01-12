package com.baidu.tieba.ala.liveroom.messages;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaGetVerifyStrategyResponseHttpMessage extends JsonHttpResponsedMessage {
    public int hEY;
    public String hEZ;
    public int hFa;
    public String hFb;
    public int hFc;
    public int hFd;
    public String hFe;
    public int hFf;
    public String hFg;
    public String hFh;
    public int verifyType;

    public AlaGetVerifyStrategyResponseHttpMessage() {
        super(1003303);
        this.hEY = 0;
        this.hFa = 2;
        this.hFc = 0;
        this.verifyType = 0;
        this.hFd = 0;
        this.hFf = 0;
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
                        this.hEY = optJSONObject3.optInt("switch");
                        this.hEZ = optJSONObject3.optString("text");
                        String optString = optJSONObject3.optString("toast_content");
                        this.hFh = optString;
                        if (!StringUtils.isNull(optString) && (split = optString.split("\\\\n")) != null) {
                            if (split.length == 2) {
                                this.hFg = split[0];
                                this.hFh = split[1];
                            } else if (split.length == 1) {
                                this.hFh = split[0];
                            }
                        }
                    }
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("certify");
                    if (optJSONObject4 != null) {
                        this.hFd = optJSONObject4.optInt("switch");
                        this.hFe = optJSONObject4.optString("text");
                    }
                    JSONObject optJSONObject5 = optJSONObject2.optJSONObject("user_verify");
                    if (optJSONObject5 != null) {
                        this.hFa = optJSONObject5.optInt("switch");
                        this.hFc = optJSONObject5.optInt("in_testlist");
                        this.hFb = optJSONObject5.optString("text");
                        this.verifyType = optJSONObject5.optInt("type");
                    }
                }
                JSONObject optJSONObject6 = optJSONObject.optJSONObject("open_live_check");
                if (optJSONObject6 != null) {
                    this.hFf = optJSONObject6.optInt("nickname_check");
                }
            }
        }
    }
}
