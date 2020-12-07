package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String hsM;
    private String hsN;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hsM = optJSONObject.optString("sign_status");
            this.hsN = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean cfP() {
        return !StringUtils.isNull(this.hsM) && this.hsM.equals("1");
    }

    public boolean cfQ() {
        return !StringUtils.isNull(this.hsN) && this.hsN.equals("1");
    }
}
