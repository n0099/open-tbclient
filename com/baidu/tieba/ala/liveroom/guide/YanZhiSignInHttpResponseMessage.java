package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String hjI;
    private String hjJ;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.hjI = optJSONObject.optString("sign_status");
            this.hjJ = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean ccE() {
        return !StringUtils.isNull(this.hjI) && this.hjI.equals("1");
    }

    public boolean ccF() {
        return !StringUtils.isNull(this.hjJ) && this.hjJ.equals("1");
    }
}
