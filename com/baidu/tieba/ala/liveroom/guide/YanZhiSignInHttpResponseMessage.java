package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String fcx;
    private String fcy;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fcx = optJSONObject.optString("sign_status");
            this.fcy = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bmz() {
        return !StringUtils.isNull(this.fcx) && this.fcx.equals("1");
    }

    public boolean bmA() {
        return !StringUtils.isNull(this.fcy) && this.fcy.equals("1");
    }
}
