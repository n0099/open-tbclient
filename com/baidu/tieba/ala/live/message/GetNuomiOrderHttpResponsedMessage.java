package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> hjM;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.hjM = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.hjM.put("dealId", jSONObject.optString("dealId"));
            this.hjM.put("appKey", jSONObject.optString("appKey"));
            this.hjM.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.hjM.put("timestamp", jSONObject.optString("timestamp"));
            this.hjM.put("totalAmount", jSONObject.optString("totalAmount"));
            this.hjM.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.hjM.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.hjM.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.hjM.put("dealTitle", jSONObject.optString("dealTitle"));
            this.hjM.put("returnData", jSONObject.optString("returnData"));
            this.hjM.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.hjM.put("channel", jSONObject.optString("channel"));
            this.hjM.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.hjM.put("rsaSign", jSONObject.optString("rsaSign"));
            this.hjM.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> caO() {
        return this.hjM;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
