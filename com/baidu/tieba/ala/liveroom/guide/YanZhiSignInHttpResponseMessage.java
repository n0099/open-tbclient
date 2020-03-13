package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String fcK;
    private String fcL;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fcK = optJSONObject.optString("sign_status");
            this.fcL = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bmA() {
        return !StringUtils.isNull(this.fcK) && this.fcK.equals("1");
    }

    public boolean bmB() {
        return !StringUtils.isNull(this.fcL) && this.fcL.equals("1");
    }
}
