package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> eKV;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.eKV = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.eKV.put("dealId", jSONObject.optString("dealId"));
            this.eKV.put("appKey", jSONObject.optString("appKey"));
            this.eKV.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.eKV.put("timestamp", jSONObject.optString("timestamp"));
            this.eKV.put("totalAmount", jSONObject.optString("totalAmount"));
            this.eKV.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.eKV.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.eKV.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.eKV.put("dealTitle", jSONObject.optString("dealTitle"));
            this.eKV.put("returnData", jSONObject.optString("returnData"));
            this.eKV.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.eKV.put("channel", jSONObject.optString("channel"));
            this.eKV.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.eKV.put("rsaSign", jSONObject.optString("rsaSign"));
            this.eKV.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bgv() {
        return this.eKV;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
