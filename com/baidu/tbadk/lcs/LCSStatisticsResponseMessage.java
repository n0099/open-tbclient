package com.baidu.tbadk.lcs;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LCSStatisticsResponseMessage extends JsonHttpResponsedMessage {
    public LCSStatisticsResponseMessage(int i2) {
        super(i2);
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
        if (jSONObject != null) {
            jSONObject.toString();
        }
    }
}
