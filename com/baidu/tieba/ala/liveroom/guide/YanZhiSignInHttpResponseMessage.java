package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String fVr;
    private String fVs;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fVr = optJSONObject.optString("sign_status");
            this.fVs = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bBT() {
        return !StringUtils.isNull(this.fVr) && this.fVr.equals("1");
    }

    public boolean bBU() {
        return !StringUtils.isNull(this.fVs) && this.fVs.equals("1");
    }
}
