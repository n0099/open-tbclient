package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String eWJ;
    private String eWK;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eWJ = optJSONObject.optString("sign_status");
            this.eWK = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bjR() {
        return !StringUtils.isNull(this.eWJ) && this.eWJ.equals("1");
    }

    public boolean bjS() {
        return !StringUtils.isNull(this.eWK) && this.eWK.equals("1");
    }
}
