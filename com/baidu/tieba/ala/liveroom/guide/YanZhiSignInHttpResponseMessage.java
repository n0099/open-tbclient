package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String gAn;
    private String gAo;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gAn = optJSONObject.optString("sign_status");
            this.gAo = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bSm() {
        return !StringUtils.isNull(this.gAn) && this.gAn.equals("1");
    }

    public boolean bSn() {
        return !StringUtils.isNull(this.gAo) && this.gAo.equals("1");
    }
}
