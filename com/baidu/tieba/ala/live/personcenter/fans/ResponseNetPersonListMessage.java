package com.baidu.tieba.ala.live.personcenter.fans;

import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class ResponseNetPersonListMessage extends JsonHttpResponsedMessage {
    private e hgV;
    private int mErrCode;
    private String mErrMsg;

    public ResponseNetPersonListMessage(int i) {
        super(1002004);
        this.mErrCode = 0;
        this.mErrMsg = "";
    }

    public e bXv() {
        return this.hgV;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            this.mErrCode = jSONObject.optInt("error_code");
            this.mErrMsg = jSONObject.optString("error_msg");
            this.hgV = new e();
            this.hgV.parserJson(jSONObject);
        }
    }
}
