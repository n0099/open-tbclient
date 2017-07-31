package com.baidu.tieba.graffiti;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.d;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseVoteGraffitiMessage extends JsonHttpResponsedMessage {
    private int mErrCode;
    private String mErrMsg;

    public int getErrCode() {
        return this.mErrCode;
    }

    public void setErrCode(int i) {
        this.mErrCode = i;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public void setErrMsg(String str) {
        this.mErrMsg = str;
    }

    public ResponseVoteGraffitiMessage(int i) {
        super(i);
        this.mErrCode = -1;
        this.mErrMsg = TbadkCoreApplication.getInst().getResources().getString(d.l.tb_err_unknown);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null) {
            try {
                this.mErrCode = jSONObject.optInt("error_code");
                this.mErrMsg = jSONObject.optString(PushConstants.EXTRA_ERROR_CODE);
            } catch (Exception e) {
            }
        }
    }
}
