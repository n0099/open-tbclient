package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String hdM;
    private String hdN;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hdM = optJSONObject.optString("sign_status");
            this.hdN = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean cac() {
        return !StringUtils.isNull(this.hdM) && this.hdM.equals("1");
    }

    public boolean cad() {
        return !StringUtils.isNull(this.hdN) && this.hdN.equals("1");
    }
}
