package com.baidu.tieba.channel.message;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.channel.data.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseNetChannelListMessage extends JsonHttpResponsedMessage {
    private e data;
    private int mErrCode;
    private String mErrMsg;

    public ResponseNetChannelListMessage(int i) {
        super(CmdConfigHttp.CMD_GET_SUBSCRIBE_CHANNEL_LIST);
        this.mErrCode = 0;
        this.mErrMsg = "";
    }

    public int getErrNo() {
        return this.mErrCode;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public e getData() {
        return this.data;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mErrCode = jSONObject.optInt("error_code");
            this.mErrMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.data = new e();
                this.data.parserJson(optJSONObject);
            }
        }
    }
}
