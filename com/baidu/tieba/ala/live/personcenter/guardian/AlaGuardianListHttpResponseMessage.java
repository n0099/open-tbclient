package com.baidu.tieba.ala.live.personcenter.guardian;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaGuardianListHttpResponseMessage extends JsonHttpResponsedMessage {
    public c haB;
    private int mErrCode;
    private String mErrMsg;

    public AlaGuardianListHttpResponseMessage() {
        super(1021024);
        this.mErrCode = 0;
        this.mErrMsg = "";
    }

    public c bYM() {
        return this.haB;
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0) {
            this.mErrCode = jSONObject.optInt("error_code");
            this.mErrMsg = jSONObject.optString(AlaRecorderLog.KEY_ERROR_MSG);
            this.haB = new c();
            this.haB.parserJson(jSONObject);
        }
    }
}
