package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String eZj;
    private String eZk;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.eZj = optJSONObject.optString("sign_status");
            this.eZk = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bkN() {
        return !StringUtils.isNull(this.eZj) && this.eZj.equals("1");
    }

    public boolean bkO() {
        return !StringUtils.isNull(this.eZk) && this.eZk.equals("1");
    }
}
