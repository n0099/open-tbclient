package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String hAd;
    private String hAe;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hAd = optJSONObject.optString("sign_status");
            this.hAe = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean ceP() {
        return !StringUtils.isNull(this.hAd) && this.hAd.equals("1");
    }

    public boolean ceQ() {
        return !StringUtils.isNull(this.hAe) && this.hAe.equals("1");
    }
}
