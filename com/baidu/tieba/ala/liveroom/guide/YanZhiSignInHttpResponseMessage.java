package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String hEB;
    private String hEC;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hEB = optJSONObject.optString("sign_status");
            this.hEC = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean cfP() {
        return !StringUtils.isNull(this.hEB) && this.hEB.equals("1");
    }

    public boolean cfQ() {
        return !StringUtils.isNull(this.hEC) && this.hEC.equals("1");
    }
}
