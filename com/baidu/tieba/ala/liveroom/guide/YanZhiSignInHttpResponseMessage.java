package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String fHr;
    private String fHs;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fHr = optJSONObject.optString("sign_status");
            this.fHs = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bvW() {
        return !StringUtils.isNull(this.fHr) && this.fHr.equals("1");
    }

    public boolean bvX() {
        return !StringUtils.isNull(this.fHs) && this.fHs.equals("1");
    }
}
