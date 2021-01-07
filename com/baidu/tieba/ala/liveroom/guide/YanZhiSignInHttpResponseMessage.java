package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String hEJ;
    private String hEK;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hEJ = optJSONObject.optString("sign_status");
            this.hEK = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean ciH() {
        return !StringUtils.isNull(this.hEJ) && this.hEJ.equals("1");
    }

    public boolean ciI() {
        return !StringUtils.isNull(this.hEK) && this.hEK.equals("1");
    }
}
