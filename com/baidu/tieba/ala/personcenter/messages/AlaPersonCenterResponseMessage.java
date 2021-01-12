package com.baidu.tieba.ala.personcenter.messages;

import com.baidu.android.util.io.BaseJsonData;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.personcenter.c.c;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class AlaPersonCenterResponseMessage extends JsonHttpResponsedMessage {
    private c data;
    private int errCode;
    private String errMsg;

    public int getErrCode() {
        return this.errCode;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public c getPersonCenterData() {
        return this.data;
    }

    public AlaPersonCenterResponseMessage(int i) {
        super(i);
        this.errCode = 0;
        this.errMsg = "";
        this.data = new c();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null) {
            this.errCode = jSONObject.optInt(BaseJsonData.TAG_ERRNO);
            this.errMsg = jSONObject.optString(BaseJsonData.TAG_ERRMSG);
            this.data.parseJson(jSONObject);
        }
    }
}
