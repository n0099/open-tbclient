package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String gnx;
    private String gny;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gnx = optJSONObject.optString("sign_status");
            this.gny = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bIl() {
        return !StringUtils.isNull(this.gnx) && this.gnx.equals("1");
    }

    public boolean bIm() {
        return !StringUtils.isNull(this.gny) && this.gny.equals("1");
    }
}
