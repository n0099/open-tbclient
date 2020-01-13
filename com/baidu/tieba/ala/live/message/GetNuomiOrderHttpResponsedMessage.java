package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> eGr;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.eGr = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.eGr.put("dealId", jSONObject.optString("dealId"));
            this.eGr.put("appKey", jSONObject.optString("appKey"));
            this.eGr.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.eGr.put("timestamp", jSONObject.optString("timestamp"));
            this.eGr.put("totalAmount", jSONObject.optString("totalAmount"));
            this.eGr.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.eGr.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.eGr.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.eGr.put("dealTitle", jSONObject.optString("dealTitle"));
            this.eGr.put("returnData", jSONObject.optString("returnData"));
            this.eGr.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.eGr.put("channel", jSONObject.optString("channel"));
            this.eGr.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.eGr.put("rsaSign", jSONObject.optString("rsaSign"));
            this.eGr.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bed() {
        return this.eGr;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
