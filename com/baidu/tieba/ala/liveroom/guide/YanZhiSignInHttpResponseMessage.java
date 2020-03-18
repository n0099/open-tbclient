package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String fdi;
    private String fdj;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.fdi = optJSONObject.optString("sign_status");
            this.fdj = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bmF() {
        return !StringUtils.isNull(this.fdi) && this.fdi.equals("1");
    }

    public boolean bmG() {
        return !StringUtils.isNull(this.fdj) && this.fdj.equals("1");
    }
}
