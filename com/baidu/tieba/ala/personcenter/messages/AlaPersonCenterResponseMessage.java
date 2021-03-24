package com.baidu.tieba.ala.personcenter.messages;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import d.b.i0.t.j.d.c;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaPersonCenterResponseMessage extends JsonHttpResponsedMessage {
    public c data;
    public int errCode;
    public String errMsg;

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
        if (statusCode != 200 || error < 0 || jSONObject == null) {
            return;
        }
        this.errCode = jSONObject.optInt("errno");
        this.errMsg = jSONObject.optString("errmsg");
        this.data.d(jSONObject);
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public c getPersonCenterData() {
        return this.data;
    }

    public void setErrCode(int i) {
        this.errCode = i;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }
}
