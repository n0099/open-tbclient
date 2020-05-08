package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> fpt;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.fpt = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.fpt.put("dealId", jSONObject.optString("dealId"));
            this.fpt.put("appKey", jSONObject.optString("appKey"));
            this.fpt.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.fpt.put("timestamp", jSONObject.optString("timestamp"));
            this.fpt.put("totalAmount", jSONObject.optString("totalAmount"));
            this.fpt.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.fpt.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.fpt.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.fpt.put("dealTitle", jSONObject.optString("dealTitle"));
            this.fpt.put("returnData", jSONObject.optString("returnData"));
            this.fpt.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.fpt.put("channel", jSONObject.optString("channel"));
            this.fpt.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.fpt.put("rsaSign", jSONObject.optString("rsaSign"));
            this.fpt.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bpK() {
        return this.fpt;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
