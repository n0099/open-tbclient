package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String hEn;
    private String hEo;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hEn = optJSONObject.optString("sign_status");
            this.hEo = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean cfI() {
        return !StringUtils.isNull(this.hEn) && this.hEn.equals("1");
    }

    public boolean cfJ() {
        return !StringUtils.isNull(this.hEo) && this.hEo.equals("1");
    }
}
