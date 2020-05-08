package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String fHw;
    private String fHx;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fHw = optJSONObject.optString("sign_status");
            this.fHx = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bvU() {
        return !StringUtils.isNull(this.fHw) && this.fHw.equals("1");
    }

    public boolean bvV() {
        return !StringUtils.isNull(this.fHx) && this.fHx.equals("1");
    }
}
