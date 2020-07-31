package com.baidu.tieba.ala.live.message;

import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tieba.ala.live.walletconfig.CashierData;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class GetNuomiOrderHttpResponsedMessage extends JsonHttpResponsedMessage {
    private HashMap<String, String> fTU;
    private String orderId;

    public GetNuomiOrderHttpResponsedMessage() {
        super(1003411);
    }

    @Override // com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage
    public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
        super.decodeLogicInBackGround(i, jSONObject);
        if (jSONObject != null) {
            this.fTU = new HashMap<>();
            this.orderId = jSONObject.optString("tpOrderId");
            this.fTU.put("dealId", jSONObject.optString("dealId"));
            this.fTU.put("appKey", jSONObject.optString("appKey"));
            this.fTU.put("tpOrderId", jSONObject.optString("tpOrderId"));
            this.fTU.put("timestamp", jSONObject.optString("timestamp"));
            this.fTU.put("totalAmount", jSONObject.optString("totalAmount"));
            this.fTU.put(CashierData.RETURN_URL, jSONObject.optString(CashierData.RETURN_URL));
            this.fTU.put(TbEnum.SystemMessage.KEY_USER_ID, jSONObject.optString(TbEnum.SystemMessage.KEY_USER_ID));
            this.fTU.put(CashierData.NOTIFY_URL, jSONObject.optString(CashierData.NOTIFY_URL));
            this.fTU.put("dealTitle", jSONObject.optString("dealTitle"));
            this.fTU.put("returnData", jSONObject.optString("returnData"));
            this.fTU.put("nativeAppId", jSONObject.optString("nativeAppId"));
            this.fTU.put("channel", jSONObject.optString("channel"));
            this.fTU.put(CashierData.DEVICE_TYPE, jSONObject.optString(CashierData.DEVICE_TYPE));
            this.fTU.put("rsaSign", jSONObject.optString("rsaSign"));
            this.fTU.put("bizInfo", jSONObject.optString("bizInfo"));
        }
    }

    public HashMap<String, String> bBO() {
        return this.fTU;
    }

    public String getOrderId() {
        return this.orderId;
    }
}
