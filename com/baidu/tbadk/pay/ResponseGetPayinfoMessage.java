package com.baidu.tbadk.pay;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ResponseGetPayinfoMessage extends JsonHttpResponsedMessage {
    public String logid;
    public PayInfoResultData mPayInfoResultData;

    public ResponseGetPayinfoMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i2, jSONObject);
        if (getStatusCode() != 200 || jSONObject == null) {
            return;
        }
        this.mPayInfoResultData = (PayInfoResultData) OrmObject.objectWithJsonStr(jSONObject.toString(), PayInfoResultData.class);
        this.logid = jSONObject.optString("logid");
    }

    public PayInfoResultData getPayInfoResultData() {
        return this.mPayInfoResultData;
    }
}
