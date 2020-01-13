package com.baidu.tbadk.pay;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ResponseGetPayinfoMessage extends JsonHttpResponsedMessage {
    public String logid;
    private PayInfoResultData mPayInfoResultData;

    public ResponseGetPayinfoMessage(int i) {
        super(i);
    }

    public PayInfoResultData getPayInfoResultData() {
        return this.mPayInfoResultData;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (getStatusCode() == 200 && jSONObject != null) {
            this.mPayInfoResultData = (PayInfoResultData) OrmObject.objectWithJsonStr(jSONObject.toString(), PayInfoResultData.class);
            this.logid = jSONObject.optString("logid");
        }
    }
}
