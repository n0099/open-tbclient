package com.baidu.tieba.frs.ecomm;

import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class EcommCanSendThreadResponseMessage extends JsonHttpResponsedMessage {
    public String address;
    public String resultString;
    public int sellerStatus;

    public EcommCanSendThreadResponseMessage(int i) {
        super(i);
        this.sellerStatus = -1;
    }

    @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) {
        int statusCode = getStatusCode();
        int error = getError();
        if (statusCode == 200 && error == 0 && jSONObject != null) {
            this.resultString = jSONObject.toString();
            if (jSONObject.has("seller")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("seller");
                this.sellerStatus = optJSONObject.optInt("status");
                this.address = optJSONObject.optString("address_text", "");
            }
        }
    }
}
