package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String gAr;
    private String gAs;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gAr = optJSONObject.optString("sign_status");
            this.gAs = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bSn() {
        return !StringUtils.isNull(this.gAr) && this.gAr.equals("1");
    }

    public boolean bSo() {
        return !StringUtils.isNull(this.gAs) && this.gAs.equals("1");
    }
}
