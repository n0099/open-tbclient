package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> hjJ;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.hjJ = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.hjJ.put("dealId", jSONObject.optString("dealId"));
            this.hjJ.put("appKey", jSONObject.optString("appKey"));
            this.hjJ.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.hjJ.put("timestamp", jSONObject.optString("timestamp"));
            this.hjJ.put("totalAmount", jSONObject.optString("totalAmount"));
            this.hjJ.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.hjJ.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.hjJ.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.hjJ.put("dealTitle", jSONObject.optString("dealTitle"));
            this.hjJ.put("returnData", jSONObject.optString("returnData"));
            this.hjJ.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.hjJ.put("channel", jSONObject.optString("channel"));
            this.hjJ.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.hjJ.put("rsaSign", jSONObject.optString("rsaSign"));
            this.hjJ.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bYe() {
        return this.hjJ;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
