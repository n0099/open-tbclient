package com.baidu.tieba.ala.live.personcenter.guardian;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaGuardianListHttpResponseMessage extends JsonHttpResponsedMessage {
    public d dSd;
    private int mErrCode;
    private String mErrMsg;

    public AlaGuardianListHttpResponseMessage() {
        super(1021024);
        this.mErrCode = 0;
        this.mErrMsg = "";
    }

    public d aMG() {
        return this.dSd;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            this.mErrCode = jSONObject.optInt("error_code");
            this.mErrMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
            this.dSd = new d();
            this.dSd.parserJson(jSONObject);
        }
    }
}
