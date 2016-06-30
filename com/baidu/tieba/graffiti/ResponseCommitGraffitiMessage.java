package com.baidu.tieba.graffiti;

import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.u;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ResponseCommitGraffitiMessage extends JsonHttpResponsedMessage {
    private boolean isNeedVcode;
    private int mErrCode;
    private String mErrMsg;
    private com.baidu.tbadk.core.data.w mGraffitiInfo;
    private p vCodeData;

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

    public p getVCodeData() {
        return this.vCodeData;
    }

    public boolean isNeedVcode() {
        return this.isNeedVcode;
    }

    public com.baidu.tbadk.core.data.w getGraffitiInfo() {
        return this.mGraffitiInfo;
    }

    public ResponseCommitGraffitiMessage(int i) {
        super(i);
        this.mErrCode = -1;
        this.isNeedVcode = false;
        this.mErrMsg = TbadkCoreApplication.m9getInst().getResources().getString(u.j.graffiti_upload_fail);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        JSONObject optJSONObject;
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null) {
            try {
                this.mErrCode = jSONObject.optInt(SocialConstants.PARAM_ERROR_CODE);
                this.mErrMsg = jSONObject.optString(SocialConstants.PARAM_ERROR_MSG);
                JSONObject optJSONObject2 = jSONObject.optJSONObject(LoginActivityConfig.INFO);
                if (optJSONObject2 != null) {
                    this.isNeedVcode = optJSONObject2.optInt("need_vcode", 0) == 1;
                    if (this.isNeedVcode) {
                        this.vCodeData = new p();
                        this.vCodeData.parserJson(optJSONObject2);
                    }
                }
                if (!this.isNeedVcode && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                    this.mGraffitiInfo = new com.baidu.tbadk.core.data.w();
                    this.mGraffitiInfo.parserJson(optJSONObject);
                    this.mGraffitiInfo.setType(1);
                    long c = com.baidu.adp.lib.h.b.c(TbadkCoreApplication.getCurrentAccount(), -1L);
                    if (!this.mGraffitiInfo.pi() || c != this.mGraffitiInfo.getUid()) {
                        setError(-3);
                        setErrCode(-3);
                        setErrorString(this.mErrMsg);
                        setErrMsg(this.mErrMsg);
                        this.mGraffitiInfo = null;
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
