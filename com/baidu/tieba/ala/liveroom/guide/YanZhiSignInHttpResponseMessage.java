package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String hsO;
    private String hsP;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hsO = optJSONObject.optString("sign_status");
            this.hsP = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean cfQ() {
        return !StringUtils.isNull(this.hsO) && this.hsO.equals("1");
    }

    public boolean cfR() {
        return !StringUtils.isNull(this.hsP) && this.hsP.equals("1");
    }
}
