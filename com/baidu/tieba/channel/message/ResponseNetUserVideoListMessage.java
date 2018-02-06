package com.baidu.tieba.channel.message;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.channel.data.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseNetUserVideoListMessage extends JsonHttpResponsedMessage {
    private a data;
    private int mErrCode;
    private String mErrMsg;

    public ResponseNetUserVideoListMessage(int i) {
        super(CmdConfigHttp.CMD_GET_USER_VIDEO_LIST);
        this.mErrCode = 0;
        this.mErrMsg = "";
    }

    public int getErrNo() {
        return this.mErrCode;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public a getData() {
        return this.data;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mErrCode = jSONObject.optInt("error_code");
            this.mErrMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
            this.data = new a();
            this.data.parserJson(jSONObject);
        }
    }
}
