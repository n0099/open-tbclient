package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String fVC;
    private String fVD;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fVC = optJSONObject.optString("sign_status");
            this.fVD = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bBV() {
        return !StringUtils.isNull(this.fVC) && this.fVC.equals("1");
    }

    public boolean bBW() {
        return !StringUtils.isNull(this.fVD) && this.fVD.equals("1");
    }
}
