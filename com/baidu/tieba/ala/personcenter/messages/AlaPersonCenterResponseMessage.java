package com.baidu.tieba.ala.personcenter.messages;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.personcenter.c.b;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaPersonCenterResponseMessage extends JsonHttpResponsedMessage {
    private b data;
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

    public b getPersonCenterData() {
        return this.data;
    }

    public AlaPersonCenterResponseMessage(int i) {
        super(i);
        this.errCode = 0;
        this.errMsg = "";
        this.data = new b();
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error >= 0 && jSONObject != null) {
            this.errCode = jSONObject.optInt("errno");
            this.errMsg = jSONObject.optString("errmsg");
            this.data.parseJson(jSONObject);
        }
    }
}
