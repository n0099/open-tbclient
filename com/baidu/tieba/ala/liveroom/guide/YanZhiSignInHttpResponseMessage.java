package com.baidu.tieba.ala.liveroom.guide;

import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class YanZhiSignInHttpResponseMessage extends JsonHttpResponsedMessage {
    private String gRZ;
    private String gSa;

    public YanZhiSignInHttpResponseMessage() {
        super(1021153);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        JSONObject optJSONObject;
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null && jSONObject.optJSONObject("data") != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
            this.gRZ = optJSONObject.optString("sign_status");
            this.gSa = optJSONObject.optString("visit_yanzhi_tab");
        }
    }

    public boolean bXd() {
        return !StringUtils.isNull(this.gRZ) && this.gRZ.equals("1");
    }

    public boolean bXe() {
        return !StringUtils.isNull(this.gSa) && this.gSa.equals("1");
    }
}
