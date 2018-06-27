package com.baidu.tieba.channel.message;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.channel.data.c;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseChannelFansListMessage extends JsonHttpResponsedMessage {
    private c data;
    private int mErrCode;
    private String mErrMsg;

    public ResponseChannelFansListMessage(int i) {
        super(CmdConfigHttp.CMD_GET_CHANNEL_FANS_LIST);
        this.mErrCode = 0;
        this.mErrMsg = "";
    }

    public int getErrNo() {
        return this.mErrCode;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public c getData() {
        return this.data;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.mErrCode = jSONObject.optInt(WXLoginActivity.KEY_BASE_RESP_ERROR_CODE);
            this.mErrMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                this.data = new c();
                this.data.parserJson(optJSONObject);
            }
        }
    }
}
