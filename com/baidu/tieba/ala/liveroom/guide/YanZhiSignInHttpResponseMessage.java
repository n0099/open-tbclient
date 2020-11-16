package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String hjp;
    private String hjq;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hjp = optJSONObject.optString("sign_status");
            this.hjq = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean cbX() {
        return !StringUtils.isNull(this.hjp) && this.hjp.equals("1");
    }

    public boolean cbY() {
        return !StringUtils.isNull(this.hjq) && this.hjq.equals("1");
    }
}
