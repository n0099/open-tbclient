package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> eKm;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.eKm = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.eKm.put("dealId", jSONObject.optString("dealId"));
            this.eKm.put("appKey", jSONObject.optString("appKey"));
            this.eKm.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.eKm.put("timestamp", jSONObject.optString("timestamp"));
            this.eKm.put("totalAmount", jSONObject.optString("totalAmount"));
            this.eKm.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.eKm.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.eKm.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.eKm.put("dealTitle", jSONObject.optString("dealTitle"));
            this.eKm.put("returnData", jSONObject.optString("returnData"));
            this.eKm.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.eKm.put("channel", jSONObject.optString("channel"));
            this.eKm.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.eKm.put("rsaSign", jSONObject.optString("rsaSign"));
            this.eKm.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bgp() {
        return this.eKm;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
