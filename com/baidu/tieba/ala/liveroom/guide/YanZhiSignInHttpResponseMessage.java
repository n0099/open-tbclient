package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String giA;
    private String giz;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.giz = optJSONObject.optString("sign_status");
            this.giA = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bFd() {
        return !StringUtils.isNull(this.giz) && this.giz.equals("1");
    }

    public boolean bFe() {
        return !StringUtils.isNull(this.giA) && this.giA.equals("1");
    }
}
