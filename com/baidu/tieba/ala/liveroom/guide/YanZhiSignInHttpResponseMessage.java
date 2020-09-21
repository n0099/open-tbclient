package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String gDG;
    private String gDH;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gDG = optJSONObject.optString("sign_status");
            this.gDH = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bTK() {
        return !StringUtils.isNull(this.gDG) && this.gDG.equals("1");
    }

    public boolean bTL() {
        return !StringUtils.isNull(this.gDH) && this.gDH.equals("1");
    }
}
